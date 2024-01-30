package br.com.administradorfiaplanches.infra.adapters.out;

import br.com.administradorfiaplanches.application.dtos.UpdateOrderStatusDto;
import br.com.administradorfiaplanches.application.ports.out.SendUpdateOrderTopicPortOut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SendUpdateOrderTopicAdapterOut implements SendUpdateOrderTopicPortOut {

    @Value("${kafka.topic.producer.name}")
    private String topicUpdateOrder;

    private final KafkaTemplate<String, UpdateOrderStatusDto> kafkaTemplateUpdateOrder;

    public SendUpdateOrderTopicAdapterOut(KafkaTemplate<String, UpdateOrderStatusDto> kafkaTemplateUpdateOrder) {
        this.kafkaTemplateUpdateOrder = kafkaTemplateUpdateOrder;
    }

    @Override
    public void sendUpdateOrderTopic(UpdateOrderStatusDto updateOrderStatusDto) {
        kafkaTemplateUpdateOrder.send(topicUpdateOrder, UUID.randomUUID().toString(), updateOrderStatusDto);
    }
}
