package com.cn.hnust.service;
import com.cn.hnust.utils.PageBean;
import com.cn.hnust.pojo.Country;
import java.util.List;
/**
 * @ClassName: CountryService
 * @title: CountryService.class
 * @author: liulangzhizi
 * @Data: 2016-11-07 10:23:26 
 * @Version: V1.0.0
 * @description:  
 */
public interface CountryService{
	//��ҳ��ѯ
	public PageBean findPage(int currentPage , int pageSize);
	//����id��ѯ
	public Country findById(int id);
	//��ѯ����
	public List<Country> findList();
	//���
	public int insertCountry(Country entity);
	//�޸�
	public int updateCountry(Country entity);
	//ɾ��
	public int deleteById(int id);
	//����ɾ��
	public void deletes(String ids);
}
