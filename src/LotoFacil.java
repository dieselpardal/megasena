import java.io.IOException;

public class LotoFacil {
    double [] price = {2.0, 32.0, 272.0, 1632.0};
    Generate generate;

    LotoFacil() {
        generate = new Generate(25, 15, "resultadoLotoFacil.txt", price);
    }

    void setTenPerVolante(int ten) {
        this.generate.setTenPerVolante(ten);
    }

    void setVolant(int numVolante) {
        this.generate.setVolant(numVolante);
    }

    String result() {
        return this.generate.result();
    }

    void gerator() throws IOException {
        this.generate.gerators();
    }

    void findLuck()  {
        int step = 10000000;
        int find = this.generate.findLuck(15,step);
        System.out.println("Probabilidade: "+find+" finds de "+step+ " try. " +(find*100/step)+"%" );

    }

}
