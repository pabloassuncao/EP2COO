package Produto;
import java.text.NumberFormat;

public class ProdutoNegrito extends ProdutoFormatadoDecorator {

	private static final String SEPARADOR = ", ";

	private int id;
	private String descricao;
	private String categoria;
	private int qtdEstoque;
	private double preco;
	private String formatacao = "";

	public ProdutoNegrito(Produto produto){
		super(produto);
		if (produto instanceof ProdutoFormatadoDecorator) {
			this.formatacao += ((ProdutoFormatadoDecorator) produto).getFormatacao();
		}
		this.formatacao += "font-weight:bold;";

		setId(produto.getId());
		setDescricao(produto.getDescricao());
		setCategoria(produto.getCategoria());
		setQtdEstoque(produto.getQtdEstoque());
		setPreco(produto.getPreco());
	}

	// setters

	private void setId(int id){

		this.id = id;
	}

	private void setDescricao(String descricao){

		this.descricao = descricao;
	}

	private void setCategoria(String categoria){

		this.categoria = categoria;
	}

	public void setQtdEstoque(int qtdEstoque){

		this.qtdEstoque = qtdEstoque;
	}
	
	public void setPreco(double preco){
	
		this.preco = preco;
	}

	// getters

	public int getId(){

		return this.id;
	}

	public String getDescricao(){

		return this.descricao;
	}

	public String getCategoria(){

		return this.categoria;
	}

	public int getQtdEstoque(){

		return this.qtdEstoque;
	}
	
	public double getPreco(){
	
		return this.preco;
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
