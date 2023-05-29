package shoss88.accurateobsidianmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import shoss88.accurateobsidianmod.AccurateObsidianMod;

public class ModItems {
    public static final Item OBSIDIAN_CHUNK = registerItem("obsidian_chunk",
            new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(AccurateObsidianMod.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup(){
        addToItemGroup(ItemGroups.INGREDIENTS, OBSIDIAN_CHUNK);
    }

    private static void addToItemGroup(ItemGroup group, Item item){
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }
    public static void registerModItems(){
        AccurateObsidianMod.LOGGER.info("Registering Mod Items for " + AccurateObsidianMod.MOD_ID);
        addItemsToItemGroup();
    }
}
