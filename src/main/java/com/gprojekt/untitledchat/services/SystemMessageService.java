package com.gprojekt.untitledchat.services;

import com.gprojekt.untitledchat.dto.SystemMessage;
import com.gprojekt.untitledchat.entities.User;

/**
 * Created by Jochen on 01.02.14.
 */
public interface SystemMessageService {
    void subscribe(long lastSystemMessageId, User user);

    void message(SystemMessage systemMessage, User user);
}
