package views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import database.dao.AlunosDAO;
import database.dao.CidadesDAO;
import database.model.Alunos;
import database.model.Cidades;
import database.model.Usuarios;

public class AlunoWindow extends JInternalFrame {

	// componentes
	private JTextField txfNomeAluno;
	private JLabel lblNomeAluno;
	private JTextField txfCode;
	private JLabel lblCode;
	private JFormattedTextField txfDataNasc;
	private JLabel lblDataNasc;
	private JLabel lblSexo;
	private JTextField txfEndereco;
	private JLabel lblEndereco;
	private JFormattedTextField txfNumeroCasa;
	private JLabel lblNumeroCasa;
	private JTextField txfComplemento;
	private JLabel lblComplemento;
	private JLabel lblCidade;
	private JTextField txfBairro;
	private JLabel lblBairro;
	private JLabel lblUF;
	private JFormattedTextField txfCEP;
	private JLabel lblCEP;
	private JTextField txfPais;
	private JLabel lblPais;
	private JFormattedTextField txfTelefone;
	private JLabel lblTelefone;
	private JFormattedTextField txfCelular;
	private JLabel lblCelular;
	private JTextField txfEmail;
	private JLabel lblEmail;
	private JTextArea txfObservacao;
	private JLabel lblObservacao;
	private JComboBox cbxCidades;
	private JComboBox cbxUF;
	private JButton btnSalvar;
	private JButton btnExcluir;
	private JButton btnConsultar;
	private JPanel painel1;
	private JRadioButton rbtMasculino;
	private JRadioButton rbtFeminino;
	String[] uf = {"AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO", };
	
	List<Cidades> cidades;

	private final int widthPadraoLabel = 75;
	private final int xPadraoLabel = 15;
	private final int widthPadraoCampo = 350;
	private final int xPadraoCampo = 95;
	private final int diferencaCampos = 28;
	
	private boolean consultar = false;
	
	MaskFormatter formatData;
	
	public AlunoWindow() {

		// Define o tamanho da janela.
		setSize(500, 500);

		// Define o titulo da janela.
		setTitle("Cadastro de Aluno");

		// Seta o layout a ser utilizado (NULL significa que não irá utilizar nenhum).
		setLayout(null);

		// Define que não poderá ser alterado as dimensões da tela.
		setResizable(false);

		// Define o método de fechamento da janela.
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBackground(Color.black);
		setClosable(true);
		setIconifiable(true);
		// Cria os componentes.
		criarComponentes();

	}
	
	public MaskFormatter maskFormatter(String format) throws ParseException {
		return (new MaskFormatter(format));
	}

