package me.videogamesm12.hotbarfaildetector.mixin;

import me.videogamesm12.hotbarfaildetector.api.HotbarLoadFailedEvent;
import me.videogamesm12.hotbarfaildetector.api.HotbarSaveFailedEvent;
import net.minecraft.client.options.HotbarStorage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HotbarStorage.class)
public class HotbarStorageLog4JMixin
{
    @Inject(method = "load", at = @At(value = "INVOKE", target = "Lorg/apache/logging/log4j/Logger;error(Ljava/lang/String;Ljava/lang/Throwable;)V", shift = At.Shift.AFTER))
    public void onLoadFailure(CallbackInfo ci)
    {
        HotbarLoadFailedEvent.EVENT.invoker().onLoadFailure();
    }

    @Inject(method = "save", at = @At(value = "INVOKE",target = "Lorg/apache/logging/log4j/Logger;error(Ljava/lang/String;Ljava/lang/Throwable;)V", shift = At.Shift.AFTER))
    public void onSaveFailure(CallbackInfo ci)
    {
        HotbarSaveFailedEvent.EVENT.invoker().onSaveFailure();
    }
}
