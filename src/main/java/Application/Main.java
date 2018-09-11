package Application;

import Service.Services;


public class Main {

    private static Services services = new Services();

    public static void main(String[] args) {




        Object flag = null;
        String tag = "Bool1";
        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Object o = services.readTagBool(tag);

            if (o != null && flag != o && flag != null) {
                if (o.equals(0)) {
                    services.logWriter("Desligado!");
                    flag = o;
                } else if (o.equals(-1)) {
                    services.logWriter("Ligado!!");
                    flag = o;
                } else {
                    services.logWriter(o.toString());
                }
            } else if (flag == null) {
                services.logWriter("Application Started");
                flag = new Object();
            }
        }
    }
}
