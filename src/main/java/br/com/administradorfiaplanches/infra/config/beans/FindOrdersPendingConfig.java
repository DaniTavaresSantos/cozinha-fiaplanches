package br.com.administradorfiaplanches.infra.config.beans;

import br.com.administradorfiaplanches.application.ports.out.OrderRestPortOut;
import br.com.administradorfiaplanches.application.usecases.FindOrdersPendingUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindOrdersPendingConfig {

    @Bean
    public FindOrdersPendingUseCase findOrdersPendingUseCase(OrderRestPortOut orderRestPortOut) {
        return new FindOrdersPendingUseCase(orderRestPortOut);
    }
}
