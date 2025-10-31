package generics;


import java.util.List;

public class GenericMethodsMain {

    public static void main(String[] args) {

//        wildCard<Cachorro, Gato> cachorroGatowildCard = new wildCard<>(new Cachorro(), new Gato());

        List<Cachorro> cachorros = criaArray(new Cachorro());
    }


    private static <ABCDEF> List<ABCDEF> criaArray(ABCDEF b){
        List<ABCDEF> list = List.of(b);
        System.out.println(list);
        return list;
    }
}

class wildCard<ABCDEF,teste>{
    private ABCDEF teste1;
    private teste teste2;

    public wildCard(ABCDEF teste1, teste teste2) {
        this.teste1 = teste1;
        this.teste2 = teste2;
    }


}
