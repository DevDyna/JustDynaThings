package com.devdyna.justdynathings.registry.builders.functional_anvils.eclipsealloy;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.client.builder.anvil.eclipsealloy.EclipseAlloyAnvilGUI;
import com.devdyna.justdynathings.registry.builders.functional_anvils.CAnvilBlock;
import com.devdyna.justdynathings.registry.types.zBlockEntities;
import com.devdyna.justdynathings.utils.Actions;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item.TooltipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

import javax.annotation.Nullable;

public class EclipseAlloyAnvilBlock extends CAnvilBlock {

    public EclipseAlloyAnvilBlock() {
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

    @Override
    public void appendHoverText(ItemStack i, TooltipContext c, List<Component> t,
            TooltipFlag f) {
        super.appendHoverText(i, c, t, f);
        t.add(Component.translatable(Main.ID + "." + Constants.Anvils.t4 + ".tip"));
        t.add(Component.translatable(Main.ID + "." + Constants.Anvils.t4 + ".boost"));
    }
}