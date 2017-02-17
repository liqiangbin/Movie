package com.cn.hnust.service;
import com.cn.hnust.utils.PageBean;
import com.cn.hnust.pojo.Mycollection;
import java.util.List;
/**
 * @ClassName: MycollectionService
 * @title: MycollectionService.class
 * @author: liulangzhizi
 * @Data: 2016-11-07 10:23:26 
 * @Version: V1.0.0
 * @description:  
 */
public interface MycollectionService{
	//��ҳ��ѯ
	public PageBean findPage(int currentPage , int pageSize);
	//����id��ѯ
	public Mycollection findById(int id);
	
	public List<Mycollection> findByUserId(int id);
	//��ѯ����
	public List<Mycollection> findList();
	//���
	public int insertMycollection(Mycollection entity);
	//�޸�
	public int updateMycollection(Mycollection entity);
	//ɾ��
	public int deleteById(int id);
	//����ɾ��
	public void deletes(String ids);
}
