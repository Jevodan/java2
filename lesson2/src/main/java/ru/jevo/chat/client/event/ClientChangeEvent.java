package ru.jevo.chat.client.event;

import lombok.Data;

@Data
public class ClientChangeEvent {

    String message;

    public ClientChangeEvent(String message) {
        this.message = message;
    }

}
