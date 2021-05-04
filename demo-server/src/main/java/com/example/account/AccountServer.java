package com.example.account;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class AccountServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder
                .forPort(50051)
                .addService(new AccountServiceImpl())
                .build();

        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.print("closing server");
            server.shutdown();
        }));

        server.awaitTermination();
    }
}
