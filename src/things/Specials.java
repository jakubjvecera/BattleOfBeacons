package things;

import org.bukkit.*;
import org.bukkit.advancement.Advancement;
import org.bukkit.advancement.AdvancementProgress;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.block.data.BlockData;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.entity.memory.MemoryKey;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.map.MapView;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;

import java.net.InetSocketAddress;
import java.util.*;

public class Specials implements Listener {
    public ItemStack doWaterBucket() {
        var waterBucket = new ItemStack(Material.WATER_BUCKET, 1);
        return waterBucket;
    }

    public ItemStack doTridentLvl1() {
        var tridentLvl1 = new ItemStack(Material.TRIDENT, 1);
        tridentLvl1.addEnchantment(Enchantment.LOYALTY, 1);
        return tridentLvl1;
    }

    public ItemStack doTridentLvl2() {
        var tridentLvl2 = new ItemStack(Material.TRIDENT, 1);
        tridentLvl2.addEnchantment(Enchantment.LOYALTY, 8);
        return tridentLvl2;
    }

    public ItemStack doLavaBucket() {
        var lavaBucket = new ItemStack(Material.LAVA_BUCKET, 1);
        return lavaBucket;
    }

    public ItemStack doPotionOfLeaping(PlayerItemConsumeEvent playerItemConsumeEvent) {
        var potionOfLeaping = new ItemStack(Material.POTION, 1);
        var itemMeta = potionOfLeaping.getItemMeta();
        itemMeta.setDisplayName("Potion of leaping");
        potionOfLeaping.setItemMeta(itemMeta);
        playerItemConsumeEvent.getPlayer().getPotionEffect(PotionEffectType.JUMP);
        return potionOfLeaping;
    }
}