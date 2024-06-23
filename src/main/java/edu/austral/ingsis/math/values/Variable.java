package edu.austral.ingsis.math.values;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.visitors.Visitor;

import java.util.HashMap;

public class Variable implements Function {
    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public Double evaluate() {
        throw new UnsupportedOperationException("Variables must be evaluated with a map of values");
    }

    @Override
    public Double evaluate(HashMap<String, Double> variables) {
        Double value = variables.getOrDefault(name, null);
        if (value == null) {
            throw new IllegalArgumentException("Variable " + name + " not found in the map");
        }
        return value;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getName() {
        return name;
    }
}
