package streams;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelStreamMain {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());

        long num = 10_000_000;
        sumFor(num);
        System.out.println();
        sumStreamIterate(num);
        System.out.println();
        sumParallelStreamIterate(num);
        System.out.println();
        sumLongStreamIterate(num);
        System.out.println();
        sumParallelLongStreamIterate(num);
    }


    private static void sumFor(long num){
        System.out.println("Sum for");
        long result = 0;
        long init = System.currentTimeMillis();
        for(int i = 1; i <= num; i++){
            result += 1;
        }

        long end = System.currentTimeMillis();
        System.out.println(result+" -> "+(end - init)+ "ms");
    }

    private static void sumStreamIterate(long num){
        System.out.println("Stream iterate:");

        long init = System.currentTimeMillis();
        long result = Stream.iterate(1L, i -> i+1).limit(num).reduce(0L, Long::sum);

        long end = System.currentTimeMillis();
        System.out.println(result+" -> "+(end - init)+ "ms");
    }

    private static void sumParallelStreamIterate(long num){
        System.out.println("Parallel Stream iterate");

        long init = System.currentTimeMillis();
        long result = Stream.iterate(1L, i -> i+1).limit(num).parallel().reduce(0L, Long::sum);

        long end = System.currentTimeMillis();
        System.out.println(result+" -> "+(end - init)+ "ms");
    }
    private static void sumLongStreamIterate(long num){
        System.out.println("sumLongStreamIterate");

        long init = System.currentTimeMillis();
        long result = LongStream.rangeClosed(1L, num).reduce(0L, Long::sum);

        long end = System.currentTimeMillis();
        System.out.println(result+" -> "+(end - init)+ "ms");
    }

    private static void sumParallelLongStreamIterate(long num){
        System.out.println("sumParallelLongStreamIterate");

        long init = System.currentTimeMillis();
        long result = LongStream.rangeClosed(1L, num).parallel().reduce(0L, Long::sum);

        long end = System.currentTimeMillis();
        System.out.println(result+" -> "+(end - init)+ "ms");
    }
}
