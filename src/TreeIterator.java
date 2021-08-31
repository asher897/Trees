public class TreeIterator<T extends Comparable<T>> {
    private BinaryNode<T> current;
    private BinaryNode<T> left;
    private BinaryNode<T> right;
    private BinaryNode<T> previous;

    public TreeIterator(BinaryNode<T> root) {
        this.current = root;
        this.left = root.getLeft();
        this.right = root.getRight();
        this.previous = null;
    }

    public BinaryNode<T> nextLeft() {
        BinaryNode<T> temp = new BinaryNode<T>();
        temp = this.current;
        this.previous = this.current;
        this.current = this.left;
        this.left = this.current.getLeft();
        this.right = this.current.getRight();

        return temp;
    }

    public BinaryNode<T> nextRight() {
        BinaryNode<T> temp = new BinaryNode<T>();
        temp = this.current;
        this.previous = this.current;
        this.current = this.left;
        this.left = this.current.getLeft();
        this.right = this.current.getRight();

        return temp;
    }
}
