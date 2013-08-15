
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
                sum += !esPar(arr[i]) ? arr[i] : 0;
            } else {
                arr[i] = i - 1;
                pro *= esPar(arr[i]) ? arr[i] : 1;
            }

            System.out.print("Vector[" + i + "]=" + arr[i] + "\n");
        }

        System.out.print("La sumatoria es: " + sum + "\n");
        System.out.print("La productoria es: " + pro + "\n");


    }

    public static boolean esPar(int n) {
        return (n % 2 == 0);
    }
//terminar 26 25 27 28
}