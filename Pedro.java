public static String pedirmascara (int metodo) {
        String mascara = "";
        Scanner sc = new Scanner(System.in);
        for(int i=0;i>=0 && i<2;i++){
            boolean distinguirmetodo=false;
            System.out.println("Introduce otra vez la máscara(0/1)");
            mascara=sc.next();
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
public static void main(String[]args){
  
}
