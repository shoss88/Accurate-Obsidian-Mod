package shoss88.accurateobsidianmod;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shoss88.accurateobsidianmod.effect.ModEffects;
import shoss88.accurateobsidianmod.item.ModItems;

public class AccurateObsidianMod implements ModInitializer {

	public static final String MOD_ID = "accurateobsidianmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModEffects.registerEffects();
	}
}