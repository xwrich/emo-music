package com.rich.music.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Dock
 * @CreateTime: 2022/1/27
 * @Description: MyBatisPlus分页配置
 */
@Configuration
public class MyBatisPlusConfig {

    //	旧版本配置
	/*@Bean
	public PaginationInterceptor paginationInterceptor(){
		return new PaginationInterceptor();
	}*/

    /**
     * 新的分页插件,一缓和二缓遵循mybatis的规则,需要设置 MybatisConfiguration#useDeprecatedExecutor = false 避免缓存出现问题
     */
    /*@Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return configuration -> configuration.setUseDeprecatedExecutor(false);
    }*/

    @Bean
    public MybatisPlusInterceptor paginationInterceptor() {
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();

        // 分页拦截器
        PaginationInnerInterceptor interceptor = new PaginationInnerInterceptor();

        interceptor.setOverflow(false);
        interceptor.setMaxLimit(500L);
        mybatisPlusInterceptor.addInnerInterceptor(interceptor);

        return mybatisPlusInterceptor;
    }
}
