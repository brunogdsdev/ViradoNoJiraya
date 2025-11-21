package innerclass;

public class InnerClassesMain {
    private String name = "Bruno";

     class Inner{
         public void printOuterAtt(){
             System.out.println(name);
             System.out.println(this);
             System.out.println(InnerClassesMain.this);
         }
     }

    public static void main(String[] args) {
        InnerClassesMain teste = new InnerClassesMain();

        InnerClassesMain.Inner inner = teste.new Inner();
        Inner inner2 = teste.new Inner();
        Inner inner3 = new InnerClassesMain().new Inner();

        inner.printOuterAtt();
        inner2.printOuterAtt();
        inner3.printOuterAtt();

    }
}
