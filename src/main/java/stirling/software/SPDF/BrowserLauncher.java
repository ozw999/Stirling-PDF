package stirling.software.SPDF;

import java.awt.*;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Ou
 * @date 2024/12/19
 */
@Component
@Slf4j
public class BrowserLauncher implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired private SPdfApplication application;

    @Autowired private Environment environment;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        try {
            // 指定要打开的 URL
            String url =
                    application.getNonStaticBaseUrl()
                            + ":"
                            //                            + application.getNonStaticPort()
                            + environment.getProperty("local.server.port")
                            + "?lang=zh_CN";
            // 检查是否支持自动打开浏览器
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                desktop.browse(new URI(url));
            }
        } catch (Exception e) {
            log.error("Failed to open browse", e);
        }
    }
}
