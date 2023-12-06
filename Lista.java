package model;


import java.util.ArrayList;

public abstract class Lista {
	protected ArrayList<Produtos> produtos;

	public Lista() {
		produtos = new ArrayList<>();
	}

	public void adicionarProduto(Produtos produto) {
		produtos.add(produto);
	}

	public void removerProduto(Produtos produto) {
		produtos.remove(produto);
	}

	public void listarProdutos() {
		for (Produtos produto : produtos) {
			System.out.println(produto);
		}
	}

	public abstract double calcularTotal();

	public ArrayList<Produtos> getProdutos() {
		return this.produtos;
	}
}