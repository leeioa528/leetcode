package _116_PopulatingNextRightPointersInEachNode;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import com.leetcode.TreeLinkNode;

public class SolutionTest{
    
    /**
     * Test method for
     * {@link _116_PopulatingNextRightPointersInEachNode.Solution }
     */
    Solution solution;

    @Rule
    public Timeout globalTimeout = new Timeout(200);

    @Before
    public void setUp() throws Exception {
        solution = new Solution();
    }

    @After
    public void tearDown() throws Exception {
        solution = null;
    }

    //      1              1  -> NULL
    //    /   \    ==>   /   \  
    //   2     3        2  -> 3 -> NULL  
    @Test
    public void Test1() {
        TreeLinkNode t1 = new TreeLinkNode(1);
        TreeLinkNode t2 = new TreeLinkNode(2);
        TreeLinkNode t3 = new TreeLinkNode(3);
        TreeLinkNode.connect(t1, t2, t3);
        TreeLinkNode root = t1;
        
        solution.connect(root);
        
        TreeLinkNode e1 = new TreeLinkNode(1);
        TreeLinkNode e2 = new TreeLinkNode(2);
        TreeLinkNode e3 = new TreeLinkNode(3);
        TreeLinkNode.connect(e1, e2, e3, null);
        TreeLinkNode.connect(e2, null, null, e3);
        TreeLinkNode expected = e1;
        
        assertTrue(TreeLinkNode.isSameLinkTree(expected, root));
        
    }

    //      1              1  -> NULL
    //    /   \    ==>   /   \  
    //   2     3        2  -> 3 -> NULL  
    //  / \   / \      / \   / \
    // 4   5 6   7    4 ->5->6 ->7 -> NULL
    @Test
    public void Test2() {
        TreeLinkNode t1 = new TreeLinkNode(1);
        TreeLinkNode t2 = new TreeLinkNode(2);
        TreeLinkNode t3 = new TreeLinkNode(3);
        TreeLinkNode t4 = new TreeLinkNode(4);
        TreeLinkNode t5 = new TreeLinkNode(5);
        TreeLinkNode t6 = new TreeLinkNode(6);
        TreeLinkNode t7 = new TreeLinkNode(7);
        TreeLinkNode.connect(t1, t2, t3);
        TreeLinkNode.connect(t2, t4, t5);
        TreeLinkNode.connect(t3, t6, t7);
        TreeLinkNode root = t1;
        
        solution.connect(root);
        
        TreeLinkNode e1 = new TreeLinkNode(1);
        TreeLinkNode e2 = new TreeLinkNode(2);
        TreeLinkNode e3 = new TreeLinkNode(3);
        TreeLinkNode e4 = new TreeLinkNode(4);
        TreeLinkNode e5 = new TreeLinkNode(5);
        TreeLinkNode e6 = new TreeLinkNode(6);
        TreeLinkNode e7 = new TreeLinkNode(7);
        TreeLinkNode.connect(e1, e2, e3, null);
        TreeLinkNode.connect(e2, e4, e5, e3);
        TreeLinkNode.connect(e3, e6, e7, null);
        TreeLinkNode.connect(e4, null, null, e5);
        TreeLinkNode.connect(e5, null, null, e6);
        TreeLinkNode.connect(e6, null, null, e7);
        TreeLinkNode expected = e1;
        
        assertTrue(TreeLinkNode.isSameLinkTree(expected, root));
        
    }

    //      1              1  -> NULL
    @Test
    public void Test3() {
        TreeLinkNode t1 = new TreeLinkNode(1);
        TreeLinkNode root = t1;
        
        solution.connect(root);
        
        TreeLinkNode e1 = new TreeLinkNode(1);
        TreeLinkNode expected = e1;
        
        assertTrue(TreeLinkNode.isSameLinkTree(expected, root));
        
    }

    //   
    @Test
    public void Test4() {
        TreeLinkNode root = null;
        
        solution.connect(root);
        
        TreeLinkNode expected = null;
        
        assertTrue(TreeLinkNode.isSameLinkTree(expected, root));
        
    }

}
