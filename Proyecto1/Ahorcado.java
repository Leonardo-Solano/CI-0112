import java.util.Scanner;
public class Ahorcado{
//atributos de la clase
    private String palabraSecreta;
    private char[] progreso;
    private char[] letrasAdivinadas;
    private int intentosRestantes;
    private int cantidadLetrasAdivinadas;



//constructor de la clase
    public Ahorcado (String palabra){
        this.palabraSecreta = palabra.toLowerCase();
        this.intentosRestantes = 6;
        this.progreso = new char [palabra.length()];

        for (int i = 0; i < palabra.length(); i++){
        progreso[i] = '_';
        }
        this.letrasAdivinadas = new char[palabra.length() + 10];
    }



//getters de la clase
    public int getIntentosRestantes() {
        return intentosRestantes;
    }

    public String getProgreso() {
        return new String(progreso);
    }



//métodos de la clase

//método que verifica los intentos de adivinar letras
    //Este fragmento sirve para saber si la letra que se está intentando ya se adivinó
    public void adivinarLetra(char letra){
        letra = Character.toLowerCase(letra);
        for (int i = 0; i < cantidadLetrasAdivinadas; i++){
            if (letrasAdivinadas[i] == letra){
                System.out.println("Ya intentó con esta letra");
                return;
            }
        }
        letrasAdivinadas[cantidadLetrasAdivinadas] = letra;
        cantidadLetrasAdivinadas++;


    //Esto verifica si la letra ingresada está en la palabra secreta
        boolean acierto = false;
        for (int i = 0; i < palabraSecreta.length(); i++){
            if (palabraSecreta.charAt(i) == letra ){
                progreso[i] = letra;
                acierto = true;
            }
        }


    //Este fragmento es para saber si la letra fue un acierto
        if (!acierto){
            intentosRestantes--;
            System.out.println("La letra que eligió no se encuentra en la palabra secreta.Le quedan la siguiente cantidad de intentos: " + intentosRestantes);
        }else{
            System.out.println ("Adivinó una nueva letra correctamente");
        }


    //Muestra el progreso de la partida
        System.out.println("Progreso de la actual partida:");
        for (int j = 0; j < progreso.length; j++){
            System.out.print(progreso[j] + " ");
        }
        System.out.println();

    }

    
//Método que verifica si se ganó la partida
    public boolean haGanado() {
        for (int i = 0; i < progreso.length; i++ ){
            if (progreso[i] == '_'){
            return false;
            }
        }
    return true;
    }

    

//Método que verifica si ya perdió todos los intentos y por lo tanto perdió
    public boolean haPerdido(){
        return intentosRestantes <= 0;
    }



//El método jugar es en el que van a interactuar los demás métodos y
//donde se va a ejecutar la lógica de la partida: entrada de letras, verificación de aciertos, turnos, y resultado final.
    public void jugar(){
        Scanner scanner = new Scanner(System.in);

        while(!haGanado() && !haPerdido()) {
            System.out.println("Jugador 2 ingrese una letra para adivinar");
            String entrada = scanner.nextLine();

            if (entrada.length() != 1) {
            System.out.println("Entrada inválida, solo puede ingresar una sola letra");
            continue;  
        }

            if (!Character.isLetter(entrada.charAt(0))) {
            System.out.println("Entrada invália, debe ingresar una letra para poder jugar");
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














