package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.world.inventory.TheArtOfRitualsContentsMenu;
import net.mcreator.monstrousworld.world.inventory.ArtOfRitualsTOCMenu;
import net.mcreator.monstrousworld.world.inventory.ArtOfRitualsPage5Menu;
import net.mcreator.monstrousworld.world.inventory.ArtOfRitualsPage4Menu;
import net.mcreator.monstrousworld.world.inventory.ArtOfRitualsPage2Menu;
import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMenus;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

import io.netty.buffer.Unpooled;

public class BinderOpenTheArtOfRitualsRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.THE_ART_OF_RITUALS
				.get()) {
			if (!entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page.contains("The Art of Rituals")) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 4 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 3) {
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
						_vars.Page = "The Art of Rituals Page 1 Advanced";
						_vars.markSyncDirty();
					}
					if (entity instanceof ServerPlayer _ent) {
						BlockPos _bpos = BlockPos.containing(x, y, z);
						_ent.openMenu(new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("ArtOfRitualsTOC");
							}

							@Override
							public boolean shouldTriggerClientSideContainerClosingOnOpen() {
								return false;
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new ArtOfRitualsTOCMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
				} else {
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
						_vars.Page = "The Art of Rituals Page 1";
						_vars.markSyncDirty();
					}
					if (entity instanceof ServerPlayer _ent) {
						BlockPos _bpos = BlockPos.containing(x, y, z);
						_ent.openMenu(new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("TheArtOfRitualsContents");
							}

							@Override
							public boolean shouldTriggerClientSideContainerClosingOnOpen() {
								return false;
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new TheArtOfRitualsContentsMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
				}
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page.contains("The Art of Rituals")) {
				if (!(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("The Art of Rituals Page 1 Advanced")) {
					if (!(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("The Art of Rituals Page 2")) {
						if (!(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("The Art of Rituals Page 4")) {
							if (!(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("The Art of Rituals Page 5")) {
								if (entity instanceof ServerPlayer _ent) {
									BlockPos _bpos = BlockPos.containing(x, y, z);
									_ent.openMenu(new MenuProvider() {
										@Override
										public Component getDisplayName() {
											return Component.literal("TheArtOfRitualsContents");
										}

										@Override
										public boolean shouldTriggerClientSideContainerClosingOnOpen() {
											return false;
										}

										@Override
										public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
											return new TheArtOfRitualsContentsMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
										}
									}, _bpos);
								}
							} else {
								if (entity instanceof ServerPlayer _ent) {
									BlockPos _bpos = BlockPos.containing(x, y, z);
									_ent.openMenu(new MenuProvider() {
										@Override
										public Component getDisplayName() {
											return Component.literal("ArtOfRitualsPage5");
										}

										@Override
										public boolean shouldTriggerClientSideContainerClosingOnOpen() {
											return false;
										}

										@Override
										public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
											return new ArtOfRitualsPage5Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
										}
									}, _bpos);
								}
							}
						} else {
							if (entity instanceof ServerPlayer _ent) {
								BlockPos _bpos = BlockPos.containing(x, y, z);
								_ent.openMenu(new MenuProvider() {
									@Override
									public Component getDisplayName() {
										return Component.literal("ArtOfRitualsPage4");
									}

									@Override
									public boolean shouldTriggerClientSideContainerClosingOnOpen() {
										return false;
									}

									@Override
									public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
										return new ArtOfRitualsPage4Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
									}
								}, _bpos);
							}
						}
					} else {
						if (entity instanceof ServerPlayer _ent) {
							BlockPos _bpos = BlockPos.containing(x, y, z);
							_ent.openMenu(new MenuProvider() {
								@Override
								public Component getDisplayName() {
									return Component.literal("ArtOfRitualsPage2");
								}

								@Override
								public boolean shouldTriggerClientSideContainerClosingOnOpen() {
									return false;
								}

								@Override
								public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
									return new ArtOfRitualsPage2Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
								}
							}, _bpos);
						}
					}
				} else {
					if (entity instanceof ServerPlayer _ent) {
						BlockPos _bpos = BlockPos.containing(x, y, z);
						_ent.openMenu(new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("ArtOfRitualsTOC");
							}

							@Override
							public boolean shouldTriggerClientSideContainerClosingOnOpen() {
								return false;
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new ArtOfRitualsTOCMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
				}
			}
		}
	}
}