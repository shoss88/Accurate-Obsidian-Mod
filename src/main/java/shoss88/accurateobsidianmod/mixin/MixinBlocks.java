package shoss88.accurateobsidianmod.mixin;

import net.minecraft.block.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;
import org.spongepowered.asm.mixin.injection.points.BeforeInvoke;

@Mixin(Blocks.class)
public abstract class MixinBlocks {

    @ModifyArgs(at = @At(value = "INVOKE", ordinal=0))
    private static void fixForObsidian(Args args) {
        args.set(0, 5.0f);
        args.set(1, 10.0f);
    }
//    @ModifyArgs(method = "register", at = @At(value = "INVOKE",
//            target = "Lnet/minecraft/registry/Registry;register(Lnet/minecraft/registry/Registry;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;"))
//    private static void fixObsidianHardness(Args args){
//        String id = args.get(1);
//        if (id.equals("obsidian")){
//            args.set(0, args.get(0));
//            args.set(1, args.get(1));
//            args.set(2, new Block(AbstractBlock.Settings.of(Material.STONE, MapColor.BLACK).requiresTool().strength(5.0f, 10.0f)));
//        }
//        else{
//            args.set(0, args.get(0));
//            args.set(1, args.get(1));
//            args.set(2, args.get(2));
//        }
//    }
}
