package Produto;
import java.text.NumberFormat;

public class ProdutoFormatado implements Produto {

	private static final String SEPARADOR = ", ";

	private int id;
	private String descricao;
	private String categoria;
	private int qtdEstoque;
	private double preco;
	private boolean negrito;
	private boolean italico;
	private boolean colorido;
	private String color;
	private String formatacao = "";

	public ProdutoFormatado(Produto produto, boolean negrito, boolean italico, boolean colorido, String color){
		
		setId(produto.getId());
		setDescricao(produto.getDescricao());
		setCategoria(produto.getCategoria());
		setQtdEstoque(produto.getQtdEstoque());
		setPreco(produto.getPreco());
		setNegrito(negrito);
		setItalico(italico);
		setColorido(colorido, color);
	}

	public ProdutoFormatado(int id, String descricao, String categoria, int qtdEstoque, double preco){

		setId(id);
		setDescricao(descricao);
		setCategoria(categoria);
		setQtdEstoque(qtdEstoque);
		setPreco(preco);
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

	public void setNegrito(boolean negrito){

		this.negrito = negrito;
	}

	public void setItalico(boolean italico){

		this.italico = italico;
	}

	public void setColorido(boolean colorido, String color){

		this.color = color;
		this.colorido = colorido;
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

	public boolean getNegrito(){

		return this.negrito;
	}

	public boolean getItalico(){

		return this.italico;
	}

	public boolean getColorido(){

		return this.colorido;
	}

	// metodo que devolve uma String que representa o produto, a ser usada na geração dos relatorios.

	public String formataParaImpressao(){

		NumberFormat fmt = NumberFormat.getCurrencyInstance();

		if (this.negrito) formatacao += "font-weight:bold;";
		if (this.italico) formatacao += "font-style:italic;";
		if (this.colorido) formatacao += "color:" + this.color + ";";

		if (this.negrito || this.italico || this.colorido){
			return "<span style=\"" + formatacao + "\">" + getDescricao() + SEPARADOR + getCategoria() + SEPARADOR + fmt.format(getPreco()) + SEPARADOR + getQtdEstoque() + " unidade(s) em estoque</span>";
		}

		return getDescricao() + SEPARADOR + getCategoria() + SEPARADOR + fmt.format(getPreco()) + SEPARADOR + getQtdEstoque() + " unidade(s) em estoque";
	}

}
