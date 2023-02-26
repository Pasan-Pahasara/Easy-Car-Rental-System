package lk.ijse.easy.controller;

import lk.ijse.easy.service.UserService;
import lk.ijse.easy.util.Current;
import lk.ijse.easy.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author : ShEnUx
 * @time : 11:16 PM
 * @date : 2/21/2023
 * @since : 0.1.0
 **/
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService service;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllRegUser() {
        System.out.println(service.getAllRegUsers());
        return new ResponseUtil("OK", "Successfully Loaded..!", service.getAllRegUsers());
    }

    @GetMapping(params = {"username"})
    public ResponseUtil setUser(String username, String password) {
        Current.currentUser = service.getRegUsers(username, password);
        return new ResponseUtil("OK", "Successfully Loaded..!", "");
    }

    @GetMapping(path = "current")
    public ResponseUtil getCurrentUser() {
        return new ResponseUtil("OK", "Successfully Loaded..!", Current.currentUser);
    }
}
