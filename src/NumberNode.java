public class NumberNode extends Node{
    double data;
    boolean isOperator = false;
    public NumberNode(double i){
        data = i;
        precedence = 1;
    }
    public String toString() {
        return String.valueOf(this.data);
    }
    
}

