package innerclass;



class Aluno{
    public void print(){
        System.out.println("TESTE123");
    }
}

public class AnonymousClassesMain {

    public static void main(String[] args) {
        Aluno aluno = new Aluno(){

            @Override
            public void print(){
                System.out.println("TESTE");
            }

            public void teste(){
                System.out.println("456");
            }
        };


        aluno.print();
//        aluno.teste();
    }
}
