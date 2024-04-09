package club.nyandere.fly;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;
import org.bukkit.command.*;

public final class Fly extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("fly").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender,Command command,String label,String args[]) {
        if (sender.hasPermission("fly:fly")) {
            if (sender instanceof Player) {
                if (args.length == 0) {
                    Player player = (Player) sender;
                    if (player.getAllowFlight()) {
                        player.setAllowFlight(false);
                        player.sendMessage("Flight disabled.");
                    } else {
                        player.setAllowFlight(true);
                        player.sendMessage("Flight enabled.");
                    }
                } else if (args.length > 0) {
                    Player target = getServer().getPlayer(args[0]);
                    if (target.getAllowFlight()) {
                        target.setAllowFlight(false);
                        sender.sendMessage(target.getName()+"Flight disabled.");
                    } else {
                        target.setAllowFlight(true);
                        sender.sendMessage(target.getName()+"Flight enabled.");
                    }
                }
            }
        } else {
            sender.sendMessage("You don't have permission to do that.");
        }
        return true;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
