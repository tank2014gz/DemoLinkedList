package com.dr.list;

//单链表
public class LinkedList<T> {

    Node list;
    int size;


    public LinkedList() {
        size = 0;
    }


    //添加节点

    /**
     * 添加头部节点
     *
     * @param data
     */
    public void put(T data) {
        Node head = list;
        Node curNode = new Node(data, list);
        list = curNode;
        size++;


    }

    public void put(int index, T data) {
        checkPointIndex(index);
        Node curNode = list;
        Node head = list;
        for (int i = 0; i < index; i++) {
            head = curNode;
            curNode = curNode.next;
        }
        Node node = new Node(data, curNode);
        head.next = node;
        size++;

    }

    //删除节点
    //删除头部节点
    public T remove() {
        if (list != null) {
            Node node = list;
            list = list.next;
            node.next = null;//GC 回收
            size--;
            return node.data;
        }
        return null;
    }


    public T remove(int index) {
        checkPointIndex(index);
        Node head = list;
        Node curNode = list;

        for (int i = 0; i < index; i++) {
            head = curNode;
            curNode = curNode.next;
        }
        head.next = curNode.next;
        curNode.next = null;//GC回收
        size--;
        return curNode.data;
    }


    public T removeLast() {
        if (list != null) {
            Node node = list;
            Node curNode = list;
            while (curNode.next != null) {
                node = curNode;
                curNode = curNode.next;
            }
            node.next = null;
            size--;
            return curNode.data;
        }
        return null;
    }

    //查询节点
    //获取头部节点
    public T get() {
        Node node = list;
        if (node == null) {
            return null;
        } else {
            return node.data;
        }
    }


    public T get(int index) {
        checkPointIndex(index);
        Node node = list;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.data;
    }

    //修改节点
    public void set(int index, T newData) {
        checkPointIndex(index);
        Node head = list;
        for (int i = 0; i < index; i++) {
            head = head.next;
        }
        head.data = newData;
    }

    /**
     * 检查index是否在链表范围内
     *
     * @param index
     * @return
     */
    public void checkPointIndex(int index) {
        if (!(index >= 0 && index < size)) {
            throw new IndexOutOfBoundsException("index:" + index + "size:" + size);
        }
    }


    //节点
    class Node {
        T data;
        Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    @Override
    public String toString() {

        Node node = list;
        for (int i = 0; i < size; i++) {
            System.out.print(node.data + " ; ");

            node = node.next;
        }
        System.out.println();
        return super.toString();
    }




}
