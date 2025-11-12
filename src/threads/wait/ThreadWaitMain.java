package threads.wait;

import javax.swing.*;

public class ThreadWaitMain implements Runnable{
    private final Members members;

    public ThreadWaitMain(Members members){
        this.members = members;
    }

    public static void main(String[] args) {
        Members members1 = new Members();
        Thread t1 = new Thread(new ThreadWaitMain(members1), "Thread1");
        Thread t2 = new Thread(new ThreadWaitMain(members1), "Thread2");

        t1.start();
        t2.start();

        while(true){
            String email = JOptionPane.showInputDialog("Entre com email");
            if(email == null || email.isEmpty()){
                members1.close();
                break;
            }

            members1.addMemberEmail(email);
        }
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()+ " iniciando envio de emails....");

        while(members.isOpen() || members.pendingEmails() > 0){
            try{
                String email = members.retrieveEmail();
                if(email == null) continue;

                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName()+ " Enviou com sucesso....");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        System.out.println("Todos os emails foram ENVIADOS!");
    }
}
