package com.laptrinhjavaweb.service.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.INewDAO;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.service.INewService;

import com.laptrinhjavaweb.pagingandsorting.PagingAndSorting;

public class NewService implements INewService {

	@Inject
	private INewDAO newDao;

	@Override
	public List<NewModel> findAllByCategoryId(Long categoryId) {
		return this.newDao.findAllByCategoryId(categoryId);
	}

	@Override
	public NewModel save(NewModel newModel) {
		newModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		// ĐĂNG NHẬP -> Tạo bài viết -> Lấy tên (DO CHƯA ĐĂNG NHẬP LÊN ĐỂ EMPTY)
		newModel.setCreatedBy("");
		Long id = newDao.save(newModel);
		return this.newDao.findById(id);
	}

	@Override
	public NewModel update(NewModel updateNew) {
		NewModel oldNew = this.newDao.findById(updateNew.getId());
		updateNew.setCreatedBy(oldNew.getCreatedBy());
		updateNew.setCreatedDate(oldNew.getCreatedDate());
		updateNew.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		// ĐĂNG NHẬP -> Sửa bài viết -> Lấy tên (DO CHƯA ĐĂNG NHẬP LÊN ĐỂ EMPTY)
		updateNew.setModifiedBy("");
		this.newDao.update(updateNew);
		return updateNew;
	}

	@Override
	public void delete(Long[] ids) {
		for (int i = 0; i < ids.length; i++) {
//			Xóa delete commnet
			this.newDao.delete(ids[i]);
		}
	}	

	@Override
	public Map<String, Object> findAll(PagingAndSorting ps) {
		List<NewModel> list = this.newDao.findAll(ps);
		Map<String, Object> mapData = new HashMap<>();
		mapData.put("data", list);
		mapData.put("page_current", ps.getPage());
		int totalPage = (int) Math.ceil((double) this.newDao.totalCount() / ps.getLimit());
		mapData.put("total_page", totalPage);
		return mapData;
	}
}
