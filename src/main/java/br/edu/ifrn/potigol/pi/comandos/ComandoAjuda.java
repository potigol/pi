package br.edu.ifrn.potigol.pi.comandos;

import java.io.PrintStream;

public class ComandoAjuda implements IComando {
    private PrintStream out = System.out;
    private String nome = "ajuda";

    public String toString() {
        return this.nome;
    }

    public Boolean equals(String comando) {
        return (comando.toLowerCase().equals(this.nome));
    }

    public void run() {
        this.out.println("ajuda ou Ajuda\t\t- Mostra essa ajuda");
		this.out.println("sair ou Sair\t\t- Finaliza o PI");
    }
}
