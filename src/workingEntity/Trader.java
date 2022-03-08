package workingEntity;

import com.google.common.collect.Lists;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.WanderingTrader;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import things.Armor;
import things.Specials;
import things.Swords;
import things.Tools;

public class Trader implements CommandExecutor {

    public static final String TRADER_NAME = "TRADER";
    private final Armor armor;
    private final Specials specials;
    private final Swords swords;
    private final Tools tools;

    public Trader() {
        armor = new Armor();
        specials = new Specials();
        swords = new Swords();
        tools = new Tools();
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) return false;
        var player = (Player) commandSender;
        var trader = (WanderingTrader) player.getWorld().spawnEntity(player.getLocation(), EntityType.WANDERING_TRADER);
        trader.setAI(false);
        trader.setCustomName(TRADER_NAME);
        trader.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000000000, 999999999, true));

        MerchantRecipe trainingSword = new MerchantRecipe(swords.doSwordLvl1(), 999);
        trainingSword.addIngredient(new ItemStack(Material.IRON_INGOT, 20));

        MerchantRecipe trainingHelmet = new MerchantRecipe(swords.doSwordLvl2(), 999);
        trainingHelmet.addIngredient(new ItemStack(Material.GOLD_INGOT, 10));

        MerchantRecipe trainingChestPlate = new MerchantRecipe(swords.doSwordLvl3(), 999);
        trainingChestPlate.addIngredient(new ItemStack(Material.GOLD_INGOT, 20));

        MerchantRecipe trainingLeggins = new MerchantRecipe(specials.doWaterBucket(), 999);
        trainingLeggins.addIngredient(new ItemStack(Material.GOLD_INGOT, 6));

        MerchantRecipe potion = new MerchantRecipe(specials.doPotionOfLeaping(), 999);
        trainingLeggins.addIngredient(new ItemStack(Material.GOLD_INGOT, 6));

        trader.setRecipes(Lists.newArrayList
                (trainingSword, trainingHelmet, trainingChestPlate, trainingLeggins, potion));

        return true;
    }
}