package br.edu.ifrn.potigol.pi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import jline.console.*;
import jline.console.completer.*;

import br.edu.ifrn.potigol.pi.comandos.IComando;
import br.edu.ifrn.potigol.pi.comandos.ComandoFabrica;

public class Repl {
    private String[] commandsList;

	public void init() {
		// commandsList = new String[] { "ajuda", "Ajuda", "sair", "Sair" };
        commandsList = ComandoFabrica.nomesDeComandos();
	}

	public void run() throws IOException {
		printWelcomeMessage();
		ConsoleReader reader = new ConsoleReader();
		reader.setBellEnabled(false);
		List<Completer> completors = new LinkedList<Completer>();

		completors.add(new StringsCompleter(commandsList));
		reader.addCompleter(new ArgumentCompleter(completors));

		String line;
        IComando comando;
		PrintWriter out = new PrintWriter(System.out);

		while ((line = readLine(reader, "")) != null) {
            if ((comando = ComandoFabrica.procure(line)) != null) {
                comando.run();
			// } else if ("sair".equals(line) || "Sair".equals(line)) {
			// 	System.out.println("Finalizando o PI");
				// return;
			} else {
				System.out.println("comando inválido.");
			}
			out.flush();
		}
	}

	private void printWelcomeMessage() {
		System.out
				.println("Bem vindo ao PI (Potigol Interativo).\npressione TAB ou digite \"ajuda\" e tecle ENTER.");

	}

	private void printHelp() {
		System.out.println("ajuda ou Ajuda\t\t- Mostra essa ajuda");
		System.out.println("sair ou Sair\t\t- Finaliza o PI");

	}

	private String readLine(ConsoleReader reader, String promtMessage)
			throws IOException {
		String line = reader.readLine(promtMessage + "\npi> ");
		return line.trim();
	}

	public static void main(String[] args) throws IOException {
		Repl shell = new Repl();
		shell.init();
		shell.run();
	}
}
