package TableModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

import database.model.importation.ResumoProfessor;
import hashmap.HashMaps;

public class ProfessorTableModel extends AbstractTableModel {
	private static final long serialVersionUID = -3586211638575736174L;

	//odeio essa merda de merge conflict
	private List<ResumoProfessor> professores;
	private String[] colunas = new String[] { "Nome", "Titulo Docente"};
	 
	public String mapTituloDocente(String num) {
		String resultado = null;
	   
		 Map<String, String> mapQualificao = new HashMap<String, String>(); 
		    mapQualificao.put("01", "Pós-Graduação");
		    mapQualificao.put("02", "Mestrado");
		    mapQualificao.put("03", "Doutorado");
		    mapQualificao.put("04", "Pós-Doutorado");
		
		
		return resultado = mapQualificao.get(num);
	}
	
	public ResumoProfessor getObjectAt(int rowIndex) {
		return professores.get(rowIndex);
	}

	public ProfessorTableModel(List<ResumoProfessor> professores) {
		this.professores = professores;
	}

	public ProfessorTableModel() {
		this.professores = new ArrayList<ResumoProfessor>();
	}

	public int getRowCount() {
		return professores.size();
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

	public void setValueAt(ResumoProfessor aValue, int rowIndex) {
		ResumoProfessor operacao = professores.get(rowIndex);

		operacao.setNomeProfessor(aValue.getNomeProfessor());
		operacao.setTituloDocente(aValue.getTituloDocente());
		

		fireTableCellUpdated(rowIndex, 0);
		fireTableCellUpdated(rowIndex, 1);
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		ResumoProfessor operacao = professores.get(rowIndex);

		switch (columnIndex) {
		case 0:
			operacao.setNomeProfessor(aValue.toString());
		case 1:
			operacao.setTituloDocente(aValue.toString());
		default:
			System.err.println("Índice da coluna inválido");
		}
		fireTableCellUpdated(rowIndex, columnIndex);
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		ResumoProfessor operacaoSelecionado = professores.get(rowIndex);
		HashMaps hm = new HashMaps();
		
		String valueObject = null;
		
		switch (columnIndex) {
			case 0: valueObject = operacaoSelecionado.getNomeProfessor();break;
			case 1:valueObject = hm.getMapQualificao().get(operacaoSelecionado.getTituloDocente());break;
			default: System.err.println("Índice inválido para propriedade do bean ResumoProfessor.class");
		}

		return valueObject;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public ResumoProfessor getProfessor(int indiceLinha) {
		return professores.get(indiceLinha);
	}

	public void addProfessor(ResumoProfessor u) {
		professores.add(u);

		int ultimoIndice = getRowCount() - 1;

		fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}

	public void removeProfessor(int indiceLinha) {
		professores.remove(indiceLinha);

		fireTableRowsDeleted(indiceLinha, indiceLinha);
	}

	public void addListaDeResumoProfessor(List<ResumoProfessor> novosResumoProfessor) {

		int tamanhoAntigo = getRowCount();
		professores.addAll(novosResumoProfessor);
		fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
	}

	public void limpar() {
		professores.clear();
		fireTableDataChanged();
	}

	public boolean isEmpty() {
		return professores.isEmpty();
	}

}
