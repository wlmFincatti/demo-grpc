// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: com.example.account/com.example.account.proto

package com.example.account;

public final class AccountOuterClass {
  private AccountOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Account_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Account_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Empty_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Empty_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\025account/com.example.account.proto\"S\n\007Account\022\n\n\002id" +
      "\030\001 \001(\005\022\r\n\005brand\030\002 \001(\t\022\016\n\006agency\030\003 \001(\005\022\016\n" +
      "\006number\030\004 \001(\005\022\r\n\005digit\030\005 \001(\005\"\007\n\005Empty29\n" +
      "\016AccountService\022\'\n\017RetriveAccounts\022\006.Emp" +
      "ty\032\010.Account\"\0000\001B\027\n\023com.example.accountP" +
      "\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_Account_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Account_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Account_descriptor,
        new java.lang.String[] { "Id", "Brand", "Agency", "Number", "Digit", });
    internal_static_Empty_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Empty_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Empty_descriptor,
        new java.lang.String[] { });
  }

  // @@protoc_insertion_point(outer_class_scope)
}