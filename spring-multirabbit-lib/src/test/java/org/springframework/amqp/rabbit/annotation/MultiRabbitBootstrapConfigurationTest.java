package org.springframework.amqp.rabbit.annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.amqp.rabbit.config.RabbitListenerConfigUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MultiRabbitBootstrapConfigurationTest {

    private MultiRabbitBootstrapConfiguration configuration = new MultiRabbitBootstrapConfiguration();

    @Mock
    private BeanDefinitionRegistry registry;

    @Test
    public void shouldCreateMultiRabbitListenerAnnotationBeanPostProcessorBean() {
        configuration.registerBeanDefinitions(null, registry);

        verify(registry).registerBeanDefinition(
                RabbitListenerConfigUtils.RABBIT_LISTENER_ANNOTATION_PROCESSOR_BEAN_NAME,
                new RootBeanDefinition(MultiRabbitListenerAnnotationBeanPostProcessor.class));
    }
}
