package com.stx.sort;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class MyClassLoader {

    public static void main(String[] args) throws Exception{
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try{
                    String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
                    InputStream in = getClass().getResourceAsStream(fileName);


                    if(in == null){
                        return super.loadClass(name);
                    }
                    byte[]b = new byte[in.available()];
                    in.read(b);
                    return defineClass(name,b,0,b.length);
                }catch (IOException e){
                    e.printStackTrace();
                }
                return super.findClass(name);
            }
        };

        Object obj = myLoader.loadClass("com.stx.sort.A").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj.getClass().getClassLoader());
        System.out.println(obj instanceof A);

    }


}
