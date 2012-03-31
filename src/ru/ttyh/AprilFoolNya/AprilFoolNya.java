package ru.ttyh.AprilFoolNya;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class AprilFoolNya extends JavaPlugin {

	public boolean onCommand(CommandSender sender, Command command,
			String commandLabel, String[] args) {
		Player player = sender instanceof Player ? (Player) sender : null;
		if (sender instanceof ConsoleCommandSender || player.isOp()) {
			ItemStack stack = new ItemStack(Material.WOOL, 1, (short) 6);
			for (Player target : getServer().getOnlinePlayers()) {
				make_nyan(target, stack);
			}
			player.sendMessage("Nyan completed");
			return true;
		}
		return false;
	}

	private boolean make_nyan(Player player, ItemStack item) {

		if (player.getInventory().getHelmet() != null
				&& player.getInventory().getHelmet().getAmount() != 0)
			return false;
		else {
			player.getInventory().setHelmet(item);
			player.sendMessage(ChatColor.DARK_PURPLE + "YOU HAVE BEEN NYANED");
			return true;
		}
	}

}
