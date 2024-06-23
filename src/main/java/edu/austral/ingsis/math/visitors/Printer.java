package edu.austral.ingsis.math.visitors;

import edu.austral.ingsis.math.binaryfunctions.*;
import edu.austral.ingsis.math.unaryfunctions.Module;
import edu.austral.ingsis.math.unaryfunctions.Sqrt;
import edu.austral.ingsis.math.values.Number;
import edu.austral.ingsis.math.values.Variable;

public class Printer implements Visitor{

    private String result = "";

    public String getResult() {
        return result;
    }

    @Override
    public void visit(Sum sum) {
        sum.getLeft().accept(this);
        result += " + ";
        sum.getRight().accept(this);
    }

    @Override
    public void visit(Subtract subtract) {
        subtract.getLeft().accept(this);
        result += " - ";
        subtract.getRight().accept(this);
    }

    @Override
    public void visit(Divide divide) {
        divide.getDenominator().accept(this);
        result += " / ";
        divide.getNumerator().accept(this);
    }

    @Override
    public void visit(Multiply multiply) {
        multiply.getLeft().accept(this);
        result += " * ";
        multiply.getRight().accept(this);
    }

    @Override
    public void visit(Number number) {
        result += number.evaluate();
    }

    @Override
    public void visit(Variable variable) {
        result += variable.getName();
    }

    @Override
    public void visit(Module module) {
        result += "mod(";
        module.getValue().accept(this);
        result += ")";
    }

    @Override
    public void visit(Power power) {
        power.getBase().accept(this);
        result += " ^ ";
        power.getExponent().accept(this);
    }

    @Override
    public void visit(Sqrt sqrt) {
        result += "sqrt(";
        sqrt.getValue().accept(this);
        result += ")";
    }
}
