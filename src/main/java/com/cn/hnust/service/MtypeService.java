package com.cn.hnust.service;
import com.cn.hnust.utils.PageBean;
import com.cn.hnust.pojo.Mtype;
import java.util.List;
/**
 * @ClassName: MtypeService
 * @title: MtypeService.class
 * @author: liulangzhizi
 * @Data: 2016-11-07 10:23:26 
 * @Version: V1.0.0
 * @description:  
 */
public interface MtypeService{
	//��ҳ��ѯ
	public PageBean findPage(int currentPage , int pageSize);
	//����id��ѯ
	public Mtype findById(int id);
	//��ѯ����
	public List<Mtype> findList();
	//���
	public int insertMtype(Mtype entity);
	//�޸�
	public int updateMtype(Mtype entity);
	//ɾ��
	public int deleteById(int id);
	//����ɾ��
	public void deletes(String ids);
}
