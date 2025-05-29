import javax.swing.*;

public class VentanaPrincipal extends JFrame{

    public VentanaPrincipal(){

        setTitle ("Formulario de usuario");
        setSize (400,300);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo (null); //Esto cierra la ventana

        JMenuBar menuBar = new JMenuBar ();
        JMenu menuArchivo = new JMenu ("Archivo");
        JMenuItem nuevoItem = new JMenuItem ("Nuevo");
        JMenuItem guardarItem = new JMenuItem ("Guardar");
        JMenuItem salirItem = new JMenuItem ("Salir");


        menuArchivo.add (nuevoItem);
        menuArchivo.add (guardarItem);
        menuArchivo.addSeparator (); //Ayuda a hacer una sepracion visual
        menuArchivo.add (salirItem);
        menuBar.add (menuArchivo);
        setJMenuBar (menuBar);

        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new BoxLayout (panelFormulario, BoxLayout.Y_AXIS));

        JLabel etiquetaNombre = new JLabel("Nombre");
        JTextField campoNombre = new JTextField(20);

        JLabel etiquetaEmail = new JLabel("Email");
        JTextField campoEmail = new JTextField(20);

        JLabel etiquetaTelefono = new JLabel("Telefono");
        JTextField campoTelefono = new JTextField(20);

        panelFormulario.add(etiquetaNombre);
        panelFormulario.add (campoNombre);
        panelFormulario.add (etiquetaEmail);
        panelFormulario.add (campoEmail);
        panelFormulario.add (etiquetaTelefono);
        panelFormulario.add (campoTelefono);

        add (panelFormulario);

        salirItem.addActionListener(e -> System.exit (0));

    }

    public static void main (String [] args){

        VentanaPrincipal ventana = new VentanaPrincipal ();
        ventana.setVisible (true); //Muestra la ventana
    }
}