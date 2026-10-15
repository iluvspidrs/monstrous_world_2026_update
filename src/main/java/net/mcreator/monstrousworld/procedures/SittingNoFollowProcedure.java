package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class SittingNoFollowProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("monstrous_world:tamed_creature"))) && !(entity.getPersistentData().getBoolean("Sitting") == true);
	}
}