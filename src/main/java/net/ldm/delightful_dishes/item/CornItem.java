package net.ldm.delightful_dishes.item;

import net.ldm.delightful_dishes.core.init.DelightfulDishes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.Objects;

public class CornItem extends BlockItem {

    public CornItem(Settings settings) {
        super(DelightfulDishes.CORN_CROP, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (Objects.requireNonNull(user.getStackInHand(hand).getOrCreateNbt()).getFloat("bites") >= 3)
            return TypedActionResult.pass(user.getStackInHand(hand));
        return super.use(world, user, hand);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        NbtCompound nbt = stack.getOrCreateNbt();
        nbt.putFloat("bites", nbt.getFloat("bites") + 1);
        return super.finishUsing(stack, world, user);
    }
}
