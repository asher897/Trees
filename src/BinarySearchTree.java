import java.util.*;

/**
 * This class defines a Binary Search Tree (BST) and makes use of the
 * BinaryNode<T> class
 * 
 * @author Aaron Sher
 * @since 20-08-2021
 */

public class BinarySearchTree<T extends Comparable<T>> {
    protected BinaryNode<T> root;
    private int size;

    /**
     * Constructor of the BST class.
     * 
     * @param node A BinaryNode which is set to the root of the BST.
     */
    public BinarySearchTree(BinaryNode<T> node) {

        this.root = node;

    }

    /**
     * No-argument constructor. The root of the BST is set to null.
     */
    public BinarySearchTree() {

        this.root = null;

    }

    /**
     * This method returns the root of the BST.
     * 
     * @return The root of the BST as a BinaryNode.
     */
    public BinaryNode<T> getRoot() {

        return this.root;

    }

    /**
     * Returns the height of the BST.
     * 
     * @return The height of the BST.
     */
    public int getHeight() {

        return getHeight(root);

    }

    /**
     * This method calculates the height of a BST or subtree starting at a specified
     * BinaryNode.
     * 
     * @param node The root of the subtree where the height is to be calculated. If
     *             the root is passed it will return the heigh of the BST.
     * @return The height of the BST or subtree.
     */
    public int getHeight(BinaryNode<T> node) {

        if (node == null) {

            return -1;

        } else {

            return 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));

        }

    }

    /**
     * This method returns the size of the BST.
     * 
     * @return The size of the BST.
     */
    public int getSize() {

        return this.size;

    }

    /**
     * This method inserts specified data into the BST as the root if the BST is
     * empty, otherwise calls the other insert method.
     * 
     * @param data The data to be inserted.
     */
    public void insert(T data) {

        if (root == null) {

            root = new BinaryNode<T>(data);

            this.size++;

        } else {

            insert(data, root);

        }

    }

    /**
     * This method inserts data into the BST by placing it into a BinaryNode and
     * moving along the BST (left and right) until its correct location is found.
     * Once the node is inserted the size variable of the BST is increased by 1.
     * 
     * @param data The data to be placed into the BST.
     * @param node The BinaryNode at which to start looking for the correct location
     *             by comparing its left and right nodes.
     */
    public void insert(T data, BinaryNode<T> node) {

        if (data.compareTo(node.getData()) <= 0) {

            if (node.getLeft() == null) {

                node.setLeft(new BinaryNode<T>(data));

                this.size++;

            } else {

                insert(data, node.getLeft());

            }

        } else {

            if (node.getRight() == null) {

                node.setRight(new BinaryNode<T>(data));

                this.size++;

            } else {

                insert(data, node.getRight());

            }

        }

    }

    /**
     * This method checks if the root houses the specified data otherwise calls the
     * other find() method to traverse down the BST.
     * 
     * @param data The data to find in the BST.
     * @return The BinaryNode which contains the specified data or null if the root
     *         is empty or the data does not exist in the tree.
     */
    public BinaryNode<T> find(T data) {

        if (root == null) {

            return null;

        } else

            return find(data, root);

    }

    /**
     * This method locates the BinaryNode which houses the specified data.
     * 
     * @param data The data to find in the BST.
     * @param node The BinaryNode at which to start looking for the specified data
     *             by checking its left and right nodes.
     * @return The BinaryNode which contains the specified data if the data exists
     *         otherwise returns null.
     */
    public BinaryNode<T> find(T data, BinaryNode<T> node) {

        if (data == node.getData()) {

            return node;

        } else if (data.compareTo(node.getData()) < 0) {

            return (node.getLeft() == null) ? null : find(data, node.getLeft());

        } else {

            return (node.getRight() == null) ? null : find(data, node.getRight());

        }

    }

    /**
     * This method prints all the data of the whole tree to the standard output by
     * calling the other printAllData() method with root as the parameter.
     */
    public void printAllData() {

        printAllData(root);

    }

    /**
     * This method prints all the data of the whole tree to the standard output if
     * the root is the parameter otherwise a subtree from the BinaryNode specified,
     * traversing down the BST.
     * 
     * @param node The BinaryNode specified.
     */
    private void printAllData(BinaryNode<T> node) {

        if (root == null) {

            System.out.println("Sorry this Binary Tree is empty");

        }

        if (node == null) {

            return;

        } else {

            printAllData(node.getLeft());

            printAllData(node.getRight());

            node.printData();

        }

    }

    /**
     * This method returns the Binary Node containing the minimum value in the BST
     * Tree by checking if the root is null otherwise calling the other findMin()
     * method.
     * 
     * @return The Binary Node containing the minimum value in the BST tree.
     */

    public BinaryNode<T> findMin() {

        if (root.getLeft() == null) {

            return this.root;

        } else {

            return findMin(root.getLeft());

        }

    }

    /**
     * This method returns the Binary Node containing the minimum value in the BST
     * Tree.
     * 
     * @param node The Binary Node to check if it is the minimum.
     * @return The Binary Node containing the minimum value in the BST tree.
     */
    public BinaryNode<T> findMin(BinaryNode<T> node) {

        if (node.getLeft() == null) {

            return node;

        } else {

            return findMin(node.getLeft());

        }

    }

    /**
     * This method removes the Binary Node containing the specified data from the
     * AVL Tree.
     * 
     * @param data
     * @return
     */
    public BinaryNode<T> remove(T data) {

        if (this.root == null) {

            return this.root;

        }

        if (find(data) == null) {

            return null;

        }

        this.root.setData(remove(data, this.root).getData());

        return this.root;

    }

    /**
     * This method removes the Binary Node containing the specified data by
     * recursively checking each node and removing it if it matches the specified
     * data.
     * 
     * @param data The data to be removed.
     * @param node The node that is currently being checked.
     * @return The Binary Node that has just been checked or the Binary Node
     *         replacing the deleted Binary Node or null if the Binary Node to be
     *         deleted is a lead.
     */
    protected BinaryNode<T> remove(T data, BinaryNode<T> node) {

        if (node.getData().compareTo(data) > 0) {

            node.setLeft(remove(data, node.getLeft()));

        } else if (node.getData().compareTo(data) < 0) {

            node.setRight(remove(data, node.getRight()));

        } else {

            if (node.isLeaf()) {

                return null;

            } else if (node.getLeft() != null && node.getRight() == null) {

                return node.getLeft();

            } else if (node.getRight() != null && node.getLeft() == null) {

                return node.getRight();

            } else {

                BinaryNode<T> temp = new BinaryNode<>(findMin(node.getRight()).getData());

                remove(temp.getData(), node.getRight());

                node.setData(temp.getData());

            }

        }

        return node;

    }

    /**
     * This method merges two BSTs into one.
     * 
     * @param tree The tree to merge with.
     */
    public void merge(BinarySearchTree<T> tree) {
        TreeIterator<T> iter = new TreeIterator<>(tree);

        while (iter.hasNext()) {
            this.insert(iter.next().getData());
        }
    }

    /**
     * This method adds the contents from a List of the same type to the BST.
     * 
     * @param list The list to add.
     */
    public void addList(List<T> list) {
        ListIterator<T> iter = list.listIterator();

        while (iter.hasNext()) {
            insert(iter.next());
        }
    }

    /**
     * This method adds the contents from the BST into a List (can be of type
     * LinkedList, ArrayList, etc).
     * 
     * @param list The list to add the data to.
     * @return The list with all that data fron the BST.
     */
    public List<T> toList(List<T> list) {
        TreeIterator<T> iter = new TreeIterator<>(this);

        while (iter.hasNext()) {
            list.add(iter.next().getData());
        }

        return list;
    }

}