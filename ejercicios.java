
import java.util.Scanner;
import java.util.ArrayList; 
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
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
        ejercicio26_2();
    }

    public static void ejercicio26_2() {
        Scanner sc = new Scanner(System.in);

        trace("Ingrese el tamanio del vector");

        int n = sc.nextInt();
        int par = 0, inpar = 0;

        int arr[] = new int[n];

        trace("Vector Sin Ordenar");

        for (int i = 0; i < n; i++) {
            arr[i] = new Random().nextInt(100);
            
            if (esPar(arr[i])) {
                par += 1;
            trace("Vector[" + i + "]=" + arr[i] + " par");
            } else {
                inpar += 1;
            trace("Vector[" + i + "]=" + arr[i] + " inpar");
            }
        }

        int arrOrden[] = new int[n];
        int arrPar[] = new int[par];
        int arrInPar[] = new int[inpar];

        int parI = 0;
        int inparI = 0;

        trace("Vector Ordenado");

        for (int i = 0; i < n; i++) {
            if (esPar(arr[i])) {
                arrPar[parI] = arr[i];
                parI++;
            } else {
                arrInPar[inparI] = arr[i];
                inparI++;
            }
        }

        Arrays.sort(arrPar);
        Arrays.sort(arrInPar);

        int _arrPar[] = arrPar.clone();

        for (int i = 0; i < arrPar.length; i++) {
            arrPar[i] = _arrPar[(arrPar.length - 1) - i];
        }

        System.arraycopy(arrPar, 0, arrOrden, 0, arrPar.length);
        System.arraycopy(arrInPar, 0, arrOrden, arrPar.length, arrInPar.length);

        //traceInt(arrPar);
        //traceInt(arrInPar);

        traceInt(arrOrden);
        
    }

    public static void ordenar(int x[], int n, char o){
        int  aux;

        for (int i; i < n - 1; -++) {
            
            for (int j = i + 1; j < n; j++) {
                if (0 == "a") {
                    if (arr[i] > arr[j]) {
                       aux = x[i];
                       x[i] = x[j];
                       x[j] = aux;
                    }
                }else{
                    if (arr[i] > arr[j]) {
                       aux = x[j];
                       x[j] = x[i];
                       x[i] = aux;
                    }
                }
            }
        }
    }

    public static void ejercicio26() {
        Scanner sc = new Scanner(System.in);

        trace("Cuantas posisiones");
        int n = sc.nextInt();
        int par = 0, inpar = 0;

        int arr[] = new int[n];

        trace("Vector Sin Ordenar");

        for (int i = 0; i < n; i++) {
            if (esPar(i)) {
                arr[i] = i * i + 1;
                par += 1;
            } else {
                arr[i] = 3 * (i + 1);
                inpar += 1;
            }

            trace("Vector[" + i + "]=" + arr[i]);

        }

        int arrOrden[] = new int[n];
        int arrPar[] = new int[par];
        int arrInPar[] = new int[inpar];

        int parI = 0;
        int inparI = 0;

        trace("Vector Ordenado");

        for (int i = 0; i < n; i++) {
            if (esPar(arr[i])) {
                arrPar[parI] = arr[i];
                parI++;
            } else {
                arrInPar[inparI] = arr[i];
                inparI++;
            }
        }

        Arrays.sort(arrPar);
        Arrays.sort(arrInPar);

        int _arrPar[] = arrPar.clone();

        for (int i = 0; i < arrPar.length; i++) {
        	arrPar[i] = _arrPar[(arrPar.length - 1) - i];
        }

        System.arraycopy(arrPar, 0, arrOrden, 0, arrPar.length);
		System.arraycopy(arrInPar, 0, arrOrden, arrPar.length, arrInPar.length);

        //traceInt(arrPar);
        //traceInt(arrInPar);

        traceInt(arrOrden);
        
    }

    public static void ejercicio24() {
        Scanner sc = new Scanner(System.in);

        trace("Cuantas posisiones?");
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

            trace("Vector[" + i + "]=" + arr[i]);
        }

        trace("La sumatoria es: " + sum);
        trace("La productoria es: " + pro);
    }

    public static void trace(String n) {
        System.out.println(n);
    }

    public static void traceInt(int[] n) {
        for (int i = 0; i < n.length; i++) {
        	trace("Vector[" + i + "]=" + n[i]);
        }
    }

    public static boolean esPar(int n) {
        return (n % 2 == 0);
    }
//terminar 26 25 27 28
}