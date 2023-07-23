package GeradorDeRelatorio;
import java.io.PrintWriter;
import java.util.*;

import Produto.*;

import java.io.IOException;

public class GeradorDeRelatorios {
	private List<Produto> produtos;
	int format_flags;

	public GeradorDeRelatorios(List<Produto> produtos){
		this.produtos = produtos;
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
			System.out.println(p.getQtdEstoque() + " " + p.getPreco() + "  " + p.getDescricao());
			out.print("<li>");
		
			out.print(p.formataParaImpressao());

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
