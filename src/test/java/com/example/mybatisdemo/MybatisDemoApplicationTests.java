package com.example.mybatisdemo;

import com.example.mybatisdemo.mapper.EmpMapper;
import com.example.mybatisdemo.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class MybatisDemoApplicationTests {

    @Autowired //从Spring的“IOC容器”中，获取类型是EmpMapper的对象并注入
    private EmpMapper empMapper;

    // 测试删除方法
    @Test
    public void testDel(){
        //调用删除方法
        empMapper.delete(16);
    }

    // 测试插入方法
    @Test
    public void testInsert(){
        //创建员工对象
        Emp emp = new Emp();
        //设置属性
        emp.setUsername("tom2");
        emp.setName("汤姆");
        emp.setImage("1.jpg");
        emp.setGender((short)1);
        emp.setJob((short)1);
        emp.setEntrydate(LocalDate.of(2000,1,1));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);
        //调用添加方法
        empMapper.insert(emp);
        //获取插入数据的id
        //- 想要拿到主键值，需要在Mapper接口中的方法上添加一个Options注解，
        // 并在注解中指定属性useGeneratedKeys=true和keyProperty="实体类属性名"
        System.out.println(emp.getDeptId());
    }


    // 测试更新方法
    @Test
    public void testUpdate(){
        //要修改的员工信息
        Emp emp = new Emp();
        emp.setId(21);
        emp.setUsername("songdaxia");
        emp.setPassword(null);
        emp.setName("老宋");
        emp.setImage("2.jpg");
        emp.setGender((short)1);
        emp.setJob((short)2);
        emp.setEntrydate(LocalDate.of(2012,1,1));
        emp.setCreateTime(null);
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(2);
        //调用方法，修改员工数据
        empMapper.update(emp);
    }

    // 测试查询方法
    @Test
    public void testGetById(){
        Emp emp = empMapper.getById(1);
        System.out.println(emp);
    }

    // 测试查询所有方法
    @Test
    public void testGetByOther(){
        LocalDate begin = LocalDate.of(2000,1,1);
        LocalDate end = LocalDate.of(2000,10,1);
        short gender = 1;
        List<Emp> empList = empMapper.list("汤姆", gender, begin, end);

//        List<Emp> empList = empMapper.list(null, null, null, null);
        System.out.println(empList);
    }
}
