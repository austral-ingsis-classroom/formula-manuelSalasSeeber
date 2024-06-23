package edu.austral.ingsis.math.visitors;

import edu.austral.ingsis.math.binaryfunctions.*;
import edu.austral.ingsis.math.unaryfunctions.Absolute;
import edu.austral.ingsis.math.unaryfunctions.Sqrt;
import edu.austral.ingsis.math.values.Number;
import edu.austral.ingsis.math.values.Variable;

import java.util.HashSet;

public class VariableCollector implements Visitor{

    private final HashSet<String> variables;

    public VariableCollector() {
        this.variables = new HashSet<>();
    }

    @Override
    public void visit(Sum sum) {
        sum.getLeft().accept(this);
        sum.getRight().accept(this);
    }

    @Override
    public void visit(Subtract subtract) {
        subtract.getLeft().accept(this);
        subtract.getRight().accept(this);
    }

    @Override
    public void visit(Divide divide) {
        divide.getDenominator().accept(this);
        divide.getNumerator().accept(this);
    }

    @Override
    public void visit(Multiply multiply) {
        multiply.getLeft().accept(this);
        multiply.getRight().accept(this);
    }

    @Override
    public void visit(Number number) {

    }

    @Override
    public void visit(Variable variable) {
        variables.add(variable.getName());
    }

    @Override
    public void visit(Absolute absolute) {
        absolute.getValue().accept(this);
    }

    @Override
    public void visit(Power power) {
        power.getBase().accept(this);
        power.getExponent().accept(this);
    }

    @Override
    public void visit(Sqrt sqrt) {
        sqrt.getValue().accept(this);
    }

    public HashSet<String> getVariables() {
        return variables;
    }
}
