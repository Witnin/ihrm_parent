package com.wsy.company.dao;

import com.wsy.domain.company.Company;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



/**
 * @author within
 * @version 1.0
 * @date 2021/4/20 15:33
 *save(company):保存或更新(有id更新，无id保存)
 * deleteByid(id):
 * findByid(id)
 * findAll()
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CompanyDaoTest {
    @Autowired
    private CompanyDao companyDao;

    @Test
    public void test(){
        Company company = companyDao.findById("1").get();
        System.out.println("test"+company);
        System.out.println("test2"+company);
        System.out.println("test3"+company);
        System.out.println("master-test3"+company);
        System.out.println("master-test4"+company);

    }

}
