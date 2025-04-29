public class Robots {

    private String nombre;
    private Double puntosDeVida;
    private Double ataque;

    public Robots (String nombre, Double puntosDeVida, Double ataque) {
        
        this.nombre = nombre;
        this.puntosDeVida = puntosDeVida;
        this.ataque = ataque;


        //Rango de vida del robot entre 50 y 100

        if (puntosDeVida<50){
            puntosDeVida = 50;
        }
        if (puntosDeVida>100){
            puntosDeVida = 100;
        }

        //Rango de ataque del robot entre 10 y 20

        if (ataque<10){
            ataque=10;
        }
        if (ataque>20){
            ataque=20;
        }
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

    //Metodos

    public void atacar (Robot otroRobot){
        
        Double daño = this.ataque;

        double VidaActual = otroRobot.getPuntosDeVida ();
        Double VidaRestante = VidaActual-daño;

        //Esto nos ayuda a actualizar la vida del otro robot despúes de recibir el ataque.
        otroRobot.SetPuntosDeVida (VidaRestante);

        //Este if le permite al programa saber que un robot no puede quedar con vida negativo, por lo que, si eso sucede, automaticamente queda en 0.
        if (VidaRestante<0){
            VidaRestante=0;
        }
    }

    //Este método nos permite saber si el robot está vivo o no. No hace falta un if, porque si la vida es mayor a 0, automaticamente sabe que es un true.
    public boolean estaVivo(){

        return this.puntosDeVida > 0;
    }
}