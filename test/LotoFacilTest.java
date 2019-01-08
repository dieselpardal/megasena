import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class LotoFacilTest {

    @Test
    public void testDezena() throws IOException {
        LotoFacil lotoFacil = new LotoFacil();
        lotoFacil.setTenPerVolante(15);
        lotoFacil.setVolant(1);
        lotoFacil.gerator();
        assertEquals(lotoFacil.result().length(), 50);
    }
}
