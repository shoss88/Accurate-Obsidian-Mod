package shoss88.accurateobsidianmod.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.client.gl.Uniform;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import shoss88.accurateobsidianmod.item.ModItems;

public class ModLootTableModifiers {
    private static final Identifier OBSIDIAN_BLOCK_ID =
            new Identifier("minecraft", "blocks/obsidian");

    public static void modifyLootTables(){
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (id.equals(OBSIDIAN_BLOCK_ID)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .with(ItemEntry.builder(ModItems.OBSIDIAN_CHUNK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(9.0f, 9.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });
    }
}
