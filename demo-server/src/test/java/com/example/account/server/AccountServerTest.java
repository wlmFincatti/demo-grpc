package com.example.account.server;

import com.example.account.Account;
import com.example.account.AccountServiceGrpc;
import com.example.account.AccountServiceImpl;
import com.example.account.Empty;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.testing.GrpcCleanupRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class AccountServerTest {

    @Rule
    public final GrpcCleanupRule grpcCleanup = new GrpcCleanupRule();

    @Test
    public void shouldReturnAccounts() throws IOException {
        // Generate a unique in-process server name.
        String serverName = InProcessServerBuilder.generateName();

        // Create a server, add service, start, and register for automatic graceful shutdown.
        grpcCleanup.register(InProcessServerBuilder
                .forName(serverName).directExecutor().addService(new AccountServiceImpl()).build()).start();

        AccountServiceGrpc.AccountServiceBlockingStub blockingStub = AccountServiceGrpc.newBlockingStub(
                // Create a client channel and register for automatic graceful shutdown.
                grpcCleanup.register(InProcessChannelBuilder.forName(serverName).directExecutor().build()));


        final Iterator<Account> accounsResult = blockingStub.retriveAccounts(Empty.newBuilder().build());

       validateAccount(accounsResult);
    }

    private void validateAccount(Iterator<Account> accounts){
        accounts.forEachRemaining(
                account->{
                    assertEquals("Another", account.getBrand());
                }
        );
    }
}