package com.example.account;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class AccountApplication {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50051)
                .usePlaintext()
                .build();
        final AccountClient accountClient = new AccountClient(channel);

        accountClient.getAccounts()
                .forEach(System.out::println);
    }
}
