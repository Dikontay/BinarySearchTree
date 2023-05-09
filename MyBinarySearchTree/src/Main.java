public class Main {
    public static void main(String[] args) {
      BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
      bst.put(3, "Yernazar");
      bst.put(7, "Yernazar");
      bst.put(5, "Yernazar");
      bst.put(8, "Yernazar");
      bst.put(9, "Yernazar");
      bst.put(10, "Yernazar");
      bst.put(2, "Yernazar");
      bst.put(1, "Yernazar");
      bst.put(4, "Yernazar");
      System.out.println(bst.get(1));


    }
}