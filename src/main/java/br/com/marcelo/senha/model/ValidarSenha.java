package br.com.marcelo.senha.model;

import java.util.ArrayList;
import java.util.List;


public class ValidarSenha {

	private String senha;
	private int pontos;
	private String complexidade;
	
	public ValidarSenha(String senha){
		this.setSenha(senha);
		this.pontos = calcularPontos(senha);
		this.setComplexidade(calcularComplexidade(this.pontos));
	}
	
	public ValidarSenha(){		

	}		

	private static final int MINIMO_CARACTERES = 8;

	public int quantidadeCaracteres(String senha) {
		return senha.length();
	}

	public int quantidadeCaracteresPontos(String senha) {
		return senha.length() * 4;
	}

	public int quantidadeMaiusculas(String senha) {

		int qtdMaiusculos = 0;
		for (int i = 0; i < senha.length(); i++) {

			if (Character.isUpperCase(senha.charAt(i))) {
				qtdMaiusculos++;
			}
		}
		return qtdMaiusculos;
	}

	public int quantidadeMaiusculasPontos(String senha) {
		return (senha.length() - quantidadeMaiusculas(senha)) * 2;
	}

	public int quantidadeMinusculas(String senha) {

		int qtdMinusculas = 0;
		for (int i = 0; i < senha.length(); i++) {

			if (Character.isLowerCase(senha.charAt(i))) {
				qtdMinusculas++;
			}
		}
		return qtdMinusculas;
	}

	public int quantidadeMinusculasPontos(String senha) {
		return (senha.length() - quantidadeMinusculas(senha)) * 2;
	}

	public int quantidadeNumeros(String senha) {
		int qtdNumeros = 0;

		for (int i = 0; i < senha.length(); i++) {

			if (Character.isDigit(senha.charAt(i)))
				qtdNumeros++;
		}
		return qtdNumeros;
	}

	public int quantidadeNumerosPontos(String senha) {
		return quantidadeNumeros(senha) * 4;
	}

	public int quantidadeSimbolos(String senha) {

		int qtdSimbolos = 0;
		for (int i = 0; i < senha.length(); i++) {

			if ((senha.substring(i, i + 1).matches("[^A-Za-z0-9 ]")))
				qtdSimbolos++;
		}
		return qtdSimbolos;
	}

	public int quantidadeSimbolosPontos(String senha) {
		return quantidadeSimbolos(senha) * 6;
	}

	public int quantidadeNumerosSimbolosMeio(String senha) {

		int qtdNumSimMeio = 0;
		for (int i = 0; i < senha.length(); i++) {

			if (Character.isDigit(senha.charAt(i)) || (senha.substring(i, i + 1).matches("[^A-Za-z0-9 ]"))) {
				if (i > 0 && i < (senha.length() - 1))
					qtdNumSimMeio++;
			}
		}
		return qtdNumSimMeio;
	}

	public int quantidadeNumerosSimbolosMeioPontos(String senha) {
		return quantidadeNumerosSimbolosMeio(senha) * 2;
	}

	public int quantidadeRequisitos(String senha) {

		List<Integer> arrayContadores = new ArrayList<Integer>();
		arrayContadores.add(0, quantidadeCaracteres(senha));
		arrayContadores.add(1, quantidadeMaiusculas(senha));
		arrayContadores.add(2, quantidadeMinusculas(senha));
		arrayContadores.add(3, quantidadeNumeros(senha));
		arrayContadores.add(4, quantidadeSimbolos(senha));

		List<String> arrayNomeContadores = new ArrayList<String>();
		arrayNomeContadores.add(0, "quantidadeCaracteres");
		arrayNomeContadores.add(1, "quantidadeMaiusculas");
		arrayNomeContadores.add(2, "quantidadeMinusculas");
		arrayNomeContadores.add(3, "quantidadeNumeros");
		arrayNomeContadores.add(4, "quantidadeSimbolos");

		int qtdRequisitos = 0;
		int valorMinimo = 0;

		for (int i = 0; i < arrayContadores.size(); i++) {

			if (arrayNomeContadores.get(i) == "quantidadeCaracteres") {
				valorMinimo = MINIMO_CARACTERES - 1;
			} else {
				valorMinimo = 0;
			}

			if (arrayContadores.get(i) == (valorMinimo + 1)) {
				qtdRequisitos++;
			} else if (arrayContadores.get(i) > (valorMinimo + 1)) {
				qtdRequisitos++;
			}
		}

		return qtdRequisitos;
	}

	public int quantidadeRequisitosPontos(String senha) {

		int minimoChar = 0;

		if (senha.length() >= MINIMO_CARACTERES) {
			minimoChar = 3;
		} else {
			minimoChar = 4;
		}

		if (quantidadeRequisitos(senha) > minimoChar) {														
			return quantidadeRequisitos(senha) * 2;
		} else {
			return 0;
		}

	}

	

