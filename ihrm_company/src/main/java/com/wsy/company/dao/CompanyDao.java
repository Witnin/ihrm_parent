package com.wsy.company.dao;

/**
 * @author within
 * @version 1.0
 * @date 2021/4/20 15:32
 */

import com.wsy.domain.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 企业数据访问接口<></>
 * 自定义dao接口继承
 * JpaRepository<实体类, 主键>
 * JpaSpecificationExecutor<实体类></>
 */
public interface CompanyDao extends JpaRepository<Company, String>, JpaSpecificationExecutor<Company> {
}
