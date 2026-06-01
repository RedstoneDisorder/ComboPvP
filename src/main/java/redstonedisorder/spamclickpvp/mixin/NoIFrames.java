package redstonedisorder.spamclickpvp.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static redstonedisorder.spamclickpvp.Command.cooldown;

@Mixin(LivingEntity.class)
public class NoIFrames {
	@Inject(at = @At("TAIL"), method = "damage")
	private void damage(ServerWorld world, DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
		if (cir.getReturnValue()) {
			LivingEntity self = (LivingEntity) (Object) this;
			Entity attacker = source.getAttacker();
			if (attacker != null) if (attacker.isPlayer()) self.timeUntilRegen = cooldown;
		}
	}
}