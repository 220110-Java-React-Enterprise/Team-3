package com.revature.project2.controllers;

import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;

@Component
public class Test {
    public Test() {
    }

    public void testMethod() throws FileNotFoundException {
        throw new FileNotFoundException();
    }
}
