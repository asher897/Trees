import java.util.*;

public class TreeIterator<T extends Comparable<T>> {
    private BinaryNode<T> current;
    private Stack<BinaryNode<T>> iter;

    public TreeIterator(BinarySearchTree<T> tree) {
        this.current = tree.getRoot();
        while (!(this.current.getLeft() != null)) {
            this.iter.add(this.current);
            this.current = this.current.getLeft();
        }
    }

    public BinaryNode<T> next() {
        BinaryNode<T> temp = this.iter.pop();
        traverse(temp);
        return temp;
    }

    public boolean isEnd() {
        return this.current.isLeaf();
    }

    public boolean hasNext() {
        return iter.peek() != null;
    }

    private void traverse(BinaryNode<T> node) {
        while (!(node.getLeft() != null)) {
            this.iter.add(node);
            node = node.getLeft();
        }
    }

}
