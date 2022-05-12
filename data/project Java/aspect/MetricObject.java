package ru.sbrf.pprb.allo.aspect;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.composite.CompositeMeterRegistry;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicLong;

import static ru.sbrf.pprb.allo.aspect.Config.APP_NAME;
import static ru.sbrf.pprb.allo.aspect.Config.MODULE_NAME;

@Getter
public class MetricObject {

//    private final static MeterRegistry METER_REGISTRY = new CompositeMeterRegistry();
//
//    @Getter
//    private final Timer timer;
//    @Getter
//    private final Counter counter;
//
//    public MetricObject(String className, String methodName) {
//        String timerId = "%s-%s-%s-%s-timer-metrics";
//        String timerDescription = "Counts the execution time of the %s controller in %s method";
//        timer = Timer.builder(String.format(timerId, MODULE_NAME, APP_NAME, className, methodName))
//                .description(String.format(timerDescription, className, methodName))
//                .register(METER_REGISTRY);
//
//        // Название метрики модуль-приложение-класс-метод-...
//        String counterId = "%s-%s-%s-%s-count-error-metrics";
//        String counterDescription = "Counts the number of errors in %s controller in %s method";
//        counter = Counter.builder(String.format(counterId, MODULE_NAME, APP_NAME, className, methodName))
//                .description(String.format(counterDescription, className, methodName))
//                .register(METER_REGISTRY);
//    }

    private final AtomicLong count = new AtomicLong(0);

    public long count() {
        return count.get();
    }

    public void increment() {
        count.addAndGet(1);
    }
}
