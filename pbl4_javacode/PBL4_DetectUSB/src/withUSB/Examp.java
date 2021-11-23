package withUSB;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.usb.UsbDevice;
import javax.usb.UsbException;
import javax.usb.UsbHostManager;
import javax.usb.UsbHub;
import javax.usb.UsbServices;

import model.BO.Device_BO;
import model.DAO.Device_DAO;
import model.bean.Device;

public class Examp {
	static File[] oldListRoot = File.listRoots();
	public static List<Device> devices = new ArrayList<Device>();
	 @SuppressWarnings("unchecked")
	public static List<Device> dumpDevice() throws UsbException
	  {

	    final UsbServices services = UsbHostManager.getUsbServices();
	    List<Device> listDevice = new ArrayList<Device>();
	    UsbDevice device = services.getRootUsbHub();
	    if(device.isUsbHub()) {
	    	 final UsbHub hub = (UsbHub) device;
	    	 for(UsbDevice child: (List<UsbDevice>) hub.getAttachedUsbDevices()) {
	    		 int idDevice = Integer.parseInt(String.valueOf(child.getUsbDeviceDescriptor().idProduct()));
	    		 int idVendor = Integer.parseInt(String.valueOf(child.getUsbDeviceDescriptor().idVendor()));
	    		 Device dev = new Device(idDevice,idVendor);
	    		 System.out.println("Device detect: " + dev);
	    		 listDevice.add(Device_DAO.getDeviceConnect(dev));
	    	 }
	    }
	    return listDevice;
	  }
	 public static void alwayCheck() {
		Thread thread = new Thread(new Runnable() {
		@Override
		public void run() {
			while(true) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				try {
					System.out.println("=============================");
					if (File.listRoots().length > oldListRoot.length) {
	                    System.out.println("new drive detected");
	                    oldListRoot = File.listRoots();
	                    devices = dumpDevice();
					 } else if (File.listRoots().length < oldListRoot.length) {	
						 System.out.println("1 driver dis connect");
	                    oldListRoot = File.listRoots();
	                    devices  = dumpDevice();
					 }
					
				} catch (UsbException e) {
					e.printStackTrace();
				}
			}
		}
		});
		thread.start();
		 
	 }
	
}
