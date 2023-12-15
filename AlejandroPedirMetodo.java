import java.util.Scanner;

public class F1 {
    public static void main(String[] args) {
        PedirMetodo();
    }

    public static byte PedirMetodo() {
        Scanner sc = new Scanner(System.in);
        byte elegirMetodo;
        do {
            try {
                System.out.println("Elige un método: 0 = Notación decimal || 1 = Notación CDIR");
                elegirMetodo = sc.nextByte();

                if (elegirMetodo == 0) {
                    System.out.println("Has elegido la notación decimal");
                } else if (elegirMetodo == 1) {
                    System.out.println("Has elegido la notación CDIR");
                } else {
                    System.out.println("Introduzca una opción válida");
                }
            } catch (Exception e) {
                System.out.println("Error: Introduzca un valor válido.");
                sc.next();
                elegirMetodo = -1;
            }
        } while (elegirMetodo != 0 && elegirMetodo != 1);

        return elegirMetodo;
    }
}
