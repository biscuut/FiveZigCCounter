package codes.biscuit.fivezigccounter;

import codes.biscuit.fivezigccounter.items.CCounterItem;
import eu.the5zig.mod.The5zigAPI;
import eu.the5zig.mod.event.EventHandler;
import eu.the5zig.mod.event.LoadEvent;
import eu.the5zig.mod.modules.Category;
import eu.the5zig.mod.plugin.Plugin;

@Plugin(name = "C Counter", version = "1.0")
public class FiveZigCCounter {

    @SuppressWarnings("unused")
    @EventHandler()
    public void onLoad(LoadEvent e) {
        The5zigAPI.getAPI().registerModuleItem(this, "ccounter", CCounterItem.class, Category.GENERAL);
    }
}
