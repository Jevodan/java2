package ru.jevo.chat.client.handler;

import lombok.SneakyThrows;
import ru.jevo.chat.client.event.ClientHistoryEvent;
import ru.jevo.chat.client.event.ClientWriteMessageEvent;
import ru.jevo.chat.client.service.HistoryProperties;

import javax.enterprise.event.Event;
import javax.enterprise.event.ObservesAsync;
import javax.inject.Inject;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.Properties;

public class ClientWriteMessageHandler {

    @Inject
    HistoryProperties prop;

    @Inject
    private Event<ClientWriteMessageEvent> clientWriteMessageEvent;

    @SneakyThrows
    public void handler(@ObservesAsync ClientWriteMessageEvent event){

        final String text = event.getMessage() + "\n";

        FileWriter writer = new FileWriter(prop.getPath() + prop.getName(), true);
        BufferedWriter bufferWriter = new BufferedWriter(writer);
        bufferWriter.write(text );
        bufferWriter.close();

    }
}