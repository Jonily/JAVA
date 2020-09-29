package frank.springbootstudy.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

@Service
public class TestLifeOfBean2 implements BeanPostProcessor {
    /**
     *  BeanPostProcessor接口方法
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean.getClass().equals(TestLifeOfBean.class)){//屏蔽其他类信息
            System.out.println("postProcessBeforeInitialization ===== "+beanName);

        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean.getClass().equals(TestLifeOfBean.class)) {//屏蔽其他类信息
            System.out.println("postProcessAfterInitialization ===== " + beanName);
        }
        return bean;
    }
}
