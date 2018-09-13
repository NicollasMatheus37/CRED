package views;

import java.awt.Color;
import java.awt.GridLayout;
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

public class BuscaUsuariosWindow extends JDialog{
	
	//componentes
	private JTextField txfBuscar;
	private JButton btnBuscar;
	private JLabel lblDescricao;
	private List<Usuarios> listaUsuarios = new ArrayList<Usuarios>();
	private UsuarioTableModel model;
	ArquivoManipular am = new ArquivoManipular();

	
	public BuscaUsuariosWindow() {
		
			
		// Define o tamanho da janela.
		setSize(1000,600);	
					
					
		// Define o titulo da janela.
		setTitle("Tela Busca de Alunos");
			
		// Seta o layout a ser utilizado (NULL significa que não irá utilizar nenhum).
		setLayout(null);
			
		// Define que não poderá ser alterado as dimensões da tela.
		setResizable(false);
			
		// Define o método de fechamento da janela.
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//		setClosable(true);
//		setIconifiable(true);
		// Cria os componentes.
		ComponentesCriar();
		
	}
	private void ComponentesCriar() {
		

		lblDescricao = new JLabel("Pesquisar :");
		lblDescricao.setBounds(25, 25, 200, 25);
		getContentPane().add(lblDescricao);
		
		txfBuscar = new JTextField();
		txfBuscar.setBounds(100,25,350,25);
		getContentPane().add(txfBuscar);
	
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(460, 25, 100, 25);
		getContentPane().add(btnBuscar);
		
		
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
        
        
        try {
        	////??????????
			
			model.addListaDeUsuarios(new UsuariosDAO().consultar(false));
		} catch (Exception e) {
			System.err.printf("Erro: %s.\n", e.getMessage());
		}
        
		
	}
	public static void main(String[] args) {
		
		new BuscaUsuariosWindow().setVisible(true);

	}

}
