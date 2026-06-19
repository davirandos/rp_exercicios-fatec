package biblioteca;
import javax.swing.JOptionPane;


public class Livro {
	private String titulo;
	private String autor;
	private int quantExemplares;
	
	static Livro[] livros = new Livro[100];
	static int totalLivros = 0;
	
	public Livro(String titulo, String autor, int quantExemplares) {
		this.titulo = titulo;
		this.autor = autor;
		this.quantExemplares = quantExemplares;
	}
	
	public static void main(String[] args) {
		String[] menuOptions = {
				"Adicionar um livro", 
				"Atualizar quantidade",
				"Consultar livro pelo título",
				"Listar todos os livros com quantidade abaixo de 10 exemplares",
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
					adicionarLivro();
					break;
				case 1:
					atualizarQuantidade();
					break;
				case 2:
					consultarLivro();
					break;
				case 3:
					listarLivros();
					break;
			}
		}
	}
	
	public static void adicionarLivro() {
		String titulo = JOptionPane.showInputDialog("Digite o título do livro:");
		while(titulo == null || titulo.isEmpty()) {
			titulo = JOptionPane.showInputDialog("Digite um título válido:");
		}
		
		
		String autor = JOptionPane.showInputDialog("Digite o nome do autor:");
		while(autor == null || autor.isEmpty()) {
			autor = JOptionPane.showInputDialog("Digite um nome válido:");
		}
		
		int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de exemplares disponíveis:"));
		while(quantidade < 0) {
			quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite uma quantidade válida de exemplares:"));
		}
		
		livros[totalLivros] = new Livro(titulo, autor, quantidade);
		totalLivros++;
		
		JOptionPane.showMessageDialog(null, "Livro adicionado à biblioteca.");	
	}
	
	public static void atualizarQuantidade() {
		String busca = JOptionPane.showInputDialog("Digite o título do livro que busca atualizar a quantidade:");
		while(busca == null || busca.isEmpty()) {
			busca = JOptionPane.showInputDialog("Digite um título válido:");
		}
		
		for(int i = 0; i < totalLivros; i++) {
			
			if(livros[i].titulo.equals(busca)) {
				int novaQuantidade = Integer.parseInt(JOptionPane.showInputDialog("Livro encontrado. Digite a nova quantidade:"));
				
				livros[i].quantExemplares = novaQuantidade;
				JOptionPane.showMessageDialog(null, "Quantidade atualizada.");
				return;
			}
		}
		
		JOptionPane.showMessageDialog(null, "Nenhum livro encontrado com esse nome.");
	}
	
	public static void consultarLivro() {
		String busca = JOptionPane.showInputDialog("Digite o título do livro que deseja consultar:");
		while(busca == null || busca.isEmpty()) {
			busca = JOptionPane.showInputDialog("Digite um título válido:");
		}
		
		for(int i = 0; i < totalLivros; i++) {
			
			if(livros[i].titulo.equals(busca)) {
				JOptionPane.showMessageDialog(null, 
						"Livro:" + livros[i].titulo
						+ "\nAutor:" + livros[i].autor
						+ "\nQuantidade:" + livros[i].quantExemplares);
				return;
			}
		}
		
		JOptionPane.showMessageDialog(null, "Nenhum livro encontrado com esse nome");
	}
	
	public static void listarLivros() {
		String lista = "";
		
		for(int i = 0; i < totalLivros; i++) {
			
			if(livros[i].quantExemplares < 10) {
				lista += "Nome:" + livros[i].titulo;
				lista += "\nAutor:" + livros[i].autor;
				lista += "\nQuantidade:" + livros[i].quantExemplares + "\n\n";
			}
		}
		
		if(lista.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nenhum livro com quantidade de exemplares abaixo de 10 encontrado.");
		} else {
			JOptionPane.showMessageDialog(null, lista);
		}
	}
	
}
