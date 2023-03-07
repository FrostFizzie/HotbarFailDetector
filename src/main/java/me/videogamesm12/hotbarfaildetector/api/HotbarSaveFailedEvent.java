package me.videogamesm12.hotbarfaildetector.api;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;

import java.util.Arrays;

/**
 * <h1>HotbarSaveFailedEvent</h1>
 * <p>Called when a hotbar file fails to save for any reason.</p>
 */
public interface HotbarSaveFailedEvent
{
    Event<HotbarSaveFailedEvent> EVENT = EventFactory.createArrayBacked(HotbarSaveFailedEvent.class,
            (listeners) -> () -> Arrays.stream(listeners).forEach(HotbarSaveFailedEvent::onSaveFailure));

    void onSaveFailure();
}
