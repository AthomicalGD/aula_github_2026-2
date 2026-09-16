 public final class Operacoes {

      private Operacoes() {}

      public static void deposito(ContaInterface conta, float valor) {
          conta.setSaldo(conta.getSaldo() + valor);
      }
  }
