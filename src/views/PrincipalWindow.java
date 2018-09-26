package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.HierarchyBoundsListener;
import java.awt.event.HierarchyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import database.model.Usuarios;

public class PrincipalWindow extends JFrame {

	JDesktopPane desktopPane;
	JMenuBar menuBar;
	JMenu menuCadastro;
	JMenu menuBusca;
	JMenuItem itemCadastroAluno;
	JMenuItem itemBuscaAluno;
	JMenuItem itemCadastroUsuario;
	JMenuItem itemBuscaUsuario;
	JMenuItem itemCadastroDisciplina;
	JMenuItem itemCadastroProfessores;
	JMenuItem itemCadastroFase;
	JLabel lbUsuarioHora;

	public PrincipalWindow() {
		// Define o tamanho da janela.
		setSize(800, 600);
		setMinimumSize(new Dimension(800, 600));
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);

		// Define o titulo da janela.
		setTitle("Menu Principal");

		// Seta o layout a ser utilizado (NULL significa que não irá utilizar nenhum).
		setLayout(null);

		// Define que não poderá ser alterado as dimensões da tela.
		setResizable(true);

		// Define o método de fechamento da janela.
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBackground(Color.black);

		setLocationRelativeTo(null);

		criarComponentes();
	}

	private void criarComponentes() {

		lbUsuarioHora = new JLabel("asd", JLabel.RIGHT);
		lbUsuarioHora.addHierarchyBoundsListener(new HierarchyBoundsListener() {

			@Override
			public void ancestorResized(HierarchyEvent e) {
				Dimension d = getSize();
				lbUsuarioHora.setBounds(((int) d.getWidth()) - 370, ((int) d.getHeight()) - 85, 350, 20);
			}

			@Override
			public void ancestorMoved(HierarchyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		new Thread(new Runnable() {

			@Override
			public void run() {

				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

				String usuario = "";
				String hora = "";

				usuario = Usuarios.getUsuarioLogin().getUsuario();

				if (usuario.length() > 20) {
					usuario = usuario.substring(0, 20) + "...";
				}

				usuario += " (" + Usuarios.getUsuarioLogin().getCdUsuario() + ")";

				try {

					while (!Thread.currentThread().isInterrupted()) {

						hora = format.format(new Date());
						lbUsuarioHora.setText(usuario + "    " + hora);

						Thread.sleep(1000);
					}

				} catch (Exception e) {

				}

			}
		}).start();

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
		menuBusca = new JMenu("Busca");

		itemCadastroAluno = new JMenuItem("Aluno");
		itemCadastroAluno.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AlunoWindow al = new AlunoWindow();
				al.setLocation(1, 1);
				desktopPane.add(al);
				al.setVisible(true);

			}
		});

		menuCadastro.add(itemCadastroAluno);
		
		
		itemCadastroFase = new JMenuItem("Fase");
		itemCadastroFase.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CadastroFaseWindow fase = new CadastroFaseWindow();
				fase.setLocation(1, 1);
				desktopPane.add(fase);
				fase.setVisible(true);

			}
		});
		menuCadastro.add(itemCadastroFase);
		
		itemCadastroDisciplina = new JMenuItem("Disciplina");
		
		itemCadastroDisciplina.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CadastroDisciplinaWindow disciplina = new CadastroDisciplinaWindow();
				disciplina.setLocation(1, 1);
				desktopPane.add(disciplina);
				disciplina.setVisible(true);

			}
		});
		menuCadastro.add(itemCadastroDisciplina);
		
		
		itemCadastroProfessores = new JMenuItem("Professores");
		itemCadastroProfessores.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CadastroProfessoresWindow professores = new CadastroProfessoresWindow();
				professores.setLocation(1, 1);
				desktopPane.add(professores);
				professores.setVisible(true);

			}
		});
		menuCadastro.add(itemCadastroProfessores);
		
		itemCadastroUsuario = new JMenuItem("Usuário");
		itemCadastroUsuario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				abrirCadastroUsuario();

			}
		});
		
//		itemCadastroDisciplina = new JMenuItem("Disciplina");
		

		if (!Usuarios.getUsuarioLogin().getPerfil().equals("Convidado")) {
			menuCadastro.add(itemCadastroUsuario);
		}

		itemBuscaAluno = new JMenuItem("Aluno");
		itemBuscaAluno.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				abrirBuscaAluno();

			}
		});
		

		itemBuscaUsuario = new JMenuItem("Usuário");
		itemBuscaUsuario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				abrirBuscaUsuario();
			}
		});

		menuBusca.add(itemBuscaAluno);
		if (!Usuarios.getUsuarioLogin().getPerfil().equals("Convidado")) {
			menuBusca.add(itemBuscaUsuario);
		}
		

		menuBar.add(menuCadastro);
		menuBar.add(menuBusca);

		setJMenuBar(menuBar);
		desktopPane.add(lbUsuarioHora);
		add(desktopPane);

	}
	
	public void abrirBuscaUsuario() {
		BuscaUsuariosWindow usu = new BuscaUsuariosWindow(this);
		usu.setLocation(1, 1);
		desktopPane.add(usu);
		usu.setVisible(true);
	}
	
	public UsuarioWindow abrirCadastroUsuario() {
//		if (!Usuarios.getUsuarioLogin().getPerfil().equals("Convidado")) {
			UsuarioWindow usu = new UsuarioWindow();
			usu.setLocation(1, 1);
			desktopPane.add(usu);
			usu.setVisible(true);
			return usu;
//		}
//	
//		return null;
	}
	
	public void abrirBuscaAluno() {
		BuscaAlunoWindow al = new BuscaAlunoWindow(this);
		al.setLocation(1, 1);
		desktopPane.add(al);
		al.setVisible(true);
	}
	
	public AlunoWindow abrirCadastroAluno() {
//		if (!Usuarios.getUsuarioLogin().getPerfil().equals("Convidado")) {
			AlunoWindow al = new AlunoWindow();
			al.setLocation(1, 1);
			desktopPane.add(al);
			al.setVisible(true);
			return al;
//		}
//	
//		return null;
	}
}
