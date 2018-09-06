package views;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import database.dao.AlunosDAO;
import database.dao.UsuariosDAO;
import database.model.Alunos;
import database.model.Usuarios;

public class UsuarioWindow extends JInternalFrame {

	private JTextField txfCode;
	private JLabel lblCode;
	private JLabel lblUsername;
	private JTextField txfUsername;
	private JLabel lblSenha;
	private JPasswordField passSenha;
	private JLabel lblPerfil;
	private JComboBox combo;
	
	private JButton btnSalvar;
	private JButton btnConsultar;
	private JButton btnExcluir;
	
	private JPanel painel1;

	String[] perfil = {"Administrador", "Convidado"};
	
	private boolean consultar = false;
	
	private final int widthPadraoLabel = 75;
	private final int xPadraoLabel = 15;
	private final int widthPadraoCampo = 350;
	private final int xPadraoCampo = 95;
	private final int diferencaCampos = 28;
	
	public UsuarioWindow() {
		setSize(500, 250);
		
		setTitle("Cadastro de Usuário");
		
		setLayout(null);
		
		setResizable(false);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setClosable(true);
		setIconifiable(true);
		
		criarComponentes();
	}
	
	private void criarComponentes() {
		lblCode = new JLabel("Código:", JLabel.RIGHT);
		lblCode.setBounds(xPadraoLabel, diferencaCampos, widthPadraoLabel, 25);
		getContentPane().add(lblCode);

		txfCode = new JTextField();
		txfCode.setEnabled(false);
		txfCode.setBounds(xPadraoCampo, diferencaCampos, 100, 25);
		getContentPane().add(txfCode);
		
		lblUsername = new JLabel("Usuário", JLabel.RIGHT);
		lblUsername.setBounds(xPadraoLabel, diferencaCampos *2, widthPadraoLabel, 25);
		getContentPane().add(lblUsername);
		
		txfUsername = new JTextField();
		txfUsername.setBounds(xPadraoCampo, diferencaCampos * 2, widthPadraoCampo, 25);
		getContentPane().add(txfUsername);
		
		lblSenha = new JLabel("Senha", JLabel.RIGHT);
		lblSenha.setBounds(xPadraoLabel, diferencaCampos * 3, widthPadraoLabel, 25);
		getContentPane().add(lblSenha);
		
		passSenha = new JPasswordField();
		passSenha.setBounds(xPadraoCampo, diferencaCampos * 3, widthPadraoCampo, 25);
		getContentPane().add(passSenha);
		
		lblPerfil = new JLabel("Perfil", JLabel.RIGHT);
		lblPerfil.setBounds(xPadraoLabel, diferencaCampos * 4, widthPadraoLabel, 25);
		getContentPane().add(lblPerfil);
		
		combo = new JComboBox(perfil);
		combo.setSelectedIndex(0);
		combo.setBounds(xPadraoCampo, diferencaCampos * 4, widthPadraoCampo, 25);
		getContentPane().add(combo);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(xPadraoCampo, (diferencaCampos * 5) + 5, 113, 25);
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				salvar();
			}

			
		});
		getContentPane().add(btnSalvar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(xPadraoCampo + 118, (diferencaCampos * 5) + 5, 113, 25);
		btnConsultar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				consultar();
				
			}

			
		});
		getContentPane().add(btnConsultar);		
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(xPadraoCampo + 236, (diferencaCampos * 5) + 5, 114, 25);
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
	
	private void zerarVariaveis() {
		
	    txfCode.setText("");
		txfUsername.setText("");
		passSenha.setText("");
		combo.setSelectedIndex(0);
		txfUsername.requestFocus();
		
	}
	
	private void habilitarCampos(Boolean habilitar) {
		
	    txfCode.setEnabled(!habilitar);
	    txfUsername.setEnabled(habilitar);
	    passSenha.setEnabled(habilitar);
	    combo.setEnabled(habilitar);
		btnExcluir.setEnabled(habilitar);
		btnSalvar.setEnabled(habilitar);
		
	}
	
	private void salvar() {
		UsuariosDAO usuarioDAO = new UsuariosDAO();
		Usuarios usuario = new Usuarios();
		
		try {
			usuario.setCdUsuario(Integer.parseInt(txfCode.getText()));
		} catch (Exception e) {
		}
		
		if (txfUsername.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Informe o nome do usuário");
			return;
		}
		
		if (passSenha.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Informe a senha do usuário");
			return;
		}
		
		usuario.setUsuario(txfUsername.getText());
		usuario.setSenha(passSenha.getText());
		usuario.setPerfil("CON");
		
		if (combo.getSelectedIndex() == 0) {
			usuario.setPerfil("ADM");
		}
		
		if (usuarioDAO.salvar(usuario)) {
			txfCode.setText(usuario.getCdUsuario().toString());
			JOptionPane.showMessageDialog(null, "Operação realizada");
			zerarVariaveis();
		}
	}
	
	private void consultar() {
		
		if (consultar) {
		
			if (!txfCode.getText().equals("")) {
				
				try {
					
					Usuarios usuario = new Usuarios();
					
					usuario.setCdUsuario(Integer.parseInt(txfCode.getText()));
					
					usuario = new UsuariosDAO().consultar(usuario);
					
					if (usuario != null) {
						popularCampos(usuario);
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
	
	private void popularCampos(Usuarios usuario) {
		
		txfCode.setText(usuario.getCdUsuario().toString());
		txfUsername.setText(usuario.getUsuario());
		passSenha.setText(usuario.getSenha());
		combo.setSelectedIndex(1);
		
		if (usuario.getPerfil().equals("ADM")) combo.setSelectedIndex(0);
		
		txfUsername.requestFocus();
		
		
	}
	
	private void excluir() {
		try {
			Usuarios usuario = new Usuarios();
			
			usuario.setCdUsuario(Integer.parseInt(txfCode.getText()));
			
			if (usuario.getCdUsuario().equals(Usuarios.getUsuarioLogin().getCdUsuario())) {
				JOptionPane.showMessageDialog(null, "Não é possível excluir o próprio usuário");
				return;
			}
			
			new UsuariosDAO().excluir(usuario);
			
			habilitarCampos(true);
			zerarVariaveis();

			JOptionPane.showMessageDialog(null, "Operação realizada");
			
			txfUsername.requestFocus();
			
		} catch (Exception e) {
		}
	}

}

