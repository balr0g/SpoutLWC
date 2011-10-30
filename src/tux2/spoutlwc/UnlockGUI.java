package tux2.spoutlwc;

import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.gui.Color;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericItemWidget;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.GenericTextField;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;

import com.griefcraft.model.Protection;

public class UnlockGUI {
	
	GenericTextField password = new GenericTextField();
	Protection protection;
	Block target;

	public UnlockGUI(SpoutLWC plugin, Protection protection, SpoutPlayer splayer) {
		this.protection = protection;
		this.target = protection.getBlock();
		
		//Let's create a new popup
		GenericPopup ppane = new GenericPopup();
		//Add the label at the top of the window
		GenericLabel label = new GenericLabel("LWC Password Unlock");
		label.setTextColor(new Color(0, 200, 0)); //This makes the label green.
		label.setAlign(WidgetAnchor.TOP_CENTER).setAnchor(WidgetAnchor.TOP_CENTER); //This puts the label at top center and align the text correctly.
		label.shiftYPos(5);
		splayer.getClipboardText();
		ppane.attachWidget(plugin, label);
		
		int y = 50, height = 15;
		int x = 170;
		GenericItemWidget chesticon = new GenericItemWidget(new ItemStack(LWCScreenListener.getDisplayItem(target.getType())));
		chesticon.setX(x + 2 * height).setY(y);
		chesticon.setHeight(height * 2).setWidth(height * 2)
				.setDepth(height * 2);
		chesticon.setTooltip("Unlock that " + target.getType().toString().replace('_', ' ') + "!");
		ppane.attachWidget(plugin, chesticon);
		GenericLabel lpassword = new GenericLabel("Enter Password:");
		lpassword.setAlign(WidgetAnchor.TOP_CENTER).setAnchor(WidgetAnchor.CENTER_CENTER);
		ppane.attachWidget(plugin, lpassword);
		password.setWidth(80).setHeight(15);
		password.setAnchor(WidgetAnchor.CENTER_CENTER);
		password.shiftYPos(20);
		password.shiftXPos(-40);
		ppane.attachWidget(plugin, password);
		GenericButton unlockbutton = new GenericButton("Unlock");
		unlockbutton.setWidth(80).setHeight(20);
		unlockbutton.setAnchor(WidgetAnchor.CENTER_CENTER).shiftYPos(40).shiftXPos(-40);
		unlockbutton.setColor(new Color(0, 150, 0));
		GenericButton cancelbutton = new GenericButton("Cancel");
		cancelbutton.setWidth(80).setHeight(20);
		cancelbutton.setAnchor(WidgetAnchor.CENTER_CENTER).shiftYPos(65).shiftXPos(-40);
		ppane.attachWidget(plugin, unlockbutton);
		ppane.attachWidget(plugin, cancelbutton);
		splayer.getMainScreen().attachPopupScreen(ppane);
	}

}