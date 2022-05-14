import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.ujalan.overlord.contracts.Environment;

public class Env implements Environment {
  @Override
  public Map<String, String> getTags() {
    return ImmutableMap.<String, String>builder()
        .put("env", "prod")
        .put("host", "ujalan-local-machine")
        .put("service", "overlord-client-service")
        .build();
  }
}
