package com.cn.hnust.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.hnust.dao.MtypeMapper;
import com.cn.hnust.pojo.Mtype;
import com.cn.hnust.pojo.MtypeExample;
import com.cn.hnust.service.MtypeService;
import com.cn.hnust.utils.PageBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
/**
 * @ClassName: MtypeServiceImpl
 * @title: MtypeServiceImpl.class
 * @author: liulangzhizi
 * @Data: 2016��-11��-07�� 10:23:26 
 * @Version: V1.0.0
 * @description:  
 */
@Service
public class MtypeServiceImpl implements MtypeService {

	@Resource
	private MtypeMapper mtypemapper;

	//��ҳ��ѯ
	public PageBean findPage(int currentPage , int pageSize){
		PageBean pageBean = new PageBean();
		MtypeExample example=new MtypeExample();
		PageHelper.startPage(currentPage, pageSize);
		List<Mtype> list = mtypemapper.selectByExample(example);
		PageInfo<Mtype> info = new PageInfo<Mtype>(list);
		long total = info.getTotal();
		int totalPage = (int) ((total + pageSize - 1) / pageSize);
		pageBean.setTotalPage(totalPage);
		pageBean.setTotal(total);
		pageBean.setRows(list);
		pageBean.setCurrentPage(currentPage);
		return pageBean;
	}
	
	//����id��ѯ
	public Mtype findById(int id){
		return mtypemapper.selectByPrimaryKey(id);
	}
	
	//��ѯ����
	public List<Mtype> findList(){
		MtypeExample example=new MtypeExample();
		return mtypemapper.selectByExample(example);
	}
	
	//���
	public int insertMtype(Mtype entity){
		return mtypemapper.insert(entity);
	}
	
	//�޸�
	public int updateMtype(Mtype entity){
		return mtypemapper.updateByPrimaryKey(entity);
	}
	
	//ɾ��
	public int deleteById(int id){
		return mtypemapper.deleteByPrimaryKey(id);
	}
	
	//����ɾ��
	public void deletes(String ids){
		String[] str=ids.split(",");
		for(String id : str){
			try {
				mtypemapper.deleteByPrimaryKey(Integer.parseInt(id));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}
