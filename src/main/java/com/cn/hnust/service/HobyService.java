package com.cn.hnust.service;
import com.cn.hnust.utils.PageBean;
import com.cn.hnust.pojo.Hoby;
import java.util.List;
/**
 * @ClassName: HobyService
 * @title: HobyService.class
 * @author: liulangzhizi
 * @Data: 2016-11-07 10:23:26 
 * @Version: V1.0.0
 * @description:  
 */
public interface HobyService{
	//��ҳ��ѯ
	public PageBean findPage(int currentPage , int pageSize);
	//����id��ѯ
	public Hoby findById(int id);
	//��ѯ����
	public List<Hoby> findList(int userId);
	//���
	public int insertHoby(Hoby entity);
	//�޸�
	public int updateHoby(Hoby entity);
	//ɾ��
	public int deleteById(int id);
	//����ɾ��
	public void deletes(String ids);
}
