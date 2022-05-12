package ru.sbrf.pprb.allo.aspect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sbrf.pprb.allo.controller.MyService;
import ru.sbrf.pprb.allo.controller.RootController;

@Configuration
public class Config {

    public static final String ANNO_NAME = "MyAspectAnno";
    public static final String MODULE_NAME = "allo";
    public static final String APP_NAME = "iam";

    @Bean
    public MetricClassBox metricClassBox() {
        MetricClassBox metricClassBox = new MetricClassBox();

        metricClassBox.addObject(RootController.class);

        return metricClassBox;
    }
}
