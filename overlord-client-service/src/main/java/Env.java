import com.google.common.collect.ImmutableMap;
import com.uday.overlord.contracts.Environment;

import java.util.Map;

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
