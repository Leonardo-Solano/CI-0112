import java.util.Scanner;
public class Menu {
    public static void main (String [] args){
    Scanner scanner = new Scanner (System.in);

        boolean siguejugando = true;
        
        while (siguejugando) {
            
            System.out.println ("=== Bienvenidos al MENÚ PRINCIPAL ===");
            System.out.println ("*** Seleccione 1 para jugar ahorcado ***");
            System.out.println ("*** Seleccione 2 para jugar batalla naval ***");
            System.out.println ("*** Seleccione 3 para salir ***");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                        System.out.println("Jugador 1, ingrese la palabra secreta para el ahorcado:");
                        String palabraSecreta = scanner.nextLine().toLowerCase();

                        Ahorcado juegoAhorcado = new Ahorcado(palabraSecreta);
                        juegoAhorcado.jugar();


                    break;
                
                case 2:
                        BatallaNaval jugarBatallaNval = new BatallaNaval();
                        jugarBatallaNval.jugar();
                        
                    break;

                case 3:
                    siguejugando = false;
                      System.out.println ("*** Gracias por jugar <3 ***");
                    break;

                default:
                      System.out.println ("*** Opción no válida. Intentar de nuevo ***");
                    break;
            }

            if (opcion == 1 || opcion == 2){
                System.out.println ("*** ¿Deseas jugar de nuevo? (s/n) ***");
                String respuestaJugador = scanner.nextLine(). toLowerCase();
                siguejugando = respuestaJugador.equals("s");
            }
        }

        scanner.close();
    }
    
}