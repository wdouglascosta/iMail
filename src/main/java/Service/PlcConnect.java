package Service;

import Application.ConnectionValues;
import etherip.EtherNetIP;

public class PlcConnect {

    private EtherNetIP plc;

    public PlcConnect(String ip,int slot) {
        this.plc = new EtherNetIP(ip,slot);
        try {
            plc.connectTcp();
        } catch (Exception e) {
            System.out.println("Controller not found!");
            e.printStackTrace();
        }
    }


    public EtherNetIP getPlc() {
        return plc;
    }
    public String getStatus() throws Exception {
        return plc.getIdentity().toString();
    }


}
