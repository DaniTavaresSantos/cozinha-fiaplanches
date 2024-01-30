package br.com.administradorfiaplanches.infra.config.beans;

import br.com.administradorfiaplanches.application.ports.out.SendUpdateOrderTopicPortOut;
import br.com.administradorfiaplanches.application.usecases.UpdateOrderStatusUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateOrderStatusConfig {

    @Bean
    public UpdateOrderStatusUseCase updateOrderStatusUseCase(SendUpdateOrderTopicPortOut sendUpdateOrderTopicPortOut) {
        return new UpdateOrderStatusUseCase(sendUpdateOrderTopicPortOut);
    }
}
