package ru.jevo.chat.client.handler;

import lombok.SneakyThrows;
import ru.jevo.chat.client.chatdraw.ChatDraw;
import ru.jevo.chat.client.event.ClientHistoryEvent;
import ru.jevo.chat.client.service.HistoryProperties;

import javax.enterprise.event.Event;
import javax.enterprise.event.ObservesAsync;
import javax.inject.Inject;
import java.io.*;
import java.util.Properties;

import static java.lang.Integer.parseInt;

public class ClientHistoryHandler {

    @Inject
    private HistoryProperties prop;

    @Inject
    private ChatDraw draw;

    @Inject
    private Event<ClientHistoryEvent> clientHistoryEvent;

    @SneakyThrows
    public void handler(@ObservesAsync ClientHistoryEvent event) {

        if (new File(prop.getPath() + prop.getName()).isFile()) {

            FileInputStream fstream = new FileInputStream(prop.getPath() + prop.getName());
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            int count = 0;

            while ((strLine = br.readLine()) != null && count < parseInt(prop.getLimit())) {
                draw.addTextToChat(strLine, "");
                count++;
            }
        } else {
            File file = new File(prop.getPath() + prop.getName());
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
