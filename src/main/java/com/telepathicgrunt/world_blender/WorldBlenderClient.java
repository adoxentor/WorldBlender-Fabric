package com.telepathicgrunt.world_blender;

import com.telepathicgrunt.world_blender.blocks.WBBlocks;
import com.telepathicgrunt.world_blender.blocks.WBPortalBlockEntity;
import com.telepathicgrunt.world_blender.blocks.WBPortalBlockEntityRenderer;
import com.telepathicgrunt.world_blender.mixin.BlockEntityRenderDispatcherInvoker;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.SignBlockEntityRenderer;
import net.minecraft.util.math.BlockPos;

public class WorldBlenderClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		((BlockEntityRenderDispatcherInvoker)BlockEntityRenderDispatcher.INSTANCE).callRegister(WBBlocks.WORLD_BLENDER_PORTAL_BE, new WBPortalBlockEntityRenderer(BlockEntityRenderDispatcher.INSTANCE));

		// Set cooldown for portal after server says it was triggered
		ClientSidePacketRegistry.INSTANCE.register(WBIdentifiers.PORTAL_COOLDOWN_PACKET_ID,
				(packetContext, attachedData) -> {
					BlockPos blockPos = attachedData.readBlockPos();
					float cooldown = attachedData.readFloat();

					packetContext.getTaskQueue().execute(() -> {
						WBPortalBlockEntity wbPortalBlockEntity = null;

						if (MinecraftClient.getInstance().world != null)
							wbPortalBlockEntity = (WBPortalBlockEntity) MinecraftClient.getInstance().world.getBlockEntity(blockPos);

						if (wbPortalBlockEntity != null)
							wbPortalBlockEntity.setCoolDown(cooldown);
					});
				});
	}
}