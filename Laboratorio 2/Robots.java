public class Robots {

    private String nombre;
    private Double puntosDeVida;
    private Double ataque;

    public Robots (String nombre, Double puntosDeVida, Double ataque) {
        
        this.nombre = nombre;
        this.puntosDeVida = puntosDeVida;
        this.ataque = ataque;
    }

    //Setters

    public void SetNombre (String nombre){
        this.nombre = nombre;
    }

    public void SetPuntosDeVida (Double puntosDeVida){
        this.puntosDeVida = puntosDeVida;
    }

    public void SetAtaque (Double ataque){
        this.ataque = ataque;
    }
}