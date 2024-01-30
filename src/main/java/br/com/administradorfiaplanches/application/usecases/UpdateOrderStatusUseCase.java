package br.com.administradorfiaplanches.application.usecases;

import br.com.administradorfiaplanches.application.dtos.UpdateOrderStatusDto;
import br.com.administradorfiaplanches.application.ports.out.SendUpdateOrderTopicPortOut;
import br.com.administradorfiaplanches.domain.enums.OrderStatus;

public class UpdateOrderStatusUseCase {

    private final SendUpdateOrderTopicPortOut sendUpdateOrderTopicPortOut;

    public UpdateOrderStatusUseCase(SendUpdateOrderTopicPortOut sendUpdateOrderTopicPortOut) {
        this.sendUpdateOrderTopicPortOut = sendUpdateOrderTopicPortOut;
    }

    public void updateOrderStatus(UpdateOrderStatusDto updateOrderStatusDto) {
        sendUpdateOrderTopicPortOut.sendUpdateOrderTopic(updateOrderStatusDto);
    }
}
