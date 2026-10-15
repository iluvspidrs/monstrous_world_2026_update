package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.monstrousworld.configuration.MonstrousWorldConfigConfiguration;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ShowTipsAfterJoinProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (MonstrousWorldConfigConfiguration.SHOW_STARTUP_TIPS.get() == true) {
			if (entity.getPersistentData().getDouble("tip_message_time") != 0) {
				if (entity.getPersistentData().getDouble("tip_message_time") <= world.dayTime()) {
					entity.getPersistentData().putDouble("tip_message_time", 0);
					if (entity.getPersistentData().getDouble("Maniac_Tip") == 1) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74\u00A7lManiac Tip: \u00A7f\u00A7rKilling with axes, butcher knives, and chainsaws will heal you, though some weapons are better than others"), false);
					}
					if (entity.getPersistentData().getDouble("Maniac_Tip") == 2) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74\u00A7lManiac Tip: \u00A7f\u00A7rDemons and Evil Clowns won't attack you unless bothered first"), false);
					}
					if (entity.getPersistentData().getDouble("Maniac_Tip") == 3) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74\u00A7lManiac Tip: \u00A7f\u00A7rHunters will attack you often, but you can use that to your advantage..."), false);
					}
					if (entity.getPersistentData().getDouble("Maniac_Tip") == 4) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74\u00A7lManiac Tip: \u00A7f\u00A7rPure Fear may be useful for protection or for mob traps"), false);
					}
					if (entity.getPersistentData().getDouble("Maniac_Tip") == 5) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74\u00A7lManiac Tip: \u00A7f\u00A7rYou must wear full Maniac armor to get Hearts from victims"), false);
					}
					if (entity.getPersistentData().getDouble("Maniac_Tip") == 6) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74\u00A7lManiac Tip: \u00A7f\u00A7rSociety Raids can be a good opportunity to gain materials...but can be dangerous!"), false);
					}
					if (entity.getPersistentData().getDouble("Maniac_Tip") == 7) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74\u00A7lManiac Tip: \u00A7f\u00A7rDemons will always be willing to trade with you for Infernal Iron Ingots"), false);
					}
					if (entity.getPersistentData().getDouble("Maniac_Tip") == 8) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74\u00A7lManiac Tip: \u00A7f\u00A7rThe Chainsaw causes blood loss and is a good choice for combat"), false);
					}
					if (entity.getPersistentData().getDouble("Maniac_Tip") == 9) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74\u00A7lManiac Tip: \u00A7f\u00A7rReaching Level 6 unlocks an ability that will make you almost unstoppable..."), false);
					}
					if (entity.getPersistentData().getDouble("Maniac_Tip") == 10) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74\u00A7lManiac Tip: \u00A7f\u00A7rSoul Sand can sometimes be found in dry biomes...but beware of the glowing type..."), false);
					}
					if (entity.getPersistentData().getDouble("Demon_Tip") == 1) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74\u00A7lDemon Tip: \u00A7f\u00A7rUnless reset, your spawn point will be in the Nether"), false);
					}
					if (entity.getPersistentData().getDouble("Demon_Tip") == 2) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74\u00A7lDemon Tip: \u00A7f\u00A7rYou will heal when in Nether fire or lava"), false);
					}
					if (entity.getPersistentData().getDouble("Demon_Tip") == 3) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74\u00A7lDemon Tip: \u00A7f\u00A7rIf you hide your true form, be careful about what weapons you carry. Some can only be handled by Demons..."), false);
					}
					if (entity.getPersistentData().getDouble("Demon_Tip") == 4) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74\u00A7lDemon Tip: \u00A7f\u00A7rClowns and Maniacs will ignore you unless attacked first"), false);
					}
					if (entity.getPersistentData().getDouble("Demon_Tip") == 5) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74\u00A7lDemon Tip: \u00A7f\u00A7rThe Hunter's Guild is resistant to enslavement, but always drop Virtuous Souls"), false);
					}
					if (entity.getPersistentData().getDouble("Demon_Tip") == 6) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74\u00A7lDemon Tip: \u00A7f\u00A7rDifferent types of servants can be exploited for different resources"), false);
					}
					if (entity.getPersistentData().getDouble("Demon_Tip") == 7) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74\u00A7lDemon Tip: \u00A7f\u00A7rOnce at a high enough level, you can smelt most items in your hand"), false);
					}
					if (entity.getPersistentData().getDouble("Demon_Tip") == 8) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74\u00A7lDemon Tip: \u00A7f\u00A7rWhen disguised, you do not need special armor to explore the Overworld without freezing"), false);
					}
					if (entity.getPersistentData().getDouble("Demon_Tip") == 9) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74\u00A7lDemon Tip: \u00A7f\u00A7rThe Hunter's Guild will try attacking you often...but you can use this to your advantage"), false);
					}
					if (entity.getPersistentData().getDouble("Demon_Tip") == 10) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74\u00A7lDemon Tip: \u00A7f\u00A7rYou can climb a wall by looking up and repeatedly right-clicking"), false);
					}
					if (entity.getPersistentData().getDouble("Clown_Tip") == 1) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7d\u00A7lEvil Clown Tip: \u00A7f\u00A7rManiacs and Demons will ignore you unless you attack first"), false);
					}
					if (entity.getPersistentData().getDouble("Clown_Tip") == 2) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7d\u00A7lEvil Clown Tip: \u00A7f\u00A7rDon't forget to melt down Villagers and Illagers into Cursed Confectionery..."), false);
					}
					if (entity.getPersistentData().getDouble("Clown_Tip") == 3) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7d\u00A7lEvil Clown Tip: \u00A7f\u00A7rThe Hunter's Guild will show up often to kill you...but you can use this to your advantage."), false);
					}
					if (entity.getPersistentData().getDouble("Clown_Tip") == 4) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7d\u00A7lEvil Clown Tip: \u00A7f\u00A7rCorn can be found in the Forsaken Lands and in the Autumn Delight biomes"), false);
					}
					if (entity.getPersistentData().getDouble("Clown_Tip") == 5) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7d\u00A7lEvil Clown Tip: \u00A7f\u00A7rYour victims will still try attacking after given Cursed Candy, so be ready"), false);
					}
					if (entity.getPersistentData().getDouble("Clown_Tip") == 6) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7d\u00A7lEvil Clown Tip: \u00A7f\u00A7rCotton Candy grants different beneficial effects based on type"), false);
					}
					if (entity.getPersistentData().getDouble("Clown_Tip") == 7) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7d\u00A7lEvil Clown Tip: \u00A7f\u00A7rThe Acid Gun is best used against living, humanoid enemies"), false);
					}
					if (entity.getPersistentData().getDouble("Clown_Tip") == 8) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7d\u00A7lEvil Clown Tip: \u00A7f\u00A7rThe Popcorn Gun is a great way to call in backup during a fight!"), false);
					}
					if (entity.getPersistentData().getDouble("Clown_Tip") == 9) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7d\u00A7lEvil Clown Tip: \u00A7f\u00A7rDeadly Balloons will float away once released...unless a suitable victim is nearby"), false);
					}
					if (entity.getPersistentData().getDouble("Clown_Tip") == 10) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7d\u00A7lEvil Clown Tip: \u00A7f\u00A7rCircus Tents are sometimes found in the Forsaken Lands"), false);
					}
					if (entity.getPersistentData().getDouble("Science_Tip") == 1) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A77\u00A7lMad Science Tip: \u00A7f\u00A7rLabs are found in desert regions"), false);
					}
					if (entity.getPersistentData().getDouble("Science_Tip") == 2) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A77\u00A7lMad Science Tip: \u00A7f\u00A7rAlways wear a Lab Coat, Lab Boots, and Lab Glasses to protect from splatter"), false);
					}
					if (entity.getPersistentData().getDouble("Science_Tip") == 3) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A77\u00A7lMad Science Tip: \u00A7f\u00A7rStrange Serum can be a weapon against human enemies"), false);
					}
					if (entity.getPersistentData().getDouble("Science_Tip") == 4) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A77\u00A7lMad Science Tip: \u00A7f\u00A7rThe Tome of Mad Science contains recipes for complex devices, as does the Laptop"), false);
					}
					if (entity.getPersistentData().getDouble("Science_Tip") == 5) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A77\u00A7lMad Science Tip: \u00A7f\u00A7rCreating a Laptop will help you progress"), false);
					}
					if (entity.getPersistentData().getDouble("Science_Tip") == 6) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A77\u00A7lMad Science Tip: \u00A7f\u00A7rDark Essence Dust can be farmed by infecting trees and then collecting the Darkened Leaves afterward"), false);
					}
					if (entity.getPersistentData().getDouble("Science_Tip") == 7) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A77\u00A7lMad Science Tip: \u00A7f\u00A7rLab Assistants will go out and do errands for you"), false);
					}
					if (entity.getPersistentData().getDouble("Science_Tip") == 8) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A77\u00A7lMad Science Tip: \u00A7f\u00A7rCollecting plenty of Iron, Tin, Copper, and Redstone is a must"), false);
					}
					if (entity.getPersistentData().getDouble("Science_Tip") == 9) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A77\u00A7lMad Science Tip: \u00A7f\u00A7rCarrying Cure Serum can save you from zombification"), false);
					}
					if (entity.getPersistentData().getDouble("Science_Tip") == 10) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A77\u00A7lMad Science Tip: \u00A7f\u00A7rVisiting a desert lab will allow you to find helpful instructions"), false);
					}
					if (entity.getPersistentData().getDouble("Zombified_Tip") == 1) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A72\u00A7lZombie Tip: \u00A7f\u00A7rYou can only heal by consuming the flesh of the living..."), false);
					}
					if (entity.getPersistentData().getDouble("Zombified_Tip") == 2) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A72\u00A7lZombie Tip: \u00A7f\u00A7rHelmets will prevent sunburn, but slowly lose durability in daylight"), false);
					}
					if (entity.getPersistentData().getDouble("Zombified_Tip") == 3) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A72\u00A7lZombie Tip: \u00A7f\u00A7rThe Undead Glow effect will allow you to use workstations and do some, but not all, magic"), false);
					}
					if (entity.getPersistentData().getDouble("Zombified_Tip") == 4) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A72\u00A7lZombie Tip: \u00A7f\u00A7rPillagers, evil Witches, Villagers, and all humans drop brains and flesh when killed by zombies..."), false);
					}
					if (entity.getPersistentData().getDouble("Zombified_Tip") == 5) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A72\u00A7lZombie Tip: \u00A7f\u00A7rIf your health isn't full, you will bite humanoid mobs when right-clicking them..."), false);
					}
					if (entity.getPersistentData().getDouble("Zombified_Tip") == 6) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A72\u00A7lZombie Tip: \u00A7f\u00A7rThe Deathcatcher can be found in patches, most commonly in the Deathly Forest"), false);
					}
					if (entity.getPersistentData().getDouble("Zombified_Tip") == 7) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A72\u00A7lZombie Tip: \u00A7f\u00A7rBiting a human, villager, witch, etc will infect them...and they will zombify in 5 minutes"), false);
					}
					if (entity.getPersistentData().getDouble("Swampmonster_Tip") == 1) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A73\u00A7lSwamp Monster Tip: \u00A7f\u00A7rHumid environments will stop you from dessicating"), false);
					}
					if (entity.getPersistentData().getDouble("Swampmonster_Tip") == 2) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A73\u00A7lSwamp Monster Tip: \u00A7f\u00A7rRight-click fish and frogs to consume them"), false);
					}
					if (entity.getPersistentData().getDouble("Swampmonster_Tip") == 3) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A73\u00A7lSwamp Monster Tip: \u00A7f\u00A7rSwamp Monster Villages are found in warmer, swampy biomes"), false);
					}
					if (entity.getPersistentData().getDouble("Swampmonster_Tip") == 4) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A73\u00A7lSwamp Monster Tip: \u00A7f\u00A7rYou are immune to vampire, zombie, and werewolf infections"), false);
					}
					if (entity.getPersistentData().getDouble("Swampmonster_Tip") == 5) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A73\u00A7lSwamp Monster Tip: \u00A7f\u00A7rSwamp Crystal Ore is best found by exploring flooded swamp caves"), false);
					}
					if (entity.getPersistentData().getDouble("Swampmonster_Tip") == 6) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A73\u00A7lSwamp Monster Tip: \u00A7f\u00A7rThe Nether is very dangerous to your kind, causing dessication even with Swamp Crystal Armor"), false);
					}
					if (entity.getPersistentData().getDouble("Swampmonster_Tip") == 7) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A73\u00A7lSwamp Monster Tip: \u00A7f\u00A7rSwamp Lights can be captured and released from special jars"), false);
					}
					if (entity.getPersistentData().getDouble("Swampmonster_Tip") == 8) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A73\u00A7lSwamp Monster Tip: \u00A7f\u00A7rThe Swamp Monster Chieftan wears a headdress and can help you level up"), false);
					}
					if (entity.getPersistentData().getDouble("Swampmonster_Tip") == 9) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A73\u00A7lSwamp Monster Tip: \u00A7f\u00A7rHungry Trees are dark, walking trees that appear in swampy regions at night"), false);
					}
					if (entity.getPersistentData().getDouble("Swampmonster_Tip") == 10) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A73\u00A7lSwamp Monster Tip: \u00A7f\u00A7rSwamp Essence Dust can be farmed by feeding a Swamp Light regular Dark Essence Dust"), false);
					}
					if (entity.getPersistentData().getDouble("Swampmonster_Tip") == 11) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A73\u00A7lSwamp Monster Tip: \u00A7f\u00A7rYou can trade with Swamp Monster Villagers for important materials to help you progress"), false);
					}
					if (entity.getPersistentData().getDouble("Hunter_Tip") == 1) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A76\u00A7lHunter Tip: \u00A7f\u00A7rMangrove propagules are uncommonly obtained from Trick or Treat bags"), false);
					}
					if (entity.getPersistentData().getDouble("Hunter_Tip") == 2) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A76\u00A7lHunter Tip: \u00A7f\u00A7rSilver Dust can appear when mining Copper"), false);
					}
					if (entity.getPersistentData().getDouble("Hunter_Tip") == 3) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A76\u00A7lHunter Tip: \u00A7f\u00A7rAlways carry an Amulet of Clear Mind or an Amulet of Strong Will in your off hand!"), false);
					}
					if (entity.getPersistentData().getDouble("Hunter_Tip") == 4) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A76\u00A7lHunter Tip: \u00A7f\u00A7rSometimes Cure Serum is found at Hunter Offices"), false);
					}
					if (entity.getPersistentData().getDouble("Hunter_Tip") == 5) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A76\u00A7lHunter Tip: \u00A7f\u00A7rKeep magical powders if you find them. They might come in handy later!"), false);
					}
					if (entity.getPersistentData().getDouble("Hunter_Tip") == 6) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A76\u00A7lHunter Tip: \u00A7f\u00A7rThe Mysterious Container can reset the Mysterious Darkness timer, buying you time to find a real cure"), false);
					}
					if (entity.getPersistentData().getDouble("Hunter_Tip") == 7) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A76\u00A7lHunter Tip: \u00A7f\u00A7rSpooky biomes tend to have more dangerous monsters than regular biomes"), false);
					}
					if (entity.getPersistentData().getDouble("Hunter_Tip") == 8) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A76\u00A7lHunter Tip: \u00A7f\u00A7rRegular iron and silver bolts are reusable"), false);
					}
					if (entity.getPersistentData().getDouble("Hunter_Tip") == 9) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A76\u00A7lHunter Tip: \u00A7f\u00A7rYou're more likely to find feral Vampires and feral Goblins in spooky biomes"), false);
					}
					if (entity.getPersistentData().getDouble("Sorcerer_Tip") == 1) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A75\u00A7lSorcerer Tip: \u00A7f\u00A7rSorcerer villages are found in taiga-like regions"), false);
					}
					if (entity.getPersistentData().getDouble("Sorcerer_Tip") == 2) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A75\u00A7lSorcerer Tip: \u00A7f\u00A7rSorcerers can have one of four types of elemental magic, thrown by pressing [G]"), false);
					}
					if (entity.getPersistentData().getDouble("Sorcerer_Tip") == 3) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A75\u00A7lSorcerer Tip: \u00A7f\u00A7rA book about rituals can be found in some Sorcerer houses"), false);
					}
					if (entity.getPersistentData().getDouble("Sorcerer_Tip") == 4) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A75\u00A7lSorcerer Tip: \u00A7f\u00A7rSorcerers are still human enough to be infected by supernatural bites"), false);
					}
					if (entity.getPersistentData().getDouble("Sorcerer_Tip") == 5) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A75\u00A7lSorcerer Tip: \u00A7f\u00A7rDark Essence Dust sometimes drops when breaking Darkened blocks"), false);
					}
					if (entity.getPersistentData().getDouble("Sorcerer_Tip") == 6) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A75\u00A7lSorcerer Tip: \u00A7f\u00A7rTrees can be infected by Mysterious Darkness by right-clicking the trunk with Dark Essence Dust"), false);
					}
					if (entity.getPersistentData().getDouble("Sorcerer_Tip") == 7) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A75\u00A7lSorcerer Tip: \u00A7f\u00A7rConcentrated Crystals can be picked up, moved, and reused"), false);
					}
					if (entity.getPersistentData().getDouble("Sorcerer_Tip") == 8) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A75\u00A7lSorcerer Tip: \u00A7f\u00A7rIt is sometimes best to use two rituals together..."), false);
					}
					if (entity.getPersistentData().getDouble("Sorcerer_Tip") == 9) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A75\u00A7lSorcerer Tip: \u00A7f\u00A7rDark Essence Dust can be farmed by infecting a tree and allowing it to spread to the leaves"), false);
					}
					if (entity.getPersistentData().getDouble("Sorcerer_Tip") == 10) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A75\u00A7lSorcerer Tip: \u00A7f\u00A7rDarkened Iron is made by combining Dark Essence Dust and Iron Ingots"), false);
					}
					if (entity.getPersistentData().getDouble("Troll_Tip") == 1) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A73\u00A7lTroll Tip: \u00A7f\u00A7rTroll Villages are found in mountainous areas"), false);
					}
					if (entity.getPersistentData().getDouble("Troll_Tip") == 2) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A73\u00A7lTroll Tip: \u00A7f\u00A7rTrolls are the only being able to mine Tungsten, by using the Work Hammer"), false);
					}
					if (entity.getPersistentData().getDouble("Troll_Tip") == 3) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A73\u00A7lTroll Tip: \u00A7f\u00A7rTrolls don't earn bad reputations easily, but can by killing innocents"), false);
					}
					if (entity.getPersistentData().getDouble("Troll_Tip") == 4) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A73\u00A7lTroll Tip: \u00A7f\u00A7rTroll Armor has special perks when full sets are worn"), false);
					}
					if (entity.getPersistentData().getDouble("Troll_Tip") == 5) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A73\u00A7lTroll Tip: \u00A7f\u00A7rTrolls are immune to vampire, werewolf, and zombie bites"), false);
					}
					if (entity.getPersistentData().getDouble("Troll_Tip") == 6) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A73\u00A7lTroll Tip: \u00A7f\u00A7rGoblins are willing to trade with Trolls for valuable materials"), false);
					}
					if (entity.getPersistentData().getDouble("Troll_Tip") == 7) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A73\u00A7lTroll Tip: \u00A7f\u00A7rTroll-made alloy tools each have a special ability, even shovels and hoes"), false);
					}
					if (entity.getPersistentData().getDouble("Troll_Tip") == 8) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A73\u00A7lTroll Tip: \u00A7f\u00A7rTroll-made tools can be modded by Goblins for additional effects"), false);
					}
					if (entity.getPersistentData().getDouble("Goblin_Tip") == 1) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7a\u00A7lGoblin Tip: \u00A7f\u00A7rGoblin Villages are found in forested areas"), false);
					}
					if (entity.getPersistentData().getDouble("Goblin_Tip") == 2) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7a\u00A7lGoblin Tip: \u00A7f\u00A7rGoblins can even modify Swamp Crystal tools and even Silver Daggers"), false);
					}
					if (entity.getPersistentData().getDouble("Goblin_Tip") == 3) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7a\u00A7lGoblin Tip: \u00A7f\u00A7rCookies can be made with most types of magical powders"), false);
					}
					if (entity.getPersistentData().getDouble("Goblin_Tip") == 4) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7a\u00A7lGoblin Tip: \u00A7f\u00A7rKidnapping too many baby villagers can get the Hunter's Guild called on you"), false);
					}
					if (entity.getPersistentData().getDouble("Goblin_Tip") == 5) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7a\u00A7lGoblin Tip: \u00A7f\u00A7rGoblins are immune to vampire, werewolf, and zombie bites"), false);
					}
					if (entity.getPersistentData().getDouble("Goblin_Tip") == 6) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7a\u00A7lGoblin Tip: \u00A7f\u00A7rTrolls are willing to trade with Goblins for valuable materials"), false);
					}
					if (entity.getPersistentData().getDouble("Goblin_Tip") == 7) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7a\u00A7lGoblin Tip: \u00A7f\u00A7rEnchanting innocent beings can worsen your reputation"), false);
					}
					if (entity.getPersistentData().getDouble("Goblin_Tip") == 8) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7a\u00A7lGoblin Tip: \u00A7f\u00A7rLevel 3+ Goblins can turn invisible by sneaking"), false);
					}
					if (entity.getPersistentData().getDouble("Goblin_Tip") == 9) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7a\u00A7lGoblin Tip: \u00A7f\u00A7rDark Essence Dust can infect the ground under sugar cane, and often drops from Darkened Leaves"), false);
					}
					if (entity.getPersistentData().getDouble("General_Tip") == 1) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7f\u00A7lGeneral Tip: \u00A7f\u00A7rFaction guidebooks can be found by breaking Dark Bookshelves or by trading with your own kind"), false);
					}
					if (entity.getPersistentData().getDouble("General_Tip") == 2) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7f\u00A7lGeneral Tip: \u00A7f\u00A7rSpooky biomes are more dangerous at night than normal biomes"), false);
					}
					if (entity.getPersistentData().getDouble("General_Tip") == 3) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7f\u00A7lGeneral Tip: \u00A7f\u00A7rTrick or Treat bags can be found as loot in many structures"), false);
					}
					if (entity.getPersistentData().getDouble("General_Tip") == 4) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7f\u00A7lGeneral Tip: \u00A7f\u00A7rSome structures contain darkened blocks which can infect you!"), false);
					}
					if (entity.getPersistentData().getDouble("General_Tip") == 5) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7f\u00A7lGeneral Tip: \u00A7f\u00A7rHunter's Guild offices in savannas can have helpful defenses against monsters"), false);
					}
					if (entity.getPersistentData().getDouble("General_Tip") == 6) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7f\u00A7lGeneral Tip: \u00A7f\u00A7rSkull icons indicate a bad reputation. The Hunter's Guild will have you on its radar!"), false);
					}
					if (entity.getPersistentData().getDouble("General_Tip") == 7) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7f\u00A7lGeneral Tip: \u00A7f\u00A7rPrecious stones are found throughout the world and have many uses."), false);
					}
					if (entity.getPersistentData().getDouble("General_Tip") == 8) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7f\u00A7lGeneral Tip: \u00A7f\u00A7rZombies can bite and infect players!"), false);
					}
					if (entity.getPersistentData().getDouble("General_Tip") == 9) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7f\u00A7lGeneral Tip: \u00A7f\u00A7rMonsters in villages tend to be civilized. Others tend to be dangerous!"), false);
					}
					if (entity.getPersistentData().getDouble("General_Tip") == 10) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7f\u00A7lGeneral Tip: \u00A7f\u00A7rSociety partrols wear black and carry monster detectors."), false);
					}
					if (entity.getPersistentData().getDouble("General_Tip") == 11) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7f\u00A7lGeneral Tip: \u00A7f\u00A7rCure Serum can be purchased from Mad Scientists in desert labs"), false);
					}
					if (entity.getPersistentData().getDouble("General_Tip") == 12) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7f\u00A7lGeneral Tip: \u00A7f\u00A7rReading lore and checking your advancements can help you progress through Monstrous World"), false);
					}
					if (entity.getPersistentData().getDouble("Werewolf_Tip") == 1) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A76\u00A7lWerewolf Tip: \u00A7f\u00A7rAll Werewolves transform during the full moon"), false);
					}
					if (entity.getPersistentData().getDouble("Werewolf_Tip") == 2) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A76\u00A7lWerewolf Tip: \u00A7f\u00A7rWerewolves turned by being bitten tend to grow more savage over time"), false);
					}
					if (entity.getPersistentData().getDouble("Werewolf_Tip") == 3) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A76\u00A7lWerewolf Tip: \u00A7f\u00A7rWerewolves cannot be infected by stepping on Darkened Blocks"), false);
					}
					if (entity.getPersistentData().getDouble("Werewolf_Tip") == 4) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A76\u00A7lWerewolf Tip: \u00A7f\u00A7rA bad reputation can get the Hunter's Guild called on you"), false);
					}
					if (entity.getPersistentData().getDouble("Werewolf_Tip") == 5) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A76\u00A7lWerewolf Tip: \u00A7f\u00A7rKilling mobs while in beast form replenishes hunger"), false);
					}
					if (entity.getPersistentData().getDouble("Werewolf_Tip") == 6) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A76\u00A7lWerewolf Tip: \u00A7f\u00A7rThe Bracelet of Beastly Restraint can help later-gen Werewolves avoid growing more savage"), false);
					}
					if (entity.getPersistentData().getDouble("Werewolf_Tip") == 7) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A76\u00A7lWerewolf Tip: \u00A7f\u00A7rWerewolf villages can be found in cold regions"), false);
					}
					if (entity.getPersistentData().getDouble("Werewolf_Tip") == 8) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A76\u00A7lWerewolf Tip: \u00A7f\u00A7rThe Lunar Pearl forces a Werewolf into beast form when used"), false);
					}
					if (entity.getPersistentData().getDouble("Werewolf_Tip") == 8) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A76\u00A7lWerewolf Tip: \u00A7f\u00A7rWerewolves can suffer Holy Damage from being hit by silver weapons"), false);
					}
					if (entity.getPersistentData().getDouble("Werewolf_Tip") == 9) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A76\u00A7lWerewolf Tip: \u00A7f\u00A7rThe Moon Clock can help you track the moon phase"), false);
					}
					if (entity.getPersistentData().getDouble("Werewolf_Tip") == 10) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A76\u00A7lWerewolf Tip: \u00A7f\u00A7rHelpful items for Werewolves can be found in Trick or Treat bags"), false);
					}
					if (entity.getPersistentData().getDouble("Werewolf_Tip") == 11) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A76\u00A7lWerewolf Tip: \u00A7f\u00A7rWerewolves are immune to Enchantment and Hypnosis while in beast form"), false);
					}
					if (entity.getPersistentData().getDouble("Vampire_Tip") == 1) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74\u00A7lVampire Tip: \u00A7f\u00A7rClicking on a creature with a Bloodletter will fill an empty bottle in your off hand with blood"), false);
					}
					if (entity.getPersistentData().getDouble("Vampire_Tip") == 2) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74\u00A7lVampire Tip: \u00A7f\u00A7rVampire Manors are found in Dark Forests and Murky Madness biomes"), false);
					}
					if (entity.getPersistentData().getDouble("Vampire_Tip") == 3) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74\u00A7lVampire Tip: \u00A7f\u00A7rHaving an empty blood bar will prevent you from healing"), false);
					}
					if (entity.getPersistentData().getDouble("Vampire_Tip") == 4) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74\u00A7lVampire Tip: \u00A7f\u00A7rA bad reputation can get the Hunter's Guild called on you"), false);
					}
					if (entity.getPersistentData().getDouble("Vampire_Tip") == 5) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74\u00A7lVampire Tip: \u00A7f\u00A7rFeeding directly from a being will grant Regeneration"), false);
					}
					if (entity.getPersistentData().getDouble("Vampire_Tip") == 6) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74\u00A7lVampire Tip: \u00A7f\u00A7rThe Vampire Cloak and Cloak Hood protect against sunlight for a short time"), false);
					}
					if (entity.getPersistentData().getDouble("Vampire_Tip") == 7) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74\u00A7lVampire Tip: \u00A7f\u00A7rCoffins are made with Evil Tree Logs and red wool"), false);
					}
					if (entity.getPersistentData().getDouble("Vampire_Tip") == 8) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74\u00A7lVampire Tip: \u00A7f\u00A7rVampires are immune to possession and are only mildly bothered by insanity"), false);
					}
					if (entity.getPersistentData().getDouble("Vampire_Tip") == 9) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74\u00A7lVampire Tip: \u00A7f\u00A7rSardonyx, needed for the Bloodletter, is found deep underground"), false);
					}
					if (entity.getPersistentData().getDouble("Vampire_Tip") == 10) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74\u00A7lVampire Tip: \u00A7f\u00A7rBiting human victims will infect them..."), false);
					}
					if (entity.getPersistentData().getDouble("Vampire_Tip") == 11) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74\u00A7lVampire Tip: \u00A7f\u00A7rHunters are resistant to Hypnosis"), false);
					}
					if (entity.getPersistentData().getDouble("Vampire_Tip") == 12) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74\u00A7lVampire Tip: \u00A7f\u00A7rPillagers, Witches, and many non-human beings are on a Vampire's menu... "), false);
					}
					if (entity.getPersistentData().getDouble("Vampire_Tip") == 13) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74\u00A7lVampire Tip: \u00A7f\u00A7rInfecting a human by biting will worsen your reputation"), false);
					}
					if (entity.getPersistentData().getDouble("Witch_Tip") == 1) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7a\u00A7lWitch Tip: \u00A7f\u00A7rA few magical plants can be found throughout the world"), false);
					}
					if (entity.getPersistentData().getDouble("Witch_Tip") == 2) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7a\u00A7lWitch Tip: \u00A7f\u00A7rWitch Villages are found in plains-type biomes"), false);
					}
					if (entity.getPersistentData().getDouble("Witch_Tip") == 3) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7a\u00A7lWitch Tip: \u00A7f\u00A7rUsing magical powders can improve or worsen your reputation"), false);
					}
					if (entity.getPersistentData().getDouble("Witch_Tip") == 4) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7a\u00A7lWitch Tip: \u00A7f\u00A7rA bad reputation can get the Hunter's Guild called on you"), false);
					}
					if (entity.getPersistentData().getDouble("Witch_Tip") == 5) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7a\u00A7lWitch Tip: \u00A7f\u00A7rTrick or Treat bags are found as loot, and are made by Witches and Warlocks"), false);
					}
					if (entity.getPersistentData().getDouble("Witch_Tip") == 6) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7a\u00A7lWitch Tip: \u00A7f\u00A7rSpooky biomes have more magical plants than other biomes"), false);
					}
					if (entity.getPersistentData().getDouble("Witch_Tip") == 7) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7a\u00A7lWitch Tip: \u00A7f\u00A7rUsing the magical Tomes you make will help you level up"), false);
					}
					if (entity.getPersistentData().getDouble("Witch_Tip") == 8) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7a\u00A7lWitch Tip: \u00A7f\u00A7rUsing magical powders you make will help you level up"), false);
					}
					if (entity.getPersistentData().getDouble("Witch_Tip") == 8) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7a\u00A7lWitch Tip: \u00A7f\u00A7rOnyx and Sardonyx are found deep underground"), false);
					}
					if (entity.getPersistentData().getDouble("Witch_Tip") == 9) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7a\u00A7lWitch Tip: \u00A7f\u00A7rRose Quartz may be found in flowery biomes"), false);
					}
					if (entity.getPersistentData().getDouble("Witch_Tip") == 10) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7a\u00A7lWitch Tip: \u00A7f\u00A7rEvil Trees can spit sticky sap at victims"), false);
					}
					if (entity.getPersistentData().getDouble("Witch_Tip") == 11) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7a\u00A7lWitch Tip: \u00A7f\u00A7rGhostly Trees are a blue-gray color and drop Ghostly Apples on occasion"), false);
					}
					if (entity.getPersistentData().getDouble("Witch_Tip") == 12) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7a\u00A7lWitch Tip: \u00A7f\u00A7rCat Familiars are stubborn, but might follow you if you're holding raw salmon or cod."), false);
					}
				}
			}
		}
	}
}