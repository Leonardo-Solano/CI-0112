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

    //Getters

    public String getNombre (){
        return nombre;
    }

    public Double getPuntosDeVida (){
        return puntosDeVida;
    }

    public Double getAtaque (){
        return ataque;
    }
    

    //Rango de vida de los robots (50-100)

    if (puntosDeVida <50){
        
        puntosDeVida = 50;
    }

    //Metodos

    public void atacar (Double cantDeDayo){

        this.ataque = this.puntosDeVida-cantDeDayo;

        double atacar = this.ataque;

    }


}