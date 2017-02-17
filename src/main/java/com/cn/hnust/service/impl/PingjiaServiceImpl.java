package com.cn.hnust.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.hnust.dao.PingjiaMapper;
import com.cn.hnust.pojo.Pingjia;
import com.cn.hnust.pojo.PingjiaExample;
import com.cn.hnust.service.PingjiaService;
import com.cn.hnust.utils.PageBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
/**
 * @ClassName: PingjiaServiceImpl
 * @title: PingjiaServiceImpl.class
 * @author: liulangzhizi
 * @Data: 2016��-11��-07�� 10:23:26 
 * @Version: V1.0.0
 * @description:  
 */
@Service
public class PingjiaServiceImpl implements PingjiaService {

	@Resource
	private PingjiaMapper pingjiamapper;

	//��ҳ��ѯ
	public PageBean findPage(int currentPage , int pageSize){
		PageBean pageBean = new PageBean();
		PingjiaExample example=new PingjiaExample();
		PageHelper.startPage(currentPage, pageSize);
		List<Pingjia> list = pingjiamapper.selectByExample(example);
		PageInfo<Pingjia> info = new PageInfo<Pingjia>(list);
		long total = info.getTotal();
		int totalPage = (int) ((total + pageSize - 1) / pageSize);
		pageBean.setTotalPage(totalPage);
		pageBean.setTotal(total);
		pageBean.setRows(list);
		pageBean.setCurrentPage(currentPage);
		return pageBean;
	}
	
	//����id��ѯ
	public Pingjia findById(int id){
		return pingjiamapper.selectByPrimaryKey(id);
	}
	
	//��ѯ����
	public List<Pingjia> findList(){
		PingjiaExample example=new PingjiaExample();
		return pingjiamapper.selectByExampleWithBLOBs(example);
	}
	
	//���
	public int insertPingjia(Pingjia entity){
		return pingjiamapper.insert(entity);
	}
	
	//�޸�
	public int updatePingjia(Pingjia entity){
		return pingjiamapper.updateByPrimaryKey(entity);
	}
	
	//ɾ��
	public int deleteById(int id){
		return pingjiamapper.deleteByPrimaryKey(id);
	}
	
	//����ɾ��
	public void deletes(String ids){
		String[] str=ids.split(",");
		for(String id : str){
			try {
				pingjiamapper.deleteByPrimaryKey(Integer.parseInt(id));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}
