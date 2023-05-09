import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class BinarySearchTree <K extends Comparable<K>, V>{
    private Node root;
   private class Node{
        private K key;
        private V val;
        private Node left, right;
        public int size;
        public Node(K key, V value){
            this.key = key;
            this.val = value;
            size = 1;
        }
   }

   public void put(K key, V val){
        root=put(root, key,val);
   }
   private Node put(Node node, K key, V val){
       if(node == null){
           return new Node(key, val);
       }
        int cmp = key.compareTo(node.key);
       if(cmp>0){
           node.right=put(node.right, key, val);
       } else node.left= put(node.left, key, val);

       node.size= isNotNull(node.left)+isNotNull(node.right)+1 ;
      return node;
   }
   private int isNotNull(Node n){
       return n!=null? n.size : 0;
   }
   public V get(K key){
       return find(root, key);
   }
   private V find(Node n, K key){
       if(n==null){
           return null;
       }
       int cmp = n.key.compareTo(key);
       if(cmp==0){
           return n.val;
       }
       else if (cmp>0){
           return find(n.right, key);
       }else return find(n.left, key);

   }
   public void delete(K key){

   }
   public Iterable<K> iterator(){
       return null;
   }
   public boolean isEmpty(){
       return root==null;
   }
   private class InOrder implements Iterable<K>{

       @Override
       public Iterator<K> iterator() {
           return null;
       }

       @Override
       public void forEach(Consumer<? super K> action) {
           Iterable.super.forEach(action);
       }

       @Override
       public Spliterator<K> spliterator() {
           return Iterable.super.spliterator();
       }
   }
}
