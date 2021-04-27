package com.springtourofheroes.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping(value = "/api/streams")
public class StreamController {

    @GetMapping("/")
    public void stream() {
        var arr = Arrays.asList("a1", "a2", "b1", "b2", "c1", "c2");

        arr.stream()
                .filter((string) -> string.startsWith("c"))
                .map((string) -> string.toUpperCase())
                .sorted()
                .forEach((string) -> System.out.println(string));

        arr.stream()
                .findFirst()
                .ifPresent((string) -> System.out.println(string));


        Arrays.stream(new int[]{1, 2, 3, 4, 5})
                .map((number) -> 2 * number)
                .average()
                .ifPresent((number) -> System.out.println(number));
    }
}
