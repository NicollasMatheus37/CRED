package lib;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import database.model.importation.Arquivo;
import database.model.importation.Header;
import database.model.importation.ResumoDisciplina;
import database.model.importation.ResumoOperacao;
import database.model.importation.ResumoProfessor;
import database.model.importation.Trailer;
import hashmap.HashMaps;
import util.FileUtil;

public class ImportacaoArquivo {

	private final static byte HEADER = 0;
	private final static byte RESUMOOPERACAO = 1;
	private final static byte RESUMODISCIPLINA = 2;
	private final static byte RESUMOPROFESSORES = 3;
	private final static byte TRAILER = 9;

	public Header interpretarHeader(String string, int linha) {

		Header h = new Header();

		h.setTipoRegistro(HEADER);
		h.setCurso(string.substring(1, 11));
		h.setDataProcessamento(string.substring(11, 19));
		h.setPeriodoInicial(string.substring(19, 26));
		h.setPeriodoFinal(string.substring(26, 33));
		h.setSequencia(Integer.parseInt(string.substring(33, 40)));
		h.setVersaoLayout(string.substring(40, 43));

		h.setLinha(linha);

		return h;
	}

	public ResumoOperacao interpretarResumoOperacao(String string, int linha) {

		ResumoOperacao ro = new ResumoOperacao();

		ro.setTipoRegistro(RESUMOOPERACAO);
		ro.setFase(string.substring(1, 8));
		ro.setQuantidadeDisciplina(Integer.valueOf(string.substring(8, 10)));
		ro.setQuantidadeProfessor(Integer.valueOf(string.substring(10, 12)));

		ro.setLinha(linha);

		return ro;
	}

	public ResumoDisciplina interpretarResumoDisciplina(String string, int linha) {

		ResumoDisciplina rd = new ResumoDisciplina();

		rd.setTipoRegistro(RESUMODISCIPLINA);
		rd.setCodigoDisciplina(string.substring(1, 7));
		rd.setDiaSemana(Integer.valueOf(string.substring(7, 9)));
		rd.setQuantidadeProfessor(Integer.valueOf(string.substring(9, 11)));

		rd.setLinha(linha);

		return rd;
	}

	public ResumoProfessor interpretarResumoProfessor(String string, int linha) {

		ResumoProfessor rp = new ResumoProfessor();

		rp.setTipoRegistro(RESUMOPROFESSORES);
		rp.setNomeProfessor(string.substring(1, 40));
		rp.setTituloDocente(Integer.valueOf(string.substring(40, 42)));

		rp.setLinha(linha);

		return rp;
	}

	public Trailer interpretarTrailer(String string, int linha) {

		Trailer t = new Trailer();

		t.setTipoRegistro(TRAILER);
		t.setTotalRegistro(Integer.valueOf(string.substring(1, 12)));

		t.setLinha(linha);

		return t;
	}

	public Arquivo lerArquivo(String caminho, String nome) {

		Arquivo arquivo = new Arquivo();
		int i = 0;

		try {
			List<Header> headers = new ArrayList<Header>();
			List<ResumoOperacao> resumos = new ArrayList<ResumoOperacao>();
			List<Trailer> trailers = new ArrayList<Trailer>();

			FileUtil file = new FileUtil();

			if (!file.readFile(caminho, nome))
				return null;

			while (file.hasNext()) {
				i++;
				String linha = file.next();
				int ultimoRegistro = resumos.size() - 1;

				switch (linha.charAt(0)) {

				case HEADER:

					if (!validarHeader(linha))
						return null;

					headers.add(interpretarHeader(linha, i));
					break;

				case RESUMOOPERACAO:

					if (!validarResumoOperacao(linha))
						return null;

					resumos.add(interpretarResumoOperacao(linha, i));
					break;

				case RESUMODISCIPLINA:

					if (!validarResumoDisciplina(linha))
						return null;

					resumos.get(ultimoRegistro).getDisciplinas().add(interpretarResumoDisciplina(linha, i));
					break;

				case RESUMOPROFESSORES:

					if (resumos.get(ultimoRegistro).getDisciplinas().isEmpty()) {
						throw new Exception("Resumo de Operação não possúi disciplinas\nLinha"
								+ resumos.get(ultimoRegistro).getLinha());
					}

					if (!validarResumoProfessor(linha))
						return null;

					resumos.get(ultimoRegistro).getDisciplinas()
							.get(resumos.get(ultimoRegistro).getDisciplinas().size() - 1).getProfessores()
							.add(interpretarResumoProfessor(linha, i));
					break;

				case TRAILER:

					if (!validarTrailer(linha))
						return null;

					trailers.add(interpretarTrailer(linha, i));
					break;
				}
			}

			file.close();

			arquivo.setHeader(headers);
			arquivo.setResumos(resumos);
			arquivo.setTrailer(trailers);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			return null;
		}

		return validarArquivo(arquivo) ? arquivo : null;

	}

