//package ru.sbrf.pprb.allo.config.exception;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//@ControllerAdvice
//public class MyExceptionHandler {
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<?> otherExceptionHandler(Exception e) {
//        System.out.println("Исключение в RootController");
//        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//}
