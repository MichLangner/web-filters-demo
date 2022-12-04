package io.michlangner.webfiltersdemo.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.servlet.Filter;
import java.util.Set;


@RestController
public class ControllerApi {

    Set<Filter> allSpringFilters;

    public ControllerApi(Set<Filter> allSpringFilters) {
        this.allSpringFilters = allSpringFilters;
    }

    @PostConstruct
    public void printAllFilters(){
        allSpringFilters.forEach(System.out::println);


    }

    @GetMapping(value = "/user/{first}")
    public ResponseEntity<String> showValueForUser(@PathVariable String first){
        return ResponseEntity.ok(first);
    }

    @GetMapping(value = "/admin/{first}")
    public ResponseEntity<String> showValueForAdmin(@PathVariable String first){
        return ResponseEntity.ok(first);
    }

    @GetMapping(value = "/viewer/{first}")
    public ResponseEntity<String> showValueForViewer(@PathVariable String first){
        return ResponseEntity.ok(first);
    }
}
