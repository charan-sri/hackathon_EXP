import java.util.Random;
import java.util.Scanner;

interface car1 {
    abstract void Startup();

    abstract int getVehicleStatus();

}

class Start implements car1 {
    public void Startup() {
        int a, i = 0;
        Scanner s = new Scanner(System.in);
        System.out.println("Apply brake and press the ignition button to start.");
        String parts;
        while (i == 0) {
            System.out.println("1.StartEngine()");
            System.out.println("2.AccessoryMode()");
            System.out.println("3.IgnitionMode()");
            System.out.println("enter about all parts");
            parts = s.next();
            System.out.println("Select an option: ");

            a = s.nextInt();
            switch (a) {
                case 1:
                    System.out.println("Welcome to MG.Vehicle check-OK.Wear your seat bealt and drive safe!!");
                    break;
                case 2:
                    System.out.println("Accessory mode.You can use the accesories.");
                    useAccessories();
                    break;
                case 3:
                    System.out.println("Ignition mode.vehicle check is in process!!");
                    useAccessories();
                    break;
                default:
                    System.out.println("Apply the brake and push the ignition button to start the engine!!");
            }
        }
    }

    /**
     * 100=Everything is working.
     * 200=Major funtionality working.There is some fault.
     * 300=Faulty vehicle functionality.
     * @return
     */
    public int getVehicleStatus() {
      int status[]=new int[]{100,200,300};
        Random rand= new Random();
        return status[rand.nextInt(3)];

    }
    public void useAccessories()
    {
        int vehicleStatus=getVehicleStatus();
        if(vehicleStatus==100)
        {
            System.out.println("We are good to go.");
            checkStatus(100);
        } else if (vehicleStatus==200) {
            System.out.println("You may face some inconvinience.Please check.");
            checkStatus(200);
        }
        else{
            System.out.println("Faulty Engine.");
            checkStatus(-1);
        }


    }

    public void checkStatus(int vehicleStatus) {
        if (vehicleStatus == 100) {
            System.out.println("Vehicle status-OK.Press the push button to start engine .");
        } else if (vehicleStatus == 200) {
            System.out.println("Some faulty condition,repair it!!");
        } else {
            System.out.println("Faulty Engine.");
        }
    }
    public static void main(String args[]) {
        Start obj = new Start();
        obj.Startup();
    }
}
