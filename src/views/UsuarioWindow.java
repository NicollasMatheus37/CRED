package views;
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

import database.dao.AlunosDAO;
import database.model.Alunos;

public class UsuarioWindow extends JInternalFrame {
	
	private JLabel lblUsername;
	private JTextField txfUsername;
	private JLabel lblSenha;
	private JPasswordField passSenha;
	private JLabel lblPerfil;
	
	private JButton btnCadastrar;
	
	private JPanel painel1;

	String[] perfil = {"Administrador", "Convidado"};

	
	private final int widthPadraoLabel = 75;
	private final int xPadraoLabel = 15;
	private final int widthPadraoCampo = 350;
	private final int xPadraoCampo = 95;
	private final int diferencaCampos = 28;
	
	public UsuarioWindow() {
		setSize(500, 200);
		
		setTitle("Cadastro de Usuário");
		
		setLayout(null);
		
		setResizable(false);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setClosable(true);
		setIconifiable(true);
		
		criarComponentes();
	}
	
	private void criarComponentes() {
		
		lblUsername = new JLabel("Usuário", JLabel.RIGHT);
		lblUsername.setBounds(xPadraoLabel, diferencaCampos, widthPadraoLabel, 25);
		getContentPane().add(lblUsername);
		
		txfUsername = new JTextField();
		txfUsername.setBounds(xPadraoCampo, diferencaCampos, widthPadraoCampo, 25);
		getContentPane().add(txfUsername);
		
		lblSenha = new JLabel("Senha", JLabel.RIGHT);
		lblSenha.setBounds(xPadraoLabel, diferencaCampos * 2, widthPadraoLabel, 25);
		getContentPane().add(lblSenha);
		
		passSenha = new JPasswordField();
		passSenha.setBounds(xPadraoCampo, diferencaCampos * 2, widthPadraoCampo, 25);
		getContentPane().add(passSenha);
		
		lblPerfil = new JLabel("Perfil", JLabel.RIGHT);
		lblPerfil.setBounds(xPadraoLabel, diferencaCampos * 3, widthPadraoLabel, 25);
		getContentPane().add(lblPerfil);
		
		JComboBox combo = new JComboBox(perfil);
		combo.setSelectedIndex(1);
		combo.setBounds(xPadraoCampo, diferencaCampos * 3, widthPadraoCampo, 25);
		getContentPane().add(combo);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(xPadraoCampo, (diferencaCampos * 4) + 5, 100, 25);
		btnCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//System.out.println(getSelectedButtonText());
			}

			private void cadastrar() {
				
				
				
				
			}
		});
		getContentPane().add(btnCadastrar);
		
		painel1 = new JPanel();
		painel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		painel1.setBounds(0, 0, 500, 600);
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

