package ContaCorrente;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ContaCorrente {
    private String numeroConta;
    private String numeroAgencia;
    private String nomeCliente;
    private LocalDate dataNascimento;
    private double saldo;

    public ContaCorrente(String numeroConta, String numeroAgencia, String nomeCliente, LocalDate dataNascimento, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.numeroAgencia = numeroAgencia;
        this.nomeCliente = nomeCliente;
        this.dataNascimento = dataNascimento;
        this.saldo = saldoInicial;
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso. Saldo atual: R$ " + saldo);
        } else {
            System.out.println("Saque inválido. Saldo insuficiente ou valor inválido.");
        }
    }

    public void transferir(double valor, ContaCorrente contaDestino) {
        if (valor > 0 && valor <= saldo) {
            this.saldo -= valor;
            contaDestino.depositar(valor);
            System.out.println("Transferência de R$ " + valor + " realizada para " + contaDestino.getNomeCliente());
        } else {
            System.out.println("Transferência inválida. Saldo insuficiente ou valor inválido.");
        }
    }

    public void cancelarConta(String justificativa) {
        if (saldo == 0) {
            System.out.println("Conta cancelada com a justificativa: " + justificativa);
        } else {
            System.out.println("Não é possível cancelar a conta com saldo pendente. Saldo atual: R$ " + saldo);
        }
    }

    public void consultarExtrato(LocalDate dataInicio, LocalDate dataFim) {
        // Simulação de consulta de extrato
        System.out.println("Consultando extrato de " + dataInicio + " a " + dataFim + "...");
        System.out.println("Exemplo de transações fictícias");
    }

    public void consultarSaldoAtual() {
        System.out.println("Saldo atual: R$ " + saldo);
    }

    private void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public double getSaldo() {
        return saldo;
    }

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        ContaCorrente conta1 = new ContaCorrente("12345", "001", "João Silva", LocalDate.parse("01/01/1990", formatter), 1000.00);
        ContaCorrente conta2 = new ContaCorrente("67890", "001", "Maria Oliveira", LocalDate.parse("15/05/1995", formatter), 500.00);

        conta1.consultarSaldoAtual();
        conta1.sacar(200.00);
        conta1.transferir(300.00, conta2);
        conta1.consultarExtrato(LocalDate.parse("01/01/2023", formatter), LocalDate.parse("31/12/2023", formatter));
        conta1.cancelarConta("Mudança de banco");

        conta2.consultarSaldoAtual();
    }
}