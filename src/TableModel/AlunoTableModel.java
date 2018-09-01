package TableModel;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import database.model.*;

public class AlunoTableModel extends AbstractTableModel {
	private static final long serialVersionUID = -3586211638575736174L;

	private List<Alunos> alunos;
	private String[] colunas = new String[] { "ID", "Código", "Nome", "Email" };

	public AlunoTableModel(List<Alunos> alunos) {
		this.alunos = alunos;
	}

	public AlunoTableModel() {
		this.alunos = new ArrayList<Alunos>();
	}

	public int getRowCount() {
		return alunos.size();
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

	public void setValueAt(Alunos aValue, int rowIndex) {
		Alunos aluno = alunos.get(rowIndex);

		aluno.setCdAluno(aValue.getCdAluno());
		aluno.setAluno(aValue.getAluno());
		aluno.setEmail(aValue.getEmail());
		aluno.setTelefone(aValue.getTelefone());
		aluno.setCelular(aValue.getCelular());

		fireTableCellUpdated(rowIndex, 0);
		fireTableCellUpdated(rowIndex, 1);
		fireTableCellUpdated(rowIndex, 2);
		fireTableCellUpdated(rowIndex, 3);
		fireTableCellUpdated(rowIndex, 3);
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Alunos aluno = alunos.get(rowIndex);

		switch (columnIndex) {
		case 0:
			aluno.setCdAluno(Integer.parseInt(aValue.toString()));
		case 1:
			aluno.setAluno(aValue.toString());
		case 2:
			aluno.setEmail(aValue.toString());
		case 3:
			aluno.setTelefone(aValue.toString());
		case 4:
			aluno.setCelular(aValue.toString());
		default:
			System.err.println("Índice da coluna inválido");
		}
		fireTableCellUpdated(rowIndex, columnIndex);
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Alunos alunoSelecionado = alunos.get(rowIndex);
		String valueObject = null;
		switch (columnIndex) {
		case 0:
			valueObject = alunoSelecionado.getCdAluno().toString();
			break;
		case 1:
			valueObject = alunoSelecionado.getAluno();
			break;
		case 2:
			valueObject = alunoSelecionado.getEmail();
			break;
		case 3:
			valueObject = alunoSelecionado.getTelefone();
			break;
		case 4:
			valueObject = alunoSelecionado.getCelular();
			break;
		default:
			System.err.println("Índice inválido para propriedade do bean Alunos.class");
		}

		return valueObject;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public Alunos getAluno(int indiceLinha) {
		return alunos.get(indiceLinha);
	}

	public void addAluno(Alunos u) {
		alunos.add(u);

		int ultimoIndice = getRowCount() - 1;

		fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}

	public void removeAluno(int indiceLinha) {
		alunos.remove(indiceLinha);

		fireTableRowsDeleted(indiceLinha, indiceLinha);
	}

	public void addListaDeAlunos(List<Alunos> novosAlunos) {

		int tamanhoAntigo = getRowCount();
		alunos.addAll(novosAlunos);
		fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
	}

	public void limpar() {
		alunos.clear();
		fireTableDataChanged();
	}

	public boolean isEmpty() {
		return alunos.isEmpty();
	}

}
