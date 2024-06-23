package edu.austral.ingsis.math.binaryfunctions;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.visitors.Visitor;

import java.util.HashMap;

public class Subtract implements Function {
    private final Function left;
    private final Function right;

    public Subtract(Function left, Function right) {
        this.left = left;
        this.right = right;
    }
    @Override
    public Double evaluate() {
        return left.evaluate() - right.evaluate();
    }

    @Override
    public Double evaluate(HashMap<String, Double> variables) {
        return left.evaluate(variables) - right.evaluate(variables);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Function getLeft() {
        return this.left;
    }

    public Function getRight() {
        return this.right;
    }
}
