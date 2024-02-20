package my.gov.ns.ptgns.doc_utils.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MemoryMonitor {

    private static final Logger LOGGER = LoggerFactory.getLogger(MemoryMonitor.class);

    public static void Monitor() {
        //Start Memory Monitoring
        int mb = 1024 * 1024;

        //Getting the runtime reference from system
        Runtime runtime = Runtime.getRuntime();

        LOGGER.info("##### Heap utilization statistics [MB] #####");

        //Print used memory
        LOGGER.info("Used Memory: {}", ((runtime.totalMemory() - runtime.freeMemory()) / mb));

        //Print free memory
        LOGGER.info("Free Memory: {}", (runtime.freeMemory() / mb));

        //Print total available memory
        LOGGER.info("Total Memory: {}", (runtime.totalMemory() / mb));

        //Print Maximum available memory
        LOGGER.info("Max Memory: {}", (runtime.maxMemory() / mb));
        //End Memory Monitoring
    }
}
