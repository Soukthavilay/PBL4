package usb.core;

import java.io.IOException;
import java.util.Hashtable;


/**
 * Provides access to a USB device descriptor.
 * Most fields of this descriptor are specified in section 9.6.1 of
 * the USB 1.1 specification, and the standard device messages are
 * defined later in that chapter.
 *
 * @see Device
 *
 * @author David Brownell
 * @version $Id: DeviceDescriptor.java,v 1.1 2008/10/15 09:27:56 huangmeng Exp $
 */
final public class DeviceDescriptor extends Descriptor
{
    /** Device with which this descriptor is associated */
    private Device	dev;


    public DeviceDescriptor clone (Device d)
    {
	return new DeviceDescriptor (d, data);
    }

    public DeviceDescriptor (Device d, byte buf [])
    {
	super (buf);
	if (getDescriptorType () != TYPE_DEVICE)
	    throw new IllegalArgumentException ();
	dev = d;
    }


    /**
     * Returns the version of the USB specification to which this device
     * and its descriptors conform.  At this writing, "1.1" is the current
     * version, used by most hubs, but older "1.0" devices are available.
     */
    public String getUSBVersion ()
    {
	return getBCD (2);
    }

    /** Returns the USB class identifier for the device.  */
    public int getDeviceClass ()
    {
	return getU8 (4);
    }
	
    /** Returns the USB class name for the device.  */
    public String getDeviceClassName ()
    {
	return getClassName (getDeviceClass (), "device");
    }
	
    /** Returns the USB subclass identifier for the device.  */
    public int getDeviceSubClass ()
    {
	return getU8 (5);
    }

    /** Returns the device protocol */
    public int getDeviceProtocol ()
    {
	return getU8 (6);
    }

    /**
     * Returns the maximum packet size understood by endpoint zero.
     * Only values of 8, 16, 32, or 64 bytes are relevant.
     */
    public int getMaxPacketSize0 ()
    {
	return getU8 (7);
    }

    /**
     * Returns the vendor of the USB device.
     * Many devices are bundled into products from other vendors, so
     * this vendor ID may not correspond to markings on packaging.
     */
    public int getVendorId ()
    {
	return getU16 (8);
    }

    /**
     * Returns the vendor's product identifier code.
     * Each vendor assigns these codes as it chooses.
     */
    public int getProductId ()
    {
	return getU16 (10);
    }

    /** Returns the device release version number (such as "3.14").  */
    public String getDeviceId ()
    {
	return getBCD (12);
    }

    /**
     * Returns any string describing the product's manufacturer,
     * or null.  This is optional, and is typically associated
     * with the vendor ID.
     */
    public String getManufacturer (int language)
    {
	try {
	    int id = getManufacturerStringId ();
	    if (id > 0)
		return dev.getString (id, language);
	} catch (IOException e) { }
	return null;
    }

    /** Returns the manufacturer string ID, or zero. */
    public int getManufacturerStringId ()
	{ return getU8 (14); }

    /**
     * Returns any string describing the product, or null.
     * This is optional, and is typically associated with the
     * product ID.
     */
    public String getProduct (int language)
    {
	try {
	    int id = getProductStringId ();
	    if (id > 0)
		return dev.getString (id, language);
	} catch (IOException e) { }
	return null;
    }

    /** Returns the product string ID, or zero */
    public int getProductStringId ()
	{ return getU8 (15); }

    /**
     * Returns any string describing the product's serial number,
     * or null.  This is optional, and is assigned using the
     * manufacturer's scheme.
     */
    public String getSerial (int language)
    {
	try {
	    int id = getSerialStringId ();
	    if (id > 0)
		return dev.getString (id, language);
	} catch (IOException e) { }
	return null;
    }

    /** Returns the serial string ID, or zero. */
    public int getSerialStringId ()
	{ return getU8 (16); }


    /** Returns the number of configurations this device supports. */
    public int getNumConfigurations ()
    {
	return getU8 (17);
    }

    /** Returns the device the descriptor describes. */
    public Device getDevice ()
    {
	return dev;
    }
}