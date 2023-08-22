import models.Conta;
import models.PessoaFisica;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    List<Conta> pessoa = new LinkedList<>();

    public static void main(String[] args) {
        int opcao;

        do{
            System.out.println("""
                    Escolha uma opção:
                    1 - Cadastrar como Pessoa Fisica
                    2 - Fazer login
                    3 - Sair
                    """);
            opcao = scanner.nextInt();

            switch (opcao){
                case 1 -> {
                    PessoaFisica pessoaFisica = PessoaFisica.cadastrarNovaConta();
                    System.out.printf("""
                            Pessoa cadastrada com sucesso!
                            Agência: %d
                            Saldo: %.2f
                            Nome: %s
                            CPF: %s
                            %n""", pessoaFisica.getAgencia(), pessoaFisica.getSaldo(), pessoaFisica.getNome(), pessoaFisica.getCpf());
                }
                case 2 -> {
                    System.out.println("Usuario logado");
                }
                case 3 -> {
                    System.out.println("Saindo");
                }
                default -> {
                    System.out.println("Opção invalida!");
                }
            }

        } while (opcao != 3);
    }
}