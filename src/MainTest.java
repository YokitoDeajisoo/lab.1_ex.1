import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class MainTest {

    private Main program;

    @BeforeEach
    void setUp() {
        program = new Main();
    }

    @Test
    void testFindMinAbsIndex() {
        int[] array = {50, -20, 5, -3, 15};
        assertEquals(3, program.findMinAbsIndex(array));
    }

    @Test
    void testSumBetweenPositive() {
        int[] array = {-1, 10, -5, -3, 8, 20, -15};
        assertEquals(0, program.sumBetweenPositive(array));
    }

    @Test
    void testSumBetweenPositiveException() {
        int[] array = {-5, 10, -2, -8};
        assertThrows(IllegalArgumentException.class, () -> program.sumBetweenPositive(array));
    }
}