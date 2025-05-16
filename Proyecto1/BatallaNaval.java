/**

@file BatallaNaval.Java
@brief En esta clase se presenta el juego BatallaNaval


Esta clase contiene absolutamente toda la logica y estado del juego: los tableros, los disparos,
colocacion de los barcos, los turnos y la verificacion de los ganadores.

@author Leonardo Solano Ramirez
@version final
@date 16-05-2025
 */


import java.util.Scanner;

/**
 * @brief Esta es la clase principal del juego batalla naval entre los dos jugadores
 */
public class BatallaNaval {

    private int barcoUno;
    private int barcoDos;
    private boolean turnoJugador;
    private char [][] tableroJugador1;
    private char [][] tableroJugador2;
    private char [][] disparosJugador1;
    private char [][] disparosJugador2;
    private Scanner scanner = new Scanner (System.in);

    /**
     * @brief Este es el constructor de la clase BatallaNaval, permite que se cree el objeto en la clase main. Todo lo que esta dentro de este
     * metodo se va a inicializar automaticamente cuando se cree el objeto.
     */
    public BatallaNaval (){

        //En el metodo constructor se inicializan los tableros, al vida de los barcos y los respectivos disparos de los jugadores.

        this.turnoJugador = true;
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
    
    /**
     * @brief Este barcoUno establecera la vida de los barcos del jugador 1
     * @param barcoUno Se le asignara el valor de vida del barco
     */
    public void setBarcoUno (int barcoUno){
        this.barcoUno = barcoUno;
    }

    /**
     * @brief Este barcoUno establecera la vida de los barcos del jugador 2
     * @param barcoDos Se le asignara el valor de vida del barco
     */
    public void setBarcoDos (int barcoDos){
        this.barcoDos = barcoDos;
    }

    /**
     * @brief Establecera el turno del jugador actual
     * @param turnoJugador tiene un valor booleana para determinar el turno
     */
    public void setTurnoJugador (boolean turnoJugador){
        this.turnoJugador = turnoJugador;
    }

    //Getters

    /**
     * @brief Obtiene el valor de vida del barco del jugador 1
     * @return Retorna la vida del barco
     */
    public int getBarcoUno (){
        return barcoUno;
    }

     /**
     * @brief Obtiene el valor de vida del barco del jugador 2
     * @return Retorna la vida del barco
     */
    public int getBarcoDos (){
        return barcoDos;
    }
     /**
     * @brief Retorna el turno de alguno de los dos jugadores
     * @return true si es el turno del jugador 1.
     */
    public boolean getTurnoJugador (){
        return turnoJugador;
    }

    /**
     * @brief Inicializa un tablero con los carecteres "-"
     * @param tablero que se inicializara
     */
    public void inicializarTab (char [][] tablero){
        for ( int i = 0; i < tablero.length; i++){
            for (int j = 0; j < tablero[i].length; j++){
                tablero [i][j] = '-';
            }
        }
    }

    /**
     * @brief Asigna la vida d elos barcos a los jugadores
     */
    //Este metodo permite asignarle vida a los barcos de los jugadores.
    public void vidaBarcos (){

        this.barcoUno = 300;
        this.barcoDos = 300;
    }
    /**
     * @brief Permite disparar a los barcos en una posicion del tablero oponente
     * @param fila a la fila que se va a disparar
     * @param columna a la columna que se va a disparar
     * @param jugador1 sera true si es el turno de disparar al jugador1 o sera false si es el turno del jugador2
     */
    //Por medio de este metodo se da la accion de disparle entre los dos jugadores. Ademas permita saber cuando acerto y fallo un jugador.
    public void disparos ( int fila, int columna, boolean jugador1){

        if (jugador1) {

            if (tableroJugador2 [fila][columna] == 'B'){

                    disparosJugador1 [fila][columna] = 'X';
                    tableroJugador2 [fila] [columna] = 'X';

                    this.barcoDos -= 100;
                    System.out.println(" has dado al objetivo, jugador 1");

            }else{
                    disparosJugador1 [fila][columna] = 'O';
                    System.out.println("El jugador 1 ha fallado");
                }

            }else{
                
                if (tableroJugador1 [fila][columna] == 'B') {

                    disparosJugador2 [fila][columna] = 'X';
                    tableroJugador1  [fila][columna] = 'X';

                    this.barcoUno -= 100;
                    System.out.println(" has dado al objetivo, jugador 2");
            }else{

                    disparosJugador2 [fila][columna] = 'O';
                    System.out.println("El jugador 2 ha fallado");
            }
         }
    }

    /**
     * @brief Permite a los jugadores colocar el barco en cualquier lado del tablero
     * @param esjugador true si es el jugador1 quien debe poner los barcos, false si le toca al jugador2
     */
    //Este metodo permite colocar los barco en el tablero de cada jugador.
    public void posicionDelBarco (boolean esjugador){

        int barcosPorColocar = 0;

        char [][] tablero;

        int numJugador;

        if (esjugador){

            tablero = tableroJugador1;
            numJugador = 1;

        }else{

            tablero = tableroJugador2;
            numJugador = 2;
        }

        System.out.println("Hola, jugador: " + numJugador + "Por favor ingrese sus 3 barcos en el tablero");

            //Este while permite que los jugadores agregan sus 3 barcos en el respectivo tablero
        while (barcosPorColocar < 3){
            System.out.println ("Por favor ingrese una fila (0 a 4): ");
            int fila = scanner.nextInt();
            System.out.println ("Por favor ingrese una columna (0 a 4): ");
            int columna = scanner.nextInt();

                //Este if ayuda a colocar los parametros en los que deben existir los barcos.
            if (fila >= 0 && fila < 5 && columna >= 0 && columna < 5){
                if (tablero [fila][columna] != 'B'){
                    tablero [fila][columna] = 'B';
                    barcosPorColocar++;
                    System.out.println("Barco colocado en ( " + fila + "," + columna + ")" );

                }else{
                    System.out.println("Ya hay un barco en esa posicion, escoge otra" );
                }

            } else{
                    System.out.println("Coordenadas fuera de rango");
            }

        }
    }

    /**
     * @brief Muestra el tablero del jugador actual y los diparos que este ha hecho
     * @param jugadorActual indica el numero del jugador actual (sea 1 o 2)
     */
    //Este metodo le permite al programa mostrar el tablero en la pantalla de los jugadores por turno.
    public void mostrarTablero (int jugadorActual){

        char [][] miTablero;
        char [][] disparosHechos;

        if (jugadorActual == 1){

            miTablero = tableroJugador1;
            disparosHechos = disparosJugador1;

        }else{

            miTablero = tableroJugador2;
            disparosHechos = disparosJugador2;
        }

        System.out.println( "tu tablero");
        impresionDeMatriz (miTablero);

        System.out.println( "Tablero Enemigo. Estos son tus disparos");
        impresionDeMatriz (disparosHechos);
    }

    /**
     * @brief Imprime la matriz que se vera en todo en la consola
     * @param matriz permite imprimir los caracteres en consola
     */
    //Este metodo se relaciona con el metodo mostrarTablero ya que, este precisamente muestra la matriz del tablero donde se va a colar todo.
    public void impresionDeMatriz (char [][] matriz){
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){

                System.out.print(matriz [i][j] + "  ");
            }
                System.out.println();
        }
    }

    /**
     * @brief verifica si uno de los dos jugarores ya gano el juego
     * @return si es true hay ganador, si es false significa que no hay ganador
     */
    //Este metodo le permite al programa ver si ya uno de los dos jugadores ganaron el juego. La idea es que verifique si los barcos ya tienen 0 de vida
    public boolean verificarSiHayGanador() {
        if (barcoUno <= 0){
            System.out.println ("El jugador dos ha ganado");
            return true;
        }
         if(barcoDos <= 0){
                System.out.println ("El jugador uno ha ganado");
                return true;
            }

            //Sino s cumplen los dos if's, significa que ambos tienen vida, por lo que, retorna false (nadie tiene 0 de vida)
            return false;
        }

        /**
         * @brief Permite el flujo completo del juego
         */
    /*Por ultimo, el metodo jugar permite que los jugadores puedan interactuar con todos los otros metodos ya creados. Les permite colocar
     * los barcos dentro del tablero, saber cuando se acaba el juego y disparar a los otros barcos.
     */
    public void jugar (){

        boolean seAcaboElJuego = false;
        int jugadorActual = 1;

        System.out.println("Por favor, jugador:  " + jugadorActual + ". Posiciona tus 3 barcos");
        posicionDelBarco(true);

        System.out.println("Por favor, jugador:  " + jugadorActual + ". Posiciona tus 3 barcos");
        posicionDelBarco(false);

        /*Este while es el que permite que el juego siga en pie todo el tiempo. Tiene la instruccion que le permite detener el bucle
         * solo si verifica que el juego ya acabo. Sino ha acabado, sigue el bucle hasta que alguno pierda ssus 3 barcos
         */
        while (!seAcaboElJuego) {

            mostrarTablero(jugadorActual);
            
            System.out.println (" Jugador: " + jugadorActual + "Ingrese una fila del 0-4, por favor: ");
            int fila = scanner.nextInt();
            System.out.println (" Jugador " + jugadorActual + "Ingrese una columna del 0-4, por favor: ");
            int columna = scanner.nextInt();
            disparos(fila, columna, jugadorActual == 1);

            seAcaboElJuego = verificarSiHayGanador();

            if (jugadorActual == 1) {
                jugadorActual = 2;

            }else{

                jugadorActual = 1;
            }
        }
            System.out.println ("El juega ha acabado con éxito, :) ");
    }
}