package net.ldm.mo_food.client.render;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.ldm.mo_food.block.SifterBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.World;

@Environment(EnvType.CLIENT)
public class SifterBlockEntityRenderer implements BlockEntityRenderer<SifterBlockEntity> {
    private static ItemStack item = ItemStack.EMPTY;

    public SifterBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {}

    public void updateItem(SifterBlockEntity blockEntity) {
        item = blockEntity.getStack(0);
    }

    //TODO: Fix item not disappearing after being removed (possible client desync?)
    @Override
    public void render( SifterBlockEntity blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay ) {
        updateItem(blockEntity);
        System.out.println(item+": "+!(item.isEmpty() || item.isOf(Items.AIR)));

        matrices.push();

        World world = blockEntity.getWorld();
        assert world != null;

        if (!(item.isEmpty() || item.isOf(Items.AIR))) {
            double offset = Math.sin((world.getTime() + tickDelta) / 8.0) / 4.0; // Calculate the current offset in the y value
            matrices.translate(0.5, 1.25 + offset, 0.5); // Move the item
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees((world.getTime() + tickDelta) * 4)); // Rotate the item

            int lightAbove = WorldRenderer.getLightmapCoordinates(blockEntity.getWorld(), blockEntity.getPos().up());
            MinecraftClient.getInstance().getItemRenderer().renderItem(item, ModelTransformation.Mode.GROUND, lightAbove, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
        }

        matrices.pop();
    }
}
