package net.ldm.delightful_dishes.block;

import net.ldm.delightful_dishes.core.init.DelightfulDishes;
import net.ldm.delightful_dishes.core.init.DelightfulDishesTags;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("deprecation")
public class CooktopBlock extends HorizontalFacingBlock implements Waterloggable {
    private static final VoxelShape OUTLINE;
    public static final IntProperty PANS = IntProperty.of("pans", 0, 4);
    public static final BooleanProperty LIT = Properties.LIT;
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public CooktopBlock(Settings settings ) {
        super(settings);
        setDefaultState(getDefaultState()
                .with(PANS, 0)
                .with(LIT, false)
                .with(Properties.HORIZONTAL_FACING, Direction.NORTH)
                .with(WATERLOGGED, false)
        );
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(PANS, LIT, Properties.HORIZONTAL_FACING, WATERLOGGED);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState()
                .with(Properties.HORIZONTAL_FACING, ctx.getPlayerFacing().getOpposite())
                .with(WATERLOGGED, ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED))
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack stack = player.getStackInHand(hand);

        if (stack.getRegistryEntry().isIn(DelightfulDishesTags.FIRE_STARTERS) && !state.get(LIT)) {
            player.playSound(SoundEvents.ITEM_FIRECHARGE_USE, 1, 1);
            world.setBlockState(pos, state.with(LIT, true));
            // TODO: 2023-08-20 Damage/decrement item stack
        } else if (stack.isOf(DelightfulDishes.FRYING_PAN) && state.get(PANS) < 4) {
            player.playSound(SoundEvents.BLOCK_ANVIL_PLACE, 1, 1);
            world.setBlockState(pos, state.with(PANS, state.get(PANS) + 1));
            stack.decrement(1);
        } else {
            // TODO: 2023-08-24 For some reason, right-clicking the block with a water bucket does nothing; fix this.
            super.onUse(state, world, pos, player, hand, hit);
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (!state.get(LIT)) return;
        double d = (double)pos.getX() + 0.5;
        double e = (double)pos.getY() + 0.7;
        double f = (double)pos.getZ() + 0.5;
        world.addParticle(ParticleTypes.SMOKE, d, e, f, 0.0, 0.0, 0.0);
    }

    @Override
    public VoxelShape getOutlineShape( BlockState state, BlockView world, BlockPos pos, ShapeContext context ) {
        return OUTLINE;
    }

    static {
        VoxelShape body = Block.createCuboidShape(0, 0, 1, 16, 4, 16);
        OUTLINE = VoxelShapes.union(body);
    }
}
