package com.dr.list;

public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.put(i);
        }

        list.put(2,6);
        list.put(11);
        list.toString();
        list.put(20,30);


    }
}
