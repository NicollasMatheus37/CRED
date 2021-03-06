package TableModel;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import database.model.*;

public class UsuarioTableModel extends AbstractTableModel {


	private List<Usuarios> usuarios;
	private String[] colunas = new String[] { "C�digo", "Usuario", "Perfil" };

	public UsuarioTableModel(List<Usuarios> usuarios) {
		this.usuarios = usuarios;
	}

	public UsuarioTableModel() {
		this.usuarios = new ArrayList<Usuarios>();
	}

	public int getRowCount() {
		return usuarios.size();
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

	public void setValueAt(Usuarios aValue, int rowIndex) {
		Usuarios usuario = usuarios.get(rowIndex);

		usuario.setCdUsuario(aValue.getCdUsuario());
		usuario.setUsuario(aValue.getUsuario());
		usuario.setPerfil(aValue.getPerfil());
		fireTableCellUpdated(rowIndex, 0);
		fireTableCellUpdated(rowIndex, 1);
		fireTableCellUpdated(rowIndex, 2);
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Usuarios usuario = usuarios.get(rowIndex);

		switch (columnIndex) {
		case 0:
			usuario.setCdUsuario(Integer.parseInt(aValue.toString()));
		case 1:
			usuario.setUsuario(aValue.toString());
		case 2:
			usuario.setPerfil(aValue.toString());
		default:
			System.err.println("�ndice da coluna inv�lido");
		}
		fireTableCellUpdated(rowIndex, columnIndex);
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Usuarios usuarioSelecionado = usuarios.get(rowIndex);
		String valueObject = null;
		switch (columnIndex) {
		case 0:
			valueObject = usuarioSelecionado.getCdUsuario().toString();
			break;
		case 1:
			valueObject = usuarioSelecionado.getUsuario();
			break;
		case 2:
			valueObject = usuarioSelecionado.getPerfil();
			break;
		default:
			System.err.println("�ndice inv�lido para propriedade do bean Usuarios.class");
		}

		return valueObject;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public Usuarios getUsuario(int indiceLinha) {
		return usuarios.get(indiceLinha);
	}

	public void addUsuario(Usuarios u) {
		usuarios.add(u);

		int ultimoIndice = getRowCount() - 1;

		fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}

	public void removeUsuario(int indiceLinha) {
		usuarios.remove(indiceLinha);

		fireTableRowsDeleted(indiceLinha, indiceLinha);
	}

	public void addListaDeUsuarios(List<Usuarios> novosUsuarios) {

		int tamanhoAntigo = getRowCount();
		usuarios.addAll(novosUsuarios);
		fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
	}
	

	public void limpar() {
		usuarios.clear();
		fireTableDataChanged();
	}

	public boolean isEmpty() {
		return usuarios.isEmpty();
	}

}
