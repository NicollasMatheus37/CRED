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
	private JButton btnConcluir;
	private JButton btnBuscar;
	
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
		lblCurso.setBounds(15, 10, 50, 25);
		getContentPane().add(lblCurso);
		
		
		lblFase = new JLabel("Fase:");
		lblFase.setBounds(180, 10, 50, 25);
		getContentPane().add(lblFase);
		
		
// 		TextFilds
		
		txfFase = new JTextField();
		txfFase.setBounds(220, 10, 100, 25);
		getContentPane().add(txfFase);
		
		
		
		
//		ComboBox
		comboCurso = new JComboBox(Curso);
		comboCurso.setSelectedIndex(0);
		comboCurso.setBounds(60, 10, 100, 25);
		getContentPane().add(comboCurso);

		
//		Buttons
		btnConcluir = new JButton("Concluir");
		btnConcluir.setBounds(175, 45, 100, 30);
		getContentPane().add(btnConcluir);
		btnConcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Vai Dar");

			}

		});
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(70, 45, 100, 30);
		getContentPane().add(btnBuscar);		
		
		
		btnBuscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Vai Dar :)");

			}

		});

	}

	
}
