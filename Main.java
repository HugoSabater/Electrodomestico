import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Electrodomestico> electrodomesticos = new ArrayList<>();
        electrodomesticos.add(new Lavadora());
        electrodomesticos.add(new Lavadora(20, 50));
        electrodomesticos.add(new Lavadora(70, 90, 'B', "blanco", 40, true, "Lana"));
        electrodomesticos.add(new Television());
        electrodomesticos.add(new Television(20, 80));
        electrodomesticos.add(new Television(40, 20, 'A', "negro", 73, true, "HBO"));

        for (Electrodomestico e : electrodomesticos) e.dimeAlexa();
        System.out.println("*".repeat(20));

        // No realiza nada (no almacena valores o otros), pero lo pide así en el pdf
        for (Electrodomestico e : electrodomesticos) e.preciofinal();

        /*
         Almaceno los precios de los electrodomésticos en una matriz
         0 = lavadoras,    1 = televisores,   2 = suma_lavadoras,   3 = suma_televisores
        */
        int[] pFinal = new int[4];
        for (Electrodomestico e : electrodomesticos) {
            if (e instanceof Lavadora) {
                pFinal[0] = e.preciofinal();
                pFinal[2] += pFinal[0];
                System.out.printf("Lavadora: " + pFinal[0] + "€\n");
            } else if (e instanceof Television) {
                pFinal[1] = e.preciofinal();
                pFinal[3] += pFinal[1];
                System.out.printf("Television: " + pFinal[1] + "€\n");
            }
        }
        System.out.println("*".repeat(20));
        System.out.println("Precio de las lavadoras total: " + pFinal[2] + "€");
        System.out.println("Precio de las televisiones total: " + pFinal[3] + "€");
    }
}