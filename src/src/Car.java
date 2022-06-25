import java.sql.Time;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

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
            System.out.println("Select an option: ");
            a = s.nextInt();
            switch (a) {
                case 1:
                    System.out.println("Welcome to MG.Vehicle check-OK.Wear your seat bealt and drive safe!!");
                    drivemode();
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
            i--;
        }
    }

    /**
     * 100=Everything is working.
     * 200=Major funtionality working.There is some fault.
     * 300=Faulty vehicle functionality.
     *
     * @return
     */
    public int getVehicleStatus() {
        int status[] = new int[]{100, 200, 300};
        Random rand = new Random();
        return status[rand.nextInt(3)];

    }

    public void useAccessories() {
        int vehicleStatus = getVehicleStatus();
        if (vehicleStatus == 100) {
            System.out.println("We are good to go.");
            checkStatus(100);
        } else if (vehicleStatus == 200) {
            System.out.println("You may face some inconvinience.Please check.");
            checkStatus(200);
        } else {
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

    public void drivemode() {
        int i = 0, c;

        while (i == 0) {
            Scanner s1 = new Scanner(System.in);
            System.out.println("1.SportMode()");
            System.out.println("2.AWD mode()");
            System.out.println("3.Reverse()");
            System.out.println("4.EcoMode()");

            System.out.println("Drive mode selection: ");
            c = s1.nextInt();
            switch (c) {
                case 1:
                    System.out.println("Wear seatbelt and donot overspeed.");
                    getBattery();
                    break;
                case 2:
                    System.out.println("Use this mode for hillstart,consumes more power look after the battery percentage.");
                    getBattery();
                    break;
                case 3:
                    System.out.println("Rear camera turned on,also check the surroundings.");
                    getBattery();
                    break;
                case 4:
                    System.out.println("Economy mode gives more range.Drive longer and safer");
                    getBattery();
                default:
                    System.out.println("Exit ");
            }
            i--;

        }
    }
        public void transactions(){

            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    getBattery();
                }
            },5000,1000);
        }
int b1,b2;
    public void getBattery() {


        int battery1[] = new int[101];
        for (int a = 0; a <= 100; a++) {
            battery1[a] = a;
        }
        Random rand = new Random();
        b1 = battery1[rand.nextInt(101)];
        System.out.println("b1= " + b1);
        int battery2[] = new int[101];
        for (int a = 0; a <= 100; a++) {
            battery2[a] = a;
        }
        b2 = battery2[rand.nextInt(101)];
        System.out.println("b2= " + b2);
    }




   public void switching()
   {

       while(b1!=0 || b2!=0)
       {
           if(b1>b2)
           {
               b1-=5;
               b2+=2;
               System.out.println("b1 is discharging and b2 is recharging");
               System.out.println("b1="+b1);
               System.out.println("b2="+b2);
           }
           else if (b2>b1)
           {
            b2-=5;
            b1+=2;
               System.out.println("b2 is discharging and b1 is recharging");
               System.out.println("b1="+b1);
               System.out.println("b2="+b2);

           }
           else if (b1==b2)
           {
               b1-=5;
               b2+=2;
               System.out.println("b1 is discharging and b2 is recharging");
               System.out.println("b1="+b1);
               System.out.println("b2="+b2);
           }
           break;
       }
   }


    public static void main(String args[]) {
        Start obj = new Start();
        obj.Startup();
        obj.switching();



    }
}
