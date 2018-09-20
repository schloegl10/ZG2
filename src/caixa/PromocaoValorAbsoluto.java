package caixa;

public class PromocaoValorAbsoluto implements Promocao{
	
	int leve;
	float valor;
	
	public PromocaoValorAbsoluto(int leve,float valor) {
		
		this.leve=leve;
		this.valor=valor;
		
	}
	public float getDesconto(int quantidade,float preco) {
		
		int verificador;
		verificador=quantidade/leve;
		
		if(verificador>=1){
			
			return preco*leve*verificador- valor*verificador;
		}
		
		return 0;
	}

}
