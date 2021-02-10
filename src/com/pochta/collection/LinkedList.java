package com.pochta.collection;

import java.util.Iterator;

public class LinkedList<Element> implements Iterable<Element> {

    private Node<Element> first;
    private Node<Element> last;
    private int size;

    private static class Node<Element> {
        Element item;
        Node<Element> next;
        Node<Element> prev;

        public Node(Element item, Node<Element> next, Node<Element> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node<Element> getNodeByIndex(int index) {
        Node<Element> result = first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result;
    }

    //Добавить новый элемент в конец списа (просто операция add)

    public void add(Element element) {
        if (first == null) {
            Node<Element> node = new Node<>(element, null, null);
            first = node;
            last = node;
            size++;
        } else {
            Node<Element> node = new Node<>(element, null, last);
            last.next = node;
            last = node;
            size++;
        }
    }

    //Вернуть длину списка

    public int size() {
        return size;
    }

    public Element get(int index) {
        return getNodeByIndex(index).item;
    }

    // Вернуть первый элемент

    public Element getFirstElement() {
        return first.item;
    }

    // Вернуть последний элемент

    public Element getLastElement() {
        return last.item;
    }

    //Добавить элемент в начало списка

    public void addFirst(Element element) {
        Node<Element> firstElement = new Node<>(element, first, null);
        Node<Element> tmp = firstElement;
        tmp.prev = firstElement;
        first = firstElement;
        size++;
    }

    //Удалить элемент по индексу

    public void delete(int index) {
        Node<Element> deleteNode = getNodeByIndex(index);
        Node<Element> elementBefore = deleteNode.prev;
        Node<Element> elementAfter = deleteNode.next;
        elementBefore.next = elementAfter;
        elementAfter.prev = elementBefore;
        size--;
    }

    //Реализовать возможность прохождения итератором по списку

    @Override
    public Iterator<Element> iterator() {
        return new Iterator<Element>() {
            private Node<Element> current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Element next() {
                Node<Element> tmp = current;
                current = current.next;
                return tmp.item;
            }
        };
    }
}
