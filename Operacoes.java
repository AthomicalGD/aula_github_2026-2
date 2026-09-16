public final class Operacoes {

  private Operacoes() {
  }

  public static void saque(ContaAbstract conta, float valor) {
    conta.setSaldo(conta.getSaldo() - valor);
  }
}
