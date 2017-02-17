package com.cn.hnust.service;
import com.cn.hnust.utils.PageBean;
import com.cn.hnust.pojo.Pingjia;
import java.util.List;
/**
 * @ClassName: PingjiaService
 * @title: PingjiaService.class
 * @author: liulangzhizi
 * @Data: 2016-11-07 10:23:26 
 * @Version: V1.0.0
 * @description:  
 */
public interface PingjiaService{
	//��ҳ��ѯ
	public PageBean findPage(int currentPage , int pageSize);
	//����id��ѯ
	public Pingjia findById(int id);
	//��ѯ����
	public List<Pingjia> findList();
	//���
	public int insertPingjia(Pingjia entity);
	//�޸�
	public int updatePingjia(Pingjia entity);
	//ɾ��
	public int deleteById(int id);
	//����ɾ��
	public void deletes(String ids);
}
