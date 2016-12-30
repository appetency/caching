package spittr.config;

import net.sf.ehcache.CacheManager;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableCaching  /*启用缓存*/
public class CachingConfig {

  @Bean
  public EhCacheCacheManager cacheManager(CacheManager cm) {
    return new EhCacheCacheManager(cm);
  } /*配置EhCacheManager*/

  @Bean
  public EhCacheManagerFactoryBean ehcache() {   /*EhCacheManagerFactoryBean*/
    EhCacheManagerFactoryBean ehCacheFactoryBean = 
        new EhCacheManagerFactoryBean();
    ehCacheFactoryBean.setConfigLocation(
        new ClassPathResource("spittr/cache/ehcache.xml"));/*指明EhCache XML配置文件*/
    return ehCacheFactoryBean;
  }
  
}
