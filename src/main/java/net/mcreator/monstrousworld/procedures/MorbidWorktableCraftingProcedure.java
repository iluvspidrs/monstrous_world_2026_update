package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.init.MonstrousWorldModMenus;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

public class MorbidWorktableCraftingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double coal_required = 0;
		double iron_required = 0;
		if (getAmountInGUISlot(entity, 9) == 0) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu1 ? _menu1.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DRIED_SKIN.get()
					&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu3 ? _menu3.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
					&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu6 ? _menu6.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DRIED_SKIN
							.get()) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu8 ? _menu8.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DRIED_SKIN
						.get()
						&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu10 ? _menu10.getSlots().get(4).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.DRIED_SKIN.get()
						&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu12 ? _menu12.getSlots().get(5).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.DRIED_SKIN.get()) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu14 ? _menu14.getSlots().get(6).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.DRIED_SKIN.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu16 ? _menu16.getSlots().get(7).getItem() : ItemStack.EMPTY)
									.getItem() == MonstrousWorldModItems.DRIED_SKIN.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu18 ? _menu18.getSlots().get(8).getItem() : ItemStack.EMPTY)
									.getItem() == MonstrousWorldModItems.DRIED_SKIN.get()) {
						CreateDriedSkinTunicProcedure.execute(world, x, y, z, entity);
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu20 ? _menu20.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DRIED_SKIN.get()
					&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu22 ? _menu22.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DRIED_SKIN
							.get()
					&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu24 ? _menu24.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DRIED_SKIN
							.get()) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu26 ? _menu26.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DRIED_SKIN
						.get()
						&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu28 ? _menu28.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
						&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu31 ? _menu31.getSlots().get(5).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.DRIED_SKIN.get()) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu33 ? _menu33.getSlots().get(6).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.DRIED_SKIN.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu35 ? _menu35.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu38 ? _menu38.getSlots().get(8).getItem() : ItemStack.EMPTY)
									.getItem() == MonstrousWorldModItems.DRIED_SKIN.get()) {
						CreateDriedSkinLeggingsProcedure.execute(world, x, y, z, entity);
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu40 ? _menu40.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DRIED_SKIN.get()
					&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu42 ? _menu42.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Items.STRING
					&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu44 ? _menu44.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DRIED_SKIN
							.get()) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu46 ? _menu46.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
						&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu49 ? _menu49.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Blocks.SKELETON_SKULL
								.asItem()
						&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu51 ? _menu51.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu54 ? _menu54.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu57 ? _menu57.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu60 ? _menu60.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem()) {
						CreateSkullMaskProcedure.execute(world, x, y, z, entity);
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu63 ? _menu63.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
					&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu66 ? _menu66.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
					&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu69 ? _menu69.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu72 ? _menu72.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DRIED_SKIN
						.get() && (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu74 ? _menu74.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Items.STRING
						&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu76 ? _menu76.getSlots().get(5).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.DRIED_SKIN.get()) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu78 ? _menu78.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu81 ? _menu81.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Blocks.SKELETON_SKULL
									.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu83 ? _menu83.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem()) {
						CreateSkullMaskProcedure.execute(world, x, y, z, entity);
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu86 ? _menu86.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DRIED_SKIN.get()
					&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu88 ? _menu88.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Items.STRING
					&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu90 ? _menu90.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DRIED_SKIN
							.get()) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu92 ? _menu92.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
						&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu95 ? _menu95.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Blocks.BONE_BLOCK.asItem()
						&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu97 ? _menu97.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu100 ? _menu100.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu103 ? _menu103.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu106 ? _menu106.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem()) {
						CreateHockeyMaskProcedure.execute(world, x, y, z, entity);
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu109 ? _menu109.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
					&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu112 ? _menu112.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
					&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu115 ? _menu115.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu118 ? _menu118.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DRIED_SKIN
						.get() && (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu120 ? _menu120.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Items.STRING
						&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu122 ? _menu122.getSlots().get(5).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.DRIED_SKIN.get()) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu124 ? _menu124.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu127 ? _menu127.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Blocks.BONE_BLOCK
									.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu129 ? _menu129.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem()) {
						CreateHockeyMaskProcedure.execute(world, x, y, z, entity);
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu132 ? _menu132.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DRIED_SKIN
					.get() && (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu134 ? _menu134.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Items.STRING
					&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu136 ? _menu136.getSlots().get(2).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.DRIED_SKIN.get()) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu138 ? _menu138.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
						&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu141 ? _menu141.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Blocks.YELLOW_TERRACOTTA
								.asItem()
						&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu143 ? _menu143.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
								.getItem()) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu146 ? _menu146.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu149 ? _menu149.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu152 ? _menu152.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem()) {
						CreateBunnyMaskProcedure.execute(world, x, y, z, entity);
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu155 ? _menu155.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
					&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu158 ? _menu158.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
					&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu161 ? _menu161.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu164 ? _menu164.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DRIED_SKIN
						.get() && (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu166 ? _menu166.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Items.STRING
						&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu168 ? _menu168.getSlots().get(5).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.DRIED_SKIN.get()) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu170 ? _menu170.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu173 ? _menu173.getSlots().get(7).getItem() : ItemStack.EMPTY)
									.getItem() == Blocks.YELLOW_TERRACOTTA.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu175 ? _menu175.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem()) {
						CreateBunnyMaskProcedure.execute(world, x, y, z, entity);
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu178 ? _menu178.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.INFERNAL_IRON_INGOT.get()
					&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu180 ? _menu180.getSlots().get(1).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.PURE_FEAR.get()
					&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu182 ? _menu182.getSlots().get(2).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.PURE_FEAR.get()) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu184 ? _menu184.getSlots().get(3).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.INFERNAL_IRON_INGOT.get()
						&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu186 ? _menu186.getSlots().get(4).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.INFERNAL_IRON_INGOT.get()
						&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu188 ? _menu188.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == Blocks.CHAIN.asItem()) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu190 ? _menu190.getSlots().get(6).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.NETHER_GEM.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu192 ? _menu192.getSlots().get(7).getItem() : ItemStack.EMPTY)
									.getItem() == MonstrousWorldModItems.PURE_FEAR.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu194 ? _menu194.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == Blocks.LEVER
									.asItem()) {
						CreateChainsawProcedure.execute(world, x, y, z, entity);
					}
				}
			}
		}
	}

	private static int getAmountInGUISlot(Entity entity, int sltid) {
		if (entity instanceof Player player && player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor menuAccessor) {
			ItemStack stack = menuAccessor.getSlots().get(sltid).getItem();
			if (stack != null)
				return stack.getCount();
		}
		return 0;
	}
}