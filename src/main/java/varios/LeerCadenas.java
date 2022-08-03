package varios;

import java.util.Scanner;

public class LeerCadenas {
    private static Scanner sc = new Scanner(System.in);
    public static String leer(String mensaje){
        System.out.println(mensaje);
        String respuesta= sc.nextLine();
        return respuesta;
    }

    public static String EscogerSimbolo(int numjug, String inicial){
        boolean valido=true;
        String simbolo="";
        if (inicial.equalsIgnoreCase("vacio")) {
            do {
                System.out.println("Elija entre utilizar \"X\" o la \"O\"");
                String respuesta = sc.nextLine();
                switch (respuesta.toLowerCase()) {
                    case "x":
                        simbolo = "x";
                        valido = false;
                        break;
                    case "o":
                        simbolo = "0";
                        valido = false;
                        break;
                    default:
                        System.out.println("Opcion Incorrecta \n");
                        break;
                }
            } while (valido);
        }else{
            if (inicial.equalsIgnoreCase("x")){
                simbolo="O";
            }else{
                simbolo="X";
            }
        }
        return simbolo;

    }
}
