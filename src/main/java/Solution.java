import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Set<Integer> setOfNodesWithNoParents = new HashSet<>();
        for (int i = 0; i < n; i++) {
            setOfNodesWithNoParents.add(i);
        }
        //find two parents
        Set<Integer> uniqueNodes = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if(leftChild[i] != -1){
                if(uniqueNodes.contains(leftChild[i])){
                    return false;
                }
                uniqueNodes.add(leftChild[i]);
                setOfNodesWithNoParents.remove(leftChild[i]);
            }
            if(rightChild[i] != -1){
                if(uniqueNodes.contains(rightChild[i])){
                    return false;
                }
                uniqueNodes.add(rightChild[i]);
                setOfNodesWithNoParents.remove(rightChild[i]);
            }
            if(setOfNodesWithNoParents.isEmpty()){
                return false;
            }
        }
        if(setOfNodesWithNoParents.size() != 1){
            return false;
        }
        //check if it is one connected graph
        int root = -1;
        for (int x : setOfNodesWithNoParents) {
            root = x;
        }

        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            int current = stack.pop();
            visited.add(current);
            if(leftChild[current] != - 1){
                stack.push(leftChild[current]);
            }
            if(rightChild[current] != - 1){
                stack.push(rightChild[current]);
            }
        }

        return visited.size() == n;
    }
}
