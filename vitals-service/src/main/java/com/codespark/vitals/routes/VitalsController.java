package com.codespark.vitals.routes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping
public class VitalsController {

    @GetMapping("/vitals/v1")
    public Mono<String> v1Vitals() {
        return Mono.just("V1 Vitals");
    }

    @GetMapping("/vitals/v2")
    public String v2Vitals() {
        return "V2 Vitals";
    }

}
