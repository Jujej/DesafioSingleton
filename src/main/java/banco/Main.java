package banco;

public class Main {
    public static void main(String[] args) {
        // Criando clientes
        Cliente cliente1 = new Cliente("001", "João", 1000.0);
        Cliente cliente2 = new Cliente("002", "Maria", 500.0);

        // Operações
        cliente1.depositar(200.0);
        cliente1.sacar(150.0);

        cliente2.depositar(300.0);
        cliente2.sacar(1000.0); // saldo insuficiente

        // Ver saldo
        cliente1.verSaldo();
        cliente2.verSaldo();

        // Listar contas
        AccountManager.getInstance().listarContasAtivas();

        // Demonstração do Singleton
        AccountManager outraInstancia = AccountManager.getInstance();
        outraInstancia.verSaldo("001"); // Deve mostrar o mesmo saldo do cliente1
    }
}
