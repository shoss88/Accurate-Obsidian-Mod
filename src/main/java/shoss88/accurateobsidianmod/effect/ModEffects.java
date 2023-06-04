package shoss88.accurateobsidianmod.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import shoss88.accurateobsidianmod.AccurateObsidianMod;

public class ModEffects {
    public static StatusEffect BLEEDING;
    public static StatusEffect registerStatusEffect(String name) {
        return Registry.register(
                Registries.STATUS_EFFECT,
                new Identifier(AccurateObsidianMod.MOD_ID, name),
                new BleedingEffect(StatusEffectCategory.HARMFUL, 0xD10000));
    }

    public static void registerEffects(){
        BLEEDING = registerStatusEffect("bleeding");
    }
}
