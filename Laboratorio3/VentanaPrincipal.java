import java.io.IOException;
import java.io.File;
import javax.swing.*;
import java.io.FileWriter;

public class VentanaPrincipal extends JFrame{

    private JTextField campoNombre;
    private JTextField campoEmail;
    private JTextField campoTelefono;
    private JComboBox<String> comboUsuario;
    private JCheckBox checkTerminos;

    public VentanaPrincipal(){

        setTitle ("Formulario de usuario");
        setSize (400,300);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo (null); //Esto cierra la ventana

        //Menu
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

        //Panel
        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new BoxLayout (panelFormulario, BoxLayout.Y_AXIS));

        JLabel etiquetaNombre = new JLabel("Nombre");
        campoNombre = new JTextField(20);

        JLabel etiquetaEmail = new JLabel("Email");
        campoEmail = new JTextField(20);

        JLabel etiquetaTelefono = new JLabel("Telefono");
        campoTelefono = new JTextField(20);

        panelFormulario.add(etiquetaNombre);
        panelFormulario.add (campoNombre);
        panelFormulario.add (etiquetaEmail);
        panelFormulario.add (campoEmail);
        panelFormulario.add (etiquetaTelefono);
        panelFormulario.add (campoTelefono);

        add (panelFormulario);

        //ComboBox para tipo de usuario

        String [] tipoDeUsuario = {"Seleccione", "Cliente", "Empleado", "Administrativo"};
        comboUsuario = new JComboBox<>(tipoDeUsuario);
        panelFormulario.add (new JLabel ("Tipo de usuario"));
        panelFormulario.add (comboUsuario);

        //CheckBox pata terminos y condiciones

        checkTerminos = new JCheckBox("Acepto los terminos y condiciones");
        panelFormulario.add(checkTerminos);

        //Apartado de botones
        JButton botonGuardado = new JButton("Guardar");
        botonGuardado.addActionListener (e -> guardarDatos ());

        JButton botonLimpiar = new JButton("Limpiar");
        botonLimpiar.addActionListener (e -> limpiarDatos ());

        panelFormulario.add (botonGuardado);
        panelFormulario.add (botonLimpiar);
        add(panelFormulario);

        //Acciones en el menú

        guardarItem.addActionListener(e -> guardarDatos());
        nuevoItem.addActionListener(e -> limpiarDatos());
        salirItem.addActionListener(e -> System.exit(0));

        //Lectura de los archivos
        cargarDatosSiExisten();
    }

     private void guardarDatos() {
            if (comboUsuario.getSelectedIndex() ==0){

                JOptionPane.showMessageDialog(this, "Seleccione un tipo de usuario");
                return;
            }
            if (! checkTerminos.isSelected()) {
                JOptionPane.showMessageDialog(this, "Debes aceptar los termininos y condiciones");
                return;
            }

            try {

                FileWriter writer = new FileWriter("datos_usuario txt");
                writer.write (campoNombre.getText() + "\n");
                writer.write (campoEmail.getText() + "\n");
                writer.write (campoTelefono.getText () + "\n");
                writer.write (comboUsuario.getSelectedItem() .toString() + "\n");
                writer.write (Boolean.toString(checkTerminos.isSelected()) + "\n");
                writer.close();
                JOptionPane.showMessageDialog(this, "Datos guardados correctamente");

            }catch (IOException ex){

                JOptionPane.showMessageDialog(this, "Error, los datos no se guardaron");
            }
        }

        private void limpiarDatos() {
        campoNombre.setText("");
        campoEmail.setText("");
        campoTelefono.setText("");
        comboUsuario.setSelectedIndex(0);
        checkTerminos.setSelected(false);
    }

    private void cargarDatosSiExisten() {
        java.io.File archivo = new java.io.File("datos_usuario.txt");
        if (archivo.exists()) {

            try (java.io.BufferedReader lector = new java.io.BufferedReader(new java.io.FileReader(archivo))) {
            campoNombre.setText(lector.readLine());
            campoEmail.setText(lector.readLine());
            campoTelefono.setText(lector.readLine());
            comboUsuario.setSelectedItem(lector.readLine());
            checkTerminos.setSelected(Boolean.parseBoolean(lector.readLine()));

            }catch (IOException e) {
            e.printStackTrace();
        }
    }
}

    public static void main (String [] args){
        VentanaPrincipal ventana = new VentanaPrincipal ();
        ventana.setVisible (true); //Muestra la ventana
    }
}