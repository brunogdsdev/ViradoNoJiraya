package generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


abstract class Animal{
    public abstract void consulta();
}

class Cachorro extends Animal{
    @Override
    public void consulta(){
        System.out.println("CONSULTA DOG");
    }
}

class Gato extends Animal{
    @Override
    public void consulta(){
        System.out.println("CONSULTA GATO");
    }
}

public class WildcardMain {
    public static void main(String[] args) {
//        teste1();
        teste2();

    }


    public static void teste1(){
        Cachorro[] dogs = {new Cachorro(), new Cachorro()};
        Gato[] cats = {new Gato(), new Gato()};

        printConsulta1(dogs);
        printConsulta1(cats);

        Animal[] animals = {new Gato(), new Cachorro()};
        Animal animal = new Gato();
        printConsulta1(animals);
    }

    private static void printConsulta1(Animal[] animals){
        for (Animal animal : animals) {
            animal.consulta();
        }
        //        error arrays store exception
//        animals[1] = new Cachorro();
    }



    public static void teste2(){

        List<Cachorro> cachorros = List.of(new Cachorro(), new Cachorro());
        List<Gato> gatos = List.of(new Gato(), new Gato());

        printConsulta2(cachorros);
        printConsulta2(gatos);

//        printConsulta3(cachorros);
//        printConsulta3(gatos);

        List<Animal> animals = new ArrayList<>();
        printConsulta3(animals);
    }

    private static void printConsulta2(List<? extends  Animal> animals){ // ACEITA ANIMAL, CACHORRO, GATO...ETC
        for (Animal animal : animals) {
            animal.consulta();
        }

//        com o uso do wild card ? extends Animal, aceita tudo que é um Animal mas nao pode adicionar nada na lista, only read
//        animals.add(new Cachorro());
    }


    // <? super  Animal> ACEITA ANIMAL, OBJECT
    // <? super  Cachorro> aceita cachorro, animal, object
//     nesse caso, como temos a garantia que a lista é de Animal e nao talvez de cachorro ou gato, entao nesse caso pode-se inserir
//    pois é uma lista de Animal, com extends existe a possibilidade de ser uma Lista de Cachorro e entao nao poderia inserir um Gato por ex
    private static void printConsulta3(List<? super  Animal> animals){
        animals.add(new Cachorro());
        animals.add(new Gato());
        for (Object animal : animals) {
            if( animal instanceof Cachorro){
                ((Cachorro) animal).consulta();
            }
        }
    }


}
