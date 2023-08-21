package net.ldm.delightful_dishes.block;

import net.ldm.delightful_dishes.core.init.DelightfulDishes;
import net.ldm.delightful_dishes.core.init.DelightfulDishesTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
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
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

@SuppressWarnings("deprecation")
public class CooktopBlock extends Block {
    private static final VoxelShape OUTLINE;
    public static final IntProperty PANS = IntProperty.of("pans", 0, 4);
    public static final BooleanProperty LIT = Properties.LIT;

    public CooktopBlock(Settings settings ) {
        super(settings);
        setDefaultState(getDefaultState().with(PANS, 0).with(LIT, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(PANS);
        builder.add(LIT);
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
