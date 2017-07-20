package caixaEletronico;

import java.util.ArrayList;
import conta.ContaCorrente;
import conta.Senha;
public class Software {
	//para simplificar a implementação considerarei que o caixa eletronico guarda
	//as informações de todas as contas correntes na estrutura a seguir.
	ArrayList<ContaCorrente> contas = new ArrayList<ContaCorrente>();
	ContaCorrente atual;
	//esta classe foi criada com o padrao de projeto Singleton, garantindo que
	//apenas uma instancia do software do caixa eletronico seja criada.
	private static Software instance = null;
	private Software(){
		atual = null;
	}
	
	public static Software getInstance(){
		if (instance == null){
			instance = new Software();
		}
		return instance;
	}
	
	public String acessoDeUsuario(int nConta, String senha){	
		if(nConta <= contas.size()){
			ContaCorrente aux = contas.get(nConta);
			if (aux.verificarSenha(senha)){
				atual = aux;
				return "Acesso com sucesso";
			}
			else return "Acesso negado";
		}
		else return "Conta inexistente";
	}
	
	public void saidaDeUsuario(){
		atual = null;
	}
	
	//*******REQUESITOS*******//
	//Saldo
	public int consultaSaldo(){
		if (atual == null) return 0;
		return atual.getSaldo();
	}
	//Pagamento
	public void pagamento(int valor){
		if(atual != null) atual.pagar(valor);
	}
	//Depósito
	public void deposito(int valor){
		if(atual != null) atual.depositar(valor);
	}
	//Criar conta corrente
	public String criarContaCorrente(String senhaBruta, int depositoInicial, String nomeUser, String docUser){
		Senha novaSenha = new Senha();
		novaSenha.setSenha(senhaBruta);
		if(novaSenha.aprovada) {
			ContaCorrente novaConta = new ContaCorrente(contas.size(), depositoInicial, novaSenha, nomeUser, docUser);
			contas.add(novaConta);
			return "Conta criada com sucesso";
		}
		else return "Conta não criada";
	}
}
