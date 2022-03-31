public abstract class Conta implements IConta{

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int NumeroConta;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.NumeroConta = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        if(valor>0) {
            if (this.saldo >= valor) {
                this.saldo -= valor;
            } else {
                throw new RuntimeException("Saldo indisponivel");
            }
        }
        else{
            throw new RuntimeException("Valor deve ser positivo");
        }
    }

    @Override
    public void depositar(double valor) {
        if (valor>0){
            this.saldo += valor;
        }else{
            throw new RuntimeException("Valor deve ser positivo");
        }
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if(this.saldo >= valor){
            this.sacar(valor);
            contaDestino.depositar(valor);
        }else{
            throw new RuntimeException("Saldo indisponivel");
        }
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.NumeroConta));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumeroConta() {
        return NumeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

}
