package br.edu.ifrn.potigol.pi.comandos;

public interface IComando {
    public String toString();
    public Boolean equals(String comando);
    public void run();
}
