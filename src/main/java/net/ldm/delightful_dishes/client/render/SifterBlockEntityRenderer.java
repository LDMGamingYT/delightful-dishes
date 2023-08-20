package net.ldm.delightful_dishes.client.render;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.ldm.delightful_dishes.block.entity.SifterBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

@Environment(EnvType.CLIENT)
public class SifterBlockEntityRenderer implements BlockEntityRenderer<SifterBlockEntity> {
    private ItemStack item = ItemStack.EMPTY;

    public SifterBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
    }

    public void updateItem(SifterBlockEntity blockEntity) {
        item = blockEntity.getStack(0);
    }

    //TODO: Fix item not disappearing after being removed (possible client desync?)
    @Override
    public void render(SifterBlockEntity blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        updateItem(blockEntity);
        matrices.push();

        World world = blockEntity.getWorld();
        assert world != null;

        float offset = ((float) (blockEntity.getWorld().getTime() - blockEntity.animationStartTime) + tickDelta) / 150f; // Calculate the current offset in the y value

        if (offset >= 0.3f) {
            MinecraftClient.getInstance().getItemRenderer().renderItem(ItemStack.EMPTY, ModelTransformation.Mode.GROUND,
                    light, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
        } else {
            matrices.translate(0.5, 0.7 - offset, 0.5); // move the item to the center, and follow the "offset"

            int lightAbove = WorldRenderer.getLightmapCoordinates(blockEntity.getWorld(), blockEntity.getPos().up());
            MinecraftClient.getInstance().getItemRenderer().renderItem(item, ModelTransformation.Mode.GROUND, lightAbove,
                    OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
        }

        matrices.pop();
    }
}
