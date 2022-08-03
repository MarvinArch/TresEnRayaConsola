package Jugador;

public class jugador {
    private String nombre;
    private String simbolo;
    private int numeroJug;
    private int cantidadMovimientos;

    public jugador(int numeroJug) {
        this.numeroJug = numeroJug;
        cantidadMovimientos=0;
    }

    public int getCantidadMovimientos() {
        return cantidadMovimientos;
    }

    public void setCantidadMovimientos() {
        cantidadMovimientos++;
    }

    public int getNumeroJug() {
        return numeroJug;
    }

    public void setNumeroJug(int numeroJug) {
        this.numeroJug = numeroJug;
    }

    public jugador() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }
}
