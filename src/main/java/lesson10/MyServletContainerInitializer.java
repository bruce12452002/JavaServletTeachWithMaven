package lesson10;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

/**
 * servlet SPI 機制：啟動時，會去加載
 * resources/META-INF/services/
 * javax.servlet.ServletContainerInitializer 的檔案
 * 裡面只要寫 ServletContainerInitializer 實作內容即可
 */
@HandlesTypes(GrandPapa.class) // GrandPapa 不會被加載，但子類，不管是介面、抽象類別、類別都會被加載
public class MyServletContainerInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        System.out.println("init success"); // 如果沒有 @HandlesTypes 的 class，c 會是 null
    }
}
