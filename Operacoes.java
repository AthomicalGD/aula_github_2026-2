 public final class Operacoes {

      private Operacoes() {}

      public static void deposito(ContaInterface conta, int valor) {
          conta.setSaldo(conta.getSaldo() + valor);
      }
  }
