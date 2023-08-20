package net.ldm.delightful_dishes.block.entity;

import net.ldm.delightful_dishes.core.BasicInventory;
import net.ldm.delightful_dishes.core.LDMUtils;
import net.ldm.delightful_dishes.core.init.DelightfulDishes;
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
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class SifterBlockEntity extends BlockEntity implements BasicInventory {
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(1, ItemStack.EMPTY);
    public long animationStartTime;
    public boolean inUse;
    public ItemStack storedResultStack;
    public float storedResultChance;

    public SifterBlockEntity(BlockPos pos, BlockState state) {
        super(DelightfulDishes.SIFTER_BLOCK_ENTITY, pos, state);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putLong("animationStartTime", animationStartTime);
        nbt.putBoolean("inUse", inUse);
        nbt.putString("storedResult", LDMUtils.getItemID(storedResultStack));
        nbt.putFloat("storedResultChance", storedResultChance);
        Inventories.writeNbt(nbt, items);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        animationStartTime = nbt.getLong("animationStartTime");
        inUse = nbt.getBoolean("inUse");
        storedResultStack = LDMUtils.getItemOrNull(LDMUtils.getItemFromID(nbt.getString("storedResult")));
        storedResultChance = nbt.getFloat("storedResultChance");
        Inventories.readNbt(nbt, items);
    }

    public static void tick(World world, BlockPos pos, SifterBlockEntity blockEntity) {
        if (world.getTime() - blockEntity.animationStartTime == 45) {
            if (blockEntity.storedResultStack == null)
                world.spawnEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), blockEntity.getStack(0).copyWithCount(1))); //spawn input item
            else {
                if (Random.create().nextFloat() < blockEntity.storedResultChance)
                    world.spawnEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), blockEntity.storedResultStack.copy())); //spawn recipe result
            }

            blockEntity.setStack(0, ItemStack.EMPTY);
            blockEntity.inUse = false;
            blockEntity.markDirty();
        }
    }

    public void storeResult(ItemStack stack, float chance) {
        storedResultStack = stack;
        storedResultChance = chance;
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
