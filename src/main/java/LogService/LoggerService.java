package LogService;

import Application.AppValues;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class LoggerService {

    private static final Logger log = LoggerFactory.getLogger(LoggerService.class);
    private SimpleDateFormat sdf;

    public LoggerService() {
        this.sdf = new SimpleDateFormat("yyyy-MM-dd, HH:mm:ss.SSS");
    }


    /**
     * Adiciona uma mensagem no log.txt
     *
     * @param msg   mensagem a ser adicionada no arquivo
     */
    public void logToFile(String msg, String fileName) {
        try {
            String line = createLogLine(msg);
            File folder = new File(AppValues.getPath());
            folder.mkdirs();
            File log = new File(folder, fileName);
            FileWriter fw = new FileWriter(log, true);
            fw.write(line);
            fw.close();
        } catch (IOException ex) {
            log.error("Problema ao loggar no arquivo", ex);
        }
    }

    /**
     * Cria uma mensagem de Log formatada de acordo com a classe que está sendo executada
     *
     * @param msg   mensagem do log
     * @return dados do log no padrão (Data, nome da classe, método e número da classe)
     */
    public String createLogLine(String msg) {
        String line = sdf.format(new Date()) + ", - tag: ," + msg + "\n";
        return line;

    }

}
