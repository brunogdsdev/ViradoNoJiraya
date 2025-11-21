package concurrency;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Members {
    private final Queue<String> emails = new ArrayBlockingQueue<>(10);
    private boolean open = true;

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();


    public boolean isOpen(){
        return this.open;
    }

    public int pendingEmails(){
        lock.lock();
        try{
            return emails.size();
        }finally {
            lock.unlock();
        }
    }


    public void addMemberEmail(String email){
        synchronized (this.emails){
            lock.lock();
            try{
                System.out.println(Thread.currentThread().getName()+ " adicionou email");
                this.emails.add(email);
                condition.signalAll();
            }finally {
                lock.unlock();
            }

        }
    }


    public String retrieveEmail() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+ " verificando se há emails");

        lock.lock();
        try{
            while(emails.size() == 0){
                if(!open) break;
                System.out.println(Thread.currentThread().getName()+" Nao tem email disponível na lista, entrando em modo espera");
                condition.await();
            }
            return this.emails.poll();
        }finally {
            lock.unlock();
        }
    }


    public void close(){
        open = false;
        lock.lock();
        try{

            System.out.println(Thread.currentThread().getName()+" fechando...");
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

}
