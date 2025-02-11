package uz.divergenny.orderservice.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @NotBlank(message = "orderId обязательно для заполнения")
    private String orderId;
    @NotBlank(message = "customerName обязательно для заполнения")
    private String customerName;
    @Positive(message = "amount должен быть положительным числом")
    private double amount;
}
