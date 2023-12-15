import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static byte pedirmetodo () {
        System.out.print("Hola, tienes los siguientes métodos - (0 - Notación decimal / 1 - Notación CDIR)");
        System.out.println();
        String error = "La opción no es válida, vuelve a intentarlo.";
        byte a = 0;
        for (int salida = 0; salida == 0; ) {
            for (int cont = 0; cont == 0; ) {
                try {
                    /*Pido opción para la calculadora*/
                    System.out.print("Opción: ");
                    Scanner sc = new Scanner(System.in);
                    byte metodo = sc.nextByte();
                    if (metodo == 0) {
                        System.out.println("Método elegido: Notación decimal.");
                        cont++;
                        salida++;
                    } else if (metodo == 1) {
                        System.out.println("Método elegido: Notación CDIR");
                        a = metodo;
                        cont++;
                        salida++;
                    } else {
                        System.out.println(error);
                    }
                } catch (Exception e) {
                    System.out.println(error);
                    cont++;
                }
            }
        }
        return a;
    }

    public static String pedirIP () {
        String ip = "";
        System.out.print("Por favor introduce una IP: ");
        try {
            Scanner sc = new Scanner(System.in);
            ip = sc.next();
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error.");
        }

        return ip;
    }

public static String pedirmascara (int metodo) {
        String mascara = "";
        Scanner sc = new Scanner(System.in);
        try {
            if (metodo == 0) {
                System.out.print("Introduce la máscara en notación decimal: ");
                mascara = sc.next();
            } else if (metodo == 1) {
                System.out.println("Introduce la máscara en notación CDIR");
                mascara = sc.next();
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error.");
        }
        return mascara;
}
    
    public static String[] segmentarIP(String ip) {
        int aux = 0;
        byte longitud = 0;
        int auxarray = 0;
        int cont = 1;
        /*------- COMPRUEBO LONGITUD ARRAY -------*/
        for (; longitud<ip.length(); longitud++) {
            if (String.valueOf(ip.charAt(longitud)).equals(".")) {
                cont++;
            }
        }
        String[] array = new String[cont];
        /*-----------------------------------------*/

        /*------- PARTO LA IP EN PARTES, SEGMENTADAS POR EL PUNTO -------*/
        longitud = 0;
        for (; longitud<ip.length(); longitud++) {
            try {
                if (String.valueOf(ip.charAt(longitud)).equals(".")) {

                    array[auxarray] = ip.substring(aux, longitud);
                    aux = longitud+1;
                    auxarray++;
                }
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error.");
            }
        }
        if (longitud==ip.length()){
            array[auxarray] = ip.substring(aux, longitud);
        }
        /*----------------------------------------------------------------*/
        return array;
    }
    
    public static byte compararIPMetodo(byte metodo, String ip) { /*Compruebo si el método corresponde con la IP - (String ip, byte metodo) */
        byte correcto = 0;
        try {
            if (metodo == 0) { /*Notación Decimal*/
                System.out.println("TODAVIA NO ESTA LISTO");
            } else if (metodo == 1) { /*Notación CDIR*/
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error.");
        }
        
        return correcto;
    }



    public static void main(String[] args) {
        System.out.println("Prueba");
        System.out.println(Arrays.toString(segmentarIP(pedirIP())));
    }
}
