package tmnt150.BackPack;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable(){
        this.getServer().getLogger().info("行動背包插件開啟");
        getServer().getPluginManager().registerEvents(new BPack(),this);
    }
    @Override
    public void onDisable(){
        this.getServer().getLogger().info("行動背包插件關閉");
    }
}
