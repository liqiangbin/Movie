package com.cn.hnust.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.MovieimgMapper;
import com.cn.hnust.pojo.Movieimg;
import com.cn.hnust.pojo.MovieimgExample;
import com.cn.hnust.pojo.MovieimgExample.Criteria;
import com.cn.hnust.service.MovieimgService;
import com.cn.hnust.utils.PageBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
/**
 * @ClassName: MovieimgServiceImpl
 * @title: MovieimgServiceImpl.class
 * @author: liulangzhizi
 * @Data: 2016��-11��-07�� 10:23:26 
 * @Version: V1.0.0
 * @description:  
 */
@Service
public class MovieimgServiceImpl implements MovieimgService {

	@Resource
	private MovieimgMapper movieimgmapper;

	//��ҳ��ѯ
	public PageBean findPage(int currentPage , int pageSize){
		PageBean pageBean = new PageBean();
		MovieimgExample example=new MovieimgExample();
		PageHelper.startPage(currentPage, pageSize);
		List<Movieimg> list = movieimgmapper.selectByExampleWithBLOBs(example);
		PageInfo<Movieimg> info = new PageInfo<Movieimg>(list);
		long total = info.getTotal();
		int totalPage = (int) ((total + pageSize - 1) / pageSize);
		pageBean.setTotalPage(totalPage);
		pageBean.setTotal(total);
		pageBean.setRows(list);
		pageBean.setCurrentPage(currentPage);
		return pageBean;
	}
	
	//����id��ѯ
	public Movieimg findById(int id){
		return movieimgmapper.selectByPrimaryKey(id);
	}
	
	//��ѯ����
	public List<Movieimg> findList(){
		MovieimgExample example=new MovieimgExample();
		return movieimgmapper.selectByExample(example);
	}
	
	//���
	public int insertMovieimg(Movieimg entity){
		return movieimgmapper.insert(entity);
	}
	
	//�޸�
	public int updateMovieimg(Movieimg entity){
		return movieimgmapper.updateByPrimaryKey(entity);
	}
	
	//ɾ��
	public int deleteById(int id){
		return movieimgmapper.deleteByPrimaryKey(id);
	}
	
	//����ɾ��
	public void deletes(String ids){
		String[] str=ids.split(",");
		for(String id : str){
			try {
				movieimgmapper.deleteByPrimaryKey(Integer.parseInt(id));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}

	@Override
	public List<Movieimg> findByMovieId(int movieId) {
		MovieimgExample example=new MovieimgExample();
		Criteria criteria = example.createCriteria();
		criteria.andMovieidEqualTo(movieId);
		return this.movieimgmapper.selectByExampleWithBLOBs(example);
	}
}
