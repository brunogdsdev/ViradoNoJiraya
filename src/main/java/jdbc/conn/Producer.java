package jdbc.conn;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public final class Producer {
    private final Integer id;
    private final String name;
}


// o final nao é obrigatório pois o Lombok @Value já vai criar a classe e os atributos como final
// porém adicionei pra lembrar disso