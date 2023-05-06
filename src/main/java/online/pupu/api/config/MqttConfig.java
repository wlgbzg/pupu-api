package online.pupu.api.config;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

import java.util.Objects;

@Slf4j
@Configuration
@IntegrationComponentScan
@Getter
@Setter
public class MqttConfig {

    public static final String OUTBOUND_CHANNEL = "mqttOutboundChannel";

    public static final String INPUT_CHANNEL = "mqttInputChannel";

    @Value("${mqtt.username}")
    private String username;

    @Value("${mqtt.password}")
    private String password;

    @Value("${mqtt.serverURIs}")
    private String hostUrl;

    @Value("${mqtt.client.id}")
    private String clientId;

    @Value("${mqtt.topic}")
    private String defaultTopic;

    @Bean
    public MqttPahoClientFactory clientFactory() {
        final MqttConnectOptions options = new MqttConnectOptions();
        options.setServerURIs(new String[]{hostUrl});
        options.setUserName(username);
        options.setPassword(password.toCharArray());
        options.setAutomaticReconnect(true); // 自动重连
        final DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        factory.setConnectionOptions(options);
        return factory;
    }

    @Bean(value = OUTBOUND_CHANNEL)
    public MessageChannel mqttOutboundChannel() {
        return new DirectChannel();
    }

    @Bean
    @ServiceActivator(inputChannel = OUTBOUND_CHANNEL)
    public MessageHandler mqttOutbound() {
        final MqttPahoMessageHandler handler = new MqttPahoMessageHandler(clientId, clientFactory());
        handler.setDefaultQos(1);
        handler.setDefaultRetained(false);
        handler.setDefaultTopic(defaultTopic);
        handler.setAsync(false);
        handler.setAsyncEvents(false);
        return handler;
    }

    /**
     * MQTT消息接收处理
     */
    //接收通道
    @Bean
    public MessageChannel mqttInputChannel() {
        return new DirectChannel();
    }

    //配置client,监听的topic
    @Bean
    public MessageProducer inbound() {
        MqttPahoMessageDrivenChannelAdapter adapter = new MqttPahoMessageDrivenChannelAdapter(clientId + "_inbound", clientFactory(), defaultTopic);
        adapter.setCompletionTimeout(3000);
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(1);
        adapter.setOutputChannel(mqttInputChannel());
        return adapter;
    }

    //通过通道获取数据
    @Bean
    @ServiceActivator(inputChannel = INPUT_CHANNEL)
    public MessageHandler handler() {
        return message -> {
            String topic = Objects.requireNonNull(message.getHeaders().get("mqtt_receivedTopic")).toString();
            log.info("topic: {}", topic);
            log.info("payload: {}", message.getPayload());
        };
    }

}