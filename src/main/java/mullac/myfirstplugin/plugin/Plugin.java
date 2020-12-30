package mullac.myfirstplugin.plugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;


public class Plugin extends JavaPlugin {
    @Override public void onEnable() {
        System.out.println("instawall!");
        getCommand("instawall").setExecutor(new InstaHouseCmd(this));
    }
}
