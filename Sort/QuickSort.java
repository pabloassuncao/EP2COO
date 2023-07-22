package Sort;

import java.util.Collections;
import java.util.List;

import Order.Order;
import Produto.Produto;

public class QuickSort implements SortStrategy {
  private Order criterio;
  private List<Produto> produtosOrdenados;

  public Order getOrder() {
    return this.criterio;
  }

  public void setOrder(Order order) {
    this.criterio = order;
  }

  private int particiona(List<Produto> produtos, int ini, int fim){
		Produto x = produtos.get(ini);
		int i = (ini - 1);
		int j = (fim + 1);

		while(true){
				do{ 
					j--;
				} while(criterio.compare(x, produtosOrdenados.get(j)));
			
				do{
					i++;
				} while(criterio.compare(produtosOrdenados.get(i), x));

			if(i < j){
        Collections.swap(produtos, i, j);
			} else return j;
		}
	}

  public void quickSort(List<Produto> produtosOrdenados, int ini, int fim) {
      if(ini < fim) {

				int q = particiona(produtosOrdenados, ini, fim);
				
				quickSort(produtosOrdenados, ini, q);
				quickSort(produtosOrdenados, q + 1, fim);
			}
  }

  public List<Produto> ordena(List<Produto> produtos) {
    this.produtosOrdenados = produtos;

    this.quickSort(produtosOrdenados, 0, produtosOrdenados.size()-1);
  
    return produtosOrdenados;
  }
}
