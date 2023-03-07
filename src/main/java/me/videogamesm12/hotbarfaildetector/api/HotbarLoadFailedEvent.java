package me.videogamesm12.hotbarfaildetector.api;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;

import java.util.Arrays;

/**
 * <h1>HotbarLoadFailedEvent</h1>
 * <p>Called when a hotbar file fails to load for any reason.</p>
 */
public interface HotbarLoadFailedEvent
{
    Event<HotbarLoadFailedEvent> EVENT = EventFactory.createArrayBacked(HotbarLoadFailedEvent.class,
            (listeners) -> () -> Arrays.stream(listeners).forEach(HotbarLoadFailedEvent::onLoadFailure));

    void onLoadFailure();
}
