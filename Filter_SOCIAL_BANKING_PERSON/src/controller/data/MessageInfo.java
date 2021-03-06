/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package data;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2015-11-6")
public class MessageInfo implements org.apache.thrift.TBase<MessageInfo, MessageInfo._Fields>, java.io.Serializable, Cloneable, Comparable<MessageInfo> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("MessageInfo");

  private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("id", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField FB_PAGE_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("fb_page_name", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField FB_MESSAGE_FIELD_DESC = new org.apache.thrift.protocol.TField("fb_message", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField POST_MESSAGE_FIELD_DESC = new org.apache.thrift.protocol.TField("post_message", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField POST_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("post_type", org.apache.thrift.protocol.TType.I16, (short)5);
  private static final org.apache.thrift.protocol.TField FB_FROM_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("fb_from_name", org.apache.thrift.protocol.TType.STRING, (short)6);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new MessageInfoStandardSchemeFactory());
    schemes.put(TupleScheme.class, new MessageInfoTupleSchemeFactory());
  }

  public String id; // required
  public String fb_page_name; // required
  public String fb_message; // required
  public String post_message; // required
  public short post_type; // required
  public String fb_from_name; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ID((short)1, "id"),
    FB_PAGE_NAME((short)2, "fb_page_name"),
    FB_MESSAGE((short)3, "fb_message"),
    POST_MESSAGE((short)4, "post_message"),
    POST_TYPE((short)5, "post_type"),
    FB_FROM_NAME((short)6, "fb_from_name");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // ID
          return ID;
        case 2: // FB_PAGE_NAME
          return FB_PAGE_NAME;
        case 3: // FB_MESSAGE
          return FB_MESSAGE;
        case 4: // POST_MESSAGE
          return POST_MESSAGE;
        case 5: // POST_TYPE
          return POST_TYPE;
        case 6: // FB_FROM_NAME
          return FB_FROM_NAME;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __POST_TYPE_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("id", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.FB_PAGE_NAME, new org.apache.thrift.meta_data.FieldMetaData("fb_page_name", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.FB_MESSAGE, new org.apache.thrift.meta_data.FieldMetaData("fb_message", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.POST_MESSAGE, new org.apache.thrift.meta_data.FieldMetaData("post_message", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.POST_TYPE, new org.apache.thrift.meta_data.FieldMetaData("post_type", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I16)));
    tmpMap.put(_Fields.FB_FROM_NAME, new org.apache.thrift.meta_data.FieldMetaData("fb_from_name", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(MessageInfo.class, metaDataMap);
  }

  public MessageInfo() {
  }

  public MessageInfo(
    String id,
    String fb_page_name,
    String fb_message,
    String post_message,
    short post_type,
    String fb_from_name)
  {
    this();
    this.id = id;
    this.fb_page_name = fb_page_name;
    this.fb_message = fb_message;
    this.post_message = post_message;
    this.post_type = post_type;
    setPost_typeIsSet(true);
    this.fb_from_name = fb_from_name;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public MessageInfo(MessageInfo other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetId()) {
      this.id = other.id;
    }
    if (other.isSetFb_page_name()) {
      this.fb_page_name = other.fb_page_name;
    }
    if (other.isSetFb_message()) {
      this.fb_message = other.fb_message;
    }
    if (other.isSetPost_message()) {
      this.post_message = other.post_message;
    }
    this.post_type = other.post_type;
    if (other.isSetFb_from_name()) {
      this.fb_from_name = other.fb_from_name;
    }
  }

  public MessageInfo deepCopy() {
    return new MessageInfo(this);
  }

  @Override
  public void clear() {
    this.id = null;
    this.fb_page_name = null;
    this.fb_message = null;
    this.post_message = null;
    setPost_typeIsSet(false);
    this.post_type = 0;
    this.fb_from_name = null;
  }

  public String getId() {
    return this.id;
  }

  public MessageInfo setId(String id) {
    this.id = id;
    return this;
  }

  public void unsetId() {
    this.id = null;
  }

  /** Returns true if field id is set (has been assigned a value) and false otherwise */
  public boolean isSetId() {
    return this.id != null;
  }

  public void setIdIsSet(boolean value) {
    if (!value) {
      this.id = null;
    }
  }

  public String getFb_page_name() {
    return this.fb_page_name;
  }

  public MessageInfo setFb_page_name(String fb_page_name) {
    this.fb_page_name = fb_page_name;
    return this;
  }

  public void unsetFb_page_name() {
    this.fb_page_name = null;
  }

  /** Returns true if field fb_page_name is set (has been assigned a value) and false otherwise */
  public boolean isSetFb_page_name() {
    return this.fb_page_name != null;
  }

  public void setFb_page_nameIsSet(boolean value) {
    if (!value) {
      this.fb_page_name = null;
    }
  }

  public String getFb_message() {
    return this.fb_message;
  }

  public MessageInfo setFb_message(String fb_message) {
    this.fb_message = fb_message;
    return this;
  }

  public void unsetFb_message() {
    this.fb_message = null;
  }

  /** Returns true if field fb_message is set (has been assigned a value) and false otherwise */
  public boolean isSetFb_message() {
    return this.fb_message != null;
  }

  public void setFb_messageIsSet(boolean value) {
    if (!value) {
      this.fb_message = null;
    }
  }

  public String getPost_message() {
    return this.post_message;
  }

  public MessageInfo setPost_message(String post_message) {
    this.post_message = post_message;
    return this;
  }

  public void unsetPost_message() {
    this.post_message = null;
  }

  /** Returns true if field post_message is set (has been assigned a value) and false otherwise */
  public boolean isSetPost_message() {
    return this.post_message != null;
  }

  public void setPost_messageIsSet(boolean value) {
    if (!value) {
      this.post_message = null;
    }
  }

  public short getPost_type() {
    return this.post_type;
  }

  public MessageInfo setPost_type(short post_type) {
    this.post_type = post_type;
    setPost_typeIsSet(true);
    return this;
  }

  public void unsetPost_type() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __POST_TYPE_ISSET_ID);
  }

  /** Returns true if field post_type is set (has been assigned a value) and false otherwise */
  public boolean isSetPost_type() {
    return EncodingUtils.testBit(__isset_bitfield, __POST_TYPE_ISSET_ID);
  }

  public void setPost_typeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __POST_TYPE_ISSET_ID, value);
  }

  public String getFb_from_name() {
    return this.fb_from_name;
  }

  public MessageInfo setFb_from_name(String fb_from_name) {
    this.fb_from_name = fb_from_name;
    return this;
  }

  public void unsetFb_from_name() {
    this.fb_from_name = null;
  }

  /** Returns true if field fb_from_name is set (has been assigned a value) and false otherwise */
  public boolean isSetFb_from_name() {
    return this.fb_from_name != null;
  }

  public void setFb_from_nameIsSet(boolean value) {
    if (!value) {
      this.fb_from_name = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ID:
      if (value == null) {
        unsetId();
      } else {
        setId((String)value);
      }
      break;

    case FB_PAGE_NAME:
      if (value == null) {
        unsetFb_page_name();
      } else {
        setFb_page_name((String)value);
      }
      break;

    case FB_MESSAGE:
      if (value == null) {
        unsetFb_message();
      } else {
        setFb_message((String)value);
      }
      break;

    case POST_MESSAGE:
      if (value == null) {
        unsetPost_message();
      } else {
        setPost_message((String)value);
      }
      break;

    case POST_TYPE:
      if (value == null) {
        unsetPost_type();
      } else {
        setPost_type((Short)value);
      }
      break;

    case FB_FROM_NAME:
      if (value == null) {
        unsetFb_from_name();
      } else {
        setFb_from_name((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ID:
      return getId();

    case FB_PAGE_NAME:
      return getFb_page_name();

    case FB_MESSAGE:
      return getFb_message();

    case POST_MESSAGE:
      return getPost_message();

    case POST_TYPE:
      return Short.valueOf(getPost_type());

    case FB_FROM_NAME:
      return getFb_from_name();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ID:
      return isSetId();
    case FB_PAGE_NAME:
      return isSetFb_page_name();
    case FB_MESSAGE:
      return isSetFb_message();
    case POST_MESSAGE:
      return isSetPost_message();
    case POST_TYPE:
      return isSetPost_type();
    case FB_FROM_NAME:
      return isSetFb_from_name();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof MessageInfo)
      return this.equals((MessageInfo)that);
    return false;
  }

  public boolean equals(MessageInfo that) {
    if (that == null)
      return false;

    boolean this_present_id = true && this.isSetId();
    boolean that_present_id = true && that.isSetId();
    if (this_present_id || that_present_id) {
      if (!(this_present_id && that_present_id))
        return false;
      if (!this.id.equals(that.id))
        return false;
    }

    boolean this_present_fb_page_name = true && this.isSetFb_page_name();
    boolean that_present_fb_page_name = true && that.isSetFb_page_name();
    if (this_present_fb_page_name || that_present_fb_page_name) {
      if (!(this_present_fb_page_name && that_present_fb_page_name))
        return false;
      if (!this.fb_page_name.equals(that.fb_page_name))
        return false;
    }

    boolean this_present_fb_message = true && this.isSetFb_message();
    boolean that_present_fb_message = true && that.isSetFb_message();
    if (this_present_fb_message || that_present_fb_message) {
      if (!(this_present_fb_message && that_present_fb_message))
        return false;
      if (!this.fb_message.equals(that.fb_message))
        return false;
    }

    boolean this_present_post_message = true && this.isSetPost_message();
    boolean that_present_post_message = true && that.isSetPost_message();
    if (this_present_post_message || that_present_post_message) {
      if (!(this_present_post_message && that_present_post_message))
        return false;
      if (!this.post_message.equals(that.post_message))
        return false;
    }

    boolean this_present_post_type = true;
    boolean that_present_post_type = true;
    if (this_present_post_type || that_present_post_type) {
      if (!(this_present_post_type && that_present_post_type))
        return false;
      if (this.post_type != that.post_type)
        return false;
    }

    boolean this_present_fb_from_name = true && this.isSetFb_from_name();
    boolean that_present_fb_from_name = true && that.isSetFb_from_name();
    if (this_present_fb_from_name || that_present_fb_from_name) {
      if (!(this_present_fb_from_name && that_present_fb_from_name))
        return false;
      if (!this.fb_from_name.equals(that.fb_from_name))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_id = true && (isSetId());
    list.add(present_id);
    if (present_id)
      list.add(id);

    boolean present_fb_page_name = true && (isSetFb_page_name());
    list.add(present_fb_page_name);
    if (present_fb_page_name)
      list.add(fb_page_name);

    boolean present_fb_message = true && (isSetFb_message());
    list.add(present_fb_message);
    if (present_fb_message)
      list.add(fb_message);

    boolean present_post_message = true && (isSetPost_message());
    list.add(present_post_message);
    if (present_post_message)
      list.add(post_message);

    boolean present_post_type = true;
    list.add(present_post_type);
    if (present_post_type)
      list.add(post_type);

    boolean present_fb_from_name = true && (isSetFb_from_name());
    list.add(present_fb_from_name);
    if (present_fb_from_name)
      list.add(fb_from_name);

    return list.hashCode();
  }

  @Override
  public int compareTo(MessageInfo other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetId()).compareTo(other.isSetId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id, other.id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFb_page_name()).compareTo(other.isSetFb_page_name());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFb_page_name()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.fb_page_name, other.fb_page_name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFb_message()).compareTo(other.isSetFb_message());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFb_message()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.fb_message, other.fb_message);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPost_message()).compareTo(other.isSetPost_message());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPost_message()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.post_message, other.post_message);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPost_type()).compareTo(other.isSetPost_type());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPost_type()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.post_type, other.post_type);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFb_from_name()).compareTo(other.isSetFb_from_name());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFb_from_name()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.fb_from_name, other.fb_from_name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("MessageInfo(");
    boolean first = true;

    sb.append("id:");
    if (this.id == null) {
      sb.append("null");
    } else {
      sb.append(this.id);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("fb_page_name:");
    if (this.fb_page_name == null) {
      sb.append("null");
    } else {
      sb.append(this.fb_page_name);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("fb_message:");
    if (this.fb_message == null) {
      sb.append("null");
    } else {
      sb.append(this.fb_message);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("post_message:");
    if (this.post_message == null) {
      sb.append("null");
    } else {
      sb.append(this.post_message);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("post_type:");
    sb.append(this.post_type);
    first = false;
    if (!first) sb.append(", ");
    sb.append("fb_from_name:");
    if (this.fb_from_name == null) {
      sb.append("null");
    } else {
      sb.append(this.fb_from_name);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class MessageInfoStandardSchemeFactory implements SchemeFactory {
    public MessageInfoStandardScheme getScheme() {
      return new MessageInfoStandardScheme();
    }
  }

  private static class MessageInfoStandardScheme extends StandardScheme<MessageInfo> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, MessageInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.id = iprot.readString();
              struct.setIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // FB_PAGE_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.fb_page_name = iprot.readString();
              struct.setFb_page_nameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // FB_MESSAGE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.fb_message = iprot.readString();
              struct.setFb_messageIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // POST_MESSAGE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.post_message = iprot.readString();
              struct.setPost_messageIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // POST_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I16) {
              struct.post_type = iprot.readI16();
              struct.setPost_typeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // FB_FROM_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.fb_from_name = iprot.readString();
              struct.setFb_from_nameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, MessageInfo struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.id != null) {
        oprot.writeFieldBegin(ID_FIELD_DESC);
        oprot.writeString(struct.id);
        oprot.writeFieldEnd();
      }
      if (struct.fb_page_name != null) {
        oprot.writeFieldBegin(FB_PAGE_NAME_FIELD_DESC);
        oprot.writeString(struct.fb_page_name);
        oprot.writeFieldEnd();
      }
      if (struct.fb_message != null) {
        oprot.writeFieldBegin(FB_MESSAGE_FIELD_DESC);
        oprot.writeString(struct.fb_message);
        oprot.writeFieldEnd();
      }
      if (struct.post_message != null) {
        oprot.writeFieldBegin(POST_MESSAGE_FIELD_DESC);
        oprot.writeString(struct.post_message);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(POST_TYPE_FIELD_DESC);
      oprot.writeI16(struct.post_type);
      oprot.writeFieldEnd();
      if (struct.fb_from_name != null) {
        oprot.writeFieldBegin(FB_FROM_NAME_FIELD_DESC);
        oprot.writeString(struct.fb_from_name);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class MessageInfoTupleSchemeFactory implements SchemeFactory {
    public MessageInfoTupleScheme getScheme() {
      return new MessageInfoTupleScheme();
    }
  }

  private static class MessageInfoTupleScheme extends TupleScheme<MessageInfo> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, MessageInfo struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetId()) {
        optionals.set(0);
      }
      if (struct.isSetFb_page_name()) {
        optionals.set(1);
      }
      if (struct.isSetFb_message()) {
        optionals.set(2);
      }
      if (struct.isSetPost_message()) {
        optionals.set(3);
      }
      if (struct.isSetPost_type()) {
        optionals.set(4);
      }
      if (struct.isSetFb_from_name()) {
        optionals.set(5);
      }
      oprot.writeBitSet(optionals, 6);
      if (struct.isSetId()) {
        oprot.writeString(struct.id);
      }
      if (struct.isSetFb_page_name()) {
        oprot.writeString(struct.fb_page_name);
      }
      if (struct.isSetFb_message()) {
        oprot.writeString(struct.fb_message);
      }
      if (struct.isSetPost_message()) {
        oprot.writeString(struct.post_message);
      }
      if (struct.isSetPost_type()) {
        oprot.writeI16(struct.post_type);
      }
      if (struct.isSetFb_from_name()) {
        oprot.writeString(struct.fb_from_name);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, MessageInfo struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(6);
      if (incoming.get(0)) {
        struct.id = iprot.readString();
        struct.setIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.fb_page_name = iprot.readString();
        struct.setFb_page_nameIsSet(true);
      }
      if (incoming.get(2)) {
        struct.fb_message = iprot.readString();
        struct.setFb_messageIsSet(true);
      }
      if (incoming.get(3)) {
        struct.post_message = iprot.readString();
        struct.setPost_messageIsSet(true);
      }
      if (incoming.get(4)) {
        struct.post_type = iprot.readI16();
        struct.setPost_typeIsSet(true);
      }
      if (incoming.get(5)) {
        struct.fb_from_name = iprot.readString();
        struct.setFb_from_nameIsSet(true);
      }
    }
  }

}

