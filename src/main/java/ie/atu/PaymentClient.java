package ie.atu;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "payment-service", url = "http://localhost:8081/payment")
public interface PaymentClient {
    @PostMapping("/processPayment/{memberID}/{amount}")
    public String processPayment(@PathVariable int memberID, @PathVariable double amount);
}
