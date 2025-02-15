import java.util.Arrays;

public class Television extends Electrodomestico implements Alexa{
    private int resolucion;
    private boolean smartTv;
    private String canal;
    private final String[] canales = new String[] {"La 1 HD", "La 2 HD", "TD HD", "Antena 3 HD", "Telecinco HD", "Netfilx", "HBO", "Amazon Prime"};

    public Television() {
        super();
        resolucion = 32;
        smartTv = false;
        canal = "La 1 HD";
    }

    public Television(int precioBase, int peso) {
        super(precioBase, peso);
        resolucion = 32;
        smartTv = false;
        canal = "La 1 HD";
    }

    public Television(int precioBase, int peso, char consumo_energetico, String color, int resolucion, boolean smartTv, String canal) {
        super(precioBase, color, consumo_energetico, peso);
        this.resolucion = resolucion;
        this.smartTv = smartTv;
        this.canal = canal;
    }

    public int getResolucion() {
        return resolucion;
    }

    public boolean isSmartTv() {
        return smartTv;
    }

    public String getCanal() {
        return canal;
    }

    /*
      Incrementa al precio de Electrodomestico
      El incremento del 30% se puede representar como la unidad (1) más un 0.3 extra
      50 si es inteligente
     */
    @Override
    public int preciofinal() {
        int p = super.preciofinal();

        if (getResolucion() > 40) p *= (int) 1.3;
        if (isSmartTv())  p += 50;

        return p;
    }

    @Override
    public void dimeAlexa() {
        if (isSmartTv()) System.out.println(Arrays.toString(canales));
            else System.out.println("No es una SmartTv");
    }
}
