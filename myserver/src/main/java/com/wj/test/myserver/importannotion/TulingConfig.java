package com.wj.test.myserver.importannotion;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {TulingSelector.class, TulingImportBeanDefinitionRegistrar.class})
public class TulingConfig {

}
