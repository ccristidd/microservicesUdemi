package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Schema(
        name = "Accounts",
        description = "Schema to hold Account information"
)
@Data
public class AccountsDto {

    @NotEmpty(message = "Account number cannot be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "mobile number must be 10 digits")
    @Schema(
            description = "Account number of Eazy Bank", example = "6742345632"
    )
    private Long accountNumber;

    @NotEmpty(message = "Account type cannot be null or empty")
    @Schema(
            description = "Account type of Eazy Bank account", example = "Savings"
    )
    private String accountType;

    @NotEmpty(message = "Branch address cannot be null or empty")
    @Schema(
            description = "Eazy Bank Branch addresss", example = "124 Bucuresti"
    )
    private String branchAddress;
}
