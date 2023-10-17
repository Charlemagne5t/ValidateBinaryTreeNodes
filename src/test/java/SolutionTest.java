import org.junit.Assert;
import org.junit.Test;


public class SolutionTest {
    @Test
    public void validateBinaryTreeNodesTest1(){
        int n = 4;
        int[] leftChild = {1,-1,3,-1};
        int[] rightChild = {2,-1,-1,-1};
        boolean actual = new Solution().validateBinaryTreeNodes(n, leftChild, rightChild);

        Assert.assertTrue(actual);
    }

    @Test
    public void validateBinaryTreeNodesTest2(){
        int n = 4;
        int[] leftChild = {1,-1,3,-1};
        int[] rightChild = {2,3,-1,-1};
        boolean actual = new Solution().validateBinaryTreeNodes(n, leftChild, rightChild);

        Assert.assertFalse(actual);
    }

    @Test
    public void validateBinaryTreeNodesTest3(){
        int n = 4;
        int[] leftChild = {1,0};
        int[] rightChild = {-1,-1};
        boolean actual = new Solution().validateBinaryTreeNodes(n, leftChild, rightChild);

        Assert.assertFalse(actual);
    }
}
