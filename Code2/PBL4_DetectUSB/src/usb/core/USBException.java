package usb.core;

import java.io.IOException;

/**
 * USBException objects indicate USB errors.
 *
 * @author David Brownell
 * @version $Id: USBException.java,v 1.1 2008/10/15 09:27:59 huangmeng Exp $
 */
public abstract class USBException extends IOException
{
    /**
     * Constructs an exception object representing a USB exception.
     */
    public USBException (String descriptive)
    {
	super (descriptive);
    }

    /**
     * Returns true iff the exception indicates a (bulk) endpoint has
     * stalled; these are used as error indicators in device protocols.
     */
    abstract public boolean isStalled ();
}