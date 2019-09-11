package com.xiewendomg.admin.java.design_patterns.proxy.trends_proxy;

import com.xiewendomg.admin.java.design_patterns.proxy.static_proxy.Moveable;
import com.xiewendomg.admin.java.design_patterns.proxy.static_proxy.Tank;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;

public class TrendComplier {
    public static void main(String[] args) throws Exception {

        //得到Java源文件
        String src ="package com.xiewendomg.admin.java.design_patterns.proxy.trends;\n" +
                "import com.xiewendomg.admin.java.design_patterns.proxy.static_proxy.Moveable;\n" +
                "public class TankTimeProxy implements Moveable {\n" +
                "    Moveable t;\n" +
                "\n" +
                "    public TankTimeProxy(Moveable t) {\n" +
                "        this.t = t;\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public void run() {\n" +
                "        System.out.println(\"Start time .............\"+System.currentTimeMillis());\n" +
                "        t.run();\n" +
                "        System.out.println(\"End time ................\"+System.currentTimeMillis());\n" +
                "    }\n" +
                "}\n";
        String fileName=System.getProperty("user.dir")+
                "/src/main/java/com/xiewendomg/admin/java/design_patterns/proxy/trends_proxy/TankTimeProxy.java";
        File file=new File(fileName);
        FileWriter fileWriter=new FileWriter(file);
        fileWriter.write(src);
        fileWriter.flush();
        fileWriter.close();

        //编译文件
        JavaCompiler javaCompiler=ToolProvider.getSystemJavaCompiler();
        System.out.println(javaCompiler);

        StandardJavaFileManager fm=javaCompiler.getStandardFileManager(null,null,null);
        Iterable units=fm.getJavaFileObjects(fileName);
        JavaCompiler.CompilationTask task= javaCompiler.getTask(null,fm,null,null,null,units);
        task.call();
        fm.close();

        //load in memory and create an instance
        URL[] urls=new URL[]{new URL("file:/"+ System.getProperty("user.dir"))};
        URLClassLoader ul=new URLClassLoader(urls);
        Class c=ul.loadClass("com.xiewendomg.admin.java.design_patterns.proxy.trends_proxy.TankTimeProxy");
        System.out.println(c);
        Constructor constructor=c.getConstructor(Moveable.class);
        Moveable moveable=(Moveable) constructor.newInstance(new Tank());
        moveable.run();

    }
}
