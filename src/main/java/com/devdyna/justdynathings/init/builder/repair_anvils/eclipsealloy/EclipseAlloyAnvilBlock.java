package com.devdyna.justdynathings.init.builder.repair_anvils.eclipsealloy;

import com.devdyna.justdynathings.api.Actions;
import com.devdyna.justdynathings.api.repair_anvils.CAnvilBlock;
import com.devdyna.justdynathings.init.types.zBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class EclipseAlloyAnvilBlock extends CAnvilBlock {

    public EclipseAlloyAnvilBlock(Properties p) {
        super(p);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos p, BlockState s) {
        return new EclipseAlloyAnvilBE(zBlockEntities.ECLIPSEALLOY_ANVIL.get(), p, s);
    }

    @Override
    public void openMenu(Player p, BlockPos b) {
        Actions.openMenu(p, (w, i, e) -> new EclipseAlloyAnvilGUI(w, i, b), b);
    }

    @Override
    public boolean isValidBE(BlockEntity b) {
        return b instanceof EclipseAlloyAnvilBE;
    }

    //TODO tip
    // @Override
    // public void appendHoverText(ItemStack i, TooltipContext c, List<Component> t,
    //         TooltipFlag f) {
    //     super.appendHoverText(i, c, t, f);
    //     t.add(Component.translatable(Main.ID + "." + Constants.Anvils.t4 ));
    //     t.add(Component.translatable(Main.ID + "." + Constants.Anvils.t4 + ".boost"));
    // }

    @Override
    public boolean supportFluidContent() {
        return true;
    }
}