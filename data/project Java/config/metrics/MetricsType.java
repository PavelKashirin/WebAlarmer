package ru.sbrf.pprb.allo.config.metrics;

public class MetricsType {
    private static final String ALLO_METRIC_FORMAT = "# HELP metrics_total full metrics\n# TYPE metrics_total summary\n";
    private static final String METRICS_TOTAL_COUNT = "metrics_total_count{class=\"%s\",method=\"%s\"}";
    private static final String METRICS_TOTAL_TIMER = "metrics_total_timer{class=\"%s\",method=\"%s\"}";
    private static final String METRICS_TOTAL_ERROR = "metrics_total_error{class=\"%s\",method=\"%s\"}";

    public static final String METRICS_COUNTER_ID = "allo-count-metrics";
    public static final String METRICS_COUNTER_DESCRIPTION = "Counts the number of calls";
    public static final String METRICS_TIMER_ID = "allo-timer-metrics";
    public static final String METRICS_TIMER_DESCRIPTION = "Counts the execution time of the method";

    private static final String ROOT_CONTROLLER_NAME = "RootController";
    private static final String ROOT_CONTROLLER_GETUI_METHOD = "getUi";


    public static String getMetricsFormatRootControllerGetUi() {
        return getMetricsFormatWithControllerNameAndMethodName(ROOT_CONTROLLER_NAME, ROOT_CONTROLLER_GETUI_METHOD);
    }

    private static String getMetricsFormatWithControllerNameAndMethodName(String controllerName, String methodName) {
        return ALLO_METRIC_FORMAT +
                String.format(METRICS_TOTAL_COUNT, controllerName, methodName) +
                " %s\n" +
                String.format(METRICS_TOTAL_TIMER, controllerName, methodName) +
                " %s\n" +
                String.format(METRICS_TOTAL_ERROR, controllerName, methodName) +
                " %s";
    }
}