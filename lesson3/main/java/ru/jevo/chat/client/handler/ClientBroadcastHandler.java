package ru.jevo.chat.client.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import ru.jevo.chat.client.api.Client;
import ru.jevo.chat.client.event.ClientBroadcastEvent;
import ru.jevo.chat.client.event.ClientHistoryEvent;
import ru.jevo.chat.client.event.ClientWriteMessageEvent;
import ru.jevo.chat.client.user.UserClient;
import ru.jevo.chat.model.PacketBroadcast;

import javax.enterprise.event.Event;
import javax.enterprise.event.ObservesAsync;
import javax.inject.Inject;

public class ClientBroadcastHandler {

    @Inject
    Client client;

    @Inject
    private Event<ClientWriteMessageEvent> clientWriteMessageEvent;

    @SneakyThrows
    public void handler(@ObservesAsync final ClientBroadcastEvent event) {

        System.out.println("БРОАДКАСТ");

        @NotNull final ObjectMapper objectMapper = new ObjectMapper();
        @NotNull final PacketBroadcast packetBroadcast = new PacketBroadcast();
        packetBroadcast.setMessage(event.getMessage());
        packetBroadcast.setLogin(UserClient.login);

        client.send(objectMapper.writeValueAsString(packetBroadcast));
        clientWriteMessageEvent.fireAsync(new ClientWriteMessageEvent(UserClient.login + " : " + event.getMessage()));

    }

}
