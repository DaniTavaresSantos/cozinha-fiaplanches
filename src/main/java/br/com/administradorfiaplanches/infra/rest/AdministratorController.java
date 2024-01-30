package br.com.administradorfiaplanches.infra.rest;

import br.com.administradorfiaplanches.application.dtos.OrderDto;
import br.com.administradorfiaplanches.application.dtos.UpdateOrderStatusDto;
import br.com.administradorfiaplanches.application.ports.out.SendUpdateOrderTopicPortOut;
import br.com.administradorfiaplanches.application.usecases.FindOrdersPendingUseCase;
import br.com.administradorfiaplanches.application.usecases.UpdateOrderStatusUseCase;
import br.com.administradorfiaplanches.domain.enums.OrderStatus;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/admin")
public class AdministratorController {

    private final FindOrdersPendingUseCase findOrdersPendingUseCase;

    private final UpdateOrderStatusUseCase updateOrderStatusUseCase;

    public AdministratorController(FindOrdersPendingUseCase findOrdersPendingUseCase, UpdateOrderStatusUseCase updateOrderStatusUseCase){
        this.findOrdersPendingUseCase = findOrdersPendingUseCase;
        this.updateOrderStatusUseCase = updateOrderStatusUseCase;
    }

    @GetMapping("/find/order/pending")
    public ResponseEntity<List<OrderDto>> findOrdersPending() {
        List<OrderDto> orderDtos = findOrdersPendingUseCase.findOrdersPending();

        return ResponseEntity.status(HttpStatus.OK).body(orderDtos);
    }

    @PostMapping("/update/order/status")
    public ResponseEntity<String> updateOrderStatus(@RequestBody @Valid UpdateOrderStatusDto updateOrderStatusDto) {
        updateOrderStatusUseCase.updateOrderStatus(updateOrderStatusDto);
        return ResponseEntity.status(HttpStatus.OK).body("Solicitação realizada com sucesso!");
    }
//
//    @PostMapping("/pay-order")
//    public ResponseEntity<OrderDto> pagaPedido(@RequestBody @Valid PaymentOrderDto paymentOrderDto) {
//        OrderDto orderDto = paymentOrderUseCase.payOrder(paymentOrderDto);
//        return ResponseEntity.ok().body(orderDto);
//    }
//
//    @PostMapping("/create-order")
//    public ResponseEntity<Long> createOrder(@RequestBody @Valid CreateOrderDto createOrderDto) {
//        OrderDto orderDto = createOrderUseCase.createOrder(createOrderDto);
//        return ResponseEntity.status(HttpStatus.CREATED).body(orderDto.id());
//    }
//
//    @PutMapping("/update-order")
//    public ResponseEntity<OrderDto> updateOrder(@RequestBody @Valid UpdateOrderDto updateOrderDto) {
//        OrderDto orderDto = updateOrderUseCase.updateOrder(updateOrderDto);
//        return ResponseEntity.status(HttpStatus.OK).body(orderDto);
//    }
//
//    @GetMapping("/ordered")
//    public ResponseEntity<Page<OrderDto>> findOrderOrdered(@PageableDefault Pageable pageable) {
//        List<OrderDto> orderOrdered = findOrderOrderedUseCase.findOrderOrdered();
//
//        return ResponseEntity.status(HttpStatus.OK).body(
//                new PageImpl<OrderDto>(orderOrdered, pageable, orderOrdered.size())
//        );
//    }
}
