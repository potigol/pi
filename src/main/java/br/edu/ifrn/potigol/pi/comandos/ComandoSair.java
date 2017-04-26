package br.edu.ifrn.potigol.pi.comandos;

import java.io.PrintStream;

public class ComandoSair implements IComando {
    private PrintStream out = System.out;
    private String nome = "sair";

    public String toString() {
        return this.nome;
    }

    public Boolean equals(String comando) {
        return (comando.toLowerCase().equals(this.nome));
    }

    public void run() {
        this.out.println("Finalizando o PI");
		System.exit(0);
    }
}
