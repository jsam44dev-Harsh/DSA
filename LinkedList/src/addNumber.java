public class addNumber {
    Node head;
    class Node{
        int data;
        Node next;
        Node(int d){
            this.data=d;
            this.next=null;
        }
    }
    public static void main(String[] args) {

    }

    public void printList(){
        if(head==null){
            System.out.println("List is empty");
        }
        Node curr=head;
        while(curr!=null){
            System.out.println(curr.data+"->");
            curr=curr.next;
        }
        System.out.println("Null");
    }
    public void addFirst(int data){
        Node curr=new Node(data);
        if(head==null){
            head=curr;
            return;
        }
        curr.next=head;
        head=curr;
    }
}
