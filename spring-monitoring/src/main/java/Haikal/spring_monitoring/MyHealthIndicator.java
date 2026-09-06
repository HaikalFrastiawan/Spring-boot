package Haikal.spring_monitoring;

import org.jspecify.annotations.Nullable;
import org.springframework.boot.health.contributor.AbstractHealthIndicator;
import org.springframework.boot.health.contributor.Health;
import org.springframework.boot.health.contributor.Status;
import org.springframework.stereotype.Component;

@Component
public class MyHealthIndicator extends AbstractHealthIndicator {


    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        builder.status(Status.UP);
        builder.withDetail("app","ok");
        builder.withDetail("error", "no-error");
    }
}
