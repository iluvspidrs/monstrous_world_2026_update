package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.MonstrousWorldMod;

public class TrickOrTreatBagRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.moss_carpet.place")), SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.moss_carpet.place")), SoundSource.NEUTRAL, 1, 1, false);
			}
		}
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), 200);
		if (entity instanceof ServerPlayer _player) {
			AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:risky_click"));
			if (_adv != null) {
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
		}
		if (entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(MobEffects.LUCK)) {
			{
				final String _tagName = "BagResult";
				final double _tagValue = (Mth.nextInt(RandomSource.create(), 1, 39));
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		} else if (entity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(MonstrousWorldModMobEffects.DISAPPOINTMENT)) {
			{
				final String _tagName = "BagResult";
				final double _tagValue = (Mth.nextInt(RandomSource.create(), 40, 58));
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		} else {
			{
				final String _tagName = "BagResult";
				final double _tagValue = (Mth.nextInt(RandomSource.create(), 1, 58));
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		MonstrousWorldMod.queueServerWork(1, () -> {
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") <= 39) {
				if (entity instanceof ServerPlayer _player) {
					AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:its_a_treat"));
					if (_adv != null) {
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
			}
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 1) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7aIt's a small treat!"), true);
				BagResult1SmallTreatProcedure.execute(world, x, y, z);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 2) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7aMagical candy spills out of the bag!"), true);
				Bag2ResultCandyProcedure.execute(world, x, y, z);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 3) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7aEnjoy these Pumpkin Cookies..."), true);
				Bag3ResultPumpkinCookiesPlainProcedure.execute(world, x, y, z);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 4) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7aYou find a magical tome in the bag!"), true);
				Bag4ResultRandomTomeProcedure.execute(world, x, y, z);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 5) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7aUse these rare glass panes carefully..."), true);
				Bag5ResultRandomPanesProcedure.execute(world, x, y, z);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 6) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7aEnjoy these Pumpkin Cookies..."), true);
				Bag6ResultPumpkinCookiesMagicalProcedure.execute(world, x, y, z);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 7) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7aEnjoy your candy!"), true);
				Bag2ResultCandyProcedure.execute(world, x, y, z);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 8) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7aYou might need this..."), true);
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.CURE_SERUM_SYRINGE.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 9) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7aSkull lamps emerge from the bag..."), true);
				Bag9ResultSkullLampsProcedure.execute(world, x, y, z);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 10) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7aA child's toy..."), true);
				Bag10ResultBronzeSwordsProcedure.execute(world, x, y, z);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 11) {
				Bag11ResultMagicalPowderProcedure.execute(world, x, y, z);
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7aA magical powder!"), true);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 12) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7aEnjoy your candy!"), true);
				Bag2ResultCandyProcedure.execute(world, x, y, z);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 13) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7aMy precious..."), true);
				Bag13ResultPreciousStonesProcedure.execute(world, x, y, z);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 14) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7aYou might need this..."), true);
				Bag14ResultSilverDaggersProcedure.execute(world, x, y, z);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 15) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7aFor your survival..."), true);
				Bag15ResultVampireProcedure.execute(world, x, y, z, entity);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 16) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7aA helpful item..."), true);
				Bag16ResultGoblinProcedure.execute(world, x, y, z, entity);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 17) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7aA helpful item..."), true);
				Bag17ResultTrollProcedure.execute(world, x, y, z, entity);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 18) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7aA helpful item..."), true);
				Bag18ResultSorcererProcedure.execute(world, x, y, z, entity);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 19) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7aA helpful item..."), true);
				Bag19ResultWitchProcedure.execute(world, x, y, z, entity);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 20) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7aA helpful item..."), true);
				Bag20ResultWerewolfProcedure.execute(world, x, y, z, entity);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 21) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7aA helpful item..."), true);
				Bag21ResultSwampmonsterProcedure.execute(world, x, y, z, entity);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 22) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7aA helpful item..."), true);
				Bag22ResultDemonProcedure.execute(world, x, y, z, entity);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 23) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7aA helpful item..."), true);
				Bag23ResultClownProcedure.execute(world, x, y, z, entity);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 24) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7aA helpful item..."), true);
				Bag24ResultManiacProcedure.execute(world, x, y, z, entity);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 25) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7aA helpful reset..."), true);
				Bag15ResultEmptyContainerProcedure.execute(world, x, y, z);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 26) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7aA bit overwhelming..."), true);
				Bag26ResultPumpkinsProcedure.execute(world, x, y, z);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 27) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7aParty lights..."), true);
				Bag27ResultLightBulbsProcedure.execute(world, x, y, z);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 28) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7aTrance breaker..."), true);
				Bag28ResultInjectionClarityProcedure.execute(world, x, y, z);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 29) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7aTrance preventer..."), true);
				Bag29ResultAmuletsProcedure.execute(world, x, y, z);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 30) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7aA useful pickaxe"), true);
				Bag30ResultBronzePickaxesProcedure.execute(world, x, y, z);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 31) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7aA useful axe"), true);
				Bag31ResultBronzeAxesProcedure.execute(world, x, y, z);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 32) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7aA useful charm?"), true);
				Bag32ResultCharmsProcedure.execute(world, x, y, z);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 33) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7aSpooky saplings"), true);
				Bag33ResultSaplingsProcedure.execute(world, x, y, z);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 34) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7aTime to decorate..."), true);
				Bag34ResultAutumnMagicProcedure.execute(world, x, y, z);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 35) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7aUseful items..."), true);
				Bag25ResultHunterProcedure.execute(world, x, y, z, entity);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 36) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7aUseful items..."), true);
				Bag36ResultZombifiedProcedure.execute(world, x, y, z, entity);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 37) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7aDon't spend it all in one place!"), true);
				Bag37EmeraldsDiamondsProcedure.execute(world, x, y, z);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 38) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7aSpooky blocks!"), true);
				Bag38SpookyDecoProcedure.execute(world, x, y, z);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 39) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7aSome cheerful decorations..."), true);
				Bag39SkullsProcedure.execute(world, x, y, z);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 40) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74An evil spirit lurks nearby..."), true);
				Bag40ResultEvilSpiritProcedure.execute(world, x, y, z, entity);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 41) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74You are surrounded..."), true);
				Bag41ResultZombiesProcedure.execute(world, x, y, z, entity);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 42) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74That's just...disappointing"), true);
				Bag42ResultPamphletProcedure.execute(world, x, y, z);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 43) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74You are being hunted..."), true);
				Bag43ResultVampireProcedure.execute(world, x, y, z, entity);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 44) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74It's candy, but..."), true);
				Bag44ResultPeanutButterKissesProcedure.execute(world, x, y, z, entity);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 45) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74Spiders appear around you..."), true);
				Bag45ResultSpidersProcedure.execute(world, x, y, z, entity);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 46) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74Sometimes the pumpkins try to carve you..."), true);
				Bag46ResultVengefulPumpkinProcedure.execute(world, x, y, z, entity);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 47) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74You are being hunted..."), true);
				Bag47ResultVampireProcedure.execute(world, x, y, z, entity);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 48) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74Well, that isn't funny..."), true);
				Bag48ResultClownsProcedure.execute(world, x, y, z, entity);
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 49) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74That's not even interesting..."), true);
				Bag49ResultDirtProcedure.execute(world, x, y, z);
			}
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 50) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74A hole opens up underneath you!"), true);
				Bag50ResultSentToDeepProcedure.execute(world, x, y, z);
			}
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 51) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74You are surrounded..."), true);
				Bag51ResultDreadfulWatchersProcedure.execute(world, x, y, z, entity);
			}
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 52) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74Phobia..."), true);
				Bag52ResultSnakesProcedure.execute(world, x, y, z, entity);
			}
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 53) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74Yuck (in most cases.)"), true);
				Bag53ResultRottenFleshProcedure.execute(world, x, y, z);
			}
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 54) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74What? The apple isn't even healthy?"), true);
				Bag54ResultGhostlyAppleProcedure.execute(world, x, y, z);
			}
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 55) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74A curse falls upon you!"), true);
				Bag55ResultPumpkinsRevengeProcedure.execute(world, x, y, z, entity);
			}
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 56) {
				Bag56ResultManiacProcedure.execute(world, x, y, z, entity);
			}
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 57) {
				Bag57ResultChooChooProcedure.execute(world, x, y, z, entity);
			}
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("BagResult") == 58) {
				Bag58ResultRandomCurseProcedure.execute(world, entity);
			}
		});
		MonstrousWorldMod.queueServerWork(2, () -> {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			{
				final String _tagName = "BagResult";
				final double _tagValue = 0;
				CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
		});
	}
}