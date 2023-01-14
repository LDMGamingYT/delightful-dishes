package disabled_classes;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class CooktopBlockEntity extends AbstractFurnaceBlockEntity {
    public CooktopBlockEntity( BlockPos pos, BlockState state) {
        super(MoreFood.COOKTOP_BLOCK_ENTITY, pos, state, MoreFood.COOKTOP_RECIPE);
    }

    @Override
    public Text getContainerName() {
        return Text.of("Cooktop");
    }

    @Override
    public ScreenHandler createScreenHandler( int syncId, PlayerInventory playerInventory) {
        return new CooktopScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }
}
