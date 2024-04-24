package com.eazybytes.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Schema(name = "Cards", description = "Schema to hold cards information")
@Data
public class CardsDto {

    @NotEmpty(message = "Mobile Nr cannot be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Nr must be 10 digits")
    @Schema(description = "Mobile Nr of customer", example = "1234567890")
    private String mobileNumber;

    @NotEmpty(message = "Card Number can not be a null or empty")
    @Pattern(regexp = "(^$|[0-9]{12})", message = "CardNumber must be 12 digits")
    @Schema(description = "Card Number of the customer", example = "123456789012")
    private String cardNumber;

    @NotEmpty(message = "CardType can not be a null or empty")
    @Schema(description = "Type of the card", example = "Credit Card")
    private String cardType;

    @Positive(message = "Total card limit should be greater than zero")
    @Schema(description = "Total amount limit available against a card", example = "100000" )
    private int totalLimit;

    @PositiveOrZero(message = "Total amount used should be equal or greater than zero")
    @Schema(description = "Total amount used by a Customer", example = "1000")
    private int amountUsed;

    @PositiveOrZero(message = "Total available amount should be equal or greater than zero")
    @Schema(description = "Total available amount against a card", example = "90000")
    private int availableAmount;
}
