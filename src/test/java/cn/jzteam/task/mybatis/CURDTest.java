package cn.jzteam.task.mybatis;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.jzteam.task.dao.UserEntityMapper;
import cn.jzteam.task.dao.entity.UserEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class CURDTest {
    
    @Autowired
    private UserEntityMapper userMapper;
    
    @Autowired
    private SqlSession sqlSession;
    
    public void init(){
    }
    
    @Test
    public void curdTest(){
        
        long start = System.currentTimeMillis();
//        UserEntityMapper mapper = sqlSession.getMapper(UserEntityMapper.class);
//        for(int i = 0;i<1000;i++){
            UserEntity entity = new UserEntity();
            String name = UUID.randomUUID().toString().substring(0, 10);
            entity.setUsername(name);
            entity.setPassword("123123");
            entity.setDeleteflag(0);
            entity.setMobile("18810246073");
            userMapper.insertSelective(entity);
            System.out.println("插入一条：");
            
//        }
        
        long end = System.currentTimeMillis();
        System.out.println("插入完成，耗时："+(end-start));
    }

}
