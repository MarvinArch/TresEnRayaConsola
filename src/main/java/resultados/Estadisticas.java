package resultados;

public class Estadisticas {
    private String nombreJugador;
    private int numeroPartida;
    private int cantidadMovimientos;


    public Estadisticas(String nombreJugador, int numeroPartida, int cantidadMovimientos) {
        this.nombreJugador = nombreJugador;
        this.numeroPartida = numeroPartida;
        this.cantidadMovimientos = cantidadMovimientos;
    }

    @Override
    public String toString() {
        return  "Nombre Jugador='" + nombreJugador +
                ", \n \tNumero Partida=" + numeroPartida +
                ", \n \t\tCantidad Movimientos=" + cantidadMovimientos +
                '\n';
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public int getNumeroPartida() {
        return numeroPartida;
    }

    public void setNumeroPartida(int numeroPartida) {
        this.numeroPartida = numeroPartida;
    }

    public int getCantidadMovimientos() {
        return cantidadMovimientos;
    }

    public void setCantidadMovimientos(int cantidadMovimientos) {
        this.cantidadMovimientos = cantidadMovimientos;
    }
}
