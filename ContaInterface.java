interface ContaInterface {
  private int contaId;
  private int clienteId;
  private float saldo;
  
  public float getSaldo();
  public void realizarTransferencia();
  public void realizarSaque();
  public void realizarDeposito();

}
