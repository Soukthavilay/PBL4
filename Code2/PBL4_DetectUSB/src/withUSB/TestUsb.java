package withUSB;

import java.util.List;

import javax.usb.UsbConfiguration;
import javax.usb.UsbDevice;
import javax.usb.UsbEndpoint;
import javax.usb.UsbException;
import javax.usb.UsbHostManager;
import javax.usb.UsbHub;
import javax.usb.UsbInterface;
import javax.usb.UsbPort;
import javax.usb.UsbServices;

public class TestUsb {
	/**
     * Dumps the specified USB device to stdout.
     * 
     * @param device
     *            The USB device to dump.
     */
    @SuppressWarnings("unchecked")
	private static void dumpDevice(final UsbDevice device)
    {
        // Dump information about the device itself
        System.out.println(device);
        
        final UsbPort port = device.getParentUsbPort();
        if (port != null)
        {
            System.out.println("Connected to port: " + port.getPortNumber());
            System.out.println("Parent: " + port.getUsbHub());
        }
        
        // Dump device descriptor
        System.out.println(device.getUsbDeviceDescriptor());

        // Process all configurations
        for (UsbConfiguration configuration: (List<UsbConfiguration>) device
            .getUsbConfigurations())
        {
            // Dump configuration descriptor
            System.out.println(configuration.getUsbConfigurationDescriptor());

        
        }

        System.out.println();

        // Dump child devices if device is a hub
        if (device.isUsbHub())
        {
            final UsbHub hub = (UsbHub) device;
            for (UsbDevice child: (List<UsbDevice>) hub.getAttachedUsbDevices())
            {
                dumpDevice(child);
            }
        }
    }
    
    private static void RemoveUSB(final UsbDevice device) {
    	device.removeUsbDeviceListener(null);
    }
    /**
     * Main method.
     * 
     * @param args
     *            Command-line arguments (Ignored)
     * @throws UsbException
     *             When an USB error was reported which wasn't handled by this
     *             program itself.
     */
    public static void main(final String[] args) throws UsbException
    {
        // Get the USB services and dump information about them
        final UsbServices services = UsbHostManager.getUsbServices();
        System.out.println("USB Service Implementation: "
            + services.getImpDescription());
        System.out.println("Implementation version: "
            + services.getImpVersion());
        System.out.println("Service API version: " + services.getApiVersion());
        System.out.println();

        // Dump the root USB hub
        dumpDevice(services.getRootUsbHub());
    }
}
