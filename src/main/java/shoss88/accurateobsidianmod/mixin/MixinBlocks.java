package shoss88.accurateobsidianmod.mixin;

import net.minecraft.block.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(Blocks.class)
public abstract class MixinBlocks {

    /**
     * Change the hardness and resistance of obsidian when it is instantiated.
     * @param args
     *     All arguments within the strength() method
     */
    @ModifyArgs(method = "<clinit>", slice = @Slice(
                from = @At(value = "CONSTANT", args = "stringValue=obsidian")
            ),
            at = @At(value = "INVOKE", target = "net/minecraft/block/AbstractBlock$Settings.strength (FF)Lnet/minecraft/block/AbstractBlock$Settings;", ordinal = 0))
    private static void fixForObsidian(Args args) {
        args.set(0, 5.0f);
        args.set(1, 10.0f);
    }
}
