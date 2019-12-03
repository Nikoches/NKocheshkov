import org.pcap4j.core.*;
import org.pcap4j.util.NifSelector;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainTest {
    static PcapNetworkInterface getNetworkDevice() {
        PcapNetworkInterface device = null;
        try {
            device = new NifSelector().selectNetworkInterface();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return device;
    }

    public static void main(String[] args) throws PcapNativeException, NotOpenException {
        List<PcapPacket> list = new ArrayList<>();
        // The code we had before
        PcapNetworkInterface device = getNetworkDevice();
        System.out.println("You chose: " + device);

        // New code below here
        if (device == null) {
            System.out.println("No device chosen.");
            System.exit(1);
        }

        // Open the device and get a handle
        int snapshotLength = 65536; // in bytes
        int readTimeout = 50; // in milliseconds
        final PcapHandle handle;
        handle = device.openLive(snapshotLength, PcapNetworkInterface.PromiscuousMode.PROMISCUOUS, readTimeout);

        // Create a listener that defines what to do with the received packets
        PacketListener listener = (PcapPacket pcapPacket) -> {
            // Override the default gotPacket() function and process packet
            System.out.println(handle.getTimestampPrecision());
            System.out.println(pcapPacket);
        };

        // Tell the handle to loop using the listener we created
        try {
            int maxPackets = 10;
            handle.loop(maxPackets, listener);
            list.add(handle.getNextPacket());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SparkJob.initialize(list);
        // Cleanup when complete
        handle.close();
    }
}
