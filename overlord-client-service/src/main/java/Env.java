import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.uday.overlord.contracts.Environment;

public class Env implements Environment {
  @Override
  public Map<String, String> getTags() {
    return ImmutableMap.<String, String>builder()
        .put("env", "prod")
        .put("host", "host_a")
        .put("service", "service_a")
        .build();
  }
}
