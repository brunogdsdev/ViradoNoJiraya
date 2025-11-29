package crud.service;

import crud.dominio.Anime;
import crud.dominio.Producer;
import crud.repository.AnimeRepository;
import crud.repository.ProducerRepository;

import java.util.List;
import java.util.Scanner;

public class AnimeService {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void buildMenu(int op){
        switch (op){
            case 1 -> findByName();
            case 2 -> saveAnime();
            default -> System.out.println("Invalid option");
        }
    }
    public static void showMenu(){
        System.out.println("------------- MENU (Anime) ------------------");
        System.out.println("1 - Pesquisar ");
        System.out.println("2 - Criar ");
        System.out.println("0 - Voltar ");
        System.out.println("-------------------------------------------");
        System.out.print("Option: ");
    }


    public static void findByName(){
        System.out.print("Digite um nome ou aperte ENTER para buscar todos");

        String name = SCANNER.nextLine();

        List<Anime> animes = AnimeRepository.findByName(name);


        for (int i = 0; i < animes.size(); i++) {
            Anime a = animes.get(i);
            System.out.println("-------------------------------------------");
            System.out.printf("[%d] Id: %d, Nome: %s, Produtora: %s \n", i, a.getId(), a.getName(), a.getProducer().getName());
        }
        System.out.printf("\n\n\n");
    }


    public static void saveAnime(){
        System.out.print("Digite um nome: ");
        String name = SCANNER.nextLine();

        if(name.isEmpty()){
            System.out.println("Nome nao pode ser vazio!");
            return;
        }

        System.out.print("Digite quantidade de episodios: ");
        Integer episodes = Integer.parseInt(SCANNER.nextLine());

        if(! (episodes >= 0)){
            System.out.println("Nome nao pode ser negativo!");
            return;
        }

        System.out.print("Digite um nome de produtora ou escolha um id existente: ");
        String producer_value = SCANNER.nextLine();

        int producer_id;
        if(producer_value.matches("/d")){
            Producer producer = ProducerService.findById(Integer.parseInt(producer_value));
            producer_id = producer.getId();
        }else{
            producer_id = ProducerRepository.saveProducer(producer_value);
        }

        Anime a = Anime.builder()
                .name(name)
                .episodes(episodes)
                .id(1)
                .producer(null)
                .build();

        AnimeRepository.saveAnime(a, producer_id);
        System.out.println("Criado com sucesso! \n\n");
    }


}
