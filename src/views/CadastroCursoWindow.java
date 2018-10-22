package views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import javafx.scene.control.TextField;

public class CadastroCursoWindow extends JInternalFrame {

	private JLabel lblCode;
	private JTextField txfCode;
	private JLabel lblName;
	private JTextField txfName;
	private JButton btnRegister;
	private JButton btnConsultar;
	private JButton btnExcluir;
	
	private final int widthPadraoLabel = 75;
	private final int xPadraoLabel = 15;
	private final int widthPadraoCampo = 350;
	private final int xPadraoCampo = 95;
	private final int diferencaCampos = 28;
	
	public CadastroCursoWindow() {
		setSize(500,180);
		
		setTitle("Cadastro de Curso");
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setClosable(true);
		setIconifiable(true);
		
		criarComponentes();

	}
	
	public MaskFormatter maskFormatter(String format) throws ParseException {
		return (new MaskFormatter(format));
	}
	
	private void criarComponentes() {
		lblCode = new JLabel("Código:", JLabel.RIGHT);
		lblCode.setBounds(xPadraoLabel, diferencaCampos, widthPadraoLabel,25);
		getContentPane().add(lblCode);
		
		txfCode = new JTextField();
		txfCode.setEnabled(false);
		txfCode.setBounds(xPadraoCampo, diferencaCampos, 100, 25);
		getContentPane().add(txfCode);
		
		lblName = new JLabel("Nome:", JLabel.RIGHT);
		lblName.setBounds(xPadraoLabel, diferencaCampos * 2, widthPadraoLabel, 25);
		getContentPane().add(lblName);
		
		txfName = new JTextField();
		txfName.setBounds(xPadraoCampo, diferencaCampos * 2, widthPadraoCampo, 25);
		getContentPane().add(txfName);
		
		btnRegister = new JButton("Salvar");
		btnRegister.setBounds(xPadraoCampo, (diferencaCampos * 3), 115, 25);
		btnRegister.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				register();
			}
		});
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(xPadraoCampo+118, (diferencaCampos * 3), 114, 25);
		btnConsultar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			
			}
		});
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(xPadraoCampo+235, (diferencaCampos * 3), 115, 25);
		btnExcluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		
			}
		});
		
		
		getContentPane().add(btnRegister);
		getContentPane().add(btnConsultar);
		getContentPane().add(btnExcluir);
	}
	
	
	
	private void register() {
		
	}

}
