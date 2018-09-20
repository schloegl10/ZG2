package caixa;

public class PromocaoPagueLeve implements Promocao{
	int leve,pague;
	public PromocaoPagueLeve(int leve,int pague) {
		this.leve=leve;
		this.pague=pague;
	}
	public float getDesconto(int quantidade, float preco) {
		int verificador;
		verificador = quantidade/leve;
		if(verificador>=1) {
			return preco*((leve-pague)*verificador);
		}
		return 0;
	}
}
