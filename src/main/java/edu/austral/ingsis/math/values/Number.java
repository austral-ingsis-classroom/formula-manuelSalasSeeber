package edu.austral.ingsis.math.values;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.visitors.Visitor;

import java.util.HashMap;

public class Number implements Function {
    private final Double value;

    public Number(Double value) {
        this.value = value;
    }

    @Override
    public Double evaluate() {
        return value;
    }

    @Override
    public Double evaluate(HashMap<String, Double> variables) {
        return value;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
