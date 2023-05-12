import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
      BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
      bst.put(3, "Yernazar");
      bst.put(7, "Dilnaz");
      bst.put(5, "Sabina");
      bst.put(8, "Sultan");
      bst.put(9, "Aisultan");
      bst.put(10, "Madi");
      bst.put(2, "Ruslan");
      bst.put(1, "Rulan");
      bst.put(4, "Adel");
      bst.delete(4);
      System.out.println("This is size "+ bst.size());
      for (var n : bst ) System.out.println(n.key+" "+n.val);


    }
}