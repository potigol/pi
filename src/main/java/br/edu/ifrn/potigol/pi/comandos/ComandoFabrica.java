package br.edu.ifrn.potigol.pi.comandos;

// import java.util.Set;
import java.util.HashMap;

public abstract class ComandoFabrica {
    public static HashMap<String, IComando> comandos = new HashMap<String, IComando>();

    static {
        IComando comando;

        comando = new ComandoAjuda();
        comandos.put(comando.toString(), comando);

        comando = new ComandoSair();
        comandos.put(comando.toString(), comando);
    }

    // public static Set<IComando> lista() {
    //
    // }

    public static IComando procure(String comando) {
        return comandos.get(comando);
    }

    public static String[] nomesDeComandos() {
        return comandos.keySet().toArray(new String[0]);
    }
}
