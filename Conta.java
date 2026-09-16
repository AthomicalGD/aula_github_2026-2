public class Conta extends ContaAbstract {
    public Conta(int contaId, int clienteId, float saldo) {
        super(contaId, clienteId, saldo);
    }
    // implementar aqui o override das funções de realizar depósito e de realizar saque
    @Override
    public void realizarSaque(float valor) {
        //responsável implementará depois
    }

    @Override
    public void realizarDeposito(float valor) {
        //responsável implementará depois
    }
}
