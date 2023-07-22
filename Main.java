import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


import Filter.*;
import Filter.Compare.AllCompare;
import Filter.Compare.Compare;
import Filter.Compare.CompareOptions;
import Filter.Compare.CompareStrategy;
import GeradorDeRelatorio.GeradorDeRelatorios;
import Order.*;
import Produto.*;
import Sort.*;

public class Main {
  public static final String ALG_INSERTIONSORT = "quick";
	public static final String ALG_QUICKSORT = "insertion";

	public static final String CRIT_DESC_CRESC = "descricao_c";
	public static final String CRIT_PRECO_CRESC = "preco_c";
	public static final String CRIT_ESTOQUE_CRESC = "estoque_c";
	
	public static final String FILTRO_TODOS = "todos";
	public static final String FILTRO_ESTOQUE_MENOR_OU_IQUAL_A = "estoque_menor_igual";
	public static final String FILTRO_CATEGORIA_IGUAL_A = "categoria_igual";

	public static boolean negrito;
	public static boolean italico;
	public static boolean colorido;
	public static String color;
 
	public static enum formatOptions {
		NEGRITO,
		ITALICO,
		COLORIDO
	}

  public static List<Produto> carregaProdutosEstatico(){
		return Arrays.asList(new Produto [] { 
			new ProdutoPadrao( 1, "O Hobbit", "Livros", 2, 34.90),
			new ProdutoPadrao( 2, "Notebook Core i7", "Informatica", 5, 1999.90),
			new ProdutoPadrao( 3, "Resident Evil 4", "Games", 7, 79.90),
			new ProdutoPadrao( 4, "iPhone", "Telefonia", 8, 4999.90),
			new ProdutoPadrao( 5, "Calculo I", "Livros", 20, 55.00),
			new ProdutoPadrao( 6, "Power Glove", "Games", 3, 499.90),
			new ProdutoPadrao( 7, "Microsoft HoloLens", "Informatica", 1, 19900.00),
			new ProdutoPadrao( 8, "OpenGL Programming Guide", "Livros", 4, 89.90),
			new ProdutoPadrao( 9, "Vectrex", "Games", 1, 799.90),
			new ProdutoPadrao(10, "Carregador iPhone", "Telefonia", 15, 499.90),
			new ProdutoPadrao(11, "Introduction to Algorithms", "Livros", 7, 315.00),
			new ProdutoPadrao(12, "Daytona USA (Arcade)", "Games", 1, 12000.00),
			new ProdutoPadrao(13, "Neuromancer", "Livros", 5, 45.00),
			new ProdutoPadrao(14, "Nokia 3100", "Telefonia", 4, 249.99),
			new ProdutoPadrao(15, "Oculus Rift", "Games", 1, 3600.00),
			new ProdutoPadrao(16, "Trackball Logitech", "Informatica", 1, 250.00),
			new ProdutoPadrao(17, "After Burner II (Arcade)", "Games", 2, 8900.0),
			new ProdutoPadrao(18, "Assembly for Dummies", "Livros", 30, 129.90),
			new ProdutoPadrao(19, "iPhone (usado)", "Telefonia", 3, 3999.90),
			new ProdutoPadrao(20, "Game Programming Patterns", "Livros", 1, 299.90),
			new ProdutoPadrao(21, "Playstation 2", "Games", 10, 499.90),
			new ProdutoPadrao(22, "Carregador Nokia", "Telefonia", 14, 89.00),
			new ProdutoPadrao(23, "Placa Aceleradora Voodoo 2", "Informatica", 4, 189.00),
			new ProdutoPadrao(24, "Stunts", "Games", 3, 19.90),
			new ProdutoPadrao(25, "Carregador Generico", "Telefonia", 9, 30.00),
			new ProdutoPadrao(26, "Monitor VGA 14 polegadas", "Informatica", 2, 199.90),
			new ProdutoPadrao(27, "Nokia N-Gage", "Telefonia", 9, 699.00),
			new ProdutoPadrao(28, "Disquetes Maxell 5.25 polegadas (caixa com 10 unidades)", "Informatica", 23, 49.00),
			new ProdutoPadrao(29, "Alone in The Dark", "Games", 11, 59.00),
			new ProdutoPadrao(30, "The Art of Computer Programming Vol. 1", "Livros", 3, 240.00),
			new ProdutoPadrao(31, "The Art of Computer Programming Vol. 2", "Livros", 2, 200.00),
			new ProdutoPadrao(32, "The Art of Computer Programming Vol. 3", "Livros", 4, 270.00)
		});
	}

