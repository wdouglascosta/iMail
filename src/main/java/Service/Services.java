package Service;

import Application.AppValues;
import LogService.LoggerService;
import etherip.types.CIPData;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Services {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MMM");
    private String ip = new String(AppValues.getProperty("ip"));
    private int slot = Integer.parseInt(new String(AppValues.getProperty("slot")));
    private PlcConnect plcConnect = new PlcConnect(ip, slot);
    private LoggerService loggerService = new LoggerService();

    public String logWriter(String msg) {
        try {
            loggerService.logToFile(msg, dateFormat.format(new Date()) );
            return "Success logged file!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    private void tryConnect() {
        try {
            plcConnect = new PlcConnect(ip, slot);
        } catch (Exception notConnect) {
            System.out.println("PLC not found");
        }
    }

    public Object readTagBool(String tag) {
        try {
            CIPData data = plcConnect.getPlc().readTag(tag);
            System.out.println(data.getNumber(0).intValue());
            return data.getNumber(0).intValue();

        } catch (Exception e) {
            System.out.println("Tag not found!");
            try {
                System.out.println(plcConnect.getStatus());
            } catch (Exception e1) {
                System.out.println("Controller not connected! Trying connect again in a few seconds...");
                try {
                    Thread.sleep(5000);
                    tryConnect();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
            e.printStackTrace();
            return null;
        }
    }


}
