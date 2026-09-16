public abstract class ContaAbstract {
  protected int contaId;
  protected int clienteId;
  protected float saldo;

  public ContaAbstract(int contaId, int clienteId, float saldo) {
    this.contaId = contaId;
    this.clienteId = clienteId;
    this.saldo = saldo;
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

  // métodos que podem mudar se tiver diferentes tipos de conta
  public abstract void realizarSaque(float valor);
  public abstract void realizarDeposito(float valor);

  public void transferir(ContaAbstract destino, float valor) { this.realizarSaque(valor); destino.realizarDeposito(valor); }
}