package behavior;


@FunctionalInterface // NAO É OBRIGATÓRIO, MAS FORCA A SEGUIR O PADRAO DE 1 FUNCAO NA INTERFACE PARA SEGUIR O PADRAO DE INTERFACE FUNCIONAL
public interface CarPredicate {

    boolean test(Car car);
}
