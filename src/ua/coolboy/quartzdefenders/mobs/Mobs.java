package ua.coolboy.quartzdefenders.mobs;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.inventory.ItemStack;
import ua.endertainment.quartzdefenders.utils.ItemUtil;
import ua.endertainment.quartzdefenders.utils.Language;

public abstract class Mobs {

    public static void middDef(WitherSkeleton skeleton) {
        skeleton.setCustomName(Language.getString("mobs.diamond_defender"));
        skeleton.setCustomNameVisible(true);
        skeleton.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(50);
        skeleton.setHealth(50);
        skeleton.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).setBaseValue(3);
        skeleton.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(0.5);
        skeleton.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(2);
        skeleton.getEquipment().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        skeleton.getEquipment().setItemInMainHand(new ItemStack(Material.IRON_SWORD));
        skeleton.getEquipment().setHelmetDropChance(0F);
    }

    public static void soulDef(Skeleton s) {
        ItemStack coin = new ItemStack(Material.DOUBLE_PLANT, 4);
        ItemUtil.setMeta(coin, Language.getString("mobs.alchemists_coin.name"), Arrays.asList(Language.getString("mobs.alchemists_coin.lore")));
        s.setCustomName(Language.getString("mobs.alchemist_soul"));
        s.setCustomNameVisible(true);
        s.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(35);
        s.setHealth(35);
        s.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).setBaseValue(3);

        s.getEquipment().setHelmet(new ItemStack(Material.GLASS));
        s.getEquipment().setHelmetDropChance(0.0F);
        s.getEquipment().setChestplate(new ItemStack(new ItemStack(Material.ELYTRA)));
        s.getEquipment().setChestplateDropChance(0F);
        s.getEquipment().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        s.getEquipment().setLeggingsDropChance(0.3F);
        s.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
        s.getEquipment().setBootsDropChance(0.2F);
        s.getEquipment().setItemInMainHand(new ItemStack(Material.DIAMOND_SWORD));
        s.getEquipment().setItemInMainHandDropChance(0.2F);
        s.getEquipment().setItemInOffHand(coin);
        s.getEquipment().setItemInOffHandDropChance(0.5F);
    }

    public static Integer randomInRadius(int rad) {
        int i;
        Random random = new Random();
        i = random.nextInt(rad * 2);

        return rad - i;
    }

    public static Integer countMobs(Collection<Entity> col, EntityType type) {
        int count = 0;
        for (Entity e : col) {
            if (e.getType().equals(type)) {
                if (e.getType().equals(EntityType.PLAYER)
                        && ((Player) e).getGameMode().equals(GameMode.SPECTATOR)) {
                    continue;
                }
                count++;
            }
        }
        return count;
    }

    public static boolean canSpawn(Location loc) {
        Block block = loc.getWorld().getHighestBlockAt(loc);
        return !(block.getY() == 0
                || block.getType() == Material.WEB
                || block.getRelative(BlockFace.DOWN).getType().equals(Material.MAGMA));
    }
}