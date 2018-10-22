package views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import TableModel.DisciplinaTableModel;
import TableModel.OperacaoTableModel;
import TableModel.ProfessorTableModel;
import database.dao.CursosDAO;
import database.dao.DisciplinasDAO;
import database.dao.FaseDAO;
import database.dao.ProfessorDAO;
import database.dao.importation.HeaderDAO;
import database.model.Cursos;
import database.model.Disciplinas;
import database.model.Fases;
import database.model.Professores;
import database.model.importation.Arquivo;
import database.model.importation.ResumoDisciplina;
import database.model.importation.ResumoOperacao;
import database.model.importation.ResumoProfessor;
import lib.ImportacaoArquivo;

public class ImportacaoWindow extends JInternalFrame {

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
	private JButton btnBuscar;
	private JButton btnNum1;
	private JButton btnNum2;
	private Arquivo arquivoImportado;
	private boolean clickOperacao = false;

	// private JButton btnImportarr;

	public ImportacaoWindow() {
		setSize(830, 610);
		setTitle("Importação");
		setLayout(null);

		setResizable(false);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setClosable(true);
		setIconifiable(true);

		criarComponentes();
	}

	private void criarComponentes() {

		lblImportar = new JLabel("Importar:");
		lblImportar.setBounds(15, 10, 100, 25);
		getContentPane().add(lblImportar);

		txfImportar = new JTextField();
		txfImportar.setBounds(80, 10, 585, 25);
		getContentPane().add(txfImportar);

		btnBuscar = new JButton("...");
		btnBuscar.setBounds(670, 10, 30, 25);
		getContentPane().add(btnBuscar);
		btnBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fchBusca = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Apenas Texto", "txt", "text");
				fchBusca.setFileFilter(filter);
				int i = fchBusca.showSaveDialog(null);
				if (i == 1) {
					txfImportar.setText("");
				} else {
					File arquivo = fchBusca.getSelectedFile();
					txfImportar.setText(arquivo.getPath());
				}
			}

		});

		btnImportar = new JButton("Importar");
		btnImportar.setBounds(710, 10, 100, 25);
		getContentPane().add(btnImportar);
		btnImportar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!txfImportar.getText().equals("")) {
					limpar();
					importarArquivo(txfImportar.getText());
				}
			}
		});

		lblCurso = new JLabel("Curso:");
		lblCurso.setBounds(30, 50, 100, 25);
		getContentPane().add(lblCurso);

		txfCurso = new JTextField();
		txfCurso.setBounds(80, 50, 150, 25);
		txfCurso.setEditable(false);
		getContentPane().add(txfCurso);

		lblData = new JLabel("Data:");
		lblData.setBounds(240, 50, 100, 25);
		getContentPane().add(lblData);

		txfData = new JTextField();
		txfData.setBounds(280, 50, 100, 25);
		txfData.setEditable(false);
		getContentPane().add(txfData);

		lblFaseI = new JLabel("Período inicial:");
		lblFaseI.setBounds(390, 50, 100, 25);
		getContentPane().add(lblFaseI);

		txfFaseI = new JTextField();
		txfFaseI.setBounds(485, 50, 100, 25);
		txfFaseI.setEditable(false);
		getContentPane().add(txfFaseI);

		lblFaseF = new JLabel("Período Final:");
		lblFaseF.setBounds(595, 50, 100, 25);
		getContentPane().add(lblFaseF);

		txfFaseF = new JTextField();
		txfFaseF.setBounds(685, 50, 100, 25);
		txfFaseF.setEditable(false);
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

		tblOperacao = new JTable(modelO);
		tblOperacao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		barraRolagemOpe = new JScrollPane(tblOperacao);
		painelFundoOpe.add(barraRolagemOpe);
 		painelFundoOpe.setBounds(25, 100, 400, 200);
		getContentPane().add(painelFundoOpe);

		tblOperacao.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				if (tblOperacao.getSelectedRow() < 0) return;
				
				clickOperacao = true;
				tblDisciplina.clearSelection();
				tblProfessor.clearSelection();

				for (ResumoOperacao resumo : arquivoImportado.getResumos()) {

					if (resumo.getLinha() == modelO.getObjectAt(tblOperacao.getSelectedRow()).getLinha()) {

						for (ResumoDisciplina resumoDisciplina : resumo.getDisciplinas()) {

							for (int i = 0; i < modelD.getRowCount(); i++) {

								if (resumoDisciplina.getLinha() == modelD.getObjectAt(i).getLinha()) {
									tblDisciplina.addRowSelectionInterval(i, i);

									for (ResumoProfessor resumoProfessor : resumoDisciplina.getProfessores()) {

										for (int j = 0; j < modelP.getRowCount(); j++) {
											if (resumoProfessor.getLinha() == modelP.getObjectAt(j).getLinha()) {
												tblProfessor.addRowSelectionInterval(j, j);
											}
										}

									}

								}
							}

						}

					}

				}
				clickOperacao = false;

			}
		});

		tblDisciplina = new JTable(modelD);
		tblDisciplina.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		barraRolagemDisci = new JScrollPane(tblDisciplina);
		painelFundoDisciplina.add(barraRolagemDisci);
		painelFundoDisciplina.setBounds(25, 325, 400, 200);
		getContentPane().add(painelFundoDisciplina);

		tblDisciplina.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {

				if (!clickOperacao) {
					tblOperacao.clearSelection();
					tblProfessor.clearSelection();
	
					for (ResumoProfessor resumoProfessor : modelD.getObjectAt(tblDisciplina.getSelectedRow())
							.getProfessores()) {
	
						for (int j = 0; j < modelP.getRowCount(); j++) {
							if (resumoProfessor.getLinha() == modelP.getObjectAt(j).getLinha()) {
								tblProfessor.addRowSelectionInterval(j, j);
							}
						}
	
					}
				}

			}
		});

		tblProfessor = new JTable(modelP);
		barraRolagemProf = new JScrollPane(tblProfessor);
		painelFundoProf.add(barraRolagemProf);
		painelFundoProf.setBounds(450, 100, 330, 425);
		getContentPane().add(painelFundoProf);

		btnNum1 = new JButton("Limpar");
		btnNum1.setBounds(680, 540, 100, 25);
		getContentPane().add(btnNum1);
		btnNum1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				limpar();

			}

		});

		btnNum2 = new JButton("Salvar");
		btnNum2.setBounds(560, 540, 100, 25);
		getContentPane().add(btnNum2);
		btnNum2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (salvarImportacao()) {
					JOptionPane.showMessageDialog(null, "Informações salvas com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
					limpar();
				}

			}

		});

	}

	private void importarArquivo(String caminho) {

		arquivoImportado = new ImportacaoArquivo().lerArquivo("", caminho);

		if (arquivoImportado == null)
			return;

		modelO.limpar();
		modelD.limpar();
		modelP.limpar();

		txfCurso.setText(arquivoImportado.getHeader().get(0).getCurso());
		txfFaseI.setText(arquivoImportado.getHeader().get(0).getPeriodoInicial());
		txfFaseF.setText(arquivoImportado.getHeader().get(0).getPeriodoFinal());
		try {
			txfData.setText(new SimpleDateFormat("dd/MM/yyyy").format(new SimpleDateFormat("yyyyMMdd")
					.parse(arquivoImportado.getHeader().get(0).getDataProcessamento())));
		} catch (ParseException e) {
		}

		for (ResumoOperacao resumo : arquivoImportado.getResumos()) {

			modelO.addOperacao(resumo);

			for (ResumoDisciplina resumoDisciplina : resumo.getDisciplinas()) {

				modelD.addDisciplina(resumoDisciplina);

				for (ResumoProfessor resumoProfessor : resumoDisciplina.getProfessores()) {
					modelP.addProfessor(resumoProfessor);
				}
			}

		}

	}
	
	public boolean salvarImportacao() {
		
		CursosDAO cDao = new CursosDAO();
		FaseDAO fDao = new FaseDAO();
		ProfessorDAO pDao = new ProfessorDAO();
		DisciplinasDAO dDao = new DisciplinasDAO();
				
		try {
			Cursos c = new Cursos();
			
			c.setCdCurso(cDao.getMax());
			c.setNmCurso(arquivoImportado.getHeader().get(0).getCurso());
			
			if (cDao.salvar(c)) {
				
				c = cDao.existe(c);
				
				for (ResumoOperacao op : arquivoImportado.getResumos()) {
					
					Fases f = new Fases();
					
					f.setCdFase(fDao.getMax());
					f.setCurso(c);
					f.setNrFase(Integer.parseInt(op.getFase().substring(4, 7)));
					
					if (fDao.salvar(f)) {
						
						f = fDao.existe(f);
								
						for (ResumoDisciplina rD : op.getDisciplinas()) {
							
							List<Professores> professores = new ArrayList<Professores>();
							
							for (ResumoProfessor rP : rD.getProfessores()) {
								
								Professores p = new Professores();
								
								p.setCdProfessor(pDao.getMax());
								p.setNmProfessor(rP.getNomeProfessor());
								p.setTitulo(rP.getTituloDocente());
								
								if (pDao.salvar(p)) {
									p = pDao.existe(p);
									
									professores.add(p);
								}
								
							}
							
							Disciplinas d = new Disciplinas();
							
							d.setCdDisciplina(dDao.getMax());
							d.setMatricula(rD.getCodigoDisciplina());
							d.setDiaSemana(rD.getDiaSemana());
							d.setFase(f);
							d.setProfessores(professores);
							
							dDao.salvar(d);
						}
						
					}
					
				}
				
			}
			
			HeaderDAO hDao = new HeaderDAO();
			
			hDao.salvar(arquivoImportado.getHeader().get(0));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		
		return true;
	}
	
	public void limpar() {
		txfCurso.setText("");
		txfData.setText("");
		txfFaseF.setText("");
		txfFaseI.setText("");
		modelD.limpar();
		modelO.limpar();
		modelP.limpar();
		
	}

}
