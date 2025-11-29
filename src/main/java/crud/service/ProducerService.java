package crud.service;

import crud.MainCrud;
import crud.dominio.Producer;
import crud.repository.ProducerRepository;

import java.util.List;
import java.util.Scanner;


public class ProducerService {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static void buildMenu(int op) {
//        switch (op) {
//            case 1:
//                findByName();
//                break;
//            case 2:
//                deleteById();
//                break;
//            case 0:
//                System.out.println("Encerrando...");
//            default:
//                throw new IllegalArgumentException("Ivalid option");
//        }


        // ENHANCED SWITCH JAVA 12
        switch (op) {
            case 1 -> findByName();
            case 2 -> deleteById();
            case 3 -> create();
            case 4 -> updateById();
            case 0 -> MainCrud.showMainMenu();
            default -> throw new IllegalArgumentException("Ivalid option");
        }
    }

    public static void showMenu() {
        System.out.println("------------- MENU (Producer) ------------");
        System.out.println("1 - Buscar ");
        System.out.println("2 - Deletar ");
        System.out.println("3 - Criar ");
        System.out.println("4 - Alterar ");
        System.out.println("0 - Voltar ");
        System.out.println("-------------------------------------------");
        System.out.print("Option: ");
    }


    private static void findByName() {
        System.out.print("Pesquise um nome ou tecle ENTER para buscar todos: ");
        String name = SCANNER.nextLine();
        List<Producer> list = ProducerRepository.findByName(name);
        for (int i = 0; i < list.size(); i++) {
            Producer p = list.get(i);
            System.out.println("--------------------------------------");
            System.out.printf("[%d] Id: %d, Name: %s %n", i, p.getId(), p.getName());
        }
        System.out.printf("%n%n%n");

    }

    public static Producer findById(Integer id) {
        return ProducerRepository.findById(id);
    }

    private static void deleteById() {
        findByName();

        System.out.print("Escolha qual ID deseja deletar: ");
        int id = Integer.parseInt(SCANNER.nextLine());
        System.out.print("Tem certeza disso? S/N: ");
        String choice = SCANNER.nextLine();

        if("s".equalsIgnoreCase(choice)){
            ProducerRepository.deleteById(id);
            System.out.println("Deletado Producer de ID = " + id);
        }
    }


    public static void create(){
        System.out.print("Digite um nome: ");
        String name = SCANNER.nextLine();

        if(name.isEmpty()){
            System.out.println("Nome nao pode ser vazio!");
            return;
        }

        ProducerRepository.saveProducer(name);
        System.out.println("Criado com sucesso! \n\n");
        findByName();
    }

    public static void updateById(){
        findByName();

        System.out.print("Escolha qual ID deseja alterar: ");
        int id = Integer.parseInt(SCANNER.nextLine());

        System.out.print("Escolha o novo nome: ");
        String name = SCANNER.nextLine();

        if(name.isEmpty()){
            System.out.println("Nome nao pode ser vazio!");
            return;
        }
        ProducerRepository.updateById(id, name);

        findByName();
    }

}
