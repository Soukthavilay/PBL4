package usb.core;

import java.io.IOException;


/**
 * Represents a host with one or more Universal Serial Busses.
 *
 * <p> A Host is the first object you need to access in order to
 * use this API.  At this writing, accessing that first object
 * uses OS-specific APIs, or unstandardized policies for using
 * RMI Naming.  That will change over time.
 *
 * @see usb.linux.Linux
 *
 * @author David Brownell
 * @version $Id: Host.java,v 1.1 2008/10/15 09:27:56 huangmeng Exp $
 */
public interface Host
{
    /**
     * Returns an array of objects representing the USB busses currently
     * available on this host.
     */
    public Bus [] getBusses ()
    throws IOException;

    /**
     * Returns the device, if any, associated with the specified
     * {@link usb.core.PortIdentifier PortIdentifier} string.
     */
    public Device getDevice (String portId)
    throws IOException;

    /** Adds a callback for USB structure changes */
    public void addUSBListener (USBListener l)
    throws IOException;
	
    /** Removes a callback for USB structure changes */
    public void removeUSBListener (USBListener l)
    throws IOException;
}