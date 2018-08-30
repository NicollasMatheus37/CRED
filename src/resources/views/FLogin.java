package resources.views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FLogin extends JDialog {
	
	// Declara os componentes da tela.
	private JTextField txfUsuario;
	private JLabel lblUsuario;
	private JPasswordField pwfSenha;
	private JLabel lblSenha;
	private JButton btnEntrar;
	private JPanel telacheia;

	public FLogin() {
		
		
		// Define o tamanho da janela.
		setSize(400,200);
		
				
				
		// Define o titulo da janela.
		setTitle("Login");
		
		// Seta o layout a ser utilizado (NULL significa que não irá utilizar nenhum).
		setLayout(null);
		
		// Define que não poderá ser alterado as dimensões da tela.
		setResizable(false);
		
		// Define o método de fechamento da janela.
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBackground(Color.black);
		
		setLocationRelativeTo(null);
		// Cria os componentes.
		ComponentesCriar();
	}
	
	/**
	 * Cria os componentes e os adiciona na janela.
	 */
	private void ComponentesCriar() {
		
		txfUsuario = new JTextField();
		txfUsuario.setBounds(90,30,260,25);
		getContentPane().add(txfUsuario);
		txfUsuario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				pwfSenha.requestFocus();
			}
		});
		
		pwfSenha = new JPasswordField();
		pwfSenha.setBounds(90,65,260,25);
		getContentPane().add(pwfSenha);
		pwfSenha.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnEntrar.requestFocus();
				validarLogin();
				
			}
		});
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(30,30,200,25);
		getContentPane().add(lblUsuario);
		
		lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(30,65,200,25);
		getContentPane().add(lblSenha);
		
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(150, 110, 100, 25);
		getContentPane().add(btnEntrar);
		btnEntrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				validarLogin();
			}
		});
		

		telacheia = new JPanel();
		telacheia.setBounds(0,0,500,300);
		telacheia.setBackground(Color.decode("#DCDCDC"));
		getContentPane().add(telacheia);
		
	}
	
	private boolean validarLogin(){
		
		System.out.println("sdfgsd");
		return true;
		
	}
	
	public static void main(String[] args) {
		
		new FLogin().setVisible(true);

	}

}
