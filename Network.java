import java.util.Scanner;

public class Network {


	    private int numberof_Connections;
	    private int numberof_Devices;
	    private String[] nameOfDevice = new String [numberof_Devices];

	    public Network(){
	        numberof_Connections = 0;
	        numberof_Devices = 0;
	    }

	    public Network(int numberOfConnections, int numberOfDevices, String[] nameOfDevice) {
	        this.numberof_Connections = numberOfConnections;
	        this.numberof_Devices = numberOfDevices;
	        this.nameOfDevice = nameOfDevice;
	    }

	    public int getNumberOfConnections() {
	        return numberof_Connections;
	    }

	    public void setNumberOfConnections(int numberOfConnections) {
	        this.numberof_Devices = numberOfConnections;
	    }

	    public int getNumberOfDevices() {
	        return numberof_Devices;
	    }

	    public void setNumberOfDevices(int numberOfDevices) {
	        this.numberof_Devices = numberOfDevices;
	    }

	    public String[] getNameOfDevice() {
	        return nameOfDevice;
	    }

	    public void setNameOfDevice() {

	        int num = getNumberOfDevices();
	        for (int i = 0; i < num; i++){
	            Scanner scan = new Scanner(System.in);
	            nameOfDevice[i] = scan.nextLine();
	        }
	    }

	public String extractDeviceName(String deviceDescription) {
		// Find the position of the first space in the description
		int spaceIndex = deviceDescription.indexOf(" ");

		// Extract the name from the beginning of the description
		String deviceName = deviceDescription.substring(0, spaceIndex);

		// Return the extracted device name
		return deviceName;
	}


	public String extractDeviceType(String deviceDescription) {
		// Find the position of the first space in the description
		int spaceIndex = deviceDescription.indexOf(" ");

		// Extract the type after the first space
		String deviceType = deviceDescription.substring(spaceIndex + 1);

		// Return the extracted device type
		return deviceType;
	}

}

