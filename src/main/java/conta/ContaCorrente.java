package conta;

public class ContaCorrente {
	private int num;
	private Usuario user;
	private Senha senha;
	private int saldo;
	
	public ContaCorrente(int numero, int saldoInicial, Senha password, String nome, String documento){
		this.num = numero;
		this.saldo = saldoInicial;
		this.user = new Usuario(nome, documento);
		this.senha = password;
	}
	
	public boolean verificarSenha(String pass){
		if(this.senha.getSenha() == pass){
			return true;
		}
		return false;
	}
	
	public int getNum() {
		return num;
	}

	public Usuario getUser() {
		return user;
	}

	public int getSaldo() {
		return saldo;
	}

	public void pagar(int valor){
		saldo -=valor;
	}
	
	public void depositar(int valor){
		saldo += valor;
	}
}
