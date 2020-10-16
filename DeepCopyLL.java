/*
 * #138. Copy List with Random Pointer
 * 
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

1. val: an integer representing Node.val
2. random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.
 

Example 1:
Refer leetcode

Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]

Example 2:
Refer leetcode

Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]

Example 3:
Refer leetcode


Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]

Example 4:

Input: head = []
Output: []
Explanation: Given linked list is empty (null pointer), so return null.
 

Constraints:

1. -10000 <= Node.val <= 10000
2. Node.random is null or pointing to a node in the linked list.
3. The number of nodes will not exceed 1000.

 */


/*
 * Time Complexity: O (N) ->  because we make one pass over the original linked list.
 * 
 * Space complexity: O (N) -> as we have a 'map' containing mapping from old list nodes to new list nodes. Since there are N nodes, we have O(N) space complexity.
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.design5;

import java.util.HashMap;

//Definition for a Node50.
class Node50 {
 int val;
 Node50 next;
 Node50 random;

 public Node50(int val) {
     this.val = val;
     this.next = null;
     this.random = null;
 }
 
}

public class DeepCopyLL {
	HashMap<Node50, Node50> map;
    
    public Node50 copyRandomList(Node50 head) {
        
        // #1. Base condition
        if(head == null){
            return null;
        }
        
        // #2. Create a HashMap to store mapping of old Node50s to new Node50s
        map = new HashMap<>();
        
        // #3. Assign the head to oldNode50 pointer using which we will traverse the given LL
        Node50 oldNode50 = head;
        
        // #4. Clone the old Node50
        Node50 newNode50 = new Node50(oldNode50.val);
        
        // #5. Initialize the map with oldNode50 -> newNode50 mapping
        map.put(oldNode50, newNode50);
        
        // #6. Wire the next and random pointer connections for cloned Node50s
        // Do this until the end of a given LL
        while(oldNode50 != null){
            
            // Get the cloned Node50 for a particular old Node50 from the map
            newNode50.next = clonedNode50(oldNode50.next); 
            newNode50.random = clonedNode50(oldNode50.random);
            
            // Once next and random pointers are wired, move to the next oldNode50 and newNode50
            oldNode50 = oldNode50.next;
            newNode50 = newNode50.next;
        }
        
        // return deep copy of a LL
        // head pointer is first Node50 in given LL, map.get(head) gives the pointer to first Node50 in the cloned LL
        return map.get(head);
        
    }
    
    public Node50 clonedNode50(Node50 Node50){
        
        if(Node50 != null){
            // If map contains oldNode50.next or oldNode50.random as a key
            if(map.containsKey(Node50)){
                // Get the cloned Node50 for oldNode50.next or oldNode50.random from a map
                return map.get(Node50);
            }
            else{
                // Put the oldNode50.next or oldNode50.random as a key and newly created cloned Node50 as a value in a map
                map.put(Node50, new Node50(Node50.val));
                return map.get(Node50);
            }
        }
        
        return null;
        
    }
    
}
