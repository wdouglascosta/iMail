package Service;

import Application.AppValues;
import Application.ConnectionValues;
import LogService.LoggerService;
import etherip.types.CIPData;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Services {
    private PlcConnect plcConnect = new PlcConnect(ConnectionValues.getIp(),ConnectionValues.getSlot());
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MMM");

    private LoggerService loggerService = new LoggerService();
    public String logWriter(String msg){
        try {
            loggerService.logToFile(msg, dateFormat.format(new Date()) + AppValues.getLogFormat());
            return "Success logged file!";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    public Object readTagBool(String tag){
        try {
            CIPData data = plcConnect.getPlc().readTag(tag);
            System.out.println(data.getNumber(0).intValue());
            return data.getNumber(0).intValue();

        } catch (Exception e) {
        System.out.println("Tag not found!");
            try {
                System.out.println(plcConnect.getStatus());
            } catch (Exception e1) {
                System.out.println("Controller not connected!");
            }
            e.printStackTrace();
            return null;
        }
    }


}
