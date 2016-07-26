package rancheros.com.infrastructure.kafka;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface RancherosProducer {

    @Output("output")
    MessageChannel getMessageChannel();
}
