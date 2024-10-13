import fr.demo.CalculatriceModel;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatriceModelTest {

    @Test
    public void testAddition() {
        CalculatriceModel model = new CalculatriceModel();
        BigDecimal result = model.addition(BigDecimal.valueOf(2), BigDecimal.valueOf(3));
        assertEquals(BigDecimal.valueOf(5), result, "L'addition de 2 + 3 devrait être 5");
    }

    @Test
    public void testSoustraction() {
        CalculatriceModel model = new CalculatriceModel();
        BigDecimal result = model.soustraction(BigDecimal.valueOf(5), BigDecimal.valueOf(3));
        assertEquals(BigDecimal.valueOf(2), result, "La soustraction de 5 - 3 devrait être 2");
    }

    @Test
    public void testMultiplication() {
        CalculatriceModel model = new CalculatriceModel();
        BigDecimal result = model.multiplication(BigDecimal.valueOf(2), BigDecimal.valueOf(3));
        assertEquals(BigDecimal.valueOf(6), result, "La multiplication de 2 * 3 devrait être 6");
    }

    @Test
    public void testDivision() {
        CalculatriceModel model = new CalculatriceModel();
        BigDecimal result = model.division(BigDecimal.valueOf(10), BigDecimal.valueOf(2));
        assertEquals(BigDecimal.valueOf(5).stripTrailingZeros(),
                result.stripTrailingZeros(), "La division de 10 par 2 devrait être 5");
    }

    @Test
    public void testDivisionParZero() {
        CalculatriceModel model = new CalculatriceModel();
        assertThrows(ArithmeticException.class, () -> {
            model.division(BigDecimal.valueOf(10), BigDecimal.valueOf(0));
        }, "Division par zéro devrait lancer une ArithmeticException");
    }

    @Test
    public void testPuissance() {
        CalculatriceModel model = new CalculatriceModel();
        BigDecimal result = model.puissance(BigDecimal.valueOf(2), BigDecimal.valueOf(3));
        assertEquals(BigDecimal.valueOf(8).stripTrailingZeros(),
                result.stripTrailingZeros(), "2 à la puissance 3 devrait être 8");
    }


    @Test
    public void testRacine() {
        CalculatriceModel model = new CalculatriceModel();
        BigDecimal result = model.racine(BigDecimal.valueOf(9));
        assertEquals(BigDecimal.valueOf(3).stripTrailingZeros(),
                result.stripTrailingZeros(), "La racine carrée de 9 devrait être 3");
    }

}
