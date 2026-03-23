public class Rotate {
    Node head;
    class Node {
        String data;
        Node next;

        Node(String d){
            this.data=d;
            this.next=null;
        }
    }
    public static void main(String[] args) {
        Rotate list=new Rotate();
        list.addfirst("4");
        list.addfirst("3");
        list.addfirst("2");
        list.addfirst("1");
        list.rotate(list.head,6);

    }
    public void rotate(Node head, int k) {
        // code here
        if(head==null || head.next==null){
            return;
        }
        int n=1;
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
            n++;
        }
        Node tempnew=head;
        while(k%n!=0){
            tempnew=tempnew.next;
            k--;
        }
        head=tempnew.next;
        tempnew.next=null;

    }
    

    public void addfirst(String data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void printList() {
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }
}
