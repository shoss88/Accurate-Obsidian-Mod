package shoss88.accurateobsidianmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.mixin.content.registry.AxeItemAccessor;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import shoss88.accurateobsidianmod.AccurateObsidianMod;
import shoss88.accurateobsidianmod.item.custom.ObsidianArmorItem;

public class ModItems {
    public static final Item OBSIDIAN_CHUNK = registerItem("obsidian_chunk",
            new Item(new FabricItemSettings().fireproof()));
    public static final Item OBSIDIAN_SHOVEL = registerItem("obsidian_shovel",
            new ShovelItem(ModToolMaterials.OBSIDIAN, 4.5f, -3, new FabricItemSettings().fireproof()));
    public static final Item OBSIDIAN_PICKAXE = registerItem("obsidian_pickaxe",
            new PickaxeItem(ModToolMaterials.OBSIDIAN, 4, -1.5f, new FabricItemSettings().fireproof()));
    public static final Item OBSIDIAN_HOE = registerItem("obsidian_hoe",
            new HoeItem(ModToolMaterials.OBSIDIAN, 4, -1.5f, new FabricItemSettings().fireproof()));
    public static final Item OBSIDIAN_AXE = registerItem("obsidian_axe",
            new AxeItem(ModToolMaterials.OBSIDIAN, 8f, -3.1f, new FabricItemSettings().fireproof()));
    public static final Item OBSIDIAN_SWORD = registerItem("obsidian_sword",
            new SwordItem(ModToolMaterials.OBSIDIAN, 7, -2.4f, new FabricItemSettings().fireproof()));
    public static final Item OBSIDIAN_HELMET = registerItem("obsidian_helmet",
            new ObsidianArmorItem(ModArmorMaterials.OBSIDIAN, ArmorItem.Type.HELMET, new FabricItemSettings().fireproof()));
    public static final Item OBSIDIAN_CHESTPLATE = registerItem("obsidian_chestplate",
            new ObsidianArmorItem(ModArmorMaterials.OBSIDIAN, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().fireproof()));
    public static final Item OBSIDIAN_LEGGINGS = registerItem("obsidian_leggings",
            new ObsidianArmorItem(ModArmorMaterials.OBSIDIAN, ArmorItem.Type.LEGGINGS, new FabricItemSettings().fireproof()));
    public static final Item OBSIDIAN_BOOTS = registerItem("obsidian_boots",
            new ObsidianArmorItem(ModArmorMaterials.OBSIDIAN, ArmorItem.Type.BOOTS, new FabricItemSettings().fireproof()));


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
        addToItemGroup(ItemGroups.COMBAT, OBSIDIAN_SWORD);
        addToItemGroup(ItemGroups.COMBAT, OBSIDIAN_HELMET);
        addToItemGroup(ItemGroups.COMBAT, OBSIDIAN_CHESTPLATE);
        addToItemGroup(ItemGroups.COMBAT, OBSIDIAN_LEGGINGS);
        addToItemGroup(ItemGroups.COMBAT, OBSIDIAN_BOOTS);
    }

    private static void addToItemGroup(ItemGroup group, Item item){
        if (item instanceof ObsidianArmorItem){
            ItemStack stack = new ItemStack(item);
            stack.addEnchantment(Enchantments.FIRE_PROTECTION, 1);
            stack.addEnchantment(Enchantments.THORNS, 1);
            ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(stack));
        }
        else {
            ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        }
    }
    public static void registerModItems(){
        AccurateObsidianMod.LOGGER.info("Registering Mod Items for " + AccurateObsidianMod.MOD_ID);
        addItemsToItemGroup();
    }
}
