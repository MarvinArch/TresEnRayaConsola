package Main;

import Juego.NuevoJuego;
import resultados.Estadisticas;
import varios.LeerCadenas;

public class Lanzador {
    public static Estadisticas[] estadisticaJuegos;
    public static int conta=0;
    public static int contaPartida=1;
    public static void main(String[] args) {
        estadisticaJuegos= new Estadisticas[100];
        menuJuego();
    }

    public static void menuJuego (){
        int sali=0;
        do {
        System.out.println("---------------------------");
        System.out.println("opcion 1: Nuevo Juego");
        System.out.println("opcion 2: Estadisticas");
        System.out.println("opcion 3: Salir");
        String respuesta = LeerCadenas.leer("Eliga Una Opcion");
        int opcion= Integer.parseInt(respuesta);

            switch (opcion) {
                case 1:
                    NuevoJuego juego= new NuevoJuego(contaPartida);
                    contaPartida++;
                    break;
                case 2:
                    MostrarEstadisticas();
                    break;
                case 3:
                    sali=1;
                    break;
                default:
                    System.out.println("La opcion Elegida no es correcta \n \n");
                    break;
            }
        }while (sali!=1);
    }

    public static void MostrarEstadisticas(){
        for (int i = 0; i < conta; i++) {
            System.out.println(estadisticaJuegos[i].toString());
        }
    }
    public static void agregarGanador(String nombreJugador, int numeroPartica, int cantidadMovimientos){
        estadisticaJuegos[conta]=new Estadisticas(nombreJugador,numeroPartica,cantidadMovimientos);
        conta++;
    }
}
