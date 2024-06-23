package edu.austral.ingsis.math;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

import edu.austral.ingsis.math.binaryfunctions.*;
import edu.austral.ingsis.math.unaryfunctions.*;
import edu.austral.ingsis.math.values.Number;
import edu.austral.ingsis.math.values.Variable;
import edu.austral.ingsis.math.visitors.VariableCollector;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ListVariablesTest {

  private VariableCollector createVariableCollector() {
    return new VariableCollector();
  }

  /** Case 1 + 6 */
  @Test
  public void shouldListVariablesFunction1() {
    VariableCollector variableCollector = createVariableCollector();
    Sum sum = new Sum(new Number(1d), new Number(6d));
    variableCollector.visit(sum);
    final List<String> result = variableCollector.getVariables();

    assertThat(result, empty());
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    VariableCollector variableCollector = createVariableCollector();
    Divide divide = new Divide(new Number(12d), new Variable("div"));
    variableCollector.visit(divide);
    final List<String> result = variableCollector.getVariables();

    assertThat(result, containsInAnyOrder("div"));
  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    VariableCollector variableCollector = createVariableCollector();
    Multiply func = new Multiply(new Divide(new Number(9d), new Variable("x")), new Variable("y"));
    variableCollector.visit(func);
    final List<String> result = variableCollector.getVariables();

    assertThat(result, containsInAnyOrder("x", "y"));
  }

  /** Case (27 / a) ^ b */
  @Test
  public void shouldListVariablesFunction4() {
    VariableCollector variableCollector = createVariableCollector();
    Power func = new Power(new Divide(new Number(27d), new Variable("a")), new Variable("b"));
    variableCollector.visit(func);
    final List<String> result = variableCollector.getVariables();

    assertThat(result, containsInAnyOrder("a", "b"));
  }

  /** Case z ^ (1/2) */
  @Test
  public void shouldListVariablesFunction5() {
    VariableCollector variableCollector = createVariableCollector();
    Sqrt func = new Sqrt(new Variable("z"));
    variableCollector.visit(func);
    final List<String> result = variableCollector.getVariables();

    assertThat(result, containsInAnyOrder("z"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction6() {
    VariableCollector variableCollector = createVariableCollector();
    Subtract func = new Subtract(new Absolute(new Variable("value")), new Number(8d));
    variableCollector.visit(func);
    final List<String> result = variableCollector.getVariables();

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldListVariablesFunction8() {
    VariableCollector variableCollector = createVariableCollector();
    Multiply func = new Multiply(new Subtract(new Number(5d), new Variable("i")), new Number(8d));
    variableCollector.visit(func);
    final List<String> result = variableCollector.getVariables();

    assertThat(result, containsInAnyOrder("i"));
  }
}
