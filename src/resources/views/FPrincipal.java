package resources.views;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.HierarchyBoundsListener;
import java.awt.event.HierarchyEvent;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class FPrincipal extends JFrame {

	JDesktopPane desktopPane;
	JMenuBar menuBar;
	JMenu menuCadastro;
	JMenuItem itemCadastroUsuario;

	public FPrincipal() {
		// Define o tamanho da janela.
		setSize(800, 600);
		setMinimumSize(new Dimension(800, 600));
		setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH);

		// Define o titulo da janela.
		setTitle("Menu Principal");

		// Seta o layout a ser utilizado (NULL significa que não irá utilizar nenhum).
		setLayout(null);

		// Define que não poderá ser alterado as dimensões da tela.
		setResizable(true);

		// Define o método de fechamento da janela.
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBackground(Color.black);

		setLocationRelativeTo(null);
		
		criarComponentes();
	}
	
	private void criarComponentes() {
		
		desktopPane = new JDesktopPane();
//		desktopPane.setSize(800,600);
		desktopPane.addHierarchyBoundsListener(new HierarchyBoundsListener() {
			
			@Override
			public void ancestorResized(HierarchyEvent arg0) {
				Dimension d = getSize();
				d.setSize(d.getWidth() - 20, d.getHeight() - 60);
				desktopPane.setSize(d);				
			}
			
			@Override
			public void ancestorMoved(HierarchyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		menuBar = new JMenuBar();
		
		menuCadastro = new JMenu("Cadastro");
		
		itemCadastroUsuario = new JMenuItem("Usuário");
		itemCadastroUsuario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FUsuario al = new FUsuario();
				al.setLocation(1, 1);
				desktopPane.add(al);
				al.setVisible(true);
				
			}
		});
		
		menuCadastro.add(itemCadastroUsuario);
		
		menuBar.add(menuCadastro);
		
		setJMenuBar(menuBar);
		add(desktopPane);
		
	}

}
