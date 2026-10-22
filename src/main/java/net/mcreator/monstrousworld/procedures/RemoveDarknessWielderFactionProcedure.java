package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

public class RemoveDarknessWielderFactionProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		SetScoresToZeroProcedure.execute(world, entity);
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 6) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("The evil presence within is sent back to the abyss, though you remain connected..."), false);
			{
				MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
				_vars.FactionLevel = 0;
				_vars.Reputation = 0;
				_vars.MessageTimer = 0;
				_vars.Blackout_Timer = 0;
				_vars.Dark_Message_Timer = 0;
				_vars.Possession = 0;
				_vars.markSyncDirty();
			}
			MonstrousWorldModVariables.MapVariables.get(world).PlayerPossessed = false;
			MonstrousWorldModVariables.MapVariables.get(world).markSyncDirty();
			{
				MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
				_vars.Reputation_Static = false;
				_vars.MonsterInfectable = true;
				_vars.markSyncDirty();
			}
			entity.getPersistentData().putBoolean("can_kill_maniac", false);
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DARKENED_HELMET.get()) {
				{
					Entity _entity = entity;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(3, ItemStack.EMPTY);
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.HEAD, ItemStack.EMPTY);
					}
				}
			}
		}
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 0) {
			{
				MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
				_vars.Reputation = 0;
				_vars.MonsterInfectable = true;
				_vars.DarknessInfectable = true;
				_vars.markSyncDirty();
			}
		}
		{
			MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
			_vars.Dark_Message_Timer = 0;
			_vars.MessageTimer = 0;
			_vars.MonsterClass = 0;
			_vars.FactionLevel = 0;
			_vars.markSyncDirty();
		}
		entity.getPersistentData().putBoolean("Monstrous World Darkness Wielder", false);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MonstrousWorldModMobEffects.BAD_REPUTATION);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MonstrousWorldModMobEffects.BLACKOUT);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MonstrousWorldModMobEffects.ENTITY_HUNGER);
		if (entity instanceof LivingEntity _entity) {
			_entity.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(ResourceLocation.parse("monstrous_world:darkness_damage"));
		}
		if (entity instanceof LivingEntity _entity) {
			_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:darkness_speed"));
		}
		if (entity instanceof LivingEntity _entity) {
			_entity.getAttribute(Attributes.ARMOR).removeModifier(ResourceLocation.parse("monstrous_world:darkness_armor"));
		}
		if (entity instanceof LivingEntity _entity) {
			_entity.getAttribute(Attributes.KNOCKBACK_RESISTANCE).removeModifier(ResourceLocation.parse("monstrous_world:darkness_knockback_resistance"));
		}
	}
}