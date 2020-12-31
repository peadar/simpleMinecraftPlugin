package mullac.myfirstplugin.plugin;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class InstaHouseCmd implements CommandExecutor {
    private final Plugin plugin;
    InstaHouseCmd(Plugin plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        plugin.getLogger().info("instawall time");
        if (!(sender instanceof Player)) {
            plugin.getLogger().info("sender is a " + sender.getClass());
            return false;
        }
        final int radius = 20;
        final int height = 10;
        double steps = radius * Math.PI * 2;
        double degrees = 360.0 / steps;
        Player p = (Player)sender;
        Location l = p.getLocation();
        l.setPitch(0);
        for (int i = 0; i < height; ++i) {
            for (float d = 0; d < 180.0; d += degrees) {
                l.setYaw(d);
                Vector dir = l.getDirection();
                dir.multiply(radius);
                Location wall = l.clone();
                wall.add(dir);
                Block b = wall.getBlock();
                b.setType(Material.STONE);
            }
            l.setY(l.getY() + 1);
        }
        return true;
    }
}