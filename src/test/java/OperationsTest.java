
import model.Operations;
import model.Polynomial;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class OperationsTest {

    @Test
    public void addTest(){
        Polynomial polynomial1 = new Polynomial();
        Polynomial polynomial2 = new Polynomial();
        polynomial1.create("2x^3-1.3x^2-1");
        polynomial2.create("3x^4-x^3+x+2.4");
        Polynomial actualResult = Operations.add(polynomial1, polynomial2);
        Polynomial expectedResult = new Polynomial();
        expectedResult.create("3x^4+x^3-1.3x^2+x+1.4");
        assertEquals(expectedResult.toString(), actualResult.toString());
    }

    @Test
    public void substractTest(){
        Polynomial polynomial1 = new Polynomial();
        Polynomial polynomial2 = new Polynomial();
        polynomial1.create("2x^3-1.3x^2-1");
        polynomial2.create("3x^4-x^3+x+2.4");
        Polynomial actualResult = Operations.substract(polynomial1, polynomial2);
        Polynomial expectedResult = new Polynomial();
        expectedResult.create("-3x^4+3x^3-1.3x^2-x-3.4");
        assertEquals(expectedResult.toString(), actualResult.toString());
    }

    @Test
    public void multiplyTest(){
        Polynomial polynomial1 = new Polynomial();
        Polynomial polynomial2 = new Polynomial();
        polynomial1.create("2x^3-1.3x^2-1");
        polynomial2.create("3x^4-x^3+x+2.4");
        Polynomial actualResult = Operations.multiply(polynomial1, polynomial2);
        Polynomial expectedResult = new Polynomial();
        expectedResult.create("6x^7-5.9x^6+1.3x^5-x^4+4.5x^3-3.12x^2-x-2.4");
        assertEquals(expectedResult.toString(), actualResult.toString());
    }

    @Test
    public void divideTest(){
        Polynomial polynomial1 = new Polynomial();
        Polynomial polynomial2 = new Polynomial();
        polynomial1.create("2x^3-1.3x^2-1");
        polynomial2.create("3x^4-x^3+x+2.4");
        Polynomial actualResult = Operations.multiply(polynomial1, polynomial2);
        Polynomial expectedResult = new Polynomial();
        expectedResult.create("6x^7-5.9x^6+1.3x^5-x^4+4.5x^3-3.12x^2-x-2.4");
        assertEquals(expectedResult.toString(), actualResult.toString());
    }

    @Test
    public void deriveTest(){
        Polynomial polynomial1 = new Polynomial();
        polynomial1.create("3x^4-x^3+x+2.4");
        Polynomial actualResult = Operations.derive(polynomial1);
        Polynomial expectedResult = new Polynomial();
        expectedResult.create("12x^3-3x^2+1");
        assertEquals(expectedResult.toString(), actualResult.toString());
    }

    @Test
    public void integrateTest()
    {
        Polynomial polynomial1 = new Polynomial();
        polynomial1.create("3x^4-x^3+x+2.4");
        Polynomial actualResult = Operations.integrate(polynomial1);
        Polynomial expectedResult = new Polynomial();
        expectedResult.create("0.6x^5-0.25x^4+0.5x^2+2.4x");
        assertEquals(expectedResult.toString(), actualResult.toString());
    }
}
