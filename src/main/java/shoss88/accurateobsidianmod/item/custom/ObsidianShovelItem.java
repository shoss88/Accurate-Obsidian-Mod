package shoss88.accurateobsidianmod.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
import shoss88.accurateobsidianmod.effect.ModEffects;

public class ObsidianShovelItem extends ShovelItem {
    public ObsidianShovelItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(ModEffects.BLEEDING, 60), attacker);
        return super.postHit(stack, target, attacker);
    }
}
