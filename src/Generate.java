import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.*;

class Generate {

    private int ten = 0;
    private int tenPerVolant;
    private int numVolant = 0;
    private String file;
    private String generated = "";
    private int[] volant;
   // private int totalVolant;
    //private List<String> resOriginal = new ArrayList<>();
    private int max;
    double [] price;

    Generate(int maxTen, int tenPerVolant, String file, double [] price) {
        this.max = maxTen;
        this.tenPerVolant = tenPerVolant;
        this.file = file;
        this.price = price;
    }

    void setTenPerVolante(int ten) {
        this.ten = ten;
    }

    void setVolant(int volant) {
        this.numVolant = volant;
    }

    String result() {
        return generated;
    }

    int findLuck(int tenLike, int step) {
        int[] volant;
        volant = newVolante(this.ten);
        int find = 0;
        int[] volantLuck;
        for (int i = 0; i < step; i++) {
            volantLuck = newVolante(tenLike);
            if (verifyEqual(volant, volantLuck)) {
                find++;
                System.out.println(convertArrayToStr(volant) +" == "+convertArrayToStr(volantLuck) + "  FIND: "+ i +" Possibilies.   "+((100*i)/step) +"% Done.   Gastar:"+convertDoubleToMoney(this.price[tenLike-this.tenPerVolant] * i)  );
            }
        }
        return find;
    }

    String convertDoubleToMoney (double d) {
        Locale ptBr = new Locale("pt", "BR");
        return NumberFormat.getCurrencyInstance(ptBr).format(d);
    }


    private boolean verifyEqual(int [] v1, int [] v2 ) {
        int passo = 0;
        for (int i = 0; i < v1.length; i++) {
            for (int j = 0; j < v2.length; j++) {
                if (v1[i] == v2[j]) passo++;
            }
        }
        return passo > this.tenPerVolant-1;
    }

    void gerators() throws IOException {
        this.generated = "";
        this.volant = new int[this.ten];
        String volantStr;
        int [][] volantOriginal = pegarResultadoOriginal(this.file);
        for (int f = 0; f < this.numVolant; f++) {
            do {
                volant = newVolante(this.ten);
                volantStr = convertArrayToStr(volant);
               // System.out.print(volantStr + "  Testing... ");
            } while ((verifyEqualOriginal(volantOriginal,volant) || sum(volant)) || imPar(volant));
            //System.out.println(" ");
            generated += (tab(f + 1)) + ") " + volantStr + "\n";
        }
    }

    private boolean verifyEqualOriginal(int[][] volantOriginal, int[] volant) {
        int passo = 0;
        int length = volantOriginal.length;
        int f = 0;
        while ( (f<length) && (passo<this.tenPerVolant) ) {
            passo = 0;
            for (int i = 0; i < volantOriginal[f].length; i++) {
                for (int j = 0; j < volant.length; j++) {
                    if (volantOriginal[f][i] == volant[j]) passo++;
                }
            }
            f++;
        }
        if(passo>this.tenPerVolant-1)
            System.out.println(" VOLANT ORIGINAL:" + (f-1) + " Passo = "+passo+" Poor. Try again.");
        return passo > this.tenPerVolant-1;

    }

    int [] newVolante( int ten) {
        int order = 0;
        int [] volant = new int[ten];
        boolean different;
        int luck = (int) Math.round(Math.random() * max + 1);
        volant[order++] = luck;
        while (order < ten) {
            different = true;
            luck = (int) Math.round(Math.random() * max + 1);
            int orderTemp = 0;
            while (different && orderTemp < order) {
                if (volant[orderTemp] == luck) different = false;
                orderTemp++;
            }
            if (different) volant[order++] = luck;
        }
        return crescent(volant);
    }

    private String convertArrayToStr(int [] volant) {
        String str = "";
                for (int i = 0; i < volant.length; i++) {
            str += tab(volant[i]) + " ";
        }
        return str;
    }

    private boolean imPar(int[] volant) {
        int total_par = 0;
        int total_impar = 0;
        for (int i = 0; i < volant.length - 1; i++) {
            if (volant[i] % 2 == 0)
                total_par++;
            else total_impar++;
        }
        if (((total_par >= 2) && (total_par <= volant.length - 2)) && ((total_impar >= 2) && (total_impar <= volant.length - 2)))
            return false;

        System.out.println(" PAR:" + total_par + " e IMPAR:" + total_impar + " Poor. Try again.");
        return true;
    }

    private boolean sum(int[] str) {
        int totalHigh = 0;
        for (int i = this.max; i > (this.max - (volant.length)); i--) totalHigh += i;
        int totalLow = 0;
        for (int i = 1; i < volant.length; i++) totalLow += i;
        int media = (totalHigh + totalLow) / 2;
        //System.out.print("Maior:"+totalMaior+"  Menor:"+totalMenor+"  Media ==" + media  +" ");
        int soma = 0;
        for (int i = 0; i < volant.length; i++)
            soma += volant[i];
        if ((soma > media - 50) && (soma < media + 50))
            return false;
        System.out.println(" Somatorio: :" + soma + " Poor. Tentar de novo.");
        return true;
    }

//    private boolean verifyEqualStr(String str) {
//        boolean igual = false;
//        int passo = 0;
//        while (passo < this.totalVolant && igual) {
//            if (str.equals(this.resOriginal.get(passo))) {
//                igual = true;
//                System.out.print(str + " ==" + resOriginal.get(passo) + " ");
//                System.out.println("  EQUAL. Tru Again.");
//            }
//            passo++;
//        }
//        return igual;
//    }

    private int[] crescent(int[] volant) {
        int temp;
        for (int i = 0; i < volant.length - 1; i++) {
            if (volant[i] > volant[i + 1]) {
                temp = volant[i];
                volant[i] = volant[i + 1];
                volant[i + 1] = temp;
                i = -1;
            }
        }
        return volant;
    }

    private String tab(int i) {
        return i < 10 ? "0" + i : String.valueOf(i);
    }

    private int[][] pegarResultadoOriginal(String file) throws IOException {
        Path filePath = Paths.get(file);
        Scanner scanner = new Scanner(filePath);
        List<Integer> integers = new ArrayList<>();

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                integers.add(scanner.nextInt());

            } else {
                scanner.next();
            }
        }
        System.out.println(integers);
        System.out.println(integers.size() / this.tenPerVolant);
        int totalVolant = integers.size() / this.tenPerVolant;
        int passo = 0;
       // this.resOriginal.clear();
        int a;
        int[][] volant = new int[totalVolant][this.tenPerVolant];
        for (int i = 0; i < totalVolant; i++) {
           // String str = "";
            for (int f = 0; f < this.tenPerVolant; f++) {
                a = integers.get(passo++);
                volant[i][f] = a;
               // str += tab(a) + " ";
            }

           // this.resOriginal.add(str);
        }
       // System.out.println(resOriginal.get(1));
        return volant;
    }
}
