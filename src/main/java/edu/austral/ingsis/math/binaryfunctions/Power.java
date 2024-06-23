package edu.austral.ingsis.math.binaryfunctions;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.visitors.Visitor;
import java.util.HashMap;

public class Power implements Function {
  private final Function base;
  private final Function exponent;

  public Power(Function base, Function exponent) {
    this.base = base;
    this.exponent = exponent;
  }

  @Override
  public Double evaluate() {
    return Math.pow(base.evaluate(), exponent.evaluate());
  }

  @Override
  public Double evaluate(HashMap<String, Double> variables) {
    return Math.pow(base.evaluate(variables), exponent.evaluate(variables));
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  public Function getBase() {
    return this.base;
  }

  public Function getExponent() {
    return this.exponent;
  }
}
