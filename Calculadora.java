import java.util.Scanner;

public class odiar {
    public static int mascaraTipo (){ // Pide tipo de máscara
        try {
            System.out.println("Hola, introduce el formato de la máscara (0-Decimal / 1-CDIR)");
            for (int cont = 0; cont==0; cont++) { //Comprobar opción valida
                Scanner sc = new Scanner(System.in);
                System.out.print("Opción: ");
                int opcion = sc.nextInt();
                if (opcion == 0) {
                    System.out.println("Opción elegida - formato decimal");
                    return opcion;
                } else if (opcion == 1) {
                    System.out.println("Opción elegida - formato CDIR");
                    return opcion;
                } else {
                    System.out.println("Opción incorrecta, vuelve a intentarlo.");
                }
            }
        } catch (Exception e) {
            System.out.println("Opción incorrecta, reiniciando...");
        }
        return -1;
    }
    public static String introducirDatos (int opcion) { // Pedir IP/Máscara
        try {
            Scanner sc = new Scanner(System.in);
            if (opcion == 0) { // Pedir máscara 0/1
                System.out.print("Por favor introduce tu máscara en formato decimal: ");
                return sc.next();
            } else if (opcion == 1) {
                System.out.print("Por favor introduce tu máscara en formato CDIR: ");
                return sc.next();
            }
            else {
                System.out.print("Por favor introduce tu IP: ");
                return sc.next();
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error, reiniciando...");
        }
        return null;
    }
    public static int comprobarLongitud (String dato) {
        try {
            byte longitud = 0;
            int cont = 1;
            // 1) Crear longitud del array
            for (; longitud<dato.length(); longitud++) {
                if (String.valueOf(dato.charAt(longitud)).equals(".")) {
                    cont++;
                }
            }
            // 2) Comprobar longitud del array
            if (cont==4) { // Longitud correcta
                System.out.println("OK - Longitud correcta, continuando.");
                return 0;
            } else if (cont>4){ // Longitud incorrecta (>)
                System.out.println("ERROR - Los datos introducidos tienen más de 4 octetos, abortando...");
                return 1;
            } else { // Longitud incorrecta (<)
                System.out.println("ERROR - Los datos introducidos tienen menos de 4 octetos, abortando...");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error con los comprobantes, abortando...");
        }
        return 1;
    }
    public static String[] segmentar (String dato, int comprobante) {
        try {
            if (comprobante == 1) { // Longitud incorrecta, aborta
                System.out.println("ERROR - Comprobante Longitud equivocado, abortando...");
            } else if (comprobante == 0) { // Longitud correcta, continúa
                int aux = 0;
                byte longitud = 0;
                int auxarray = 0;
                // 1) Crear array
                String[] array = new String[4];
                // 2) Segmentar array (determinante = '.')
                for (; longitud<dato.length(); longitud++) {
                    try {
                        if (String.valueOf(dato.charAt(longitud)).equals(".")) {
                            array[auxarray] = dato.substring(aux, longitud);
                            aux = longitud+1;
                            auxarray++;
                        }
                    } catch (Exception e) {
                        System.out.println("Ha ocurrido un error con los comprobantes, abortando...");
                    }
                }
                // 3) Colocar la última parte del array como 4to valor
                if (longitud==dato.length()){
                    array[auxarray] = dato.substring(aux, longitud);
                }
                return array;
            }
            return null;
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error, abortando...");
        }
        return null;
    }
    public static int[] stringInt (String[] dato) {
        try {
            // 1) Pasar de String a Int
            int[] arrayInt=new int[4];
            for (int cont=0; cont<=3; cont++) {
                arrayInt[cont] = Integer.parseInt(dato[cont]);
            }
            return arrayInt;
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error, abortando...");
        }
        return null;
    }
    public static int comprobarRango (int[] dato) {
        try {
            // 1) Compruebo si los valores del array están entre 0 y 255
            int correcto = 0;
            for (int cont=0; cont<=3; cont++) {
                if (dato[cont]<256 && dato[cont]>-1) {
                    correcto++;
                }
            }
            if (correcto==4) { // Correcto, valores dentro del rango.
                System.out.println("OK - Los valores están dentro del rango, continuando...");
                return 0;
            } else { // Incorrecto, valores fuera del rango.
                System.out.println("ERROR - Los valores no están dentro del rango, abortando...");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error, abortando...");
        }
        return 1;
    }
    public static String[] stringBinario(String[] dato, int comprobante){
        try {
            if (comprobante==1) { // Comprobante incorrecto, aborta
                System.out.println("ERROR - Comprobante Rango equivocado, abortando...");
            } else if (comprobante==0) {
                //1) Crea un nuevo array y convierte los valores
                String[] arrayBinario = new String[4];
                for (int cont=0; cont<=3; cont++) {
                    arrayBinario[cont] = Integer.toBinaryString(Integer.parseInt(dato[cont]));

                    //2) Comprueba los caracteres, si hay menos de 8, rellena con 0's a la izquierda
                    if (arrayBinario[cont].length()<8) {
                        int ceros = 8-arrayBinario[cont].length();
                        for (; ceros>0; ceros--) {
                            arrayBinario[cont] =  "0" + arrayBinario[cont];
                        }
                    }
                }
                return arrayBinario;
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error con los comprobantes, abortando...");        }
        return null;
    }
    public static int comprobarValores (int[] dato, int comprobante) {
        try {
            if (comprobante==1) {
                System.out.println("ERROR - Comprobante Rango equivocado, abortando...");
            } else if (comprobante==0) {
                int valor = 0;
                int aux = 0;

                // 1) Compruebo si el número está dentro del rango
                int[] arrayBits = {0, 128, 192, 224, 240, 248, 252, 254, 255};
                for (int cont=0; cont<4; cont++) {
                    for (int bit = 0; bit<9; bit++) {
                        if (dato[cont]==arrayBits[bit]){
                            valor=0;
                            bit=8;
                        } else {
                            valor=1;
                        }
                    }
                    // 2) Compruebo si hay 255 y en base a eso, compruebo si los siguientes octetos son 0
                    if (dato[cont]!=255) {
                        for (;cont<dato.length;cont++) {
                            if (dato[cont]==0) {
                                aux = 0;
                            } else {
                                aux = 1;
                            }
                        }
                        //3) Fix Octetos
                        if (dato[cont-1]<dato[cont-2]) {
                            aux = 0;
                        }
                    }
                }
                if (valor==0 && aux==0) {
                    System.out.println("OK - Los valores están dentro del rango, continuando...");
                    return 0;
                } else {
                    System.out.println("ERROR - Los valores no están dentro del rango, abortando...");
                    return 1;
                }
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error con los comprobantes, abortando...");        }
        return 1;
    }
    public static int comprobarMascaraCDIR (String dato) {
        try {
            // 1) Comprueba si la máscara está dentro del rango
            if (Integer.parseInt(dato)>0 && Integer.parseInt(dato)<33) { // Correcto, está dentro del rango, continúa
                System.out.println("OK - La máscara proporcionada está dentro del rango, continuando...");
                return 0;
            } else { // Incorrecto, no está dentro del rango, aborta
                System.out.println("ERROR - La máscara está fuera del rango, abortando...");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error con los comprobantes, abortando...");
        }
        return 1;
    }
    public static String[] rellenarUnoCero (String dato, int comprobante) {
        try {
            if (comprobante==1) { // Comprobante incorrecto, aborta
                System.out.println("ERROR - Comprobante Valor equivocado, abortando...");
            } else { // Comprobante correcto, continúa
                // 1) Comprueba y convierte la Máscara /8 y calcula el resto
                int octeto = 0;
                int resto = 0;
                int mascara = Integer.parseInt(dato);
                int[] arrayBit = {128, 64, 32, 16, 8, 4, 2, 1};
                String[] array = new String[4];
                for (; mascara>=8;octeto++) {
                    mascara = mascara-8;
                    array[octeto]= String.valueOf(255);
                }
                if (mascara>0) {
                    for (; mascara>0; mascara--) {
                        resto = resto + arrayBit[mascara - 1];
                    }
                    array[octeto] = String.valueOf(resto);
                }
                // 2) Rellena con 0 si hay valores nulos
                for (int cont=0; cont<4; cont++) {
                    if (array[cont]==null) {
                        array[cont] = String.valueOf(0);
                    }
                }
                return array;
            }
            return null;
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error con los comprobantes, abortando...");
        }
        return null;
    }
    public static int nUnos (String[]dato0, int comprobanteIP, int comprobanteMascara) {
        try {
            int unos = 0;
            if (comprobanteIP == 1 || comprobanteMascara == 1) {
                System.out.println("ERROR - Hay un error en alguno de los comprobantes, abortando...");
            } else if (comprobanteIP == 0 && comprobanteMascara == 0) {
                // 1) Calcular Nº de 1's en la Máscara
                for (int octeto = 0; octeto < 4; octeto++) {
                    for (int posicion = 0; posicion < 8; posicion++) {
                        if (dato0[octeto].charAt(posicion) == '1') {
                            unos++;
                        }
                    }
                }
            }
            return unos;
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error con los comprobantes, abortando...");
        }
        return 1;
    }
    public static String[] multiplicarBits (int unos, String[] dato, int comprobanteIP, int comprobanteMascara) {
        try {
            String[] resultado = {"", "", "", ""};
            if (comprobanteIP==1 || comprobanteMascara==1) {
                System.out.println("ERROR - Hay un error en alguno de los comprobantes, abortando...");
            } else if (comprobanteIP==0 && comprobanteMascara==0) {
                // 1) Multiplico los 1's por la IP
                for (int octeto = 0; octeto<4; octeto++) {
                    for (int posicion = 0; posicion<8; posicion++) {
                        if (unos!=0) {
                            resultado[octeto] = resultado[octeto] + dato[octeto].charAt(posicion);
                            unos--;
                        }
                        else {
                            resultado[octeto] = resultado[octeto] + 0;
                        }
                    }
                }
                return resultado;
            }
            return null;
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error con los comprobantes, abortando...");
        }
        return null;
    }
    public static String[] binarioDecimal (String[] dato) {
        try {
            String[] array = {"", "", "", ""};
            int[] arrayBits = {128, 64, 32, 16, 8, 4, 2, 1};
            for (int cont=0; cont<4; cont++){
                int suma = 0;
                for (int posiciones = 0; posiciones<8; posiciones++) {
                    if (dato[cont].charAt(posiciones)=='1') {
                        suma = suma + arrayBits[posiciones];
                    }
                }
                array[cont] = String.valueOf(suma);
            }
            return array;
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error con los comprobantes, abortando...");
        }
        return null;
    }
    public static void calculadora (int nUnos, String[] dato, int[] dato2) {
        try {
            //1) Dirección de Red
            String[] direccionRed = binarioDecimal(dato);
            int[] direccionRedInt = stringInt(direccionRed);
            assert direccionRedInt != null;
            //2) Dirección de Broadcast PARTE 1 (1's)
            String[] arraynuevo = {"", "", "", "",};
            int unos = nUnos;
            for (int octeto = 0 ; octeto<=3; octeto++) {
                for (int posiciones = 0; posiciones<8 && unos>0;posiciones++, unos--) {
                    arraynuevo[octeto] = arraynuevo[octeto] + dato[octeto].charAt(posiciones);
                }
            }
            //3) Dirección de Broadcast PARTE 2 (0's)
            int ceros = 32-nUnos;
            int cerosaux = ceros;
            for (int octeto = 3 ;octeto>=0; octeto--) {
                for (int posiciones = 7; posiciones>=0 && ceros>=0; posiciones--, ceros--) {
                    arraynuevo[octeto] = arraynuevo[octeto] + "1";
                }
            }
            // 4) Convertimos a decimal
            String[] direccionBroadcast = binarioDecimal(arraynuevo);
            // 5) 1º Dirección IP
            direccionRedInt[3] = direccionRedInt[3]+1;
            // 6) Convierto broadcast a entero y resto
            int[] direccionBroadcastInt = stringInt(direccionBroadcast);
            assert direccionBroadcastInt != null;
            // 7) Última Dirección IP
            direccionBroadcastInt[3] = direccionBroadcastInt[3]-1;
            // 8) Calculo la letra
            String letra = "";
            if (direccionRedInt[0]< 127) {
                letra = "A";
            } else if (direccionRedInt[0]>127 && direccionRedInt[0]<192) {
                letra = "B";
            } else if (direccionRedInt[0]>191 && direccionRedInt[0]<224) {
                letra = "C";
            } else if (direccionRedInt[0]>223 && direccionRedInt[0]<240) {
                letra = "D";
            } else if (direccionRedInt[0]>239) {
                letra = "E";
            }
            System.out.println("------------------------------------------------------");
            System.out.println("I N F O R M A C I Ó N");
            System.out.println("------------------------------------------------------");
            System.out.println("Tipo de clase: " + letra);
            // 9) Calculo el número de hosts:
            int hosts = (int) Math.pow(2, cerosaux);
            System.out.println("Total de direcciones posibles = " + hosts);
            hosts = hosts-2;
            System.out.println("Total de hosts utilizables = " + hosts);
            // 10) Fix para máscaras 23-30
            if (nUnos>=23 && nUnos <= 30) {
                direccionRedInt[2] = 255;
                direccionBroadcastInt[2] = 255;
            }
            assert direccionRed != null;
            System.out.println("Dirección de Red = " + direccionRed[0] + "." + direccionRed[1] + "." + direccionRed[2] + "." + direccionRed[3]);
            assert direccionBroadcast != null;
            System.out.println("Dirección de Broadcast = " + direccionBroadcast[0] + "." + direccionBroadcast[1] + "." + direccionBroadcast[2] + "." + direccionBroadcast[3]);
            System.out.println("Rango de hosts: " + direccionRedInt[0] + "." + direccionRedInt[1] + "." + direccionRedInt[2] + "." + direccionRedInt[3] + " - " + direccionBroadcastInt[0] + "." + direccionBroadcastInt[1] + "." + direccionBroadcastInt[2] + "." + direccionBroadcastInt[3]);
            // 11) Easter Egg
            int egg = 0;
            if (dato2[0] == 8 && dato2[1] == 8 && dato2[2] == 8 && dato2[3] == 8 || dato2[0] == 4 && dato2[1] == 4 && dato2[2] == 4 && dato2[3] == 4) {
                egg = 1;
            } else if (dato2[0] == 1 && dato2[1] == 1 && dato2[2] == 1 && dato2[3] == 1) {
                egg = 2;
            } else if (dato2[0] == 127) {
                egg = 3;
            }
            switch (egg) {
                case 1:
                    System.out.println("Las DNS de Google...");
                    break;
                case 2:
                    System.out.println("Las DNS de Cloudflare");
                    break;
                case 3:
                    System.out.println("Una dirección de loopback...");
                    break;
            }
            System.out.println("------------------------------------------------------");
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error con los comprobantes, abortando...");
        }
    }
    public static void main(String[] args) {
        for (int salida = 0; salida==0; ) {
            try {
                // APARTADO: IP - Pasos 1-9 //
                // 1) Pedir tipo de Máscara
                int masktype = 0;
                for (int limite = 0; limite==0;) {
                    masktype = mascaraTipo();
                    if (masktype != -1 ) {
                        limite++;
                    }
                }
                // 2) Pedir IP
                String ip = introducirDatos(2);
                // 3) Pedir Máscara
                String mascara = introducirDatos(masktype);
                // 5) Comprobar longitud del array (IP)
                System.out.println("Comprobando longitud de la IP...");
                int ipLongitudComprobante = comprobarLongitud(ip);
                // 6) Segmentar IP
                String[] ipSegmentada = segmentar(ip, ipLongitudComprobante);
                // 7) Convertir IP segmentada a entero
                int[] ipInt = stringInt(ipSegmentada);
                System.out.println("Comprobando valores de la IP...");
                // 8) Comprobar los rangos de los valores de la IP
                int ipValorComprobante = comprobarRango(ipInt);
                // 9) Convertir IP a binario
                String[] ipBinario = stringBinario(ipSegmentada, ipValorComprobante);
                if (masktype==0) {
                    // APARTADO: Máscara Decimal - Pasos 1-9 //
                    // 1) Comprobar longitud del array (Máscara)
                    System.out.println("Comprobando longitud de la Máscara...");
                    int mascaraLongitudComprobante = comprobarLongitud(mascara);
                    // 2) Segmentar Máscara
                    String[] mascaraSegmentada = segmentar(mascara, mascaraLongitudComprobante);
                    // 3) Convertir Máscara segmentada a entero
                    int[] mascaraInt = stringInt(mascaraSegmentada);
                    // 4) Comprobar los rangos de los valores de la Máscara
                    System.out.println("Comprobando rango de valores de la Máscara...");
                    int mascaraRangoComprobante = comprobarRango(mascaraInt);
                    // 5) Comprobar los valores de la Máscara
                    System.out.println("Comprobando valores de la Máscara...");
                    int mascaraValorComprobante = comprobarValores(mascaraInt, mascaraRangoComprobante);
                    // 6) Convertir Máscara a binario
                    String[] mascaraBinario = stringBinario(mascaraSegmentada, mascaraValorComprobante);
                    // 7) Cuento los 1's de la Máscara
                    int unosMascara = nUnos(mascaraBinario, ipValorComprobante, mascaraRangoComprobante);
                    // 8) Multiplicar los bits
                    String[] resultadoMultiplicar = multiplicarBits(unosMascara, ipBinario, ipValorComprobante, mascaraRangoComprobante);
                    // 9) Calculo el máximo y el mínimo en base a los Nº de 1's sobre el resultado de la multiplicación
                    calculadora(unosMascara,resultadoMultiplicar, ipInt);
                } else if (masktype==1) {
                    // APARTADO: Máscara CDIR - Pasos 1-6 //
                    // 1) Comprobar si la máscara está dentro del rango (1-32)
                    int mascaraRangoComprobante = comprobarMascaraCDIR(mascara);
                    // 2) Calcular los octetos y rellenar los 1's y 0's
                    String[] mascaraConvertida = rellenarUnoCero(mascara, mascaraRangoComprobante);
                    // 3) Passar Máscara a binario
                    String[] mascaraBinario = stringBinario(mascaraConvertida, mascaraRangoComprobante);
                    // 4) Cuento los 1's de la Máscara
                    int unosMascara = nUnos(mascaraBinario, ipValorComprobante, mascaraRangoComprobante);
                    // 5) Multiplicar los bits
                    String[] resultadoMultiplicar = multiplicarBits(unosMascara, ipBinario, ipValorComprobante, mascaraRangoComprobante);
                    // 6) Calculo el máximo y el mínimo en base a los Nº de 1's sobre el resultado de la multiplicación
                    calculadora(unosMascara,resultadoMultiplicar, ipInt);
                }
                Scanner sc = new Scanner(System.in);
                for (int cont = 0; cont == 0;) {
                    System.out.println("¿Quieres salir? (0 - no / 1 - sí)");
                    System.out.print("Opción: ");
                    int opcion = sc.nextInt();
                    if (opcion == 1) {
                        System.out.println("Hasta luego.");
                        salida++;
                        cont++;
                    } else if (opcion == 0) {
                        System.out.println("Continuando...");
                        cont++;
                    } else {
                        System.out.println("Opción incorrecta, vuelve a intentarlo.");
                    }
                }
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error con los comprobantes, abortando...");
            }
        }
    }
}
