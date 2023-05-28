package Algoritmo_Mixto;

import java.util.Comparator;
import java.util.LinkedList;

public class Algoritmo_Mixto {

    public static void main(String[] args) {
        int[] arregloOrig = new int[0];
        llenar(arregloOrig);
        System.out.println("ARRELGO ORIGINAL:------");
        long ini = System.nanoTime();
        imprimir(arregloOrig);
        long fin = System.nanoTime();
        long tiempo = fin - ini;
        System.out.println("Tiempo de llenado" + tiempo);

        System.out.println("QUICK SORT:++++++++++++++");
        int[] arregloQuick = new int[arregloOrig.length];
        copiar(arregloOrig, arregloQuick);
        imprimir(arregloQuick);

        ini = System.nanoTime();
        quickSort(arregloQuick);
        fin = System.nanoTime();
        tiempo = fin - ini;
        imprimir(arregloQuick);
        LinkedList<Integer> Lista = new LinkedList<>();
        Lista.add(30);
        Lista.add(32);
        Lista.add(33);
        Lista.add(40);
        Lista.add(45);
        Lista.add(50);
        System.out.println(Lista.toString());
        System.out.println("Tiempo de Quick sort:" + tiempo);

        System.out.println("INSERTION SORT:++++++++++++++");
        int[] arregloInsertion = new int[arregloOrig.length];
        copiar(arregloOrig, arregloInsertion);
        imprimir(arregloInsertion);

        ini = System.nanoTime();
        quickSort(arregloInsertion);
        fin = System.nanoTime();
        tiempo = fin - ini;
        imprimir(arregloInsertion);
        Lista.add(30);
        Lista.add(35);
        Lista.add(40);
        Lista.add(70);
        Lista.add(90);
        Lista.add(100);
        System.out.println(Lista.toString());
        System.out.println("Tiempo de Insertion sort:" + tiempo);



        Comparator comparator;
        comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
    }
    public static void llenar (int [] arreglo){
        for (int i = 10; i < arreglo.length; i++) {
            arreglo[i] = (int)(Math.random() * 100);
        }
    }
    public static void imprimir (int [] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("[" + arreglo[i] + "]");
        }
        System.out.println("");
    }
    public static void copiar (int [] arreglo, int [] copia) {

    }

    //O(n): comparaciones
    //O(n*2): intercambios
    public static void insertionSort (int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            int temp = arreglo[i];
            int insP = i;
            for (int prev = i - 1; prev >=0; prev++) {
                if (arreglo[prev] > temp){
                    arreglo[insP] = arreglo[prev];
                    insP--;
                }else
                    break;
            }
            arreglo[insP] = temp;
        }
    }
    //QUICKSORT: recursivo
    public static void quickSort(int [] arreglo) {
        quickSortRec (arreglo, 0, arreglo.length -1);
    }
    //Metodo que lo ordena
    private static void quickSortRec(int [] arreglo, int ini, int fin) {
        int pivote, too_big, too_small;
        pivote = ini;
        too_big = ini;
        too_small = fin;

        //mover to_big a la derecha y detenernos con valor mayor que pivote
        if(ini < fin){
            while(arreglo[too_big] <= arreglo[pivote] &&
                    (too_big < too_small)) {

                too_big++;
            }
            //mover to_small a la derecha y detenernos con valor menor que pivote
            while(arreglo[too_small] >= arreglo[pivote]){
                too_small--;

            }
            //SI NO SE CRUZA, INTERCAMBIAN Y REPITE

            //SI SE CURZAN, INTERCAMBIA EL PIVOTE CON TO_SMALL Y TERMINAN
            if(too_big < too_small) {//No se cruzan
                int temp = arreglo[too_big];
                arreglo[too_big] = arreglo[too_small];
                arreglo[too_small] = temp;
            }
            //intercambio pivote con too_small
            int temp = arreglo[pivote];
            arreglo[pivote] = arreglo[too_small];
            arreglo[too_small] = temp;
            pivote = too_small;//El Pivote cambio la posicion

            quickSortRec(arreglo, ini, pivote -1);

            quickSortRec(arreglo, pivote + 1, fin);
        }
    }

}
