package GeradorDeRelatório;
import java.io.PrintWriter;
import java.util.*;

import Produto.*;

import java.io.IOException;

public class GeradorDeRelatorios {
	// operador bit a bit "ou" pode ser usado para combinar mais de  
	// um estilo de formatacao simultaneamente (veja como no main)
	public static final int FORMATO_PADRAO  = 0b0000;
	public static final int FORMATO_NEGRITO = 0b0001;
	public static final int FORMATO_ITALICO = 0b0010;

	private List<Produto> produtos;
	int format_flags;

	public GeradorDeRelatorios(List<Produto> produtos, int format_flags){
		this.produtos = produtos;
		this.format_flags = format_flags;
	}


	public void geraRelatorio(String arquivoSaida) throws IOException {
		PrintWriter out = new PrintWriter(arquivoSaida);

		out.println("<!DOCTYPE html><html>");
		out.println("<head><title>Relatorio de produtos</title></head>");
		out.println("<body>");
		out.println("Relatorio de Produtos:");
		out.println("<ul>");

		int count = 0;

		for (Produto p : produtos) {
			System.out.println(p.getPreco());
			out.print("<li>");

			if((format_flags & FORMATO_ITALICO) > 0){

				out.print("<span style=\"font-style:italic\">");
			}

			if((format_flags & FORMATO_NEGRITO) > 0){

				out.print("<span style=\"font-weight:bold\">");
			} 
		
			out.print(p.formataParaImpressao());

			if((format_flags & FORMATO_NEGRITO) > 0){

				out.print("</span>");
			} 

			if((format_flags & FORMATO_ITALICO) > 0){

				out.print("</span>");
			}

			out.println("</li>");
			count++;
		};

		out.println("</ul>");
		out.println(count + " produtos listados, de um total de " + produtos.size() + ".");
		out.println("</body>");
		out.println("</html>");

		out.close();
	}
}
