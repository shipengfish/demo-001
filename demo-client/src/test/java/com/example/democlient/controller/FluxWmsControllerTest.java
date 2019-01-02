package com.example.democlient.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FluxWmsControllerTest {

    @InjectMocks
    private FluxWmsController fluxWmsController;

    @Test
    public void test() {
        System.out.println(fluxWmsController);
        final ArrayList<Integer> codes = new ArrayList<>();
//        codes.add(12);
        fluxWmsController.export(codes);
    }
}