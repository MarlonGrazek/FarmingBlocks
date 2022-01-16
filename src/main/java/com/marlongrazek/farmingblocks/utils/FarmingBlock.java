package com.marlongrazek.farmingblocks.utils;

import com.marlongrazek.builder.StringBuilder;
import com.marlongrazek.datafile.DataFile;
import com.marlongrazek.farmingblocks.main.Main;
import org.bukkit.Location;

import java.util.Random;

public class FarmingBlock {

    private Long id;
    private final Location location;

    public FarmingBlock(Location location) {
        this.id = generateID();
        this.location = location;
    }

    public FarmingBlock(long id, Location location) {
        this.id = id;
        this.location = location;
    }


    public void create() {

        if (id == null) this.id = generateID();

        DataFile farmingblocks = Main.getDataFile("farmingblocks");
        farmingblocks.set(id + ".location", location);
    }

    public void delete() {
        Main.getDataFile("farmingblocks").set(id + "", null);
    }


    public long getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }

    // id
    private long generateID() {
        StringBuilder sb = new StringBuilder();
        String randomNumbers = "0123456789";
        Random random = new Random();
        long id = 0;
        while (id == 0) {
            for (int i = 0; i < 16; i++)
                sb.add(String.valueOf(randomNumbers.charAt(random.nextInt(randomNumbers.length()))));
            long generatedID = Long.parseLong(sb.toString());
            if (!isExistingID(generatedID)) id = generatedID;
        }
        return id;
    }

    private boolean isExistingID(long id) {
        for (String idString : Main.getDataFile("farmingblocks").getConfigurationSection("", false))
            if (Long.parseLong(idString) == id) return true;
        return false;
    }

    public static FarmingBlock fromLocation(Location location) {

        DataFile farmingblocks = Main.getDataFile("farmingblocks");
        for (String id : farmingblocks.getConfigurationSection("", false)) {

            if (farmingblocks.get(id + ".location") != null && farmingblocks.get(id + ".location").equals(location)) {

                return new FarmingBlock(Long.parseLong(id), location);
            }
        }

        return null;
    }

    public static boolean isExisting(FarmingBlock farmingBlock) {
        DataFile farmingblocks = Main.getDataFile("farmingblocks");
        for (String id : farmingblocks.getConfigurationSection("", false)) {
            if (farmingblocks.contains(id + ".location") &&
                    farmingBlock.getLocation().equals(farmingblocks.get(id + ".location"))) return true;
        }
        return false;
    }
}
