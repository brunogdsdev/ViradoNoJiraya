package threads;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ThreadSafeNames{
    // a variavel se torna safe mas os métodos continuam sendo acessados por várias threads se usar apenas o synchronizedList
    private final List<String> names = new ArrayList<>();


    public synchronized void add(String name){
        names.add(name);
    }

    public synchronized void removeFirst(){
        if(names.size() > 0){
            System.out.println(Thread.currentThread().getName());
            System.out.println(names.remove(0));
        }
    }
}

public class ThreadSafeMain {
    public static void main(String[] args) {
        ThreadSafeNames t = new ThreadSafeNames();
        t.add("azincrev");

        Runnable r = t::removeFirst;

        new Thread(r).start();
        new Thread(r).start();

    }
}
