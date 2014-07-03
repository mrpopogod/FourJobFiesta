/*
 * (C) 2014 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */

package ffvrandom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author doukasa
 */
public class FFVRandom
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        List<String> windJobs = Arrays.asList("Knight", "Monk", "Thief", "White Mage", "Black Mage", "Blue Mage");
        List<String> waterJobs = Arrays.asList("Mystic Knight", "Berserker", "Red Mage", "Time Mage", "Summoner");
        List<String> fireJobs = Arrays.asList("Ninja", "Geomancer", "Beastmaster", "Ranger", "Bard");
        List<String> earthJobs = Arrays.asList("Samurai", "Dragoon", "Dancer", "Chemist");
        List<String> allJobs = new ArrayList<>();
        allJobs.addAll(windJobs);
        allJobs.addAll(waterJobs);
        allJobs.addAll(fireJobs);
        allJobs.addAll(earthJobs);

        Random rand = new Random();
        // Generate all jobs
        List<String> jobs = new ArrayList<>();
        for (int i = 0; i < 4; i++)
        {
            jobs.add(allJobs.get(rand.nextInt(allJobs.size())));
            allJobs.remove(jobs.get(i));
        }

        List<String> availableWind = new ArrayList<>();
        List<String> availableWater = new ArrayList<>();
        List<String> availableFire = new ArrayList<>();
        List<String> availableEarth = new ArrayList<>();

        for (String job : jobs)
        {
            if (windJobs.contains(job))
            {
                availableWind.add(job);
                availableWater.add(job);
                availableFire.add(job);
                availableEarth.add(job);
            }
            else if (waterJobs.contains(job))
            {
                availableWater.add(job);
                availableFire.add(job);
                availableEarth.add(job);
            }
            else if (fireJobs.contains(job))
            {
                availableFire.add(job);
                availableEarth.add(job);
            }
            else
            {
                availableEarth.add(job);
            }
        }

        for (int i = 0; i < 4; i++)
        {
            String job = "";
            if (!availableWind.isEmpty())
            {
                job = availableWind.get(rand.nextInt(availableWind.size()));
                availableWind.clear();
                availableWater.remove(job);
                availableFire.remove(job);
                availableEarth.remove(job);
            }
            else if (!availableWater.isEmpty())
            {
                job = availableWater.get(rand.nextInt(availableWater.size()));
                availableWater.clear();
                availableFire.remove(job);
                availableEarth.remove(job);
            }
            else if (!availableFire.isEmpty())
            {
                job = availableFire.get(rand.nextInt(availableFire.size()));
                availableFire.clear();
                availableEarth.remove(job);
            }
            else
            {
                job = availableEarth.get(rand.nextInt(availableEarth.size()));
                availableEarth.remove(job);
            }

            System.out.println("Job #" + i + ": " + job);
        }
    }

}
