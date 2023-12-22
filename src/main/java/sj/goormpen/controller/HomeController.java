package sj.goormpen.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class HomeController {

    @GetMapping("/api/hello")
    public List<String> Hello(){
        return Arrays.asList("헬로", "월드");
    }
}
