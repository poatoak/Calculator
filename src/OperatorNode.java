public class OperatorNode extends Node {
    String data;
    public OperatorNode(String str){
        data = str;
        String plusOrMinus = "+-";
        if (plusOrMinus.contains(str)) {
            precedence = 1;
        } else {
            precedence = 2;
        }
    }
    public void kidAdder(Node n) {
        if (leftKid == null) {
            leftKid = n;
        } else {
            rightKid = n;
        }
    }
    public String toString() {
        return this.data + " kids: "  + (this.leftKid == null? "no lk": this.leftKid.toString()) + "," + (this.rightKid == null? "no rk":this.rightKid.toString());
    }
}
