import java.util.*;

public class sortedMerge {

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
        sortedMerge ll=new sortedMerge();
        sortedMerge nn=new sortedMerge();
        ll.addfirst(7);
        ll.addfirst(5);
        ll.addfirst(3);
        ll.addfirst(1);
        nn.addfirst(6);
        nn.addfirst(4);
        nn.addfirst(2);
        sortedMerge util = new sortedMerge();
        Node mergedHead = util.merge(ll.head, nn.head);

        util.printList(mergedHead);

    }
    public  Node merge(Node head1, Node head2){
//        *********************************Efficient Approach************************
//        TC(n+m) and SC(1)


        Node dummy = new Node(-1);
        Node curr = dummy;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }
        if (head1 != null) {
            curr.next = head1;
        } else {
            curr.next = head2;
        }
        return dummy.next;

//        *********************************Recursive Approach************************
//        TC(n+m) and SC(n+,m)

//       if (head1==null){
//           return head2;
//       }
//       if(head2==null)
//           return head1;
//
//       if(head1.data<=head2.data){
//           head1.next=merge(head1.next,head2);
//           return head1;
//       }
//       else {
//           head2.next=merge(head1,head2.next);
//           return head2;
//       }
        // ********************************Brute force approach***********************
        // TC(n+m*log(n+m)) SC (SAME)

//        ArrayList<Integer> list= new ArrayList<>();
//        while(head1!=null){
//            list.add(head1.data);
//            head1=head1.next;
//        }
//        while(head2!=null){
//            list.add(head2.data);
//            head2=head2.next;
//        }
//        Collections.sort(list);
//        Node dummy = new Node(0);
//        Node current = dummy;
//        for (int val : list) {
//            current.next = new Node(val);
//            current = current.next;
//        }
//
//        return dummy.next;
//
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
