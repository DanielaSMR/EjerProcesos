import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            Scanner sc = new Scanner(System.in);
            ProcessBuilder pb = new ProcessBuilder("kcalc");
            Process p = pb.start();

            String pInfo = p.info().toString();
            String resultado = "t";

            String respuesta = "";
            do{
                System.out.println("Quieres terminar con el proceso");
                respuesta = sc.nextLine();
                respuesta.toLowerCase();
            
                if(respuesta.equals("y")){
                    resultado = "f";
                    System.out.println(" | INFO: " + pInfo);
                    p.destroy();
                }else if(respuesta.equals("n")){
                    resultado = "f";
                    System.out.println("Esperando...");
                    //Thread.sleep(10000); //Si vamos a utilizarla mas de una vez hacer una funcion
                }else{
                    System.out.println("Caracter erroneo");
                    Thread.sleep(2000);
                }

            }while(!resultado.equals("f"));
            
            int result = p.waitFor();//Esperando a que el proceso hijo se muera
            int result2 = p.exitValue();//Para saber el valor del proceso hijo

            System.out.println(" | Final proceso (" + p.pid() + "). | Resultado: " + result + " | Informacion adicional " + pInfo);

            System.out.println("Final");

        } catch (IOException e) {
            e.printStackTrace();
         
            Thread.currentThread().interrupt();
        }
    }
}
