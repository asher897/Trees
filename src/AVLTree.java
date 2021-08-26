/**
 * This class defines an AVL Tree and makes use of the BinaryNode<T> class and
 * uses inheritance to extend the BinarySearchTree<T> class.
 * 
 * @author Aaron Sher
 * @since 20-08-2021
 */

public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T> {

    /**
     * Construcotr of the AVLTree class.
     * 
     * @param node A Binary Node which is set to the root of the tree by use of the
     *             super() method calling the BST constructor.
     */
    public AVLTree(BinaryNode<T> node) {

        super(node);

    }

    /**
     * No-argument constructor which sets the root to null and makes use of the
     * super() method to call the parent class' no-argument constructor.
     */
    public AVLTree() {

        super();

    }

    /**
     * This method calculates the balance factor of a Binary Node. The balance
     * factor is the difference in height between the left and right subtrees. A
     * positive result implies the left subtree is greater and a negative implies
     * the right is greater. The result will help determine whether the AVL Tree
     * will need to be balanced.
     * 
     * @param node The Binary Node at which to calculate the balance factor.
     * @return The balance factor as an int value.
     */
    public int balanceFactor(BinaryNode<T> node) {

        if (node.getLeft() == null) {

            if (node.getRight() == null) {

                return 0;

            } else {

                return node.getRight().getHeight() * -1;

            }

        } else if (node.getRight() == null) {

            return node.getLeft().getHeight();

        } else {

            return (node.getLeft().getHeight() - node.getRight().getHeight());

        }

    }

    /**
     * This method performs a rotations on the AVL Tree (or subtree) using the right
     * child of the specified Binary Node (root of the tree or subtree).
     * 
     * @param parent The root Binary Node of the tree (or subtree) that needs to be
     *               balanced.
     * @return The new root of the tree or subtree.
     */
    public BinaryNode<T> rotateWithRightChild(BinaryNode<T> parent) {

        BinaryNode<T> child = parent.getRight();

        parent.setRight(child.getLeft());

        child.setLeft(parent);

        parent.setHeight();

        child.setHeight();

        if (parent == this.root) {

            root = child;

        }

        return child;

    }

    /**
     * This method performs a rotations on the AVL Tree (or subtree) using the left
     * child of the specified Binary Node (root of the tree or subtree).
     * 
     * @param parent The root Binary Node of the tree (or subtree) that needs to be
     *               balanced.
     * @return The new root of the tree or subtree.
     */
    public BinaryNode<T> rotateWithLeftChild(BinaryNode<T> parent) {

        BinaryNode<T> child = parent.getLeft();

        parent.setLeft(child.getRight());

        child.setRight(parent);

        parent.setHeight();

        child.setHeight();

        if (parent == this.root) {

            root = child;

        }

        return child;

    }

    /**
     * This method determines if the AVL Tree (or subtree) needs to be balanced. It
     * then balances it if need be by making use of the rotateWithRightChild() and
     * rotateWithLeftChild() methods. Double rotations are performed where
     * necessary.
     * 
     * @param node The root of the AVL Tree or subtree that is being balanced.
     */
    public BinaryNode<T> balance(BinaryNode<T> node) {

        int balance = balanceFactor(node);

        if (Math.abs(balance) >= 2) {

            if (balance > 0) {

                if (balanceFactor(node.getLeft()) >= 0) {

                    return rotateWithLeftChild(node);

                } else {

                    node.setLeft(rotateWithRightChild(node.getLeft()));

                    return rotateWithLeftChild(node);

                }

            } else {

                if (balanceFactor(node.getRight()) < 0) {

                    return rotateWithRightChild(node);

                } else {

                    node.setRight(rotateWithLeftChild(node.getRight()));

                    return rotateWithRightChild(node);

                }

            }

        }

        return node;

    }

    /**
     * An override of the insert(T data) method in the BST parent class. It inserts
     * new data into the tree by placing it into a new Binary Node. If the root is
     * null this becomes the root otherwise the other insert() method is called.
     * 
     * @param data The data to be inserted into the tree.
     */
    public void insert(T data) {

        if (this.root == null) {

            this.root = new BinaryNode<T>(data);

        } else {

            this.root = insert(this.root, data);

        }

    }

    /**
     * This method inserts data into the AVL Tree if the root if the tree is not
     * null. It is called by the public insert() method. It inserts the data by
     * recursively traversing the AVL Tree and comparing the data to the relevant
     * Binary Nodes. The height of the Binary Node being compared is reset.
     * 
     * @param node The Binary Node that is compared to the data to be inserted.
     * @param data The data to be inserted.
     */
    private BinaryNode<T> insert(BinaryNode<T> node, T data) {

        if (data.compareTo(node.getData()) <= 0) {

            if (node.getLeft() == null) {

                node.setLeft(new BinaryNode<T>(data));

            } else {

                node.setLeft(insert(node.getLeft(), data));

                node.setHeight();

                return balance(node);

            }

        } else {

            if (node.getRight() == null) {

                node.setRight(new BinaryNode<T>(data));

            } else {

                node.setRight(insert(node.getRight(), data));

                node.setHeight();

                return balance(node);

            }

        }

        node.setHeight();

        return node;

    }

    /**
     * An override of the remove() method in the BST class. This method removes the
     * Binary Node containing the specified data from the AVL Tree.
     * 
     * @param data The data to be removed.
     * @return The root of the AVL Tree or null if it does not exist in the tree.
     */
    public BinaryNode<T> remove(T data) {

        if (this.root == null || find(data) == null) {

            return null;

        }

        this.root.setData(remove(data, this.root).getData());

        this.root.setHeight();

        return this.root;

    }

    /**
     * An override of the remove() method in the BST class. This method removes the
     * Binary Node containing the specified data by recursively checking each node
     * and removing it if it matches the specified data. It then balances each node
     * where necessary.
     * 
     * @param data The data to be removed.
     * @param node The node that is currently being checked.
     * 
     * @return The Binary Node that has just been checked or the Binary Node
     *         replacing the deleted Binary Node or null if the Binary Node to be
     *         deleted is a lead.
     */
    protected BinaryNode<T> remove(T data, BinaryNode<T> node) {
        if (node.getData().compareTo(data) > 0) {

            node.setLeft(remove(data, node.getLeft()));
            node.setHeight();

        } else if (node.getData().compareTo(data) < 0) {

            node.setRight(remove(data, node.getRight()));
            node.setHeight();

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

                node.setHeight();

            }
        }
        node.setHeight();

        return balance(node);

    }

}