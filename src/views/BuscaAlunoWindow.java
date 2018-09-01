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
import database.model.Alunos;
import lib.ArquivoManipular;

public class BuscaAlunoWindow extends JInternalFrame{
	
	//componentes
	private JTextField txfBuscar;
	private JButton btnBuscar;
	private JLabel lblDescricao;
	private List<Alunos> listaAlunos = new ArrayList<Alunos>();
	private String[] buscar = {"Código","Nome"};
	private AlunoTableModel model;
	ArquivoManipular am = new ArquivoManipular();

	
	public BuscaAlunoWindow() {
		
			
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
		

		lblDescricao = new JLabel("Pesquisar por:");
		lblDescricao.setBounds(25, 25, 200, 25);
		getContentPane().add(lblDescricao);
		
		txfBuscar = new JTextField();
		txfBuscar.setBounds(250,25,350,25);
		getContentPane().add(txfBuscar);
		
		
		JComboBox comboBusca = new JComboBox(buscar);
		comboBusca.setSelectedIndex(0);
		comboBusca.setBounds(130,25,100,25);
		getContentPane().add(comboBusca);
		
		
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(625, 25, 100, 25);
		getContentPane().add(btnBuscar);
		
		
		JPanel painelFundo;
		
		painelFundo = new JPanel();
        painelFundo.setLayout(new GridLayout(1, 1));

        
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
			
			model.addListaDeAlunos(listaAlunos);
		} catch (Exception e) {
			System.err.printf("Erro: %s.\n", e.getMessage());
		}
        
		
	}

}
