package api_dados_blocos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Blocos {
	int code;

	@Test

	public void testPesquisarBlocos() {
		Response response = RestAssured
				.get("https://dadosabertos.camara.leg.br/api/v2/deputados?ordem=ASC&ordenarPor=nome");

		code = response.getStatusCode();

		System.out.println("o status code retornado é " + code);

		assertEquals(200, code);
	}

	@Test
	public void validarId() {
		int posicao = 0;
		Response response = RestAssured

				.get("https://dadosabertos.camara.leg.br/api/v2/blocos?ordem=ASC&ordenarPor=nome");

		String id = response.jsonPath().getString("dados.id[" + posicao + "]".toString());

		System.out.println("id retornado "+id);

	}

	@Test
	public void validarFederação() {

		String nomeEsperado = "Federação Brasil da Esperança - Fe Brasil";
		int posicao = 0;
		Response response = RestAssured
				.get("https://dadosabertos.camara.leg.br/api/v2/blocos?ordem=ASC&ordenarPor=nome");

		String nome = response.jsonPath().getString("dados.nome[" + posicao + "]").toString();
		assertEquals(nome, nomeEsperado);
		System.out.println(" Federação retornada : " + nome);

	}

	@Test
	public void validarIdLegislacao() {

		String idLegislacaoEsperada = "57";
		int posicao = 0;
		Response response = RestAssured
				.get("https://dadosabertos.camara.leg.br/api/v2/blocos?ordem=ASC&ordenarPor=nome");

		String idLegislacao = response.jsonPath().getString("dados.idLegislatura[" + posicao + "]").toString();
		assertEquals(idLegislacao, idLegislacaoEsperada);
		System.out.println(" IdLesgislacao retornada  : " + idLegislacao);
	}

}
