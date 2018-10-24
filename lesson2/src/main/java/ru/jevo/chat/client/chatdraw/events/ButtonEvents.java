package ru.jevo.chat.client.chatdraw.events;

import ru.jevo.chat.client.chatdraw.ChatDraw;
import ru.jevo.chat.client.event.*;

import javax.enterprise.event.Event;
import javax.inject.Inject;

public class ButtonEvents implements ButtonEventsShow {

    @Inject
    private Event<ClientBroadcastEvent> clientBroadcastEvent;

    @Inject
    private Event<ClientPingEvent> clientPingEvent;

    @Inject
    private Event<ClientLoginEvent> clientLoginEvent;

    @Inject
    private Event<ClientRegistryEvent> clientRegistryEvent;

    @Inject
    private Event<ClientChangeEvent> clientChangeEvent;

    @Override
    public void clickPing() { clientPingEvent.fireAsync(new ClientPingEvent());}

    @Override
    public void clickMessage(String message) {
        clientBroadcastEvent.fireAsync(new ClientBroadcastEvent(message));
    }

    @Override
    public void clickLogin() { clientLoginEvent.fireAsync(new ClientLoginEvent());}

    @Override
    public void clickRegistry() { clientRegistryEvent.fire(new ClientRegistryEvent());}

    @Override
    public void clickPrivat() {}

    @Override
    public void clickChange(String message) {
        clientChangeEvent.fire(new ClientChangeEvent(message));
    }

    @Override
    public void clickExit() {}
}
