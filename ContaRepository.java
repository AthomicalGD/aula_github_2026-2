import java.util.ArrayList;
import java.util.List;

public class ContaRepository {

  private static List<Conta> Contas = new ArrayList<>();
  private static int proximoId = 1;

  public static int getProximoId() {
    return proximoId++;
  }

  public static List<Conta> listar() {
    return Contas;
  }

  public static Conta buscarPorId(int id) {
    for (Conta c : Contas) {
      if (c.getContaId() == id) {
        return c;
      }
    }
    return null;
  }

  public static void adicionar(Conta conta) {
    Contas.add(conta);
  }
}
