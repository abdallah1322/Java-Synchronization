import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numcon, numdev;

		System.out.println("What is the number of WI-FI Connections?");
		numcon = scan.nextInt();
		System.out.println("What is the number of devices Clients want to connect?");
		numdev = scan.nextInt();
		String[] names = new String[numdev];

		Network net = new Network(numcon, numdev, names);

		net.setNameOfDevice();

		try {
			PrintStream consoleOut = System.out;
			PrintStream fileOut = new PrintStream(new File("output.log"));
			PrintStream teePrintStream = new TeePrintStream(consoleOut, fileOut);
			System.setOut(teePrintStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Router router = new Router(net);
		Device[] devlist = new Device[numdev];
		for (int i = 0; i < numdev; i++) {
			Device device = new Device(net.extractDeviceName(net.getNameOfDevice()[i]),net.extractDeviceType(net.getNameOfDevice()[i]), router);
			devlist[i] = device;
			if (i < numcon) {
				System.out.println(devlist[i].getname() + " " + devlist[i].getType() + " " + "arrived\n");
			} else {
				System.out.println(devlist[i].getname() + " " + devlist[i].getType() + " " + "arrived and waiting\n");
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			devlist[i].start();
		}
	}
}

