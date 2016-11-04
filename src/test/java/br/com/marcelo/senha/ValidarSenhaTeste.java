package br.com.marcelo.senha;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.marcelo.senha.model.ValidarSenha;

public class ValidarSenhaTeste {
	private ValidarSenha validar = new ValidarSenha();
	
	private String passwordTest = "Te0DoRoS@Mp";
	private String passwordTestMaiusConsec = " AA BC";
	private String passwordTestMinusConsec = " aa bc";
	private String letrasSequenciais = " abc aabbccdefg";
	private String numerosSequenciais = " 234 001122345";
	private String simbolosSequenciais = "@#$(*&)(*";
	
	
	@Test
	public void testQuantidadeMaiuscula() {
		int qtd = validar.quantidadeMaiusculas(passwordTest);
		assertEquals(5, qtd);
	}
	
	@Test
	public void testQuantidadeMinuscula() {
		int qtd = validar.quantidadeMinusculas(passwordTest);
		assertEquals(4, qtd);
	}
	
	@Test
	public void testQuantidadeNumeros() {
		int qtd = validar.quantidadeNumeros(passwordTest);
		assertEquals(1, qtd);
	}
	
	@Test
	public void testQuantidadeSimbolos() {
		int qtd = validar.quantidadeSimbolos(passwordTest);
		assertEquals(1, qtd);
	}
	
	@Test
	public void testQuantidadeNumerosSimbolosMeio() {
		int qtd = validar.quantidadeNumerosSimbolosMeio(passwordTest);
		assertEquals(2, qtd);
	}
	
	@Test
	public void testQuantidadeRequisitos() {
		int qtd = validar.quantidadeRequisitos(passwordTest);
		assertEquals(5, qtd);
	}
	
	@Test
	public void testQuantidadeApenasLetras() {
		int qtd = validar.quantidadeApenasLetras(passwordTest);
		assertEquals(0, qtd);
	}
	
	@Test
	public void testQuantidadeApenasNumeros() {
		int qtd = validar.quantidadeApenasNumeros(passwordTest);
		assertEquals(0, qtd);
	}
	
	@Test
	public void testQuantidadeCaracteresRepetidos() {
		int qtd = validar.quantidadeCaracteresRepetidos(passwordTest);
		assertEquals(2, qtd);
	}
	
	@Test
	public void testQuantidadeMaiusculasConsecutivas() {
		int qtd = validar.quantidadeMaiusculasConsecutivas(passwordTestMaiusConsec);
		assertEquals(3, qtd);
	}
	
	@Test
	public void testQuantidadeMinusculasConsecutivas() {
		int qtd = validar.quantidadeMinusculasConsecutivas(passwordTestMinusConsec);
		assertEquals(3, qtd);
	}
	
	@Test
	public void testQuantidadeNumerosConsecutivos() {
		int qtd = validar.quantidadeNumerosConsecutivos(passwordTest);
		assertEquals(0, qtd);
	}
	
	@Test
	public void testQuantidadeLetrasSequenciais() {
		int qtd = validar.quantidadeLetrasSequenciais(letrasSequenciais);
		assertEquals(4, qtd);
	}
	
	@Test
	public void testQuantidadeNumerosSequenciais() {
		int qtd = validar.quantidadeNumerosSequenciais(numerosSequenciais);
		assertEquals(2, qtd);
	}
	
	@Test
	public void testQuantidadeSimbolosSequenciais() {
		int qtd = validar.quantidadeSimbolosSequenciais(simbolosSequenciais);
		assertEquals(2, qtd);
	}
	
		
	@Test
	public void testQuantidadeMaiusculaPontos() {
		int qtd = validar.quantidadeMaiusculasPontos(passwordTest);
		assertEquals(12, qtd);
	}
	
	@Test
	public void testQuantidadeMinusculaPontos() {
		int qtd = validar.quantidadeMinusculasPontos(passwordTest);
		assertEquals(14, qtd);
	}
	
	@Test
	public void testQuantidadeNumerosPontos() {
		int qtd = validar.quantidadeNumerosPontos(passwordTest);
		assertEquals(4, qtd);
	}
	
	@Test
	public void testQuantidadeSimbolosPontos() {
		int qtd = validar.quantidadeSimbolosPontos(passwordTest);
		assertEquals(6, qtd);
	}
	
	@Test
	public void testQuantidadeNumerosSimbolosMeioPontos() {
		int qtd = validar.quantidadeNumerosSimbolosMeioPontos(passwordTest);
		assertEquals(4, qtd);
	}
	
	@Test
	public void testQuantidadeRequisitosPontos() {
		int qtd = validar.quantidadeRequisitosPontos(passwordTest);
		assertEquals(10, qtd);
	}
		
	
	@Test
	public void testQuantidadeApenasLetrasPontos() {
		int qtd = validar.quantidadeApenasLetrasPontos(passwordTest);
		assertEquals(0, qtd);
	}
	
	@Test
	public void testQuantidadeApenasNumerosPontos() {
		int qtd = validar.quantidadeApenasNumerosPontos(passwordTest);
		assertEquals(0, qtd);
	}
	
	@Test
	public void testQuantidadeCaracteresRepetidosPontos() {
		int qtd = validar.quantidadeCaracteresRepetidosPontos(passwordTest);
		assertEquals(1, qtd);
	}
	
	@Test
	public void testQuantidadeMaiusculasConsecutivasPontos() {
		int qtd = validar.quantidadeMaiusculasConsecutivasPontos(passwordTest);
		assertEquals(0, qtd);
	}
	
	@Test
	public void testQuantidadeMinusculasConsecutivasPontos() {
		int qtd = validar.quantidadeMinusculasConsecutivasPontos(passwordTest);
		assertEquals(0, qtd);
	}
	
	@Test
	public void testQuantidadeNumerosConsecutivosPontos() {
		int qtd = validar.quantidadeNumerosConsecutivosPontos(passwordTest);
		assertEquals(0, qtd);
	}
	
	@Test
	public void testQuantidadeLetrasSequenciaisPontos() {
		int qtd = validar.quantidadeLetrasSequenciaisPontos(passwordTest);
		assertEquals(0, qtd);
	}
	
	@Test
	public void testQuantidadeNumerosSequenciaisPontos() {
		int qtd = validar.quantidadeNumerosSequenciaisPontos(passwordTest);
		assertEquals(0, qtd);
	}
	
	@Test
	public void testQuantidadeSimbolosSequenciaisPontos() {
		int qtd = validar.quantidadeSimbolosSequenciaisPontos(passwordTest);
		assertEquals(0, qtd);
	}
	
	@Test
	public void testCalcularPontos() {
		int qtd = validar.calcularPontos(passwordTest);
		assertEquals(93, qtd);
	}
	
	@Test
	public void testCalcularComplexidade() {
		String complexidade = validar.calcularComplexidade(validar.calcularPontos(passwordTest));
		assertEquals("Muito Forte", complexidade);
	}
	
	
	
	
	
	

}
