package threads.wait;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Members {
    private final Queue<String> emails = new ArrayBlockingQueue<>(10);
    private boolean open = true;


    public boolean isOpen(){
        return this.open;
    }

    public int pendingEmails(){
        synchronized (emails){
            return emails.size();
        }
    }


    public void addMemberEmail(String email){
        synchronized (this.emails){
            System.out.println(Thread.currentThread().getName()+ " adicionou email");
            this.emails.add(email);
            this.emails.notifyAll();

        }
    }


    public String retrieveEmail() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+ " verificando se há emails");

        synchronized (this.emails){
            while(emails.size() == 0){
                if(!open) break;
                System.out.println(Thread.currentThread().getName()+" Nao tem email disponível na lista, entrando em modo espera");
                this.emails.wait();
            }
            return this.emails.poll();
        }
    }


    public void close(){
        open = false;
        synchronized (this.emails){
            System.out.println(Thread.currentThread().getName()+" fechando...");
            this.emails.notifyAll();
        }
    }

}
