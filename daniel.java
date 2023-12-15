public class Array2 {

    public static void calculadora(int[] maskaux) {
        int cont = 0;
        int[] mascara = new int[4];
        if (maskaux.length == 1)  { /*Esto es notación CDIR*/
            for (boolean limit = true; limit == true; ) {
                for (cont = 0; cont <= 4;) {
                    if (maskaux[0] >= 8) {
                        System.out.println(maskaux[0] + " menos 8 es");
                        maskaux[0] = maskaux[0] - 8;
                        System.out.println(maskaux[0]);
                        mascara[cont] = 255;
                        cont++;
                    } else {
                        System.out.println(maskaux[0] + " es menor que 8, por tanto paro");
                        int[] array = {128, 64, 32, 16, 8, 4, 2, 1}; // Lista bytes
                        for (true) {
                            int aux = 0;
                            aux = aux + array[maskaux[0]];
                            maskaux--;
                            mascara[cont] = for
                        }
                        limit = false;
                        break;
                    }
                }
            }


        }
    }
/*
    for (int cont = 0; cont >= 0; cont++) {
                mask = mask/8;
            }
 */


    public static void main(String[] args) {
        int[] maskaux = {25};
        System.out.println("Prueba");
        calculadora(maskaux);
    }
}
