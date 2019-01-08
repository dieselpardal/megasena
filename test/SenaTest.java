import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class SenaTest {

    @Test
    public void testDezena() throws IOException {
        Sena sena = new Sena();
        sena.setTenPerVolante(6);
        sena.setVolant(1);
        sena.gerator();
        assertEquals(sena.result().length(), 23);
    }
}
