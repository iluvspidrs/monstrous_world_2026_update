package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModEntities;
import net.mcreator.monstrousworld.entity.TeleportProjectileEntity;
import net.mcreator.monstrousworld.entity.SpiritSpellProjectileEntity;
import net.mcreator.monstrousworld.entity.LevitationChargeProjectileEntity;
import net.mcreator.monstrousworld.entity.FireSpellProjectileEntity;

public class UsePrimarySpellProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 4) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 4) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BeastForm == false) {
						if (entity.getPersistentData().getDouble("Cooldown_Spell") == 0) {
							if (entity instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.breeze.shoot")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.breeze.shoot")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel < 3) {
								entity.getPersistentData().putDouble("Cooldown_Spell", 200);
							}
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 3) {
								entity.getPersistentData().putDouble("Cooldown_Spell", 20);
							}
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Magic_Type == 1) {
								{
									Entity _shootFrom = entity;
									Level projectileLevel = _shootFrom.level();
									if (!projectileLevel.isClientSide()) {
										Projectile _entityToSpawn = initArrowProjectile(
												new LevitationChargeProjectileEntity(MonstrousWorldModEntities.LEVITATION_CHARGE_PROJECTILE.get(), 0, 0, 0, projectileLevel, createArrowWeaponItemStack(projectileLevel, 1, (byte) 0)), null, 1, true,
												false, false, AbstractArrow.Pickup.DISALLOWED);
										_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
										_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 2, 0);
										projectileLevel.addFreshEntity(_entityToSpawn);
									}
								}
							}
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Magic_Type == 2) {
								{
									Entity _shootFrom = entity;
									Level projectileLevel = _shootFrom.level();
									if (!projectileLevel.isClientSide()) {
										Projectile _entityToSpawn = initArrowProjectile(new FireSpellProjectileEntity(MonstrousWorldModEntities.FIRE_SPELL_PROJECTILE.get(), projectileLevel), null, 1, true, false, false,
												AbstractArrow.Pickup.DISALLOWED);
										_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
										_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 2, 0);
										projectileLevel.addFreshEntity(_entityToSpawn);
									}
								}
							}
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Magic_Type == 3) {
								{
									Entity _shootFrom = entity;
									Level projectileLevel = _shootFrom.level();
									if (!projectileLevel.isClientSide()) {
										Projectile _entityToSpawn = initArrowProjectile(new TeleportProjectileEntity(MonstrousWorldModEntities.TELEPORT_PROJECTILE.get(), projectileLevel), null, 1, true, false, false, AbstractArrow.Pickup.DISALLOWED);
										_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
										_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 2, 0);
										projectileLevel.addFreshEntity(_entityToSpawn);
									}
								}
							}
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Magic_Type == 4) {
								{
									Entity _shootFrom = entity;
									Level projectileLevel = _shootFrom.level();
									if (!projectileLevel.isClientSide()) {
										Projectile _entityToSpawn = initArrowProjectile(new SpiritSpellProjectileEntity(MonstrousWorldModEntities.SPIRIT_SPELL_PROJECTILE.get(), projectileLevel), null, 1, true, false, false,
												AbstractArrow.Pickup.DISALLOWED);
										_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
										_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 2, 0);
										projectileLevel.addFreshEntity(_entityToSpawn);
									}
								}
							}
						}
					}
				} else {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("You have no life force to draw this magic from"), false);
				}
			}
		}
	}

	private static AbstractArrow initArrowProjectile(AbstractArrow entityToSpawn, Entity shooter, float damage, boolean silent, boolean fire, boolean particles, AbstractArrow.Pickup pickup) {
		entityToSpawn.setOwner(shooter);
		entityToSpawn.setBaseDamage(damage);
		if (silent)
			entityToSpawn.setSilent(true);
		if (fire)
			entityToSpawn.igniteForSeconds(100);
		if (particles)
			entityToSpawn.setCritArrow(true);
		entityToSpawn.pickup = pickup;
		return entityToSpawn;
	}

	private static ItemStack createArrowWeaponItemStack(Level level, int knockback, byte piercing) {
		ItemStack weapon = new ItemStack(Items.ARROW);
		if (knockback > 0)
			weapon.enchant(level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.KNOCKBACK), knockback);
		if (piercing > 0)
			weapon.enchant(level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PIERCING), piercing);
		return weapon;
	}
}