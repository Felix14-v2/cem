package net.dorianpb.cem.internal.config;

import me.lortseam.completeconfig.api.ConfigContainer;
import me.lortseam.completeconfig.api.ConfigEntry;
import me.lortseam.completeconfig.data.Config;
import me.lortseam.completeconfig.gui.ConfigScreenBuilder;
import me.lortseam.completeconfig.gui.cloth.ClothConfigScreenBuilder;
import net.fabricmc.loader.api.FabricLoader;

@SuppressWarnings({"FieldMayBeFinal"})
public final class CemConfig extends Config implements ConfigContainer, CemOptions{
	@ConfigEntry
	private boolean use_optifine_folder        = false;
	@ConfigEntry
	private boolean use_new_model_creation_fix = true;
	
	private CemConfig(){
		super("cem");
	}
	
	public static CemConfig getConfig(){
		CemConfig hello = new CemConfig();
		hello.load();
		return hello;
	}
	
	public static void createScreen(){
		if(FabricLoader.getInstance().isModLoaded("cloth-config2")){
			ConfigScreenBuilder.setMain("cem", new ClothConfigScreenBuilder());
		}
	}
	
	@Override
	public boolean useOptifineFolder(){
		return this.use_optifine_folder;
	}
	
	@Override
	public boolean useTransparentParts(){
		return this.use_new_model_creation_fix;
	}
}