package banco;

public class Cliente {
    private String id;
    private String nome;

    public Cliente(String id, String nome, double saldoInicial) {
        this.id = id;
        this.nome = nome;
        AccountManager.getInstance().criarConta(id, saldoInicial);
    }

    public void depositar(double valor) {
        AccountManager.getInstance().depositar(id, valor);
    }

    public void sacar(double valor) {
        AccountManager.getInstance().sacar(id, valor);
    }

    public void verSaldo() {
        AccountManager.getInstance().verSaldo(id);
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
