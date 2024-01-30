package br.com.administradorfiaplanches.application.ports.out;

import br.com.administradorfiaplanches.application.dtos.UpdateOrderStatusDto;
import br.com.administradorfiaplanches.domain.enums.OrderStatus;

public interface SendUpdateOrderTopicPortOut {

    void sendUpdateOrderTopic(UpdateOrderStatusDto updateOrderStatusDto);
}
