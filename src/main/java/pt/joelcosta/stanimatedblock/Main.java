package pt.joelcosta.stanimatedblock;

import org.bukkit.*;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public final class Main extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onBlockPlaced(BlockPlaceEvent e) {
        if (e.getBlockPlaced().getType() == Material.DIAMOND_BLOCK) {
            Location blockLocation = e.getBlockPlaced().getLocation();
            World world = blockLocation.getWorld();

            ArmorStand armorStand = world.spawn(blockLocation.add(0.5, 1.0, 0.5), ArmorStand.class);
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            ItemStack head = new ItemStack(Material.DIAMOND_BLOCK);
            armorStand.setHelmet(head);

            ArmorStand otherstand1 = world.spawn(armorStand.getLocation().add(0, -1, 1), ArmorStand.class);
            otherstand1.setVisible(false);
            otherstand1.setGravity(false);
            otherstand1.setHelmet(new ItemStack(Material.IRON_BLOCK));

            ArmorStand otherstand2 = world.spawn(armorStand.getLocation().add(0, -1, -1), ArmorStand.class);
            otherstand2.setVisible(false);
            otherstand2.setGravity(false);
            otherstand2.setHelmet(new ItemStack(Material.IRON_BLOCK));

            ArmorStand otherstand3 = world.spawn(armorStand.getLocation().add(1, -1, 0), ArmorStand.class);
            otherstand3.setVisible(false);
            otherstand3.setGravity(false);
            otherstand3.setHelmet(new ItemStack(Material.IRON_BLOCK));

            ArmorStand otherstand4 = world.spawn(armorStand.getLocation().add(-1, -1, 0), ArmorStand.class);
            otherstand4.setVisible(false);
            otherstand4.setGravity(false);
            otherstand4.setHelmet(new ItemStack(Material.IRON_BLOCK));

            Bukkit.getScheduler().runTaskTimer(this, () -> {
                EulerAngle currentRotation = armorStand.getHeadPose();
                double newYaw = currentRotation.getY() + Math.toRadians(5);
                armorStand.setHeadPose(new EulerAngle(currentRotation.getX(), newYaw, currentRotation.getZ()));

                EulerAngle otherRotation1 = otherstand1.getHeadPose();
                double newYawB1 = otherRotation1.getY() + Math.toRadians(5);
                otherstand1.setHeadPose(new EulerAngle(otherRotation1.getX(), newYawB1, otherRotation1.getZ()));

                EulerAngle otherRotation2 = otherstand2.getHeadPose();
                double newYawB2 = otherRotation2.getY() + Math.toRadians(5);
                otherstand2.setHeadPose(new EulerAngle(otherRotation2.getX(), newYawB2, otherRotation2.getZ()));

                EulerAngle otherRotation3 = otherstand3.getHeadPose();
                double newYawB3 = otherRotation3.getY() + Math.toRadians(5);
                otherstand3.setHeadPose(new EulerAngle(otherRotation3.getX(), newYawB3, otherRotation3.getZ()));

                EulerAngle otherRotation4 = otherstand4.getHeadPose();
                double newYawB4 = otherRotation4.getY() + Math.toRadians(5);
                otherstand4.setHeadPose(new EulerAngle(otherRotation4.getX(), newYawB4, otherRotation4.getZ()));
            }, 0L, 1L).getTaskId();
        }
    }

    @Override
    public void onDisable() {
    }
}
