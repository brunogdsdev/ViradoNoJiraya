package crud.dominio;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public final class Producer {
    Integer id;
    String name;
}


// o final nao é obrigatório pois o Lombok @Value já vai criar a classe e os atributos como final
// porém adicionei pra lembrar disso