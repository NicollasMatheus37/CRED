package resources.views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.LineNumberInputStream;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import database.dao.AlunosDAO;
import database.model.Alunos;

public class FUsuario extends JInternalFrame {

	// componentes
	private JTextField txfNomeAluno;
	private JLabel lblNomeAluno;
	private JTextField txfCode;
	private JLabel lblCode;
	private JTextField txfDataNasc;
	private JLabel lblDataNasc;
	private JLabel lblSexo;
	private JTextField txfEndereco;
	private JLabel lblEndereco;
	private JTextField txfNumeroCasa;
	private JLabel lblNumeroCasa;
	private JTextField txfComplemento;
	private JLabel lblComplemento;
	private JLabel lblCidade;
	private JTextField txfBairro;
	private JLabel lblBairro;
	private JTextField txfUF;
	private JLabel lblUF;
	private JTextField txfCEP;
	private JLabel lblCEP;
	private JTextField txfPais;
	private JLabel lblPais;
	private JTextField txfTelefone;
	private JLabel lblTelefone;
	private JTextField txfCelular;
	private JLabel lblCelular;
	private JTextField txfEmail;
	private JLabel lblEmail;
	private JTextArea txfObservacao;
	private JLabel lblObservacao;
	
	private JButton btnCadastrar;
	private JPanel painel1;
	String[] uf = {"SC","RS"};
	String[] cidades = {"meu ovo", "minha colinha na prova de ontem tava uma beleza"};
	String[] pais = {"Republica Dominicana do Congo", "Teu cú"};
	
	private final int widthPadraoLabel = 75;
	private final int xPadraoLabel = 15;
	private final int widthPadraoCampo = 350;
	private final int xPadraoCampo = 95;
	private final int diferencaCampos = 28;
	
	public FUsuario() {

		// Define o tamanho da janela.
		setSize(500, 600);

		// Define o titulo da janela.
		setTitle("Tela Cadastro Aluno");

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
		ComponentesCriar();

	}

	private void ComponentesCriar() {

		// codigo
		lblCode = new JLabel("Código:", JLabel.RIGHT);
		lblCode.setBounds(xPadraoLabel, diferencaCampos, widthPadraoLabel, 25);
		getContentPane().add(lblCode);

		txfCode = new JTextField();
		txfCode.setBounds(xPadraoCampo, diferencaCampos, 100, 25);
		txfCode.setBackground(Color.decode("#FFFFFF"));
		txfCode.setEditable(false);
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

		txfDataNasc = new JTextField();
		txfDataNasc.setBounds(xPadraoCampo, diferencaCampos * 3, 150, 25);
		getContentPane().add(txfDataNasc);

		// sexo
		lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(250, diferencaCampos * 3, widthPadraoLabel, 25);
		getContentPane().add(lblSexo);

		JRadioButton rbtMasculino = new JRadioButton("Masculino");
		rbtMasculino.setSelected(false);
		rbtMasculino.setBounds(285, diferencaCampos * 3, 85, 25);
		rbtMasculino.setBackground(Color.decode("#DEDEDE"));
		getContentPane().add(rbtMasculino);

		JRadioButton rbtFeminino = new JRadioButton("Feminino");
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
		
		txfNumeroCasa = new JTextField();
		txfNumeroCasa.setBounds(xPadraoCampo, diferencaCampos * 5,50,25);
		getContentPane().add(txfNumeroCasa);
		
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
		
		JComboBox comboUF = new JComboBox(uf);
		comboUF.setSelectedIndex(1);
		comboUF.setBounds(xPadraoCampo, diferencaCampos * 6,50,25);
		getContentPane().add(comboUF);

		//Cidade
		lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(150, diferencaCampos * 6, widthPadraoLabel, 25);
		getContentPane().add(lblCidade);
		
		JComboBox combo = new JComboBox(cidades);
		combo.setSelectedIndex(1);
		combo.setBounds(200, diferencaCampos * 6,245,25);
		getContentPane().add(combo);
		
		//País
		lblPais = new JLabel("País:", JLabel.RIGHT);
		lblPais.setBounds(xPadraoLabel, diferencaCampos * 7,widthPadraoLabel, 25);
		getContentPane().add(lblPais);
				
		JComboBox comboPais = new JComboBox(pais);
		comboPais.setSelectedIndex(1);
		comboPais.setBounds(xPadraoCampo, diferencaCampos * 7,350,25);
		getContentPane().add(comboPais);
		
		//CEP
		lblCEP = new JLabel("CEP:", JLabel.RIGHT);
		lblCEP.setBounds(xPadraoLabel, diferencaCampos * 8,widthPadraoLabel, 25);
		getContentPane().add(lblCEP);
				
		txfCEP = new JTextField();
		txfCEP.setBounds(xPadraoCampo, diferencaCampos * 8,150,25);
		getContentPane().add(txfCEP);

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
						
		txfTelefone = new JTextField();
		txfTelefone.setBounds(xPadraoCampo, diferencaCampos * 9,150,25);
		getContentPane().add(txfTelefone);

		//Celular
		lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(250, diferencaCampos * 9,150,25);
		getContentPane().add(lblCelular);
						
		txfCelular = new JTextField();
		txfCelular.setBounds(300, diferencaCampos * 9,145,25);
		getContentPane().add(txfCelular);
		
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
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(xPadraoCampo, (diferencaCampos * 15) + 5, 100, 25);
		btnCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cadastrar();
				
			}

			private void cadastrar() {
				
				AlunosDAO alunosDAO = new AlunosDAO();
				Alunos alunos = new Alunos();
				
				
				
			}
		});
		getContentPane().add(btnCadastrar);		
		
		painel1 = new JPanel();
		painel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		painel1.setBounds(0, 0, 500, 600	);
		painel1.setBackground(Color.decode("#DEDEDE"));
		getContentPane().add(painel1);

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

}
