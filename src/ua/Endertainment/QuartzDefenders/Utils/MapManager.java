package ua.Endertainment.QuartzDefenders.Utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;

import ua.Endertainment.QuartzDefenders.QuartzDefenders;

public class MapManager {


	private String worldS;
	private World world;
	private File sourseDir;
	private File serverDir;
	
	private boolean success = false;
	
	public MapManager(String world) {
		this.worldS = world;
		this.sourseDir = new File(QuartzDefenders.getInstance().getDataFolder().getPath(), "maps" + File.separator + world);
		this.serverDir = new File(QuartzDefenders.getInstance().getServer().getWorldContainer().getAbsolutePath());
	}
	
	public void resetMap() {
		this.deleteMap();
		this.copyMap();
	}
	
	public void deleteMap() {
		World w = Bukkit.getWorld(worldS);
		if(w != null) {
			File worldFolder = new File(w.getWorldFolder().getPath());
			Bukkit.unloadWorld(w, false);
			try {
				FileUtils.deleteDirectory(worldFolder);
			} catch (IOException e) {
				LoggerUtil.logError(Language.getString("logger.delete_map_failed", new Replacer("{0}", worldS)));
			}
		}
	}
	
	public void copyMap() {
		if(!isFolderExist()) {
			LoggerUtil.logError(Language.getString("logger.find_map_failed", new Replacer("{0}", worldS), new Replacer("{1}", sourseDir.toString())));
			return;
		}
		try {
			FileUtils.copyDirectory(sourseDir, serverDir);
		} catch (IOException e) {
			LoggerUtil.logError(Language.getString("logger.copy_map_failed"));
		}
		this.world = Bukkit.getServer().createWorld(new WorldCreator(worldS));
		this.success = true;
	}
	
	public World getWorld() {
		if(world == null) return null;
		return world;
	}
	
	public boolean isFolderExist() {
		if(sourseDir.exists()) return true;
		return false;
	}

	public boolean isSuccess() {
		return success;
	}

	
}
