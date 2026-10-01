package com.devdyna.justdynathings.init.builder.advanced_energy_transmitter;

import com.direwolf20.justdirethings.client.screens.basescreens.BaseMachineScreen;
import com.direwolf20.justdirethings.client.screens.standardbuttons.ToggleButtonFactory;
import com.direwolf20.justdirethings.client.screens.widgets.GrayscaleButton;
import com.direwolf20.justdirethings.common.blockentities.basebe.FluidMachineBE;
import com.direwolf20.justdirethings.common.blockentities.basebe.PoweredMachineBE;
import com.direwolf20.justdirethings.common.network.data.EnergyTransmitterSettingPayload;
import com.direwolf20.justdirethings.util.MagicHelpers;
import com.direwolf20.justdirethings.util.MiscTools;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.player.Inventory;
import net.neoforged.neoforge.client.network.ClientPacketDistributor;

public class AdvEnergyTransmitterScreen extends BaseMachineScreen<AdvEnergyTransmitterGUI> {
    public boolean showParticles;

    public AdvEnergyTransmitterScreen(AdvEnergyTransmitterGUI arg0, Inventory arg1, Component arg2) {
        super(arg0, arg1, arg2);

        if (container.baseMachineBE instanceof AdvEnergyTransmitterBE energyTransmitterBE)
            this.showParticles = energyTransmitterBE.showParticles;

    }

    public void init() {
        super.init();
        this.addRenderableWidget(ToggleButtonFactory.SHOWPARTICLESBUTTON(this.leftPos + 116, this.topSectionTop + 62,
                this.showParticles, (b) -> {
                    this.showParticles = !this.showParticles;
                    ((GrayscaleButton) b).toggleActive();
                    this.saveSettings();
                }));
    }

    public void addRedstoneButtons() {
        super.addRedstoneButtons();
    }

    public void setTopSection() {
        this.extraWidth = 60;
        this.extraHeight = 0;
    }

    public void addTickSpeedButton() {
    }

    public void saveSettings() {
        super.saveSettings();
        ClientPacketDistributor.sendToServer(new EnergyTransmitterSettingPayload(this.showParticles),
                new CustomPacketPayload[0]);
    }

    /**
     * TODO PR : JDT#516
     * <br/>
     * <br/>
     * https://github.com/Direwolf20-MC/JustDireThings/pull/516
     * <br/>
     * <br/>
     * Bruteforce override to move fluid tank render
     */
    @Override
    public void extractBackground(GuiGraphicsExtractor graphics, int arg1, int arg2, float arg3) {

        graphics.blitSprite(RenderPipelines.GUI_TEXTURED, this.SOCIALBACKGROUND, this.topSectionLeft + 20,
                this.topSectionTop - 20, this.topSectionWidth - 40, 20);

        graphics.blitSprite(RenderPipelines.GUI_TEXTURED, this.SOCIALBACKGROUND, this.topSectionLeft,
                this.topSectionTop, this.topSectionWidth, this.topSectionHeight);

        this.renderInventorySection(graphics, (this.width - this.imageWidth) / 2, (this.height - this.imageHeight) / 2);
        var inv = this.container.slots.iterator();

        while (inv.hasNext())
            this.drawSlot(graphics, inv.next());

        extractEnergy(graphics);
        extractFluid(graphics, 185, 0);

        if (this.renderablesChanged)
            this.updateRenderables();

    }

    public void extractEnergy(GuiGraphicsExtractor graphics) {
        if (this.baseMachineBE instanceof PoweredMachineBE poweredMachineBE) {
            graphics.blit(RenderPipelines.GUI_TEXTURED, this.POWERBAR, this.topSectionLeft + this.getEnergyBarOffset(),
                    this.topSectionTop + 5, 0.0F, 0.0F, 18, 72, 36, 72);
            var offset = poweredMachineBE.getMaxEnergy();
            var maxMB = 70;
            if (offset > 0) {
                int remaining = this.container.getEnergy() * maxMB / offset;
                graphics.blit(RenderPipelines.GUI_TEXTURED, this.POWERBAR,
                        this.topSectionLeft + this.getEnergyBarOffset() + 1,
                        this.topSectionTop + this.getEnergyBarOffset() + 72 - 2 - remaining, 19.0F,
                        69.0F - (float) remaining, 17, remaining + 1, 36, 72);
            }
        }
    }

    public void extractFluid(GuiGraphicsExtractor graphics, int x, int y) {
        if (this.baseMachineBE instanceof FluidMachineBE fluidMachineBE) {

            graphics.blit(RenderPipelines.GUI_TEXTURED, this.FLUIDBAR, this.topSectionLeft + getFluidBarOffset() + x,
                    this.topSectionTop + 5 + y, 0.0F, 0.0F, 18, 72, 36, 72);
            var maxMB = fluidMachineBE.getMaxMB();

            if (maxMB > 0)
                renderFluid(graphics, this.topSectionLeft + getFluidBarOffset() + 1 + x,
                        this.topSectionTop + 5 + 72 - 1 + y, 16,
                        this.container.getFluidAmount() * 70 / maxMB);

            graphics.blit(RenderPipelines.GUI_TEXTURED, this.FLUIDBAR, this.topSectionLeft + getFluidBarOffset() + x,
                    this.topSectionTop + 5 + y, 18.0F, 0.0F, 18, 72, 36, 72);

        }
    }

    public void fluidBarTooltip(GuiGraphicsExtractor graphics, int pX, int pY) {
        if (baseMachineBE instanceof FluidMachineBE fluidMachineBE) {
            if (MiscTools.inBounds(topSectionLeft + getFluidBarOffset() + 185, topSectionTop + 5, 18, 72, pX, pY)) {
                graphics.setTooltipForNextFrame(font, Minecraft.getInstance().hasShiftDown()
                        ? Component.translatable("justdirethings.screen.fluid",
                                this.container.getFluidStack().getHoverName(),
                                MagicHelpers.formatted(this.container.getFluidAmount()),
                                MagicHelpers.formatted(fluidMachineBE.getMaxMB()))
                        : Component.translatable("justdirethings.screen.fluid",
                                this.container.getFluidStack().getHoverName(),
                                MagicHelpers.withSuffix(this.container.getFluidAmount()),
                                MagicHelpers.withSuffix(fluidMachineBE.getMaxMB())),
                        pX, pY);
            }
        }
    }

}
