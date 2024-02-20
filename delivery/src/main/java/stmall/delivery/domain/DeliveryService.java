package stmall.delivery.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import stmall.delivery.events.DeliveryCanceled;
import stmall.delivery.events.DeliveryCompleted;
import stmall.delivery.events.DeliveryStarted;
import stmall.delivery.events.ProductCollected;

import java.util.function.Consumer;

@Service
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;
    private final StreamBridge streamBridge;

    @Autowired
    public DeliveryService(DeliveryRepository deliveryRepository, StreamBridge streamBridge) {
        this.deliveryRepository = deliveryRepository;
        this.streamBridge = streamBridge;
    }

    @Bean
    public Consumer<DeliveryStarted> wheneverOrdered_StartDelivery() {
        return deliveryStarted -> {
            // Logic to handle DeliveryStarted event
        };
    }

    @Bean
    public Consumer<DeliveryCanceled> wheneverOrderCanceled_CancelDelivery() {
        return deliveryCanceled -> {
            // Logic to handle DeliveryCanceled event
        };
    }

    @Bean
    public Consumer<DeliveryCompleted> wheneverDeliveryCompleted_CompleteDelivery() {
        return deliveryCompleted -> {
            // Logic to handle DeliveryCompleted event
        };
    }

    @Bean
    public Consumer<ProductCollected> wheneverProductCollected_CollectionCompleted() {
        return productCollected -> {
            // Logic to handle ProductCollected event
        };
    }

    @Bean
    public Consumer<Object> discardFunction() {
        return event -> {
            // Logic to discard the event
        };
    }
}