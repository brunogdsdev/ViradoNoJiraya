package Strings;

public class StringPerformanceTest {

    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
//        concatString(100_000);
//        concatStringBuilder(100_000);
        concatStringBuffer(100_000);
        long fim = System.currentTimeMillis();
        System.out.println("Tempo de execucao "+ (fim - inicio)+"ms");
    }

    private static void concatStringBuffer(int size){
        StringBuffer texto = new StringBuffer(size);

        for(int i = 0; i <= size; i++){
            texto.append(i);
        }
    }

    private static void concatStringBuilder(int size){
        StringBuilder texto = new StringBuilder(size);

        for(int i = 0; i <= size; i++){
            texto.append(i);
        }
    }

    private static void concatString(int size){
        String texto = "";

        for(int i = 0; i <= size; i++){
            texto += i;
        }
    }
}
