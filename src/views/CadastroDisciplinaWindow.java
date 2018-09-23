package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class CadastroDisciplinaWindow extends JInternalFrame{

	private JLabel lblNome;
	private JLabel lblFase;
	private JLabel lblCreditos;
	private JLabel lblCurso;
	private JLabel lblDia;
	private JTextField txfNome;
	private JFormattedTextField ftxfCreditos;
	private JTextField txtCurso;
	private JComboBox comboDia;
	private JComboBox comboFase;
	private JButton btnConcluir;
	
	MaskFormatter mask;
	
	
	String[] diaSemana = { "01-Domingo", "02-Segunda-Feira", "03-Ter�a-Feira", "04-Quarta-Feira",
			"05-Quinta-Feira", "06-Sexta-Feira", "07-S�bado"};
	
	String[] fases = {"teste-01","teste-02","teste-03"};
	
	
	public CadastroDisciplinaWindow() {
		setSize(500, 200);
		setTitle("Cadastro de Disciplina");
		setLayout(null);
		
		setResizable(false);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setClosable(true);
		setIconifiable(true);
		
		criarComponentes();
	}
	
	public MaskFormatter maskFase(String format) throws ParseException {
		return (new MaskFormatter(format));
	}
	
	private void criarComponentes() {
//		=====================Label's========================
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(15, 10, 50, 25);
		getContentPane().add(lblNome);
		
		lblFase = new JLabel("Fase:");
		lblFase.setBounds(15, 40, 50, 25);
		getContentPane().add(lblFase);
		
		lblCreditos = new JLabel("Cr�ditos:");
		lblCreditos.setBounds(15, 70, 60, 25);
		getContentPane().add(lblCreditos);
		
		lblCurso = new JLabel("Curso:");
		lblCurso.setBounds(200, 40, 300, 25);
		getContentPane().add(lblCurso);
		
		lblDia = new JLabel("Dia:");
		lblDia.setBounds(200, 70, 300, 25);
		getContentPane().add(lblDia);
//		====================textFields / FormattedTextFields========================
		txfNome = new JTextField();
		txfNome.setBounds(80, 10, 350, 25);
		getContentPane().add(txfNome);
		
		txtCurso = new JTextField();
		txtCurso.setBounds(250, 40, 180, 25);
		getContentPane().add(txtCurso);
		
		try {
			ftxfCreditos = new JFormattedTextField(maskFase("##"));
			ftxfCreditos.setBounds(80, 70, 100, 25);
			getContentPane().add(ftxfCreditos);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		
//		====================ComboBox===============================
		comboDia = new JComboBox(diaSemana);
		comboDia.setSelectedIndex(0);
		comboDia.setBounds(250, 70, 180, 25);
		getContentPane().add(comboDia);
		
		comboFase = new JComboBox(fases);
		comboFase.setSelectedIndex(0);
		comboFase.setBounds(80, 40, 100, 25);
		getContentPane().add(comboFase);
		
//		=====================Buttons================================
		btnConcluir = new JButton("Concluir");
		btnConcluir.setBounds(100, 110, 250, 30);
		getContentPane().add(btnConcluir);
		btnConcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("teste");

			}

		});

	}
}
