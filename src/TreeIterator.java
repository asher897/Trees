import java.util.*;

public class TreeIterator<T extends Comparable<T>> {
    private BinaryNode<T> current;
    private Stack<BinaryNode<T>> iter;

    public TreeIterator(BinarySearchTree<T> tree) {
        this.current = tree.getRoot();
        this.iter = new Stack<>();
        traverse(this.current);
        System.out.println("HELLO");
    }

    public void next() {
        BinaryNode<T> temp = this.iter.pop().getRight();
        traverse(temp);
    }

    public BinaryNode<T> current() {
        return this.iter.peek();
    }

    public boolean hasNext() {
        return !this.iter.isEmpty();
    }

    private void traverse(BinaryNode<T> node) {
        while (node != null) {
            this.iter.push(node);
            node = node.getLeft();
        }
    }

}
