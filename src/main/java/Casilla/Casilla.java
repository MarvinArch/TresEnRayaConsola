package Casilla;

import Jugador.jugador;

public class Casilla {

    private jugador jug;
    private boolean ocupado;
    private int numero;
    private String[] casilla;

    public Casilla(int numero) {
        this.numero = numero;
        this.jug= null;
    }

    public jugador getJug() {
        return jug;
    }

    public void setJug(jugador jug) {
        this.jug = jug;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public void definirCasilla() {
        if (jug != null) {
            String simbolo = jug.getSimbolo();
            casilla = new String[]{"|       |",
                    "|   " + simbolo + "   |",
                                   "|_______|"};
        } else {
            casilla = new String[]{"|       |",
                    "|   " + numero + "   |",
                                   "|_______|"};

        }
    }

    public String LineaCasilla(int linea){
        return casilla[linea];
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
