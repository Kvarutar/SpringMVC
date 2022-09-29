package ru.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@Configuration
@ComponentScan("ru.mvc")
@EnableWebMvc
public class SpringConfig implements WebMvcConfigurer {//реализация интерфейса для шаблонизатора
    private final ApplicationContext applicationContext;//контекст нужен для шаблонизатора

    @Autowired
    public SpringConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    public SpringResourceTemplateResolver templateResolver() {//штука для представлений
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);//для шаблонизатора опять же
        templateResolver.setPrefix("/WEB-INF/views/");//папка для представлений
        templateResolver.setSuffix(".html");//расширение файлов представлений
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {//здесь тоже происходить конфигурация представлений
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {//этот метод из шаблонизатора и в нем передается
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();  //информация о том, что мы хотим использовать
        resolver.setTemplateEngine(templateEngine());                  //шаблонизатор thymeleaf
        registry.viewResolver(resolver);
    }
}