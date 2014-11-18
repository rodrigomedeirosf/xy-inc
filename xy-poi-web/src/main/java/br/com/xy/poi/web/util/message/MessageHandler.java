package br.com.xy.poi.web.util.message;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class MessageHandler {
	
	private MessageHandler(){}
	
	private static Logger log = LoggerFactory.getLogger(MessageHandler.class);
	
	public static final String POI_SAVE_ILLEGAL_ARGUMENT = "poi.save.invalidArgument";
	public static final String POI_SAVE_SUCCESS = "poi.save.success";
	
	private static final HashMap<String, String> messages = new HashMap<String, String>();
	private static final Properties prop = new Properties();
	private static InputStream input = null;

	static {
		
		try {
			input = MessageHandler.class.getResourceAsStream("/message.properties");
			prop.load(input);
			loadEasterEggMessages();
		} catch (IOException e) {
			log.error("Error reading resource file.", e);
		}  catch (Exception e) {
			log.error("unexpected error loading message file.", e);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					log.error("Error closing resource file.", e);
				}
			}
		}
	}
	
	public static String getMessage(String key){
		return prop.getProperty(key);
	}
	
	public static String getMessage(String keyAux, String key){
		return StringUtils.isNotBlank(messages.get(keyAux)) ? messages.get(keyAux) : prop.getProperty(key);
	}
	
	public static void loadEasterEggMessages(){
		messages.put("Pombo's House", "Phruuuuu!! Pombo's House poi saved!");
	}
	
}
