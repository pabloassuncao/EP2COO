package Produto;
import java.text.NumberFormat;

public class ProdutoColorido extends ProdutoFormatadoDecorator {

	private static final String SEPARADOR = ", ";

	private String formatacao = "";

	public ProdutoColorido(Produto produto, String cor){
		super(produto);
		if (produto instanceof ProdutoFormatadoDecorator) {
			this.formatacao += ((ProdutoFormatadoDecorator) produto).getFormatacao();
		}
		this.formatacao += "color:" + cor + ";";
	}

	public String getFormatacao(){

		return this.formatacao;
	}

	// metodo que devolve uma String que representa o produto, a ser usada na geração dos relatorios.
	public String formataParaImpressao(){

		NumberFormat fmt = NumberFormat.getCurrencyInstance();

		return "<span style=\"" + formatacao + "\">" + getDescricao() + SEPARADOR + getCategoria() + SEPARADOR + fmt.format(getPreco()) + SEPARADOR + getQtdEstoque() + " unidade(s) em estoque</span>";
	}

}
