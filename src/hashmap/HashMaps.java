package hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMaps {
	 
	private Map<String, String> mapDisciplinas;
	private Map<String, String> mapDiasSemana;
	private Map<String, String> mapQualificao;
	
	public  HashMaps(){
	    mapDisciplinas = new HashMap<String, String>(); 
	    mapDisciplinas.put("10850", "Algoritmos");
	    mapDisciplinas.put("10851", "Introdu��o a Ci�ncia da Computa��o");
	    mapDisciplinas.put("10854", "Fundamentos Matem�ticos para Computa��o");
	    mapDisciplinas.put("10852", "Metodologia Cient�fica e da Pesquisa");
	    mapDisciplinas.put("10853", "Produ��o e Interpreta��o de Textos");
	    mapDisciplinas.put("10858", "C�lculo I");
	    mapDisciplinas.put("10857", "Filosofia");
	    mapDisciplinas.put("10856", "F�sica Aplicada");
	    mapDisciplinas.put("10855", "L�gica para Computa��o");
	    mapDisciplinas.put("10859", "Programa��o I");
	    mapDisciplinas.put("10860", "C�lculo II");
	    mapDisciplinas.put("10862", "Circuitos Digitais");
	    mapDisciplinas.put("10863", "Estat�stica e Probabilidade");
	    mapDisciplinas.put("10864", "Estrutura de Dados I");
	    mapDisciplinas.put("10861", "Programa��o II");
	    mapDisciplinas.put("10865", "Projeto Interdisciplinar da Computa��o I");
	    mapDisciplinas.put("10868", "An�lise de Algoritmos");
	    mapDisciplinas.put("10869", "Arquitetura e Organiza��o de Computadores");
	    mapDisciplinas.put("10870", "C�lculo Num�rico");
	    mapDisciplinas.put("10866", "Estrutura de Dados II");
	    mapDisciplinas.put("10867", "Projeto Interdisciplinar da Computa��o II");
	    mapDisciplinas.put("10871", "Teoria dos Grafos");
	    mapDisciplinas.put("10875", "Banco de Dados I");
	    mapDisciplinas.put("10876", "Engenharia de Software I");
	    mapDisciplinas.put("10873", "Linguagens Formais");
	    mapDisciplinas.put("10872", "Sistemas Operacionais");
	    mapDisciplinas.put("10874", "T�picos Especiais I");
	    mapDisciplinas.put("10877", "Banco de Dados II");
	    mapDisciplinas.put("10879", "Compiladores");
	    mapDisciplinas.put("10880", "Comunica��o de Dados");
	    mapDisciplinas.put("10878", "Engenharia de Software II");
	    mapDisciplinas.put("10881", "Teoria da Computa��o");
	    mapDisciplinas.put("10886", "Administra��o Empresarial");
	    mapDisciplinas.put("10884", "Computa��o Gr�fica");
	    mapDisciplinas.put("10883", "Computa��o Paralela e Distribu�da");
	    mapDisciplinas.put("10885", "Intelig�ncia Artificial");
	    mapDisciplinas.put("10882", "Redes de Computadores");
	    mapDisciplinas.put("10887", "Trabalho de Conclus�o de Curso - TCC I");
	    mapDisciplinas.put("10891", "Empreendedorismo");
	    mapDisciplinas.put("10890", "Gest�o de Sistemas de Informa��o");
	    mapDisciplinas.put("10892", "Optativa I");
	    mapDisciplinas.put("10888", "T�picos Especiais II");
	    mapDisciplinas.put("10889", "Trabalho de Conclus�o de Curso - TCC II");
	    mapDisciplinas.put("10895", "Optativa II");
	    mapDisciplinas.put("10893", "T�picos Especiais III");
	    mapDisciplinas.put("10894", "Trabalho de Conclus�o de Curso - TCC III");
	   
	    mapDiasSemana = new HashMap<String, String>(); 
	    mapDiasSemana.put("01", "Domingo");
	    mapDiasSemana.put("02", "Segunda-Feira");
	    mapDiasSemana.put("03", "Ter�a-Feira");
	    mapDiasSemana.put("04", "Quarta-Feira");
	    mapDiasSemana.put("05", "Quinta-Feira");
	    mapDiasSemana.put("06", "Sexta-Feira");
	    mapDiasSemana.put("07", "Sabado");
	    
	    mapQualificao = new HashMap<String, String>(); 
	    mapQualificao.put("01", "P�s-Gradua��o");
	    mapQualificao.put("02", "Mestrado");
	    mapQualificao.put("03", "Doutorado");
	    mapQualificao.put("04", "P�s-Doutorado");
	}

	public Map<String, String> getMapDisciplinas() {
		return mapDisciplinas;
	}

	public Map<String, String> getMapDiasSemana() {
		return mapDiasSemana;
	}

	public Map<String, String> getMapQualificao() {
		return mapQualificao;
	}
	
}
