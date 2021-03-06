package com.cn.hnust.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cn.hnust.dao.ManagerMapper;
import com.cn.hnust.pojo.Manager;
import com.cn.hnust.pojo.ManagerExample;
import com.cn.hnust.pojo.ManagerExample.Criteria;
import com.cn.hnust.service.ManagerService;
import com.cn.hnust.utils.PageBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
/**
 * @ClassName: ManagerServiceImpl
 * @title: ManagerServiceImpl.class
 * @author: liulangzhizi
 * @Data: 2016��-11��-07�� 10:23:26 
 * @Version: V1.0.0
 * @description:  
 */
@Service
public class ManagerServiceImpl implements ManagerService {
	@Resource
	private ManagerMapper managermapper;
	
	//��ҳ��ѯ
	public PageBean findPage(int currentPage , int pageSize){
		PageBean pageBean = new PageBean();
		ManagerExample example=new ManagerExample();
		PageHelper.startPage(currentPage, pageSize);
		List<Manager> list = managermapper.selectByExample(example);
		PageInfo<Manager> info = new PageInfo<Manager>(list);
		long total = info.getTotal();
		int totalPage = (int) ((total + pageSize - 1) / pageSize);
		pageBean.setTotalPage(totalPage);
		pageBean.setTotal(total);
		pageBean.setRows(list);
		pageBean.setCurrentPage(currentPage);
		return pageBean;
	}
	
	//����id��ѯ
	public Manager findById(int id){
		return managermapper.selectByPrimaryKey(id);
	}
	
	//��ѯ����
	public List<Manager> findList(){
		ManagerExample example=new ManagerExample();
		return managermapper.selectByExample(example);
	}
	
	//���
	public int insertManager(Manager entity){
		return managermapper.insert(entity);
	}
	
	//�޸�
	public int updateManager(Manager entity){
		return managermapper.updateByPrimaryKey(entity);
	}
	
	//ɾ��
	public int deleteById(int id){
		return managermapper.deleteByPrimaryKey(id);
	}
	
	//����ɾ��
	public void deletes(String ids){
		String[] str=ids.split(",");
		for(String id : str){
			try {
				managermapper.deleteByPrimaryKey(Integer.parseInt(id));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}

	public Manager checkLogin(String name, String password) {
		System.out.println("***********");
		ManagerExample example=new ManagerExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		criteria.andPasswordEqualTo(password);
		List<Manager> list = this.managermapper.selectByExample(example);
		System.out.println("!!!!!!!!!!!1");
		if(null ==list || list.size()==0){
			return null;
		}
		return list.get(0);
	}
}
