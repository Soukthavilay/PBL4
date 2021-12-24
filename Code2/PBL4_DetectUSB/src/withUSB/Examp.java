	package withUSB;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.usb.UsbDevice;
import javax.usb.UsbException;
import javax.usb.UsbHostManager;
import javax.usb.UsbHub;
import javax.usb.UsbServices;

import model.DAO.ConnectionDAO;
import model.DAO.Device_DAO;
import model.bean.Connect;
import model.bean.Device;

public class Examp {
	static File[] oldListRoot = 	File.listRoots();
	public static List<Device> list = new ArrayList<Device>();  
	public static Map<Device,Boolean> devices = new HashMap<Device, Boolean>();
	public static Map<Device,Boolean> newdevices = new HashMap<Device, Boolean>();

	 @SuppressWarnings("unchecked")
	public static List<Device> dumpDevice() throws UsbException
	  {
		 System.out.println("===dddd====");
	    final UsbServices services = UsbHostManager.getUsbServices();
	    List<Device> listdevice = new ArrayList<Device>();
	    
	    /**
	     * list1(a,b,c)
	     * list2(a,b,c,d)
	     * 
	     */
	    //List<Device> listDevice = new ArrayList<Device>();
	    UsbDevice device = services.getRootUsbHub();
	    if(device.isUsbHub()) {
	    	 final UsbHub hub = (UsbHub) device;
	    	 for(UsbDevice child: (List<UsbDevice>) hub.getAttachedUsbDevices()) {
	    		 int idDevice = Integer.parseInt(String.valueOf(child.getUsbDeviceDescriptor().idProduct()));
	    		 int idVendor = Integer.parseInt(String.valueOf(child.getUsbDeviceDescriptor().idVendor()));
	    		 Device dev = new Device(idDevice,idVendor);
	    		 listdevice.add(dev);  
	    		 
	    	 }
	    }
	    manage();
	    for(Map.Entry<Device, Boolean> i : devices.entrySet()) {
	    	System.out.println(i.getKey()+ "   " + i.getValue());
	    }
	    return listdevice;
	  }
	// private static Device getDeviceChange() throws SecurityException, UsbException {
	
	 //}
	 private static void manage() {
		 if(devices.size() == 0) {
			 for(Device device : list) {
				 devices.put(device, true);
			 }
		 }
		 else {
			 for(Device device: list) {
				 newdevices.put(device, true);
			 }
		 }
		 for(Map.Entry<Device, Boolean> i : devices.entrySet()) {
			 int check = 0;
			 for(Map.Entry<Device, Boolean> j : newdevices.entrySet()) {
				 if(i.getKey().getIdDevice() == j.getKey().getIdDevice()) {
					 check++;
				 }
			 }
			 if(i.getValue()== true && check == 0) {
				 int IdConnect = ConnectionDAO.getIdConnect(i.getKey().getIdDevice());
				 ConnectionDAO.updateConnect(IdConnect);
				 i.setValue(false);
			 }
			 if(i.getValue() == false && check != 0) {
				 int idTypeGate = Device_DAO.getTypeGate(i.getKey().getIdDevice());
				 ConnectionDAO.setConnect(new Connect(idTypeGate,i.getKey().getIdDevice(),LocalDateTime.now(),null));
				 i.setValue(true);
			 }
		 }	 
		 for(Map.Entry<Device, Boolean> j : newdevices.entrySet()) {
			 int check = 0;
			 for(Map.Entry<Device, Boolean> i : devices.entrySet()) {
				 if(j.getKey().getIdDevice() == i.getKey().getIdDevice()) {
					 check ++;
				 }
			 }
			 if(check == 0) {
				 int idTypeGate = Device_DAO.getTypeGate(j.getKey().getIdDevice());
				 ConnectionDAO.setConnect(new Connect(idTypeGate,j.getKey().getIdDevice(),LocalDateTime.now(),null));
				 devices.put(j.getKey(), true);
			 }
		 }
		 newdevices.clear();
	 }

	 @SuppressWarnings("unused")
	public  String getComputerName()
	 {
	     Map<String, String> env = System.getenv();
	     if (env.containsKey("COMPUTERNAME"))
	         return env.get("COMPUTERNAME");
	     else if (env.containsKey("HOSTNAME"))
	         return env.get("HOSTNAME");
	     else
	         return "Unknown Computer";
	 }
	 public void main(String[] args) {
		 alwayCheck();
	}
	 public boolean Load;
	 public void alwayCheck() {
		
		 Thread thread = new Thread(new Runnable() {
		
			@Override
			public void run() {
				while(true) {
					Load = false;
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					try {
						System.out.println("=============================");
							list = dumpDevice();
						if (File.listRoots().length > oldListRoot.length) {
			                System.out.println("new drive detected");
			                oldListRoot = File.listRoots();
			                list = dumpDevice();
			                Load = true;
			                
						 } else if (File.listRoots().length < oldListRoot.length) {	
							System.out.println("1 driver dis connect");
			                oldListRoot = File.listRoots();
			                list  = dumpDevice();
			                Load = true;
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
