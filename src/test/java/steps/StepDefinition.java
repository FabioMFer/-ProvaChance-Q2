package steps;

import caixaEletronico.*;
import conta.*;

import cucumber.api.java.pt.*;

import static org.junit.Assert.assertTrue;

import org.jmock.Expectations;

public class StepDefinition {

	private Hardware cx;
	private Software s;
	ContaCorrente c; 

	int originCount, currentCount;
	String originPassWord , currentPassWord;

	public void inicializar(){

		cx = new Hardware();
		s = cx.soft;
		
		s.criarContaCorrente("123ab&120", 0, "user", "docUser");
		s.criarContaCorrente("qwer12&%", 0, "nomeUser", "docUser");
	}

	@Dado("^Eu quero acessar o sistema usando o número da conta (.*) e senha (.*)$")
	public void eu_quero_acessar_o_sistema_usando_o_número_da_conta_e_senha(int contaInicial, String senhaInicial) throws Throwable {
		
		inicializar();
		
		originCount = contaInicial;
		originPassWord = senhaInicial;

	}
	
	@Quando("^Eu informei a conta (\\d+) e a senha (\\d+)$")
	public void eu_informei_a_conta_e_a_senha(final int conta,final String senha) throws Throwable {
		
		new Expectations(){{
			if (originCount == conta && originPassWord == senha){
				will(returnValue("Acesso com sucesso"));
			}
			else if(originCount == conta && originPassWord != senha){
				will(returnValue("Acesso negado"));
			}
			else{
				will(returnValue("Conta inexistente"));
			}
		}};
	}

	
	@Então("^Eu recebo a mensagem de status (.*)$")
	public void eu_recebo_a_mensagem_de_status(String teste) throws Throwable {

		String resposta = s.acessoDeUsuario(currentCount, currentPassWord);
		
		assertTrue(resposta.contains(teste));

	}

}