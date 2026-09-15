import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
  private static List<Cliente> clientes = new ArrayList<>();
  private static int proximoId = 1;

static {
  clientes.add(new Cliente(proximoId++, "Maria Silva", "111.111.111-11", "(86) 99999-0001", "Rua A, 100"));
  clientes.add(new Cliente(proximoId++, "Joao Souza", "222.222.222-22", "(86) 99999-0002", "Rua B, 200"));
}

public static List<Cliente> listar() {
  return clientes;
}

public static Cliente buscarPorId(int id) {
  for (Cliente c : clientes) {
    if (c.getId() == id) {
      return c;
    }
  }
  return null;
}

public static void adicionar(Cliente cliente) {
  clientes.add(cliente);
}
}
