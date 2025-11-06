package threads;


class ThreadExample extends Thread{
    char c;

    public ThreadExample(char c){
        this.c = c;
    }

    @Override
    public void run(){
        System.out.println();
        System.out.println(Thread.currentThread().getName());
        for(int i = 0; i < 1000; i++){
            System.out.print(this.c);
            if(i % 100 == 0){
                System.out.println();
            }
        }
    }
}


class RunnableExample implements Runnable{
    char c;

    public RunnableExample(char c){
        this.c = c;
    }

    @Override
    public void run() {
        System.out.println();
        System.out.println(Thread.currentThread().getName());
        for(int i = 0; i < 1000; i++){
            System.out.print(this.c);
            if(i % 100 == 0){
                System.out.println();
            }
        }
    }
}

public class ThreadMain {
    public static void main(String[] args) {
//        ThreadExample t1 = new ThreadExample('A');
//        ThreadExample t2 = new ThreadExample('B');
//        ThreadExample t3 = new ThreadExample('C');
//        ThreadExample t4 = new ThreadExample('D');
//        ThreadExample t5 = new ThreadExample('E');


//        t1.run();
//        t2.run();
//        t3.run();
//        t4.run();
//        t5.run();

//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
//        t5.start();

        Thread t1 = new Thread(new RunnableExample('A'));
        Thread t2 = new Thread(new RunnableExample('B'));
        Thread t3 = new Thread(new RunnableExample('C'));
        Thread t4 = new Thread(new RunnableExample('D'));
        Thread t5 = new Thread(new RunnableExample('E'));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }
}
