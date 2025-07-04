package com.devdyna.justdynathings.registry.builders;

import static com.devdyna.justdynathings.Main.ID;

import java.util.List;

import com.devdyna.justdynathings.registry.types.zProperties;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
@SuppressWarnings("null")
public class DisabledItem extends Item{

    public DisabledItem() {
        super(zProperties.iProp);
    }
    
    @Override
    public void appendHoverText(ItemStack i, TooltipContext c, List<Component> t,
            TooltipFlag f) {
                t.add(Component.translatable(ID+".disabled"));
    }
    
}
