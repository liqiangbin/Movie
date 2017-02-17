package com.cn.hnust.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.HobyMapper;
import com.cn.hnust.pojo.Hoby;
import com.cn.hnust.pojo.HobyExample;
import com.cn.hnust.pojo.HobyExample.Criteria;
import com.cn.hnust.service.HobyService;
import com.cn.hnust.utils.PageBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
/**
 * @ClassName: HobyServiceImpl
 * @title: HobyServiceImpl.class
 * @author: liulangzhizi
 * @Data: 2016��-11��-07�� 10:23:26 
 * @Version: V1.0.0
 * @description:  
 */
@Service
public class HobyServiceImpl implements HobyService {

	@Resource
	private HobyMapper hobymapper;

	//��ҳ��ѯ
	public PageBean findPage(int currentPage , int pageSize){
		PageBean pageBean = new PageBean();
		HobyExample example=new HobyExample();
		PageHelper.startPage(currentPage, pageSize);
		List<Hoby> list = hobymapper.selectByExample(example);
		PageInfo<Hoby> info = new PageInfo<Hoby>(list);
		long total = info.getTotal();
		int totalPage = (int) ((total + pageSize - 1) / pageSize);
		pageBean.setTotalPage(totalPage);
		pageBean.setTotal(total);
		pageBean.setRows(list);
		pageBean.setCurrentPage(currentPage);
		return pageBean;
	}
	
	//����id��ѯ
	public Hoby findById(int id){
		return hobymapper.selectByPrimaryKey(id);
	}
	
	//��ѯ����
	public List<Hoby> findList(int userId){
		HobyExample example=new HobyExample();
		Criteria criteria=example.createCriteria();
		criteria.andUseridEqualTo(userId);
		example.setOrderByClause("Id desc");
		return hobymapper.selectByExample(example);
	}
	
	//���
	public int insertHoby(Hoby entity){
		return hobymapper.insert(entity);
	}
	
	//�޸�
	public int updateHoby(Hoby entity){
		return hobymapper.updateByPrimaryKey(entity);
	}
	
	//ɾ��
	public int deleteById(int id){
		return hobymapper.deleteByPrimaryKey(id);
	}
	
	//����ɾ��
	public void deletes(String ids){
		String[] str=ids.split(",");
		for(String id : str){
			try {
				hobymapper.deleteByPrimaryKey(Integer.parseInt(id));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}
