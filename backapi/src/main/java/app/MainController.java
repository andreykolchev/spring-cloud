package app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by user on 4/12/17.
 */
@RestController
@RequestMapping("/")
class MainController {

    @Value("${server.port}")
    String serverPort;

    @RequestMapping(value = "message", method = RequestMethod.GET)
    ResponseEntity<String> getMessage() {
        return new ResponseEntity<>(new String("Hello from back API on port: " + serverPort), HttpStatus.CREATED);
    }

//    @RequestMapping(value = "health", method = RequestMethod.GET, produces = "application/json")
//    @ResponseBody
//    ResponseEntity<String> getHealth() {
//        return new ResponseEntity<>(new String("{\"status\": \"UP\"}"), HttpStatus.CREATED);
//    }

}