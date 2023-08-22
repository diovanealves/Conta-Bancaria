package models;

import java.util.Random;

public class Conta {
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
