package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.binaryfunctions.*;
import edu.austral.ingsis.math.unaryfunctions.*;
import edu.austral.ingsis.math.values.Number;
import edu.austral.ingsis.math.values.Variable;
import java.util.HashMap;
import org.junit.jupiter.api.Test;

public class ResolutionWithVariablesTest {

  /** Case 1 + x where x = 3 */
  @Test
  public void shouldResolveFunction1() {
    final HashMap<String, Double> variables = new HashMap<>();
    variables.put("x", 3d);
    final Double result = new Sum(new Number(1d), new Variable("x")).evaluate(variables);

    assertThat(result, equalTo(4d));
  }

  /** Case 12 / div where div = 4 */
  @Test
  public void shouldResolveFunction2() {
    final HashMap<String, Double> variables = new HashMap<>();
    variables.put("div", 4d);
    final Double result = new Divide(new Number(12d), new Variable("div")).evaluate(variables);

    assertThat(result, equalTo(3d));
  }

  /** Case (9 / x) * y where x = 3 and y = 4 */
  @Test
  public void shouldResolveFunction3() {
    final HashMap<String, Double> variables = new HashMap<>();
    variables.put("x", 3d);
    variables.put("y", 4d);
    final Double result =
        new Multiply(new Divide(new Number(9d), new Variable("x")), new Variable("y"))
            .evaluate(variables);

    assertThat(result, equalTo(12d));
  }

  /** Case (27 / a) ^ b where a = 9 and b = 3 */
  @Test
  public void shouldResolveFunction4() {
    final HashMap<String, Double> variables = new HashMap<>();
    variables.put("a", 9d);
    variables.put("b", 3d);
    final Double result =
        new Power(new Divide(new Number(27d), new Variable("a")), new Variable("b"))
            .evaluate(variables);

    assertThat(result, equalTo(27d));
  }

  /** Case z ^ (1/2) where z = 36 */
  @Test
  public void shouldResolveFunction5() {
    final HashMap<String, Double> variables = new HashMap<>();
    variables.put("z", 36d);
    final Double result = new Sqrt(new Variable("z")).evaluate(variables);

    assertThat(result, equalTo(6d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction6() {
    final HashMap<String, Double> variables = new HashMap<>();
    variables.put("value", 8d);
    final Double result =
        new Subtract(new Absolute(new Variable("value")), new Number(8d)).evaluate(variables);

    assertThat(result, equalTo(0d));
  }

  /** Case (5 - i) * 8 where i = 2 */
  @Test
  public void shouldResolveFunction8() {
    final HashMap<String, Double> variables = new HashMap<>();
    variables.put("i", 2d);
    final Double result =
        new Multiply(new Subtract(new Number(5d), new Variable("i")), new Number(8d))
            .evaluate(variables);

    assertThat(result, equalTo(24d));
  }
}
