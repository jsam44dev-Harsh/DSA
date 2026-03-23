import java.util.*;

public class GroupReverse {

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
        GroupReverse ll=new GroupReverse();
        ll.addfirst(7);
        ll.addfirst(5);
        ll.addfirst(3);
        ll.addfirst(1);
        GroupReverse util = new GroupReverse();
        Node mergedHead = util.reverseKGroup(ll.head, 2);

        util.printList(mergedHead);

    }
    public Node reverseKGroup(Node head, int k) {
        // code here
        Node prev=null;
        Node curr=head;
        Node next=null;
        int x=0;
        while(curr!=null &&x<k){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            x++;
        }
        if (next != null)
            head.next = reverseKGroup(next, k);
        return prev;

    }
    public void addfirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void printList(Node node) {
        Node currNode = node;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }
}

