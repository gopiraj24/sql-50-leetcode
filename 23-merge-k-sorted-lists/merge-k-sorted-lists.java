/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) { 
        //  Edge case 
        if (lists == null || lists.length == 0) return null;

        // Min Heap (based on node value) 
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b)-> a.val - b.val);

        // Step 1: Add all heads 

        for (ListNode node : lists) {
            if(node != null) {
                pq.add(node);
            }
        }

    //  Dummy node to build result 
    ListNode dummy = new ListNode(0);
    ListNode tail = dummy;

    //  step 2: Process heap 
    while (!pq.isEmpty()) {
        ListNode minNode = pq.poll();

        tail.next = minNode;
        tail = tail.next;

        //  If next exists, add to heap
        if (minNode.next != null) {
            pq.add(minNode.next);
        }
    }

    return dummy.next;
        
    }
}