package com.example.account;

import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: com.example.account/com.example.account.proto")
public final class AccountServiceGrpc {

  private AccountServiceGrpc() {}

  public static final String SERVICE_NAME = "AccountService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<Empty,
          Account> METHOD_RETRIVE_ACCOUNTS =
      io.grpc.MethodDescriptor.<Empty, Account>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "AccountService", "RetriveAccounts"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Empty.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Account.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AccountServiceStub newStub(io.grpc.Channel channel) {
    return new AccountServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AccountServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AccountServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AccountServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AccountServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class AccountServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void retriveAccounts(Empty request,
                                io.grpc.stub.StreamObserver<Account> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_RETRIVE_ACCOUNTS, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_RETRIVE_ACCOUNTS,
            asyncServerStreamingCall(
              new MethodHandlers<
                      Empty,
                      Account>(
                  this, METHODID_RETRIVE_ACCOUNTS)))
          .build();
    }
  }

  /**
   */
  public static final class AccountServiceStub extends io.grpc.stub.AbstractStub<AccountServiceStub> {
    private AccountServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AccountServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AccountServiceStub(channel, callOptions);
    }

    /**
     */
    public void retriveAccounts(Empty request,
                                io.grpc.stub.StreamObserver<Account> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_RETRIVE_ACCOUNTS, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AccountServiceBlockingStub extends io.grpc.stub.AbstractStub<AccountServiceBlockingStub> {
    private AccountServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AccountServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AccountServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<Account> retriveAccounts(
        Empty request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_RETRIVE_ACCOUNTS, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AccountServiceFutureStub extends io.grpc.stub.AbstractStub<AccountServiceFutureStub> {
    private AccountServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AccountServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AccountServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_RETRIVE_ACCOUNTS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AccountServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AccountServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_RETRIVE_ACCOUNTS:
          serviceImpl.retriveAccounts((Empty) request,
              (io.grpc.stub.StreamObserver<Account>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class AccountServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return AccountOuterClass.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (AccountServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AccountServiceDescriptorSupplier())
              .addMethod(METHOD_RETRIVE_ACCOUNTS)
              .build();
        }
      }
    }
    return result;
  }
}
