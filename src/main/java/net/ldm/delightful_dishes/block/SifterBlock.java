package net.ldm.delightful_dishes.block;

import net.ldm.delightful_dishes.block.entity.SifterBlockEntity;
import net.ldm.delightful_dishes.core.init.DelightfulDishes;
import net.ldm.delightful_dishes.recipe.SiftingRecipe;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class SifterBlock extends Block implements BlockEntityProvider {
    private static final VoxelShape LEG_1;
    private static final VoxelShape LEG_2;
    private static final VoxelShape LEG_3;
    private static final VoxelShape LEG_4;
    private static final VoxelShape TOP_BORDER_NORTH;
    private static final VoxelShape TOP_BORDER_EAST;
    private static final VoxelShape TOP_BORDER_SOUTH;
    private static final VoxelShape TOP_BORDER_WEST;
    private static final VoxelShape NET;
    private static final VoxelShape FULL_SHAPE;

    public SifterBlock( Settings settings ) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity( BlockPos pos, BlockState state ) {
        return new SifterBlockEntity(pos, state);
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResult onUse( BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit ) {
        if (world.isClient) return ActionResult.SUCCESS;
        if (!(world.getBlockEntity(pos) instanceof SifterBlockEntity blockEntity)) return ActionResult.SUCCESS;
        if (blockEntity.inUse) return ActionResult.SUCCESS;

        ItemStack playerStack = player.getStackInHand(hand);
        if (blockEntity.getStack(0).isEmpty()) { // inventory empty, hand full
            if (playerStack.isEmpty()) return ActionResult.SUCCESS;
            blockEntity.setStack(0, player.getStackInHand(hand).copy());
            playerStack.decrement(1);
        } else {
            if (playerStack.isEmpty()) { //inventory full, hand empty
                player.setStackInHand(hand, blockEntity.getStack(0));
                blockEntity.setStack(0, ItemStack.EMPTY);
            } else { //inventory full, hand full
                ItemStack switchStack = blockEntity.getStack(0);
                blockEntity.setStack(0, playerStack);
                player.setStackInHand(hand, switchStack);
            }
        }
        Optional<SiftingRecipe> result = world.getRecipeManager().getFirstMatch(SiftingRecipe.Type.INSTANCE, blockEntity, world);

        blockEntity.animationStartTime = world.getTime();
        blockEntity.inUse = true;
        blockEntity.storeResult(result.map(SiftingRecipe::getOutput).orElse(null), result.map(SiftingRecipe::chance).orElse(1f));

        blockEntity.markDirty();

        world.updateListeners(pos, state, state, Block.NOTIFY_LISTENERS);
        return ActionResult.SUCCESS;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        if (!type.equals(DelightfulDishes.SIFTER_BLOCK_ENTITY)) throw new IllegalArgumentException("Unexpected block entity type");
        return (world1, pos, state1, blockEntity) -> SifterBlockEntity.tick(world1, pos, (SifterBlockEntity) blockEntity);
    }

    @Override
    public void onBreak( World world, BlockPos pos, BlockState state, PlayerEntity player ) {
        if (!(world.getBlockEntity(pos) instanceof SifterBlockEntity blockEntity)) return;
        world.spawnEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), blockEntity.getStack(0)));
        super.onBreak(world, pos, state, player);
        world.updateListeners(pos, state, state, Block.NOTIFY_LISTENERS);
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getOutlineShape( BlockState state, BlockView world, BlockPos pos, ShapeContext context ) {
        return FULL_SHAPE;
    }

    static {
        LEG_1 = Block.createCuboidShape(1, 0, 1, 3, 10, 3);
        LEG_2 = Block.createCuboidShape(13, 0, 1, 15, 10, 3);
        LEG_3 = Block.createCuboidShape(1, 0, 13, 3, 10, 15);
        LEG_4 = Block.createCuboidShape(13, 0, 13, 15, 10, 15);
        TOP_BORDER_NORTH = Block.createCuboidShape(12.75, 10, 0.75, 15.25, 12, 3.25);
        TOP_BORDER_EAST = Block.createCuboidShape(0.75, 10, 0.75, 15.25, 12, 12.25);
        TOP_BORDER_SOUTH = Block.createCuboidShape(0.75, 10, 12.25, 15.25, 12, 15.25);
        TOP_BORDER_WEST = Block.createCuboidShape(12.75, 10, 0.75, 15.25, 12, 3.25);
        NET = Block.createCuboidShape(3.25, 11, 3.25, 12.25, 11, 12.25);
        FULL_SHAPE = VoxelShapes.union(LEG_1, LEG_2, LEG_3, LEG_4, TOP_BORDER_NORTH, TOP_BORDER_EAST, TOP_BORDER_SOUTH, TOP_BORDER_WEST, NET);
    }
}
