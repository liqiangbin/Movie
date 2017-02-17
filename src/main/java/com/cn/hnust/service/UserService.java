package com.cn.hnust.service;
import java.util.List;

import com.cn.hnust.pojo.User;
import com.cn.hnust.utils.PageBean;
/**
 * @ClassName: UserService
 * @title: UserService.class
 * @author: liulangzhizi
 * @Data: 2016-11-07 10:23:26 
 * @Version: V1.0.0
 * @description:  
 */
public interface UserService{
	//��ҳ��ѯ
	public PageBean findPage(int currentPage , int pageSize);
	//����id��ѯ
	public User findById(int id);
	//��ѯ����
	public List<User> findList(boolean hasParams,String ParamName,String ParamValue);
	//���
	public int insertUser(User entity);
	//�޸�
	public int updateUser(User entity);
	//ɾ��
	public int deleteById(int id);
	//����ɾ��
	public void deletes(String ids);
}
