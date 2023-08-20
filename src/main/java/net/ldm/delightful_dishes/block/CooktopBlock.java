package net.ldm.delightful_dishes.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class CooktopBlock extends Block {
    private static final VoxelShape OUTLINE;

    public CooktopBlock(Settings settings ) {
        super(settings);
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
