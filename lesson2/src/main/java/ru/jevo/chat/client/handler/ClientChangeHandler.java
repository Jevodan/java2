package ru.jevo.chat.client.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import ru.jevo.chat.client.api.Client;
import ru.jevo.chat.client.event.ClientChangeEvent;
import ru.jevo.chat.client.user.UserClient;
import ru.jevo.chat.model.PacketChange;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

public class ClientChangeHandler {

    @Inject
    Client client;

    @Inject
    private Event<ClientChangeEvent> clientChangeEvent;

    @SneakyThrows
    public void hanler(@Observes ClientChangeEvent event){

        System.out.println("СМЕНИТЬ НИК");

        @NotNull final ObjectMapper objectMapper = new ObjectMapper();
        @NotNull final PacketChange packetChange = new PacketChange();
        packetChange.setMessage(event.getMessage());
        packetChange.setLogin(UserClient.login);

        client.send(objectMapper.writeValueAsString(packetChange));

    }

}
