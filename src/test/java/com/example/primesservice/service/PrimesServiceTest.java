package com.example.primesservice.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimesServiceTest {
    PrimesService primesService = new PrimesService();

    @Test
    void isPrime() {
        long n = 45;
        boolean expected = false;
        boolean actual = primesService.isPrime(n);
        assertEquals(expected, actual);
    }

    @Test
    void isPrime2() {
        long n = 285191;
        boolean expected = true;
        boolean actual = primesService.isPrime(n);
        assertEquals(expected, actual);
    }

    @Test
    void isPrime3() {
        long n = 539828945930573L;
        boolean expected = false;
        boolean actual = primesService.isPrime(n);
        assertEquals(expected, actual);
    }
}