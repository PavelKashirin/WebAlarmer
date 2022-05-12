package ru.sbrf.pprb.allo.controller;

import org.springframework.stereotype.Service;

@Service
public class MyService {

    public void getException() {
        throw new RuntimeException();
    }
}
