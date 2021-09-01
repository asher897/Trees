import java.util.*;

public class BinaryTest {

    public static void main(String[] args) {

        int[] data = { 4, 6, 23, 78, 8, 10, 63, 54, 76, 2, 43 };

        int[] data_two = { 53, 41, 6, 34, 21, 85, 67, 4, 17, 13 };

        BinarySearchTree<Integer> tree_one = new BinarySearchTree<>();

        for (Integer i : data) {

            tree_one.insert(i);

        }

        BinarySearchTree<Integer> tree_two = new BinarySearchTree<>();

        for (Integer i : data_two) {

            tree_two.insert(i);

        }

        // tree_one.printAllData();
        // System.out.println("Done");

        // tree_two.printAllData();
        // System.out.println("Done2");

        tree_one.merge(tree_two);

        List<Integer> list = new ArrayList<>();
        tree_one.toList(list);

        for (Integer i : list) {
            System.out.println(i);
        }
        System.out.println("Done");

        tree_one.printAllData();
        System.out.println("Done");

        // tree.remove(9);

        // // System.out.println("The min: " + tree.findMin().getData());
        // tree.remove(8);

        // tree.printAllData();

        // System.out.println("Done");

        // tree = new AVLTree<>();

        // for (Integer i : data) {

        // tree.insert(i);

        // }

        // tree.printAllData();
        // System.out.println("Done");

        // tree.remove(63);
        // tree.remove(78);

        // // System.out.println("Root: " + tree.getRoot().getData());

        // tree.printAllData();

        // System.out.println("Done");

    }

}
