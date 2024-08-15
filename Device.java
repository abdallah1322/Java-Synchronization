import java.util.Random;


public class Device extends Thread {
	Random random=new Random();
	private String name ;
	private String type ;
	
	Router router;

	public String getname() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	

	void connect(int num) {
		router.produce(this);


		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	void online(int num) {
		System.out.println("connection "+num+"( " + name + " )" + " perform online activity\n");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void logout() {
		System.out.println("( " + name + " )" + " (" + type +") logged out \n" );
		router.consume(this);

	}
	Device (String nameofdevice , String typeofdevice,Router r) {
		name = nameofdevice;
		type = typeofdevice;
		this.router=r;
	}
	
	public void run() {
		connect(router.present+1);
		logout();
		
	}
}