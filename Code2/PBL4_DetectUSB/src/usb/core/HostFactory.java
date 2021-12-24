package usb.core;

import java.io.IOException;

/**
 * Bootstrapping methods.
 */
public abstract class HostFactory
{
    static private Host		self;

    /**
     * Not part of the API.
     * This is part of the SPI for the reference implementation.
     */
    protected HostFactory () { }

    /**
     * Not part of the API.
     * This is part of the SPI for the reference implementation.
     */
    public abstract Host createHost () throws IOException;


    /**
     * Returns a USB Host according to an environment-specific policy.
     * This bootstrapping method is part of the API, but the policy
     * used by the environment isn't.
     *
     * @exception IOException When USB Host functions are not available.
     */
    public static Host getHost ()
    throws IOException
    {
	synchronized (HostFactory.class) {
	    if (self != null)
		return self;

	    // The exact policy used to find a host to return is
	    // NOT standardized -- embedded systems might want
	    // to avoid reflection (at some cost in portability),
	    // others might be driven by some system property.

	    try {
		// prefer any designated proxy
		self = maybeGetHost ("usb.remote.RemoteHostFactory");
		if (self != null)
		    return self;

	    // ignore exceptions here
	    } catch (IOException e) {
	    } catch (RuntimeException e) {
	    }

	    // else try a native implementation
	    String os = System.getProperty ("os.name");
            
            //added by Mike 14.7.2003
            if(os.toLowerCase().startsWith("windows")){
                //System.out.println("usb." + os.toLowerCase () + "." + os);
                self = maybeGetHost ("usb.windows.Windows");
            }
	    //self = maybeGetHost ("usb." + os.toLowerCase () + "." + os);
	    if (self == null)
		throw new IOException ("USB Host support is unavailable.");
	}
	return self;
    }

    static private Host maybeGetHost (String classname)
    throws IOException, SecurityException
    {
	try {
	    Object	temp;
	    HostFactory	factory;

	    temp = Class.forName (classname);
	    temp = ((Class)temp).newInstance ();
	    return ((HostFactory) temp).createHost ();

	} catch (SecurityException e) {
	    throw e;

	} catch (IOException e) {
	    throw e;

	} catch (Exception e) {
	    return null;
	}
    }
}