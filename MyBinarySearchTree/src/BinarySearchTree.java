public class BinarySearchTree <K extends Comparable<K>, V>{
    private Node root;
   private class Node{
        private K key;
        private V val;
        private Node left, right;
        public int size = 1;
        public Node(K key, V value){
            this.key = key;
            this.val = value;
        }
   }

   public void put(K key, V val){
        root=put(root, key,val);
   }
   private Node put(Node node, K key, V val){
       if(node == null){
           return new Node(key, val);
       }
       if(key.compareTo(node.key)>0){
           node.right=put(node.right, key, val);
       } else node.left= put(node.left, key, val);



      node.size= isNotNull(node.left)+isNotNull(node.right)+1 ;
      return node;
   }
   private int isNotNull(Node n){
       return n!=null? 1 : 0;
   }
   public V get(K key){

       return find(root, key);
   }
   private V find(Node n, K key){
       if(n==null){
           return null;
       }
       if(n.key.compareTo(key)==0){
           return n.val;
       }
       if(n.key.compareTo(key)>0){
          return find(n.right, key);
       }else return find(n.left, key);
   }
   public void delete(K key){

   }
   public Iterable<K> iterator(){
       return null;
   }
}
