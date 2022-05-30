package keystrokesmod.client.module.modules.client;

import keystrokesmod.client.main.Raven;
import keystrokesmod.client.module.Module;
import keystrokesmod.client.module.DescriptionSetting;
import keystrokesmod.client.module.SliderSetting;
import keystrokesmod.client.module.TickSetting;
import keystrokesmod.client.utils.Utils;

public class GuiModule extends Module {
   public static final int bind = 54;
   public static SliderSetting guiTheme, backgroundOpacity;
   public static DescriptionSetting guiThemeDesc;
   public static TickSetting categoryBackground;
   public static TickSetting toggleNotification;
   public static TickSetting rainbowNotification;

   public GuiModule() {
      super("Gui", Module.category.client, 54);
      this.registerSetting(guiTheme = new SliderSetting("Theme", 3.0D, 1.0D, 4.0D, 1.0D));
      this.registerSetting(guiThemeDesc = new DescriptionSetting(Utils.md + "b+"));
      this.registerSetting(backgroundOpacity = new SliderSetting("Background Opacity %", 43.0D, 0.0D, 100.0D, 1.0D));
      this.registerSetting(categoryBackground = new TickSetting("Category Background", true));
      this.registerSetting(toggleNotification = new TickSetting("Toggle Notifications", true));
      this.registerSetting(rainbowNotification = new TickSetting("Rainbow Notifications", true));
   }

   public void onEnable() {
      if (Utils.Player.isPlayerInGame() && mc.currentScreen != Raven.clickGui) {
         mc.displayGuiScreen(Raven.clickGui);
            Raven.clickGui.initMain();
      }

      this.disable();
   }

   public void guiUpdate() {
      switch((int) guiTheme.getInput()) {
      case 1:
         guiThemeDesc.setDesc(Utils.md + "b" + 1);
         break;
      case 2:
         guiThemeDesc.setDesc(Utils.md + "b" + 2);
         break;
      case 3:
         guiThemeDesc.setDesc(Utils.md + "b" + 3);
         break;

      case 4:
         guiThemeDesc.setDesc(Utils.md + "b+");
         break;
      }
   }
}