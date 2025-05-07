public class BatallaNaval {

    private int barcoUno;
    private int barcoDos;
    private boolean turnoJugador;
    private char [][] tableroJugador1;
    private char [][] tableroJugador2;
    private char [][] disparosJugador1;
    private char [][] disparosJugador2;

    public BatallaNaval (int barcoUno, int barcoDos, boolean turnoJugador, char tableroJugador1, char tableroJugador2, char disparosJugador1, char disparosJugador2){

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
    }

    
}