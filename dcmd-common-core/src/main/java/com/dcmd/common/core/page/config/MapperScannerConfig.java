/**
 * Copy Right Information : 数云 <br>
 * Project : 数云指挥系统 <br>
 * Description : 分页参数类<br>
 * Author : 朱彪 <br>
 * Maintainer:  <br>
 * Version : 1.0.0 <br>
 * Since : 1.0 <br>
 * Date : 2018-03-20<br>
 * Update:  <br>
 */
package com.dcmd.common.core.page.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureAfter(MybatisConfig.class) //保证在MyBatisConfig实例化之后再实例化该类
public class MapperScannerConfig {
    
    // mapper接口的扫描器
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.dcmd.common.core.page");
        return mapperScannerConfigurer;
    }


}