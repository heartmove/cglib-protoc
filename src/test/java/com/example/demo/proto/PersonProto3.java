// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: PersonProto3.proto

package com.example.demo.proto;

public final class PersonProto3 {
  private PersonProto3() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Person3_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Person3_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\022PersonProto3.proto\032\036google/protobuf/wr" +
      "appers.proto\"o\n\007Person3\022\n\n\002id\030\005 \001(\003\022\013\n\003a" +
      "ge\030\001 \001(\005\022+\n\006height\030\002 \001(\0132\033.google.protob" +
      "uf.Int32Value\022\020\n\010job_name\030\003 \001(\t\022\014\n\004cars\030" +
      "\004 \003(\t2,\n\rPersonService\022\033\n\003add\022\010.Person3\032" +
      "\010.Person3\"\000B\032\n\026com.example.demo.protoP\001b" +
      "\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.WrappersProto.getDescriptor(),
        });
    internal_static_Person3_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Person3_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Person3_descriptor,
        new String[] { "Id", "Age", "Height", "JobName", "Cars", });
    com.google.protobuf.WrappersProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
