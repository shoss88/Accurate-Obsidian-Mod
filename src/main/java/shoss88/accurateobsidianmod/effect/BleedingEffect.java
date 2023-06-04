package shoss88.accurateobsidianmod.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import shoss88.accurateobsidianmod.item.ModToolMaterials;

public class BleedingEffect extends StatusEffect {
    public BleedingEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int i = 15 >> amplifier;
        if (i > 0) {
            return duration % i == 0;
        }
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        LivingEntity attacker = entity.getAttacker();
        entity.damage(entity.getDamageSources().mobAttack(attacker), 1.0f);
    }
}
