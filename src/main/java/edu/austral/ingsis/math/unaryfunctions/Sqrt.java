package edu.austral.ingsis.math.unaryfunctions;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.visitors.Visitor;
import java.util.HashMap;

public class Sqrt implements Function {
  private final Function value;

  public Sqrt(Function value) {
    this.value = value;
  }

  @Override
  public Double evaluate() {
    return Math.sqrt(value.evaluate());
  }

  @Override
  public Double evaluate(HashMap<String, Double> variables) {
    return Math.sqrt(value.evaluate(variables));
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  public Function getValue() {
    return this.value;
  }
}
