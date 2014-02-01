package com.gprojekt.untitledchat.rest.v1;

import com.gprojekt.untitledchat.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Created with IntelliJ IDEA.
 * User: Weisgerber
 * Date: 01.02.14
 * Time: 14:28
 * To change this template use File | Settings | File Templates.
 */

@Path("/v1/login")
public class Login {

    @Autowired
    LoginService loginService;

    @Produces(MediaType.APPLICATION_JSON)
    public boolean login(@QueryParam("username") String username, @QueryParam("password")String password) {
        return this.loginService.login(username, password);
    }
}
