import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
  
  public static void main(String[] args) {
    Menu mainMenu = new Menu("Menu Principal", Arrays.asList("Conta", "Cliente", "Operacoes"));
    int selecionado = mainMenu.getSelection();
    if(selecionado == 1){
      Menu contaMenu = new Menu("Menu Conta", Arrays.asList("Abrir Conta"));
      int opcaoConta = contaMenu.getSelection();
      if(opcaoConta == 1){
        abrirConta();
      }
    }
    else if (selecionado == 2) {
      Menu clienteMenu = new Menu("Menu Cliente", Arrays.asList("Listar Clientes cadastrados", "Editar dados do Cliente"));
      int opcaoCliente = clienteMenu.getSelection();
      if (opcaoCliente == 1) {
        listarClientes();
      } else if (opcaoCliente == 2) {
        editarCliente();
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

  public static void abrirConta(){
    Scanner scanner = new Scanner(System.in);
    listarClientes();
    System.out.println("Informe o ID do cliente para abrir uma nova conta:");
    int id = Integer.parseInt(scanner.nextLine());
    Cliente cliente = ClienteRepository.buscarPorId(id);
    if (cliente == null) {
      System.out.println("Cliente nao encontrado.");
      return;
    }

    System.out.println("Informe o saldo inicial da conta:");
    float saldoInicial = Float.parseFloat(scanner.nextLine());

    int idContaNova = ContaRepository.getProximoId();

    Conta novaConta = new Conta(idContaNova, cliente.getId(), saldoInicial);
    ContaRepository.adicionar(novaConta);

    System.out.println("Conta criada com sucesso! ID da Conta: " + idContaNova);
  }
  
}