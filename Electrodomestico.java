import java.util.Arrays;

public abstract class Electrodomestico implements Alexa {
    protected int precioBase;
    protected String color;
    protected char consumo_energetico;
    protected int peso;

    // Constructor por defecto
    public Electrodomestico() {
        this.color = "blanco";
        this.consumo_energetico = 'F';
        this.precioBase = 100;
        this.peso = 5;
    }

    // Constructor con precio y peso
    public Electrodomestico(int precioBase, int peso) {
        this.precioBase = precioBase;
        this.peso = peso;
        this.color = "blanco";
        this.consumo_energetico = 'F';
    }

    // Constructor con todos los atributos
    public Electrodomestico(int precioBase, String color, char consumo_energetico, int peso) {
        this.precioBase = precioBase;
        this.color = comprobarColor(color);
        this.consumo_energetico = comprobarConsumoEnergetico(consumo_energetico);
        this.peso = peso;
    }

    // Si consume contiene la letra de consumo_electrico se establecerá la letra, sinó guardará por defecto 'F'
    private char comprobarConsumoEnergetico(char letra) {
        String consume = "ABCDEF";
        return consume.contains(Character.toString(letra).toUpperCase()) ? letra : 'F';
    }

    // Si colors contiene el string de color se establecerá el color, sinó guardará por defecto "blanco"
    private String comprobarColor(String color) {
        String[] colors = new String[] {"blanco", "negro", "azul", "gris"};
        return Arrays.asList(colors).contains(color.toLowerCase()) ? color : "blanco";
    }

    // Calcula el precio según el consumo_electrico y su peso
    public int preciofinal() {
        int p = 0;
        
        char[] c = new char[] {'A', 'B', 'C', 'D', 'E', 'F'};
        int[] precio = new int[] {100, 80, 60, 50, 30, 10};
        for (int i = 0; i < c.length; i++) {
            if (c[i] == consumo_energetico) {
                p += precio[i];
                break;
            }
        }

        if (peso > 80) p += 100;
            else if (peso > 50) p += 80;
                else if (peso > 20) p += 50;
                    else  p += 10;

        return p;
    }

    // Necesario para Main > 13
    @Override
    public void dimeAlexa() {}
}
