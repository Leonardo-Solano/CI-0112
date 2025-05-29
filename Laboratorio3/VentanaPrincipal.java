import javax.swing.*;

public class VentanaPrincipal extends JFrame{

    public VentanaPrincipal(){

        setTitle ("Formulario de usuario");
        setSize (400,300);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo (null); //Esto cierra la ventana
    }

    public static void main (String [] args){

        VentanaPrincipal ventana = new VentanaPrincipal ();
        ventana.setVisible (true); //Muestra la ventana
    }
}