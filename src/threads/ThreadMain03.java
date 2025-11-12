package threads;

import javax.print.attribute.standard.RequestingUserName;

public class ThreadMain03 implements Runnable{
    private final Account ac = new Account();
    public static void main(String[] args) {
        ThreadMain03 t = new ThreadMain03();
        Thread t1 = new Thread(t, "ABC");
        Thread t2 = new Thread(t, "DEF");
        t1.start();
        t2.start();
    }


    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            withDrawl(10);
            if(ac.getBalance() < 0){
                System.out.println("NO MONEY");
            }
        }
    }


private void withDrawl(int amount){
        // nesse caso o synchronized vai organizar o acesso ao metodo apenas e nao ao metodo
        // cria um LOCK no objeto, é nesseário que ele seja FINAL para nao 'confundir' na hora de passar o ac como argumento
        synchronized (ac){
            if(ac.getBalance() >= amount){
                System.out.println(Thread.currentThread().getName()+ " está indo sacar dinheiro");
                ac.withDrawl(amount);
                System.out.println(Thread.currentThread().getName()+ " completou o saque, valor atual"+ ac.getBalance());
            }else{
                System.out.println(Thread.currentThread().getName()+ " sem dinheiro dinheiro para saque"+ ac.getBalance());
            }
        }
}

// o synchronized garante que outra thread só vai iniciar esse metodo quando a thread que estiver rotando terminar
//private synchronized void withDrawl(int amount) {
//    if (ac.getBalance() >= amount) {
//        System.out.println(Thread.currentThread().getName() + " está indo sacar dinheiro");
//        ac.withDrawl(amount);
//        System.out.println(Thread.currentThread().getName() + " completou o saque, valor atual" + ac.getBalance());
//    } else {
//        System.out.println(Thread.currentThread().getName() + " sem dinheiro dinheiro para saque" + ac.getBalance());
//    }
//}




//    private void withDrawl(int amount){
//        if(ac.getBalance() >= amount){
//            System.out.println(Thread.currentThread().getName()+ " está indo sacar dinheiro");
//            ac.withDrawl(amount);
//            System.out.println(Thread.currentThread().getName()+ " completou o saque, valor atual"+ ac.getBalance());
//        }else{
//            System.out.println(Thread.currentThread().getName()+ " sem dinheiro dinheiro para saque"+ ac.getBalance());
//        }
//    }


}
