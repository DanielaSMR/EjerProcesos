package E4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class E4 {
    public static void main(String[] args) throws Exception {
            
            Scanner sc = new Scanner(System.in);
            ProcessBuilder pb = new ProcessBuilder("konsole");
            String linea;

            pb.redirectErrorStream(true);
            /*
            *Este comando es porque las entradas y salidas se redigiren al proceso 
            *padre por lo que antes es necesario añadir esta linea
            */
            try {
                Process p = pb.start();
                InputStream is = p.getInputStream();
                /*
                *Esto va a ser necesario para luego acceder a los comandos read() y skip()
                *ya que lee los datos de entrada
                */
                BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
                /*
                *Creamos un buffer para leer texto del InputStream de una forma sencilla
                */
                System.out.println("Salida de la terminal");
                while((linea = br.readLine()) != null){
                    System.out.println(linea);
                }
                /*
                 * Aqui creamos un while que hara que "linea" pase a ser las lineas
                 * que leera el bufferReader(que saldran de la consola de conmandos)
                 * y mientras no sea null seguira mostrando linea por linea
                 */
            } catch (Exception e) {
                System.out.println("Error" + e.getMessage());
            }
            

            
            System.out.println("Terminal Cerrada");

    }
}
