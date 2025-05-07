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
}



//getters de la clase
public int getIntentosRestantes() {
    return intentosRestantes;
}

public String getProgreso() {
    return new String(progreso);
}

public boolean haGanado() {
    for (int i = 0; i < progreso.length; i++) {
        if (progreso[i] == '_') {
            return false;
        }
    }
    return true;
}

public boolean haPerdido() {
    return intentosRestantes <= 0;
}









}