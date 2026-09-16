import java.util.Arrays;
import java.util.Scanner;

public class Main {

public static void main(String[] args) {
	Menu mainMenu = new Menu("Menu Principal", Arrays.asList("Conta", "Cliente", "Operacoes"));
	int selecionado = mainMenu.getSelection();
	if (selecionado == 2) {
		Menu clienteMenu = new Menu("Menu Cliente", Arrays.asList("Editar dados do Cliente"));
		int opcao = clienteMenu.getSelection();
		if (opcao == 1) {
			editarCliente();
		}
	} else {
		System.out.println(selecionado + "foi selecionada");
	}
	System.out.println("Fim");
}

public static void editarCliente() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Informe o ID do cliente a editar:");
	int id = Integer.parseInt(scanner.nextLine());
	Cliente cliente = ClienteRepository.buscarPorId(id);
	if (cliente == null) {
		System.out.println("Cliente nao encontrado.");
		return;
	}
	System.out.println("Novo nome (deixe em branco para manter '" + cliente.getNome() + "'):");
	String nome = scanner.nextLine();
	if (!nome.isBlank()) {
		cliente.setNome(nome);
	}
	System.out.println("Novo telefone (deixe em branco para manter '" + cliente.getTelefone() + "'):");
	String telefone = scanner.nextLine();
	if (!telefone.isBlank()) {
		cliente.setTelefone(telefone);
	}
	System.out.println("Novo endereco (deixe em branco para manter '" + cliente.getEndereco() + "'):");
	String endereco = scanner.nextLine();
	if (!endereco.isBlank()) {
		cliente.setEndereco(endereco);
	}
	System.out.println("Cliente atualizado: " + cliente);
}

}
