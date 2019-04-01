package com.dr.list;

public class LruLinkedList<T> extends LinkedList<T> {

    private int memorySize = 0;//用于限制限定内存空间大小，也就是缓存大小

    static final int DEFAULT_CAP = 5;

    public LruLinkedList() {
        this(DEFAULT_CAP);
    }

    public LruLinkedList(int defaultCap) {
        memorySize = defaultCap;
    }


    //lru添加

    public void lruPut(T data) {
        if (size >= memorySize) {
            removeLast();
            put(data);
        } else {
            put(data);
        }
    }

    /**
     * 删除
     * @return
     */
    public T lruRemove(){
        return removeLast();
    }


    /**
     *  lru算法是 保留最近访问的数据，移除最老数据的算法
     * @param index
     * @return
     */
    public T lruGet(int index){
        checkPointIndex(index);
        Node node=list;
        Node preNode=list;

        for (int i=0;i<index;i++){
            preNode=node;
            node=node.next;
        }
        T resultNode=node.data;
        //将访问的节点移到表头
        preNode.next=node.next;
        Node head=list;
        node.next=head;
        list=node;

        return resultNode;

    }




}
