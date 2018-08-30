package resources.views;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Aluno extends JInternalFrame{
	
	//componentes
	private JTextField txfNomeAluno;
	private JLabel lblNomeAluno;
	private JTextField txfCode;
	private JLabel lblCode;
	private JTextField txfDataNasc;
	private JLabel lblDataNasc;
	private JTextField txfSexo;
	private JLabel lblSexo;
	private JTextField txfEndereco;
	private JLabel lblEndereco;
	private JTextField txfNumeroCasa;
	private JLabel lblNumeroCasa;
	private JTextField txfComplemento;
	private JLabel lblComplemento;
	private JTextField txfCidade;
	private JLabel lblCidade;
	private JTextField txfBairro;
	private JLabel lblBairro;
	private JTextField txfUF;
	private JLabel lblUF;
	private JTextField txfCEP;
	private JLabel lblCEP;
	
	private JButton btnEntrar;
	private JPanel telacheia;
	private JPanel painel1;
	private JLabel lblPainel1;
	
	public Aluno() {
		
			
		// Define o tamanho da janela.
		setSize(800,700);
			
					
					
		// Define o titulo da janela.
		setTitle("Tela Cadastro Aluno");
			
		// Seta o layout a ser utilizado (NULL significa que não irá utilizar nenhum).
		setLayout(null);
			
		// Define que não poderá ser alterado as dimensões da tela.
		setResizable(false);
			
		// Define o método de fechamento da janela.
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBackground(Color.black);
		// Cria os componentes.
		ComponentesCriar();
		
	}
	private void ComponentesCriar() {
		
		//codigo
		lblCode = new JLabel("Código:");
		lblCode.setBounds(25,75,150,25);
		getContentPane().add(lblCode);
		
		txfCode = new JTextField();
		txfCode.setBounds(25,100,100,25);
		getContentPane().add(txfCode);
		
		//nome
		lblNomeAluno = new JLabel("Nome:");
		lblNomeAluno.setBounds(140,75,150,25);
		getContentPane().add(lblNomeAluno);
		
		txfNomeAluno = new JTextField();
		txfNomeAluno.setBounds(140,100,350,25);
		getContentPane().add(txfNomeAluno);
		
		//data nascimento
		lblDataNasc = new JLabel("Nascimento:");
		lblDataNasc.setBounds(505,75,200,25);
		getContentPane().add(lblDataNasc);
		
		txfDataNasc = new JTextField();
		txfDataNasc.setBounds(505,100,100,25);
		getContentPane().add(txfDataNasc);
		
		//sexo
		lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(620,75,200,25);
		getContentPane().add(lblSexo);
		
		txfSexo = new JTextField();
		txfSexo.setBounds(620,100,65,25);
		getContentPane().add(txfSexo);
		
		//endereço
		lblEndereco = new JLabel("Endereço:");
		lblEndereco.setBounds(25,125,200,25);
		getContentPane().add(lblEndereco);
		
		txfEndereco = new JTextField();
		txfEndereco.setBounds(25,150,300,25);
		getContentPane().add(txfEndereco);
		
		//numero casa
		lblNumeroCasa = new JLabel("Numero:");
		lblNumeroCasa.setBounds(340,125,100,25);
		getContentPane().add(lblNumeroCasa);
		
		txfNumeroCasa = new JTextField();
		txfNumeroCasa.setBounds(340,150,100,25);
		getContentPane().add(txfNumeroCasa);
		
		//complemento
		lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(460,125,100,25);
		getContentPane().add(lblComplemento);
			
		txfComplemento = new JTextField();
		txfComplemento.setBounds(460,150,225,25);
		getContentPane().add(txfComplemento);			
		
		//endereço
		lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(25,175,200,25);
		getContentPane().add(lblCidade);
				
		txfCidade = new JTextField();
		txfCidade.setBounds(25,200,225,25);
		getContentPane().add(txfCidade);

		//bairro
		lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(265,175,200,25);
		getContentPane().add(lblBairro);
				
		txfBairro = new JTextField();
		txfBairro.setBounds(265,200,225,25);
		getContentPane().add(txfBairro);

		//UF
		lblUF = new JLabel("UF:");
		lblUF.setBounds(505,175,50,25);
		getContentPane().add(lblUF);
				
		txfUF = new JTextField();
		txfUF.setBounds(505,200,50,25);
		getContentPane().add(txfUF);
		
		//CEP
		lblCEP = new JLabel("CEP:");
		lblCEP.setBounds(570,175,115,25);
		getContentPane().add(lblCEP);
				
		txfUF = new JTextField();
		txfUF.setBounds(570,200,115,25);
		getContentPane().add(txfUF);
		
		//painel1
		
		painel1 = new JPanel();
		painel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		painel1.setBounds(20, 60, 670, 200);
		painel1.setBackground(Color.decode("#C0C0C0"));
		getContentPane().add(painel1);
		
		
		
		
//		btnEntrar = new JButton("Entrar");
//		btnEntrar.setBounds(150, 150, 100, 25);
//		getContentPane().add(btnEntrar);
		

//		telacheia = new JPanel();
//		telacheia.setBounds(0,0,500,300);
//		telacheia.setBackground(Color.decode("#C0C0C0"));
//		getContentPane().add(telacheia);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Aluno().setVisible(true);
		
	}

}
