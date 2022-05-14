import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.ujalan.overlord.contracts.Environment;

public class Env implements Environment {

  public static final String SERVICE = "overlord-client-service";
  public static final String MACHINE = "ujalan-local-machine";
  public static final String ENV = "prod";

  @Override
  public String getService() {
    return SERVICE;
  }

  @Override
  public String getHost() {
    return MACHINE;
  }

  @Override
  public String getEnvironment() {
    return ENV;
  }
}
