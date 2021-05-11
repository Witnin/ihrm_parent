package com.wsy.company.controller;

import com.wsy.common.entity.Result;
import com.wsy.common.entity.ResultCode;
import com.wsy.common.exception.CommonException;
import com.wsy.company.service.CompanyService;
import com.wsy.domain.company.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author within
 * @version 1.0
 * @date 2021/4/21 15:01
 */
@CrossOrigin //跨域
@RequestMapping(value = "/company")
@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    //新增
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Result add(@RequestBody Company company) {
        companyService.add(company);
        return  new Result(ResultCode.SUCCESS);

    }
    //更新
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Result update(@PathVariable(value = "id") String id, @RequestBody Company company) {
        company.setId(id);
        companyService.save(company);
        Result result = new Result(ResultCode.SUCCESS);
        return result;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable(value = "id") String id) {
        companyService.deleteById(id);
        Result result = new Result(ResultCode.SUCCESS);
        return result;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable(value = "id") String id) throws CommonException {
//        throw new CommonException(ResultCode.UNAUTHORISE);
        Company company = companyService.findById(id);
        Result result = new Result(ResultCode.SUCCESS);
        result.setData(company);
        return result;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Result findAll() {
//        int i = 1/0;
        List<Company> list = companyService.findAll();
        Result result = new Result(ResultCode.SUCCESS);
        result.setData(list);
        return result;
    }


}
