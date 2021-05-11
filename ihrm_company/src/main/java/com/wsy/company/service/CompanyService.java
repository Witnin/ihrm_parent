package com.wsy.company.service;
import	java.util.List;


import com.wsy.common.utils.IdWorker;
import com.wsy.company.dao.CompanyDao;
import com.wsy.domain.company.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @author within
 * @version 1.0
 * @date 2021/4/20 17:23
 */
@Service
public class CompanyService {
    @Autowired
    CompanyDao companyDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 保存企业,配置idworker到工程，在service中注入idworker,通过idworker生成id,保存企业
     */
    public void add(Company company){
        //基本属性的设置
        String id = idWorker.nextId()+"";
        company.setId(id);
        //默认状态
        company.setAuditState("1"); //0:未审核，1已审核
        company.setState(1); //0-未激活；1-已激活

        companyDao.save(company);


    }

    /**
     * 更新企业
     */
    public void save(Company company){
        //基本属性的设置
        companyDao.save(company);


    }

    /**
     * 删除企业
     */

    public void deleteById(String id) {

        companyDao.deleteById(id);
    }

    /**
     * 根据id查询企业
     */
    public Company findById(String id){
        Company company =companyDao.findById(id).get();
        return company;
    }

    /**
     *查询企业列表
     */
    public List<Company> findAll() {
        return companyDao.findAll();
    }


}
