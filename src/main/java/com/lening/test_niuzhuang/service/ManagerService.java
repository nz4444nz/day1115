package com.lening.test_niuzhuang.service;

import com.github.pagehelper.PageInfo;
import com.lening.test_niuzhuang.entity.CompanyBean;
import com.lening.test_niuzhuang.entity.ManagerBean;

public interface ManagerService {
    ManagerBean getLogin(ManagerBean managerBean);

    PageInfo<CompanyBean> findAll(CompanyBean searchEntity, Integer pageNum, Integer pageSize);


    void deleteManagerById(Integer id);

    void saveOrUpdate(CompanyBean companyBean);

    void deleteBatch(Integer[] cids);

    CompanyBean updateManager(Integer id);

}
