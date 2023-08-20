package net.ldm.delightful_dishes.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

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

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getOutlineShape( BlockState state, BlockView world, BlockPos pos, ShapeContext context ) {
        return OUTLINE;
    }

    static {
        VoxelShape body = Block.createCuboidShape(0, 0, 1, 16, 4, 16);
        OUTLINE = VoxelShapes.union(body);
    }
}
