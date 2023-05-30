package shoss88.accurateobsidianmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.mixin.content.registry.AxeItemAccessor;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import shoss88.accurateobsidianmod.AccurateObsidianMod;

public class ModItems {
    public static final Item OBSIDIAN_CHUNK = registerItem("obsidian_chunk",
            new Item(new FabricItemSettings()));
    public static final Item OBSIDIAN_SHOVEL = registerItem("obsidian_shovel",
            new ShovelItem(ModToolMaterials.OBSIDIAN, 5.5f, 1, new FabricItemSettings()));
    public static final Item OBSIDIAN_PICKAXE = registerItem("obsidian_pickaxe",
            new PickaxeItem(ModToolMaterials.OBSIDIAN, 5, 2.5f, new FabricItemSettings()));
    public static final Item OBSIDIAN_HOE = registerItem("obsidian_hoe",
            new HoeItem(ModToolMaterials.OBSIDIAN, 3, 2.5f, new FabricItemSettings()));
    public static final Item OBSIDIAN_AXE = registerItem("obsidian_axe",
            new AxeItem(ModToolMaterials.OBSIDIAN, 10f, 0.9f, new FabricItemSettings()));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(AccurateObsidianMod.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup(){
        addToItemGroup(ItemGroups.INGREDIENTS, OBSIDIAN_CHUNK);
        addToItemGroup(ItemGroups.TOOLS, OBSIDIAN_SHOVEL);
        addToItemGroup(ItemGroups.TOOLS, OBSIDIAN_PICKAXE);
        addToItemGroup(ItemGroups.TOOLS, OBSIDIAN_HOE);
        addToItemGroup(ItemGroups.TOOLS, OBSIDIAN_AXE);
        addToItemGroup(ItemGroups.COMBAT, OBSIDIAN_AXE);
    }

    private static void addToItemGroup(ItemGroup group, Item item){
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }
    public static void registerModItems(){
        AccurateObsidianMod.LOGGER.info("Registering Mod Items for " + AccurateObsidianMod.MOD_ID);
        addItemsToItemGroup();
    }
}
