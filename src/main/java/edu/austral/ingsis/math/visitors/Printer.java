package edu.austral.ingsis.math.visitors;

import edu.austral.ingsis.math.binaryfunctions.*;
import edu.austral.ingsis.math.unaryfunctions.Absolute;
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
        result += "(";
        sum.getLeft().accept(this);
        result += " + ";
        sum.getRight().accept(this);
        result += ")";
    }

    @Override
    public void visit(Subtract subtract) {
        result += "(";
        subtract.getLeft().accept(this);
        result += " - ";
        subtract.getRight().accept(this);
        result += ")";
    }

    @Override
    public void visit(Divide divide) {
        result += "(";
        divide.getDenominator().accept(this);
        result += " / ";
        divide.getNumerator().accept(this);
        result += ")";
    }

    @Override
    public void visit(Multiply multiply) {
        result += "(";
        multiply.getLeft().accept(this);
        result += " * ";
        multiply.getRight().accept(this);
        result += ")";
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
    public void visit(Absolute absolute) {
        result += "(";
        result += "|";
        absolute.getValue().accept(this);
        result += "|";
        result += ")";
    }

    @Override
    public void visit(Power power) {
        result += "(";
        power.getBase().accept(this);
        result += " ^ ";
        power.getExponent().accept(this);
        result += ")";
    }

    @Override
    public void visit(Sqrt sqrt) {
        result += "(";
        result += "sqrt(";
        sqrt.getValue().accept(this);
        result += ")";
        result += ")";
    }
}
