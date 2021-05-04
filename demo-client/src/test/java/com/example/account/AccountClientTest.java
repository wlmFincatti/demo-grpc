package com.example.account;

import io.grpc.ManagedChannel;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.stub.StreamObserver;
import io.grpc.testing.GrpcCleanupRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.AdditionalAnswers.delegatesTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(JUnit4.class)
public class AccountClientTest {

    @Rule
    public final GrpcCleanupRule grpcCleanup = new GrpcCleanupRule();

    private final AccountServiceGrpc.AccountServiceImplBase serviceImpl =
            mock(AccountServiceGrpc.AccountServiceImplBase.class, delegatesTo(
                    new AccountServiceGrpc.AccountServiceImplBase() {
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
                    }));

    private AccountClient client;

    @Before
    public void setUp() throws Exception {
        // Generate a unique in-process server name.
        String serverName = InProcessServerBuilder.generateName();

        // Create a server, add service, start, and register for automatic graceful shutdown.
        grpcCleanup.register(InProcessServerBuilder
                .forName(serverName).directExecutor().addService(serviceImpl).build().start());

        // Create a client channel and register for automatic graceful shutdown.
        ManagedChannel channel = grpcCleanup.register(
                InProcessChannelBuilder.forName(serverName).directExecutor().build());

        // Create a AccoutnClient using the in-process channel;
        client = new AccountClient(channel);
    }

    @Test
    public void shouldRetrieveAccounts() {
        //when
        final List<AccountDto> result = client.getAccounts();

        //then
        verify(serviceImpl).retriveAccounts(any(), any());
        assertEquals(9, result.size());
    }
}