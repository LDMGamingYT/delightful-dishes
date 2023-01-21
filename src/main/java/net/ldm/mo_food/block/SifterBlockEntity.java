package net.ldm.mo_food.block;

import net.ldm.mo_food.core.BasicInventory;
import net.ldm.mo_food.core.init.MoFood;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

public class SifterBlockEntity extends BlockEntity implements BasicInventory {
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(1, ItemStack.EMPTY);

    public SifterBlockEntity(BlockPos pos, BlockState state) {
        super(MoFood.SIFTER_BLOCK_ENTITY, pos, state);
    }

    @Override
    public void readNbt( NbtCompound nbt ) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, items);
    }

    @Override
    protected void writeNbt( NbtCompound nbt ) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, items);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }
}
