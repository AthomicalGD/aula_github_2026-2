 public final class Operacoes {

      private Operacoes() {}

      public static void saque(ContaInterface conta, float valor){
          conta.setSaldo(conta.getSaldo() - valor);
   }
  }
