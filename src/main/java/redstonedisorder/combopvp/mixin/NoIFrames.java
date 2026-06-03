package redstonedisorder.combopvp.mixin;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static redstonedisorder.combopvp.ComboPvP.cooldown;

@Mixin(LivingEntity.class)
public class NoIFrames {
    @Inject(method = "hurtServer", at = @At("TAIL"))
    private void hurtServer(ServerLevel level, DamageSource source, float damage, CallbackInfoReturnable<Boolean> cir) {
        if (cir.getReturnValue()) {
            LivingEntity self = (LivingEntity) (Object) this;
            Entity attacker = source.getEntity();
            if (attacker != null) if (attacker.getType() == EntityType.PLAYER) self.invulnerableTime = cooldown;
        }
    }
}
