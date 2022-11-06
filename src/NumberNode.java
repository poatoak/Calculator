public class NumberNode extends Node{
    double data;
    public NumberNode(double i){
        data = i;
        precedence = 1;
    }
    public String toString() {
        return this.data + " kids: "  + (this.leftKid == null? "no lk": this.leftKid.toString()) + "," + (this.rightKid == null? "no rk":this.rightKid.toString());
    }
}

