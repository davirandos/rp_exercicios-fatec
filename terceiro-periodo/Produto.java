package estoque;
import javax.swing.JOptionPane;

public class Produto {
	private String nome;
	private int quantidade;
	private double preco;
	
	static Produto[] produtos = new Produto[100];
	static int totalProdutos = 0;
	
	public Produto(String nome, int quantidade, double preco) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	public static void main(String[] args) {
		String[] menuOptions = {
				"Adicionar um novo produto", 
				"Atualizar a quantidade de um produto", 
				"Consultar o preço de um produto", 
				"Listar todos os produtos com estoque abaixo de um valor mínimo", 
				"Sair"
		};
		
		while(true) {
			int menu = JOptionPane.showOptionDialog(
					null, 
					"Escolha uma opção:", 
					"Menu", 
					JOptionPane.DEFAULT_OPTION, 
					JOptionPane.QUESTION_MESSAGE, 
					null, 
					menuOptions, 
					menuOptions[0]);
			
			if(menu == 4 || menu == -1) {
				break;
			}
			
			switch(menu) {
				case 0:
					adicionarProduto();
					break;
				case 1:
					atualizarQuantidade();
					break;
				case 2:
					consultarPreco();
					break;
				case 3: 
					listarProdutos();
					break;
			}
		}
	}
	
	public static void adicionarProduto() {
		String nome = JOptionPane.showInputDialog("Digite o nome do produto:");
		while(nome == null || nome.isEmpty()) {
			nome = JOptionPane.showInputDialog("Digite um nome válido:");
		}
		
		int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade em estoque do produto:"));
		while(quantidade < 0) {
			quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite uma quantidade válida para o produto:"));
		}
		
		double preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do produto:"));
		while(preco <= 0) {
			preco = Double.parseDouble(JOptionPane.showInputDialog("Digite um valor válido para o produto:"));
		}
		
		produtos[totalProdutos] = new Produto(nome, quantidade, preco);
		totalProdutos++;
		
		JOptionPane.showMessageDialog(null, "Produto adicionado ao estoque.");
	}
	
	public static void atualizarQuantidade() {
		String busca = JOptionPane.showInputDialog("Digite o nome do produto que deseja atualizar a quantidade em estoque:");
		while(busca == null || busca.isEmpty()) {
			busca = JOptionPane.showInputDialog("Digite um nome válido para o produto que deseja atualizar a quantidade em estoque:");
		}
		
		for(int i = 0; i < totalProdutos; i++) {
			
			if(produtos[i].nome.equals(busca)) {
				int quantidadeNova = Integer.parseInt(JOptionPane.showInputDialog("Digite a nova quantidade do produto:"));
				
				produtos[i].quantidade = quantidadeNova;
				
				JOptionPane.showMessageDialog(null, "Quantidade atualizada!");
				return;
			}
		}
		
		JOptionPane.showMessageDialog(null, "Produto não encontrado.");
	}
	
	public static void consultarPreco() {
		String busca = JOptionPane.showInputDialog("Digite o nome do produto que deseja consultar o preço:");
		while(busca == null || busca.isEmpty()) {
			busca = JOptionPane.showInputDialog("Digite um nome de produto válido para consultar o preço:");
		}
		
		for(int i = 0; i < totalProdutos; i++) {
			
			if(produtos[i].nome.equals(busca)) {
				JOptionPane.showMessageDialog(null, "Produto encontrado."
						+ "\n\tNome: " + produtos[i].nome
						+ "\n\tQuantidade: " + produtos[i].quantidade
						+ "\n\tPreço: " + produtos[i].preco);
				return;
			}
		}
		
		JOptionPane.showMessageDialog(null, "Produto não encontrado.");
	}
	
	public static void listarProdutos() {
		String lista = "";
		
		int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um valor para consultar os produtos com estoque abaixo desse: "));
		while(valor <= 0) {
			valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um valor para consultar os produtos com estoque abaixo desse: "));
		}
		
		for(int i = 0; i < totalProdutos; i++) {
			
			if(produtos[i].preco < valor) {
				lista += "Nome: " + produtos[i].nome + "\n";
				lista += "Quantidade: " + produtos[i].quantidade + "\n";
				lista += "Preço: " + produtos[i].preco + "\n";
			}
		}
		if(lista.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Sem produtos com quantidade menor que o do digitado.");
		} else {
			JOptionPane.showMessageDialog(null, lista);
		}
	}
}


