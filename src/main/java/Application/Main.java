package Application;

import Service.Services;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Services services = new Services();
        Object flag = 1;
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Object o = services.readTagBool("Bool1");

            if (o != null && flag != o) {
                if (o.equals(0)) {
                    services.logWriter("Desligado!");
                    flag = o;
                } else {
                    services.logWriter("Ligado!!");
                    flag = o;
                }
            }

        }
    }
}
