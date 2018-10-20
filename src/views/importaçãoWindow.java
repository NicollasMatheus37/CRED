package views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import TableModel.AlunoTableModel;
import TableModel.DisciplinaTableModel;
import TableModel.OperacaoTableModel;
import TableModel.ProfessorTableModel;


	
public class importaçãoWindow extends JDialog{
	
	private JLabel lblImportar;
	private JLabel lblCurso;
	private JLabel lblData;
	private JLabel lblFaseI;
	private JLabel lblFaseF;
	private JTextField txfCurso;
	private JTextField txfData;
	private JTextField txfFaseI;
	private JTextField txfFaseF;
	private JTextField txfImportar;
	private JButton btnImportar;
	private JTable tblOperacao;
	private JTable tblDisciplina;
	private JTable tblProfessor;
	DisciplinaTableModel modelD;
	OperacaoTableModel modelO;
	ProfessorTableModel modelP;
	JPanel painelFundoDisciplina;
	JPanel painelFundoProf;
	JPanel painelFundoOpe;
	JScrollPane barraRolagemOpe;
	JScrollPane barraRolagemDisci;
	JScrollPane barraRolagemProf;
	private JButton btnNum1;
	private JButton btnNum2;
	private JFileChooser fchImport;
	
//	private JButton btnImportarr;
	
	
	
	public importaçãoWindow() {
		setSize(830, 610);
		setTitle("Importação");
		setLayout(null);
		
		setResizable(false);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//		setClosable(true);
//		setIconifiable(true);
		
		criarComponentes();
	}
	
	private void criarComponentes() {
		
		lblImportar = new JLabel("Importar:");
		lblImportar.setBounds(15, 10, 100, 25);
		getContentPane().add(lblImportar);
		
		txfImportar = new JTextField();
		txfImportar.setBounds(80, 10, 585, 25);
		getContentPane().add(txfImportar);
		
		btnImportar = new JButton("Importar");
		btnImportar.setBounds(685, 10, 100, 25);
		getContentPane().add(btnImportar);
		btnImportar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fchImport = new JFileChooser();
				fchImport.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int i= fchImport.showSaveDialog(null);
			       if (i==1){
			    	   txfImportar.setText("");
			       } else {
			           File arquivo = fchImport.getSelectedFile();
			           txfImportar.setText(arquivo.getPath()+"\\");
			       }
			}

			

		});
		
		lblCurso = new JLabel("Curso:");
		lblCurso.setBounds(30, 50, 100, 25);
		getContentPane().add(lblCurso);
		
		txfCurso = new JTextField();
		txfCurso.setBounds(80, 50, 150, 25);
		getContentPane().add(txfCurso);
		
		lblData = new JLabel("Data:");
		lblData.setBounds(240, 50, 100, 25);
		getContentPane().add(lblData);
		
		txfData = new JTextField();
		txfData.setBounds(280, 50, 100, 25);
		getContentPane().add(txfData);
		
		lblFaseI = new JLabel("Período inicial:");
		lblFaseI.setBounds(390, 50, 100, 25);
		getContentPane().add(lblFaseI);
		
		txfFaseI = new JTextField();
		txfFaseI.setBounds(485, 50, 100, 25);
		getContentPane().add(txfFaseI);
		
		lblFaseF = new JLabel("Período Final:");
		lblFaseF.setBounds(595, 50, 100, 25);
		getContentPane().add(lblFaseF);
		
		txfFaseF = new JTextField();
		txfFaseF.setBounds(685, 50, 100, 25);
		getContentPane().add(txfFaseF);
		
		
		
		

		painelFundoDisciplina = new JPanel();
		painelFundoDisciplina.setLayout(new GridLayout(1, 1));
		modelD = new DisciplinaTableModel();
		
		painelFundoProf = new JPanel();
		painelFundoProf.setLayout(new GridLayout(1, 1));
		modelP = new ProfessorTableModel();
		

		painelFundoOpe = new JPanel();
		painelFundoOpe.setLayout(new GridLayout(1, 1));
		modelO = new OperacaoTableModel();
		
//		tblOperação = new JTable(null);
//		tblOperação.setBounds(25, 100, 400, 200);
//		getContentPane().add(tblOperação);
		tblOperacao = new JTable(modelO);
		tblOperacao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		barraRolagemOpe = new JScrollPane(tblOperacao);
		painelFundoOpe.add(barraRolagemOpe);
		painelFundoOpe.setBounds(25, 100, 400, 200);
		getContentPane().add(painelFundoOpe);
		
//		tblDisciplina = new JTable(null);
//		tblDisciplina.setBounds(25, 325, 400, 200);
//		getContentPane().add(tblDisciplina);
		
		tblDisciplina = new JTable(modelD);
		tblDisciplina.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		barraRolagemDisci = new JScrollPane(tblDisciplina);
		painelFundoDisciplina.add(barraRolagemDisci);
		painelFundoDisciplina.setBounds(25, 325, 400, 200);
		getContentPane().add(painelFundoDisciplina);
		
//		tblProfessor = new JTable(null);
//		tblProfessor.setBounds(485, 100, 300, 425);
//		getContentPane().add(tblProfessor);
		
		tblProfessor = new JTable(modelP);
		tblProfessor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		barraRolagemProf = new JScrollPane(tblProfessor);
		painelFundoProf.add(barraRolagemProf);
		painelFundoProf.setBounds(450, 100, 330, 425);
		getContentPane().add(painelFundoProf);
		
		btnNum1 = new JButton("Importar");
		btnNum1.setBounds(680, 540, 100, 25);
		getContentPane().add(btnNum1);
		btnNum1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Vai Dar");

			}

		});
		
		btnNum2 = new JButton("Importar");
		btnNum2.setBounds(560, 540, 100, 25);
		getContentPane().add(btnNum2);
		btnNum2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Vai Dar");

			}

		});
		
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		importaçãoWindow imp = new importaçãoWindow();
		imp.setVisible(true);
	}

}
