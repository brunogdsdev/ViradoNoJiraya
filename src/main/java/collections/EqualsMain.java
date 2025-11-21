package collections;

public class EqualsMain {

    public static void main(String[] args) {
        String nome = "Bruno Gomes";
//        String nome2 = "Bruno Gomes";
        String nome2 = new String("Bruno Gomes");

        System.out.println("(1) ->"+(nome == nome2));
        System.out.println("(2) ->"+nome.equals(nome2));



        Smartphone s1 = new Smartphone("A1", "Iphone");
        Smartphone s2 = new Smartphone("A1", "Iphone");
        Smartphone s3 = s1;

        System.out.println("(3) ->"+(s1 == s2));
        System.out.println("(4) ->"+s1.equals(s2));
        System.out.println("(5) ->"+(s1 == s3));
        System.out.println("(6) ->"+s1.equals(s3));
    }
}


class Smartphone{
    private String serialNumber;
    private String marca;

    public Smartphone(String serialNumber, String marca) {
        this.serialNumber = serialNumber;
        this.marca = marca;
    }


//    reflexivo: x.equals(x) tem que ser true para tudo que for diferente de null
//    simétrico: para x e y  diferentes de null, s x.equals(y) === true logo, y.equals(x) === true
//    transitividade: para x,y,z diferentes de null, se x.equals(y) == true, e x.equals(z) == true logo, y.equals(z) == true
//    consistente: x.equals(x) sempre retorna true se x for diferente de null
//    para x diferente de null, x.equals(null) tem que retornar false

    @Override
    public boolean equals(Object obj) {
        if(obj == null)return false;
        if(this == obj)return true;
        if(this.getClass() != obj.getClass()) return false;

        Smartphone sm = (Smartphone) obj;
        return serialNumber != null && serialNumber.equals(sm.serialNumber);

    }


//    se x.equals(y) == true, y.hashcode() == x.hashcode()
//      y.hashcode() == x.hashcode() nao necessariamente o equals de y.equals(x) tem ser true
//    se x.equals(y) == false
//    y.hashcode() != x.hashcode() x.equals(y) deverá ser false
    @Override
    public int hashCode() {
        return serialNumber == null ? 0 : this.serialNumber.hashCode();
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "serialNumber='" + serialNumber + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
