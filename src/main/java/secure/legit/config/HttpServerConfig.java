package secure.legit.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.embedded.tomcat.TomcatProtocolHandlerCustomizer;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;

@Configuration
public class HttpServerConfig {

    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> enableDefaultServlet() {
        return factory -> factory.setRegisterDefaultServlet(true);
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public TomcatProtocolHandlerCustomizer<?> protocolHandlerVirtualThreadExecutorCustomizer() {
        return protocolHandler -> protocolHandler.setExecutor(Executors.newCachedThreadPool());
    }
}
