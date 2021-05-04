package com.example.account;

import io.grpc.ManagedChannel;

import java.util.ArrayList;
import java.util.List;

import static com.example.account.AccountServiceGrpc.AccountServiceBlockingStub;
import static com.example.account.AccountServiceGrpc.newBlockingStub;

public class AccountClient {

    private ManagedChannel channel;
    private List<AccountDto> accounts = new ArrayList<>();

    public AccountClient(ManagedChannel channel) {
        this.channel = channel;
    }

    public List<AccountDto> getAccounts() {
        final AccountServiceBlockingStub accountClient = newBlockingStub(this.channel);

        accountClient.retriveAccounts(Empty.newBuilder().build())
                .forEachRemaining(accountResponse -> {
                    accounts.add(AccountDto.convertToDto(accountResponse));
                });

        this.channel.shutdown();
        return accounts;
    }
}
