import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import Filter.*;
import Filter.Compare.Compare;
import Filter.Compare.CompareOptions;
import Filter.Compare.CompareStrategy;
import GeradorDeRelatório.GeradorDeRelatorios;
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

	// operador bit a bit "ou" pode ser usado para combinar mais de  
	// um estilo de formatacao simultaneamente (veja como no main)
	public static final int FORMATO_PADRAO  = 0b0000;
	public static final int FORMATO_NEGRITO = 0b0001;
	public static final int FORMATO_ITALICO = 0b0010;

  public static List<Produto> carregaProdutos(){
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

  public static void main(String [] args) {

		if(args.length < 6){

			System.out.println("Uso:");
			System.out.println("\tjava " + GeradorDeRelatorios.class.getName() + " <algoritmo> <critério de ordenação> <critério de filtragem> <parâmetro de filtragem> <opções de formatação>");
			System.out.println("Onde:");
			System.out.println("\talgoritmo: 'quick' ou 'insertion'");
			System.out.println("\tcriterio de ordenação: 'preco' ou 'descricao' ou 'estoque'");
      System.out.println("\t\tcritério de ordenação: 'asc' ou 'desc'");
			System.out.println("\tcriterio de filtragem: 'todos' ou 'estoque' ou 'categoria' ou 'preco' ou 'descricao'");
      System.out.println("\t\tcritério de filtragem: 'maior_igual' ou 'maior' ou 'igual' ou 'menor_igual' ou 'menor' ou 'diferente' ou 'contem'");
			System.out.println("\tparâmetro de filtragem: argumentos adicionais necessários para a filtragem, separados por vírgula caso haja mais de um, como por exemplo: '10,25'"); 
			System.out.println("\topções de formatação: 'negrito' e/ou 'italico'");
			System.out.println();
			System.exit(1);
		}

      SortStrategy sortStrategySelected = Sort.sortOptions.get(SortTypes.valueOf(args[0].toUpperCase()));

      OrderStrategy orderStrategySelected = Order.orderOptions.get(OrderOptions.valueOf(args[1].toUpperCase()));

      OrderTypes orderTypeSelected = OrderTypes.valueOf(args[2].toUpperCase());

      FilterStrategy filterStrategySelected = args[3].equals("todos") ? null : Filter.filterOptions.get(FilterOptions.valueOf(args[3].toUpperCase()));
      CompareStrategy compareStrategySelected = Compare.compareOptions.get(CompareOptions.valueOf(args[4].toUpperCase()));
      
      CompareOptions compareOp = CompareOptions.valueOf(args[4].toUpperCase());

      String filterValue1Selected = args[5].split(",")[0];
      String filterValue2Selected = args[5].split(",").length > 1 ? args[5].split(",")[1] : null;
      
      String [] formatOptions = new String[2];
      formatOptions[0] = args.length > 6 ? args[6] : null;
      formatOptions[1] = args.length > 7 ? args[7] : null;
      int formato = FORMATO_PADRAO;
      
      for(int i = 0; i < formatOptions.length; i++) {

        String op = formatOptions[i];
        formato |= (op != null ? op.equals("negrito") ? FORMATO_NEGRITO : (op.equals("italico") ? FORMATO_ITALICO : 0) : 0); 
      }

      if(sortStrategySelected == null || orderStrategySelected == null || orderTypeSelected == null || (filterStrategySelected == null && !args[3].equals("todos")) || compareStrategySelected == null || filterValue1Selected == null) {
        System.out.println("Alguma opção está inválida! Encontramos:");
        System.out.println("Algoritmo: " + sortStrategySelected);
        System.out.println("Criterio de ordenação: " + orderStrategySelected);
        System.out.println("Ordem: " + orderTypeSelected);
        System.out.println("Filtro: " + filterStrategySelected);
        System.out.println("Comparação do filtro: " + compareStrategySelected);
        System.out.println("Valor do filtro 1: " + filterValue1Selected);
        System.out.println("Valor do filtro 2: " + filterValue2Selected);
        System.exit(1);
      }

      List<Produto> produtos = carregaProdutos();

      Compare compare = new Compare(compareOp, compareStrategySelected);

      Filter filter = new Filter(filterStrategySelected, compare);

      produtos = filter.filter(produtos, filterValue1Selected, filterValue2Selected);

      Order order = new Order(orderStrategySelected, orderTypeSelected);

      Sort sort = new Sort(sortStrategySelected, order);
      
      produtos = sort.ordena(produtos);

		try{

      GeradorDeRelatorios gdr = new GeradorDeRelatorios(produtos, formato);
			gdr.geraRelatorio("saida.html");
		}
		catch(IOException e){
			
			e.printStackTrace();
		}
	}
}
