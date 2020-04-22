package CanDetect.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.ObjectInputStream;

@RestController
public class ControllerExamples {
    // No method specified
    @RequestMapping("/hello")
    private String hello() {
        return "Hello world!";
    }

    // Attempting to deserialize data provided by user is a vulnerability
    @RequestMapping(value = "/getObject", method = RequestMethod.GET)
    private Object getObject(HttpServletRequest request) throws Exception {
        ServletInputStream sis = request.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(sis);
        return ois.readObject();
    }
}
