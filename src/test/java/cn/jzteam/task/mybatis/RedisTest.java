package cn.jzteam.task.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.jzteam.task.dao.entity.UserEntity;
import redis.clients.jedis.Jedis;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class RedisTest {
    
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    
    @Test
    public void getSetTest(){
        UserEntity entity = new UserEntity();
        entity.setUsername("jzteam");
        entity.setId(123);
        
        System.out.println("======== set =======");
        ValueOperations<String, String> value = redisTemplate.opsForValue();
        
        value.set("test", "jzteamtest");
        
        
        
        System.out.println("======== get =======");

        System.out.println(value.get("test"));
    }
    
    public static void main(String[] args) {
        
        Jedis jedis = new Jedis("192.168.0.100",6381);
        
        System.out.println("jedis="+jedis);

        System.out.println("---set---");
        jedis.set("test", "test1");
        System.out.println("---get---");
        System.out.println(jedis.get("test"));
    }
    

}
