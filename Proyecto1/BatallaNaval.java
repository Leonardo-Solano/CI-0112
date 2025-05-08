import java.util.Scanner;

public class BatallaNaval {

    private int barcoUno;
    private int barcoDos;
    private boolean turnoJugador;
    private char [][] tableroJugador1;
    private char [][] tableroJugador2;
    private char [][] disparosJugador1;
    private char [][] disparosJugador2;

    public BatallaNaval (int barcoUno, int barcoDos, boolean turnoJugador, char tableroJugador1){

        this.barcoUno = barcoUno;
        this.barcoDos = barcoDos;
        this.turnoJugador = turnoJugador;
        this.tableroJugador1 = new char[5][5];
        this.tableroJugador2 = new char[5][5];
        this.disparosJugador1 = new char[5][5];
        this.disparosJugador2 = new char[5][5];

        inicializarTab (this.tableroJugador1);
        inicializarTab (this.tableroJugador2);
        inicializarTab (this.disparosJugador1);
        inicializarTab (this.disparosJugador2);

        vidaBarcos();
    }


    // Setter

    public void setBarcoUno (int barcoUno){
        this.barcoUno = barcoUno;
    }
    public void setBarcoDos (int barcoDos){
        this.barcoDos = barcoDos;
    }
    public void setTurnoJugador (boolean turnoJugador){
        this.turnoJugador = turnoJugador;
    }

    //Getters

    public int barcoUno (){
        return barcoUno;
    }
    public int barcoDos (){
        return barcoDos;
    }
    public boolean turnoJugador (){
        return turnoJugador;
    }

    public void inicializarTab (char [][] tablero){
        for ( int i = 0; i < tablero.length; i++){
            for (int j = 0; j < tablero[i].length; j++){
                tablero [i][j] = '-';
            }
        }
    }

    public void vidaBarcos (){

        this.barcoUno = 300;
        this.barcoDos = 300;
    }

    public void disparos ( int fila, int columna, boolean jugador1){

        if (jugador1) {

            if (tableroJugador2 [fila][columna] == 'B'){

                    disparosJugador1 [fila][columna] = 'X';
                    tableroJugador2 [fila] [columna] = 'X';

                    barcoDos -= 100;
                    System.out.println("Le has dado al objetivo, jugador 1");

            }else{

                    disparosJugador1 [fila][columna] = 'O';
                    System.out.println("El jugador 1 ha fallado");

                }

            }if (tableroJugador1 [fila][columna] == 'B') {

                    disparosJugador2 [fila][columna] = 'X';
                    tableroJugador1  [fila][columna] = 'X';

                    barcoUno -= 100;
                    System.out.println("Le has dado al objetivo, jugador 2");

            }else{

                    disparosJugador1 [fila][columna] = 'O';
                    System.out.println("El jugador 2 ha fallado");
        }
     }
}