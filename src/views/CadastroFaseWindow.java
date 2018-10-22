package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class CadastroFaseWindow extends JInternalFrame {

	private JLabel lblFase;
	private JLabel lblCurso;
	private JTextField txfFase;
	private JComboBox comboCurso;
	private JButton btnSalvar;
	private JButton btnConsultar;
	private JButton btnExcluir;
	
	MaskFormatter mask;
	

	String[] Curso = {"Direito","Medicina","Artes"};
	

	
	public CadastroFaseWindow() {
		setSize(350, 120);
		setTitle("Cadastro de Fase");
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
		
//	Label
		lblCurso = new JLabel("Curso:");
		lblCurso.setBounds(10, 10, 50, 25);
		getContentPane().add(lblCurso);
		
		
		lblFase = new JLabel("Fase:");
		lblFase.setBounds(175, 10, 50, 25);
		getContentPane().add(lblFase);
		
		
// 		TextFilds
		
		txfFase = new JTextField();
		txfFase.setBounds(215, 10, 110, 25);
		getContentPane().add(txfFase);
		
		
		
		
//		ComboBox
		comboCurso = new JComboBox(Curso);
		comboCurso.setSelectedIndex(0);
		comboCurso.setBounds(55, 10, 110, 25);
		getContentPane().add(comboCurso);

		
//		Buttons
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(55, 45, 85, 25);
		getContentPane().add(btnSalvar);
		btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Salvando");

			}

		});
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(145, 45, 90, 25);
		getContentPane().add(btnConsultar);		
		
		
		btnConsultar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Consultando :)");

			}

		});
		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(240, 45, 85, 25);
		getContentPane().add(btnExcluir);
		btnExcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Excluir");

			}

		});

	}

	
}
