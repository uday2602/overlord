

import javax.annotation.Generated;

import com.uday.overlord.Key;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_Key extends Key {

  private final String metricName;
  private final String tagsHash;

  AutoValue_Key(
      String metricName,
      String tagsHash) {
    if (metricName == null) {
      throw new NullPointerException("Null metricName");
    }
    this.metricName = metricName;
    if (tagsHash == null) {
      throw new NullPointerException("Null tagsHash");
    }
    this.tagsHash = tagsHash;
  }

  @Override
  String metricName() {
    return metricName;
  }

  @Override
  String tagsHash() {
    return tagsHash;
  }

  @Override
  public String toString() {
    return "com.uday.overlord.Key{"
        + "metricName=" + metricName + ", "
        + "tagsHash=" + tagsHash
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Key) {
      Key that = (Key) o;
      return (this.metricName.equals(that.metricName()))
           && (this.tagsHash.equals(that.tagsHash()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.metricName.hashCode();
    h *= 1000003;
    h ^= this.tagsHash.hashCode();
    return h;
  }

}
