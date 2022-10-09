public class OperatorNode extends Node {
    String data;
    public OperatorNode(String str){
        data = str;
    }
    public void kidAdder(Node n) {
        if (leftKid == null) {
            leftKid = n;
        } else {
            rightKid = n;
        }
    }
}
