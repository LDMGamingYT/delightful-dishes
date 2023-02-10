package net.ldm.mo_food.block.entity;

import net.ldm.mo_food.core.BasicInventory;
import net.ldm.mo_food.core.init.MoFood;
import net.ldm.mo_food.recipe.SiftingRecipe;
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

import java.util.Optional;

public class SifterBlockEntity extends BlockEntity implements BasicInventory {
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(1, ItemStack.EMPTY);
    public long animationStartTime;
    public static int timer;
    public static boolean inUse;
    public static Optional<SiftingRecipe> storedResult;

    public SifterBlockEntity(BlockPos pos, BlockState state) {
        super(MoFood.SIFTER_BLOCK_ENTITY, pos, state);
    }

    @Override
    protected void writeNbt( NbtCompound nbt ) {
        super.writeNbt(nbt);
        nbt.putLong("animationStartTime", animationStartTime);
        nbt.putInt("timer", timer);
        nbt.putBoolean("inUse", inUse);
        Inventories.writeNbt(nbt, items);
    }

    @Override
    public void readNbt( NbtCompound nbt ) {
        super.readNbt(nbt);
        animationStartTime = nbt.getLong("animationStartTime");
        timer = nbt.getInt("timer");
        inUse = nbt.getBoolean("inUse");
        Inventories.readNbt(nbt, items);
    }

    public static void tick(World world, BlockPos pos, BlockState state, SifterBlockEntity blockEntity) {
        if (timer == 0 && storedResult.isPresent()) {
            world.spawnEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), storedResult.get().getOutput().copy()));
            inUse = false;
        }
        timer--;
        System.out.println(timer);
    }

    public void resetTimer() {
        timer = 45;
    }
    public void markInUse() {
        resetTimer();
        inUse = true;
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
