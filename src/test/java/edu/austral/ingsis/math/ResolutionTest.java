package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.binaryfunctions.*;
import edu.austral.ingsis.math.unaryfunctions.*;
import edu.austral.ingsis.math.unaryfunctions.Absolute;
import edu.austral.ingsis.math.values.Number;
import org.junit.jupiter.api.Test;

public class ResolutionTest {

  /** Case 1 + 6 */
  @Test
  public void shouldResolveSimpleFunction1() {
    final Double result = new Sum(new Number(1d), new Number(6d)).evaluate();

    assertThat(result, equalTo(7d));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldResolveSimpleFunction2() {
    final Double result = new Divide(new Number(12d), new Number(2d)).evaluate();

    assertThat(result, equalTo(6d));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldResolveSimpleFunction3() {
    final Double result =
        new Multiply(new Divide(new Number(9d), new Number(2d)), new Number(3d)).evaluate();

    assertThat(result, equalTo(13.5d));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldResolveSimpleFunction4() {
    final Double result =
        new Power(new Divide(new Number(27d), new Number(6d)), new Number(2d)).evaluate();

    assertThat(result, equalTo(20.25d));
  }

  /** Case 36 ^ (1/2) */
  @Test
  public void shouldResolveSimpleFunction5() {
    final Double result = new Sqrt(new Number(36d)).evaluate();

    assertThat(result, equalTo(6d));
  }

  /** Case |136| */
  @Test
  public void shouldResolveSimpleFunction6() {
    final Double result = new Absolute(new Number(136d)).evaluate();

    assertThat(result, equalTo(136d));
  }

  /** Case |-136| */
  @Test
  public void shouldResolveSimpleFunction7() {
    final Double result = new Absolute(new Number(-136d)).evaluate();

    assertThat(result, equalTo(136d));
  }

  /** Case (5 - 5) * 8 */
  @Test
  public void shouldResolveSimpleFunction8() {
    final Double result =
        new Multiply(new Subtract(new Number(5d), new Number(5d)), new Number(8d)).evaluate();

    assertThat(result, equalTo(0d));
  }
}
