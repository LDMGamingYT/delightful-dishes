package net.ldm.mo_food.block.entity;

import net.ldm.mo_food.core.BasicInventory;
import net.ldm.mo_food.core.LDMUtils;
import net.ldm.mo_food.core.init.MoFood;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class SifterBlockEntity extends BlockEntity implements BasicInventory {
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(1, ItemStack.EMPTY);
    public long animationStartTime;
    public boolean inUse;
    public ItemStack storedResult;

    public SifterBlockEntity(BlockPos pos, BlockState state) {
        super(MoFood.SIFTER_BLOCK_ENTITY, pos, state);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putLong("animationStartTime", animationStartTime);
        nbt.putBoolean("inUse", inUse);
        nbt.putString("storedResult", LDMUtils.getItemID(storedResult));
        Inventories.writeNbt(nbt, items);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        animationStartTime = nbt.getLong("animationStartTime");
        inUse = nbt.getBoolean("inUse");
        storedResult = LDMUtils.getItemFromID(nbt.getString("storedResult")).asItem().getDefaultStack();
        Inventories.readNbt(nbt, items);
    }

    public static void tick(World world, BlockPos pos, SifterBlockEntity blockEntity) {
        if (world.getTime() - blockEntity.animationStartTime == 45) {
            if (blockEntity.storedResult == null)
                world.spawnEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), blockEntity.getStack(0).copy())); //spawn input item
            else
                world.spawnEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), blockEntity.storedResult.copy())); //spawn recipe result

            blockEntity.setStack(0, ItemStack.EMPTY);
            blockEntity.inUse = false;
        }
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }
}
