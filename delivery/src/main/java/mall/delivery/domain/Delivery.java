package mall.delivery.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.AbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import mall.delivery.domain.events.DeliveryStarted;
import mall.delivery.domain.events.DeliveryCanceled;
import mall.delivery.domain.events.DeliveryCompleted;
import mall.delivery.domain.events.ProductCollected;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "deliveries")
public class Delivery extends AbstractAggregateRoot<Delivery> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long orderId;
    private String userId;
    private String productName;
    private Long productId;
    private Integer qty;
    private String deliveryStatus;

    // Business logic methods to handle commands and raise events
    public void startDelivery() {
        this.deliveryStatus = "STARTED";
        registerEvent(new DeliveryStarted(this));
    }

    public void cancelDelivery() {
        this.deliveryStatus = "CANCELED";
        registerEvent(new DeliveryCanceled(this));
    }

    public void completeDelivery() {
        this.deliveryStatus = "COMPLETED";
        registerEvent(new DeliveryCompleted(this));
    }

    public void collectProduct() {
        this.deliveryStatus = "COLLECTED";
        registerEvent(new ProductCollected(this));
    }
}