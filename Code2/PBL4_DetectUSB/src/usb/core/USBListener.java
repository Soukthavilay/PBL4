package usb.core;

import java.io.IOException;
import java.util.EventListener;


/**
 * Interface implemented by objects that want to monitor USB structure.
 * The order in which these changes are reported is not necessarily
 * going to be the order in which the changes were seen in the real
 * world, and delays also occur.
 *
 * <p> For the moment it seems wise to ensure that your listener
 * callbacks can safely handle duplicated notifications.
 */
public interface USBListener extends EventListener
{
    // not bothering to wrap the info inside an "EventObject"

    /** New bus added.  */
    public void busAdded (Bus bus)
    throws IOException;

    /** Bus removed. */
    public void busRemoved (Bus bus)
    throws IOException;

    /** New device added.  */
    public void deviceAdded (Device dev)
    throws IOException;

    /** Device removed. */
    public void deviceRemoved (Device dev)
    throws IOException;
}