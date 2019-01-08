import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
//        System.out.println("GERADOR DE MEGA SENA");
//        Sena sena = new Sena();
//        sena.setTenPerVolante(6);
//        sena.setVolant(30);
//        sena.gerator();
//        System.out.println("---------------------------------");
//        System.out.println(sena.result());
//        System.out.println("---------------------------------");
//        sena.findLuck();
        System.out.println("GERADO LOTOFACIL");
        LotoFacil lotofacil = new LotoFacil();
        lotofacil.setTenPerVolante(15);
        lotofacil.setVolant(20);
        lotofacil.gerator();
        System.out.println("---------------------------------");
        System.out.println(lotofacil.result());
        System.out.println("---------------------------------");
        lotofacil.findLuck();
    }
}
