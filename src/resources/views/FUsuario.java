package resources.views;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class FUsuario extends JInternalFrame {
	
	private JLabel lblUsername;
	private JTextField txfUsername;
	private JLabel lblSenha;
	private JPasswordField passSenha;
	private JLabel lblPerfil;
	
	private JButton btnCadastrar;
	
	private JPanel painel1;

	String[] perfil = {"Administrador", "Usuário"};

	
	public FUsuario() {
		setSize(500, 600);
		
		setTitle("Tela de Cadastro de Usuário");
		
		setLayout(null);
		
		setResizable(false);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setClosable(true);
		setIconifiable(true);
		
		criarComponentes();
	}
	
	private void criarComponentes() {
		
		lblUsername = new JLabel("Username");
		lblUsername.setBounds(0,0,0,0);
		getContentPane().add(lblUsername);
		
		txfUsername = new JTextField();
		txfUsername.setBounds(0,0,0,0);
		txfUsername.setBackground(Color.decode(""));
		getContentPane().add(txfUsername);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(0,0,0,0);
		getContentPane().add(lblSenha);
		
		passSenha = new JPasswordField();
		passSenha.setBounds(0,0,0,0);
		passSenha.setBackground(Color.decode(""));
		getContentPane().add(passSenha);
		
		lblPerfil = new JLabel("Perfil");
		lblPerfil.setBounds(0,0,0,0);
		getContentPane().add(lblPerfil);
		
		JComboBox combo = new JComboBox(perfil);
		combo.setSelectedIndex(1);
		combo.setBounds(0,0,0,0);
		getContentPane().add(combo);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(95, 500, 100, 25);
		btnCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//System.out.println(getSelectedButtonText());
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new FAluno().setVisible(true);

	}

}

