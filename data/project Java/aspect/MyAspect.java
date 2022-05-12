package ru.sbrf.pprb.allo.aspect;

import io.micrometer.core.instrument.Timer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class MyAspect {

    private final MetricClassBox metricClassBox;
    private long start;

    public MyAspect(@Autowired MetricClassBox metricClassBox) {
        this.metricClassBox = metricClassBox;
    }

    @Pointcut("@annotation(MyAspectAnno)")
//    @Pointcut("execution(* *.example(..))")
    public void allMethods() {
    }

    @Before("allMethods()")
    public void before() {
        start = System.currentTimeMillis();
        System.out.println("Время начала метода: " + start);
    }

    private MetricObject getMetricObject(String fullName) {
        return metricClassBox.getMap().get(fullName);
    }

    @After("allMethods()")
    public void after(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().toShortString().split("\\.")[0];
        String fullName = className + "#" + methodName;
        MetricObject metricObject = getMetricObject(fullName);
        metricObject.increment();
        long ping = System.currentTimeMillis() - start;
        System.out.println("Время работы: " + ping);
        System.out.println("Хэш объекта метрик: " + metricObject);
//        timer.record(ping, TimeUnit.MILLISECONDS);
//        System.out.println("Время работы метода по объекту Таймер: " + timer.mean(TimeUnit.MILLISECONDS));
//        System.out.println("Общее время работы: " + timer.totalTime(TimeUnit.MILLISECONDS));
    }

    @AfterThrowing(value = "allMethods()", throwing = "exception")
    public void recordFailedExecution(JoinPoint joinPoint, Exception exception) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().toShortString().split("\\.")[0];
        String fullName = className + "#" + methodName;
        MetricObject metricObject = getMetricObject(fullName);
        metricObject.increment();
        System.out.printf("Метод - %s, класса- %s, был аварийно завершен с исключением - %s\n",
                joinPoint.getSignature().getName(),
                joinPoint.getSourceLocation().getWithinType().getName(),
                exception);

    }
}
