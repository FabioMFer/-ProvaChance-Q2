package conta;

public class Usuario {
	private String nome;
	private String documento;
	
	Usuario(String name, String doc){
		this.nome = name;
		this.documento = doc;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getDocumento() {
		return documento;
	}
}
