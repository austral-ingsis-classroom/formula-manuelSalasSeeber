package edu.austral.ingsis.math.unaryfunctions;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.visitors.Visitor;

import java.util.HashMap;

public class Module implements Function {
    private final Function value;

    public Module(Function value) {
        this.value = value;
    }
    @Override
    public Double evaluate() {
        return Math.abs(value.evaluate());
    }

    @Override
    public Double evaluate(HashMap<String, Double> variables) {
        return Math.abs(value.evaluate(variables));
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Function getValue() {
        return this.value;
    }
}
