package com.example.calculator.interfaces;

import java.util.ArrayList;

public interface iCalculator {
    public String add(String srs, String dsr);            // +
    public String sub(String srs, String dsr);            // -
    public String mult(String srs, String dsr);           // *
    public String sep(String srs, String dsr);            // /
    public String equ(String srs, String dsr);            // =
    public String arithmetic(String value);    // арифметика
}
