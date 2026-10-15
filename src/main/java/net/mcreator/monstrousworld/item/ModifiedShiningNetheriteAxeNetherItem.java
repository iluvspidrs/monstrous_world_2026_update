package net.mcreator.monstrousworld.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.network.chat.Component;

import net.mcreator.monstrousworld.procedures.ModifiedIronSwordNetherGemLivingEntityIsHitWithToolProcedure;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

import java.util.List;

public class ModifiedShiningNetheriteAxeNetherItem extends AxeItem {
	private static final Tier TOOL_TIER = new Tier() {
		@Override
		public int getUses() {
			return 3500;
		}

		@Override
		public float getSpeed() {
			return 10f;
		}

		@Override
		public float getAttackDamageBonus() {
			return 0;
		}

		@Override
		public TagKey<Block> getIncorrectBlocksForDrops() {
			return BlockTags.INCORRECT_FOR_NETHERITE_TOOL;
		}

		@Override
		public int getEnchantmentValue() {
			return 15;
		}

		@Override
		public Ingredient getRepairIngredient() {
			return Ingredient.of(new ItemStack(MonstrousWorldModItems.SHINING_NETHERITE_INGOT.get()));
		}
	};

	public ModifiedShiningNetheriteAxeNetherItem() {
		super(TOOL_TIER, new Item.Properties().attributes(DiggerItem.createAttributes(TOOL_TIER, 9f, -3f)).fireResistant());
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		ModifiedIronSwordNetherGemLivingEntityIsHitWithToolProcedure.execute(entity);
		return retval;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.monstrous_world.modified_shining_netherite_axe_nether.description_0"));
		list.add(Component.translatable("item.monstrous_world.modified_shining_netherite_axe_nether.description_1"));
		list.add(Component.translatable("item.monstrous_world.modified_shining_netherite_axe_nether.description_2"));
	}
}