package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CadastroProfessoresWindow extends JInternalFrame{

	private JLabel lblCodigo;
	private JLabel lblNome;
	private JLabel lblCurso;
	private JLabel lblFase;
	private JLabel lblDisciplina;
	private JLabel lblTituloDocente;
	private JTextField txfCodigo;
	private JTextField txfNome;
	private JComboBox comboCurso;
	private JComboBox comboFase;
	private JComboBox comboDisciplina;
	private JComboBox comboTituloDocente;
	private JButton btnConcluir;
	
	String[] testeFases = {"teste Fase-01","teste Fase-02","teste Fase-03"};
	String[] testeCursos = {"teste Curso-01","teste Curso-02","teste Curso-03"};
	String[] testeDisciplinas = {"teste Disciplina-01","teste Disciplina-02","teste Disciplina-03"};
	String[] testeTituloDocente = {"Pós-Graduação","Mestrado","Doutorado", "Pós-Doutorado"};
	
	
	public CadastroProfessoresWindow() {
		setSize(700, 230);
		setTitle("Cadastro de Professores");
		setLayout(null);
		
		setResizable(false);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setClosable(true);
		setIconifiable(true);
		
		criarComponentes();
	}
	
	private void criarComponentes() {
//		=====================Label's========================
		lblCodigo = new JLabel("Código:");
		lblCodigo.setBounds(15, 10, 50, 25);
		getContentPane().add(lblCodigo);
		
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(15, 40, 50, 25);
		getContentPane().add(lblNome);
		
		lblCurso = new JLabel("Curso:");
		lblCurso.setBounds(15, 70, 50, 25);
		getContentPane().add(lblCurso);
		
		lblFase = new JLabel("Fase:");
		lblFase.setBounds(15, 100, 50, 25);
		getContentPane().add(lblFase);
		
		lblDisciplina = new JLabel("Disciplina:");
		lblDisciplina.setBounds(350, 70, 70, 25);
		getContentPane().add(lblDisciplina);
		
		lblTituloDocente = new JLabel("Título Docente:");
		lblTituloDocente.setBounds(350, 100, 85, 25);
		getContentPane().add(lblTituloDocente);
		
//		========================textFields===================
		txfCodigo = new JTextField();
		txfCodigo.setEnabled(false);
		txfCodigo.setBounds(80, 10, 100, 25);
		getContentPane().add(txfCodigo);
		
		txfNome = new JTextField();
		txfNome.setBounds(80, 40, 580, 25);
		getContentPane().add(txfNome);
		
//		========================ComboBox======================
		comboCurso = new JComboBox(testeCursos);
		comboCurso.setSelectedIndex(0);
		comboCurso.setBounds(80, 70, 250, 25);
		getContentPane().add(comboCurso);
		
		comboFase = new JComboBox(testeFases);
		comboFase.setSelectedIndex(0);
		comboFase.setBounds(80, 100, 250, 25);
		getContentPane().add(comboFase);
		
		comboDisciplina = new JComboBox(testeDisciplinas);
		comboDisciplina.setSelectedIndex(0);
		comboDisciplina.setBounds(440, 70, 219, 25);
		getContentPane().add(comboDisciplina);
		
		comboTituloDocente = new JComboBox(testeTituloDocente);
		comboTituloDocente.setSelectedIndex(0);
		comboTituloDocente.setBounds(440, 100, 219, 25);
		getContentPane().add(comboTituloDocente);
//		=====================Button==============================
		
		btnConcluir = new JButton("Concluir");
		btnConcluir.setBounds(200, 135, 250, 30);
		getContentPane().add(btnConcluir);
		btnConcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("teste");

			}

		});

		
	}
	
}
