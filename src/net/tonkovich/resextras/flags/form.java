package net.tonkovich.resextras.flags;

import net.t00thpick1.residence.api.ResidenceAPI;
import net.t00thpick1.residence.api.areas.PermissionsArea;
import net.tonkovich.resextras.FlagManagerExtras;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFormEvent;

public class form implements Listener {
	@EventHandler(priority = EventPriority.LOW)
	public void Form(BlockFormEvent event) {
	    if(event.isCancelled())
	        return;
	    PermissionsArea area = ResidenceAPI.getPermissionsAreaByLocation(event.getBlock().getLocation());
	    if(area!=null) {
	        if(!area.allowAction(FlagManagerExtras.ICE_FORMING)) {
	            event.setCancelled(true);
	        }
	    }
	}
}
