package com.github.plexpt.ptmod;

import com.github.plexpt.ptmod.common.CommonProxy;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;


/**
 * @author pt
 */
@Mod(modid = PTmod.MODID, name = PTmod.NAME, version = PTmod.VERSION, acceptedMinecraftVersions = "[1.12,)")
public class PTmod {
    public static final String MODID = "ptmod";
    public static final String NAME = "PT mod";
    public static final String VERSION = "1.0.0";

    private static Logger logger;

    @Mod.Instance(MODID)
    public static PTmod instance;

    @SidedProxy(clientSide = "com.github.plexpt.ptmod.client.ClientProxy",
            serverSide = "com.github.plexpt.ptmod.common.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        logger = event.getModLog();
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }

    public Logger getLogger()
    {
        return logger;
    }

}
