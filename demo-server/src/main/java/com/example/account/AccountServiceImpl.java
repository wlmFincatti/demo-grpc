package com.example.account;

import com.example.account.Account;
import com.example.account.AccountServiceGrpc;
import com.example.account.Empty;
import io.grpc.stub.StreamObserver;

import java.util.stream.IntStream;

public class AccountServiceImpl extends AccountServiceGrpc.AccountServiceImplBase {

    @Override
    public void retriveAccounts(Empty request, StreamObserver<Account> responseObserver) {
        IntStream.range(1, 10)
                .forEach(id -> {
                    Account account = Account.newBuilder()
                            .setId(id)
                            .setAgency(5482)
                            .setBrand("Another")
                            .setDigit(2)
                            .setNumber(265893)
                            .build();
                    responseObserver.onNext(account);
                });

        responseObserver.onCompleted();
    }

}
