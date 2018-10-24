package ru.jevo.chat.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Packet {

    @Nullable
    private String id = UUID.randomUUID().toString();

    @Nullable
    private PacketType type = PacketType.NONE;

    @Nullable
    private String message = "";

    @Nullable
    private String login = "";

    @Nullable
    private String password = "";

}
