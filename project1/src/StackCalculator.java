import java.util.Stack;

public class StackCalculator {

    private Stack<Double> stack = new Stack<>();

    public void push(double value) {
        stack.push(value);
    }

    public double pop() {
        return stack.pop();
    }

    public double add() {
        double op1 = this.pop();
        double op2 = this.pop();
        double result = op1 + op2;
        this.push(result);
        return result;
    }

    public double subtract() {
        double op1 = this.pop();
        double op2 = this.pop();
        double result = op1 - op2;
        this.push(result);
        return result;
    }

    public double multiply() {
        double op1 = this.pop();
        double op2 = this.pop();
        double result = op1 * op2;
        this.push(result);
        return result;
    }

    public double divide() {
        double op1 = this.pop();
        double op2 = this.pop();
        double result = op2 / op1;
        this.push(result);
        return result;
    }

    public void clear() {
        stack.clear();
    }

    public Double[] getValues() {
        Double[] array = new Double[stack.size()];
        return stack.toArray(array);
    }

    public int size() {
        return stack.size();
    }
}