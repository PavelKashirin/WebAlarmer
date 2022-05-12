package ru.sbrf.pprb.allo.aspect;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Timer;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author Pavel Kashirin
 */
@Component
@Endpoint(id = "allometrics")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Getter
@Setter
public class MetricsConfigurator {

    private final MetricClassBox metricClassBox;

    private final String ALLO_METRIC_FORMAT = "# HELP metrics_total full metrics" + System.lineSeparator() +
            "# TYPE metrics_total summary" + System.lineSeparator();
    private final String METRICS_TOTAL_COUNT = "metrics_total_count{class=\"%s\",method=\"%s\"}";
    private final String METRICS_TOTAL_TIMER = "metrics_total_timer{class=\"%s\",method=\"%s\"}";
    private final String METRICS_TOTAL_ERROR = "metrics_total_error{class=\"%s\",method=\"%s\"}";

    @ReadOperation
    public String getMetrics() {
        StringBuilder result = new StringBuilder();
        metricClassBox.getMap().forEach((x, y) -> {
            result.append(getFormat(y, x.split("#")[0], x.split("#")[1])).append(System.lineSeparator());
        });

        return result.toString();
    }

    private String getFormat(MetricObject metricObject, String className, String methodName) {
        return String.format(getMetricsFormatWithClassNameAndMethodName(className, methodName),
                metricObject.count(),
                metricObject.count(),
                metricObject.count());
    }

    private String getMetricsFormatWithClassNameAndMethodName(String className, String methodName) {
        return ALLO_METRIC_FORMAT +
                String.format(METRICS_TOTAL_COUNT, className, methodName) +
                " %s" + System.lineSeparator() +
                String.format(METRICS_TOTAL_TIMER, className, methodName) +
                " %s" + System.lineSeparator() +
                String.format(METRICS_TOTAL_ERROR, className, methodName) +
                " %s";
    }
}
