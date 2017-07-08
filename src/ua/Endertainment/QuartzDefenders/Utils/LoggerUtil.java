package ua.Endertainment.QuartzDefenders.Utils;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public abstract class LoggerUtil {

	private static String prefix = new ColorFormat("&b&lQuartz &3\u00BB &8: &f").format();
        private final static Logger LOGGER = Bukkit.getLogger();
	
	public static String getPrefix() {
		return prefix;
	}
        
        public static void logError(String message) {
            LOGGER.log(Level.WARNING, new ColorFormat(prefix + "&4 Error &8: &4" + message).format());
        }
        
        public static void logInfo(String message) {
            LOGGER.log(Level.INFO, new ColorFormat(prefix + "&7 Info &8: &7" + message).format());
        }
        
	public static String gameMessage(String type, String message) {
		return new ColorFormat(getPrefix() + "&7" + type + " &8: &7" + message).format();
	}
	
}
