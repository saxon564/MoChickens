package com.saxon564.mochickens.events;

import com.saxon564.mochickens.Reference;
import com.saxon564.mochickens.configs.txts.ItemFile;

import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = Reference.MOD_ID)
public class CommonEvents {
	private static boolean filesGenerated = false;

	@SubscribeEvent
	public static void onEntityJoinLevelEvent(final EntityJoinLevelEvent event) {
		if (!filesGenerated) {
			filesGenerated = true;
			ItemFile.generateTxtFiles(event.getLevel());
		}
	}
}