public class Node {
    boolean isOperator;
    Node leftKid;                               
    Node rightKid;
    int precedence;
    public Node () {
        leftKid = null;
        rightKid = null;
        precedence = 1;
    }
}
