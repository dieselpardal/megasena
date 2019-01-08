import java.io.IOException;

class Sena {
    double [] price = {3.5, 24.5, 98.0, 294.0, 735.0, 1617.0, 3234.0, 6006.0, 10510.5, 17517.5};
    Generate generate;

    Sena() {
        this.generate = new Generate(60, 6, "resultadoMegaSena.txt" ,price);
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
