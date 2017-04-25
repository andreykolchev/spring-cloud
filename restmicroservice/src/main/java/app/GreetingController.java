package app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
class GreetingController {


    @Value("${server.port}")
    String serverPort;

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<Greet> getGreet() {
        return new ResponseEntity<>(new Greet("Hello from rest api on port: " + serverPort), HttpStatus.CREATED);
    }

}