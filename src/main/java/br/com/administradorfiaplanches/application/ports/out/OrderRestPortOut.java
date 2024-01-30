package br.com.administradorfiaplanches.application.ports.out;

import br.com.administradorfiaplanches.application.dtos.OrderDto;
import br.com.administradorfiaplanches.domain.enums.OrderStatus;

import java.util.List;
import java.util.Optional;

public interface OrderRestPortOut {

    Optional<List<OrderDto>> findOrdersPending(OrderStatus orderStatus);
}
