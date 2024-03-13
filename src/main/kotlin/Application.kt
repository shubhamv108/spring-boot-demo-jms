package code.shubham.demo.jms

import jakarta.jms.ConnectionFactory
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer
import org.springframework.context.annotation.Bean
import org.springframework.jms.annotation.EnableJms
import org.springframework.jms.config.DefaultJmsListenerContainerFactory
import org.springframework.jms.support.converter.MappingJackson2MessageConverter
import org.springframework.jms.support.converter.MessageConverter
import org.springframework.jms.support.converter.MessageType
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.util.ErrorHandler

@SpringBootApplication
@EnableJms
@EnableScheduling
class Application {
    @Bean
    fun jmsListenerContainerFactory(
            configurer: DefaultJmsListenerContainerFactoryConfigurer, connectionFactory: ConnectionFactory?,
            myErrorHandler: ErrorHandler?): DefaultJmsListenerContainerFactory {
        val factory = DefaultJmsListenerContainerFactory()
        configurer.configure(factory, connectionFactory)
        factory.setErrorHandler(myErrorHandler)
        return factory
    }

    @Bean // Serialize message content to json using TextMessage
    fun jacksonJmsMessageConverter(): MessageConverter {
        val converter = MappingJackson2MessageConverter()
        converter.setTargetType(MessageType.TEXT)
        converter.setTypeIdPropertyName("_type")
        return converter
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(Application::class.java, *args)
        }
    }
}