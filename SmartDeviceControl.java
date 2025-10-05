interface Powerable{
void powerOn();
void powerOff();
}
interface Connectable{
void connectToWiFi(String ssid);
}
class SmartLight implements Powerable{
public void powerOn(){System.out.println("Light On");}
public void powerOff(){System.out.println("Light Off");}
}
class SmartSpeaker implements Powerable,Connectable{
public void powerOn(){System.out.println("Speaker On");}
public void powerOff(){System.out.println("Speaker Off");}
public void connectToWiFi(String ssid){System.out.println("Speaker connected to "+ssid);}
}
class SmartPlug implements Powerable{
public void powerOn(){System.out.println("Plug On");}
public void powerOff(){System.out.println("Plug Off");}
}
public class SmartDeviceControl{
public static void main(String[] args){
SmartLight l=new SmartLight();
SmartSpeaker s=new SmartSpeaker();
SmartPlug p=new SmartPlug();
l.powerOn();
l.powerOff();
s.powerOn();
s.connectToWiFi("HomeWiFi");
s.powerOff();
p.powerOn();
p.powerOff();
}
}
