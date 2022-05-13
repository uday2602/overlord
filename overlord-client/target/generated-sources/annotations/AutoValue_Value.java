

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Generated;

import com.uday.overlord.Value;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_Value extends Value {

  private final String metricName;
  private final Map<String, String> tags;
  private final AtomicInteger counter;

  AutoValue_Value(
      String metricName,
      Map<String, String> tags,
      AtomicInteger counter) {
    if (metricName == null) {
      throw new NullPointerException("Null metricName");
    }
    this.metricName = metricName;
    if (tags == null) {
      throw new NullPointerException("Null tags");
    }
    this.tags = tags;
    if (counter == null) {
      throw new NullPointerException("Null counter");
    }
    this.counter = counter;
  }

  @Override
  String metricName() {
    return metricName;
  }

  @Override
  Map<String, String> tags() {
    return tags;
  }

  @Override
  AtomicInteger counter() {
    return counter;
  }

  @Override
  public String toString() {
    return "com.uday.overlord.Value{"
        + "metricName=" + metricName + ", "
        + "tags=" + tags + ", "
        + "counter=" + counter
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Value) {
      Value that = (Value) o;
      return (this.metricName.equals(that.metricName()))
           && (this.tags.equals(that.tags()))
           && (this.counter.equals(that.counter()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.metricName.hashCode();
    h *= 1000003;
    h ^= this.tags.hashCode();
    h *= 1000003;
    h ^= this.counter.hashCode();
    return h;
  }

}
