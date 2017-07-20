package caixaEletronico;

public class Hardware {
//esta classe foi criada para instanciar o Software
	public Software soft;
	public Hardware(){
		soft = Software.getInstance();
	}
}