	// Implementa a leitura dos produtos do arquivo produtos.csv e retorna uma lista de produtos
	public static List<Produto> carregaProdutosCSV(String arquivo) throws IOException {
		List<Produto> produtos = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new FileReader(arquivo));
		String line = reader.readLine();
		while ((line = reader.readLine()) != null) {
			String[] fields = line.split(", ");
			int id = Integer.parseInt(fields[0]);
			String descricao = fields[1];
			String categoria = fields[2];
			int estoque = Integer.parseInt(fields[3]);
			double preco = Double.parseDouble(fields[4]);
			Produto produto = new ProdutoPadrao(id, descricao, categoria, estoque, preco);

			Boolean negrito = Boolean.parseBoolean(fields[5]);
			Boolean italico = Boolean.parseBoolean(fields[6]);
			String color = fields[7];

			if(negrito) produto = new ProdutoNegrito(produto);
			if(italico) produto = new ProdutoItalico(produto);
			if(!color.equals("#000000")) produto = new ProdutoColorido(produto, color);

			produtos.add(produto);
		}
		reader.close();
		return produtos;
	}

  public static void main(String [] args) {

		if(args.length < 8){

			System.out.println("Uso:");
			System.out.println("\tjava " + GeradorDeRelatorios.class.getName() + " <algoritmo> <critério de ordenação> <critério de filtragem> <parâmetro de filtragem> <opções de formatação>");
			System.out.println("Onde:");
			System.out.println("\talgoritmo: 'quick' ou 'insertion'");
			System.out.println("\tcriterio de ordenação: 'preco' ou 'descricao' ou 'estoque'");
      System.out.println("\t\tcritério de ordenação: 'asc' ou 'desc'");
			System.out.println("\tcriterio de filtragem: 'todos' ou 'estoque' ou 'categoria' ou 'preco' ou 'descricao'");
      System.out.println("\t\tcritério de filtragem: 'maior_igual' ou 'maior' ou 'igual' ou 'menor_igual' ou 'menor' ou 'diferente' ou 'contem' ou 'entre'");
			System.out.println("\tparâmetro de filtragem: argumentos adicionais necessários para a filtragem, separados por vírgula caso haja mais de um, como por exemplo: '10,25'"); 
			System.out.println("\torigem dos dados: 'estatico' ou 'csv', caso seja 'csv'");
			System.out.println("\t\tarquivo de origem dos dados: nome do arquivo CSV (Obs: deve estar na pasta do programa) preencher com qualquer coisa caso estático para poder inserir formatação");
			System.out.println("\topções de formatação: 'negrito' e/ou 'italico' e/ou 'colorido' e a cor desejada separada por virgula (colorido,corDesejada)");
			System.out.println();
			System.exit(1);
		}

		try {
			SortStrategy sortStrategySelected = Sort.sortOptions.get(SortTypes.valueOf(args[0].toUpperCase()));

			OrderStrategy orderStrategySelected = Order.orderOptions.get(OrderOptions.valueOf(args[1].toUpperCase()));

			OrderTypes orderTypeSelected = OrderTypes.valueOf(args[2].toUpperCase());

			FilterStrategy filterStrategySelected = args[3].equals("todos") ? new AllElementsFilter() : Filter.filterOptions.get(FilterOptions.valueOf(args[3].toUpperCase()));
			CompareStrategy compareStrategySelected = args[3].equals("todos") ? new AllCompare() : Compare.compareOptions.get(CompareOptions.valueOf(args[4].toUpperCase()));
			
			CompareOptions compareOp = CompareOptions.valueOf(args[4].toUpperCase());

			String filterValue1Selected = args[5].split(",")[0];
			String filterValue2Selected = args[5].split(",").length > 1 ? args[5].split(",")[1] : null;

			if (args.length > 8) {
				String [] formatArgs = new String[3];
				formatArgs[0] = args.length > 8 ? args[8] : null;
				formatArgs[1] = args.length > 9 ? args[9] : null;
				formatArgs[2] = args.length > 10 ? args[10] : null;
				
				for(int i = 0; i < formatArgs.length; i++) {
					if(formatArgs[i] != null) {
						if(formatArgs[i].indexOf(',') > -1) {
							String [] formatArgsSplit = formatArgs[i].split(",");
							if (formatArgsSplit[0].toUpperCase().equals(formatOptions.COLORIDO.toString())){
								Main.colorido = true;
								Main.color = formatArgsSplit[1];
							}
						} else if(formatArgs[i].toUpperCase().equals(formatOptions.NEGRITO.toString())) {
							Main.negrito = true;
						} else if(formatArgs[i].toUpperCase().equals(formatOptions.ITALICO.toString())) {
							Main.italico = true;
						}
					}
				}
			} else {
				Main.negrito = false;
				Main.italico = false;
				Main.colorido = false;
			}

			List<Produto> produtos = null;

			produtos = args[6].equals("estatico") ? carregaProdutosEstatico() : carregaProdutosCSV(args[7]);
			
			if(Main.negrito || Main.italico || Main.colorido) {
				for(int i = 0; i < produtos.size(); i++) {
					if(Main.negrito) produtos.set(i, new ProdutoNegrito(produtos.get(i)));
					if(Main.italico) produtos.set(i, new ProdutoItalico(produtos.get(i)));
					if(Main.colorido) produtos.set(i, new ProdutoColorido(produtos.get(i), Main.color));
				}
			}

			Compare compare = new Compare(compareOp, compareStrategySelected);

			Filter filter = new Filter(filterStrategySelected, compare);

			produtos = filter.filter(produtos, filterValue1Selected, filterValue2Selected);

			Order order = new Order(orderStrategySelected, orderTypeSelected);

			Sort sort = new Sort(sortStrategySelected, order);
			
			produtos = sort.ordena(produtos);

			GeradorDeRelatorios gdr = new GeradorDeRelatorios(produtos);
			gdr.geraRelatorio("saida.html");
		} catch (IOException e) {
			System.out.println("Erro ao carregar produtos do arquivo CSV!");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Erro ao gerar relatório!");
			e.printStackTrace();
		}
	}
}
