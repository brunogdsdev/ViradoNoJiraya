package innerclass;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Barco{
    public String tipo;

    public Barco(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}


// PRIMEIRA FORMA DE COMPARAR
class BarcoComparator implements Comparator<Barco>{
    @Override
    public int compare(Barco o1, Barco o2){
        return o1.getTipo().compareTo(o2.getTipo());
    }
}

public class AnonymousClassesMain02 {
    public static void main(String[] args) {
        List<Barco> barcoList = new ArrayList<>(List.of(new Barco("canoa"), new Barco("lancha")));


//        OU SEGUNDA FORMA DE COMPARAR
        barcoList.sort(new Comparator<Barco>() {
            @Override
            public int compare(Barco barco, Barco t1) {
                return 0;
            }
        });

//        OU TERCEIRA FORMA DE COMPARAR
        barcoList.sort((o1, o2) -> o1.getTipo().compareTo(o2.getTipo()));
    }
}
