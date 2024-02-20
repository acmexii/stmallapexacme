package stmall.delivery.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryCompleted {
    private Long id;
    private Long orderId;
    private String userId;
    private String productName;
    private Long productId;
    private Integer qty;
    private String deliveryStatus;
}