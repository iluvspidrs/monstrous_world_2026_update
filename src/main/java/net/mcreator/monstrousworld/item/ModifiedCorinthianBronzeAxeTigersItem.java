package net.mcreator.monstrousworld.item;

import net.neoforged.neoforge.common.crafting.CompoundIngredient;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import net.mcreator.monstrousworld.procedures.ModifiedIronSwordTigersLivingEntityIsHitWithToolProcedure;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

import java.util.List;

public class ModifiedCorinthianBronzeAxeTigersItem extends AxeItem {
	private static final Tier TOOL_TIER = new Tier() {
		@Override
		public int getUses() {
			return 600;
		}

		@Override
		public float getSpeed() {
			return 8f;
		}

		@Override
		public float getAttackDamageBonus() {
			return 0;
		}

		@Override
		public TagKey<Block> getIncorrectBlocksForDrops() {
			return BlockTags.INCORRECT_FOR_DIAMOND_TOOL;
		}

		@Override
		public int getEnchantmentValue() {
			return 25;
		}

		@Override
		public Ingredient getRepairIngredient() {
			return CompoundIngredient.of(Ingredient.of(new ItemStack(MonstrousWorldModItems.CORINTHIAN_BRONZE_INGOT.get())), Ingredient.of(ItemTags.create(ResourceLocation.parse("c:ingots/corinthian_bronze"))));
		}
	};

	public ModifiedCorinthianBronzeAxeTigersItem() {
		super(TOOL_TIER, new Item.Properties().attributes(DiggerItem.createAttributes(TOOL_TIER, 7f, -3f)));
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		ModifiedIronSwordTigersLivingEntityIsHitWithToolProcedure.execute(entity.level(), entity);
		return retval;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.monstrous_world.modified_corinthian_bronze_axe_tigers.description_0"));
		list.add(Component.translatable("item.monstrous_world.modified_corinthian_bronze_axe_tigers.description_1"));
	}
}