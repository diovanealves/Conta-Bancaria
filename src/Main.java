import models.Conta;
import models.PessoaFisica;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Conta> contas = new ArrayList<>();
        int opcao;

        do {
            System.out.println("""
                    Escolha uma opção:
                    1 - Cadastrar como Pessoa Fisica
                    2 - Fazer login
                    3 - Sair
                    """);
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> {
                    PessoaFisica pessoaFisica = PessoaFisica.cadastrarNovaConta();
                    contas.add(pessoaFisica);
                    System.out.printf("""
                            Pessoa cadastrada com sucesso!
                            Agência: %d
                            Saldo: %.2f
                            Nome: %s
                            CPF: %s
                            %n""", pessoaFisica.getAgencia(), pessoaFisica.getSaldo(), pessoaFisica.getNome(), pessoaFisica.getCpf());
                }
                case 2 -> realizarLogin(contas);
                case 3 -> System.out.println("Saindo");
                default -> System.out.println("Opção invalida!");
            }

        } while (opcao != 3);
    }

    public static void realizarLogin(ArrayList<Conta> contas) {
        int agencia = Integer.parseInt(JOptionPane.showInputDialog("Agência: "));
        int senha = Integer.parseInt(JOptionPane.showInputDialog("Senha: "));

        for (Conta conta : contas) {
            if (conta.fazerLogin(agencia, senha)) {
                conta.exibirMenu();
            } else {
                System.out.println("Usuário ou senha incorreta");
            }
        }
    }
}