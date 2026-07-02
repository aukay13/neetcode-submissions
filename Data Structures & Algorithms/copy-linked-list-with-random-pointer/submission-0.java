/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> hmap = new HashMap<>();
        hmap.put(null, null);
        Node curr = head;
        while (curr!=null) {
            hmap.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while (curr!=null) {
            Node n = hmap.get(curr);
            n.next = hmap.get(curr.next);
            n.random = hmap.get(curr.random);
            curr = curr.next;
        }

        return hmap.get(head);
    }
}
