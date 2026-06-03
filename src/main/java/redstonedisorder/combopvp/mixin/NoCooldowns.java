package redstonedisorder.combopvp.mixin;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public class NoCooldowns {
	@Inject(at = @At("HEAD"), method = "getAttackStrengthScale", cancellable = true)
	private void getAttackStrengthScale(float a, CallbackInfoReturnable<Float> cir) {
		cir.setReturnValue(1f);
	}
}