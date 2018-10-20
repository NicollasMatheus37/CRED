package TableModel;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import database.model.*;
import database.model.importation.ResumoOperacao;

public class OperacaoTableModel extends AbstractTableModel {
	private static final long serialVersionUID = -3586211638575736174L;

	private List<ResumoOperacao> operacoes;
	private String[] colunas = new String[] { "Fase", "N° de Disciplinas", "N° de Professores"};

	public OperacaoTableModel(List<ResumoOperacao> operacoes) {
		this.operacoes = operacoes;
	}

	public OperacaoTableModel() {
		this.operacoes = new ArrayList<ResumoOperacao>();
	}

	public int getRowCount() {
		return operacoes.size();
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

	public void setValueAt(ResumoOperacao aValue, int rowIndex) {
		ResumoOperacao operacao = operacoes.get(rowIndex);

		operacao.setFase(aValue.getFase());
		operacao.setQuantidadeDisciplina(aValue.getQuantidadeDisciplina());
		operacao.setQuantidadeProfessor(aValue.getQuantidadeProfessor());
		

		fireTableCellUpdated(rowIndex, 0);
		fireTableCellUpdated(rowIndex, 1);
		fireTableCellUpdated(rowIndex, 2);
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		ResumoOperacao operacao = operacoes.get(rowIndex);

		switch (columnIndex) {
		case 0:
			operacao.setFase(aValue.toString());
		case 1:
			operacao.setQuantidadeDisciplina(Integer.parseInt(aValue.toString()));
		case 2:
			operacao.setQuantidadeProfessor(Integer.parseInt(aValue.toString()));
		default:
			System.err.println("Índice da coluna inválido");
		}
		fireTableCellUpdated(rowIndex, columnIndex);
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		ResumoOperacao operacaoSelecionado = operacoes.get(rowIndex);
		String valueObject = null;
		switch (columnIndex) {
			case 0: valueObject = operacaoSelecionado.getFase();break;
			case 1:valueObject = Integer.toString(operacaoSelecionado.getQuantidadeDisciplina());break;
			case 2:valueObject = Integer.toString(operacaoSelecionado.getQuantidadeProfessor());break;
			default: System.err.println("Índice inválido para propriedade do bean ResumoOperacao.class");
		}

		return valueObject;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public ResumoOperacao getOperacao(int indiceLinha) {
		return operacoes.get(indiceLinha);
	}

	public void addOperacao(ResumoOperacao u) {
		operacoes.add(u);

		int ultimoIndice = getRowCount() - 1;

		fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}

	public void removeOperacao(int indiceLinha) {
		operacoes.remove(indiceLinha);

		fireTableRowsDeleted(indiceLinha, indiceLinha);
	}

	public void addListaDeResumoOperacao(List<ResumoOperacao> novosResumoOperacao) {

		int tamanhoAntigo = getRowCount();
		operacoes.addAll(novosResumoOperacao);
		fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
	}

	public void limpar() {
		operacoes.clear();
		fireTableDataChanged();
	}

	public boolean isEmpty() {
		return operacoes.isEmpty();
	}

}
