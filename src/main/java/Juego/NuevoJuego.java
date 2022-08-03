package Juego;
import Casilla.Casilla;
import Jugador.jugador;
import Main.Lanzador;
import varios.LeerCadenas;

import java.util.Scanner;

public class NuevoJuego {
    private jugador jugadores[]= new jugador[2];
    private Casilla tablero[][] = new Casilla[3][3];
    private boolean ganador= true;
    private boolean empate = false;
    private int numeroPartida;
    public NuevoJuego(int partida) {
        this.numeroPartida=partida;
        IniciarJugadores();
        int num=1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j]= new Casilla(num);
                tablero[i][j].definirCasilla();
                num++;
            }
        }
        ImprimirTablero();
        Juego();
        Comprobaciones();
    }

    private void IniciarJugadores(){
        jugadores[0]= new jugador(1);
        jugadores[1]= new jugador(2);
        jugadores[0].setNombre(LeerCadenas.leer("Ingrese nombre del Jugador 1"));
        jugadores[0].setSimbolo(LeerCadenas.EscogerSimbolo(1, "vacio"));
        jugadores[1].setNombre(LeerCadenas.leer("Ingrese nombre del Jugador 2"));
        jugadores[1].setSimbolo(LeerCadenas.EscogerSimbolo(2, jugadores[0].getSimbolo()));
    }

    private void ImprimirTablero(){
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(tablero[i][j].LineaCasilla(k));
                }
                System.out.println();
            }
        }
    }

    private void Juego(){

        do {
            for (int i = 0; i < 2; i++) {
                boolean jugadavalida=false;
                do {
                    System.out.println("-------Turno Jugador "+(i+1)+"---------");
                    String posicion= LeerCadenas.leer("Ingrese El numero de la Casilla en donde desea jugar");
                    jugadavalida=validarJugada(Integer.parseInt(posicion), jugadores[i]);
                    if (!jugadavalida) System.out.println("-------- La Casilla seleccionada esta ocupada");
                    ImprimirTablero();
                    jugadores[i].setCantidadMovimientos();
                    if (comprobarCasillasLennas()==false){
                        empate=true;
                        i=1;
                        break;
                    }
                    if (comprobarHorzontalVericalDiagonal()!=null){
                        ganador = false;
                        i=1;
                        break;
                    }
                }while(!jugadavalida);

            }
        }while ((ganador && !empate));
    }

    private boolean validarJugada(int numero, jugador jug){
        boolean valido=false;
        if (numero<10 && numero>0) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (tablero[i][j].getNumero() == numero) {
                        if (tablero[i][j].getJug() == null) {
                            tablero[i][j].setJug(jug);
                            tablero[i][j].definirCasilla();
                            valido = true;
                        }
                    }
                }
            }
        }
        return valido;
    }

    public boolean comprobarCasillasLennas(){
        boolean casillaVacia=false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j].getJug()==null) casillaVacia=true;
            }
        }
        return casillaVacia;
    }

    public void Comprobaciones(){
        if (empate==true){
            System.out.println("El Juego ha terminado en un empate Ya no hay mas casillas para jugar");
        }
    }

    public jugador comprobarHorzontalVericalDiagonal(){
        jugador juga= null;
        for (int i = 0; i < 3; i++) {
            //comprobar Casillas Vacias
            if (tablero[i][0].getJug()!=null && tablero[i][1].getJug()!=null && tablero[i][2].getJug()!=null) {
                //comprobacion horizontal
                if (tablero[i][0].getJug().getNumeroJug() == tablero[i][1].getJug().getNumeroJug() &&
                        tablero[i][1].getJug().getNumeroJug() == tablero[i][2].getJug().getNumeroJug())
                    juga = tablero[i][2].getJug();
            }
            if (tablero[0][i].getJug()!=null && tablero[1][i].getJug()!=null && tablero[2][i].getJug()!=null) {
                //comporbacion vertical
                if (tablero[0][i].getJug().getNumeroJug() == tablero[1][i].getJug().getNumeroJug()
                        && tablero[1][i].getJug().getNumeroJug() == tablero[2][i].getJug().getNumeroJug())
                    juga = tablero[2][i].getJug();
            }
        }
        if (tablero[0][0].getJug()!=null && tablero[1][1].getJug()!=null && tablero[2][2].getJug()!=null) {
            //Pendiente Negativa
            if (tablero[0][0].getJug().getNumeroJug() == tablero[1][1].getJug().getNumeroJug()
                    && tablero[2][2].getJug().getNumeroJug() == tablero[1][1].getJug().getNumeroJug())
                juga = tablero[0][0].getJug();
        }
        if (tablero[2][0].getJug()!=null && tablero[1][1].getJug()!=null && tablero[0][2].getJug()!=null) {
            //Pendiente Positiva
            if (tablero[2][0].getJug().getNumeroJug() == tablero[1][1].getJug().getNumeroJug()
                    && tablero[0][2].getJug().getNumeroJug() == tablero[1][1].getJug().getNumeroJug())
                juga = tablero[2][0].getJug();
        }
        if (juga!=null){
            System.out.println("-------------------El Jugador "+ juga.getNombre()+"---------------------");
            System.out.println("Ha Ganado la Partida");
            Lanzador.agregarGanador(juga.getNombre(),numeroPartida,juga.getCantidadMovimientos());
        }
        return juga;
    }
}
