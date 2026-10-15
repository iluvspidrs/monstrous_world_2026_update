package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.entity.MysteriousShadowEntity;
import net.mcreator.monstrousworld.entity.LargePossessingEntityEntity;

import java.util.Comparator;

public class TomeOfLightRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (world instanceof ServerLevel)
				((ServerLevel) world).sendParticles((ParticleTypes.ENCHANT), x, (y + 1), z, 10, 1, 1, 1, 1);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("This book heals everyone nearby of most infections, curses, and effects! "), false);
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.TOME_OF_LIGHT.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			entity.getPersistentData().putDouble("UsedLightTome", 20);
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
				_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
				_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
				_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
			{
				final Vec3 _center = new Vec3(x, y, z);
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					if (!(entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Bloodlevel == -1)) {
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.Bloodlevel = 12;
							_vars.markSyncDirty();
						}
					}
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
						_vars.DarknessTimer = 0;
						_vars.VampireInfection = 0;
						_vars.ZombieInfection = 0;
						_vars.WerewolfInfectionTimer = 0;
						_vars.WebbedLevel = 0;
						_vars.Zombify = 0;
						_vars.No_Defense = 0;
						_vars.More_Nightmares = 0;
						_vars.Slower_Movement = 0;
						_vars.markSyncDirty();
					}
					if (entityiterator instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION);
					if (entityiterator instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT);
					if (entityiterator instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT);
					if (entityiterator instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.BAD_OMEN_SOCIETY);
					if (entityiterator instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.PUMPKINS_REVENGE);
					if (entityiterator instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.DISAPPOINTMENT);
					if (entityiterator instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.STRANGE_SERUM);
					if (entityiterator instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.INSANITY);
					if (entityiterator instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.DRY_EYE);
					if (entityiterator instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.ENCHANTED);
					if (entityiterator instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.CRAZED);
					if (entityiterator instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.WEBBED);
					if (entityiterator instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.DESPAIR);
					if (entityiterator instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.DESSICATION);
					if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 300, 0, false, false));
					if (entityiterator instanceof MysteriousShadowEntity || entityiterator instanceof LargePossessingEntityEntity) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:this_one_simple_trick"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC)), 100);
					} else {
						if (entityiterator instanceof LivingEntity _entity)
							_entity.setHealth(entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
					}
				}
			}
		}
	}
}