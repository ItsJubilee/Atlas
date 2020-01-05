package cc.funkemunky.api.listeners;

import cc.funkemunky.api.Atlas;
import cc.funkemunky.api.bungee.BungeeAPI;
import cc.funkemunky.api.tinyprotocol.api.TinyProtocolHandler;
import cc.funkemunky.api.utils.Init;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

@Init
public class ConnectionListeners implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        TinyProtocolHandler.bungeeVersionCache.remove(event.getPlayer().getUniqueId());
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if(BungeeAPI.bungee) {
            try {
                ByteArrayOutputStream bstream = new ByteArrayOutputStream();
                ObjectOutputStream ostream = new ObjectOutputStream(bstream);

                ostream.writeUTF("version");
                ostream.writeObject(event.getPlayer().getUniqueId());

                event.getPlayer().sendPluginMessage(Atlas.getInstance(), "atlasOut", bstream.toByteArray());
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}
