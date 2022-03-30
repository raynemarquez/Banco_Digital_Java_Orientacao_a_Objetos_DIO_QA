public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNome("Rayne");

        Conta contaCorrente = new ContaCorrente(cliente);
        contaCorrente.depositar(100);

        Conta contaPoupanca = new ContaPoupanca(cliente);
        contaPoupanca.depositar(200);

        contaCorrente.transferir(50, contaPoupanca);

        contaCorrente.imprimirExtrato();
        contaPoupanca.imprimirExtrato();

    }
}
