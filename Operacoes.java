public final class Operacoes {

  private Operacoes() {
  }

  public static void deposito(ContaAbstract conta, float valor) {
    conta.realizarDeposito(valor);
  }

  public static void saque(ContaAbstract conta, float valor) {
    conta.realizarSaque(valor);
  }
}
