import java.util.ArrayList;

public abstract class ContaAbstract {

  protected int contaId;
  protected int clienteId;
  protected float saldo;

  protected ArrayList<String> transacoes;

  public ContaAbstract(int contaId, int clienteId, float saldo) {
    this.contaId = contaId;
    this.clienteId = clienteId;
    this.saldo = saldo;
    this.transacoes = new ArrayList<>();
  }

  public float getSaldo() {
    return this.saldo;
  }

  public int getContaId() {
    return this.contaId;
  }

  public int getClienteId() {
    return this.clienteId;
  }

  public abstract void realizarSaque(float valor);

  public abstract void realizarDeposito(float valor);

  public void transferir(ContaAbstract destino, float valor) {
    this.realizarSaque(valor);
    destino.realizarDeposito(valor);

    this.transacoes.add(
        "TRANSFERÊNCIA ENVIADA: R$ " + valor +
            " para a conta " + destino.getContaId());

    destino.transacoes.add(
        "TRANSFERÊNCIA RECEBIDA: R$ " + valor +
            " da conta " + this.getContaId());
  }

  public void imprimirTransferencias() {
    System.out.println("Transferências da conta " + this.contaId + ":");

    for (String transacao : transacoes) {
      if (transacao.startsWith("TRANSFERÊNCIA")) {
        System.out.println(transacao);
      }
    }
  }
}
