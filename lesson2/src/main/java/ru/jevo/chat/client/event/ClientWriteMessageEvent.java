package ru.jevo.chat.client.event;

import lombok.Data;

@Data
public class ClientWriteMessageEvent {

    String message;

    public ClientWriteMessageEvent(String message) {
        this.message = message;
    }

}
