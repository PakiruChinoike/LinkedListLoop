package linkedlistloop;

import java.util.HashSet;
import java.util.Scanner;

public class LinkedList {
    
    private static Node firstNode;

    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    static public void addNext(int value) {

        Node newNode = new Node(value);
        newNode.next = firstNode;
        firstNode = newNode;
    }

    static boolean isLoop(Node n) {
        HashSet<Integer> hash = new HashSet<Integer>();

        while(n!=null) {
            if(hash.contains(n.value)) {
                return true;
            } 
            hash.add(n.value);

            n = n.next;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList lList = new LinkedList();

        int nodeNumber = scanner.nextInt();
        firstNode = new Node(scanner.nextInt());
        for(int i = 1; i<nodeNumber; i++) {
            lList.addNext(scanner.nextInt());
        }

        if(isLoop(firstNode)) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }

        scanner.close();
    }

}   
