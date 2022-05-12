//package ru.sbrf.pprb.allo.config;
//
//import com.sbt.audit.proxy.client.AuditProxyClient;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class AuditConfig {
//    @Value("${audit2.proxy.url}")
//    private String url;
////    @Value("${ssl.key.password}")
////    private String alias;
////    @Value("${ssl.keystore.location}")
////    private String keyStorePath;
////    @Value("${ssl.keystore.password}")
////    private String keyStorePassword;
//
//    @Bean
//    public AuditProxyClient auditProxyClient() {
//        return AuditProxyClient.builder()
//                .baseUrl(url)
//                .nodeId("local")
////                .sslKeystorePassword(keyStorePassword)
////                .sslKeystoreLocation(keyStorePath)
////                .sslKeyPassword(alias)
////                .sslTruststoreLocation(keyStorePath)
////                .sslTruststorePassword(keyStorePassword)
//                .build();
//    }
//}
