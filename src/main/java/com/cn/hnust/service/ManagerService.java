package com.cn.hnust.service;
import java.util.List;

import com.cn.hnust.pojo.Manager;
import com.cn.hnust.utils.PageBean;
/**
 * @ClassName: ManagerService
 * @title: ManagerService.class
 * @author: liulangzhizi
 * @Data: 2016-11-07 10:23:26 
 * @Version: V1.0.0
 * @description:  
 */
public interface ManagerService{
	//��ҳ��ѯ
	public PageBean findPage(int currentPage , int pageSize);
	//����id��ѯ
	public Manager findById(int id);
	//��ѯ����
	public List<Manager> findList();
	//���
	public int insertManager(Manager entity);
	//�޸�
	public int updateManager(Manager entity);
	//ɾ��
	public int deleteById(int id);
	//����ɾ��
	public void deletes(String ids);
	
	public Manager checkLogin(String name, String password);
}
