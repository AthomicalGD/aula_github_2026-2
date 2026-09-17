public class Conta extends ContaAbstract {

    public Conta(int contaId, int clienteId, float saldo) {
        super(contaId, clienteId, saldo);
    }

    @Override
    public void realizarSaque(float valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException(
                "O valor do saque deve ser positivo."
            );
        }

        if (valor > saldo) {
            throw new IllegalArgumentException(
                "Saldo insuficiente."
            );
        }

        saldo -= valor;

        transacoes.add(
            "SAQUE: R$ " + valor
        );
    }

    @Override
    public void realizarDeposito(float valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException(
                "O valor do depósito deve ser positivo."
            );
        }

        saldo += valor;

        transacoes.add(
            "DEPÓSITO: R$ " + valor
        );
    }
}

