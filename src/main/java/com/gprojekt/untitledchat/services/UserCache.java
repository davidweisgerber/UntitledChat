package com.gprojekt.untitledchat.services;

import com.gprojekt.untitledchat.entities.User;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jochen on 01.02.14.
 */
@Component
public class UserCache {
    private Map<String, User> userMap;

    public UserCache() {
        this.userMap = Collections.synchronizedMap(new HashMap<String, User>());
    }

    public Map<String, User> get() {
        return this.userMap;
    }
}
