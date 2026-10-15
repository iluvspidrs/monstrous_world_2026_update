package net.mcreator.monstrousworld.network;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.HolderLookup;
import net.minecraft.client.model.EntityModel;

import net.mcreator.monstrousworld.MonstrousWorldMod;

import java.util.function.Supplier;

import com.jcraft.jogg.Page;

@EventBusSubscriber
public class MonstrousWorldModVariables {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, MonstrousWorldMod.MODID);
	public static final Supplier<AttachmentType<PlayerVariables>> PLAYER_VARIABLES = ATTACHMENT_TYPES.register("player_variables", () -> AttachmentType.serializable(() -> new PlayerVariables()).build());
	public static ResourceLocation ArmorerVillager = null;
	public static EntityModel BatForm = null;
	public static ResourceLocation BatTexture = null;
	public static ResourceLocation ButcherVillager = null;
	public static ResourceLocation CartographerVillager = null;
	public static ResourceLocation ClericVillager = null;
	public static double CurrentTime = 0;
	public static ResourceLocation DesertVillager = null;
	public static ResourceLocation DiamondLevelVillager = null;
	public static ResourceLocation EmeraldLevelVillager = null;
	public static ResourceLocation FarmerVillager = null;
	public static ResourceLocation FishermanVillager = null;
	public static ResourceLocation FletcherVillager = null;
	public static ResourceLocation GoblinEarsPlayer = null;
	public static ResourceLocation GoblinPlayerSkinSlim = null;
	public static ResourceLocation GoblinPlayerSkinWide = null;
	public static ResourceLocation GoldLevelVillager = null;
	public static ResourceLocation IronLevelVillager = null;
	public static ResourceLocation JungleVillager = null;
	public static ResourceLocation LeatherworkerVillager = null;
	public static ResourceLocation LibrarianVillager = null;
	public static ResourceLocation MasonVillager = null;
	public static ResourceLocation NitwitVillager = null;
	public static ResourceLocation PlainsVillager = null;
	public static ResourceLocation PlayerDarkPossessedEyes = null;
	public static ResourceLocation PlayerDarkPossessedFace = null;
	public static ResourceLocation PlayerEyeOverlay = null;
	public static ResourceLocation PlayerFlyFace = null;
	public static ResourceLocation PlayerFlyOverlaySlim = null;
	public static ResourceLocation PlayerFlyOverlayWide = null;
	public static ResourceLocation PlayerFlyWings = null;
	public static ResourceLocation PlayerFlyWingsOffGround = null;
	public static ResourceLocation PlayerLevPossessedEyes = null;
	public static ResourceLocation PlayerLevPossessedFace = null;
	public static ResourceLocation PlayerSerpentBody = null;
	public static ResourceLocation PlayerSerpentOverlaySlim = null;
	public static ResourceLocation PlayerSerpentOverlayWide = null;
	public static double PlayersInCoffins = 0;
	public static ResourceLocation PlayerZombieOverlay = null;
	public static ResourceLocation SavannaVillager = null;
	public static ResourceLocation ShepherdVillager = null;
	public static ResourceLocation SnowVillager = null;
	public static ResourceLocation SpiderParalysisEyes = null;
	public static ResourceLocation StoneLevelVillager = null;
	public static ResourceLocation SwampmonsterPartsTexture = null;
	public static ResourceLocation SwampmonsterPlayerSkinSlim = null;
	public static ResourceLocation SwampmonsterPlayerSkinWide = null;
	public static ResourceLocation SwampVillager = null;
	public static ResourceLocation TaigaVillager = null;
	public static double TimeUntilNight = 0;
	public static ResourceLocation ToolsmithVillager = null;
	public static ResourceLocation VampireEvoker = null;
	public static ResourceLocation VampireEyesGoon = null;
	public static ResourceLocation VampireEyesHuman = null;
	public static ResourceLocation VampireEyesVillager = null;
	public static ResourceLocation VampireIllusioner = null;
	public static ResourceLocation VampirePillager = null;
	public static ResourceLocation VampireRobe = null;
	public static ResourceLocation VampireVindicator = null;
	public static ResourceLocation VampireWanderingTrader = null;
	public static ResourceLocation VampireWitch = null;
	public static ResourceLocation WeaponsmithVillager = null;
	public static EntityModel WerewolfForm = null;
	public static ResourceLocation WerewolfTexture = null;
	public static EntityModel WebbedVictim1 = null;
	public static EntityModel WebbedVictim2 = null;
	public static ResourceLocation WrappedVictim = null;
	public static ResourceLocation UndeadGlowEyes = null;
	public static ResourceLocation PlayerZombieOverlaySlim = null;
	public static ResourceLocation PlayerTrollLayerWide = null;
	public static ResourceLocation PlayerTrollLayerSlim = null;
	public static EntityModel PlayerTrollFace = null;
	public static EntityModel PlayerHungerMode = null;
	public static ResourceLocation hunger_mode = null;
	public static ResourceLocation acid_overlay = null;
	public static ResourceLocation popcorn_overlay = null;
	public static ResourceLocation PlayerClownSkin = null;
	public static ResourceLocation PlayerDemonSkinWide = null;
	public static ResourceLocation PlayerDemonSkinSlim = null;
	public static ResourceLocation PlayerDemonParts = null;
	public static ResourceLocation PlayerClownHair = null;
	public static ResourceLocation PlayerBalloonForm = null;
	public static EntityModel PlayerDemonOffGround = null;
	public static EntityModel BalloonForm = null;
	public static EntityModel DummyBow = null;
	public static ResourceLocation DummyBowTexture = null;
	public static EntityModel ClownNose = null;
	public static ResourceLocation ClownNoseTexture = null;
	public static ResourceLocation feral_swampmonster_player_wide = null;
	public static ResourceLocation feral_swampmonster_player_slim = null;
	public static ResourceLocation player_moss_overlay = null;

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		MonstrousWorldMod.addNetworkMessage(SavedDataSyncMessage.TYPE, SavedDataSyncMessage.STREAM_CODEC, SavedDataSyncMessage::handleData);
		MonstrousWorldMod.addNetworkMessage(PlayerVariablesSyncMessage.TYPE, PlayerVariablesSyncMessage.STREAM_CODEC, PlayerVariablesSyncMessage::handleData);
	}

	@SubscribeEvent
	public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
		if (event.getEntity() instanceof ServerPlayer player) {
			for (Entity entityiterator : player.level().players())
				if (entityiterator != player && entityiterator instanceof ServerPlayer playeriterator)
					PacketDistributor.sendToPlayer(player, new PlayerVariablesSyncMessage(playeriterator.getData(PLAYER_VARIABLES), playeriterator.getId()));
			PacketDistributor.sendToPlayersInDimension((ServerLevel) player.level(), new PlayerVariablesSyncMessage(player.getData(PLAYER_VARIABLES), player.getId()));
		}
	}

	@SubscribeEvent
	public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
		if (event.getEntity() instanceof ServerPlayer player) {
			for (Entity entityiterator : player.level().players())
				if (entityiterator != player && entityiterator instanceof ServerPlayer playeriterator)
					PacketDistributor.sendToPlayer(player, new PlayerVariablesSyncMessage(playeriterator.getData(PLAYER_VARIABLES), playeriterator.getId()));
			PacketDistributor.sendToPlayersInDimension((ServerLevel) player.level(), new PlayerVariablesSyncMessage(player.getData(PLAYER_VARIABLES), player.getId()));
		}
	}

	@SubscribeEvent
	public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (event.getEntity() instanceof ServerPlayer player) {
			for (Entity entityiterator : player.level().players())
				if (entityiterator != player && entityiterator instanceof ServerPlayer playeriterator)
					PacketDistributor.sendToPlayer(player, new PlayerVariablesSyncMessage(playeriterator.getData(PLAYER_VARIABLES), playeriterator.getId()));
			PacketDistributor.sendToPlayersInDimension((ServerLevel) player.level(), new PlayerVariablesSyncMessage(player.getData(PLAYER_VARIABLES), player.getId()));
		}
	}

	@SubscribeEvent
	public static void onPlayerTickUpdateSyncPlayerVariables(PlayerTickEvent.Post event) {
		if (event.getEntity() instanceof ServerPlayer player && player.getData(PLAYER_VARIABLES)._syncDirty) {
			PacketDistributor.sendToPlayersInDimension((ServerLevel) player.level(), new PlayerVariablesSyncMessage(player.getData(PLAYER_VARIABLES), player.getId()));
			player.getData(PLAYER_VARIABLES)._syncDirty = false;
		}
	}

	@SubscribeEvent
	public static void clonePlayer(PlayerEvent.Clone event) {
		PlayerVariables original = event.getOriginal().getData(PLAYER_VARIABLES);
		PlayerVariables clone = new PlayerVariables();
		clone.Assignment1 = original.Assignment1;
		clone.Assignment2 = original.Assignment2;
		clone.Assignment3 = original.Assignment3;
		clone.AssistantsAreOut = original.AssistantsAreOut;
		clone.BeastForm = original.BeastForm;
		clone.BloodBar = original.BloodBar;
		clone.Bloodlevel = original.Bloodlevel;
		clone.DarknessInfectable = original.DarknessInfectable;
		clone.DarknessTimer = original.DarknessTimer;
		clone.Disguised = original.Disguised;
		clone.FactionLevel = original.FactionLevel;
		clone.FeralLevel = original.FeralLevel;
		clone.HasArtifact = original.HasArtifact;
		clone.hasPamphlet = original.hasPamphlet;
		clone.HuntersGuild = original.HuntersGuild;
		clone.MonsterClass = original.MonsterClass;
		clone.MonsterInfectable = original.MonsterInfectable;
		clone.MonsterType = original.MonsterType;
		clone.Page = original.Page;
		clone.PlayerFace = original.PlayerFace;
		clone.Possession = original.Possession;
		clone.RecipeGuideShow = original.RecipeGuideShow;
		clone.Reputation = original.Reputation;
		clone.TerritoryMarkers = original.TerritoryMarkers;
		clone.TradeButton = original.TradeButton;
		clone.TradeHeading = original.TradeHeading;
		clone.TradeType = original.TradeType;
		clone.TransformCooldown = original.TransformCooldown;
		clone.VampireInfection = original.VampireInfection;
		clone.VictimBloodLevel = original.VictimBloodLevel;
		clone.ZombieInfection = original.ZombieInfection;
		clone.LoreBinderPage = original.LoreBinderPage;
		clone.HideLoreBinder = original.HideLoreBinder;
		clone.Nightmare_Mode = original.Nightmare_Mode;
		clone.EvilFaction = original.EvilFaction;
		clone.WebbedLevel = original.WebbedLevel;
		clone.Reputation_Static = original.Reputation_Static;
		clone.Dark_Message_Timer = original.Dark_Message_Timer;
		clone.Magic_Type = original.Magic_Type;
		clone.Cooldown = original.Cooldown;
		clone.SetSpawn = original.SetSpawn;
		clone.Zombify = original.Zombify;
		clone.No_Defense = original.No_Defense;
		clone.More_Nightmares = original.More_Nightmares;
		clone.Slower_Movement = original.Slower_Movement;
		clone.MessageTimer = original.MessageTimer;
		clone.Chilled = original.Chilled;
		clone.WerewolfInfectionTimer = original.WerewolfInfectionTimer;
		clone.LunarPullTimer = original.LunarPullTimer;
		clone.WerewolfEffect = original.WerewolfEffect;
		clone.Balloon = original.Balloon;
		clone.MurkanusMarth = original.MurkanusMarth;
		if (!event.isWasDeath()) {
			clone.Trident_Countdown = original.Trident_Countdown;
			clone.Blackout_Timer = original.Blackout_Timer;
			clone.Raid_Fighters = original.Raid_Fighters;
		}
		event.getEntity().setData(PLAYER_VARIABLES, clone);
	}

	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		if (event.getEntity() instanceof ServerPlayer player) {
			SavedData mapdata = MapVariables.get(event.getEntity().level());
			SavedData worlddata = WorldVariables.get(event.getEntity().level());
			if (mapdata != null)
				PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(0, mapdata));
			if (worlddata != null)
				PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(1, worlddata));
		}
	}

	@SubscribeEvent
	public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (event.getEntity() instanceof ServerPlayer player) {
			SavedData worlddata = WorldVariables.get(event.getEntity().level());
			if (worlddata != null)
				PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(1, worlddata));
		}
	}

	@SubscribeEvent
	public static void onWorldTick(LevelTickEvent.Post event) {
		if (event.getLevel() instanceof ServerLevel level) {
			WorldVariables worldVariables = WorldVariables.get(level);
			if (worldVariables._syncDirty) {
				PacketDistributor.sendToPlayersInDimension(level, new SavedDataSyncMessage(1, worldVariables));
				worldVariables._syncDirty = false;
			}
			MapVariables mapVariables = MapVariables.get(level);
			if (mapVariables._syncDirty) {
				PacketDistributor.sendToAllPlayers(new SavedDataSyncMessage(0, mapVariables));
				mapVariables._syncDirty = false;
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "monstrous_world_worldvars";
		boolean _syncDirty = false;

		public static WorldVariables load(CompoundTag tag, HolderLookup.Provider lookupProvider) {
			WorldVariables data = new WorldVariables();
			data.read(tag, lookupProvider);
			return data;
		}

		public void read(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
		}

		@Override
		public CompoundTag save(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			return nbt;
		}

		public void markSyncDirty() {
			this.setDirty();
			this._syncDirty = true;
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(new SavedData.Factory<>(WorldVariables::new, WorldVariables::load), DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "monstrous_world_mapvars";
		boolean _syncDirty = false;
		public boolean NightmareMode = false;
		public boolean PlayerPossessed = false;
		public double TeamResetTimer = 0;
		public double Nightmare_Mode_World = 0;

		public static MapVariables load(CompoundTag tag, HolderLookup.Provider lookupProvider) {
			MapVariables data = new MapVariables();
			data.read(tag, lookupProvider);
			return data;
		}

		public void read(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			NightmareMode = nbt.getBoolean("NightmareMode");
			PlayerPossessed = nbt.getBoolean("PlayerPossessed");
			TeamResetTimer = nbt.getDouble("TeamResetTimer");
			Nightmare_Mode_World = nbt.getDouble("Nightmare_Mode_World");
		}

		@Override
		public CompoundTag save(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			nbt.putBoolean("NightmareMode", NightmareMode);
			nbt.putBoolean("PlayerPossessed", PlayerPossessed);
			nbt.putDouble("TeamResetTimer", TeamResetTimer);
			nbt.putDouble("Nightmare_Mode_World", Nightmare_Mode_World);
			return nbt;
		}

		public void markSyncDirty() {
			this.setDirty();
			_syncDirty = true;
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(new SavedData.Factory<>(MapVariables::new, MapVariables::load), DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public record SavedDataSyncMessage(int dataType, SavedData data) implements CustomPacketPayload {
		public static final Type<SavedDataSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "saved_data_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, SavedDataSyncMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, SavedDataSyncMessage message) -> {
			buffer.writeInt(message.dataType);
			if (message.data != null)
				buffer.writeNbt(message.data.save(new CompoundTag(), buffer.registryAccess()));
		}, (RegistryFriendlyByteBuf buffer) -> {
			int dataType = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			SavedData data = null;
			if (nbt != null) {
				data = dataType == 0 ? new MapVariables() : new WorldVariables();
				if (data instanceof MapVariables mapVariables)
					mapVariables.read(nbt, buffer.registryAccess());
				else if (data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt, buffer.registryAccess());
			}
			return new SavedDataSyncMessage(dataType, data);
		});

		@Override
		public Type<SavedDataSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final SavedDataSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> {
					if (message.dataType == 0)
						MapVariables.clientSide.read(message.data.save(new CompoundTag(), context.player().registryAccess()), context.player().registryAccess());
					else
						WorldVariables.clientSide.read(message.data.save(new CompoundTag(), context.player().registryAccess()), context.player().registryAccess());
				}).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}

	public static class PlayerVariables implements INBTSerializable<CompoundTag> {
		boolean _syncDirty = false;
		public String Assignment1 = "\"\"";
		public String Assignment2 = "\"\"";
		public String Assignment3 = "\"\"";
		public boolean AssistantsAreOut = false;
		public boolean BeastForm = false;
		public double BloodBar = -1.0;
		public double Bloodlevel = 12.0;
		public boolean DarknessInfectable = true;
		public double DarknessTimer = 0;
		public boolean Disguised = false;
		public double FactionLevel = 0;
		public double FeralLevel = 0;
		public boolean HasArtifact = false;
		public boolean hasPamphlet = false;
		public boolean HuntersGuild = false;
		public double MonsterClass = 0;
		public boolean MonsterInfectable = true;
		public double MonsterType = 0;
		public String Page = "\"\"";
		public double PlayerFace = 0;
		public double Possession = 0;
		public String RecipeGuideShow = "\"\"";
		public double Reputation = 0;
		public double TerritoryMarkers = 5.0;
		public String TradeButton = "\"\"";
		public String TradeHeading = "\"\"";
		public String TradeType = "\"\"";
		public double TransformCooldown = 0;
		public double VampireInfection = 0;
		public double VictimBloodLevel = 0;
		public double ZombieInfection = 0;
		public String LoreBinderPage = "\"\"";
		public boolean HideLoreBinder = false;
		public double Nightmare_Mode = 0;
		public double EvilFaction = 0;
		public double WebbedLevel = 0;
		public boolean Reputation_Static = false;
		public double Trident_Countdown = 0;
		public double Dark_Message_Timer = 0;
		public double Blackout_Timer = 0;
		public double Raid_Fighters = 0;
		public double Magic_Type = 0;
		public double Cooldown = 0;
		public boolean SetSpawn = false;
		public double Zombify = 0;
		public double No_Defense = 0;
		public double More_Nightmares = 0;
		public double Slower_Movement = 0;
		public double MessageTimer = 0;
		public double Chilled = 0;
		public double WerewolfInfectionTimer = 0;
		public double LunarPullTimer = 0;
		public double WerewolfEffect = 0;
		public boolean Balloon = false;
		public double MurkanusMarth = 0;

		@Override
		public CompoundTag serializeNBT(HolderLookup.Provider lookupProvider) {
			CompoundTag nbt = new CompoundTag();
			nbt.putString("Assignment1", Assignment1);
			nbt.putString("Assignment2", Assignment2);
			nbt.putString("Assignment3", Assignment3);
			nbt.putBoolean("AssistantsAreOut", AssistantsAreOut);
			nbt.putBoolean("BeastForm", BeastForm);
			nbt.putDouble("BloodBar", BloodBar);
			nbt.putDouble("Bloodlevel", Bloodlevel);
			nbt.putBoolean("DarknessInfectable", DarknessInfectable);
			nbt.putDouble("DarknessTimer", DarknessTimer);
			nbt.putBoolean("Disguised", Disguised);
			nbt.putDouble("FactionLevel", FactionLevel);
			nbt.putDouble("FeralLevel", FeralLevel);
			nbt.putBoolean("HasArtifact", HasArtifact);
			nbt.putBoolean("hasPamphlet", hasPamphlet);
			nbt.putBoolean("HuntersGuild", HuntersGuild);
			nbt.putDouble("MonsterClass", MonsterClass);
			nbt.putBoolean("MonsterInfectable", MonsterInfectable);
			nbt.putDouble("MonsterType", MonsterType);
			nbt.putString("Page", Page);
			nbt.putDouble("PlayerFace", PlayerFace);
			nbt.putDouble("Possession", Possession);
			nbt.putString("RecipeGuideShow", RecipeGuideShow);
			nbt.putDouble("Reputation", Reputation);
			nbt.putDouble("TerritoryMarkers", TerritoryMarkers);
			nbt.putString("TradeButton", TradeButton);
			nbt.putString("TradeHeading", TradeHeading);
			nbt.putString("TradeType", TradeType);
			nbt.putDouble("TransformCooldown", TransformCooldown);
			nbt.putDouble("VampireInfection", VampireInfection);
			nbt.putDouble("VictimBloodLevel", VictimBloodLevel);
			nbt.putDouble("ZombieInfection", ZombieInfection);
			nbt.putString("LoreBinderPage", LoreBinderPage);
			nbt.putBoolean("HideLoreBinder", HideLoreBinder);
			nbt.putDouble("Nightmare_Mode", Nightmare_Mode);
			nbt.putDouble("EvilFaction", EvilFaction);
			nbt.putDouble("WebbedLevel", WebbedLevel);
			nbt.putBoolean("Reputation_Static", Reputation_Static);
			nbt.putDouble("Trident_Countdown", Trident_Countdown);
			nbt.putDouble("Dark_Message_Timer", Dark_Message_Timer);
			nbt.putDouble("Blackout_Timer", Blackout_Timer);
			nbt.putDouble("Raid_Fighters", Raid_Fighters);
			nbt.putDouble("Magic_Type", Magic_Type);
			nbt.putDouble("Cooldown", Cooldown);
			nbt.putBoolean("SetSpawn", SetSpawn);
			nbt.putDouble("Zombify", Zombify);
			nbt.putDouble("No_Defense", No_Defense);
			nbt.putDouble("More_Nightmares", More_Nightmares);
			nbt.putDouble("Slower_Movement", Slower_Movement);
			nbt.putDouble("MessageTimer", MessageTimer);
			nbt.putDouble("Chilled", Chilled);
			nbt.putDouble("WerewolfInfectionTimer", WerewolfInfectionTimer);
			nbt.putDouble("LunarPullTimer", LunarPullTimer);
			nbt.putDouble("WerewolfEffect", WerewolfEffect);
			nbt.putBoolean("Balloon", Balloon);
			nbt.putDouble("MurkanusMarth", MurkanusMarth);
			return nbt;
		}

		@Override
		public void deserializeNBT(HolderLookup.Provider lookupProvider, CompoundTag nbt) {
			Assignment1 = nbt.getString("Assignment1");
			Assignment2 = nbt.getString("Assignment2");
			Assignment3 = nbt.getString("Assignment3");
			AssistantsAreOut = nbt.getBoolean("AssistantsAreOut");
			BeastForm = nbt.getBoolean("BeastForm");
			BloodBar = nbt.getDouble("BloodBar");
			Bloodlevel = nbt.getDouble("Bloodlevel");
			DarknessInfectable = nbt.getBoolean("DarknessInfectable");
			DarknessTimer = nbt.getDouble("DarknessTimer");
			Disguised = nbt.getBoolean("Disguised");
			FactionLevel = nbt.getDouble("FactionLevel");
			FeralLevel = nbt.getDouble("FeralLevel");
			HasArtifact = nbt.getBoolean("HasArtifact");
			hasPamphlet = nbt.getBoolean("hasPamphlet");
			HuntersGuild = nbt.getBoolean("HuntersGuild");
			MonsterClass = nbt.getDouble("MonsterClass");
			MonsterInfectable = nbt.getBoolean("MonsterInfectable");
			MonsterType = nbt.getDouble("MonsterType");
			Page = nbt.getString("Page");
			PlayerFace = nbt.getDouble("PlayerFace");
			Possession = nbt.getDouble("Possession");
			RecipeGuideShow = nbt.getString("RecipeGuideShow");
			Reputation = nbt.getDouble("Reputation");
			TerritoryMarkers = nbt.getDouble("TerritoryMarkers");
			TradeButton = nbt.getString("TradeButton");
			TradeHeading = nbt.getString("TradeHeading");
			TradeType = nbt.getString("TradeType");
			TransformCooldown = nbt.getDouble("TransformCooldown");
			VampireInfection = nbt.getDouble("VampireInfection");
			VictimBloodLevel = nbt.getDouble("VictimBloodLevel");
			ZombieInfection = nbt.getDouble("ZombieInfection");
			LoreBinderPage = nbt.getString("LoreBinderPage");
			HideLoreBinder = nbt.getBoolean("HideLoreBinder");
			Nightmare_Mode = nbt.getDouble("Nightmare_Mode");
			EvilFaction = nbt.getDouble("EvilFaction");
			WebbedLevel = nbt.getDouble("WebbedLevel");
			Reputation_Static = nbt.getBoolean("Reputation_Static");
			Trident_Countdown = nbt.getDouble("Trident_Countdown");
			Dark_Message_Timer = nbt.getDouble("Dark_Message_Timer");
			Blackout_Timer = nbt.getDouble("Blackout_Timer");
			Raid_Fighters = nbt.getDouble("Raid_Fighters");
			Magic_Type = nbt.getDouble("Magic_Type");
			Cooldown = nbt.getDouble("Cooldown");
			SetSpawn = nbt.getBoolean("SetSpawn");
			Zombify = nbt.getDouble("Zombify");
			No_Defense = nbt.getDouble("No_Defense");
			More_Nightmares = nbt.getDouble("More_Nightmares");
			Slower_Movement = nbt.getDouble("Slower_Movement");
			MessageTimer = nbt.getDouble("MessageTimer");
			Chilled = nbt.getDouble("Chilled");
			WerewolfInfectionTimer = nbt.getDouble("WerewolfInfectionTimer");
			LunarPullTimer = nbt.getDouble("LunarPullTimer");
			WerewolfEffect = nbt.getDouble("WerewolfEffect");
			Balloon = nbt.getBoolean("Balloon");
			MurkanusMarth = nbt.getDouble("MurkanusMarth");
		}

		public void markSyncDirty() {
			_syncDirty = true;
		}
	}

	public record PlayerVariablesSyncMessage(PlayerVariables data, int player) implements CustomPacketPayload {
		public static final Type<PlayerVariablesSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "player_variables_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, PlayerVariablesSyncMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, PlayerVariablesSyncMessage message) -> {
			buffer.writeInt(message.player());
			buffer.writeNbt(message.data().serializeNBT(buffer.registryAccess()));
		}, (RegistryFriendlyByteBuf buffer) -> {
			PlayerVariablesSyncMessage message = new PlayerVariablesSyncMessage(new PlayerVariables(), buffer.readInt());
			message.data.deserializeNBT(buffer.registryAccess(), buffer.readNbt());
			return message;
		});

		@Override
		public Type<PlayerVariablesSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final PlayerVariablesSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> {
					Entity player = context.player().level().getEntity(message.player);
					if (player == null)
						return;
					player.getData(PLAYER_VARIABLES).deserializeNBT(context.player().registryAccess(), message.data.serializeNBT(context.player().registryAccess()));
				}).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}
}