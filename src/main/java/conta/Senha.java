package conta;

public class Senha {
	
	private String senha;
	private boolean letra;
	private boolean numero;
	private boolean caracEsp;
	public boolean aprovada;
	
	public Senha(){
		letra = false;
		numero = false;
		caracEsp = false;
		aprovada = false;
	}
	
	public String setSenha(String senhaBruta){
		String aviso = verificarSenha(senhaBruta); 
		if(aprovada){
			senha = senhaBruta;
		}
		return aviso;
	}
	
	private String verificarSenha(String senhaBruta){
		int tamanho = senhaBruta.length();
		if (tamanho < 8){
			return "A senha deve conter pelo menos 8 digitos";
		}
		char atual;
		for(int i = 0; i<tamanho; i++){
			atual = senhaBruta.charAt(i);
			if(atual >= 'A' && atual <= 'z'){
				letra = true;
			}
			else if(atual >= '0' && atual <= '9'){
				numero = true;
			}
			else caracEsp = true;
		}
		
		if(letra && numero && caracEsp){
			aprovada = true;
			return "Senha aprovada";
		}
		else {
			return "ERRO DE SENHA:\n"
					+ "A senha não atende os requisitos de possuir"
					+ " letras, números e ao menos um caracter especial";
		}
	}

	public String getSenha() {
		return senha;
	}
}
