
import java.util.Scanner;
import java.util.Random;

public class JuegoBatalla {

    public static void main (String [] args){

    }

    //Atributos
    private Robot[] robots;

    public JuegoBatalla (int cantidadDeRobots){

        robots = new Robot (cantidadDeRobots);
    }

    //Metodos

    public void iniciarCreacionRobots(){

        robots = creacionRobots ();
    }

    public Robot [] creacionRobots (){

        Scanner = new Scanner (System.in);
        System.out.println ("Ingrese la cantidad de robots que desea enfrentar");

        int cantidadDeRobots = nextInt();
        nextInt ();

        Robot [] nuevosRobots = new Robot [cantidadDeRobots];

        for (int i = 0; i < robots.length; i++);

        System.out.println("Ingrese el nombre del robot" + (i+1));
        String nombre = nextInt ();
    }

    public void iniciarBatalla (){

    }
}