/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.monstrousworld.init;

import org.lwjgl.glfw.GLFW;

import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.monstrousworld.network.*;

@EventBusSubscriber(Dist.CLIENT)
public class MonstrousWorldModKeyMappings {
	public static final KeyMapping SLEEP_IN_COFFIN = new KeyMapping("key.monstrous_world.sleep_in_coffin", GLFW.GLFW_KEY_C, "key.category.monstrous_world.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new SleepInCoffinMessage(0, 0));
				SleepInCoffinMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping CREATURE_FORM = new KeyMapping("key.monstrous_world.creature_form", GLFW.GLFW_KEY_B, "key.category.monstrous_world.monstrous_world") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new CreatureFormMessage(0, 0));
				CreatureFormMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping THROW_SPELL = new KeyMapping("key.monstrous_world.throw_spell", GLFW.GLFW_KEY_Y, "key.category.monstrous_world.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new ThrowSpellMessage(0, 0));
				ThrowSpellMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping PRIMARY_SPELL = new KeyMapping("key.monstrous_world.primary_spell", GLFW.GLFW_KEY_G, "key.category.monstrous_world.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new PrimarySpellMessage(0, 0));
				PrimarySpellMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping SECONDARY_SPELL = new KeyMapping("key.monstrous_world.secondary_spell", GLFW.GLFW_KEY_Y, "key.category.monstrous_world.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new SecondarySpellMessage(0, 0));
				SecondarySpellMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping FEED = new KeyMapping("key.monstrous_world.feed", GLFW.GLFW_KEY_V, "key.category.monstrous_world.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new FeedMessage(0, 0));
				FeedMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping FLY_UPWARD = new KeyMapping("key.monstrous_world.fly_upward", GLFW.GLFW_KEY_SPACE, "key.category.monstrous_world.movement") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new FlyUpwardMessage(0, 0));
				FlyUpwardMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping DESCEND = new KeyMapping("key.monstrous_world.descend", GLFW.GLFW_KEY_D, "key.category.monstrous_world.movement") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new DescendMessage(0, 0));
				DescendMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping LEVITATE = new KeyMapping("key.monstrous_world.levitate", GLFW.GLFW_KEY_C, "key.category.monstrous_world.movement") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new LevitateMessage(0, 0));
				LevitateMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping GLIDE_WITH_WINGS = new KeyMapping("key.monstrous_world.glide_with_wings", GLFW.GLFW_KEY_W, "key.category.monstrous_world.movement") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new GlideWithWingsMessage(0, 0));
				GlideWithWingsMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				GLIDE_WITH_WINGS_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - GLIDE_WITH_WINGS_LASTPRESS);
				PacketDistributor.sendToServer(new GlideWithWingsMessage(1, dt));
				GlideWithWingsMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	private static long GLIDE_WITH_WINGS_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(SLEEP_IN_COFFIN);
		event.register(CREATURE_FORM);
		event.register(THROW_SPELL);
		event.register(PRIMARY_SPELL);
		event.register(SECONDARY_SPELL);
		event.register(FEED);
		event.register(FLY_UPWARD);
		event.register(DESCEND);
		event.register(LEVITATE);
		event.register(GLIDE_WITH_WINGS);
	}

	@EventBusSubscriber(Dist.CLIENT)
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(ClientTickEvent.Post event) {
			if (Minecraft.getInstance().screen == null) {
				SLEEP_IN_COFFIN.consumeClick();
				CREATURE_FORM.consumeClick();
				THROW_SPELL.consumeClick();
				PRIMARY_SPELL.consumeClick();
				SECONDARY_SPELL.consumeClick();
				FEED.consumeClick();
				FLY_UPWARD.consumeClick();
				DESCEND.consumeClick();
				LEVITATE.consumeClick();
				GLIDE_WITH_WINGS.consumeClick();
			}
		}
	}
}