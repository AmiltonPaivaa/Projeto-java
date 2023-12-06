package model;

public class ListaDeCompras extends Lista {
	public ListaDeCompras() {
		super();
	}

	@Override
	public double calcularTotal() {
		double total = 0;
		for (Produtos produto : produtos) {
			total += produto.getPreco()* produto.getQuantidade();
		}
		return total;
	}
}
