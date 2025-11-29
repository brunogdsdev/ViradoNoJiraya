package crud;

import crud.service.AnimeService;
import crud.service.ProducerService;

import java.util.Scanner;

public class MainCrud {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int op;
        while (true) {
            showMainMenu();
            op = Integer.parseInt(scanner.nextLine());
            if (op == 0) break;

            switch (op){
                case 1 -> ProducerService.showMenu();
                case 2 -> AnimeService.showMenu();
            }

            int service = Integer.parseInt(scanner.nextLine());
            if (service == 0) showMainMenu();

            switch (op){
                case 1 -> ProducerService.buildMenu(service);
                case 2 -> AnimeService.buildMenu(service);
            }
        }
    }


    public static void showMainMenu(){
        System.out.println("------------- MENU PRINCIPAL ------------------");
        System.out.println("1 - Producer ");
        System.out.println("2 - Anime ");
        System.out.println("0 - Sair ");
        System.out.println("-------------------------------------------");
        System.out.print("Option: ");
    }
}


