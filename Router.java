
public class Router {
	
	
	private int space;
	protected Device[]listofdevices;
	protected int present= 0;
	private int connect= 0;

	Semaphore sem4 ;
	
	Router(Network net){
		this.space=net.getNumberOfConnections();
		listofdevices=new Device[space];
		sem4= new Semaphore(space);
	}
	
	Router(){}
	
	public void produce(Device device) {
	sem4.acquire();
	listofdevices[present] = device;
	present = (present + 1) % space;
	System.out.println("connection "+(present+1)+" ( " + device.getname() + " )" + " login \n");
	System.out.println("connection "+(present+1)+" ( " + device.getname() + " )" + " Occupied \n");
	device.online(present+1);
	
	}
	
	public void consume(Device device) {
		listofdevices[connect]=null;
		sem4.release();
		connect = (connect + 1) % space;
		
	}

}


