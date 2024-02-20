package stmall.delivery.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import stmall.delivery.events.DeliveryStarted;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class DeliveryServiceTest {

    @Autowired
    private DeliveryService deliveryService;

    @Test
    public void contextLoads() {
        assertNotNull(deliveryService);
    }

    @Test
    public void testWheneverOrdered_StartDelivery() {
        DeliveryStarted deliveryStarted = new DeliveryStarted(1L, 1L, "user1", "Product 1", 1L, 1, "STARTED");
        deliveryService.wheneverOrdered_StartDelivery().accept(deliveryStarted);
        // Add assertions to verify the behavior
    }
}