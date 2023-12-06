package View;

import java.util.Scanner;

import model.ListaDeCompras;
import model.Produtos;

public class ListaDeComprasView {
	private Scanner scanner;
	private ListaDeCompras listaDeCompras;

	public ListaDeComprasView() {
		scanner = new Scanner(System.in);
		listaDeCompras = new ListaDeCompras();
	}

	public void exibirMenu() {
		System.out.println("------------------------------------------------------------------");
		System.out.println("------------------------ Lista de Compras ------------------------");
		System.out.println("------------------------------------------------------------------");
		System.out.println("     ***** Selecione uma operação que deseja realizar *****");
		System.out.println("------------------------------------------------------------------");
		System.out.println("---------------------------- Menu --------------------------------");
		System.out.println("1. Adicionar produtos ");
		System.out.println("2. Remover produtos ");
		System.out.println("3. Listar produtos");
		System.out.println("4. Calcular produtos");
		System.out.println("5. Finalizar compra");
		System.out.println("0. Sair");
	}

	public void lerOpcao() {
		int opcao = -1;

		while (opcao != 0) {
			exibirMenu();
			System.out.print("Escolha uma opção: ");
			opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
			case 1:
				adicionarProduto();
				break;
			case 2:
				removerProduto();
				break;
			case 3:
				listarProdutos();
				break;
			case 4:
				calcularTotal();
				break;
			case 5:
				finalizarCompra();
				break;
			case 0:
				System.out.println("Saindo...");
				break;
			default:
				System.out.println("Opção inválida.");
				break;
				
			}
		}
	}

	public void adicionarProduto() {
		System.out.print("Digite o nome do produto: ");
		String nome = scanner.nextLine();
		System.out.print("Digite o preço do produto: ");
		double preco = scanner.nextDouble();
		System.out.print("Digite a quantidade do produto: ");
		int quantidade = scanner.nextInt();
		scanner.nextLine();

		Produtos produto = new Produtos(nome, preco, quantidade);
		listaDeCompras.adicionarProduto(produto);
		System.out.println("Produto adicionado à lista.");
	}
	public void removerProduto() {
		System.out.print("Digite o nome do produto que deseja remover: ");
		String nome = scanner.nextLine();

		for (Produtos produto : listaDeCompras.getProdutos()) {
			if (produto.getNome().equalsIgnoreCase(nome)) {
				listaDeCompras.removerProduto(produto);
				System.out.println("Produto removido da lista.");
				return;
			}
		}

		System.out.println("Produto não encontrado na lista.");
	}

	public void listarProdutos() {
		listaDeCompras.listarProdutos();
	}

	public void calcularTotal() {
		double total = listaDeCompras.calcularTotal();
		System.out.println("Total da compra: R$" + total);
	}

	public void finalizarCompra() {
		System.out.println("\nLista Finalizada!\nContinue comprando...");
		return;
	}
}
