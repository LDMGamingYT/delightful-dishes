package net.ldm.delightful_dishes.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

@SuppressWarnings("deprecation")
public class CooktopBlock extends Block {
    private static final VoxelShape OUTLINE;
    public static final IntProperty PANS = IntProperty.of("pans", 0, 4);
    public static final BooleanProperty LIT = BooleanProperty.of("lit");

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
        if (state.get(LIT)) return ActionResult.SUCCESS;
        player.playSound(SoundEvents.ITEM_FIRECHARGE_USE, 1, 1);
        world.setBlockState(pos, state.with(LIT, true));
        return ActionResult.SUCCESS;
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
