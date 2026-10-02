/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        
        HashMap<Integer,Node> hmap = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        q.add(node);

        while (!q.isEmpty()) {
            Node currNode = q.poll();
            if(!hmap.containsKey(currNode.val)){
                hmap.put(currNode.val, new Node(currNode.val));
            }
            for(Node n:currNode.neighbors){
                if(!hmap.containsKey(n.val)){
                    Node newNode = new Node(n.val);
                    hmap.put(newNode.val, newNode);
                    hmap.get(currNode.val).neighbors.add(newNode);
                    q.add(n);
                }
                else{
                    hmap.get(currNode.val).neighbors.add(hmap.get(n.val));
                }
            }
        }

        return hmap.get(node.val);
    }
}