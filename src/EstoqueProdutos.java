import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EstoqueProdutos {
	List<Produto> listaProdutos = new ArrayList<Produto>();

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}
	
	private static EstoqueProdutos instancia;
	
	public static EstoqueProdutos getInstancia()
    {
      if (instancia == null)
      {
         instancia = new EstoqueProdutos();
      }
      return instancia;
    }

	public void setListaProtudos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
	
	public List<Produto> listarMaisVendidos(int quantidade){
		
		List<Produto> lista = this.listaProdutos;
		List<Produto> listaMaisVendidos = new ArrayList<Produto>();
		
		int vetorQtvendidos[] = new int[lista.size()];
		int ids[] = new int[lista.size()];
		
		for(int i = 0; i < lista.size(); i++) {
			vetorQtvendidos[i] = lista.get(i).getQtVendidos();
			ids[i] = lista.get(i).getId();
		}

		
		quickSort(vetorQtvendidos, ids, 0, lista.size() - 1);
		
		for(int i = 0; i < ids.length; i++) {
				System.out.println(ids[i]);
			}
				
		for(int i = ids.length - 1; i >= ids.length - quantidade ; i--) {
			for(int j = 0; j < lista.size(); j++) {
				if(ids[i] == lista.get(j).getId()) {
					listaMaisVendidos.add(lista.get(j));
				}
			}
		}
		
		return listaMaisVendidos;
	}
	
	//Retira de estoque em um venda.
	public void gerenciaProdutos(List<Produto> lista) {
		for(int i = 0; i < lista.size(); i++) {
			for(int j = 0; j < this.listaProdutos.size(); j++) {
				if(lista.get(i).getId() == this.listaProdutos.get(j).getId()) {
					this.listaProdutos.get(j).vendeItem();
					break;
				}
			}
		}
	}

	@Override
	public String toString() {
		return "EstoqueProdutos [listaProdutos=" + listaProdutos + "]";
	}
	
    private static int separar(int[] vetor_qt, int[] vetor_id, int inicio, int fim) {
        int pivo = vetor_qt[inicio];
        int pivo_id = vetor_id[inicio];
        int i = inicio + 1, f = fim;
        while (i <= f) {
               if (vetor_qt[i] <= pivo)
                      i++;
               else if (pivo < vetor_qt[f])
                      f--;
               else {
                      int troca = vetor_qt[i];
                      vetor_qt[i] = vetor_qt[f];
                      vetor_qt[f] = troca;
                      
                      troca = vetor_id[i];
                      vetor_id[i] = vetor_id[f];
                      vetor_id[f] = troca;
                      i++;
                      f--;
               }
        }
        vetor_qt[inicio] = vetor_qt[f];
        vetor_qt[f] = pivo;
        
        vetor_id[inicio] = vetor_id[f];
        vetor_id[f] = pivo_id;
        
        return f;
  }
	
    private static void quickSort(int[] vetor_qt, int[] vetor_id, int inicio, int fim) {
        if (inicio < fim) {
               int posicaoPivo = separar(vetor_qt, vetor_id, inicio, fim);
               quickSort(vetor_qt, vetor_id, inicio, posicaoPivo - 1);
               quickSort(vetor_qt, vetor_id, posicaoPivo + 1, fim);
        }
  }
	
	
}