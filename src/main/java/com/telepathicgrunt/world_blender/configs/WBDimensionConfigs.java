package com.telepathicgrunt.world_blender.configs;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry;
import me.sargunvohra.mcmods.autoconfig1u.shadowed.blue.endless.jankson.Comment;

@Config(name = "dimension")
public class WBDimensionConfigs implements ConfigData {

    @ConfigEntry.Gui.PrefixText
    @ConfigEntry.Gui.Tooltip(count = 0)
    @Comment(value = "\nShould Dispensers always drop the Glass Bottle when using specific \n"
            +"bottle items on certain The Bumblezone blocks? \n"
            +"\n"
            +"Example: Using Honey Bottle to feed Honeycomb Brood Blocks will grow the larva and \n"
            +"drop the Glass Bottle instead of putting it back into Dispenser if this is set to true.")
    public boolean dispensersDropGlassBottles = false;


    @ConfigEntry.Gui.PrefixText
    @ConfigEntry.Gui.Tooltip(count = 0)
    @Comment(value = " The size of the different kinds of surfaces. Higher numbers means\r\n"
            +" each surface will be larger but might make some surfaces harder to"
            +" find. Lower numbers means the surfaces are smaller but could become"
            +" too chaotic or small for some features to spawn on.\r\n")
    @ConfigEntry.BoundedDiscrete(min = 1, max = 100000)
    public double surfaceScale = 240D;

    @ConfigEntry.Gui.PrefixText
    @ConfigEntry.Gui.Tooltip(count = 0)
    @Comment(value = " If true, the Enderdragon will spawn at world origin in the\r\n"
            +" World Blender dimension and can respawn if you put back the\r\n"
            +" End Crystals on the podiums. Once killed, the podium's portal \r\n"
            +" will take you to the End where you can battle the End's Enderdragon. \r\n"
            +" \r\n"
            +" And yes, you can respawn the EnderDragon by placing 4 End Crystals \r\n"
            +" on the edges of the Bedrock Podium. \r\n"
            +" \r\n"
            +" If set to false, the Enderdragon will not spawn.\r\n"
            +" NOTE: Once the Enderdragon is spawned, changing this to false"
            +" will not despawn the Enderdragon. Also, this option will not\r\n"
            +" work in the World Blender Worldtype due to how fight managers are \r\n"
            +" set up. It will only work for the dimension. \r\n")
    public boolean spawnEnderDragon = false;

    @ConfigEntry.Gui.PrefixText
    @ConfigEntry.Gui.Tooltip(count = 0)
    @Comment(value = " If true, carvers (mainly vanilla caves and ravines) can now carve\r\n"
            +" out Netherrack, End Stone, and some modded blocks as well.\r\n"
            +" \r\n"
            +" If turned off, you might see Vanilla caves and stuff gets cutoff \r\n"
            +" by a wall of End Stone, Netherrack, or modded blocks. \r\n")
    public boolean carversCanCarveMoreBlocks = true;
}