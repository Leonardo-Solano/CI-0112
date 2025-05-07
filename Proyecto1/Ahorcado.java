public class Ahorcado{
    private String palabraSecreta;
    private char[] progreso;
    private char[] letrasAdivinadas;
    private int intentosRestantes;
    private int cantidadLetrasAdivinadas;


public Ahorcado (String palabra){
    this.palabraSecreta = palabra.toLowerCase();
    this.intentosRestantes = 6;
    this.progreso = new char [palabra.length()];

    for (int i = 0; i < palabra.length(); i++){
    progreso[i] = '_';
    }
}

}