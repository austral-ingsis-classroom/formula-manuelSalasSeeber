package edu.austral.ingsis.math.visitors;

import edu.austral.ingsis.math.binaryfunctions.*;
import edu.austral.ingsis.math.unaryfunctions.*;
import edu.austral.ingsis.math.unaryfunctions.Absolute;
import edu.austral.ingsis.math.values.*;
import edu.austral.ingsis.math.values.Number;


public interface Visitor {
    void visit(Sum sum);
    void visit(Subtract subtract);
    void visit(Divide divide);
    void visit(Multiply multiply);
    void visit(Number number);
    void visit(Variable variable);
    void visit(Absolute absolute);
    void visit(Power power);
    void visit(Sqrt sqrt);
}
