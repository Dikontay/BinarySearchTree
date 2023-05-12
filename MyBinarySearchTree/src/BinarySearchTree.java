import java.util.Iterator;
import java.util.Stack;

public class BinarySearchTree <K extends Comparable<K>, V> implements Iterable<BinarySearchTree<K, V>.Node> {
    private Node root;
   public   class Node{
        public  K key;
        public V val;
        private int size=1;
        private Node left, right;
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
        int cmp = key.compareTo(node.key);
       if(cmp>0){
           node.right=put(node.right, key, val);
       } else node.left= put(node.left, key, val);

       node.size= sizeOfNode(node.left)+ sizeOfNode(node.right)+1 ;
      return node;
   }
   private int sizeOfNode(Node n){
       return n!=null? n.size : 0;
   }
   public int size(){
       return root.size;
   }
   public V get(K key){
       if(find(root,  key)==null){
           return null;
       }
      else  return find(root, key).val;
   }
   private Node find(Node n, K key){
       if(n==null){
           return null;
       }
       int cmp = key.compareTo(n.key);
       if(cmp==0){
           return n;
       }
       else if (cmp>0){
           return find(n.right, key);
       }else return find(n.left, key);

   }
   public void delete(K key){
        root = delete(root, key);
   }

   private Node delete(Node n, K key){
     if(n==null){
         return null;
     }else if(key.compareTo(n.key)>0){
         n.right = delete(n.right, key);
     }else if(key.compareTo(n.key)<0){
         n.left= delete(n.left, key);
     } else {
         //Once it finds the key we must consider 3 cases for deleting  a node
         //----------------------------------------
         //Case 1 if a node has no child
         if(n.left==null&n.right==null){
             n = null;
             return null;
         } //Case 2 If only one child
         else if(n.left==null){
             Node temp = n;
             n= n.right;
             temp = null;

         } else if(n.right==null){
             Node temp = n;
             n= n.left;
             temp = null;

         }// Case 3 if a node has both left and right child
         else {
             Node t= max(n.left);
             n.key=t.key;
             n.val=t.val;
            n.right=delete(n.right, t.key);
           n.left = t.left;
         }

     }
       n.size--;
       return n;
   }
    //maximum from left child of node
   private Node max(Node n){
       while(n.right!=null) {
           n = n.right;
       }
       return n;
   }

    //minimum from left child of node
   private Node minRight(Node n){
       while(n.left!=null){
           n=n.left;
       }
       return n;
   }
   public void output(){
       output(root);
   }
   private void output(Node n){
       if(n==null){
           return;
       }

       output(n.left);
       System.out.println("This is key: "+ n.key + " This is value : " + n.val);
       output(n.right);
   }

   public boolean isEmpty(){
       return root==null;
   }
    @Override
    public Iterator<Node> iterator() {

        return new InOrder();
    }

    public  class InOrder implements Iterator<Node> {
        Stack<Node> stack = new Stack<>();

        public InOrder(){

            pushLeft(root);
        }

        private void pushLeft(Node n){
            while(n!=null){
                stack.push(n);
                n = n.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public Node  next() {
            if(hasNext()){
                Node current = stack.peek();
                stack.pop();
               pushLeft(current.right);

                return current;
            }
            else return null;

        }


    }

}
