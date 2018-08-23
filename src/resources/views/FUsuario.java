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
//	private JTextField txfCidade;
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
//	private JPanel telacheia;
	private JPanel painel1;
//	private JLabel lblPainel1;
	String[] uf = {"SC","RS"};
	String[] cidades = {"meu ovo", "minha colinha na prova de ontem tava uma beleza"};
	String[] pais = {"Republica Dominicana do Congo", "Teu cú"};
	
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
		lblCode = new JLabel("Código:");
		lblCode.setBounds(45, 20, 150, 25);
		getContentPane().add(lblCode);

		txfCode = new JTextField();
		txfCode.setBounds(95, 20, 150, 25);
		txfCode.setBackground(Color.decode("#FFFFFF"));
		txfCode.setEditable(false);
		getContentPane().add(txfCode);

		// nome
		lblNomeAluno = new JLabel("Nome:");
		lblNomeAluno.setBounds(50, 55, 150, 25);
		getContentPane().add(lblNomeAluno);

		txfNomeAluno = new JTextField();
		txfNomeAluno.setBounds(95, 55, 350, 25);
		getContentPane().add(txfNomeAluno);

		// data nascimento
		lblDataNasc = new JLabel("Nascimento:");
		lblDataNasc.setBounds(15, 90, 200, 25);
		getContentPane().add(lblDataNasc);

		txfDataNasc = new JTextField();
		txfDataNasc.setBounds(95, 90, 150, 25);
		getContentPane().add(txfDataNasc);

		// sexo
		lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(250, 90, 200, 25);
		getContentPane().add(lblSexo);

		JRadioButton rbtMasculino = new JRadioButton("Masculino");
		rbtMasculino.setSelected(false);
		rbtMasculino.setBounds(285, 90, 85, 25);
		rbtMasculino.setBackground(Color.decode("#DEDEDE"));
		getContentPane().add(rbtMasculino);

		JRadioButton rbtFeminino = new JRadioButton("Feminino");
		rbtFeminino.setSelected(false);
		rbtFeminino.setBounds(370, 90, 100, 25);
		rbtFeminino.setBackground(Color.decode("#DEDEDE"));
		getContentPane().add(rbtFeminino);

		ButtonGroup group = new ButtonGroup();
		group.add(rbtMasculino);
		group.add(rbtFeminino);

		
		//endereço
		lblEndereco = new JLabel("Endereço:");
		lblEndereco.setBounds(30,125,200,25);
		getContentPane().add(lblEndereco);
		
		txfEndereco = new JTextField();
		txfEndereco.setBounds(95,125,350,25);
		getContentPane().add(txfEndereco);
//		
		//numero casa
		lblNumeroCasa = new JLabel("Numero:");
		lblNumeroCasa.setBounds(40,160,100,25);
		getContentPane().add(lblNumeroCasa);
		
		txfNumeroCasa = new JTextField();
		txfNumeroCasa.setBounds(95,160,50,25);
		getContentPane().add(txfNumeroCasa);
		
		//complemento
		lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(150,160,100,25);
		getContentPane().add(lblComplemento);
			
		txfComplemento = new JTextField();
		txfComplemento.setBounds(240,160,205,25);
		getContentPane().add(txfComplemento);			
		
		//Cidade
		lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(150,230,100,25);
		getContentPane().add(lblCidade);
		
		JComboBox combo = new JComboBox(cidades);
		combo.setSelectedIndex(1);
		combo.setBounds(200,230,245,25);
		getContentPane().add(combo);
				
//		txfCidade = new JTextField();
//		txfCidade.setBounds(95,195,150,25);
//		getContentPane().add(txfCidade);

		//bairro
		lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(250,195,150,25);
		getContentPane().add(lblBairro);
				
		txfBairro = new JTextField();
		txfBairro.setBounds(295,195,150,25);
		getContentPane().add(txfBairro);

		//UF
		lblUF = new JLabel("UF:");
		lblUF.setBounds(70,230,50,25);
		getContentPane().add(lblUF);
		
		JComboBox comboUF = new JComboBox(uf);
		comboUF.setSelectedIndex(1);
		comboUF.setBounds(95,230,50,25);
		getContentPane().add(comboUF);
				
//		txfUF = new JTextField();
//		txfUF.setBounds(95,230,50,25);
//		getContentPane().add(txfUF);

		//País
		lblPais = new JLabel("País:");
		lblPais.setBounds(60,265,100,25);
		getContentPane().add(lblPais);
				
		JComboBox comboPais = new JComboBox(pais);
		comboPais.setSelectedIndex(1);
		comboPais.setBounds(95,265,350,25);
		getContentPane().add(comboPais);
		
//		txfPais = new JTextField();
//		txfPais.setBounds(95,265,350,25);
//		getContentPane().add(txfPais);
		
		
		//CEP
		lblCEP = new JLabel("CEP:");
		lblCEP.setBounds(60,195,200,25);
		getContentPane().add(lblCEP);
				
		txfCEP = new JTextField();
		txfCEP.setBounds(95,195,150,25);
		getContentPane().add(txfCEP);
		
		//Telefone
		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(35,300,200,25);
		getContentPane().add(lblTelefone);
						
		txfTelefone = new JTextField();
		txfTelefone.setBounds(95,300,150,25);
		getContentPane().add(txfTelefone);

		//Celular
		lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(250,300,150,25);
		getContentPane().add(lblCelular);
						
		txfCelular = new JTextField();
		txfCelular.setBounds(300,300,145,25);
		getContentPane().add(txfCelular);
		
		//Email
		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(55,335,200,25);
		getContentPane().add(lblEmail);
								
		txfEmail = new JTextField();
		txfEmail.setBounds(95,335,350,25);
		getContentPane().add(txfEmail);

		//Observacao
		lblObservacao = new JLabel("Observacao:");
		lblObservacao.setBounds(15,370,150,25);
		getContentPane().add(lblObservacao);
								
		txfObservacao = new JTextArea();
		txfObservacao.setBounds(95,370,350,115);
		txfObservacao.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		getContentPane().add(txfObservacao);
		//button
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(95, 500, 100, 25);
		btnCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println(getSelectedButtonText(group));
				
			}
		});
		getContentPane().add(btnCadastrar);		
		
//		//painel1
//		
		painel1 = new JPanel();
		painel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		painel1.setBounds(0, 0, 500, 600	);
		painel1.setBackground(Color.decode("#DEDEDE"));
		getContentPane().add(painel1);


//		telacheia = new JPanel();
//		telacheia.setBounds(0,0,500,300);
//		telacheia.setBackground(Color.decode("#C0C0C0"));
//		getContentPane().add(telacheia);
		


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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new FUsuario().setVisible(true);

	}

}
