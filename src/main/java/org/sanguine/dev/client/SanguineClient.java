package org.sanguine.dev.client;

import net.fabricmc.api.ClientModInitializer;
import org.sanguine.dev.common.init.SanguineEvents;

public class SanguineClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        SanguineEvents.initClientEvents();
    }
}
