//package ru.sbrf.pprb.allo.config;
//
//import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
//import com.googlecode.jsonrpc4j.ProxyUtil;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import ru.sbt.currency.integration.api.cb.CentralBankRates;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//
//@Configuration
//public class RatesConfig {
//    @Bean
//    public JsonRpcHttpClient jsonRpcClient(@Value("${cb.rate.server.host}") String jsonRpcHost,
//            @Value("${cb.rate.read.timeout}") int readTimeout,
//            @Value("${cb.rate.connection.timeout}") int connectionTimeout) throws MalformedURLException {
//        JsonRpcHttpClient client = new JsonRpcHttpClient(new URL(jsonRpcHost));
//        if(readTimeout > 0) {
//            client.setReadTimeoutMillis(readTimeout);
//        }
//        if(connectionTimeout > 0) {
//            client.setConnectionTimeoutMillis(connectionTimeout);
//        }
//        return client;
//    }
//
//    @Bean
//    public CentralBankRates centralBankRates(JsonRpcHttpClient jsonRpcClient) {
//        return ProxyUtil.createClientProxy(RatesConfig.class.getClassLoader(), CentralBankRates.class, jsonRpcClient);
//    }
//}
