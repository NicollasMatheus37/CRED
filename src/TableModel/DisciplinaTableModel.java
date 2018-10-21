package TableModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

import database.model.importation.ResumoDisciplina;
import database.model.importation.ResumoOperacao;
import hashmap.HashMaps;
//odeio essa merda de merge conflict
public class DisciplinaTableModel extends AbstractTableModel {
	private static final long serialVersionUID = -3586211638575736174L;

	private List<ResumoDisciplina> disciplinas;
	private String[] colunas = new String[] { "Disciplina", "Dia da Semana", "N� de Professores",};
 
	public DisciplinaTableModel(List<ResumoDisciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	public String mapDisciplinas(String num) {
		String resultado = null;
		Map<String, String> mapDisciplinas = new HashMap<String, String>(); 
	    mapDisciplinas.put("10850", "Algoritmos");
	    mapDisciplinas.put("10851", "Introdu��o a Ci�ncia da Computa��o");
	    mapDisciplinas.put("10854", "Fundamentos Matem�ticos para Computa��o");
	    mapDisciplinas.put("10852", "Metodologia Cient�fica e da Pesquisa");
	    mapDisciplinas.put("10853", "Produ��o e Interpreta��o de Textos");
	    mapDisciplinas.put("10858", "C�lculo I");
	    mapDisciplinas.put("10857", "Filosofia");
	    mapDisciplinas.put("10856", "F�sica Aplicada");
	    mapDisciplinas.put("10855", "L�gica para Computa��o");
	    mapDisciplinas.put("10859", "Programa��o I");
	    mapDisciplinas.put("10860", "C�lculo II");
	    mapDisciplinas.put("10862", "Circuitos Digitais");
	    mapDisciplinas.put("10863", "Estat�stica e Probabilidade");
	    mapDisciplinas.put("10864", "Estrutura de Dados I");
	    mapDisciplinas.put("10861", "Programa��o II");
	    mapDisciplinas.put("10865", "Projeto Interdisciplinar da Computa��o I");
	    mapDisciplinas.put("10868", "An�lise de Algoritmos");
	    mapDisciplinas.put("10869", "Arquitetura e Organiza��o de Computadores");
	    mapDisciplinas.put("10870", "C�lculo Num�rico");
	    mapDisciplinas.put("10866", "Estrutura de Dados II");
	    mapDisciplinas.put("10867", "Projeto Interdisciplinar da Computa��o II");
	    mapDisciplinas.put("10871", "Teoria dos Grafos");
	    mapDisciplinas.put("10875", "Banco de Dados I");
	    mapDisciplinas.put("10876", "Engenharia de Software I");
	    mapDisciplinas.put("10873", "Linguagens Formais");
	    mapDisciplinas.put("10872", "Sistemas Operacionais");
	    mapDisciplinas.put("10874", "T�picos Especiais I");
	    mapDisciplinas.put("10877", "Banco de Dados II");
	    mapDisciplinas.put("10879", "Compiladores");
	    mapDisciplinas.put("10880", "Comunica��o de Dados");
	    mapDisciplinas.put("10878", "Engenharia de Software II");
	    mapDisciplinas.put("10881", "Teoria da Computa��o");
	    mapDisciplinas.put("10886", "Administra��o Empresarial");
	    mapDisciplinas.put("10884", "Computa��o Gr�fica");
	    mapDisciplinas.put("10883", "Computa��o Paralela e Distribu�da");
	    mapDisciplinas.put("10885", "Intelig�ncia Artificial");
	    mapDisciplinas.put("10882", "Redes de Computadores");
	    mapDisciplinas.put("10887", "Trabalho de Conclus�o de Curso - TCC I");
	    mapDisciplinas.put("10891", "Empreendedorismo");
	    mapDisciplinas.put("10890", "Gest�o de Sistemas de Informa��o");
	    mapDisciplinas.put("10892", "Optativa I");
	    mapDisciplinas.put("10888", "T�picos Especiais II");
	    mapDisciplinas.put("10889", "Trabalho de Conclus�o de Curso - TCC II");
	    mapDisciplinas.put("10895", "Optativa II");
	    mapDisciplinas.put("10893", "T�picos Especiais III");
	    mapDisciplinas.put("10894", "Trabalho de Conclus�o de Curso - TCC III");
		
		
		return resultado = mapDisciplinas.get(num);
	}
	public String mapDiaSemana(String num) {
		String resultado = null;
	   
	    Map<String, String> mapDiasSemana = new HashMap<String, String>(); 
	    mapDiasSemana.put("01", "Domingo");
	    mapDiasSemana.put("02", "Segunda-Feira");
	    mapDiasSemana.put("03", "Ter�a-Feira");
	    mapDiasSemana.put("04", "Quarta-Feira");
	    mapDiasSemana.put("05", "Quinta-Feira");
	    mapDiasSemana.put("06", "Sexta-Feira");
	    mapDiasSemana.put("07", "Sabado");
		
		
		return resultado = mapDiasSemana.get(num);
	}

	public ResumoDisciplina getObjectAt(int rowIndex) {
		return disciplinas.get(rowIndex);
	}
	
	public DisciplinaTableModel() {
		this.disciplinas = new ArrayList<ResumoDisciplina>();
	}

	public int getRowCount() {
		return disciplinas.size();
	}

	public int getColumnCount() {
		return colunas.length;
	}

	public String getColumnName(int columnIndex) {
		return colunas[columnIndex];
	}

	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	public void setValueAt(ResumoDisciplina aValue, int rowIndex) {
		ResumoDisciplina disciplina = disciplinas.get(rowIndex);

		disciplina.setCodigoDisciplina(aValue.getCodigoDisciplina());
		disciplina.setDiaSemana(aValue.getDiaSemana());
		disciplina.setQuantidadeProfessor(aValue.getQuantidadeProfessor());
		

		fireTableCellUpdated(rowIndex, 0);
		fireTableCellUpdated(rowIndex, 1);
		fireTableCellUpdated(rowIndex, 2);
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		ResumoDisciplina disciplina = disciplinas.get(rowIndex);

		switch (columnIndex) {
		case 0:
			disciplina.setCodigoDisciplina((aValue.toString()));
		case 1:
			disciplina.setDiaSemana(aValue.toString());
		case 2:
			disciplina.setQuantidadeProfessor(aValue.toString());
		default:
			System.err.println("�ndice da coluna inv�lido");
		}
		fireTableCellUpdated(rowIndex, columnIndex);
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		ResumoDisciplina disciplinaSelecionado = disciplinas.get(rowIndex);
		HashMaps hm = new HashMaps();
		String valueObject = null;
		switch (columnIndex) {
		case 0:
			valueObject = hm.getMapDisciplinas().get(String.valueOf(Integer.valueOf(disciplinaSelecionado.getCodigoDisciplina())));
			break;
		case 1:
			valueObject = hm.getMapDiasSemana().get(disciplinaSelecionado.getDiaSemana());
			break;
		case 2:
			valueObject = disciplinaSelecionado.getQuantidadeProfessor();
			break;
		default:
			System.err.println("�ndice inv�lido para propriedade do bean ResumoDisciplina.class");
		}

		return valueObject;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public ResumoDisciplina getDisciplina(int indiceLinha) {
		return disciplinas.get(indiceLinha);
	}

	public void addDisciplina(ResumoDisciplina u) {
		
		disciplinas.add(u);

		int ultimoIndice = getRowCount() - 1;

		fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}

	public void removeDisciplina(int indiceLinha) {
		disciplinas.remove(indiceLinha);

		fireTableRowsDeleted(indiceLinha, indiceLinha);
	}

	public void addListaDeResumoDisciplina(List<ResumoDisciplina> novosResumoDisciplina) {

		int tamanhoAntigo = getRowCount();
		disciplinas.addAll(novosResumoDisciplina);
		fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
	}

	public void limpar() {
		disciplinas.clear();
		fireTableDataChanged();
	}

	public boolean isEmpty() {
		return disciplinas.isEmpty();
	}

}
