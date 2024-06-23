package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.binaryfunctions.*;
import edu.austral.ingsis.math.unaryfunctions.Absolute;
import edu.austral.ingsis.math.values.Number;
import edu.austral.ingsis.math.values.Variable;
import edu.austral.ingsis.math.visitors.Printer;
import org.junit.jupiter.api.Test;

public class PrintTest {

  private Printer createPrinter() {
    return new Printer();
  }

  /** Case 1 + 6 */
  @Test
  public void shouldPrintFunction1() {
    final String expected = "(1.0 + 6.0)";
    final Printer printer = createPrinter();
    final Sum func = new Sum(new Number(1d), new Number(6d));
    printer.visit(func);
    final String result = printer.getResult();

    assertThat(result, equalTo(expected));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldPrintFunction2() {
    final String expected = "(12.0 / 2.0)";
    Printer printer = createPrinter();
    Divide func = new Divide(new Number(12d), new Number(2d));
    printer.visit(func);
    final String result = printer.getResult();

    assertThat(result, equalTo(expected));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldPrintFunction3() {
    final String expected = "((9.0 / 2.0) * 3.0)";
    Printer printer = createPrinter();
    Multiply func = new Multiply(new Divide(new Number(9d), new Number(2d)), new Number(3d));
    printer.visit(func);
    final String result = printer.getResult();

    assertThat(result, equalTo(expected));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldPrintFunction4() {
    final String expected = "((27.0 / 6.0) ^ 2.0)";
    Printer printer = createPrinter();
    Power func = new Power(new Divide(new Number(27d), new Number(6d)), new Number(2d));
    printer.visit(func);
    final String result = printer.getResult();

    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction6() {
    final String expected = "((|value|) - 8.0)";
    Printer printer = createPrinter();
    Subtract func = new Subtract(new Absolute(new Variable("value")), new Number(8d));
    printer.visit(func);
    final String result = printer.getResult();

    assertThat(result, equalTo(expected));
  }

  /** Case ((5 - i) * 8) */
  @Test
  public void shouldPrintFunction8() {
    final String expected = "((5.0 - i) * 8.0)";
    Printer printer = createPrinter();
    Multiply func = new Multiply(new Subtract(new Number(5d), new Variable("i")), new Number(8d));
    printer.visit(func);
    final String result = printer.getResult();

    assertThat(result, equalTo(expected));
  }
}
