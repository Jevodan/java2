package ru.jevo.chat.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PacketChange extends Packet {

    public PacketChange() {super.setType(PacketType.CHANGE); }

    private String message = "";

    private String login = "";

}
