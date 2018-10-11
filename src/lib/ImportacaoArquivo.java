package lib;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;

import database.model.importation.Arquivo;
import database.model.importation.Header;
import database.model.importation.ResumoDisciplina;
import database.model.importation.ResumoOperacao;
import database.model.importation.ResumoProfessor;
import database.model.importation.Trailer;
import util.FileUtil;

public class ImportacaoArquivo {

	private final static byte HEADER = 0;
	private final static byte RESUMOOPERACAO = 1;
	private final static byte RESUMODISCIPLINA = 2;
	private final static byte RESUMOPROFESSORES = 3;
	private final static byte TRAILER = 9;

	public Header interpretarHeader(String string) {

		Header h = new Header();

		h.setTipoRegistro(HEADER);
		h.setCurso(string.substring(1, 11));
		h.setDataProcessamento(string.substring(11, 19));
		h.setPeriodoInicial(string.substring(19, 26));
		h.setPeriodoFinal(string.substring(26, 33));
		h.setSequencia(Integer.parseInt(string.substring(33, 40)));
		h.setVersaoLayout(string.substring(40, 43));

		return h;
	}

	public ResumoOperacao interpretarResumoOperacao(String string) {

		ResumoOperacao ro = new ResumoOperacao();

		ro.setTipoRegistro(RESUMOOPERACAO);
		ro.setFase(string.substring(1, 8));
		ro.setQuantidadeDisciplina(Integer.valueOf(string.substring(8, 10)));
		ro.setQuantidadeProfessor(Integer.valueOf(string.substring(10, 12)));

		return ro;
	}

	public ResumoDisciplina interpretarResumoDisciplina(String string) {

		ResumoDisciplina rd = new ResumoDisciplina();

		rd.setTipoRegistro(RESUMODISCIPLINA);
		rd.setCodigoDisciplina(string.substring(1, 7));
		rd.setDiaSemana(Integer.valueOf(string.substring(7, 9)));
		rd.setQuantidadeProfessor(Integer.valueOf(string.substring(9, 11)));

		return rd;
	}

	public ResumoProfessor interpretarResumoProfessor(String string) {

		ResumoProfessor rp = new ResumoProfessor();

		rp.setTipoRegistro(RESUMOPROFESSORES);
		rp.setNomeProfessor(string.substring(1, 40));
		rp.setTituloDocente(Integer.valueOf(string.substring(40, 42)));

		return rp;
	}

	public Trailer interpretarTrailer(String string) {

		Trailer t = new Trailer();

		t.setTipoRegistro(TRAILER);
		t.setTotalRegistro(Integer.valueOf(string.substring(1, 12)));

		return t;
	}

	public Arquivo lerArquivo(String caminho, String nome) {

		Arquivo arquivo = new Arquivo();
		List<ResumoOperacao> resumos = new ArrayList<ResumoOperacao>();

		FileUtil file = new FileUtil();

		if (!file.readFile(caminho, nome))
			return null;

		while (file.hasNext()) {
			String linha = file.next();
			int ultimoRegistro = resumos.size() - 1;

			switch (linha.charAt(0)) {

			case HEADER:
				arquivo.setHeader(interpretarHeader(linha));
				break;

			case RESUMOOPERACAO:
				resumos.add(interpretarResumoOperacao(linha));
				break;

			case RESUMODISCIPLINA:
				resumos.get(ultimoRegistro).getDisciplinas().add(interpretarResumoDisciplina(linha));
				break;

			case RESUMOPROFESSORES:
				resumos.get(ultimoRegistro).getDisciplinas()
						.get(resumos.get(ultimoRegistro).getDisciplinas().size() - 1).getProfessores()
						.add(interpretarResumoProfessor(linha));
				break;

			case TRAILER:
				arquivo.setTrailer(interpretarTrailer(linha));
				break;
			}
		}

		file.close();

		arquivo.setResumos(resumos);

		return arquivo;

	}

	public boolean validarArquivo(Arquivo arquivo) {

		final int qtRegistro[] = new int[] {0};

		arquivo.getResumos().forEach(resumos -> resumos.getDisciplinas()
				.forEach(disciplinas -> disciplinas.getProfessores().forEach(professores -> qtRegistro[0]++)));
		
		if (qtRegistro[0] != arquivo.getTrailer().getTotalRegistro()) return false;

		return true;
	}

}
