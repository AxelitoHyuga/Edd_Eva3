package Ordenamiento_Cadena_Textos;

import java.util.Scanner;

public class Sorts {

    public static void main(String[] args) {

        String[] arregloOrig = new String[4];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < arregloOrig.length; i++) {
            System.out.println("Ingresa un texto: ");
            arregloOrig[i] = scanner.nextLine();
        }

        System.out.println("Arreglo original:----------------------------------------");
        imprimir(arregloOrig);

        System.out.println("Selection Sort:----------------------------------------");
        String[] arregloSel = new String[arregloOrig.length];
        copiar(arregloOrig, arregloSel);
        selectionSort(arregloSel);
        imprimir(arregloSel);

        System.out.println("Insertion Sort:----------------------------------------");
        String[] arregloIns = new String[arregloOrig.length];
        copiar(arregloOrig, arregloIns);
        insertionSort(arregloIns);
        imprimir(arregloIns);

        System.out.println("Bubble Sort:----------------------------------------");
        String[] arregloBubble = new String[arregloOrig.length];
        copiar(arregloOrig, arregloBubble);
        bubbleSort(arregloBubble);
        imprimir(arregloBubble);

        System.out.println("Quick Sort:----------------------------------------");
        String[] arregloQuick = new String[arregloOrig.length];
        copiar(arregloOrig, arregloQuick);
        quickSort(arregloQuick);
        imprimir(arregloQuick);
    }

    public static void imprimir(String[] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("[" + arreglo[i] + "]");
        }
        System.out.println("");
    }

    public static void copiar(String[] arreglo, String[] copia) {
        for (int i = 0; i < arreglo.length; i++) {
            copia[i] = arreglo[i];
        }
    }

    /* SelecionSort
        O(n^2): Comparaciones
        O(n^2): Intercambio */
    public static void selectionSort(String[] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            int min = i;

            for (int j = (i + 1); j < arreglo.length; j++) {
                if (arreglo[j].compareTo(arreglo[min]) <= 0) {
                    min = j;
                }
            }

            /* Se intercambia min - i */
            if (min != i) {
                String temp = arreglo[i];
                arreglo[i] = arreglo[min];
                arreglo[min] = temp;
            }

        }
    }

    /* InsertionSort
        O(n): comparaciones
        O(n*2): intercambios */
    public static void insertionSort(String[] arreglo) {
        for (int i = 1; i < arreglo.length; i++) {
            String temp = arreglo[i];
            int insP = i;

            for (int prev = i - 1; prev >= 0; prev--) {
                /* Si el elemento anterior es mayor al actual, intercambiamos */
                if (arreglo[prev].compareTo(temp) >= 0) {
                    arreglo[insP] = arreglo[prev];
                    insP--;
                } else {
                    break;
                }
            }

            arreglo[insP] = temp;
        }
    }

    /* BubbleSort */
    public static void bubbleSort(String[] arreglo) {
        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = 0; j < (arreglo.length - i - 1); j++) {
                if (arreglo[j].compareTo(arreglo[j + 1]) >= 0) {
                    String temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
    }

    /* QuickSort N*N */
    public static void quickSort(String[] arr) {
        quickSortRec(arr, 0, arr.length - 1);
    }

    private static void quickSortRec(String[] arr, int ini, int fin) {
        if (ini < fin) {
            int pivot = quickSortPart(arr, ini, fin);

            /* Sortea los elementos recursivamente antes y después de la partición */
            quickSortRec(arr, ini, pivot - 1);
            quickSortRec(arr, pivot + 1, fin);
        }
    }

    private static int quickSortPart(String[] arr, int ini, int fin) {
        String pivot = arr[fin];
        int i = (ini-1);
        for (int j=ini; j<fin; j++)
        {
            /* Si el elemento actual es menor o igual al pivote */
            if (arr[j].compareTo(pivot) <= 0)
            {
                i++;

                /* Se intercambian arr[i] y arr[j] */
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Se intercambian arr[i+1] y arr[fin] (o pivote)
        String temp = arr[i+1];
        arr[i+1] = arr[fin];
        arr[fin] = temp;

        return i+1;
    }

}
