package models;

import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public abstract class Conta {
    private int agencia;
    private int senha;
    private double saldo;

    public Conta(int senha){
        this.agencia = gerandoAgenciaAleatorio();
        this.senha = senha;
        this.saldo = 0.0;
    }

    private int gerandoAgenciaAleatorio(){
        Random random = new Random();
        return random.nextInt(1000);
    }

    public boolean fazerLogin(int agencia, int senha) {
        return this.agencia == agencia && this.senha == senha;
    }

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("""
                    Escolha uma opção
                    1 - Exibir informações da conta
                    2 - Depositar
                    3 - Sacar
                    4 - Transferir
                    5 - Voltar
                    """);
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> System.out.printf("""
                        Agência: %d
                        Saldo: %.2f
                        %n""", getAgencia(), getSaldo());
                case 2 -> {
                    double valor = Double.parseDouble(JOptionPane.showInputDialog("Qual valor a ser depositado"));
                    saldo += valor;
                    System.out.printf("Deposito realizado com sucesso. Novo saldo: %.2f \n %n", saldo);
                }
                case 3 -> {
                    double valor = Double.parseDouble(JOptionPane.showInputDialog("Qual valor a ser sacado"));
                    if(saldo >= valor){
                        saldo -= valor;
                        System.out.printf("Saque realizado com sucesso. Novo saldo: %.2f \n %n", saldo);
                    } else {
                        System.out.println("Saldo insuficiente para realizar o saque");
                    }
                }
                case 4 -> {
                    double valor = Double.parseDouble(JOptionPane.showInputDialog("Qual valor a ser transferido"));
                    if (saldo >= valor) {
                        saldo -= valor;
                        System.out.printf("Transferência realizada com sucesso. Novo saldo: %.2f \n %n", saldo);
                    } else {
                        System.out.println("Saldo insuficiente para a transferência");
                    }
                }
                case 5 -> {
                    return;
                }
            }
        } while (opcao != 6);
    }

    public int getAgencia() {
        return agencia;
    }

    public int getSenha() {
        return senha;
    }

    public double getSaldo() {
        return saldo;
    }
}
