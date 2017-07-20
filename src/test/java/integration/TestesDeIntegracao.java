package integration;

import static org.junit.Assert.*;

import org.junit.Test;

import caixaEletronico.Hardware;
import caixaEletronico.Software;
import conta.Senha;

public class TestesDeIntegracao {
	Hardware h;
	Software s;
	Senha p;
	
	@Test
	public void testTentativaDeAcesso_SemEfetivarOAcesso() {
		h = new Hardware();
		s = h.soft;
		s.criarContaCorrente("123ab#12", 10, "Fabio", "123456789");
		
		assertEquals(0, s.consultaSaldo());
		
		s.deposito(1000);
		assertEquals(0, s.consultaSaldo());
		
		s.pagamento(900);
		assertEquals(0, s.consultaSaldo());
		
		//os dados dos usuários estão protegidos por não se fazer
		//qualquer operação sem que o usuário tenha validado o acesso
	}

}
