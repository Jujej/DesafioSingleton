package banco;

import java.util.HashMap;
import java.util.Map;

public class AccountManager {
    // Instância única (Singleton)
    private static AccountManager instancia;

    // Contas de clientes: Map<contaId, saldo>
    private Map<String, Double> contas;

    // Construtor privado para evitar instanciamento externo
    private AccountManager() {
        contas = new HashMap<>();
    }

    // Método para obter a instância única
    public static AccountManager getInstance() {
        if (instancia == null) {
            instancia = new AccountManager();
        }
        return instancia;
    }

    // Criar conta de cliente com saldo inicial
    public void criarConta(String contaId, double saldoInicial) {
        contas.put(contaId, saldoInicial);
        System.out.println("Conta criada: " + contaId + " com saldo inicial de R$ " + saldoInicial);
    }

    // Depositar
    public void depositar(String contaId, double valor) {
        if (contas.containsKey(contaId)) {
            double novoSaldo = contas.get(contaId) + valor;
            contas.put(contaId, novoSaldo);
            System.out.println("Depósito de R$ " + valor + " realizado na conta " + contaId);
        } else {
            System.out.println("Conta " + contaId + " não encontrada!");
        }
    }

    // Sacar
    public void sacar(String contaId, double valor) {
        if (contas.containsKey(contaId)) {
            double saldoAtual = contas.get(contaId);
            if (saldoAtual >= valor) {
                contas.put(contaId, saldoAtual - valor);
                System.out.println("Saque de R$ " + valor + " realizado na conta " + contaId);
            } else {
                System.out.println("Saldo insuficiente na conta " + contaId);
            }
        } else {
            System.out.println("Conta " + contaId + " não encontrada!");
        }
    }

    // Ver saldo
    public void verSaldo(String contaId) {
        if (contas.containsKey(contaId)) {
            System.out.println("Saldo da conta " + contaId + ": R$ " + contas.get(contaId));
        } else {
            System.out.println("Conta " + contaId + " não encontrada!");
        }
    }

    // Listar contas
    public void listarContasAtivas() {
        System.out.println("\nContas ativas:");
        for (Map.Entry<String, Double> entry : contas.entrySet()) {
            System.out.println("Conta " + entry.getKey() + " - Saldo: R$ " + entry.getValue());
        }
    }
}
