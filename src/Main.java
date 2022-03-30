import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        Cliente clienteTeste = new Cliente("Cliente Teste", "12345678900");
        Conta contaCorrenteTeste = new ContaCorrente(clienteTeste);
        Conta contaPoupancaTeste = new ContaPoupanca(clienteTeste);
        contaCorrenteTeste.depositar(1000);
        contaPoupancaTeste.depositar(2000);

        System.out.println("Digite a opcao desejada:");
        System.out.println("[1] - Cadastrar um cliente");
        System.out.println("[2] - Cadastrar uma conta");
        System.out.println("[3] - Fazer um deposito");
        System.out.println("[4] - Fazer um saque");
        System.out.println("[5] - Fazer uma transferencia");
        System.out.println("[6] - Imprimir extrato da conta");
        System.out.println("[0] - Sair");
        int opcao = leitor.nextInt();

        switch (opcao){
            case 1:
                System.out.println("Cadastro de Cliente");
                System.out.println("Nome do Cliente:");
                String nome = leitor.next();
                System.out.println("Documento do Cliente:");
                String documento = leitor.next();
                try{
                    Cliente clienteNovo = new Cliente(nome, documento);
                    clienteNovo.imprimirInfosCliente();
                }catch (Exception e){
                    System.err.println("Houve um erro ao adicionar cliente: " + e.getMessage());
                }
                break;
            case 2:
                System.out.println("Cadastro de Conta");
                System.out.println("Informe o tipo conta [1] - Conta corrente  [2] - Conta Poupanca: ");
                int tipoConta = leitor.nextInt();

                try{
                    if (tipoConta==1) {
                        Conta conta = new ContaCorrente(clienteTeste);
                        System.out.println("Conta corrente criada");
                        conta.imprimirInfosComuns();
                    }
                    else if(tipoConta==2){
                        Conta conta = new ContaPoupanca(clienteTeste);
                        System.out.println("Conta poupanca criada");
                        conta.imprimirInfosComuns();
                    }
                    else{
                        System.out.println("Tipo de conta invalido");
                    }
                }catch (Exception e){
                    System.err.println("Houve um erro ao adicionar conta: " + e.getMessage());
                }

                break;
            case 3:
                System.out.println("Depósito");
                System.out.println("Valor do deposito: ");
                double valorDeposito = leitor.nextDouble();
                try {
                    contaCorrenteTeste.depositar(valorDeposito);
                    contaCorrenteTeste.imprimirExtrato();
                }catch (Exception e){
                    System.err.println("Houve um erro ao depositar o valor na conta: " + e.getMessage());
                }
                break;
            case 4:
                System.out.println("Saque");
                System.out.println("Valor do saque: ");
                double valorSaque = leitor.nextDouble();
                try {
                    contaPoupancaTeste.sacar(valorSaque);
                    contaPoupancaTeste.imprimirExtrato();
                }catch (Exception e){
                    System.err.println("Houve um erro ao sacar o valor da conta: " + e.getMessage());
                }
                break;
            case 5:
                System.out.println("Transferência");
                System.out.println("Valor da transferencia: ");
                double valorTransferencia = leitor.nextDouble();
                contaCorrenteTeste.transferir(valorTransferencia, contaPoupancaTeste);
                System.out.println("Transferido valor da conta corrente para poupança");
                contaCorrenteTeste.imprimirExtrato();
                contaPoupancaTeste.imprimirExtrato();
                break;
            case 6:
                System.out.println("Extrato da Conta");
                contaCorrenteTeste.imprimirExtrato();
                break;
            case 0 :
                System.exit(0);
            default:
                System.out.println("Opção inválida");
         }

        //Cliente cliente = new Cliente("Rayne","094.194.516-23" );
        //cliente.setNome("Rayne");

//        Conta contaCorrente = new ContaCorrente(cliente);
//        contaCorrente.depositar(100);
//
//        Conta contaPoupanca = new ContaPoupanca(cliente);
//        contaPoupanca.depositar(200);
//
//        contaCorrente.transferir(50, contaPoupanca);
//
//        contaCorrente.imprimirExtrato();
//        contaPoupanca.imprimirExtrato();
//
//        cliente.imprimirInfosCliente();

    }
}
