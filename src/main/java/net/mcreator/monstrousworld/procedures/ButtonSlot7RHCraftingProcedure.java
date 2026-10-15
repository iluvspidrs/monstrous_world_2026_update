package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.world.inventory.*;
import net.mcreator.monstrousworld.init.MonstrousWorldModMenus;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;

import io.netty.buffer.Unpooled;

public class ButtonSlot7RHCraftingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DARK_ESSENCE_DUST
				.get()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("DarkEssenceDustGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new DarkEssenceDustGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu3 ? _menu3.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.PUMPKIN_ESSENCE
				.get()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("PumpkinEssenceGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new PumpkinEssenceGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu6 ? _menu6.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SPIRIT_DUST.get()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("SpiritEssenceGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new SpiritEssenceGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu9 ? _menu9.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.MOON_DUST.get()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("MoonDustGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new MoonDustGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu12 ? _menu12.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.A_HINT_OF_INSANITY
				.get()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("InsanityEssenceGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new InsanityEssenceGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu15 ? _menu15.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.UNDEATHLY_ESSENCE
				.get()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("UndeathlyEssenceGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new UndeathlyEssenceGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu18 ? _menu18.getSlots().get(7).getItem() : ItemStack.EMPTY)
				.getItem() == MonstrousWorldModItems.ESSENCE_OF_ENCHANTMENT.get()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("EssenceOfEnchantmentGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new EssenceOfEnchantmentGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu21 ? _menu21.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DARKENED_WOOD_ASH
				.get()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("DarkenedWoodAshGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new DarkenedWoodAshGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu24 ? _menu24.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.HINT_OF_SANITY
				.get()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("ADoseOfSanityGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new ADoseOfSanityGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu27 ? _menu27.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.QUARTZ_DUST.get()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("QuartzDustGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new QuartzDustGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu30 ? _menu30.getSlots().get(7).getItem() : ItemStack.EMPTY)
				.getItem() == MonstrousWorldModItems.CULTIVATED_PUMPKIN_ESSENCE.get()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("CultivatedPumpkinEssenceGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new CultivatedPumpkinEssenceGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu33 ? _menu33.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SWAMP_ESSENCE_DUST
				.get()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("SwampEssenceDustGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new SwampEssenceDustGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu36 ? _menu36.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SWAMP_ESSENCE
				.get()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("SwampEssenceGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new SwampEssenceGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu39 ? _menu39.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.BOTTLE_OF_ACID
				.get()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("AcidBottleGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new AcidBottleGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu42 ? _menu42.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.VILE_SLIME.get()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("VileSlimeGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new VileSlimeGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu45 ? _menu45.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.ODD_ROOT.get()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("OddRootGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new OddRootGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu48 ? _menu48.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DIGESTED_ROTTEN_FLESH
				.get()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("DigestedRottenFleshGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new DigestedRottenFleshGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu51 ? _menu51.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DREADFUL_TEARS
				.get()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("DreadfulTearsGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new DreadfulTearsGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu54 ? _menu54.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.VENOM_BOTTLE.get()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("VenomBottleGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new VenomBottleGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu57 ? _menu57.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.ESSENCE_OF_DECEPTION
				.get()) {
			RHEssenceOfDeceptionProcedure.execute(entity);
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu59 ? _menu59.getSlots().get(7).getItem() : ItemStack.EMPTY)
				.is(ItemTags.create(ResourceLocation.parse("monstrous_world:monstrous_plants")))) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("MonstrousPlantsGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new MonstrousPlantsGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu62 ? _menu62.getSlots().get(7).getItem() : ItemStack.EMPTY)
				.is(ItemTags.create(ResourceLocation.parse("c:ingots/silver")))
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu64 ? _menu64.getSlots().get(7).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:dusts/silver")))
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu66 ? _menu66.getSlots().get(7).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:nuggets/silver")))
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu68 ? _menu68.getSlots().get(7).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:storage_blocks/silver")))) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("SilverGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new SilverGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu71 ? _menu71.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.PURIFIED_SILVER
				.get()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("PurifiedSilverGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new PurifiedSilverGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu74 ? _menu74.getSlots().get(7).getItem() : ItemStack.EMPTY)
				.is(ItemTags.create(ResourceLocation.parse("c:ores/cassiterite")))
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu76 ? _menu76.getSlots().get(7).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:ores/tin")))
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu78 ? _menu78.getSlots().get(7).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:ingots/tin")))
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu80 ? _menu80.getSlots().get(7).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:storage_blocks/tin")))) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("TinGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new TinGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu83 ? _menu83.getSlots().get(7).getItem() : ItemStack.EMPTY)
				.is(ItemTags.create(ResourceLocation.parse("c:ingots/electrum")))
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu85 ? _menu85.getSlots().get(7).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:storage_blocks/electrum")))
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu87 ? _menu87.getSlots().get(7).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:nuggets/electrum")))) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("ElectrumGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new ElectrumGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu90 ? _menu90.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.CLEAR_QUARTZ_SHARD
				.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu92 ? _menu92.getSlots().get(7).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.PURIFIED_CLEAR_QUARTZ_SHARD.get()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("ClearQuartzGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new ClearQuartzGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu95 ? _menu95.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.ROSE_QUARTZ_SHARD
				.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu97 ? _menu97.getSlots().get(7).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.PURIFIED_ROSE_QUARTZ_SHARD.get()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("RoseQuartzGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new RoseQuartzGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu100 ? _menu100.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.BLACK_ONYX.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu102 ? _menu102.getSlots().get(7).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.PURIFIED_ONYX.get()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("BlackOnyxGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new BlackOnyxGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu105 ? _menu105.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SARDONYX.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu107 ? _menu107.getSlots().get(7).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.PURIFIED_SARDONYX.get()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("RedOnyxGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new RedOnyxGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu110 ? _menu110.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.MALACHITE.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu112 ? _menu112.getSlots().get(7).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.PURIFIED_MALACHITE.get()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("MalachiteGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new MalachiteGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu115 ? _menu115.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SWAMP_CRYSTAL_SHARD
				.get()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("SwampCrystalGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new SwampCrystalGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu118 ? _menu118.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.NETHER_GEM.get()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("NetherGemGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new NetherGemGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu121 ? _menu121.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModBlocks.BLOCK_OF_MOONSTONE
				.get().asItem()) {
			RHBlockOfMoonstoneProcedure.execute(entity);
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu123 ? _menu123.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModBlocks.BLOCK_OF_SARDOYNX
				.get().asItem()) {
			RHBlockOfSardonyxProcedure.execute(entity);
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu125 ? _menu125.getSlots().get(7).getItem() : ItemStack.EMPTY)
				.getItem() == MonstrousWorldModBlocks.BLOCK_OF_NETHER_GEMS.get().asItem()) {
			RHBlockOfNetherGemsProcedure.execute(entity);
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu127 ? _menu127.getSlots().get(7).getItem() : ItemStack.EMPTY)
				.is(ItemTags.create(ResourceLocation.parse("c:gems/moonstone")))) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("MoonstoneGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new MoonstoneGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu130 ? _menu130.getSlots().get(7).getItem() : ItemStack.EMPTY)
				.is(ItemTags.create(ResourceLocation.parse("monstrous_world:evil_tree_products")))) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("EvilTreeWoodGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new EvilTreeWoodGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu133 ? _menu133.getSlots().get(7).getItem() : ItemStack.EMPTY)
				.is(ItemTags.create(ResourceLocation.parse("monstrous_world:darkened_wood_products")))) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("DarkenedLogGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new DarkenedLogGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu136 ? _menu136.getSlots().get(7).getItem() : ItemStack.EMPTY)
				.is(ItemTags.create(ResourceLocation.parse("monstrous_world:murkwood_products")))) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("MurkwoodWoodGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new MurkwoodWoodGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu139 ? _menu139.getSlots().get(7).getItem() : ItemStack.EMPTY)
				.is(ItemTags.create(ResourceLocation.parse("monstrous_world:deathly_wood_products")))) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("DeathlyWoodGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new DeathlyWoodGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu142 ? _menu142.getSlots().get(7).getItem() : ItemStack.EMPTY)
				.is(ItemTags.create(ResourceLocation.parse("monstrous_world:pumpkin_wood_products")))) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("PumpkinLogGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new PumpkinLogGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu145 ? _menu145.getSlots().get(7).getItem() : ItemStack.EMPTY)
				.is(ItemTags.create(ResourceLocation.parse("monstrous_world:pale_stalk_products")))) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("PaleStalkWoodGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new PaleStalkWoodGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu148 ? _menu148.getSlots().get(7).getItem() : ItemStack.EMPTY)
				.is(ItemTags.create(ResourceLocation.parse("monstrous_world:darkened_sand_products")))) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("DarkenedSandGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new DarkenedSandGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu151 ? _menu151.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModBlocks.DARKENED_CRYSTAL
				.get().asItem()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("DarkenedCrystalGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new DarkenedCrystalGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu154 ? _menu154.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DARKENED_IRON_INGOT
				.get()) {
			RHDarkenedIronIngotProcedure.execute(entity);
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu156 ? _menu156.getSlots().get(7).getItem() : ItemStack.EMPTY)
				.getItem() == MonstrousWorldModBlocks.DARKENED_IRON_TRAPDOOR.get().asItem()) {
			RHDarkenedIronTrapdoorProcedure.execute(entity);
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu158 ? _menu158.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.TEST_TUBE.get()) {
			RHTestTubeProcedure.execute(entity);
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu160 ? _menu160.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_FLASK_ITEM
				.get()) {
			RHFlaskProcedure.execute(entity);
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu162 ? _menu162.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EMPTY_SYRINGE
				.get()) {
			RHSyringeProcedure.execute(entity);
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu164 ? _menu164.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModBlocks.TIN_ROD.get()
				.asItem()) {
			RHTinRodProcedure.execute(entity);
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu166 ? _menu166.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModBlocks.MAGICAL_FABRIC
				.get().asItem()) {
			RHMagicalFabricProcedure.execute(entity);
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu168 ? _menu168.getSlots().get(7).getItem() : ItemStack.EMPTY)
				.getItem() == MonstrousWorldModBlocks.DARKENED_STONE_BRICKS.get().asItem()) {
			RHDarkenedStoneBricksProcedure.execute(entity);
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu170 ? _menu170.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModBlocks.TIN_TRAPDOOR.get()
				.asItem()) {
			RHTinTrapdoorProcedure.execute(entity);
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu172 ? _menu172.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.MAGICKAL_CATALYST
				.get()) {
			RHMagickalCatalystProcedure.execute(entity);
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu174 ? _menu174.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModBlocks.SIMPLE_CAULDRON
				.get().asItem()) {
			RHBasicCauldronProcedure.execute(entity);
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu176 ? _menu176.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.COMPUTER_CHIP
				.get()) {
			RHComputerChipProcedure.execute(entity);
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu178 ? _menu178.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.LAPTOP_SCREEN
				.get()) {
			RHLaptopScreenProcedure.execute(entity);
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu180 ? _menu180.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModBlocks.TIN_SLAB.get()
				.asItem()) {
			RHTinSlabProcedure.execute(entity);
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu182 ? _menu182.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.REDSTONE_EYE
				.get()) {
			RHRedstoneEyeProcedure.execute(entity);
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu184 ? _menu184.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.GUARD_ROBOT_LEG
				.get()) {
			RHRobotGuardLegProcedure.execute(entity);
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu186 ? _menu186.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.GUARD_ROBOT_BODY
				.get()) {
			RHRobotGuardBodyProcedure.execute(entity);
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu188 ? _menu188.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.GUARD_ROBOT_ARM
				.get()) {
			RHRobotGuardArmProcedure.execute(entity);
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu190 ? _menu190.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SILVER_DAGGER
				.get()) {
			RHSilverDaggerProcedure.execute(entity);
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu192 ? _menu192.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.STAKE.get()) {
			RHStakeProcedure.execute(entity);
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu194 ? _menu194.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.INFERNAL_FABRIC
				.get()) {
			RHInfernalFabricProcedure.execute(entity);
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu196 ? _menu196.getSlots().get(7).getItem() : ItemStack.EMPTY)
				.getItem() == MonstrousWorldModBlocks.BLOCK_OF_RAW_INFERNAL_IRON.get().asItem()) {
			RHBlockOfRawInfernalIronProcedure.execute(entity);
		}
	}
}