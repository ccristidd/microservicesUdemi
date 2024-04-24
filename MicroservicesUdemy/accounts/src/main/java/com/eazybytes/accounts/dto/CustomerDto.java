package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = "Customer",
        description = "Schema to hold Customer information"
)
public class CustomerDto {
    @Size(min = 5, max = 30, message = "name should be between 5 and 30")
    @NotEmpty(message = "Name cannot be null or empty")
    @Schema(
            description = "name of the customer", example = "Eazy Bytes"
    )
    private String name;

    @Schema(
            description = "email of the customer", example = "email@ofTheCustomer.ro"
    )
    @Email(message = "Email vaule is not valid")
    @NotEmpty(message = "Email address cannot be null or empty")
    private String email;

    @Schema(
            description = "mobile number of the customer", example = "123456789"
    )
    @Pattern(regexp = "(^$|[0-9]{10})", message = "mobile number must be 10 digits")
    private String mobileNumber;

    @Schema(
            description = "Account detail of the customer"
    )
    private AccountsDto accountsDto;
}
