package ru.sbrf.pprb.allo.aspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ru.sbrf.pprb.allo.aspect.Config.ANNO_NAME;

public class MetricClassBox {
    private final List<Class<?>> objects;
    private final Map<String, MetricObject> result;

    public MetricClassBox() {
        objects = new ArrayList<>();
        result = new HashMap<>();
    }

    public void addObject(Class<?> clazz) {
        objects.add(clazz);
    }

    public Map<String, MetricObject> getMap() {
        if (result.isEmpty()) {
            objects.forEach(clazz -> result.putAll(getPairFromObject(clazz)));
        }
        return result;
    }

    private Map<String, MetricObject> getPairFromObject(Class<?> clazz) {
        Map<String, MetricObject> result = new HashMap<>();

        String className = clazz.getSimpleName();
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            String methodName = method.getName();
            Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
            String annotationInString = Arrays.toString(declaredAnnotations);
            if (annotationInString.contains(ANNO_NAME)) {
                String allName = className + "#" + methodName;
                result.put(allName, new MetricObject());
            }
        }
        return result;
    }
}
