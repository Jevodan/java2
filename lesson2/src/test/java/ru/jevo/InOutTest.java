package ru.jevo;

import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.Properties;

public class InOutTest {


    @Test
    @SneakyThrows
    public void propTest() {
        final InputStream inputStream = ClassLoader.getSystemResourceAsStream("history.properties");
        final Properties properties = new Properties();
        properties.load(inputStream);
        Assert.assertEquals(properties.get("path").toString(), "src/resources/");
        Assert.assertEquals(properties.get("name").toString(), "history.txt");
    }

    @Test
    @SneakyThrows
    public void inText() {
        final InputStream inputStream = ClassLoader.getSystemResourceAsStream("history.properties");
        final Properties properties = new Properties();
        properties.load(inputStream);
        final String path = properties.get("path").toString();
        final String name = properties.get("name").toString();

        String text = "Hello world222!\n";

        if (new File(path + name).isFile()) {
            FileWriter writer = new FileWriter(path + name, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);

            bufferWriter.write(text);
            bufferWriter.close();
        } else {
            System.out.println("не существует");
        }

    }

    @Test
    @SneakyThrows
    public void outText() {
        final InputStream inputStream = ClassLoader.getSystemResourceAsStream("history.properties");
        final Properties properties = new Properties();
        properties.load(inputStream);
        final String path = properties.get("path").toString();
        final String name = properties.get("name").toString();

        if (new File(path + name).isFile()) {
            FileInputStream fstream = new FileInputStream(path + name);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;

            while ((strLine = br.readLine()) != null) {
                System.out.println(strLine);
            }
        } else {
            File file = new File(path + name);
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
