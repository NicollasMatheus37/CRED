package resources.views;

import java.awt.Color;
import java.awt.GridLayout;

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
import javax.swing.table.DefaultTableModel;

public class FBuscarAlunos extends JDialog{
	
	//componentes
	private JTextField txfBuscar;
	private JButton btnBuscar;
	private JLabel lblDescricao;
	
	private String[] buscar = {"Código","Nome"};
	private String[] colunas = {"Código", "Nome", "Data de Nascimento", "UF", "Cidade", "Telefone", "Celular"};
	Object [][] dados = {
		    {"1", "Mauricio de Cabrau de Oliveira", "11/11/11","RS","Travesseiro","4835341113", "48999554433"},
		    {"1", "Mauricio de Cabrau", "11/11/11","RS","Travesseiro","4835341113", "48999554433"},
		    {"1", "Mauricio de Cabrau", "11/11/11","RS","Travesseiro","4835341113", "48999554433"},
		    {"1", "Mauricio de Cabrau", "11/11/11","RS","Travesseiro","4835341113", "48999554433"},
		    {"1", "Mauricio de Cabrau", "11/11/11","RS","Travesseiro","4835341113", "48999554433"},
		    {"1", "Mauricio de Cabrau", "11/11/11","RS","Travesseiro","4835341113", "48999554433"}
		};

	private DefaultTableModel model;
	
	public FBuscarAlunos() {
		
			
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
        
        model = new DefaultTableModel(dados, colunas);
        
        JTable tabela = new JTable(model);
      tabela.setCellSelectionEnabled(false);
        JScrollPane barraRolagem = new JScrollPane(tabela);
        painelFundo.add(barraRolagem); 
        painelFundo.setBounds(25, 60, 800, 430);
        getContentPane().add(painelFundo);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
       
//        setVisible(true);
//		
//		JTable tabela = new JTable(dados, colunas);
//		
//		JScrollPane scrollPane= new  JScrollPane(tabela);
////		.add(scrollPane);
//		getContentPane().add(scrollPane);


//		telacheia = new JPanel();
//		telacheia.setBounds(0,0,500,300);
//		telacheia.setBackground(Color.decode("#C0C0C0"));
//		getContentPane().add(telacheia);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new FBuscarAlunos().setVisible(true);
		
	}

}
