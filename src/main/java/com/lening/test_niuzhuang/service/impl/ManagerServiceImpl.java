package com.lening.test_niuzhuang.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lening.test_niuzhuang.entity.CompanyBean;
import com.lening.test_niuzhuang.entity.ManagerBean;
import com.lening.test_niuzhuang.mapper.CompanyMapper;
import com.lening.test_niuzhuang.mapper.ManagerMapper;
import com.lening.test_niuzhuang.service.ManagerService;
import org.junit.Test;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Resource
    private ManagerMapper managerMapper;
    @Resource
    private CompanyMapper companyMapper;
    @Override
    public ManagerBean getLogin(ManagerBean managerBean) {
        if (managerBean!=null){
            if(!StringUtils.isEmpty(managerBean.getUsername())){
                Example example = new Example(ManagerBean.class);
                Example.Criteria criteria = example.createCriteria();
                criteria.andEqualTo("username",managerBean.getUsername());
                List<ManagerBean> list = managerMapper.selectByExample(example);
                if (list!=null&&list.size()==1){
                    ManagerBean mrs = list.get(0);
                    if (mrs.getPassword().equals(managerBean.getPassword())){
                        return mrs;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public PageInfo<CompanyBean> findAll(CompanyBean searchEntity, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(CompanyBean.class);
        Example.Criteria criteria = example.createCriteria();
        if (searchEntity!=null){
            if (!StringUtils.isEmpty(searchEntity.getName())){
                criteria.andLike("name","%"+searchEntity.getName()+"%");
            }
        }
        List<CompanyBean> list = companyMapper.selectByExample(example);
        PageInfo<CompanyBean> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public void deleteManagerById(Integer id) {
        companyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(CompanyBean companyBean) {
        if(companyBean!=null){
            if(companyBean.getCid()!=null){
                companyMapper.updateByPrimaryKeySelective(companyBean);
            }else {
                String join = org.thymeleaf.util.StringUtils.join(companyBean.getServices(), ",");
                companyBean.setService(join);
                companyMapper.insertSelective(companyBean);
            }
        }
    }

    @Override
    public void deleteBatch(Integer[] cids) {
        if (cids!=null&&cids.length>=1){
            for (Integer cid : cids) {
                companyMapper.deleteByPrimaryKey(cid);
            }
        }
    }

    @Override
    public CompanyBean updateManager(Integer id) {
        return companyMapper.selectByPrimaryKey(id);
    }

    @Test
    public void test(){
        List<String> list = new ArrayList<>();
        list.add("Mxy");
        list.add("String");
        list.add("join");
        String join = String.join("-",list);//传入String类型的List集合，使用"-"号拼接
        System.out.println(join);

        String[] s = new String[]{"Yuan","Mxy"};//传入String类型的数组，使用"-"号拼接
        String join2 = String.join("-",s);
        System.out.println(join2);
    }

}