	private void criarComponentes() {

		// codigo
		lblCode = new JLabel("Código:", JLabel.RIGHT);
		lblCode.setBounds(xPadraoLabel, diferencaCampos, widthPadraoLabel, 25);
		getContentPane().add(lblCode);

		txfCode = new JTextField();
		txfCode.setEnabled(false);
		txfCode.setBounds(xPadraoCampo, diferencaCampos, 100, 25);
		getContentPane().add(txfCode);

		// nome
		lblNomeAluno = new JLabel("Nome:", JLabel.RIGHT);
		lblNomeAluno.setBounds(xPadraoLabel, diferencaCampos * 2, widthPadraoLabel, 25);
		getContentPane().add(lblNomeAluno);

		txfNomeAluno = new JTextField();
		txfNomeAluno.setBounds(xPadraoCampo, diferencaCampos * 2, widthPadraoCampo, 25);
		getContentPane().add(txfNomeAluno);

		// data nascimento
		lblDataNasc = new JLabel("Nascimento:", JLabel.RIGHT);
		lblDataNasc.setBounds(xPadraoLabel, diferencaCampos * 3, widthPadraoLabel, 25);
		getContentPane().add(lblDataNasc);

		
		try {
			txfDataNasc = new  JFormattedTextField(maskFormatter("##/##/####"));
			txfDataNasc.setBounds(xPadraoCampo, diferencaCampos * 3, 150, 25);
			getContentPane().add(txfDataNasc);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		// sexo
		lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(250, diferencaCampos * 3, widthPadraoLabel, 25);
		getContentPane().add(lblSexo);

		rbtMasculino = new JRadioButton("Masculino");
		rbtMasculino.setSelected(true);
		rbtMasculino.setBounds(285, diferencaCampos * 3, 85, 25);
		rbtMasculino.setBackground(Color.decode("#DEDEDE"));
		getContentPane().add(rbtMasculino);

		rbtFeminino = new JRadioButton("Feminino");
		rbtFeminino.setSelected(false);
		rbtFeminino.setBounds(370, diferencaCampos * 3, 100, 25);
		rbtFeminino.setBackground(Color.decode("#DEDEDE"));
		getContentPane().add(rbtFeminino);

		ButtonGroup group = new ButtonGroup();
		group.add(rbtMasculino);
		group.add(rbtFeminino);
		
		//endereço
		lblEndereco = new JLabel("Endereço:", JLabel.RIGHT);
		lblEndereco.setBounds(xPadraoLabel, diferencaCampos * 4,widthPadraoLabel, 25);
		getContentPane().add(lblEndereco);
		
		txfEndereco = new JTextField();
		txfEndereco.setBounds(xPadraoCampo, diferencaCampos * 4,350,25);
		getContentPane().add(txfEndereco);
//		
		//numero casa
		lblNumeroCasa = new JLabel("Número:", JLabel.RIGHT);
		lblNumeroCasa.setBounds(xPadraoLabel, diferencaCampos * 5,widthPadraoLabel, 25);
		getContentPane().add(lblNumeroCasa);
		
		try {
			txfNumeroCasa = new  JFormattedTextField(maskFormatter("######"));
			txfNumeroCasa.setBounds(xPadraoCampo, diferencaCampos * 5,50,25);
			getContentPane().add(txfNumeroCasa);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//complemento
		lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(150, diferencaCampos * 5,150, 25);
		getContentPane().add(lblComplemento);
			
		txfComplemento = new JTextField();
		txfComplemento.setBounds(240, diferencaCampos * 5,205,25);
		getContentPane().add(txfComplemento);			
		
		//UF
		lblUF = new JLabel("UF:", JLabel.RIGHT);
		lblUF.setBounds(xPadraoLabel, diferencaCampos * 6,widthPadraoLabel, 25);		
		getContentPane().add(lblUF);
		
		cbxUF = new JComboBox(uf);
		cbxUF.setSelectedIndex(1);
		cbxUF.setBounds(xPadraoCampo, diferencaCampos * 6,50,25);
		cbxUF.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				popularComboBox();
				
			}
		});
		getContentPane().add(cbxUF);
				
		//Cidade
		lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(150, diferencaCampos * 6, widthPadraoLabel, 25);
		getContentPane().add(lblCidade);
		
		cbxCidades = new JComboBox();
		cbxCidades.setBounds(200, diferencaCampos * 6,245,25);	
		cbxCidades.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (cbxCidades.getItemCount() == 0) return;
				
