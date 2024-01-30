package br.com.administradorfiaplanches.infra.adapters.out;

import br.com.administradorfiaplanches.application.dtos.OrderDto;
import br.com.administradorfiaplanches.application.ports.out.OrderRestPortOut;
import br.com.administradorfiaplanches.domain.enums.OrderStatus;
import br.com.administradorfiaplanches.infra.exception.handler.AdministratorBusinessException;
import br.com.administradorfiaplanches.infra.exception.handler.MessageDefaultExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class OrderRestAdapterOut implements OrderRestPortOut {

    @Autowired
    private WebClient restOrder;

    @Override
    public Optional<List<OrderDto>> findOrdersPending(OrderStatus orderStatus) {
        log.info("Chamando endpoint de busca de pedidos pendentes");
        List<OrderDto> monoOrderDto = restOrder
                .get()
                .uri("/find/status/{orderStatus}", orderStatus)
                .retrieve()
                .onStatus(
                        httpStatus -> !httpStatus.is2xxSuccessful(),
                        clientResponse -> clientResponse.bodyToMono(MessageDefaultExceptionHandler.class).
                                map(
                                        messageDefaultExceptionHandler -> new AdministratorBusinessException(messageDefaultExceptionHandler.getException().stream().map(String::valueOf).toList().toString())
                                )
                )
                .bodyToFlux(OrderDto.class)
                .collectList()
                .block();

        log.info("Pedidos pendentes: {}", monoOrderDto);
        return Optional.of(monoOrderDto);
    }
}
