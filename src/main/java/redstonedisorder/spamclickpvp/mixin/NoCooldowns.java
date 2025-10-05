package redstonedisorder.spamclickpvp.mixin;

import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class NoCooldowns {
	@Inject(at = @At("HEAD"), cancellable = true, method = "getAttackCooldownProgress")
	private void getAttackCooldownProgress(float baseTime, CallbackInfoReturnable<Float> cir) {
		cir.setReturnValue(1f);
	}
}