package net.mcreator.monstrousworld.configuration;

import net.neoforged.neoforge.common.ModConfigSpec;

public class MonstrousWorldConfigConfiguration {
	public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
	public static final ModConfigSpec SPEC;
	public static final ModConfigSpec.ConfigValue<Boolean> GRANT_SOCIETY_PAMPHLET;
	public static final ModConfigSpec.ConfigValue<Boolean> ENABLE_SOCIETY_RAIDS;
	public static final ModConfigSpec.ConfigValue<Boolean> ENABLE_NIGHTMARE_MODE;
	public static final ModConfigSpec.ConfigValue<Boolean> START_ON_NIGHTMARE_MODE;
	public static final ModConfigSpec.ConfigValue<Boolean> SHOW_STARTUP_TIPS;
	public static final ModConfigSpec.ConfigValue<Boolean> DISPLAY_MANIAC_WARNING;
	public static final ModConfigSpec.ConfigValue<Boolean> ALLOW_MYSTERIOUS_DARKNESS_INFECTION;
	public static final ModConfigSpec.ConfigValue<Boolean> ALLOW_BOOKSHELF_SPIRITS;
	public static final ModConfigSpec.ConfigValue<Double> PUMPKINS_REVENGE_CHANCE;
	public static final ModConfigSpec.ConfigValue<Double> POSSESSION_CHANCE;
	public static final ModConfigSpec.ConfigValue<Double> INSANITY_CHANCE;
	public static final ModConfigSpec.ConfigValue<Double> ENCHANTMENT_CHANCE;
	public static final ModConfigSpec.ConfigValue<Double> ZOMBIE_INFECTION_CHANCE;
	public static final ModConfigSpec.ConfigValue<Boolean> ALLOW_LOOMING_UNDEATH_CURSE;
	public static final ModConfigSpec.ConfigValue<Double> VAMPIRE_INFECTION_CHANCE;
	public static final ModConfigSpec.ConfigValue<Double> WEREWOLF_INFECTION_CHANCE;
	public static final ModConfigSpec.ConfigValue<Double> MUTATION_CHANCE;
	public static final ModConfigSpec.ConfigValue<Boolean> ALLOW_WITCH_FACTION;
	public static final ModConfigSpec.ConfigValue<Boolean> ALLOW_GOBLIN_FACTION;
	public static final ModConfigSpec.ConfigValue<Boolean> ALLOW_TROLL_FACTION;
	public static final ModConfigSpec.ConfigValue<Boolean> ALLOW_SORCERER_FACTION;
	public static final ModConfigSpec.ConfigValue<Boolean> ALLOW_MAD_SCIENTIST_FACTION;
	public static final ModConfigSpec.ConfigValue<Boolean> ALLOW_SWAMP_MONSTER_FACTION;
	public static final ModConfigSpec.ConfigValue<Boolean> ALLOW_WEREWOLF_FACTION;
	public static final ModConfigSpec.ConfigValue<Boolean> ALLOW_VAMPIRE_FACTION;
	public static final ModConfigSpec.ConfigValue<Boolean> ALLOW_DARKNESS_FACTION;
	public static final ModConfigSpec.ConfigValue<Boolean> ALLOW_EVIL_FACTION;
	public static final ModConfigSpec.ConfigValue<Boolean> ALLOW_DEMON_FACTION;
	public static final ModConfigSpec.ConfigValue<Boolean> ALLOW_EVIL_CLOWN_FACTION;
	public static final ModConfigSpec.ConfigValue<Boolean> ALLOW_MANIAC_FACTION;
	public static final ModConfigSpec.ConfigValue<Boolean> ALLOW_HUNTER_FACTION;
	public static final ModConfigSpec.ConfigValue<Double> DARKNESS_SPREADING_AREA;
	public static final ModConfigSpec.ConfigValue<Double> PLACE_ABANDONED_CART;
	public static final ModConfigSpec.ConfigValue<Double> PLACE_EVIL_TREES_FORESTS;
	public static final ModConfigSpec.ConfigValue<Double> PLACE_EVIL_TREES_SWAMPS;
	public static final ModConfigSpec.ConfigValue<Double> PLACE_EVIL_TREES_SPOOKY;
	public static final ModConfigSpec.ConfigValue<Double> PLACE_AWAKENED_SOUL_SAND;
	public static final ModConfigSpec.ConfigValue<Double> PLACE_AWAKENED_SOUL_SAND_DEATHLY;
	public static final ModConfigSpec.ConfigValue<Double> PLACE_GOURD_PATCHES;
	public static final ModConfigSpec.ConfigValue<Double> PLACE_PUMPKIN_TRAP_PATCHES;
	public static final ModConfigSpec.ConfigValue<Double> PLACE_DARKENED_BOOKSHELVES_SURFACE_COLD;
	public static final ModConfigSpec.ConfigValue<Double> PLACE_DARKENED_BOOKSHELVES_SURFACE_HUMID;
	public static final ModConfigSpec.ConfigValue<Double> PLACE_DARKENED_BOOKSHELVES_CAVE;
	public static final ModConfigSpec.ConfigValue<Double> PLACE_DARKENED_BOOKSHELVES_SPOOKY;
	public static final ModConfigSpec.ConfigValue<Double> PLACE_ABANDONED_TENTS;
	public static final ModConfigSpec.ConfigValue<Double> PLACE_FERAL_TROLL_HIDEOUTS;
	public static final ModConfigSpec.ConfigValue<Double> PLACE_GIANT_PUMPKINS;
	public static final ModConfigSpec.ConfigValue<Double> PLACE_WEBBED_RUINS;
	public static final ModConfigSpec.ConfigValue<Double> PLACE_GUILD_ADS;
	public static final ModConfigSpec.ConfigValue<Double> PLACE_WEREWOLF_WARNING;
	public static final ModConfigSpec.ConfigValue<Double> PLACE_VAMPIRE_WARNING;
	public static final ModConfigSpec.ConfigValue<Double> PLACE_WISP_WARNING;
	public static final ModConfigSpec.ConfigValue<Double> PLACE_SWAMP_WARNING;
	public static final ModConfigSpec.ConfigValue<Double> PLACE_TROLL_WARNING;
	public static final ModConfigSpec.ConfigValue<Double> PLACE_CLOWN_WARNING;
	public static final ModConfigSpec.ConfigValue<Double> PLACE_MANIAC_WARNING;
	public static final ModConfigSpec.ConfigValue<Double> PLACE_NETHER_WARNING;
	public static final ModConfigSpec.ConfigValue<Double> PLACE_VILLAGER_JOURNAL;
	public static final ModConfigSpec.ConfigValue<Double> PLACE_TRICK_TREAT_ADS;
	public static final ModConfigSpec.ConfigValue<Double> PLACE_MUSEUM_ADS;
	public static final ModConfigSpec.ConfigValue<Double> PLACE_DARK_MARKETS;
	public static final ModConfigSpec.ConfigValue<Double> PLACE_CIRCUS_TENT;
	public static final ModConfigSpec.ConfigValue<Double> PLACE_MANIAC_HOUSE;
	public static final ModConfigSpec.ConfigValue<Double> PLACE_NETHER_HALL;
	public static final ModConfigSpec.ConfigValue<Double> SOCIETY_MEMBER_SPAWN_CHANCE_HUMAN;
	public static final ModConfigSpec.ConfigValue<Double> SOCIETY_MEMBER_SPAWN_CHANCE_MONSTER;
	public static final ModConfigSpec.ConfigValue<Double> VENGEFUL_PUMPKIN_SPAWN_CHANCE;
	public static final ModConfigSpec.ConfigValue<Double> DREADFUL_WATCHER_SPAWN_CHANCE;
	public static final ModConfigSpec.ConfigValue<Double> GIANT_FLY_SPAWN_CHANCE;
	public static final ModConfigSpec.ConfigValue<Double> GIANT_SNAKE_SPAWN_CHANCE;
	public static final ModConfigSpec.ConfigValue<Double> DARKNESS_SPIRIT_SPAWN_CHANCE;
	public static final ModConfigSpec.ConfigValue<Double> LEVITATING_SPIRIT_SPAWN_CHANCE;
	public static final ModConfigSpec.ConfigValue<Double> WEREWOLF_SPAWN_CHANCE;
	public static final ModConfigSpec.ConfigValue<Double> DIRE_WEREWOLF_SPAWN_CHANCE_NORMAL;
	public static final ModConfigSpec.ConfigValue<Double> DIRE_WEREWOLF_SPAWN_CHANCE_MARKER;
	public static final ModConfigSpec.ConfigValue<Double> VAMPIRE_SPAWN_CHANCE;
	public static final ModConfigSpec.ConfigValue<Double> FERAL_GOBLIN_SPAWN_CHANCE;
	public static final ModConfigSpec.ConfigValue<Double> WISP_SPAWN_CHANCE;
	public static final ModConfigSpec.ConfigValue<Double> EVIL_CLOWN_SPAWN_CHANCE;
	public static final ModConfigSpec.ConfigValue<Double> MANIAC_SPAWN_CHANCE;
	public static final ModConfigSpec.ConfigValue<Double> DEMON_SPAWN_CHANCE;
	public static final ModConfigSpec.ConfigValue<Double> VENGEFUL_PUMPKIN_SPAWN_CHANCE_SPOOKY;
	public static final ModConfigSpec.ConfigValue<Double> DREADFUL_WATCHER_SPAWN_CHANCE_SPOOKY;
	public static final ModConfigSpec.ConfigValue<Double> GIANT_FLY_SPAWN_CHANCE_SPOOKY;
	public static final ModConfigSpec.ConfigValue<Double> ENHANCED_ZOMBIE_SPAWN_CHANCE_SPOOKY;
	public static final ModConfigSpec.ConfigValue<Double> LEVITATING_SPIRIT_SPAWN_CHANCE_SPOOKY;
	public static final ModConfigSpec.ConfigValue<Double> DARKNESS_SPIRIT_SPAWN_CHANCE_SPOOKY;
	public static final ModConfigSpec.ConfigValue<Double> FERAL_GOBLIN_SPAWN_CHANCE_SPOOKY;
	public static final ModConfigSpec.ConfigValue<Double> FERAL_VAMPIRE_SPAWN_CHANCE_SPOOKY;
	public static final ModConfigSpec.ConfigValue<Double> EVIL_CLOWN_SPAWN_CHANCE_SPOOKY;
	public static final ModConfigSpec.ConfigValue<Double> MANIAC_SPAWN_CHANCE_SPOOKY;
	static {
		BUILDER.push("general");
		GRANT_SOCIETY_PAMPHLET = BUILDER.comment("Grants the Society Pamphlet to all starting players, which contains original lore. Disable this if your modpack is relying on other lore for progression.").define("grant_starting_lore", true);
		ENABLE_SOCIETY_RAIDS = BUILDER.comment("If true, Society Raids can occur in monster villages").define("enable_society_raids", true);
		ENABLE_NIGHTMARE_MODE = BUILDER.comment("Allows Nightmare Mode to trigger upon use of a special item. Nightmare Mode unlocks Evil Factions, and causes new monsters and structures to spawn.").define("enable_nightmare_mode", true);
		START_ON_NIGHTMARE_MODE = BUILDER.comment("If enabled, Nightmare Mode will be active upon starting a world, or upon rejoining a world").define("start_with_nightmare_mode", false);
		SHOW_STARTUP_TIPS = BUILDER.comment("Displays Startup Tips upon joining a world, including faction-specific and general tips.").define("show_startup_tips", true);
		DISPLAY_MANIAC_WARNING = BUILDER.comment("Displays a warning message whenever a Maniac spawns nearby").define("maniac_warning_messages", true);
		BUILDER.pop();
		BUILDER.push("infectionand_effect_chances");
		ALLOW_MYSTERIOUS_DARKNESS_INFECTION = BUILDER.comment("Allow players to become infected by Mysterious Darkness. Setting to false will disable joining all monster factions. This setting does not disable mutations or supernatural bites.")
				.define("allow_mysterious_darkness_infection", true);
		ALLOW_BOOKSHELF_SPIRITS = BUILDER.comment("If enabled, Evil Spirits can spawn from breaking Dark Bookshelves.").define("allow_evil_spirits_in_dark_bookshelves", true);
		PUMPKINS_REVENGE_CHANCE = BUILDER.comment("The chance a Vengeful Pumpkin will inflict Pumpkin's Revenge. Default 0.05 (5% chance.) Range 0-1. Set to 0 to disable.").define("pumpkins_revenge_chance", (double) 0.05);
		POSSESSION_CHANCE = BUILDER.comment("The chance a nearby Weak Evil Spirit will possess the player. Default 0.1. Range 0-1. Set to 0 to disable.").define("possession_chance", (double) 0.1);
		INSANITY_CHANCE = BUILDER.comment("The chance that a nearby Dreadful Watcher will inflict insanity on the player (if vulnerable). Default 0.001 (.01% chance per game tick). Range 0-1. Set to 0 to disable.").define("insanity_chance",
				(double) 0.001);
		ENCHANTMENT_CHANCE = BUILDER.comment("The chance that a nearby Will O The Wisp will inflict enchantment on the player (if vulnerable). Default 0.01 (1% chance per game tick). Range 0-1. Set to 0 to disable.").define("enchantment_chance",
				(double) 0.01);
		ZOMBIE_INFECTION_CHANCE = BUILDER.comment("Allows zombies to infect human players by biting. Default setting is 0.01 (1% chance). Range: 0-1. Set to 0 to disable this.").define("zombie_infection_chance", (double) 0.01);
		ALLOW_LOOMING_UNDEATH_CURSE = BUILDER.comment("Allows the Looming Undeath curse to zombify human players who die with the effect. Set to false to disable this. ").define("allow_zombification_from_curse", true);
		VAMPIRE_INFECTION_CHANCE = BUILDER.comment("Allows Vampires to infect human players by biting. Default setting is 1 (100% chance). Range: 0-1. Set to 0 to disable this.").define("vampire_infection_chance", (double) 1);
		WEREWOLF_INFECTION_CHANCE = BUILDER.comment("Allows Werewolves to infect human players by attacking. Default setting is 0.5 (50% chance). Range: 0-1. Set to 0 to disable this.").define("werewolf_infection_chance", (double) 0.5);
		MUTATION_CHANCE = BUILDER.comment("Chance that trading with a Mad Scientist will result in mutation for human players. Default value 0.1 (10%). Range 0-1. Set to 0 to disable this.").define("mutation_chance", (double) 0.1);
		BUILDER.pop();
		BUILDER.push("allowed_factions");
		ALLOW_WITCH_FACTION = BUILDER.comment("Allows players to become Witches and Warlocks").define("allow_witch_faction", true);
		ALLOW_GOBLIN_FACTION = BUILDER.comment("Allows players to become Goblins").define("allow_goblin_faction", true);
		ALLOW_TROLL_FACTION = BUILDER.comment("Allows players to become Trolls").define("allow_troll_faction", true);
		ALLOW_SORCERER_FACTION = BUILDER.comment("Allows players to become Sorcerers").define("allow_sorcerer_faction", true);
		ALLOW_MAD_SCIENTIST_FACTION = BUILDER.comment("Allows players to become Mad Scientists").define("allow_mad_scientist_faction", true);
		ALLOW_SWAMP_MONSTER_FACTION = BUILDER.comment("Allows players to become Swamp Monsters").define("allow_swamp_monster_faction", true);
		ALLOW_WEREWOLF_FACTION = BUILDER.comment("Allows players to become Werewolves through Mysterious Darkness infection").define("allow_werewolf_faction", true);
		ALLOW_VAMPIRE_FACTION = BUILDER.comment("Allows players to become Vampires through Mysterious Darkness infection").define("allow_vampire_faction", true);
		ALLOW_DARKNESS_FACTION = BUILDER.comment("Allows players to become Darkness Wielders").define("allow_darkness_faction", true);
		ALLOW_EVIL_FACTION = BUILDER.comment("Allows players to join Evil Factions (Demon, Evil Clown, Maniac) if they are enabled. Setting this to false will still allow these monsters to spawn, if Nightmare Mode is enabled")
				.define("allow_evil_factions", true);
		ALLOW_DEMON_FACTION = BUILDER.comment("Allows players to become Demons. Faction may not be compatible with temperature mods such as Tough as Nails").define("allow_demon_faction", true);
		ALLOW_EVIL_CLOWN_FACTION = BUILDER.comment("Allows players to become Evil Clowns").define("allow_evil_clown_faction", true);
		ALLOW_MANIAC_FACTION = BUILDER.comment("Allows players to become Maniacs").define("allow_maniac_faction", true);
		ALLOW_HUNTER_FACTION = BUILDER.comment("Allows players to join the Hunter's Guild and become monster hunters").define("allow_hunter_faction", true);
		BUILDER.pop();
		BUILDER.push("structure_spawns");
		DARKNESS_SPREADING_AREA = BUILDER.comment(
				"How often Mysterious Darkness tries to show up in the Overworld. Range 0-1. Default 0.04 (1/25 chunks.) Mysterious Darkness won't always reach the surface in affected areas, and large caves will reduce its appearance. Set to 0 to disable.")
				.define("mysterious_darkness_appearances", (double) 0.04);
		PLACE_ABANDONED_CART = BUILDER.comment("How often Abandoned Pumpkin Carts appear in Plains biomes. Range 0-1. Default 0.00165 (1/600 chunks.) Set to 0 to disable.").define("abandoned_cart_appearances", (double) 0.00165);
		PLACE_EVIL_TREES_FORESTS = BUILDER.comment("Controls how often Evil Trees are placed in forested biomes. Default value is 0.0025 (0.25% chance) of an Evil Tree per chunk. Set to 0 to disable. Recommended to keep values below 0.01 ")
				.define("evil_treesin_forests", (double) 0.0025);
		PLACE_EVIL_TREES_SWAMPS = BUILDER.comment("Controls how often Evil Trees are placed in swamp biomes. Default value is 0.005 (0.5% chance) of an Evil Tree per chunk. Set to 0 to disable. Recommended to keep values below 0.01 ")
				.define("evil_treesin_swamps", (double) 0.005);
		PLACE_EVIL_TREES_SPOOKY = BUILDER.comment(
				"Controls how often Evil Trees are placed in the Murky Madness, Deathly Forest, and Crimson Dread biomes. Default value is 0.009 (0.9% chance) of an Evil Tree per chunk. Set to 0 to disable. Recommended to keep values below 0.01 ")
				.define("evil_treesin_spooky_biomes", (double) 0.009);
		PLACE_AWAKENED_SOUL_SAND = BUILDER.comment("How often Awakened Soul Sand appears in dry biomes. Default value 0.086 (1/12 chunks). Range 0-1. Set to 0 to disable.").define("awakened_soul_sandin_dry_biomes", (double) 0.086);
		PLACE_AWAKENED_SOUL_SAND_DEATHLY = BUILDER.comment("How often Awakened Soul Sand appears in the Deathly Forest. Default value 0.086 (1/12 chunks). Range 0-1. Set to 0 to disable.").define("awakened_soul_sandin_deathly_forest",
				(double) 0.086);
		PLACE_GOURD_PATCHES = BUILDER.comment("How often Gourds appear in the overworld. Default value 0.033 (1/30 chunks). Range 0-1. Set to 0 to disable.").define("gourd_patches", (double) 0.033);
		PLACE_PUMPKIN_TRAP_PATCHES = BUILDER.comment("How often Vengeful Pumpkin Patches appear on land. Default value 0.0167 (1/60 chunks). Range 0-1. Set to 0 to disable.").define("vengeful_pumpkin_patches", (double) 0.0167);
		PLACE_DARKENED_BOOKSHELVES_SURFACE_COLD = BUILDER.comment("How often Darkened Bookshelves appear in non-spooky, cold biomes on the surface. Default value 0.01 (1/100 chunks). Range 0-1. Set to 0 to disable.")
				.define("darkened_bookshelves[_coldsurface]", (double) 0.01);
		PLACE_DARKENED_BOOKSHELVES_SURFACE_HUMID = BUILDER.comment("How often Darkened Bookshelves appear in humid biomes on the surface. Default value 0.01 (1/100 chunks). Range 0-1. Set to 0 to disable.")
				.define("darkened_bookshelves[_humidsurface]", (double) 0.01);
		PLACE_DARKENED_BOOKSHELVES_CAVE = BUILDER.comment("How often Darkened Bookshelves appear in caves. Default value 0.1 (1/10 chunks). Range 0-1. Set to 0 to disable.").define("darkened_bookshelves[_cave]", (double) 0.1);
		PLACE_DARKENED_BOOKSHELVES_SPOOKY = BUILDER.comment("How often extra Darkened Bookshelves appear in the Deathly Forest, Crimson Dread and Murky Madness. Default value 0.01 (1/100 chunks). Range 0-1. Set to 0 to disable.")
				.define("darkened_bookshelves[_spooky_forests]", (double) 0.01);
		PLACE_ABANDONED_TENTS = BUILDER.comment("How often Abandoned Sorceress Tents appear in taiga-like biomes. Default value 0.00285 (1/350 chunks). Range 0-1. Set to 0 to disable.").define("abandoned_sorceress_tents", (double) 0.00285);
		PLACE_FERAL_TROLL_HIDEOUTS = BUILDER.comment("How often underground Feral Mountain Troll hideouts attempt to spawn in mountainous biomes. Default value 0.25 (A 25% chance of a spawn attempt, most will fail). Range 0-1. Set to 0 to disable.")
				.define("feral_troll_hideouts", (double) 0.25);
		PLACE_GIANT_PUMPKINS = BUILDER.comment("How often Giant Pumpkins appear in Plains biomes. Default value 0.1 (1/10 chunks). Range 0-1. Set to 0 to disable.").define("giant_pumpkins", (double) 0.1);
		PLACE_WEBBED_RUINS = BUILDER.comment("How often Webbed Ruins appear in Crimson Dread and Forskaken Lands biomes. Default value 0.05 (1/20 chunks). Range 0-1. Set to 0 to disable.").define("webbed_ruins", (double) 0.05);
		PLACE_GUILD_ADS = BUILDER.comment("How often Hunter's Guild Ads appear on land. Default value 0.00165 (1/600 chunks). Range 0-1. Set to 0 to disable.").define("hunter's_guild_ads", (double) 0.00165);
		PLACE_WEREWOLF_WARNING = BUILDER.comment("How often Werewolf Warning signs appear in the world. Default value 0.00165 (1/600 land chunks). Range 0-1. Set to 0 to disable.").define("werewolf_warning_signs", (double) 0.00165);
		PLACE_VAMPIRE_WARNING = BUILDER.comment("How often Vampire Warning signs appear in the world. Default value 0.00165 (1/600 land chunks). Range 0-1. Set to 0 to disable.").define("vampire_warning_signs", (double) 0.00165);
		PLACE_WISP_WARNING = BUILDER.comment("How often Wisp Warning signs appear in forests. Default value 0.007 (1/140 forest chunks). Range 0-1. Set to 0 to disable.").define("wisp_warning_signs", (double) 0.007);
		PLACE_SWAMP_WARNING = BUILDER.comment("How often Swamp Warning signs appear in swamps on land. Default value 0.014 (1/70 land swamp chunks). Range 0-1. Set to 0 to disable.").define("swamp_warning_signs", (double) 0.014);
		PLACE_TROLL_WARNING = BUILDER.comment("How often Troll Warning signs appear in mountainous biomes. Default value 0.01 (1/100 chunks). Range 0-1. Set to 0 to disable.").define("troll_warning_signs", (double) 0.01);
		PLACE_CLOWN_WARNING = BUILDER.comment("How often Clown Warning signs appear on land after Nightmare Mode triggers. Default value 0.0033 (1/300 chunks). Range 0-1. Set to 0 to disable.").define("clown_warning_signs", (double) 0.0033);
		PLACE_MANIAC_WARNING = BUILDER.comment("How often Maniac Warning signs appear on land after Nightmare Mode triggers. Default value 0.0033 (1/300 chunks). Range 0-1. Set to 0 to disable.").define("maniac_warning_signs", (double) 0.0033);
		PLACE_NETHER_WARNING = BUILDER.comment("How often Nether Warning signs appear on land after Nightmare Mode triggers. Default value 0.0033 (1/300 chunks). Range 0-1. Set to 0 to disable.").define("nether_warning_signs", (double) 0.0033);
		PLACE_VILLAGER_JOURNAL = BUILDER.comment("How often Villager Warning Structures appear on land. Default value 0.00165 (1/600 chunks). Range 0-1. Set to 0 to disable.").define("villager_warnings", (double) 0.00165);
		PLACE_TRICK_TREAT_ADS = BUILDER.comment("How often Trick or Treat Ads appear on land. Default value 0.00165 (1/600 chunks). Range 0-1. Set to 0 to disable.").define("trick_or_treat_ads", (double) 0.00165);
		PLACE_MUSEUM_ADS = BUILDER.comment("How often Museum Ads appear on land. Default value 0.00165 (1/600 chunks). Range 0-1. Set to 0 to disable.").define("museum_ads", (double) 0.00165);
		PLACE_DARK_MARKETS = BUILDER.comment("How often Dark Markets appear in the Crimson Dread biome after Nightmare Mode triggers. Default value 0.022 (1/45 chunks). Range 0-1. Set to 0 to disable.").define("dark_markets", (double) 0.022);
		PLACE_CIRCUS_TENT = BUILDER.comment("How often Circus Tents appear in the Forsaken Lands biome after Nightmare Mode triggers. Default value 0.01 (1/100 chunks). Range 0-1. Set to 0 to disable.").define("circus_tents", (double) 0.01);
		PLACE_MANIAC_HOUSE = BUILDER.comment("How often Maniac Houses appear after Nightmare Mode triggers. Default value 0.0015 (1/650 chunks). Range 0-1. Set to 0 to disable.").define("maniac_houses", (double) 0.0015);
		PLACE_NETHER_HALL = BUILDER.comment("How often Nether Halls appear in the Nether after Nightmare Mode triggers. Default value 0.33 (1 spawn attempt per 3 chunks, though attempts often fail.) Range 0-1. Set to 0 to disable.")
				.define("nether_halls", (double) 0.33);
		BUILDER.pop();
		BUILDER.push("mob_spawnsin_normal_biomes");
		SOCIETY_MEMBER_SPAWN_CHANCE_HUMAN = BUILDER.comment("Spawn chance of Society Patrols around ordinary human players. Default 0.0033 (1/300 chance per block placed or broken). Set to 0 to disable.")
				.define("society_member_spawn_chance_for_humans", (double) 0.0033);
		SOCIETY_MEMBER_SPAWN_CHANCE_MONSTER = BUILDER.comment("Spawn chance of Society Members around monster players. Default 0.004 (1/250 chance per block placed or broken). Set to 0 to disable.").define("society_member_spawn_chance_for_monsters",
				(double) 0.004);
		VENGEFUL_PUMPKIN_SPAWN_CHANCE = BUILDER.comment("Spawn weight of Vengeful Pumpkins in non-spooky biomes. Default 20. Range 0-100. [100 is as common as Zombies, while 5 is as common as the Witch.] Set to 0 to disable.")
				.define("vengeful_pumpkin_spawn_weight", (double) 20);
		DREADFUL_WATCHER_SPAWN_CHANCE = BUILDER.comment("Spawn weight of Dreadful Watchers in non-spooky biomes. Default 4. Range 0-100. [100 is as common as Zombies, while 5 is as common as the Witch.] Set to 0 to disable.")
				.define("dreadful_watcher_spawn_weight", (double) 4);
		GIANT_FLY_SPAWN_CHANCE = BUILDER.comment("Spawn weight of Giant Flies in regular biomes. Default 10. Range 0-100. [100 is as common as Zombies, while 5 is as common as the Witch.] Set to 0 to disable.").define("giant_fly_spawn_weight",
				(double) 10);
		GIANT_SNAKE_SPAWN_CHANCE = BUILDER.comment("Spawn weight of Giant Snakes in jungle biomes. Default 10. Range 0-100. [100 is as common as Zombies, while 5 is as common as the Witch.] Set to 0 to disable.").define("giant_snake_spawn_weight",
				(double) 10);
		DARKNESS_SPIRIT_SPAWN_CHANCE = BUILDER.comment("Spawn weight of Darkness Possessing Spirits in non-spooky biomes. Default 4. Set to 0 to disable.").define("evil_darkness_possessing_spirit_spawn_weight", (double) 4);
		LEVITATING_SPIRIT_SPAWN_CHANCE = BUILDER.comment("Spawn weight of Levitating Possessing Spirits in non-spooky biomes. Default 4. Set to 0 to disable.").define("evil_levitating_possessing_spirit_spawn_weight", (double) 4);
		WEREWOLF_SPAWN_CHANCE = BUILDER.comment("Spawn weight of feral Werewolves in all biomes during full moon nights. Default 5. Set to 0 to disable.").define("werewolf_spawn_weight[_full_moon_only]", (double) 5);
		DIRE_WEREWOLF_SPAWN_CHANCE_NORMAL = BUILDER.comment("Spawn weight of the Dire Werewolf boss in all biomes during full moon nights. Default 1. Set to 0 to disable.").define("dire_werewolf_spawn_weight[_normal]", (double) 1);
		DIRE_WEREWOLF_SPAWN_CHANCE_MARKER = BUILDER.comment("Spawn weight of the Dire Werewolf boss near Werewolf territories during full moons. Default 3. Set to 0 to disable.").define("dire_werewolf_spawn_weight[_near_werewolf_territory]",
				(double) 3);
		VAMPIRE_SPAWN_CHANCE = BUILDER.comment("Spawn weight of Feral Vampires in regular biomes. Default 2 (Weight of 2). Recommend keeping this value low. Set to 0 to disable. Vampires cannot spawn close to one another, affecting spawn rates.")
				.define("feral_vampire_spawn_weight", (double) 2);
		FERAL_GOBLIN_SPAWN_CHANCE = BUILDER.comment("Spawn weight of feral Goblins in regular, forested biomes. Default 2. Recommend keeping this value low. Set to 0 to disable.").define("feral_goblin_spawn_weight", (double) 2);
		WISP_SPAWN_CHANCE = BUILDER.comment("Spawn weight of lone Will O The Wisps in all forested biomes. Default 2. Recommend keeping this value low. Set to 0 to disable.").define("wisp_spawn_weight", (double) 2);
		EVIL_CLOWN_SPAWN_CHANCE = BUILDER.comment("Spawn weight of Evil Clowns in regular biomes. Default 2. Range 0-100. [100 is as common as Zombies, while 5 is as common as the Witch.] Set to 0 to disable.")
				.define("evil_clown_spawn_weight_in_regular_biomes[_nightmare_modeonly]", (double) 2);
		MANIAC_SPAWN_CHANCE = BUILDER.comment("Spawn weight of Maniacs in regular biomes. Default 1. Range 0-100. [100 is as common as Zombies, while 5 is as common as the Witch.] Set to 0 to disable.")
				.define("maniac_spawn_weight_in_regular_biomes[_nightmare_modeonly]", (double) 1);
		DEMON_SPAWN_CHANCE = BUILDER.comment("Spawn weight of Demons in the Nether, outside of Nether Halls. Default 10. Range 0-100. [100 is as common as Zombies, while 5 is as common as the Witch.] Set to 0 to disable.")
				.define("demon_spawn_weight_in_nether[_nightmare_modeonly]", (double) 10);
		BUILDER.pop();
		BUILDER.push("mob_spawnsin_spooky_biomes[_murky_madness,_forsaken_lands,_crimson_dread,_deathly_forest]");
		VENGEFUL_PUMPKIN_SPAWN_CHANCE_SPOOKY = BUILDER.comment("Spawn weight of Vengeful Pumpkins in spooky biomes. Default 25. Range 0-100. [100 is as common as Zombies, while 5 is as common as the Witch.] Set to 0 to disable.")
				.define("vengeful_pumpkin_spawn_weight_in_spooky_biomes", (double) 25);
		DREADFUL_WATCHER_SPAWN_CHANCE_SPOOKY = BUILDER.comment("Spawn weight of Dreadful Watchers in spooky biomes. Default 5. Range 0-100. [100 is as common as Zombies, while 5 is as common as the Witch.] Set to 0 to disable.")
				.define("dreadful_watcher_spawn_weight_in_spooky_biomes", (double) 5);
		GIANT_FLY_SPAWN_CHANCE_SPOOKY = BUILDER.comment("Spawn weight of Giant Flies in spooky biomes. Default 10. Range 0-100. [100 is as common as Zombies, while 5 is as common as the Witch.] Set to 0 to disable.")
				.define("giant_fly_spawn_weight_in_spooky_biomes", (double) 10);
		ENHANCED_ZOMBIE_SPAWN_CHANCE_SPOOKY = BUILDER.comment("Spawn weight of Enhanced Zombies and Husks in spooky biomes. Default 5. Range 0-100. [100 is as common as Zombies, while 5 is as common as the Witch.] Set to 0 to disable.")
				.define("enhanced_zombie_spawn_weight_in_spooky_biomes", (double) 5);
		LEVITATING_SPIRIT_SPAWN_CHANCE_SPOOKY = BUILDER.comment("Spawn weight of Evil Levitating Spirits in spooky biomes. Default 5. Range 0-100. [100 is as common as Zombies, while 5 is as common as the Witch.] Set to 0 to disable.")
				.define("evil_levitating_possessing_spirit_spawn_weight_in_spooky_biomes", (double) 5);
		DARKNESS_SPIRIT_SPAWN_CHANCE_SPOOKY = BUILDER.comment("Spawn weight of Evil Darkness Spirits in spooky biomes. Default 5. Range 0-100. [100 is as common as Zombies, while 5 is as common as the Witch.] Set to 0 to disable.")
				.define("evil_darkness_possessing_spirit_spawn_weight_in_spooky_biomes", (double) 5);
		FERAL_GOBLIN_SPAWN_CHANCE_SPOOKY = BUILDER.comment("Spawn weight of Feral Goblins in spooky biomes. Default 5. Range 0-100. [100 is as common as Zombies, while 5 is as common as the Witch.] Set to 0 to disable.")
				.define("feral_goblin_spawn_weight_in_spooky_biomes", (double) 5);
		FERAL_VAMPIRE_SPAWN_CHANCE_SPOOKY = BUILDER.comment(
				"Spawn weight of Feral Vampires in spooky biomes. Default 5. Range 0-100. [100 is as common as Zombies, while 5 is as common as the Witch.] Vampires cannot spawn too close to one another, affecting spawn rates. Set to 0 to disable.")
				.define("feral_vampire_spawn_weight_in_spooky_biomes", (double) 5);
		EVIL_CLOWN_SPAWN_CHANCE_SPOOKY = BUILDER.comment("Spawn weight of Evil Clowns in spooky biomes. Default 5. Range 0-100. [100 is as common as Zombies, while 5 is as common as the Witch.] Set to 0 to disable.")
				.define("evil_clown_spawn_weight_in_spooky_biomes[_nightmare_modeonly]", (double) 5);
		MANIAC_SPAWN_CHANCE_SPOOKY = BUILDER.comment("Spawn weight of Maniacs in spooky biomes. Default 5. Range 0-100. [100 is as common as Zombies, while 5 is as common as the Witch.] Set to 0 to disable.")
				.define("maniac_spawn_weight_in_spooky_biomes[_nightmare_modeonly]", (double) 3);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}