	public int quantidadeApenasLetras(String senha) {

		int qtdApenasLetras = 0;
		if ((quantidadeMaiusculas(senha) > 0 || quantidadeMinusculas(senha) > 0) && quantidadeSimbolos(senha) == 0
				&& quantidadeNumeros(senha) == 0) {
			qtdApenasLetras = senha.length();
		}
		return qtdApenasLetras;
	}

	public int quantidadeApenasLetrasPontos(String senha) {
		return quantidadeApenasLetras(senha);
	}

	public int quantidadeApenasNumeros(String senha) {

		int qtdApenasNumeros = 0;
		if (quantidadeMaiusculas(senha) == 0 && quantidadeMinusculas(senha) == 0 && quantidadeSimbolos(senha) == 0
				&& quantidadeNumeros(senha) > 0) {
			qtdApenasNumeros = senha.length();
		}
		return qtdApenasNumeros;
	}

	public int quantidadeApenasNumerosPontos(String senha) {
		return quantidadeApenasNumeros(senha);
	}

	public int quantidadeCaracteresRepetidos(String senha) {

		int qtdCharRepetidos = 0;
		for (int i = 0; i < senha.length(); i++) {

			boolean houveRepeticao = false;
			for (int n = 0; n < senha.length(); n++) {

				if (senha.charAt(i) == senha.charAt(n) && i != n) {
					houveRepeticao = true;
				}
			}
			if (houveRepeticao)
				qtdCharRepetidos++;
		}
		return qtdCharRepetidos;
	}

	
	public int quantidadeCaracteresRepetidosPontos(String senha) {

		double repeticoesCalculadas = 0;
		int variavelCalculo = 0;
		int qtdCharRepetidos = 0;
		boolean houveRepeticao = false;
		
		for (int i = 0; i < senha.length(); i++) {

			houveRepeticao = false;
			for (int n = 0; n < senha.length(); n++) {

				if (senha.charAt(i) == senha.charAt(n) && i != n) {
					houveRepeticao = true;
					repeticoesCalculadas += Math.abs(senha.length() / (i - n));
				}
			}			
		}
		if (houveRepeticao) {
			qtdCharRepetidos++;
			variavelCalculo = senha.length() - qtdCharRepetidos;
			repeticoesCalculadas = (variavelCalculo == 0) ? Math.ceil(repeticoesCalculadas / variavelCalculo)
					: Math.ceil(repeticoesCalculadas);
		}
		if (qtdCharRepetidos > 0) {
			return (int) repeticoesCalculadas;
		} else {
			return 0;
		}		
	}

	public int quantidadeMaiusculasConsecutivas(String senha) {

		Character charAnterior = Character.DIRECTIONALITY_WHITESPACE;
		int qtdMaiusConsec = 0;
		for (int i = 0; i < senha.length(); i++) {

			if (Character.isUpperCase(senha.charAt(i))) {

				if (!Character.isWhitespace(charAnterior)) {
					if (Character.isUpperCase(charAnterior)) {
						qtdMaiusConsec++;
					}

				}
				charAnterior = senha.charAt(i);
			} else if (!Character.isWhitespace(senha.charAt(i))) {
				charAnterior = senha.charAt(i);
			}
		}
		return qtdMaiusConsec;
	}

	public int quantidadeMaiusculasConsecutivasPontos(String senha) {
		return quantidadeMaiusculasConsecutivas(senha) * 2;
	}

	public int quantidadeMinusculasConsecutivas(String senha) {

		Character charAnterior = Character.DIRECTIONALITY_WHITESPACE;
		int qtdMinusConsec = 0;
		for (int i = 0; i < senha.length(); i++) {

			if (Character.isLowerCase(senha.charAt(i))) {

				if (!Character.isWhitespace(charAnterior)) {
					if (Character.isLowerCase(charAnterior)) {
						qtdMinusConsec++;
					}

				}
				charAnterior = senha.charAt(i);
			} else if (!Character.isWhitespace(senha.charAt(i))) {
				charAnterior = senha.charAt(i);
			}
		}
		return qtdMinusConsec;
	}

	public int quantidadeMinusculasConsecutivasPontos(String senha) {
		return quantidadeMinusculasConsecutivas(senha) * 2;
	}

	public int quantidadeNumerosConsecutivos(String senha) {

		Character charAnterior = Character.DIRECTIONALITY_WHITESPACE;
		int qtdNumConsec = 0;
		for (int i = 0; i < senha.length(); i++) {

			if (Character.isDigit(senha.charAt(i))) {

				if (!Character.isWhitespace(charAnterior)) {
					if (Character.isDigit(charAnterior)) {
						qtdNumConsec++;
					}

				}
				charAnterior = senha.charAt(i);
			} else if (!Character.isWhitespace(senha.charAt(i))) {
				charAnterior = senha.charAt(i);
			}
		}
		return qtdNumConsec;
	}

