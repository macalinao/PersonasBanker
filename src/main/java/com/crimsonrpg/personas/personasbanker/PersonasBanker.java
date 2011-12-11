/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crimsonrpg.personas.personasbanker;

import com.crimsonrpg.personas.personasapi.Personas;
import com.crimsonrpg.personas.personasapi.event.npc.NPCRightClickEvent;
import com.crimsonrpg.personas.personasapi.npc.NPC;
import com.crimsonrpg.personas.personasapi.persona.GenericPersona;
import java.util.logging.Logger;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * The PersonasBanker main plugin.
 */
public class PersonasBanker extends JavaPlugin {
    public static final Logger LOGGER = Logger.getLogger("Minecraft");
    
    public void onDisable() {
        LOGGER.info("[PersonasBanker] Plugin disabled.");
    }

    public void onEnable() {
        Personas.getPersonaManager().registerPersona(new GenericPersona("banker"){

            @Override
            public void onNPCRightClick(NPCRightClickEvent event) {
                event.getPlayer().sendMessage("TODO: Show a bank screen");
            }
            
        });
        LOGGER.info("[PersonasBanker] Plugin enabled.");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        NPC npc = Personas.getNPCManager().createNPC("banker", "banker");
        Personas.getNPCManager().spawnNPC(npc, ((Player) sender).getEyeLocation());
        sender.sendMessage("NPC spawned.");
        return true;
    }
    
}
