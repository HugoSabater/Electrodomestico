import java.util.Arrays;

public class Lavadora extends Electrodomestico implements Alexa{
    private int carga;
    private boolean inteligente;
    private String programa;
    private final String[] listado = new String[] {"Económico", "Lana", "Algodón", "Sintéticos", "Ropa oscura", "Rápido", "Sport"};

    // Constructor por defecto
    public Lavadora() {
        carga = 5;
        inteligente = false;
        programa = "Económico";
    }

    // Constructor de precio y peso (de Electrodomestico)
    public Lavadora(int precioBase, int peso) {
        super(precioBase, peso);
        carga = 5;
        inteligente = false;
        programa = "Económico";
    }

    // Constructor con todos los atributos
    public Lavadora(int precioBase, int peso, char consumo_energetico, String color, int carga, boolean inteligente, String programa) {
        super(precioBase, color, consumo_energetico, peso);
        this.carga = carga;
        this.inteligente = inteligente;
        this.programa = programa;
    }

    public int getCarga() {
        return carga;
    }

    public boolean isInteligente() {
        return inteligente;
    }

    public String getPrograma() {
        return programa;
    }

    /*
     Incrementa al precio de Electrodomestico
     50 si la carga es mayor a 30
     25 si es inteligente
    */
    @Override
    public int preciofinal() {
        int p = super.preciofinal();

        if (getCarga() > 30) p += 50;
        if (isInteligente()) p += 25;

        return p;
    }

    @Override
    public void dimeAlexa() {
        if (isInteligente()) System.out.println(Arrays.toString(listado));
            else System.out.println("No es inteligente");
    }
}
