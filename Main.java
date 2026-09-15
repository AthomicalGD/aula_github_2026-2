import java.util.Arrays;
import java.util.List;

public class Main {

public static void main(String[] args) {
	Menu mainMenu = new Menu("Menu Principal", Arrays.asList("Conta", "Cliente", "Operacoes"));
	int selecionado = mainMenu.getSelection();

	if (selecionado == 2) {
		Menu clienteMenu = new Menu("Menu Cliente", Arrays.asList("Listar Clientes cadastrados"));
		int opcaoCliente = clienteMenu.getSelection();
		if (opcaoCliente == 1) {
			listarClientes();
		}
	} else {
		System.out.println(selecionado + "foi selecionada");
	}

	System.out.println("Fim");
}

private static void listarClientes() {
	List<Cliente> clientes = ClienteRepository.listar();
	if (clientes.isEmpty()) {
		System.out.println("Nenhum cliente cadastrado.");
		return;
	}
	System.out.println("\n=== Clientes cadastrados ===");
	for (Cliente c : clientes) {
		System.out.println(c);
	}
}
}
