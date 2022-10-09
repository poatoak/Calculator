import java.lang.Integer;
public class Tree {
    public Node root;
    public Tree() {
        root = null;
    }
    public int calculator(OperatorNode n) {
        if (n.data == null) {
            return Integer.MIN_VALUE;
        }
        if (n.leftKid == null || n.rightKid == null) {
            return Integer.MIN_VALUE;
        }
        int leftValue;
        int rightValue;
        if (n.leftKid instanceof OperatorNode) {
            leftValue = calculator((OperatorNode) n.leftKid);
        } else {
            leftValue = ((NumberNode) n.leftKid).data;
        }
        if (n.rightKid instanceof OperatorNode) {
            rightValue = calculator((OperatorNode) n.rightKid);
        } else {
            rightValue = ((NumberNode) n.rightKid).data;
        }

        if (n.data.equals("+")) {
            return leftValue + rightValue;
        }
        if (n.data.equals("-")) {
            return leftValue - rightValue;
        }
        if (n.data.equals("*")) {
            return leftValue * rightValue;
        }
            return leftValue / rightValue;
    }
    public int calculator() {
        return calculator((OperatorNode) this.root);
    }
}
