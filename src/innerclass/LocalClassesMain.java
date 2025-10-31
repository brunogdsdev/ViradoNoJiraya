package innerclass;

public class LocalClassesMain {

    private String name = "Bruno";

    void print(){
        String lastname = "Gomes";

//        dá erro pq a variavel local pra ser usada numa classe local precisa ser final ou efetivamente final
//        lastname = "";


        class LocalClass{
            public void printLocal(){
                System.out.println(name+ lastname);
            }
        }


        LocalClass local = new LocalClass();
        local.printLocal();

        new LocalClass().printLocal();
    }

    public static void main(String[] args) {
        LocalClassesMain outer = new LocalClassesMain();

        outer.print();
    }
}
