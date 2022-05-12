package ru.sbrf.pprb.allo.controller;

//import com.sbt.audit.proxy.client.AuditProxyClient;
//import com.sbt.audit2.client.model.v2.AuditMetamodel;
//import com.sbt.audit2.client.model.v2.AuditMetamodelChangedParams;
//import com.sbt.audit2.client.model.v2.AuditMetamodelEvents;
//import com.sbt.audit2.client.model.v2.AuditMetamodelParams;
//import com.sbt.audit2.client.model.v2.BaseResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.sbrf.pprb.allo.aspect.MetricClassBox;
import ru.sbrf.pprb.allo.aspect.MyAspectAnno;
import ru.sbrf.pprb.allo.config.exception.annotations.RootControllerHandler;

import java.math.BigDecimal;
import java.util.Random;
import java.util.concurrent.TimeUnit;

//import java.util.Collections;


@RestController
@RootControllerHandler
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RootController {

//    private static final String COUNTER_WITH_TAG_NAME = "simple.counterWithTags";
//    private static final String COUNTER_WITH_TAG_DESCRIPTION = "Just a simple counter with tags";
//    private static final String COUNTER_WITH_USER_TAG_NAME = "simple.counterWithUserTag";
//    private static final String TAG_NAME_1 = "terbank";
//    private static final String TAG_NAME_2 = "vsp";
//    private static final String TAG_USER = "userText";
//    private Counter simpleCounter;
//    private Counter simpleCounterWithTags;
//    private Counter simpleCounterWithTags2;
//    private Counter simpleCounterWithUserTag;
//
//    private String nsiServiceHost = "http://nsi-ci01098420-idevgen-allowanceift.sh3.dev-gen.delta.sbrf.ru";
//    private String currencyCode = "156";
//    private final ObjectMapper mapper;
    private final MeterRegistry meterRegistry;
    private final Random random = new Random();
    private final MyService service;
    private final MetricClassBox metricClassBox;
    private final ObjectMapper objectMapper;

//    /**
//     * Инициальзация метрик типа Counter
//     */
//    @PostConstruct
//    public void init() {
//        simpleCounter = Counter.builder("simple.counter")
//                .description("Just a simple counter")
//                .register(meterRegistry);
//        simpleCounterWithTags = Counter.builder(COUNTER_WITH_TAG_NAME)
//                .description(COUNTER_WITH_TAG_DESCRIPTION)
//                .tag(TAG_NAME_1, "sib")
//                .tag(TAG_NAME_2, "111")
//                .register(meterRegistry);
//        simpleCounterWithTags2 = Counter.builder(COUNTER_WITH_TAG_NAME)
//                .description(COUNTER_WITH_TAG_DESCRIPTION)
//                .tag(TAG_NAME_1, "msk")
//                .tag(TAG_NAME_2, "111")
//                .register(meterRegistry);
//    }
//
//    /**
//     * Увеличение счетчика на 1
//     */
//    @GetMapping("/counter")
//    @ResponseBody
//    public String incrementCounter() {
//        simpleCounter.increment();
//        return String.format("Counter has been increases\nCurrent value: %s", simpleCounter.count());
//    }
//
//    /**
//     * Увеличение на 1 счетчика с разрезом фиксации "terbank" и значением "sib"
//     */
//    @GetMapping("/counterWithTags/terbank/sib")
//    @ResponseBody
//    public String incrementCounterTags1() {
//        simpleCounterWithTags.increment(1);
//        return String.format("Counter has been increases\nCurrent value: %s", simpleCounterWithTags.count());
//    }
//
//    /**
//     * Увеличение на 2 счетчика с разрезом фиксации "terbank" и значением "msk"
//     */
//    @GetMapping("/counterWithTags/terbank/msk")
//    @ResponseBody
//    public String incrementCounterTags2() {
//        simpleCounterWithTags2.increment(2);
//        return String.format("Counter has been increases\nCurrent value: %s", simpleCounterWithTags2.count());
//    }
//
//    @GetMapping("/counterWithUserTagValue")
//    @ResponseBody
//    public String incrementCounterWithUserTag(@RequestParam String val) {
//        simpleCounterWithUserTag = Counter.builder(COUNTER_WITH_USER_TAG_NAME)
//                .tag(TAG_USER, val)
//                .register(meterRegistry);
//        simpleCounterWithUserTag.increment(1);
//        return String.format("Counter has been increases\nCurrent value: %s", simpleCounterWithUserTag.count());
//    }

//    private final AuditProxyClient auditProxyClient;
//    private final CentralBankRates centralBankRates;

//    private final DictionaryService dictService;

//    @MyAspectAnno
    @GetMapping("/users")
    @ResponseBody
    public String getUi() {
//        var node = mapper.readTree(
//                new URL(String.format("%s/api/v1/currency_rates/%s", nsiServiceHost, currencyCode))
//        );
//    public Dto getUi() {
       
//        try {
//            service.getException();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            throw e;
//        }
        return "OK";
//                simpleCounter.count());
//        return dto;
//        return "Hello";
    }

    //    @GetMapping("/userse")
//    public String getUiE() {
//
//        return "Hello";
//    }
//    @MyAspectAnno
    @GetMapping("/")
    public Dto getUiRoot() throws InterruptedException {
        Thread.sleep(random.nextInt(1000));

        Dto dto = new Dto();
//        dto.setTime("root mapping");
//        dto.setMessage("root message");
//        dto.setTimeInWorking(System.currentTimeMillis());
        return dto;
    }

    @MyAspectAnno
    @GetMapping("/rates")
    public Dto getRates() throws InterruptedException {

        Thread.sleep(random.nextInt(1000));

        Dto dto = new Dto();
//        dto.setTime("rates mapping");
//        dto.setMessage("rates message");
//        dto.setTimeInWorking(System.currentTimeMillis());

        return dto;
    }
}