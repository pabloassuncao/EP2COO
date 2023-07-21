package Sort;

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

  private int particiona(int ini, int fim){

		Produto x = produtosOrdenados.get(ini);
		int i = (ini - 1);
		int j = (fim + 1);

		while(true){
				do{ 
					j--;

				} while(criterio.compare(produtosOrdenados.get(j), x));
			
				do{
					i++;

				} while(criterio.compare(produtosOrdenados.get(i), x));

			if(i < j){
				Produto temp = produtosOrdenados.get(i);
				produtosOrdenados.set(i, produtosOrdenados.get(j));		
				produtosOrdenados.set(j, temp);
			} else return j;
		}
	}
  

  // private int particiona(List<Produto> produtos, int ini, int fim) {
  //   Produto x = produtos.get(ini);
	// 	int i = (ini - 1);
	// 	int j = (fim + 1);

	// 	while(true){
  //     do{ 
  //       j--;
  //     } while(criterio.compare(produtos.get(j), x));
    
  //     do{
  //       i++;
  //     } while(criterio.compare(produtos.get(i), x));

  //     if(i < j){
  //       Produto temp = produtos.get(i);
  //       produtos.set(i, produtos.get(j));		
  //       produtos.set(j, temp);
  //     } else return j;
  //   }
  // }

  public void quickSort(int ini, int fim) {
      if(ini < fim) {

				int q = particiona(ini, fim);
				
				quickSort(ini, q);
				quickSort(q + 1, fim);
			}
  }

  public List<Produto> ordena(List<Produto> produtos) {
    this.produtosOrdenados = produtos;

    this.quickSort(0, produtosOrdenados.size());
  
    return produtosOrdenados;
  }
}
