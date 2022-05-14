import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.ujalan.overlord.contracts.Overlord;

class Service {
  @Inject
  private Overlord overlord;

  public void request() {
    overlord.increment("metric_1", ImmutableMap.of("region", "delhi"));
    overlord.increment("metric_1", ImmutableMap.of("region", "delhi"));
    overlord.increment("metric_1", ImmutableMap.of("region", "bangalore"));
    overlord.increment("metric_2", ImmutableMap.of("region", "delhi"));
    overlord.increment("metric_2", ImmutableMap.of("region", "bangalore"));
  }
}
