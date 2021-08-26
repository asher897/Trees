/**
 * This class defines a Binary Node that is used in tree data structures (AVL
 * and BST)
 * 
 * @author Aaron Sher
 * @since 20-08-2021
 */

public class BinaryNode<T extends Comparable<T>> {
    private T data;
    private BinaryNode<T> left, right;
    private int height;

    /**
     * The constructor for the class
     * 
     * @param data This is the data that is stored in the BinaryNode
     */
    public BinaryNode(T data) {

        this.data = data;

        left = right = null;

        this.height = 1;

    }

    /**
     * No-argument constructor. The data variable is set to null;
     */
    public BinaryNode() {

        left = right = null;

        this.height = 1;

    }

    /**
     * This method is used to set the left BinaryNode of the calling BinaryNode.
     * Once set the height of the BinaryNode is increased by 1.
     * 
     * @param node This is the BinaryNode to be set to the left of the calling
     *             BinaryNode.
     */
    public void setLeft(BinaryNode<T> node) {

        this.left = node;

        this.height++;

    }

    /**
     * This method is used to set the right BinaryNode of the calling BinaryNode.
     * Once set the height of the calling BinaryNode is increased by 1.
     * 
     * @param node This is the BinaryNode to be set to the right of the calling
     *             BinaryNode.
     */
    public void setRight(BinaryNode<T> node) {

        this.right = node;

        this.height++;

    }

    /**
     * This method returns the BinaryNode on the left of the calling BinaryNode.
     * 
     * @return The BinaryNode on the left of the calling BinaryNode.
     */
    public BinaryNode<T> getLeft() {

        return this.left;

    }

    /**
     * This method returns the BinaryNode on the right of the calling BinaryNode.
     * 
     * @return The BinaryNode on the right of the calling BinaryNode of type
     *         BinaryNode<T>.
     */
    public BinaryNode<T> getRight() {

        return this.right;

    }

    /**
     * This method returns the data of the calling BinaryNode.
     * 
     * @return The data of the calling BinaryNode.
     */
    public T getData() {

        return this.data;

    }

    /**
     * This method sets the data of the calling BinaryNode.
     * 
     * @param data The data to be set.
     */
    public void setData(T data) {

        this.data = data;

    }

    /**
     * This method prints the data of the calling BinaryNode to the standard system
     * output.
     */
    public void printData() {

        System.out.println(this.data);

    }

    /**
     * This method sets the height of the calling BinaryNode based on the heights of
     * the child nodes.
     */
    public void setHeight() {

        if (this.left == null) {

            if (this.right == null) {

                this.height = 1;

            } else {

                this.height = 1 + this.right.getHeight();

            }
        } else if (this.right == null) {

            this.height = 1 + this.left.getHeight();

        } else {

            this.height = 1 + Math.max(this.left.getHeight(), this.right.getHeight());

        }
    }

    /**
     * This method returns the height of the calling BinaryNode.
     * 
     * @return An int value of the height of the calling BinaryNode.
     */
    public int getHeight() {

        return this.height;

    }

    /**
     * This method checks if the calling Binary Node is a leaf.
     * 
     * @return Either true or false.
     */
    public boolean isLeaf() {

        return (this.getLeft() == null && this.getRight() == null);

    }

}
