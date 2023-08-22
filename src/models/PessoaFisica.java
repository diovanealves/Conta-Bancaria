package models;

import javax.swing.*;

public class PessoaFisica extends Conta {
    private String nome;
    private String cpf;

    public PessoaFisica(int senha, String nome, String cpf) {
        super(senha);
        this.nome = nome;
        this.cpf = cpf;
    }

    public static PessoaFisica cadastrarNovaConta(){
        String nome = JOptionPane.showInputDialog("Digite o nome");
        String cpf = JOptionPane.showInputDialog("Digite o cpf");
        int senha= (Integer.parseInt(JOptionPane.showInputDialog("Digite a senha")));

        return new PessoaFisica(senha, nome, cpf);
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}
