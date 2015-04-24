package com.github.jmpjct;

/*
 * Java Mysql Proxy
 * Main binary. Just listen for connections and pass them over
 * to the proxy module
 */

import java.io.IOException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import java.util.Properties;
import java.io.FileInputStream;

public class JMP {
    public static Properties config = new Properties();
    
    public static void main(String[] args) throws IOException {
//        JMP.class.getClassLoader().getResource("conf/jmp.properties");
        FileInputStream config = new FileInputStream("/Users/oyach/workspace/JavaMySQLProxy/daemon/src/main/resources/conf/jmp.properties");
        JMP.config.load(config);
        config.close();
        
        Logger logger = Logger.getLogger("JMP");
        PropertyConfigurator.configure(JMP.config.getProperty("logConf").trim());
        
        String[] ports = JMP.config.getProperty("ports").split(",");
        for (String port: ports) {
            new Thread(new JMP_Thread(Integer.parseInt(port.trim()))).start();
        }
    }
}
