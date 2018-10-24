package ru.jevo.chat.client.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import ru.jevo.chat.client.Marshrut;
import ru.jevo.chat.client.api.Client;
import ru.jevo.chat.client.chatdraw.ChatDraw;
import ru.jevo.chat.client.event.ClientHistoryEvent;
import ru.jevo.chat.client.event.ClientMessageReadEvent;
import ru.jevo.chat.client.event.ClientWriteMessageEvent;
import ru.jevo.chat.model.Packet;
import javax.enterprise.event.Event;
import javax.enterprise.event.ObservesAsync;
import javax.inject.Inject;
import java.io.IOException;

public class ClientMessageReadHandler {

    @Inject
    Marshrut marshrutizator;

    @Inject
    ChatDraw draw;

    @Inject
    Client client;

    @Inject
    private Event<ClientMessageReadEvent> clientMessageReadEvent;

    @SneakyThrows
    public void handler(@ObservesAsync ClientMessageReadEvent event) {

        try {
            @NotNull final String response = client.getIn().readUTF();
            @NotNull final ObjectMapper objectMapper = new ObjectMapper();
            @NotNull final Packet packet = objectMapper.readValue(response, Packet.class);
            marshrutizator.outMessage(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        clientMessageReadEvent.fireAsync(new ClientMessageReadEvent());

    }

}