				Cidades cidade = (Cidades) cbxCidades.getSelectedItem();
				txfPais.setText(cidade.getPais()); 
				
			}
		});
		getContentPane().add(cbxCidades);
		
		//País
		lblPais = new JLabel("País:", JLabel.RIGHT);
		lblPais.setBounds(xPadraoLabel, diferencaCampos * 7,widthPadraoLabel, 25);
		getContentPane().add(lblPais);
				
		txfPais = new JTextField();
		txfPais.setEditable(false);
		txfPais.setBounds(xPadraoCampo, diferencaCampos * 7,350,25);
		getContentPane().add(txfPais);
		
		//CEP
		lblCEP = new JLabel("CEP:", JLabel.RIGHT);
		lblCEP.setBounds(xPadraoLabel, diferencaCampos * 8,widthPadraoLabel, 25);
		getContentPane().add(lblCEP);
				
		try {
			txfCEP = new  JFormattedTextField(maskFormatter("#####-###"));
			txfCEP.setBounds(xPadraoCampo, diferencaCampos * 8,150,25);
			getContentPane().add(txfCEP);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//bairro
		lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(250, diferencaCampos * 8,150,25);
		getContentPane().add(lblBairro);
				
		txfBairro = new JTextField();
		txfBairro.setBounds(295, diferencaCampos * 8,150,25);
		getContentPane().add(txfBairro);
						
		//Telefone
		lblTelefone = new JLabel("Telefone:", JLabel.RIGHT);
		lblTelefone.setBounds(xPadraoLabel, diferencaCampos * 9,widthPadraoLabel, 25);
		getContentPane().add(lblTelefone);
						
		try {
			txfTelefone = new  JFormattedTextField(maskFormatter("## ####-####"));
			txfTelefone.setBounds(xPadraoCampo, diferencaCampos * 9,150,25);
			getContentPane().add(txfTelefone);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//Celular
		lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(250, diferencaCampos * 9,150,25);
		getContentPane().add(lblCelular);
						
		try {
			txfCelular = new  JFormattedTextField(maskFormatter("## # ####-####"));
			txfCelular.setBounds(300, diferencaCampos * 9,145,25);
			getContentPane().add(txfCelular);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//Email
		lblEmail = new JLabel("Email:", JLabel.RIGHT);
		lblEmail.setBounds(xPadraoLabel, diferencaCampos * 10, widthPadraoLabel, 25);
		getContentPane().add(lblEmail);
								
		txfEmail = new JTextField();
		txfEmail.setBounds(xPadraoCampo, diferencaCampos * 10, 350,25);
		getContentPane().add(txfEmail);

		//Observacao
		lblObservacao = new JLabel("Observação:", JLabel.RIGHT);
		lblObservacao.setBounds(xPadraoLabel, diferencaCampos * 11,widthPadraoLabel, 25);
		getContentPane().add(lblObservacao);
								
		txfObservacao = new JTextArea();
		txfObservacao.setBounds(xPadraoCampo, diferencaCampos * 11,350,115);
		txfObservacao.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		getContentPane().add(txfObservacao);
		//button
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(xPadraoCampo, (diferencaCampos * 15) + 5, 113, 25);
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				salvar();
				
			}

			
		});
		getContentPane().add(btnSalvar);		
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(xPadraoCampo + 118, (diferencaCampos * 15) + 5, 113, 25);
		btnConsultar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				consultar();
				
			}

			
		});
		getContentPane().add(btnConsultar);		
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(xPadraoCampo + 236, (diferencaCampos * 15) + 5, 114, 25);
		btnExcluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				excluir();
				
			}

			
		});
		getContentPane().add(btnExcluir);	
		
		painel1 = new JPanel();
		painel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		painel1.setBounds(0, 0, 500, 600	);
		painel1.setBackground(Color.decode("#DEDEDE"));
		getContentPane().add(painel1);
		
		zerarVariaveis();

	}
	

	public String getSelectedButtonText(ButtonGroup buttonGroup) {
		for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();

			if (button.isSelected()) {
				return button.getText();
			}
		}

		return null;

	}
	
	private void popularComboBox() {

		cidades = new CidadesDAO().consultar(cbxUF.getSelectedItem().toString());
		cbxCidades.removeAllItems();
		
		for (Cidades cidade : cidades) {
			cbxCidades.addItem(cidade);
		}
	}
	
	private void zerarVariaveis() {
		txfNomeAluno.setText("");
	    txfCode.setText("");
        txfDataNasc.setText("");
		txfEndereco.setText("");
		txfNumeroCasa.setText("");
		txfComplemento.setText("");
		txfBairro.setText("");
		txfCEP.setText("");
		txfPais.setText("");
		txfTelefone.setText("");
		txfCelular.setText("");
		txfEmail.setText("");
		txfObservacao.setText("");
		
		rbtMasculino.setSelected(true);
		
		txfNomeAluno.requestFocus();
		
		if (Usuarios.getUsuarioLogin().getPerfil().equals("Convidado")) {
			btnExcluir.setEnabled(false);
			btnSalvar.setEnabled(false);
		}
		
		popularComboBox();
	}
	
	private void habilitarCampos(Boolean habilitar) {
		
	    txfCode.setEnabled(!habilitar);
		txfNomeAluno.setEnabled(habilitar);
        txfDataNasc.setEnabled(habilitar);
		txfEndereco.setEnabled(habilitar);
		txfNumeroCasa.setEnabled(habilitar);
		txfComplemento.setEnabled(habilitar);
		txfBairro.setEnabled(habilitar);
		txfCEP.setEnabled(habilitar);
		txfTelefone.setEnabled(habilitar);
		txfCelular.setEnabled(habilitar);
		txfEmail.setEnabled(habilitar);
		txfObservacao.setEnabled(habilitar);
		cbxCidades.setEnabled(habilitar);
		cbxUF.setEnabled(habilitar);
		btnExcluir.setEnabled(habilitar);
		btnSalvar.setEnabled(habilitar);
		rbtFeminino.setEnabled(habilitar);
		rbtMasculino.setEnabled(habilitar);
		
		if (Usuarios.getUsuarioLogin().getPerfil().equals("Convidado")) {
			btnExcluir.setEnabled(false);
			btnSalvar.setEnabled(false);
		}
		
	}
	
	private void salvar() {
		
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date dataNascimento = null;
		try {
			if (!txfDataNasc.getText().equals("")) {
			    dataNascimento = (Date)formatter.parse(txfDataNasc.getText());
			}
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Formato da data inválido.\ndd/MM/yyyy");
			return;
		}
		
		AlunosDAO alunosDAO = new AlunosDAO();
		Alunos alunos = new Alunos();
		
		try {
			alunos.setCdAluno(Integer.parseInt(txfCode.getText()));
		} catch (Exception e) {
		}
		
		if (txfNomeAluno.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Informe o nome do aluno");
			return;
		}
		
		alunos.setAluno(txfNomeAluno.getText());
		alunos.setBairro(txfBairro.getText());
		alunos.setCelular(txfCelular.getText());
		alunos.setCep(txfCEP.getText());
		alunos.setComplemento(txfComplemento.getText());
		alunos.setDataNascimento(dataNascimento);
		alunos.setEmail(txfEmail.getText());
		alunos.setEndereco(txfEndereco.getText());
		alunos.setNumero(txfNumeroCasa.getText());
		alunos.setObservacao(txfObservacao.getText());
		alunos.setTelefone(txfTelefone.getText());
		alunos.setCidade((Cidades)cbxCidades.getSelectedItem());
				
		if (rbtMasculino.isSelected()) {
			alunos.setSexo("M");
		} else {
			alunos.setSexo("F");
		}
		
		if (alunosDAO.salvar(alunos)) {
			txfCode.setText(alunos.getCdAluno().toString());
			JOptionPane.showMessageDialog(null, "Operação realizada");
			zerarVariaveis();
		}
		
	}
	
	private void consultar() {
		
		if (consultar) {
			
			if (!txfCode.getText().equals("")) {
				
				try {
					
					Alunos aluno = new Alunos();
					
					aluno.setCdAluno(Integer.parseInt(txfCode.getText()));
					
					aluno = new AlunosDAO().consultar(aluno);
					
					if (aluno != null) {
						popularCampos(aluno);
					} else {
						JOptionPane.showMessageDialog(null, "Registro não encontrado");
						zerarVariaveis();
					}
					
				} catch (Exception e) {

					zerarVariaveis();
				}
			}
			
			habilitarCampos(true);
			consultar = false;
		} else {
			zerarVariaveis();
			habilitarCampos(false);
			consultar = true;
			txfCode.requestFocus();
		}
		
	}
	
	private void popularCampos(Alunos aluno) {
		
		txfCode.setText(aluno.getCdAluno().toString());
		txfNomeAluno.setText(aluno.getAluno());
		txfBairro.setText(aluno.getBairro());
		txfCelular.setText(aluno.getCelular());
		txfCEP.setText(aluno.getCep());
		txfComplemento.setText(aluno.getComplemento());
		try {
			txfDataNasc.setText(new SimpleDateFormat("dd/MM/yyyy").format(aluno.getDataNascimento()));
		} catch (Exception e) {
		}
		txfEmail.setText(aluno.getEmail());
		txfEndereco.setText(aluno.getEndereco());
		txfNumeroCasa.setText(aluno.getNumero());
		txfObservacao.setText(aluno.getObservacao());
		txfTelefone.setText(aluno.getTelefone());
		cbxUF.setSelectedItem(aluno.getCidade().getEstado());
		cbxCidades.setSelectedItem(aluno.getCidade());

		rbtFeminino.setSelected(true);
		
		if ("M".equals(aluno.getSexo())) {
			rbtMasculino.setSelected(true);
		}
		
		txfNomeAluno.requestFocus();
		
		
	}
	
	private void excluir() {
		try {
			Alunos aluno = new Alunos();
			
			aluno.setCdAluno(Integer.parseInt(txfCode.getText()));
			
			new AlunosDAO().excluir(aluno);
			
			habilitarCampos(true);
			zerarVariaveis();

			JOptionPane.showMessageDialog(null, "Operação realizada");
			
			txfNomeAluno.requestFocus();
			
		} catch (Exception e) {
		}
	}
	

}
