import java.util.Scanner;

/**
 * @class Menu
 * @brief Clase principal que contiene el método main y muestra el menú del sistema.
 */
public class Menu {

    /**
     * @brief Método principal que muestra el menú de juegos y gestiona la interacción con el usuario. 
       Permite al usuario:
     - Jugar Ahorcado (ingresando una palabra secreta y luego adivinanbdo)
     - Jugar Batalla Naval (llamando a la clase correspondiente)
     - Salir del programa. 

     * El menú se repite hasta que el usuario decida no jugar más
     */
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean siguejugando = true;

        while (siguejugando) {
            // Muestra el menú principal
            System.out.println("=== Bienvenidos al MENÚ PRINCIPAL ===");
            System.out.println("*** Seleccione 1 para jugar ahorcado ***");
            System.out.println("*** Seleccione 2 para jugar batalla naval ***");
            System.out.println("*** Seleccione 3 para salir ***");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpia el buffer

            switch (opcion) {
                case 1:
                    // Solicita la palabra secreta al Jugador 1
                    System.out.println("Jugador 1, ingrese la palabra secreta para el ahorcado:");
                    String palabraSecreta = scanner.nextLine().toLowerCase();

                    // Simula limpiar la pantalla
                    for (int i = 0; i < 50; i++) {
                        System.out.println();
                    }

                    // Inicia el juego de Ahorcado con el Jugador 2
                    System.out.println("*** Turno del Jugador 2 ***");
                    Ahorcado juegoAhorcado = new Ahorcado(palabraSecreta);
                    juegoAhorcado.jugar();
                    break;

                case 2:
                    // Inicia el juego de Batalla Naval
                    BatallaNaval jugarBatallaNval = new BatallaNaval();
                    jugarBatallaNval.jugar();
                    break;

                case 3:
                    // Sale del juego
                    siguejugando = false;
                    System.out.println("*** Gracias por jugar ***");
                    break;

                default:
                    // Maneja entradas inválidas
                    System.out.println("*** Opción no válida. Intentar de nuevo ***");
                    break;
            }

            // Verifica si se desea jugar de nuevo tras jugar Ahorcado o Batalla Naval
            if (opcion == 1 || opcion == 2) {
                System.out.println("*** ¿Deseas jugar de nuevo? (s/n) ***");
                String respuestaJugador = scanner.nextLine().toLowerCase();
                siguejugando = respuestaJugador.equals("s");
            }
        }

        scanner.close(); // Cierra el scanner al finalizar
    }
}
