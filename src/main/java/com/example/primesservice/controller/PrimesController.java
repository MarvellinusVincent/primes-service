package com.example.primesservice.controller;

import com.example.primesservice.rabbitmq.MQSender;
import com.example.primesservice.service.IPrimesService;
import com.example.primesservice.service.PrimesService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/primes")
public class PrimesController {
    IPrimesService primesService = new PrimesService();
    private final MQSender mqSender;
    public PrimesController(IPrimesService primesService, MQSender mqSender) {
        this.primesService = primesService;
        this.mqSender = mqSender;
    }

    @GetMapping("/{n}")
    public boolean isPrime(@PathVariable long n) {
        boolean result = primesService.isPrime(n);
        mqSender.sendMessage(n, result);
        return result;
    }
}
