package com.skinnydevi.songs_of_war.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import com.skinnydevi.songs_of_war.SongsOfWarMod;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WeaponForgerGui extends AbstractContainerScreen<WeaponForgerMenu> {
	private static final ResourceLocation GUI_TEXTURE = new ResourceLocation(SongsOfWarMod.MOD_ID,
			"textures/gui/container/weapon_forger_crafting_gui.png");
	private static final int GUI_WIDTH = 176;
	private static final int GUI_HEIGHT = 222;

	public WeaponForgerGui(
			WeaponForgerMenu menu, Inventory inv,
			Component component) {
		super(menu, inv, component);

		this.imageWidth = GUI_WIDTH;
		this.imageHeight = GUI_HEIGHT;
	}

	@Override
	protected void renderBg(PoseStack pPoseStack, float partialTick, int mouseX, int mouseY) {
		RenderSystem.setShader(GameRenderer::getPositionColorTexShader);
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.setShaderTexture(0, GUI_TEXTURE);

		int x = (width - imageWidth) / 2;
		int y = (height - imageHeight) / 2;

		this.blit(pPoseStack, x, y, 0, 0, imageWidth, imageHeight);
	}

	@Override
	protected void renderLabels(PoseStack matrixStack, int mouseX, int mouseY) {
		this.font.draw(matrixStack, this.title, 8.0F, 8.0F, 4210752);
		this.font.draw(matrixStack, this.playerInventoryTitle, 8.0F, 126.0F, 4210752);
	}

	@Override
	public void render(PoseStack poseStack, int mouseX, int mouseY, float delta) {
		renderBackground(poseStack);
		super.render(poseStack, mouseX, mouseY, delta);
		renderTooltip(poseStack, mouseX, mouseY);
	}

}
