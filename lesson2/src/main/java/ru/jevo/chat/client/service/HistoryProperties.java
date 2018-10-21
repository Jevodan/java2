package ru.jevo.chat.client.service;

import lombok.Data;
import lombok.SneakyThrows;

import javax.enterprise.context.ApplicationScoped;
import java.io.InputStream;
import java.util.Properties;

@ApplicationScoped
@Data
public class HistoryProperties {

    final String path;
    final String name;
    final String limit;

    @SneakyThrows
    public HistoryProperties() {

        final InputStream inputStream = ClassLoader.getSystemResourceAsStream("history.properties");
        final Properties properties = new Properties();

        properties.load(inputStream);
        this.name = properties.get("name").toString();
        this.path = properties.get("path").toString();
        this.limit = properties.get("limit").toString();

    }

}
