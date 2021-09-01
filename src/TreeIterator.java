
/**
 * This class defines an Iterator that is used for tree data structures (AVL
 * and BST)
 * 
 * @author Aaron Sher
 * @since 30-08-2021
 */

import java.util.*;

public class TreeIterator<T extends Comparable<T>> {
    private BinaryNode<T> current;
    private Stack<BinaryNode<T>> iter;

    /**
     * Constructor for the class.
     * 
     * @param tree The BST to iterate through.
     */
    public TreeIterator(BinarySearchTree<T> tree) {
        this.current = tree.getRoot();
        this.iter = new Stack<>();
        traverse(this.current);
        System.out.println("HELLO");
    }

    /**
     * This method moves the iterator to the next Binary Node.
     */
    public void next() {
        BinaryNode<T> temp = this.iter.pop().getRight();
        traverse(temp);
    }

    /**
     * This method fetches the current Binary Node of the iterator.
     * 
     * @return The current Binary Node in the iterator.
     */
    public BinaryNode<T> current() {
        return this.iter.peek();
    }

    /**
     * This method checks to see if the tree has any more objects to iterate
     * through.
     * 
     * @return Boolean value (true or false).
     */
    public boolean hasNext() {
        return !this.iter.isEmpty();
    }

    /**
     * This method iterates through nodes only going to the left and pushing each
     * one onto the stack.
     * 
     * @param node The Binary Node to start with.
     */
    private void traverse(BinaryNode<T> node) {
        while (node != null) {
            this.iter.push(node);
            node = node.getLeft();
        }
    }

}
