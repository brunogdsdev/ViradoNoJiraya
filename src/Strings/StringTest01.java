package Strings;

public class StringTest01 {


    public static void main(String[] args) {
        String nome = "Bruno"; // CRIA UMA REFERENCIA Bruno na String constant pool
        String nome2 = "Bruno"; // aponta para uma referencia existente
//        nome.concat("Gomes"); nome continua sendo apenas "Bruno", cria uma referencia para Gomes na String pool
//        System.out.println(nome);
        nome = nome.concat("Gomes"); // nome agora é BrunoGomes, e BrunoGomes é uma nova referencia na String pool

        System.out.println(nome);
        System.out.println(nome == nome2);

        String nome3 = new String("Bruno");

        System.out.println(nome2 == nome3); // cria um objeto no Heap e esse objeto tem uma variavel que aponta para a referencia de Bruno na String pool,
        // mas no comparativo vai dar false pq está sendo comparado a referencia da String pool com a referencia do obj na Heap


        System.out.println(nome2 == nome3.intern()); // agora está comparando as duas referencias na String pool
    }
}
