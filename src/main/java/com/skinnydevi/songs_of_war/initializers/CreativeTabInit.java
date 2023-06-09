package com.skinnydevi.songs_of_war.initializers;

import com.skinnydevi.songs_of_war.common.items.SOWItemGroups;
import com.skinnydevi.songs_of_war.common.items.Weaponry;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.CreativeModeTabEvent;

import java.util.ArrayList;

public class CreativeTabInit {
    public static final ArrayList<Item> FORGERY_TAB_ITEMS = new ArrayList<>();
    public static final ArrayList<Item> WEAPONRY_TAB_ITEMS = new ArrayList<>();

    private static void createTabContents() {
        Weaponry.addWeaponryTabContents();
        Weaponry.addForgeryTabContents();
        BlockInit.addForgeryTabContents();
    }

    public static void addCreative(CreativeModeTabEvent.BuildContents event) {
        createTabContents();

        if (event.getTab() == SOWItemGroups.FORGERY_TAB) FORGERY_TAB_ITEMS.forEach(event::accept);
        if (event.getTab() == SOWItemGroups.WEAPONRY_TAB) WEAPONRY_TAB_ITEMS.forEach(event::accept);
    }
}
