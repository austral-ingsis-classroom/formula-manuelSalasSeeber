package edu.austral.ingsis.math;

import edu.austral.ingsis.math.visitors.Visitor;
import java.util.HashMap;

public interface Function {
  Double evaluate();

  Double evaluate(HashMap<String, Double> variables);

  void accept(Visitor visitor);
}
