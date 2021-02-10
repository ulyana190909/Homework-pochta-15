package com.pochta.collection;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");
        System.out.println(linkedList.size());
        System.out.println(linkedList.getFirstElement());
        System.out.println(linkedList.getLastElement());
        System.out.println("\n");
        linkedList.addFirst("G");
        System.out.println(linkedList.getFirstElement());
        System.out.println(linkedList.size());
        System.out.println("\n");
        linkedList.delete(2);
        System.out.println(linkedList.size());
        System.out.println("\n");
        for (String element : linkedList) {
            System.out.println(element);
        }
    }
}
