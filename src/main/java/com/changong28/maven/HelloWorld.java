package com.changong28.maven;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaoch on 2014/9/30.
 */
public class HelloWorld {
    private static Map conf = new HashMap<Object, Object>();

    public static void main(String[] args){
        String appHome = System.getProperty("app.path.home","G:\\laboratory\\hive\\hello-world\\target\\hello-world-1.0-SNAPSHOT-bin\\hello-world-1.0-SNAPSHOT");
        loadYaml(appHome+"/config/config.yaml");
        System.out.println(conf.get("greetings"));
    }

    private static void loadYaml(String confPath) {
        System.out.println("confPath:"+confPath);
        Yaml yaml = new Yaml();
        try {
            InputStream stream = new FileInputStream(confPath);
            conf = (Map) yaml.load(stream);
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}
