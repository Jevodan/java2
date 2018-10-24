package ru.jevo.chat.client.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import ru.jevo.chat.client.api.Client;
import ru.jevo.chat.client.event.ClientLoginEvent;
import ru.jevo.chat.client.event.ClientRegistryEvent;
import ru.jevo.chat.client.user.UserClient;
import ru.jevo.chat.model.PacketRegistry;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class ClientRegistryHandler {

    @Inject
    Client client;

    @SneakyThrows
    public void handler(@Observes final ClientRegistryEvent event) {
        @NotNull final String login = UserClient.login;
        @NotNull final String password = UserClient.password;
        @NotNull final ObjectMapper objectMapper = new ObjectMapper();
        @NotNull final PacketRegistry packetRegistry = new PacketRegistry();
        packetRegistry.setLogin(login);
        packetRegistry.setPassword(password);
        client.send(objectMapper.writeValueAsString(packetRegistry));

    }

}
