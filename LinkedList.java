public class ConstructList<E> {
    private class Node<E> {
         Node next;
        public E e;
        public Node(E e,Node next){
            this.e=e;
            this.next=next;
        }
        public Node(E e){
            this(e,null);
        }
        public Node(){
            this(null,null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "next=" + next +
                    ", e=" + e +
                    '}';
        }
    }

    private Node dummyHead;
    private int size;
/**使用虚拟头结点保证其实结点存在*/
    public ConstructList(){
        dummyHead=new Node(null,null);
        size=0;
    }
     public boolean isEmpty(){
        return size==0;
     }
     public int getSize(){
        return size;
     }
     /**向链表的首位加载*/
     public void addFirst(E e){
       add(e,0);
     }
     /**在链表的任意位置添加结点，头结点使用虚拟结点*/
     public void add(E e,int index){
         if (index<0||index>size){
             throw new IllegalArgumentException(" index Exception");
         }

         Node prev=dummyHead;
         for (int i =0; i <index ; i++) {
             prev=prev.next;
         }
         Node node=new Node(e);
         node.next=prev.next;
         prev.next=node;
         size++;
     }
     public void addLast(E e){
         add(e,size);
     }
     /**删除元素*/
     public E remove(int index){
         if (index<0||index>size){
             throw new IllegalArgumentException("index Eception");
         }
         Node prev=dummyHead;
         for (int i = 0; i <index ; i++) {
             prev=prev.next;
         }
         Node cur= prev.next;
         prev.next=cur.next;
         cur.next=null;
         size--;
         return (E)cur.e;
     }
     public E get(int index){
         if (index<0||index>size){
             throw new IllegalArgumentException("illega index");
         }
         Node prev=dummyHead.next;
         for (int i=0;i<index;i++){
             prev=prev.next;
         }
         return (E)prev.e;
     }
}
