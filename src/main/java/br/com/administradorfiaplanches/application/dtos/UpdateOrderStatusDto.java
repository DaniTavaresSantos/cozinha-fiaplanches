package br.com.administradorfiaplanches.application.dtos;

import br.com.administradorfiaplanches.domain.enums.OrderStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateOrderStatusDto(

        @NotNull(message = "Numero da ordem nao pode ser nulo")
        Long orderId,

        @NotBlank(message = "Status da ordem nao pode ser nulo")
        OrderStatus status
) {
}
