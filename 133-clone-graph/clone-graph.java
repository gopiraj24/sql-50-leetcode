import java.util.*;

class Solution {

    // Map to store original node -> cloned node
    private Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {

        // Edge case: empty graph
        if (node == null) return null;

        // If already cloned, return it
        if (map.containsKey(node)) {
            return map.get(node);
        }

        // Create new node
        Node clone = new Node(node.val);
        map.put(node, clone);

        // Clone all neighbors
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }
}
