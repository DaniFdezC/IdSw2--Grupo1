import extras.*;
import personajes.*;
import objetos.*;
import renderizacion.RecuadroPersonaje;

import java.util.Scanner;

public class VistaBatalla {

    protected RecuadroPersonaje recuadro;
    protected Heroe heroe;

    private Scanner entrada;

    private final int ATACAR = 1;
    private final int DEFENDER = 2;
    private final int CURARSE = 3;

    public VistaBatalla(Heroe heroe, Enemigo enemigo){
        this.heroe = heroe;
        recuadro = new RecuadroPersonaje(heroe, enemigo);
        entrada = new Scanner(System.in);
    }

    public void imprimirInterfaz(){
        recuadro.imprimir();
    }

    public void anunciarGanador(Personaje ganador){
        System.out.println(ganador.getNombre() + " ha sido el ganador!");
    }

    public Acciones elegirAccion(){
        mostrarAcciones();

        switch (scanElegir(heroe.getAcciones().length)){
            case ATACAR -> {
                return Acciones.ATACAR;
            }
            case DEFENDER -> {
                return Acciones.DEFENDER;
            }
            case CURARSE -> {
                return Acciones.CURARSE;
            }
            default -> {
                return null;
            }
        }
    }

    public int elegirArma(){
        mostrarArmas();
        return scanElegir(heroe.getArmas().length);
    }

    public void esperarInteraccion(){
        Scanner a = new Scanner(System.in);
        a.nextLine();
    }
    private int scanElegir(int numMax){
        boolean elegidaOpcionCorrecta = false;
        int eleccion = 0;

        while (!elegidaOpcionCorrecta){

            eleccion = entrada.nextInt();

            if (eleccion > 0 & eleccion <= numMax){
                elegidaOpcionCorrecta = true;
            }
        }

        return eleccion;
    }

    private void mostrarAcciones(){
        for (String accion : heroe.getAcciones()) {
            System.out.print(accion + " || ");
        }
    }

    private void mostrarArmas(){
        for (Arma arma : heroe.getArmas()){
            System.out.println(arma.getNombre() + " // ");
        }
    }


}
