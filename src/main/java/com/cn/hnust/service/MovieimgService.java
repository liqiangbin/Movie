package com.cn.hnust.service;
import com.cn.hnust.utils.PageBean;
import com.cn.hnust.pojo.Movieimg;
import java.util.List;
/**
 * @ClassName: MovieimgService
 * @title: MovieimgService.class
 * @author: liulangzhizi
 * @Data: 2016-11-07 10:23:26 
 * @Version: V1.0.0
 * @description:  
 */
public interface MovieimgService{
	//��ҳ��ѯ
	public PageBean findPage(int currentPage , int pageSize);
	//����id��ѯ
	public Movieimg findById(int id);
	//��ѯ����
	public List<Movieimg> findList();
	
	public List<Movieimg> findByMovieId(int movieId);
	//���
	public int insertMovieimg(Movieimg entity);
	//�޸�
	public int updateMovieimg(Movieimg entity);
	//ɾ��
	public int deleteById(int id);
	//����ɾ��
	public void deletes(String ids);
}
