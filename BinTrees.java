public class BinTrees {

    private static class Node {
        private int value;
        private Node left;
        private Node right;
        
        Node(int value) {
            this.value = value;
            left = right = null;
        }
        
        Node addLeft(int value) {
            left = new Node(value);
            return left;
        }
        
        Node addRight(int value) {
            right = new Node(value);
            return right;
        }
        
        
        void printPreorder() {
            System.out.print(value + " ");
            
            if (left != null) {
                left.printPreorder();
            }
            
            if (right != null) {
                right.printPreorder();
            }
        }
        
        void printInorder() {
            if (left != null) {
                left.printInorder();
            }
            
            System.out.print(value + " ");
            
            if (right != null) {
                right.printInorder();
            }
        }
        
        void printPostorder() {
            if (left != null) {
                left.printPostorder();
            }
            
            if (right != null) {
                right.printPostorder();
            }
            
            System.out.print(value + " ");
        }
        
    }
    
    static Node head;
    public static void main(String[] args) {
        head = new Node(0);
        Node firstChild = head.addLeft(4);
        Node secondChild = head.addRight(3);
        Node firstGrandchild = firstChild.addLeft(11);
        Node secondGrandchild = secondChild.addLeft(9);
        Node thirdGrandchild = secondChild.addRight(8);
        head.printPreorder();
        System.out.println();
        head.printInorder();
        System.out.println();
        head.printPostorder();
        System.out.println();
    }
}
