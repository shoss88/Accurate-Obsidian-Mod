package shoss88.accurateobsidianmod.mixin;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import shoss88.accurateobsidianmod.item.custom.ObsidianArmorItem;

@Mixin(CraftingResultInventory.class)
public class MixinCraftingResultInventory {
    @Inject(method = "setStack", at = @At("HEAD"))
    private void injectSetStack(int slot, ItemStack stack, CallbackInfo ci){
        if (stack.getItem() instanceof ObsidianArmorItem && !stack.hasEnchantments()){
            stack.addEnchantment(Enchantments.FIRE_PROTECTION, 1);
            stack.addEnchantment(Enchantments.THORNS, 1);
        }
    }
}
