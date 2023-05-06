public class BinarySearchTree <T extends Comparable<T>>{
    private static class MyNode<T extends Comparable<T>>{
        T data;
        MyNode<T> left;
        MyNode<T> right;

        int size;
        public MyNode(T data,int size){
            this.data = data;
            this.size = size;
        }
    }
    MyNode <T> root ;
    private int size;
    public  boolean isEmpty(){
        return root == null;
    }
    public void insert(T value){
        root = insertRecursive(value, root);
    }
    private MyNode<T> insertRecursive(T value, MyNode<T>  current){
        if(current == null){
            return new MyNode<>(value, 1);
        }
        if(current.data.compareTo(value)>0){
            current.right= insertRecursive(value, current.right);
        }else  current.left= insertRecursive(value, current.left);
        current.size= current.left.size+current.right.size+1;
        return current;
    }

}
