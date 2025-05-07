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

//método que recibe la letra y le dice al usuario si adivinó correctamente y muestra el progreso de la partida
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

    
    boolean acierto = false;
    for (int i = 0; i < palabraSecreta.length(); i++){
        if (palabraSecreta.charAt(i) == letra ){
            progreso[i] = letra;
            acierto = true;
        }

        if (!acierto){
            intentosRestantes--;
            System.out.println("La letra que eligió no se encuentra en la palabra secreta.Le quedan la siguiente cantidad de intentos: " + intentosRestantes);
        }else{
            System.out.println ("Adivinó una nueva letra correctamente");
        }
    
    
        System.out.println("Progreso de la actual partida:");
        for (int j = 0; j < progreso.length; j++){
            System.out.print(progreso[j] + " ");
        }
        System.out.println();
    }

}









