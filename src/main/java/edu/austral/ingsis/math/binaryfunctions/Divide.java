package edu.austral.ingsis.math.binaryfunctions;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.visitors.Visitor;

import java.util.HashMap;

public class Divide implements Function {
    private final Function denominator;
    private final Function numerator;

    public Divide(Function left, Function right) {
        this.denominator = left;
        this.numerator = right;
    }

    @Override
    public Double evaluate() {
        return denominator.evaluate() / numerator.evaluate();
    }

    @Override
    public Double evaluate(HashMap<String, Double> variables) {
        return denominator.evaluate(variables) / numerator.evaluate(variables);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Function getDenominator() {
        return this.denominator;
    }

    public Function getNumerator() {
        return this.numerator;
    }
}
