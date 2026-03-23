public class single {
    Node head;
    private int size;
    single(){
        this.size=0;
    }
    class Node{
        String data;
        Node next;
        Node(String data){
            this.data=data;
            this.next=null;
            size++;
        }
    }

    public static void main(String[] args) {
        single list= new single();
        list.addfirst("is");
        list.addfirst("this");

        list.printList();

        list.addLast("a");
        list.addLast("list");

        list.printList();

        list.removeFirst();

        list.printList();

        list.removeLast();

        list.printList();

        list.getSize();

    }

    // function to add element in the beginning of the Singly LL
    public void addfirst(String data){
        Node newNode= new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }
    // function to add element in the last of the Singly LL
    public void addLast(String data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        Node currNode=head;
        while(currNode.next!=null){
            currNode=currNode.next;
        }
        currNode.next=newNode;
    }

    // function to print the List
    public void printList(){
        if(head==null){
            System.out.print("List is empty");
        }
        Node currNode=head;
        while(currNode!=null){
            System.out.print(currNode.data+" -> "  );
            currNode=currNode.next;
        }
        System.out.println("null");
    }
    public void getSize(){
        System.out.println(size);
    }
    // function to remove first element from Singly LL
    public void removeFirst(){
        head=head.next;
        size--;
    }

    // function to remove element from last
    public void removeLast(){
        if(head==null){
            System.out.println("list is empty");
        }
        size--;
        if(head.next==null){
            head=null;
            return;
        }
        Node lastsecondNode=head;
        Node lastNode= head.next;
        while(lastNode.next!=null){
            lastNode=lastNode.next;
            lastsecondNode=lastsecondNode.next;
        }
        lastsecondNode.next=null;

    }

}
