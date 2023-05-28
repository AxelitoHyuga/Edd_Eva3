package Implementar_QuickSort_Listas;

import java.util.Scanner;

class Node {
    private int value;
    private Node next;
    private Node prev;

    public Node() {
        next = null;
        prev = null;
    }

    public Node(int value) {
        this.value = value;
        next = null;
        prev = null;
    }

    public Node(int value, Node next, Node prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}

public class List {
    private Node front;
    private Node back;
    private int size;

    public List() {
        front = null;
        back = null;
        size = 0;
    }

    public void add(int value) {
        Node newNode = new Node(value);

        if (front == null) {
            front = newNode;
            back = newNode;
        } else {
            // Conectamos el nuevo nodo al final
            back.setNext(newNode);
            newNode.setPrev(back);
            back = newNode;
        }

        size++;
    }

    public String toString() {
        String text = "[";
        Node temp = front;

        while (temp != null) {
            text += temp.getValue();
            temp = temp.getNext();

            if (temp != null) {
                text += ",";
            }
        }

        text += "]";

        return text;
    }

    public void quickSort() {
        quickSortRec(front, back);
    }

    private void quickSortRec(Node low, Node high) {
        if (high != null && low != null && low != high && low != high.getNext()) {
            Node pivot = partition(low, high);
            quickSortRec(low, pivot.getPrev());
            quickSortRec(pivot.getNext(), high);
        }
    }

    private Node partition(Node low, Node high) {
        int pivot = high.getValue();
        Node i = low.getPrev();

        for (Node j = low; j != high; j = j.getNext()) {
            if (j.getValue() <= pivot) {
                i = (i == null) ? low : i.getNext();
                swapValues(i, j);
            }

            if (j.getNext() == null) {
                break;
            }
        }

        i = (i == null) ? low : i.getNext();
        swapValues(i, high);

        return i;
    }

//    private void swapValues(Node node1, Node node2) {
//        int temp = node1.getValue();
//        node1.setValue(node2.getValue());
//        node2.setValue(temp);
//    }

    private void swapValues(Node node1, Node node2) {
        if (node1 == front) {
            front = node2;
        } else if (node2 == front) {
            front = node1;
        }
        if (node1 == back) {
            back = node2;
        } else if (node2 == back) {
            back = node1;
        }
        Node temp;
        temp = node1.getNext();
        node1.setNext(node2.getNext());
        node2.setNext(temp);

        if (node1.getNext() != null) {
            node1.getNext().setPrev(node1);
        }

        if (node2.getNext() != null) {
            node2.getNext().setPrev(node2);
        }

        temp = node1.getPrev();
        node1.setPrev(node2.getPrev());
        node2.setPrev(temp);

        if (node1.getPrev() != null) {
            node1.getPrev().setNext(node1);
        }

        if (node2.getPrev() != null) {
            node2.getPrev().setNext(node2);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List list = new List();

        System.out.println("Ingrese la cantidad de nodos: ");
        int nodos = scanner.nextInt();

        for (int i = 0; i < nodos; i++) {
            list.add((int)(Math.random() * 100));
        }

        System.out.println(list.toString());

        list.quickSort();
        System.out.println(list.toString());
    }
}