	public boolean validarHeader(String header) {

		if (header.length() != 45) {
			JOptionPane.showMessageDialog(null,
					"HEADER\n O tamanho encontrado (" + header.length() + ") difere do esperado (45)", "Erro",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		try {
			new SimpleDateFormat("yyyyMMdd").format(header.substring(11, 19));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "HEADER - Data de Processamento\n Não foi possível converter '"
					+ header.substring(11, 19) + "' para uma data válida", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		try {
			if (!header.substring(19, 23).equals("FASE")) {
				JOptionPane
						.showMessageDialog(
								null, "HEADER - Período Inicial\n Formato de período inicial ("
										+ header.substring(19, 26) + ") difere do esperado (FASE000)",
								"Erro", JOptionPane.ERROR_MESSAGE);
				return false;
			}

			Integer.valueOf(header.substring(23, 26));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "HEADER - Período Inicial\n Formato de período inicial ("
					+ header.substring(19, 26) + ") difere do esperado (FASE000)", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		try {
			if (!header.substring(26, 30).equals("FASE")) {
				JOptionPane.showMessageDialog(null, "HEADER - Período Final\n Formato de período final ("
						+ header.substring(26, 33) + ") difere do esperado (FASE000)", "Erro",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}

			Integer.valueOf(header.substring(30, 33));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "HEADER - Período Final\n Formato de período final ("
					+ header.substring(26, 33) + ") difere do esperado (FASE000)", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		try {
			Integer.parseInt(header.substring(33, 40));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "HEADER - Sequência\n Não foi possível interpretar ("
					+ header.substring(33, 40) + ") como um número sequencial", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (!header.substring(40, 43).equals("001")) {
			JOptionPane.showMessageDialog(null, "HEADER - Versão do Layout\n O valor encontrado ("
					+ header.substring(40, 43) + ") difere do valor esperado (001)", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		return true;
	}

	public boolean validarResumoOperacao(String resumoOperacao) {
		if (resumoOperacao.length() != 14) {
			JOptionPane.showMessageDialog(null, "RESUMO DE OPERAÇÃO\n O tamanho encontrado (" + resumoOperacao.length()
					+ ") difere do esperado (14)", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		try {
			if (!resumoOperacao.substring(1, 5).equals("FASE")) {
				JOptionPane.showMessageDialog(null, "RESUMO DE OPERAÇÃO - Fase\n Formato da fase ("
						+ resumoOperacao.substring(1, 8) + ") difere do esperado (FASE000)", "Erro",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}

			Integer.valueOf(resumoOperacao.substring(5, 8));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "RESUMO DE OPERAÇÃO - Fase\n Formato da fase ("
					+ resumoOperacao.substring(1, 8) + ") difere do esperado (FASE000)", "Erro",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		try {
			Integer.parseInt(resumoOperacao.substring(8, 10));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"RESUMO DE OPERAÇÃO - Quantidade de Disciplinas\n Não foi possível interpretar ("
							+ resumoOperacao.substring(8, 10) + ") como um número inteiro",
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		try {
			Integer.parseInt(resumoOperacao.substring(10, 12));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"RESUMO DE OPERAÇÃO - Quantidade de Professores\n Não foi possível interpretar ("
							+ resumoOperacao.substring(10, 12) + ") como um número inteiro",
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		return true;
	}

	public boolean validarResumoDisciplina(String resumoDisciplina) {

		HashMaps hm = new HashMaps();

		if (resumoDisciplina.length() != 11) {
			JOptionPane.showMessageDialog(null, "RESUMO DE DISCIPLINA\n O tamanho encontrado ("
					+ resumoDisciplina.length() + ") difere do esperado (11)", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (hm.getMapDisciplinas().get(resumoDisciplina.substring(1, 7)) == null) {
			JOptionPane
					.showMessageDialog(
							null, "RESUMO DE DISCIPLINA - Código Disciplina\n O valor ("
									+ resumoDisciplina.substring(1, 7) + ") não está cadastrado no sistema",
							"Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (hm.getMapDiasSemana().get(resumoDisciplina.substring(7, 9)) == null) {
			JOptionPane.showMessageDialog(null, "RESUMO DE DISCIPLINA - Dia da Semana\n O valor ("
					+ resumoDisciplina.substring(1, 7) + ") não está cadastrado no sistema", "Erro",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		try {
			Integer.parseInt(resumoDisciplina.substring(9, 11));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"RESUMO DE DISCIPLINA - Quantidade de Professores\n Não foi possível interpretar ("
							+ resumoDisciplina.substring(10, 12) + ") como um número inteiro",
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		return true;
	}

	public boolean validarResumoProfessor(String resumoProfessor) {

		HashMaps hm = new HashMaps();

		if (resumoProfessor.length() != 43) {
			JOptionPane.showMessageDialog(null, "RESUMO DE PROFESSOR\n O tamanho encontrado ("
					+ resumoProfessor.length() + ") difere do esperado (43)", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (hm.getMapQualificao().get(resumoProfessor.substring(40, 42)) == null) {
			JOptionPane.showMessageDialog(null, "RESUMO DE PROFESSOR - Qualificação\n O valor ("
					+ resumoProfessor.substring(40, 42) + ") não está cadastrado no sistema", "Erro",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		return true;
	}

	public boolean validarTrailer(String trailer) {

		if (trailer.length() != 12) {
			JOptionPane.showMessageDialog(null, "TRAILER\n O tamanho encontrado ("
					+ trailer.length() + ") difere do esperado (12)", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		try {
			Integer.parseInt(trailer.substring(1, 12));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"TRAILER - Total de Registros\n Não foi possível interpretar ("
							+ trailer.substring(1, 12) + ") como um número inteiro",
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}


		return true;
	}

	public boolean validarArquivo(Arquivo arquivo) {

		final int qtRegistro[] = new int[] { 0 };

		if (arquivo.getHeader().isEmpty()) {
			JOptionPane.showMessageDialog(null, "O arquivo não possui HEADER", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (arquivo.getHeader().size() != 1) {
			JOptionPane.showMessageDialog(null, "O arquivo possui mais de um HEADER", "Erro",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (arquivo.getTrailer().isEmpty()) {
			JOptionPane.showMessageDialog(null, "O arquivo não possui TRAILER", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (arquivo.getTrailer().size() != 1) {
			JOptionPane.showMessageDialog(null, "O arquivo possui mais de um TRAILER", "Erro",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		arquivo.getResumos().forEach(resumos -> resumos.getDisciplinas()
				.forEach(disciplinas -> disciplinas.getProfessores().forEach(professores -> qtRegistro[0]++)));

		if (qtRegistro[0] != arquivo.getTrailer().get(0).getTotalRegistro()) {
			JOptionPane.showMessageDialog(null, "A quantidade de registros difere do informado no TRAILER", "Erro",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		for (ResumoOperacao resumo : arquivo.getResumos()) {
			if (resumo.getDisciplinas().isEmpty()) {
				JOptionPane.showMessageDialog(null,
						"Resumo de Operação não possuí registros\nLinha " + resumo.getLinha(), "Erro",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}

			for (ResumoDisciplina resumoDisciplina : resumo.getDisciplinas()) {
				if (resumoDisciplina.getProfessores().isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"Resumo de Disciplínas não possuí registros\nLinha " + resumoDisciplina.getLinha(), "Erro",
							JOptionPane.ERROR_MESSAGE);
					return false;
				}
			}
		}

		return true;
	}

}
