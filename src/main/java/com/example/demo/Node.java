package com.example.demo;

/* Stores one element of a linked list. */
public class Node {
    private Object element;// data
    private Node next;
    private  LinkedList list;

    // arguments constructors
    public Node(Object element) {
        this(element, null);
    }
    public Node(Object element, Node next) {
        this.element = element;
        this.next = next;
    }

    // getter and setter

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public LinkedList getList() {
        return list;
    }

    public void setList(LinkedList list) {
        this.list = list;
    }
}
