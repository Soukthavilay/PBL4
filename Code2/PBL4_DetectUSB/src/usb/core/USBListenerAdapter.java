package usb.core;

import java.io.IOException;

/**
 * Subclassable USBListener adapter, which ignores all calls.
 * Your subclasses can provide behaviors only for the events
 * relevant to their roles.
 *
 * <p> You may want to wrap your instances within a
 * {@link usb.remote.USBListenerProxy} before you hand them
 * to {@link Host#addUSBListener}.
 */
public class USBListenerAdapter
    implements USBListener
{
    /** Default constructor does nothing. */
    public USBListenerAdapter () throws IOException { }

    public void busAdded (Bus bus) throws IOException {}
    public void busRemoved (Bus bus) throws IOException {}
    public void deviceAdded (Device dev) throws IOException {}
    public void deviceRemoved (Device dev) throws IOException {}
}