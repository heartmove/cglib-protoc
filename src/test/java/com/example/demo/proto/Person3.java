// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: PersonProto3.proto

package com.example.demo.proto;

/**
 * Protobuf type {@code Person3}
 */
public final class Person3 extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Person3)
        Person3OrBuilder {
private static final long serialVersionUID = 0L;
  // Use Person3.newBuilder() to construct.
  private Person3(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Person3() {
    jobName_ = "";
    cars_ = com.google.protobuf.LazyStringArrayList.EMPTY;
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new Person3();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Person3(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            age_ = input.readInt32();
            break;
          }
          case 18: {
            com.google.protobuf.Int32Value.Builder subBuilder = null;
            if (height_ != null) {
              subBuilder = height_.toBuilder();
            }
            height_ = input.readMessage(com.google.protobuf.Int32Value.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(height_);
              height_ = subBuilder.buildPartial();
            }

            break;
          }
          case 26: {
            String s = input.readStringRequireUtf8();

            jobName_ = s;
            break;
          }
          case 34: {
            String s = input.readStringRequireUtf8();
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              cars_ = new com.google.protobuf.LazyStringArrayList();
              mutable_bitField0_ |= 0x00000001;
            }
            cars_.add(s);
            break;
          }
          case 40: {

            id_ = input.readInt64();
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        cars_ = cars_.getUnmodifiableView();
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return PersonProto3.internal_static_Person3_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return PersonProto3.internal_static_Person3_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            Person3.class, Builder.class);
  }

  public static final int ID_FIELD_NUMBER = 5;
  private long id_;
  /**
   * <code>int64 id = 5;</code>
   * @return The id.
   */
  @Override
  public long getId() {
    return id_;
  }

  public static final int AGE_FIELD_NUMBER = 1;
  private int age_;
  /**
   * <code>int32 age = 1;</code>
   * @return The age.
   */
  @Override
  public int getAge() {
    return age_;
  }

  public static final int HEIGHT_FIELD_NUMBER = 2;
  private com.google.protobuf.Int32Value height_;
  /**
   * <code>.google.protobuf.Int32Value height = 2;</code>
   * @return Whether the height field is set.
   */
  @Override
  public boolean hasHeight() {
    return height_ != null;
  }
  /**
   * <code>.google.protobuf.Int32Value height = 2;</code>
   * @return The height.
   */
  @Override
  public com.google.protobuf.Int32Value getHeight() {
    return height_ == null ? com.google.protobuf.Int32Value.getDefaultInstance() : height_;
  }
  /**
   * <code>.google.protobuf.Int32Value height = 2;</code>
   */
  @Override
  public com.google.protobuf.Int32ValueOrBuilder getHeightOrBuilder() {
    return getHeight();
  }

  public static final int JOB_NAME_FIELD_NUMBER = 3;
  private volatile Object jobName_;
  /**
   * <code>string job_name = 3;</code>
   * @return The jobName.
   */
  @Override
  public String getJobName() {
    Object ref = jobName_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      jobName_ = s;
      return s;
    }
  }
  /**
   * <code>string job_name = 3;</code>
   * @return The bytes for jobName.
   */
  @Override
  public com.google.protobuf.ByteString
      getJobNameBytes() {
    Object ref = jobName_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      jobName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int CARS_FIELD_NUMBER = 4;
  private com.google.protobuf.LazyStringList cars_;
  /**
   * <pre>
   * required string name = 4;
   * </pre>
   *
   * <code>repeated string cars = 4;</code>
   * @return A list containing the cars.
   */
  public com.google.protobuf.ProtocolStringList
      getCarsList() {
    return cars_;
  }
  /**
   * <pre>
   * required string name = 4;
   * </pre>
   *
   * <code>repeated string cars = 4;</code>
   * @return The count of cars.
   */
  public int getCarsCount() {
    return cars_.size();
  }
  /**
   * <pre>
   * required string name = 4;
   * </pre>
   *
   * <code>repeated string cars = 4;</code>
   * @param index The index of the element to return.
   * @return The cars at the given index.
   */
  public String getCars(int index) {
    return cars_.get(index);
  }
  /**
   * <pre>
   * required string name = 4;
   * </pre>
   *
   * <code>repeated string cars = 4;</code>
   * @param index The index of the value to return.
   * @return The bytes of the cars at the given index.
   */
  public com.google.protobuf.ByteString
      getCarsBytes(int index) {
    return cars_.getByteString(index);
  }

  private byte memoizedIsInitialized = -1;
  @Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (age_ != 0) {
      output.writeInt32(1, age_);
    }
    if (height_ != null) {
      output.writeMessage(2, getHeight());
    }
    if (!getJobNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, jobName_);
    }
    for (int i = 0; i < cars_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, cars_.getRaw(i));
    }
    if (id_ != 0L) {
      output.writeInt64(5, id_);
    }
    unknownFields.writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (age_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, age_);
    }
    if (height_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getHeight());
    }
    if (!getJobNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, jobName_);
    }
    {
      int dataSize = 0;
      for (int i = 0; i < cars_.size(); i++) {
        dataSize += computeStringSizeNoTag(cars_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getCarsList().size();
    }
    if (id_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(5, id_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof Person3)) {
      return super.equals(obj);
    }
    Person3 other = (Person3) obj;

    if (getId()
        != other.getId()) return false;
    if (getAge()
        != other.getAge()) return false;
    if (hasHeight() != other.hasHeight()) return false;
    if (hasHeight()) {
      if (!getHeight()
          .equals(other.getHeight())) return false;
    }
    if (!getJobName()
        .equals(other.getJobName())) return false;
    if (!getCarsList()
        .equals(other.getCarsList())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + ID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getId());
    hash = (37 * hash) + AGE_FIELD_NUMBER;
    hash = (53 * hash) + getAge();
    if (hasHeight()) {
      hash = (37 * hash) + HEIGHT_FIELD_NUMBER;
      hash = (53 * hash) + getHeight().hashCode();
    }
    hash = (37 * hash) + JOB_NAME_FIELD_NUMBER;
    hash = (53 * hash) + getJobName().hashCode();
    if (getCarsCount() > 0) {
      hash = (37 * hash) + CARS_FIELD_NUMBER;
      hash = (53 * hash) + getCarsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static Person3 parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static Person3 parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static Person3 parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static Person3 parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static Person3 parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static Person3 parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static Person3 parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static Person3 parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static Person3 parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static Person3 parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static Person3 parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static Person3 parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(Person3 prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @Override
  protected Builder newBuilderForType(
      BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code Person3}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Person3)
      Person3OrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return PersonProto3.internal_static_Person3_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return PersonProto3.internal_static_Person3_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Person3.class, Builder.class);
    }

    // Construct using com.example.demo.proto.Person3.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @Override
    public Builder clear() {
      super.clear();
      id_ = 0L;

      age_ = 0;

      if (heightBuilder_ == null) {
        height_ = null;
      } else {
        height_ = null;
        heightBuilder_ = null;
      }
      jobName_ = "";

      cars_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return PersonProto3.internal_static_Person3_descriptor;
    }

    @Override
    public Person3 getDefaultInstanceForType() {
      return Person3.getDefaultInstance();
    }

    @Override
    public Person3 build() {
      Person3 result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public Person3 buildPartial() {
      Person3 result = new Person3(this);
      int from_bitField0_ = bitField0_;
      result.id_ = id_;
      result.age_ = age_;
      if (heightBuilder_ == null) {
        result.height_ = height_;
      } else {
        result.height_ = heightBuilder_.build();
      }
      result.jobName_ = jobName_;
      if (((bitField0_ & 0x00000001) != 0)) {
        cars_ = cars_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.cars_ = cars_;
      onBuilt();
      return result;
    }

    @Override
    public Builder clone() {
      return super.clone();
    }
    @Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.setField(field, value);
    }
    @Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.addRepeatedField(field, value);
    }
    @Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof Person3) {
        return mergeFrom((Person3)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(Person3 other) {
      if (other == Person3.getDefaultInstance()) return this;
      if (other.getId() != 0L) {
        setId(other.getId());
      }
      if (other.getAge() != 0) {
        setAge(other.getAge());
      }
      if (other.hasHeight()) {
        mergeHeight(other.getHeight());
      }
      if (!other.getJobName().isEmpty()) {
        jobName_ = other.jobName_;
        onChanged();
      }
      if (!other.cars_.isEmpty()) {
        if (cars_.isEmpty()) {
          cars_ = other.cars_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureCarsIsMutable();
          cars_.addAll(other.cars_);
        }
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @Override
    public final boolean isInitialized() {
      return true;
    }

    @Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      Person3 parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (Person3) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private long id_ ;
    /**
     * <code>int64 id = 5;</code>
     * @return The id.
     */
    @Override
    public long getId() {
      return id_;
    }
    /**
     * <code>int64 id = 5;</code>
     * @param value The id to set.
     * @return This builder for chaining.
     */
    public Builder setId(long value) {
      
      id_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 id = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearId() {
      
      id_ = 0L;
      onChanged();
      return this;
    }

    private int age_ ;
    /**
     * <code>int32 age = 1;</code>
     * @return The age.
     */
    @Override
    public int getAge() {
      return age_;
    }
    /**
     * <code>int32 age = 1;</code>
     * @param value The age to set.
     * @return This builder for chaining.
     */
    public Builder setAge(int value) {
      
      age_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 age = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearAge() {
      
      age_ = 0;
      onChanged();
      return this;
    }

    private com.google.protobuf.Int32Value height_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Int32Value, com.google.protobuf.Int32Value.Builder, com.google.protobuf.Int32ValueOrBuilder> heightBuilder_;
    /**
     * <code>.google.protobuf.Int32Value height = 2;</code>
     * @return Whether the height field is set.
     */
    public boolean hasHeight() {
      return heightBuilder_ != null || height_ != null;
    }
    /**
     * <code>.google.protobuf.Int32Value height = 2;</code>
     * @return The height.
     */
    public com.google.protobuf.Int32Value getHeight() {
      if (heightBuilder_ == null) {
        return height_ == null ? com.google.protobuf.Int32Value.getDefaultInstance() : height_;
      } else {
        return heightBuilder_.getMessage();
      }
    }
    /**
     * <code>.google.protobuf.Int32Value height = 2;</code>
     */
    public Builder setHeight(com.google.protobuf.Int32Value value) {
      if (heightBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        height_ = value;
        onChanged();
      } else {
        heightBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Int32Value height = 2;</code>
     */
    public Builder setHeight(
        com.google.protobuf.Int32Value.Builder builderForValue) {
      if (heightBuilder_ == null) {
        height_ = builderForValue.build();
        onChanged();
      } else {
        heightBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Int32Value height = 2;</code>
     */
    public Builder mergeHeight(com.google.protobuf.Int32Value value) {
      if (heightBuilder_ == null) {
        if (height_ != null) {
          height_ =
            com.google.protobuf.Int32Value.newBuilder(height_).mergeFrom(value).buildPartial();
        } else {
          height_ = value;
        }
        onChanged();
      } else {
        heightBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Int32Value height = 2;</code>
     */
    public Builder clearHeight() {
      if (heightBuilder_ == null) {
        height_ = null;
        onChanged();
      } else {
        height_ = null;
        heightBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Int32Value height = 2;</code>
     */
    public com.google.protobuf.Int32Value.Builder getHeightBuilder() {
      
      onChanged();
      return getHeightFieldBuilder().getBuilder();
    }
    /**
     * <code>.google.protobuf.Int32Value height = 2;</code>
     */
    public com.google.protobuf.Int32ValueOrBuilder getHeightOrBuilder() {
      if (heightBuilder_ != null) {
        return heightBuilder_.getMessageOrBuilder();
      } else {
        return height_ == null ?
            com.google.protobuf.Int32Value.getDefaultInstance() : height_;
      }
    }
    /**
     * <code>.google.protobuf.Int32Value height = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Int32Value, com.google.protobuf.Int32Value.Builder, com.google.protobuf.Int32ValueOrBuilder> 
        getHeightFieldBuilder() {
      if (heightBuilder_ == null) {
        heightBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.protobuf.Int32Value, com.google.protobuf.Int32Value.Builder, com.google.protobuf.Int32ValueOrBuilder>(
                getHeight(),
                getParentForChildren(),
                isClean());
        height_ = null;
      }
      return heightBuilder_;
    }

    private Object jobName_ = "";
    /**
     * <code>string job_name = 3;</code>
     * @return The jobName.
     */
    public String getJobName() {
      Object ref = jobName_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        jobName_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string job_name = 3;</code>
     * @return The bytes for jobName.
     */
    public com.google.protobuf.ByteString
        getJobNameBytes() {
      Object ref = jobName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        jobName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string job_name = 3;</code>
     * @param value The jobName to set.
     * @return This builder for chaining.
     */
    public Builder setJobName(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      jobName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string job_name = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearJobName() {
      
      jobName_ = getDefaultInstance().getJobName();
      onChanged();
      return this;
    }
    /**
     * <code>string job_name = 3;</code>
     * @param value The bytes for jobName to set.
     * @return This builder for chaining.
     */
    public Builder setJobNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      jobName_ = value;
      onChanged();
      return this;
    }

    private com.google.protobuf.LazyStringList cars_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensureCarsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        cars_ = new com.google.protobuf.LazyStringArrayList(cars_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <pre>
     * required string name = 4;
     * </pre>
     *
     * <code>repeated string cars = 4;</code>
     * @return A list containing the cars.
     */
    public com.google.protobuf.ProtocolStringList
        getCarsList() {
      return cars_.getUnmodifiableView();
    }
    /**
     * <pre>
     * required string name = 4;
     * </pre>
     *
     * <code>repeated string cars = 4;</code>
     * @return The count of cars.
     */
    public int getCarsCount() {
      return cars_.size();
    }
    /**
     * <pre>
     * required string name = 4;
     * </pre>
     *
     * <code>repeated string cars = 4;</code>
     * @param index The index of the element to return.
     * @return The cars at the given index.
     */
    public String getCars(int index) {
      return cars_.get(index);
    }
    /**
     * <pre>
     * required string name = 4;
     * </pre>
     *
     * <code>repeated string cars = 4;</code>
     * @param index The index of the value to return.
     * @return The bytes of the cars at the given index.
     */
    public com.google.protobuf.ByteString
        getCarsBytes(int index) {
      return cars_.getByteString(index);
    }
    /**
     * <pre>
     * required string name = 4;
     * </pre>
     *
     * <code>repeated string cars = 4;</code>
     * @param index The index to set the value at.
     * @param value The cars to set.
     * @return This builder for chaining.
     */
    public Builder setCars(
        int index, String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureCarsIsMutable();
      cars_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * required string name = 4;
     * </pre>
     *
     * <code>repeated string cars = 4;</code>
     * @param value The cars to add.
     * @return This builder for chaining.
     */
    public Builder addCars(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureCarsIsMutable();
      cars_.add(value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * required string name = 4;
     * </pre>
     *
     * <code>repeated string cars = 4;</code>
     * @param values The cars to add.
     * @return This builder for chaining.
     */
    public Builder addAllCars(
        Iterable<String> values) {
      ensureCarsIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, cars_);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * required string name = 4;
     * </pre>
     *
     * <code>repeated string cars = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearCars() {
      cars_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * required string name = 4;
     * </pre>
     *
     * <code>repeated string cars = 4;</code>
     * @param value The bytes of the cars to add.
     * @return This builder for chaining.
     */
    public Builder addCarsBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      ensureCarsIsMutable();
      cars_.add(value);
      onChanged();
      return this;
    }
    @Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:Person3)
  }

  // @@protoc_insertion_point(class_scope:Person3)
  private static final Person3 DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new Person3();
  }

  public static Person3 getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Person3>
      PARSER = new com.google.protobuf.AbstractParser<Person3>() {
    @Override
    public Person3 parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Person3(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Person3> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<Person3> getParserForType() {
    return PARSER;
  }

  @Override
  public Person3 getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
