package com.atsistemas.cern.lhcCollector.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.JsonMessageConverter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.atsistemas.cern.lhcCollector.service.DataDispatchService;
import com.atsistemas.cern.lhcCollector.service.DataDispatchServiceImpl;
import com.atsistemas.cern.lhcCollector.util.QueueManager;
import com.atsistemas.cern.lhcCollector.util.QueueManagerPropsImpl;


@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix="rabbitmq")
public class AmqpConfig {
	
	private String host;
	private int port;
	private String virtualHost;
	private String username;
	private String password;
	
	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory(host,port);
		connectionFactory.setVirtualHost(virtualHost);
		connectionFactory.setUsername(username);
		connectionFactory.setPassword(password);
		return connectionFactory;
	}

	@Bean
	public AmqpAdmin amqpAdmin() {

		RabbitAdmin amqpAdmin = new RabbitAdmin(connectionFactory());
		
		for(Queue queue : queueManager().getQueueList()){
			amqpAdmin.declareQueue(queue);
		}
		
		return amqpAdmin;
	}

	
	@Bean
	public RabbitTemplate rabbitTemplate() {
		RabbitTemplate template = new RabbitTemplate(connectionFactory());
		template.setMessageConverter(new JsonMessageConverter());
		return template;
	}
	
	@Bean
	QueueManager queueManager(){
		return new QueueManagerPropsImpl();
//		return new QueueManagerMapImpl();
	}
	
	@Bean
	DataDispatchService dataDispatchService(){
		return new DataDispatchServiceImpl();
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getVirtualHost() {
		return virtualHost;
	}

	public void setVirtualHost(String virtualHost) {
		this.virtualHost = virtualHost;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
