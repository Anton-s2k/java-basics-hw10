import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ExampleExceptionTest {

  /**
   * Test data for positive test.
   *
   * @return test data array
   */
  @DataProvider(name = "data")
  public static Object[][] data() {
    return new Object[][]{
        {2, 2, 4},
        {2, 3, 6},
            {0, 0, 0}, //my test
            {100, 200, 20000}, //my test

    };
  }

  /**
   * Test data for exception test.
   *
   * @return test data array
   */
  @DataProvider(name = "negativeData")
  public static Object[][] negativeData() {
    return new Object[][]{
        {-2, 2},
        {2, -2},
            {-1, -2}, //my test
            {-3, -4} //my test

    };
  }

  @Test(dataProvider = "data")
  public void testRectangleArea(int a, int b, int c) {
    assertEquals(ExampleException.rectangleArea(a,b),c);
  }


  @Test(dataProvider = "negativeData", expectedExceptions = { IllegalArgumentException.class },
          expectedExceptionsMessageRegExp = "input value is below zero!")
  public void testRectangleAreaNegative(int a, int b) {
    ExampleException.rectangleArea(a,b);
  }
}