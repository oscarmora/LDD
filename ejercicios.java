
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author salaf406
 */
public class ejercicios {

    /**
      * 
      */
   public ejercicios()
   {
      super();
      // TODO Auto-generated constructor stub
   }

   /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner sc = new Scanner(System.in);

        System.out.print("Cuantas posisiones\n");
        int n = sc.nextInt();
        int sum = 0, pro = 1;

        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            if (esPar(i)) {
                arr[i] = i + 7;
            } else {
                arr[i] = i - 1;
            }

            sum += esPar(arr[i]) ? arr[i] : 0;
            pro *= !esPar(arr[i]) ? arr[i] : 1;

            trace("Vector[" + i + "]=" + arr[i] + "\n");
        }

        trace("La sumatoria es: " + sum + "\n");
        trace("La productoria es: " + pro + "\n");


    }

    public static void trace(String n) {
        System.out.print(n);
    }

    public static boolean esPar(int n) {
        return (n % 2 == 0);
    }
//terminar 26 25 27 28
}