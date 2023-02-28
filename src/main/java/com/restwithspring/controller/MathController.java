package com.restwithspring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequiredArgsConstructor
public class MathController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="/sum/{n1}/{n2}", method=RequestMethod.GET)
    public Double sum(@PathVariable(value="n1") String n1,
                      @PathVariable(value = "n2") String n2)  throws Exception {
        if (!isNumeric(n1) || !isNumeric(n2)) {
            throw new UnsupportedOperationException("Please set a numeric value");
        }
         return convertToDouble( n1) + convertToDouble(n2);
    }

    @RequestMapping(value="/sub/{n1}/{n2}", method=RequestMethod.GET)
    public Double sub(@PathVariable(value="n1") int n1,
                      @PathVariable(value = "n2") int n2)  throws Exception {
        return 1D;
    }
    @RequestMapping(value="/div/{n1}/{n2}", method=RequestMethod.GET)
    public Double div(@PathVariable(value="n1") int n1,
                      @PathVariable(value = "n2") int n2) {
        return 1D;
    }
    @RequestMapping(value="/mult/{n1}/{n2}", method=RequestMethod.GET)
    public Double mult(@PathVariable(value="n1") int n1,
                      @PathVariable(value = "n2") int n2) {
        return 1D;
    }

    private Double convertToDouble(String number) {
        if (Objects.nonNull(number)) return 0D;
        String strNumber = number.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    private boolean isNumeric(String number) {
        if (Objects.nonNull(number)) return false;
        String strNumber = number.replaceAll(",", ".");
        return strNumber.matches("[-+]]?[)-9]*\\.[0-9]+");
    }



}
