
import java.util.Scanner;
import java.util.ArrayList; 
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.text.Normalizer;
import java.util.regex.Pattern;
import java.lang.Object;

//tarea 27,28,29

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
        ejercicio28();
    }

    public static void ejercicio28() {
        Scanner sc = new Scanner(System.in);

        trace("Ingrese la viga: ");

        //String s = sc.nextLine();
        String s = "#====*====================*==";

        trace(s);

        int r1 = 10, r2 = 30, r3 = 90, l = 1, c = 1, r;

        int nsegmentos;

        if(!validarViga(s)) return;
        nsegmentos = asignarSegmentos(s);

        if(s.substring(0).equals("%")){
            r = r1;
        }else if(s.substring(0).equals("&")){
            r = r2;
        }else{
            r = r3;
        }

        if((r - nsegmentos) <= 0){
            trace("La viga NO soporta el peso!");
        }else{
            trace("La viga soporta el peso!");
        }

    }

    public static boolean validarViga(String s) {
        if(!s.matches("(%|&|#)(.*)")){
            trace("La viga esta mal construida");
            return false;
        }

        return true;
    };

    public static int asignarSegmentos(String s) {
        String lArray[] = s.split("");
        int peso = 0;
        int pesoc = 0;
        int totalpeso = 0;

        for (int i = 1;i < lArray.length ; i++) {
            trace("---" + lArray[i]);
            if (lArray[i].equals("=") && !lArray[i].matches("(%|&|#)")) {
                peso ++;
                totalpeso += peso;
            trace("---/" + peso);
            }else if(lArray[i].equals("*") && !lArray[i].matches("(%|&|#)")){
                peso = 0;
                pesoc++;
            }else if(!lArray[i].matches("(%|&|#)")){
                trace("La viga esta mal construida");
                return -1;
            }
        }

        trace("peso:" + peso);
        trace("pesoc:" + pesoc);
        trace("total peso:" + totalpeso);

        return totalpeso+pesoc;
    };

    public static void ejercicio27() {
        Scanner sc = new Scanner(System.in);

        trace("Ingrese la frase: ");

        String s = sc.nextLine();
        //String s = "¿Acaso comeré mocos acá?";

        s = unAccent(s);

        s = s.trim();

        s = s.replace(" ", "");

        //trace(s);

        String sArray[] = s.split("");

        //trace(sArray.length);

        for (int i = 1; i <  sArray.length; i++) {
            if (sArray[i].equals(sArray[sArray.length - i])) {
                trace(sArray[i] + " == " + sArray[sArray.length - i]);
            }
            else
            {
                trace(sArray[i] + " != " + sArray[sArray.length - i]);
                trace("La frase NO es palindroma");
                return;
            }
        }

        trace("La frase SI es palindroma");
    }

    public static String unAccent(String s) {
        

        //s = s.toLowerCase();

        s = s.replace("á","a");
        s = s.replace("é","e");
        s = s.replace("í","i");
        s = s.replace("ó","o");
        s = s.replace("ú","u");

        s = s.replace("É","E");
        s = s.replace("Ó","O");
        s = s.replace("Ú","U");

        s = s.replaceAll("[¿?.,;:]","");

        s = s.toUpperCase();

        return s;

        /*// Descomposición canónica
        String normalized = Normalizer.normalize(s, Normalizer.Form.NFD);
        // Nos quedamos únicamente con los caracteres ASCII
        Pattern pattern = Pattern.compile("\\P{ASCII}");
        return pattern.matcher(normalized).replaceAll("");*/
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

        for (int i = 0; i < n - 1; i++) {
            
            for (int j = i + 1; j < n; j++) {
                if (o == 'a') {
                    if (x[i] > x[j]) {
                       aux = x[i];
                       x[i] = x[j];
                       x[j] = aux;
                    }
                }else{
                    if (x[i] > x[j]) {
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

    public static void trace(int n) {
        System.out.println(n);
    }

    public static void trace(boolean n) {
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