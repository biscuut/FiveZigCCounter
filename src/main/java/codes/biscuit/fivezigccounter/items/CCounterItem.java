package codes.biscuit.fivezigccounter.items;

import eu.the5zig.mod.ModAPI;
import eu.the5zig.mod.The5zigAPI;
import eu.the5zig.mod.modules.AbstractModuleItem;
import eu.the5zig.mod.render.RenderLocation;
import net.minecraft.client.Minecraft;

import java.util.regex.Pattern;

public class CCounterItem extends AbstractModuleItem {

    @Override
    public void registerSettings() {
        getProperties().addSetting("bracketType", BracketType.ONE, BracketType.class);
    }

    @Override
    public void render(int x, int y, RenderLocation renderLocation, boolean dummy) {
        The5zigAPI.getAPI().getRenderHelper().drawString(getCCounterString(), x, y);
    }

    @Override
    public int getWidth(boolean b) {
        return The5zigAPI.getAPI().getRenderHelper().getStringWidth(getCCounterString());
    }

    private String getCCounterString() {
        ModAPI api = The5zigAPI.getAPI();
        String cString = Minecraft.getMinecraft().renderGlobal.getDebugInfoRenders();
        cString = cString.split(Pattern.quote("/"))[0].split(" ")[1];
        BracketType bracketType = (BracketType)getProperties().getSetting("bracketType").get();
        return api.getFormatting().getBracketFormatting()+bracketType.getBefore()+api.getFormatting().getPrefixFormatting()+"C"+
                api.getFormatting().getBracketFormatting()+bracketType.getAfter()+" "+
                api.getFormatting().getMainFormatting()+cString;

    }

    @Override
    public int getHeight(boolean b) {
        return 10;
    }

    @SuppressWarnings("unused")
    enum BracketType {
        ONE("", ">"),
        TWO("<", ">"),
        THREE("", "-"),
        FOUR("", ""),
        FIVE("[", "]"),
        SIX("(", ")"),
        SEVEN("", ":");

        private String before;
        private String after;

        BracketType(String before, String after) {
            this.before = before;
            this.after = after;
        }

        public String getBefore() {
            return before;
        }

        public String getAfter() {
            return after;
        }
    }
}
