package com.telepathicgrunt.world_blender.mixin;

import net.minecraft.block.Block;
import net.minecraft.world.gen.carver.Carver;
import net.minecraft.world.gen.carver.CarverConfig;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Set;

@Mixin(ConfiguredCarver.class)
public interface ConfiguredCarverAccessor{

    @Accessor("carver")
    <WC extends CarverConfig>
    Carver<WC> getcarver();
}