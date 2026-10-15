package net.mcreator.monstrousworld.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

import java.util.List;

@JeiPlugin
public class MonstrousWorldModJeiInformation implements IModPlugin {
	@Override
	public ResourceLocation getPluginUid() {
		return ResourceLocation.parse("monstrous_world:information");
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		registration.addIngredientInfo(List.of(new ItemStack(MonstrousWorldModItems.DARKENED_IRON_INGOT.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.monstrous_world.darkened_iron_ingot_info"));
		registration.addIngredientInfo(
				List.of(new ItemStack(MonstrousWorldModItems.BOTTLE_OF_BLOOD.get()), new ItemStack(MonstrousWorldModItems.BOTTLE_OF_WEAK_BLOOD.get()), new ItemStack(MonstrousWorldModItems.BOTTLE_OF_GOBLIN_BLOOD.get()),
						new ItemStack(MonstrousWorldModItems.BOTTLE_OF_TROLL_BLOOD.get()), new ItemStack(MonstrousWorldModItems.BOTTLE_OF_SWAMPMONSTER_BLOOD.get()), new ItemStack(MonstrousWorldModItems.BOTTLE_OF_WEREWOLF_BLOOD.get()),
						new ItemStack(MonstrousWorldModItems.BOTTLE_OF_SERPENT_MUTANT_BLOOD.get()), new ItemStack(MonstrousWorldModItems.BOTTLE_OF_FLY_MUTANT_BLOOD.get()), new ItemStack(MonstrousWorldModItems.BOTTLE_OF_EYE_MUTANT_BLOOD.get())),
				VanillaTypes.ITEM_STACK, Component.translatable("jei.monstrous_world.blood_bottles"));
		registration.addIngredientInfo(List.of(new ItemStack(MonstrousWorldModBlocks.SIMPLE_CAULDRON.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.monstrous_world.simple_cauldron_info"));
		registration.addIngredientInfo(List.of(new ItemStack(MonstrousWorldModBlocks.ADVANCED_CAULDRON.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.monstrous_world.advanced_cauldron_info"));
		registration.addIngredientInfo(List.of(new ItemStack(MonstrousWorldModBlocks.CHARM_ALTAR.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.monstrous_world.charm_altar_info"));
		registration.addIngredientInfo(List.of(new ItemStack(MonstrousWorldModBlocks.GOBLIN_WORKSTATION.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.monstrous_world.goblin_workstation_info"));
		registration.addIngredientInfo(List.of(new ItemStack(MonstrousWorldModBlocks.GOBLIN_OVEN.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.monstrous_world.goblin_oven_info"));
		registration.addIngredientInfo(List.of(new ItemStack(MonstrousWorldModItems.DARK_ESSENCE_DUST.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.monstrous_world.dark_essence_dust_info"));
		registration.addIngredientInfo(List.of(new ItemStack(MonstrousWorldModItems.CASSITERITE_CRYSTAL.get()), new ItemStack(MonstrousWorldModBlocks.CASSITERITE_ORE.get()), new ItemStack(MonstrousWorldModBlocks.BLOCK_OF_RAW_CASSITERITE.get())),
				VanillaTypes.ITEM_STACK, Component.translatable("jei.monstrous_world.cassiterite_info"));
		registration.addIngredientInfo(List.of(new ItemStack(MonstrousWorldModItems.TIN_INGOT.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.monstrous_world.tin_ingot_info"));
		registration.addIngredientInfo(List.of(new ItemStack(MonstrousWorldModItems.SILVER_INGOT.get()), new ItemStack(MonstrousWorldModBlocks.SILVER_ORE.get()), new ItemStack(MonstrousWorldModItems.SILVER_NUGGET.get()),
				new ItemStack(MonstrousWorldModItems.SILVER_DUST.get()), new ItemStack(MonstrousWorldModBlocks.BLOCK_OF_SILVER.get()), new ItemStack(MonstrousWorldModItems.PURIFIED_SILVER.get()),
				new ItemStack(MonstrousWorldModItems.PURIFIED_SILVER_DUST.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.monstrous_world.silver_info"));
		registration.addIngredientInfo(List.of(new ItemStack(MonstrousWorldModItems.MALACHITE.get()), new ItemStack(MonstrousWorldModBlocks.BLOCK_OF_MALACHITE.get()), new ItemStack(MonstrousWorldModItems.PURIFIED_MALACHITE.get()),
				new ItemStack(MonstrousWorldModBlocks.CONCENTRATED_MALACHITE.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.monstrous_world.malachite_info"));
		registration.addIngredientInfo(List.of(new ItemStack(MonstrousWorldModItems.MOONSTONE.get()), new ItemStack(MonstrousWorldModBlocks.MOONSTONE_ORE.get()), new ItemStack(MonstrousWorldModBlocks.BLOCK_OF_MOONSTONE.get()),
				new ItemStack(MonstrousWorldModItems.PURIFIED_MOONSTONE.get()), new ItemStack(MonstrousWorldModBlocks.CONCENTRATED_MOONSTONE.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.monstrous_world.moonstone_info"));
		registration.addIngredientInfo(List.of(new ItemStack(MonstrousWorldModItems.TIGERS_EYE.get()), new ItemStack(MonstrousWorldModBlocks.TIGERS_EYE_ORE.get()), new ItemStack(MonstrousWorldModBlocks.BLOCK_OF_TIGERS_EYE.get()),
				new ItemStack(MonstrousWorldModItems.PURIFIED_TIGERS_EYE.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.monstrous_world.tigers_eye_info"));
		registration.addIngredientInfo(
				List.of(new ItemStack(MonstrousWorldModItems.GREEN_AGATE.get()), new ItemStack(MonstrousWorldModItems.BLUE_AGATE.get()), new ItemStack(MonstrousWorldModItems.PALE_AGATE.get()), new ItemStack(MonstrousWorldModItems.RED_AGATE.get()),
						new ItemStack(MonstrousWorldModItems.PURIFIED_GREEN_AGATE.get()), new ItemStack(MonstrousWorldModItems.PURIFIED_BLUE_AGATE.get()), new ItemStack(MonstrousWorldModItems.PURIFIED_PALE_AGATE.get()),
						new ItemStack(MonstrousWorldModItems.PURIFIED_RED_AGATE.get()), new ItemStack(MonstrousWorldModBlocks.ODD_GREEN_GRAVEL.get()), new ItemStack(MonstrousWorldModBlocks.BLOCK_OF_GREEN_AGATE.get()),
						new ItemStack(MonstrousWorldModBlocks.ODD_BLUE_GRAVEL.get()), new ItemStack(MonstrousWorldModBlocks.BLOCK_OF_BLUE_AGATE.get()), new ItemStack(MonstrousWorldModBlocks.ODD_PALE_GRAVEL.get()),
						new ItemStack(MonstrousWorldModBlocks.BLOCK_OF_PALE_AGATE.get()), new ItemStack(MonstrousWorldModBlocks.ODD_RED_GRAVEL.get()), new ItemStack(MonstrousWorldModBlocks.BLOCK_OF_RED_AGATE.get())),
				VanillaTypes.ITEM_STACK, Component.translatable("jei.monstrous_world.agate_info"));
		registration.addIngredientInfo(
				List.of(new ItemStack(MonstrousWorldModItems.CLEAR_QUARTZ_SHARD.get()), new ItemStack(MonstrousWorldModItems.ROSE_QUARTZ_SHARD.get()), new ItemStack(MonstrousWorldModBlocks.BLOCK_OF_CLEAR_QUARTZ.get()),
						new ItemStack(MonstrousWorldModBlocks.CLEAR_QUARTZ_ORE.get()), new ItemStack(MonstrousWorldModBlocks.BLOCK_OF_ROSE_QUARTZ.get()), new ItemStack(MonstrousWorldModBlocks.ROSE_QUARTZ_ORE.get()),
						new ItemStack(MonstrousWorldModItems.PURIFIED_CLEAR_QUARTZ_SHARD.get()), new ItemStack(MonstrousWorldModItems.PURIFIED_ROSE_QUARTZ_SHARD.get())),
				VanillaTypes.ITEM_STACK, Component.translatable("jei.monstrous_world.quartz_info"));
		registration.addIngredientInfo(List.of(new ItemStack(MonstrousWorldModItems.BLACK_ONYX.get()), new ItemStack(MonstrousWorldModItems.SARDONYX.get()), new ItemStack(MonstrousWorldModBlocks.BLOCK_OF_BLACK_ONYX.get()),
				new ItemStack(MonstrousWorldModBlocks.BLACK_ONYX_STONE_ORE.get()), new ItemStack(MonstrousWorldModBlocks.BLACK_ONYX_DEEPSLATE_ORE.get()), new ItemStack(MonstrousWorldModBlocks.BLOCK_OF_SARDOYNX.get()),
				new ItemStack(MonstrousWorldModBlocks.SARDONYX_STONE_ORE.get()), new ItemStack(MonstrousWorldModBlocks.SARDONYX_DEEPSLATE_ORE.get()), new ItemStack(MonstrousWorldModItems.PURIFIED_ONYX.get()),
				new ItemStack(MonstrousWorldModItems.PURIFIED_SARDONYX.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.monstrous_world.black_onyx_and_sardonyx_info"));
		registration.addIngredientInfo(List.of(new ItemStack(MonstrousWorldModItems.NETHER_GEM.get()), new ItemStack(MonstrousWorldModBlocks.NETHER_GEM_ORE.get()), new ItemStack(MonstrousWorldModBlocks.BLOCK_OF_NETHER_GEMS.get()),
				new ItemStack(MonstrousWorldModItems.PURIFIED_NETHER_GEM.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.monstrous_world.nether_gem_info"));
		registration.addIngredientInfo(List.of(new ItemStack(MonstrousWorldModBlocks.SWAMP_CRYSTAL_ORE.get()), new ItemStack(MonstrousWorldModBlocks.BLOCK_OF_SWAMP_CRYSTAL.get()), new ItemStack(MonstrousWorldModItems.SWAMP_CRYSTAL_SHARD.get()),
				new ItemStack(MonstrousWorldModBlocks.CONCENTRATED_SWAMP_CRYSTAL.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.monstrous_world.swamp_crystal_info"));
		registration.addIngredientInfo(List.of(new ItemStack(MonstrousWorldModItems.PUMPKIN_ESSENCE.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.monstrous_world.pumpkin_essence_info"));
		registration.addIngredientInfo(List.of(new ItemStack(MonstrousWorldModItems.SPIRIT_DUST.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.monstrous_world.spirit_dust_information"));
		registration.addIngredientInfo(List.of(new ItemStack(MonstrousWorldModItems.A_HINT_OF_INSANITY.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.monstrous_world.a_hint_of_insanity_info"));
		registration.addIngredientInfo(List.of(new ItemStack(MonstrousWorldModItems.UNDEATHLY_ESSENCE.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.monstrous_world.undeathly_essence_info"));
		registration.addIngredientInfo(List.of(new ItemStack(MonstrousWorldModItems.HINT_OF_SANITY.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.monstrous_world.a_hint_of_sanity"));
	}
}