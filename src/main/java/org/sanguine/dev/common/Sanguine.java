package org.sanguine.dev.common;

import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;

import org.sanguine.dev.common.init.SanguineComponents;
import org.sanguine.dev.common.init.SanguineEvents;
import org.sanguine.dev.common.init.SanguineItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sanguine implements ModInitializer {
	public static final String MOD_ID = "sanguine";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		SanguineItems.init();
		SanguineComponents.init();

		SanguineEvents.initCommonEvents();
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
