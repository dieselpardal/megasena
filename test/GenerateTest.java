import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class GenerateTest {
    double [] price = {3.5, 24.5, 98.0, 294.0, 735.0, 1617.0, 3234.0, 6006.0, 10510.5, 17517.5};
    Generate generate = new Generate(60, 6, "resultadoMegaSena.txt", price);

    @Test
    public void testGeneratorSetTenSix() throws IOException {
        this.generate.setTenPerVolante(6);
        this.generate.setVolant(1);
        this.generate.gerators();
        assertEquals(this.generate.result().length(), 23);
    }

    @Test
    public void testGeneratorSetTenNono() throws IOException {
        this.generate.setTenPerVolante(9);
        this.generate.setVolant(1);
        this.generate.gerators();
        assertEquals(this.generate.result().length(), 32);
    }

    @Test
    public void testGeneratorSetVolanteThree() throws IOException {
        this.generate.setTenPerVolante(6);
        this.generate.setVolant(3);
        this.generate.gerators();
        assertEquals(this.generate.result().length(), 69);
    }
}
