package resources.views;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Login extends JDialog {
	
	// Declara os componentes da tela.
	private JTextField txfLogin;
	private JLabel lblLogin;
	private JTextField txfSenha;
	private JLabel lblSenha;
	private JButton btnEntrar;
	private JPanel telacheia;

	public Login() {
		
		// Define o tamanho da janela.
		setSize(500,300);
		
				
				
		// Define o titulo da janela.
		setTitle("Tela de Login");
		
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
	
	/**
	 * Cria os componentes e os adiciona na janela.
	 */
	private void ComponentesCriar() {
		
		txfLogin = new JTextField();
		txfLogin.setBounds(150,50,200,25);
		getContentPane().add(txfLogin);
		
		txfSenha = new JTextField();
		txfSenha.setBounds(150,100,200,25);
		getContentPane().add(txfSenha);
		
		lblLogin = new JLabel("Login:");
		lblLogin.setBounds(100,50,200,25);
		getContentPane().add(lblLogin);
		
		lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(100,100,200,25);
		getContentPane().add(lblSenha);
		
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(150, 150, 100, 25);
		getContentPane().add(btnEntrar);
		

		telacheia = new JPanel();
		telacheia.setBounds(0,0,500,300);
		telacheia.setBackground(Color.decode("#C0C0C0"));
		getContentPane().add(telacheia);
		
	}
	
	public static void main(String[] args) {
		
		new Login().setVisible(true);

	}

}
