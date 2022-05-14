import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.ujalan.overlord.OverlordModule;
import com.ujalan.overlord.contracts.Environment;

public class Main {

  public static void main(String[] args) {
    try {
      run();
    } catch (Exception e) {
      e.printStackTrace(); // line 31
    }
  }

  private static void run() {
    Injector injector = Guice.createInjector(new AbstractModule() {
      @Override
      protected void configure() {
        install(new OverlordModule());
        bind(Environment.class).to(Env.class);
      }
    });
    Service service = injector.getInstance(Service.class);
    ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
    exec.scheduleAtFixedRate(service::request, 0, 2, TimeUnit.MICROSECONDS);
    while (true) {
    }
  }
}
