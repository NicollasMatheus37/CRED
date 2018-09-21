package views;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import TableModel.AlunoTableModel;
import TableModel.UsuarioTableModel;
import database.dao.UsuariosDAO;
import database.model.Alunos;
import database.model.Usuarios;
import lib.ArquivoManipular;

public class BuscaUsuariosWindow extends JInternalFrame {

	// componentes
	private JTextField txfBuscar;
	private JButton btnBuscar;
	private JButton btnAtualizar;
	private JLabel lblDescricao;
	private List<Usuarios> listaUsuarios = new ArrayList<Usuarios>();
	private UsuarioTableModel model;
	private String[] buscar = { "Código", "Usuário" };
	private JComboBox comboBusca;

	ArquivoManipular am = new ArquivoManipular();

	public BuscaUsuariosWindow() {

		setSize(860, 550);

		setTitle("Tela Busca de Usuários");

		setLayout(null);

		setResizable(false);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		setClosable(true);

		setIconifiable(true);

		ComponentesCriar();

	}

	private void ComponentesCriar() {

		lblDescricao = new JLabel("Pesquisar por:");
		lblDescricao.setBounds(25, 25, 200, 25);
		getContentPane().add(lblDescricao);

		txfBuscar = new JTextField();
		txfBuscar.setBounds(250, 25, 350, 25);
		getContentPane().add(txfBuscar);
		txfBuscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent a) {

				zerarTodos();

				if (comboBusca.getSelectedItem().toString().equals("Código") && !txfBuscar.getText().equals("")) {
					try {
						Integer.parseInt(txfBuscar.getText());
					} catch (Exception e) {
						return;
					}
					model.addListaDeUsuarios(new UsuariosDAO().consultar(Integer.valueOf(txfBuscar.getText())));

				} else {

					if (comboBusca.getSelectedItem().toString().equals("Usuário") && !txfBuscar.getText().equals("")) {

						model.addListaDeUsuarios(new UsuariosDAO().consultar(txfBuscar.getText()));

					} else {
						mostrarTodos();
					}
				}
			}
		});

		comboBusca = new JComboBox(buscar);
		comboBusca.setSelectedIndex(0);
		comboBusca.setBounds(130, 25, 100, 25);
		getContentPane().add(comboBusca);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(625, 25, 90, 25);
		getContentPane().add(btnBuscar);
		btnBuscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent a) {

				zerarTodos();

				if (comboBusca.getSelectedItem().toString().equals("Código") && !txfBuscar.getText().equals("")) {
					try {
						Integer.parseInt(txfBuscar.getText());
					} catch (Exception e) {
						return;
					}
					model.addListaDeUsuarios(new UsuariosDAO().consultar(Integer.valueOf(txfBuscar.getText())));

				} else {

					if (comboBusca.getSelectedItem().toString().equals("Usuário") && !txfBuscar.getText().equals("")) {

						model.addListaDeUsuarios(new UsuariosDAO().consultar(txfBuscar.getText()));

					} else {
						mostrarTodos();
					}
				}
			}
		});
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(730, 25, 90, 25);
		getContentPane().add(btnAtualizar);
		btnAtualizar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent a) {

				zerarTodos();

				mostrarTodos();

				txfBuscar.setText("");

			}
		});

		JPanel painelFundo;

		painelFundo = new JPanel();
		painelFundo.setLayout(new GridLayout(1, 1));
		model = new UsuarioTableModel();

		JTable tabela = new JTable(model);
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane barraRolagem = new JScrollPane(tabela);
		painelFundo.add(barraRolagem);
		painelFundo.setBounds(25, 60, 800, 430);
		getContentPane().add(painelFundo);

		tabela.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {

				if (tabela.getSelectedRow() != -1) {
					String idSelecionado = tabela.getValueAt(tabela.getSelectedRow(), 0).toString();
				}
			}
		});

		mostrarTodos();

	}

	public static void main(String[] args) {

		new BuscaUsuariosWindow().setVisible(true);

	}

	public void mostrarTodos() {
		try {
			//// ??????????

			model.addListaDeUsuarios(new UsuariosDAO().consultar(false));
		} catch (Exception e) {
			System.err.printf("Erro: %s.\n", e.getMessage());
		}
	}

	public void zerarTodos() {
		model.limpar();
	}

}
