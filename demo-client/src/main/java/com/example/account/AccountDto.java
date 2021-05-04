package com.example.account;

import lombok.*;

@Builder(setterPrefix = "set")
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class AccountDto {

    private Integer id;
    private String brand;
    private Integer agency;
    private Integer number;
    private Integer digit;

    public static AccountDto convertToDto(Account account) {
        return AccountDto.builder()
                .setAgency(account.getAgency())
                .setBrand(account.getBrand())
                .setId(account.getId())
                .setNumber(account.getNumber())
                .setDigit(account.getDigit())
                .build();
    }
}
