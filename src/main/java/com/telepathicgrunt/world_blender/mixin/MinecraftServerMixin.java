package com.telepathicgrunt.world_blender.mixin;

import com.mojang.authlib.GameProfileRepository;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.datafixers.DataFixer;
import com.telepathicgrunt.world_blender.WorldBlender;
import com.telepathicgrunt.world_blender.generation.WBBiomeProvider;
import com.telepathicgrunt.world_blender.surfacebuilder.BlendedSurfaceBuilder;
import com.telepathicgrunt.world_blender.the_blender.IdentifierPrinting;
import com.telepathicgrunt.world_blender.the_blender.TheBlender;
import net.minecraft.resource.ResourcePackManager;
import net.minecraft.resource.ServerResourceManager;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.WorldGenerationProgressListenerFactory;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.UserCache;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.SaveProperties;
import net.minecraft.world.level.storage.LevelStorage;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.net.Proxy;


@Mixin(MinecraftServer.class)
public class MinecraftServerMixin {

    @Inject(
            method = "<init>",
            at = @At(value = "TAIL")
    )
    private void modifyBiomeRegistry(Thread thread, DynamicRegistryManager.Impl impl, LevelStorage.Session session, SaveProperties saveProperties, ResourcePackManager resourcePackManager, Proxy proxy, DataFixer dataFixer, ServerResourceManager serverResourceManager, MinecraftSessionService minecraftSessionService, GameProfileRepository gameProfileRepository, UserCache userCache, WorldGenerationProgressListenerFactory worldGenerationProgressListenerFactory, CallbackInfo ci) {

        if(impl.getOptional(Registry.BIOME_KEY).isPresent()) {
            TheBlender.blendTheWorld(impl);
            if(WorldBlender.WB_CONFIG.WBBlendingConfig.identifierDump){
                IdentifierPrinting.printAllIdentifiers(impl);
            }
        }
    }
}
