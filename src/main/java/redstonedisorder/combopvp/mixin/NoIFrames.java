package redstonedisorder.combopvp.mixin;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static redstonedisorder.combopvp.ComboPvP.cooldown;

@Mixin(LivingEntity.class)
public class NoIFrames {
	@Shadow
	public int damageCooldownTime;

	@Inject(at = @At("TAIL"), method = "hurtServer")
	private void hurtServer(ServerLevel serverLevel, DamageSource damageSource, float f, CallbackInfoReturnable<Boolean> cir) {
		if (cir.getReturnValue() && damageSource.getDirectEntity() instanceof Player) this.damageCooldownTime = cooldown;
	}
}