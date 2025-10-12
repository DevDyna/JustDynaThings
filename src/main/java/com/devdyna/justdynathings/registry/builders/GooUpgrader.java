package com.devdyna.justdynathings.registry.builders;

import static com.devdyna.justdynathings.Main.ID;

import java.util.ArrayList;
import java.util.List;

import com.devdyna.justdynathings.Constants;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;

@SuppressWarnings("null")
public class GooUpgrader extends Item {

    private ArrayList<Block> fromBlocks;
    private ArrayList<Block> toBlocks;
    private boolean makeAllasOne;

    public GooUpgrader(ArrayList<Block> fromBlocks, ArrayList<Block> toBlocks, boolean makeAllasOne) {
        super(new Item.Properties());
        this.fromBlocks = fromBlocks;
        this.toBlocks = toBlocks;
        this.makeAllasOne = makeAllasOne;
    }

    @Override
    public InteractionResult useOn(UseOnContext c) {
        var pos = c.getClickedPos();
        var level = c.getLevel();
        var state = level.getBlockState(pos);

        if (fromBlocks.contains(state.getBlock())) {
            level.setBlockAndUpdate(pos,
                    (makeAllasOne ? toBlocks.get(0) : toBlocks.get(fromBlocks.indexOf(state.getBlock())))
                            .defaultBlockState());
            c.getItemInHand().shrink(1);
            return InteractionResult.SUCCESS;
        } else

            return super.useOn(c);
    }

    @Override
    public void appendHoverText(ItemStack i, TooltipContext c, List<Component> t,
            TooltipFlag f) {
                t.add(Component.translatable(ID+"."+Constants.GooUpgraders.base));
    }

}
