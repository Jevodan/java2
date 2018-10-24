package ru.jevo.chat.client.handler;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import ru.jevo.chat.client.api.Client;
import ru.jevo.chat.client.event.ClientLoginEvent;
import ru.jevo.chat.client.user.UserClient;
import ru.jevo.chat.model.PacketLogin;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.ObservesAsync;
import javax.inject.Inject;

@ApplicationScoped
public class ClientLoginHandler {

    @Inject
    Client client;

    @SneakyThrows
    public void handler(@ObservesAsync final ClientLoginEvent event) {

        @NotNull final String login = UserClient.login;
        @NotNull final String password = UserClient.password;

        @NotNull final ObjectMapper objectMapper = new ObjectMapper();
        @NotNull final PacketLogin packetLogin = new PacketLogin();
        packetLogin.setLogin(login);
        packetLogin.setPassword(password);

        client.send(objectMapper.writeValueAsString(packetLogin));

    }

}
