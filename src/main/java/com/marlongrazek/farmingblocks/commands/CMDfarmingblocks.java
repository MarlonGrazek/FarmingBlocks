package com.marlongrazek.farmingblocks.commands;

import com.marlongrazek.farmingblocks.utils.CommandInfo;
import com.marlongrazek.farmingblocks.utils.FarmingBlock;
import com.marlongrazek.farmingblocks.utils.PluginCommand;
import org.bukkit.Location;
import org.bukkit.entity.Player;

@CommandInfo(name = "farmingblock", requiresPlayer = true)
public class CMDfarmingblocks extends PluginCommand {

    @Override
    public void execute(Player player, String[] args) {

        if (args.length == 1) {

            if (args[0].equalsIgnoreCase("create")) {

                Location facing = player.getTargetBlock(null, 5).getLocation();
                FarmingBlock farmingBlock = new FarmingBlock(facing);

                if(FarmingBlock.isExisting(farmingBlock)) {
                    player.sendMessage("§cAlready existing");
                    return;
                }

                farmingBlock.create();
                player.sendMessage("§aCreated");
            }

            else if(args[0].equalsIgnoreCase("delete")) {

                Location facing = player.getTargetBlock(null, 5).getLocation();
                FarmingBlock farmingBlock = FarmingBlock.fromLocation(facing);

                if(farmingBlock == null) {
                    player.sendMessage("§cNot a FarmingBlock");
                    return;
                }

                farmingBlock.delete();
                player.sendMessage("§aDeleted");
            }

            else if(args[0].equalsIgnoreCase("info")) {

                Location facing = player.getTargetBlock(null, 5).getLocation();
                FarmingBlock farmingBlock = FarmingBlock.fromLocation(facing);

                if(farmingBlock == null) {
                    player.sendMessage("§cNot a FarmingBlock");
                    return;
                }

                player.sendMessage("§eID: §f" + farmingBlock.getId());
            }
        }
    }
}
