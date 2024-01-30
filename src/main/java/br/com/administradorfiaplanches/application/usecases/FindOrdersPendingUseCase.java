package br.com.administradorfiaplanches.application.usecases;

import br.com.administradorfiaplanches.application.dtos.OrderDto;
import br.com.administradorfiaplanches.application.ports.out.OrderRestPortOut;
import br.com.administradorfiaplanches.domain.enums.OrderStatus;
import br.com.administradorfiaplanches.infra.exception.handler.AdministratorBusinessException;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class FindOrdersPendingUseCase {

    private final OrderRestPortOut orderRestPortOut;

    public FindOrdersPendingUseCase(OrderRestPortOut orderRestPortOut) {
        this.orderRestPortOut = orderRestPortOut;
    }

    public List<OrderDto> findOrdersPending() {
        log.info("Buscando pedidos aprovados");
        return orderRestPortOut.findOrdersPending(OrderStatus.PAGAMENTO_APROVADO).orElseThrow(
                () -> new AdministratorBusinessException("Nenhum pedido aprovado encontrado")
        );
    }
}
