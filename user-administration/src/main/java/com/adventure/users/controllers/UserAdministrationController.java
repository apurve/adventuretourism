package com.adventure.users.controllers;

import com.adventure.users.model.UserInfoTO;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("User Administration Service API")
@RestController
@RequestMapping("/users")
public class UserAdministrationController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

}
