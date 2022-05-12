//package ru.sbrf.pprb.allo.config.metrics;
//
//import io.micrometer.core.instrument.Counter;
//import io.micrometer.core.instrument.MeterRegistry;
//import io.micrometer.core.instrument.Timer;
//import io.micrometer.core.instrument.binder.system.ProcessorMetrics;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
//import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
//import org.springframework.stereotype.Component;
//import ru.sbrf.pprb.allo.controller.Dto;
//
//import javax.annotation.PostConstruct;
//import java.util.Arrays;
//import java.util.Map;
//import java.util.concurrent.TimeUnit;
//
//import static ru.sbrf.pprb.allo.config.metrics.MetricsType.METRICS_COUNTER_DESCRIPTION;
//import static ru.sbrf.pprb.allo.config.metrics.MetricsType.METRICS_COUNTER_ID;
//import static ru.sbrf.pprb.allo.config.metrics.MetricsType.METRICS_TIMER_DESCRIPTION;
//import static ru.sbrf.pprb.allo.config.metrics.MetricsType.METRICS_TIMER_ID;
//import static ru.sbrf.pprb.allo.config.metrics.MetricsType.getMetricsFormatRootControllerGetUi;
//
//
//@Component
//@Endpoint(id = "allometrics")
//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
//public class MetricConfig {
//
//    public static Counter simpleCounter;
//    public static Timer simpleTimer;
//    private final MeterRegistry meterRegistry;
//
//    /**
//     * Инициальзация метрик типа Counter
//     */
//    @PostConstruct
//    public void init() {
//        simpleCounter = Counter.builder(METRICS_COUNTER_ID)
//                .description(METRICS_COUNTER_DESCRIPTION)
//                .register(meterRegistry);
//        simpleTimer = Timer.builder(METRICS_TIMER_ID)
//                .description(METRICS_TIMER_DESCRIPTION)
//                .register(meterRegistry);
//    }
//
//
//    @ReadOperation
////    public Counter getDto() {
//    public String getDto() {
////    public Dto getDto() {
////        Dto dto = new Dto();
////        dto.setValue(simpleCounter.count());
////        dto.setTimestamp(System.currentTimeMillis());
////        dto.set__name__("up");
//
////        return simpleCounter;
//
//        String format = String.format(getMetricsFormatRootControllerGetUi(),
//                simpleTimer.count(),
//                simpleTimer.mean(TimeUnit.MILLISECONDS),
//                simpleCounter.count());
//
//        simpleTimer.measure().forEach(System.out::println);
//        return format;
//    }
//}
