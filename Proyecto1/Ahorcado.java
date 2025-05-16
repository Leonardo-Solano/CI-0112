/**
 @file Ahorcado.java
 @brief Clase que implementa el juego del Ahorcado.
 
 Esta clase permite crear y jugar una partida del clásico juego del Ahorcado.
 Controla la palabra secreta, el progreso del jugador, el número de intentos restantes
 y verifica si se gana o se pierde.

 @author Alondra Peña Quirós 
 @version Final
 @date 16-05-2025
 */



import java.util.Scanner;

/**
 * @brief Contiene la lógica y estado del juego del Ahorcado.
 */
public class Ahorcado {
    
    private String palabraSecreta;          
    private char[] progreso;                 
    private char[] letrasAdivinadas;      
    private int intentosRestantes;           
    private int cantidadLetrasAdivinadas;    


    /**
     * @brief Constructor del juego Ahorcado.
     * 
     * Inicializa la palabra secreta, el progreso con guiones bajos y los intentos restantes.
     * 
     * @param palabra Palabra que debe adivinar el jugador 2.
     */
    public Ahorcado (String palabra) {
        this.palabraSecreta = palabra.toLowerCase();
        this.intentosRestantes = 6;
        this.progreso = new char[palabra.length()];

        for (int i = 0; i < palabra.length(); i++) {
            progreso[i] = '_';
        }

        this.letrasAdivinadas = new char[palabra.length() + 10];
    }


    /**
     * @brief Obtiene el número de intentos restantes.
     * @return Número de intentos que quedan.
     */
    public int getIntentosRestantes() {
        return intentosRestantes;
    }


    /**
     * @brief Obtiene el progreso actual como cadena.
     * @return Progreso del jugador con las letras adivinadas.
     */
    public String getProgreso() {
        return new String(progreso);
    }


    /**
     * @brief Método para procesar una letra adivinada por el jugador.
     * 
     * Verifica si la letra ya fue usada, si está en la palabra secreta, y actualiza el progreso o reduce intentos.
     * 
     * @param letra Letra que el jugador intenta adivinar.
     */
    public void adivinarLetra(char letra) {
        letra = Character.toLowerCase(letra);

        // Verifica si ya se intentó esta letra
        for (int i = 0; i < cantidadLetrasAdivinadas; i++) {
            if (letrasAdivinadas[i] == letra) {
                System.out.println("Ya intentó con esta letra");
                return;
            }
        }

        letrasAdivinadas[cantidadLetrasAdivinadas] = letra;
        cantidadLetrasAdivinadas++;

        boolean acierto = false;

        // Verifica si la letra está en la palabra secreta
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                progreso[i] = letra;
                acierto = true;
            }
        }

        if (!acierto) {
            intentosRestantes--;
            System.out.println("La letra que eligió no se encuentra en la palabra secreta. Le quedan la siguiente cantidad de intentos: " + intentosRestantes);
        } else {
            System.out.println("Adivinó una nueva letra correctamente");
        }

        // Muestra el progreso de la partida
        System.out.println("Progreso de la actual partida:");
        for (int j = 0; j < progreso.length; j++) {
            System.out.print(progreso[j] + " ");
        }
        System.out.println();
    }

    
    /**
     * @brief Verifica si el jugador ha ganado.
     * @return true si adivinó todas las letras, false si no.
     */
    public boolean haGanado() {
        for (int i = 0; i < progreso.length; i++) {
            if (progreso[i] == '_') {
                return false;
            }
        }
        return true;
    }


    /**
     * @brief Verifica si el jugador ha perdido.
     * @return true si se acabaron los intentos, false si aún quedan.
     */
    public boolean haPerdido() {
        return intentosRestantes <= 0;
    }


    /**
     * @brief Método que ejecuta una partida completa del juego.
     * 
     * Este método coordina la entrada de letras por el jugador, llama a los métodos de verificación
     * y determina si se gana o se pierde. Solo termina cuando se adivina la palabra o se acaban los intentos.
     */
    public void jugar() {
        Scanner scanner = new Scanner(System.in);

        while (!haGanado() && !haPerdido()) {
            System.out.println("Jugador 2 ingrese una letra para adivinar");
            String entrada = scanner.nextLine();

            // Validación: debe ser solo una letra
            if (entrada.length() != 1) {
                System.out.println("Entrada inválida, solo puede ingresar una sola letra");
                continue;
            }

            if (!Character.isLetter(entrada.charAt(0))) {
                System.out.println("Entrada inválida, debe ingresar una letra para poder jugar");
                continue;
            }

            char letra = entrada.charAt(0);
            adivinarLetra(letra);
        }

        if (haGanado()) {
            System.out.println("Ha adivinado la palabra secreta");
        } else {
            System.out.println("Se acabaron los intentos, la palabra era: " + palabraSecreta);
        }
    }
}















