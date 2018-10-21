package ru.jevo.chat.server.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import ru.jevo.chat.model.PacketChange;
import ru.jevo.chat.server.api.ConnectionService;
import ru.jevo.chat.server.api.UserService;
import ru.jevo.chat.server.event.ServerChangeEvent;
import ru.jevo.chat.server.service.Connection;

import javax.enterprise.event.ObservesAsync;
import javax.inject.Inject;
import java.net.Socket;

public class ServerChangeHandler {

    @Inject
    private UserService userService;

    @Inject
    private ConnectionService connectionService;

    @SneakyThrows
    public void handler(@ObservesAsync ServerChangeEvent event) {

        System.out.println("ServerChangeHandler");

        @NotNull final Socket socket = event.getSocket();
        @NotNull final String messageJSON = event.getMessageJSON();
        @NotNull final ObjectMapper objectMapper = new ObjectMapper();
        @NotNull final PacketChange packetChange = objectMapper.readValue(messageJSON, PacketChange.class);
        @Nullable final Connection connection = connectionService.get(socket);

        if (connection == null) return;
        @Nullable final String login = connection.getLogin();
        if (login == null || login.isEmpty()) return;
        if (!login.equals(packetChange.getLogin())) {
            System.out.println("логины юзера из БД и сокета не совпадают");
            return;
        }
        connectionService.changeLogin(connection, packetChange.getMessage());
        userService.changeLogin(login, packetChange.getMessage());
        connectionService.sendResult(socket, true, messageJSON);

    }
}
