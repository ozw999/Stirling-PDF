package stirling.software.SPDF;

import java.awt.*;
import java.net.URI;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author Ou
 * @date 2024/12/19
 */
@Component
public class BrowserLauncher implements ApplicationListener<ApplicationReadyEvent> {

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        try {
            // 指定要打开的 URL
            String url = "http://localhost:8080/?lang=zh_CN";
            // 检查是否支持自动打开浏览器
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                desktop.browse(new URI(url));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