	public int quantidadeNumerosConsecutivosPontos(String senha) {
		return quantidadeNumerosConsecutivos(senha) * 2;
	}

	public int quantidadeLetrasSequenciais(String senha) {

		String abecedario = "abcdefghijklmnopqrstuvwxyz";
		int qtdLetrasSeq = 0;
		for (int i = 0; i < 23; i++) {

			String sequenciaFrente = abecedario.substring(i, i + 3);
			String sequenciaTras = new StringBuilder(sequenciaFrente).reverse().toString();
			if (senha.toLowerCase().indexOf(sequenciaFrente) != -1
					|| senha.toLowerCase().indexOf(sequenciaTras) != -1) {
				qtdLetrasSeq++;
			}
		}
		return qtdLetrasSeq;
	}

	public int quantidadeLetrasSequenciaisPontos(String senha) {
		return quantidadeLetrasSequenciais(senha) * 3;
	}

	public int quantidadeNumerosSequenciais(String senha) {

		String numeros = "01234567890";
		int qtdNumSeq = 0;
		for (int i = 0; i < 8; i++) {

			String sequenciaFrente = numeros.substring(i, i + 3);
			String sequenciaTras = new StringBuilder(sequenciaFrente).reverse().toString();
			if (senha.toLowerCase().indexOf(sequenciaFrente) != -1
					|| senha.toLowerCase().indexOf(sequenciaTras) != -1) {
				qtdNumSeq++;
			}
		}
		return qtdNumSeq;
	}

	public int quantidadeNumerosSequenciaisPontos(String senha) {
		return quantidadeNumerosSequenciais(senha) * 3;
	}

	public int quantidadeSimbolosSequenciais(String senha) {

		String simbolos = ")!@#$%^&*()";
		int qtdSimbSeq = 0;
		for (int i = 0; i < 8; i++) {

			String sequenciaFrente = simbolos.substring(i, i + 3);
			String sequenciaTras = new StringBuilder(sequenciaFrente).reverse().toString();
			if (senha.toLowerCase().indexOf(sequenciaFrente) != -1
					|| senha.toLowerCase().indexOf(sequenciaTras) != -1) {
				qtdSimbSeq++;
			}
		}
		return qtdSimbSeq;
	}

	public int quantidadeSimbolosSequenciaisPontos(String senha) {
		return quantidadeSimbolosSequenciais(senha) * 3;
	}

	public int calcularPontos(String senha) {	

		int pontos = quantidadeCaracteresPontos(senha) + quantidadeMaiusculasPontos(senha)
				+ quantidadeMinusculasPontos(senha) + quantidadeNumerosPontos(senha) + quantidadeSimbolosPontos(senha)
				+ quantidadeNumerosSimbolosMeioPontos(senha) + quantidadeRequisitosPontos(senha)

				- quantidadeApenasLetrasPontos(senha) - quantidadeApenasNumerosPontos(senha)
				- quantidadeCaracteresRepetidosPontos(senha) - quantidadeMaiusculasConsecutivasPontos(senha)
				- quantidadeMinusculasConsecutivasPontos(senha) - quantidadeNumerosConsecutivosPontos(senha)
				- quantidadeLetrasSequenciaisPontos(senha) - quantidadeNumerosSequenciaisPontos(senha)
				- quantidadeSimbolosSequenciaisPontos(senha);		
		if (pontos > 100) {
			this.setPontos(100);
			return 100;
		} else if (pontos < 0){
			this.setPontos(0);
			return pontos;
		}else{
			this.setPontos(pontos);
			return pontos;
		}
	}

	public String calcularComplexidade(int pontos) {

		String complexidade = "" ;
		if (pontos >= 1 && pontos <= 19) {
			complexidade = "Muito Fraca";
		} else if (pontos >= 20 && pontos <= 39) {
			complexidade = "Fraca";
		} else if (pontos >= 40 && pontos <= 59) {
			complexidade = "Boa";
		} else if (pontos >= 60 && pontos <= 79) {
			complexidade = "Forte";
		} else if (pontos >= 80 && pontos <= 100) {
			complexidade = "Muito Forte";
		}else if (pontos == 0 && this.senha.length() > 1){
			complexidade = "Muito Fraca";
		}else{
			complexidade = "Muito Curta";
		}		
		
		this.setComplexidade(complexidade);
		return complexidade;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public String getComplexidade() {
		return complexidade;
	}

	public void setComplexidade(String complexidade) {
		this.complexidade = complexidade;
	}

}
