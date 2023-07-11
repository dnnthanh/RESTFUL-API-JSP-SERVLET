package com.laptrinhjavaweb.dao.impl;

import java.util.List;
import java.util.Objects;

import com.laptrinhjavaweb.dao.INewDAO;
import com.laptrinhjavaweb.mapper.NewMapper;
import com.laptrinhjavaweb.model.NewModel;

import com.laptrinhjavaweb.pagingandsorting.PagingAndSorting;

public class NewDAO extends AbstractDAO<NewModel> implements INewDAO {
	@Override
	public List<NewModel> findAllByCategoryId(Long categoryId) {
		String query = "SELECT * FROM web_jsp_servlet.news WHERE categoryid = ?";
		return findAll(query, new NewMapper(), categoryId);
	}

	@Override
	public Long save(NewModel newModel) {
		StringBuilder query = new StringBuilder("INSERT INTO news(title, thumbnail, descriptionshort, ");
		query.append("content, categoryid, createdate, createdby)");
		query.append(" VALUES (?, ?, ?, ?, ?, ?, ?)");
		return insert(query.toString(), newModel.getTitle(), newModel.getThumbnail(), newModel.getDescriptionshort(),
				newModel.getContent(), newModel.getCategoryId(), newModel.getCreatedDate(), newModel.getCreatedBy());
	}

	@Override
	public NewModel findById(Long id) {
		String query = "SELECT * FROM web_jsp_servlet.news WHERE id = ?";
		List<NewModel> list = findAll(query, new NewMapper(), id);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public void update(NewModel updateNew) {
		StringBuilder query = new StringBuilder("UPDATE news SET title = ?, thumbnail = ?,");
		query.append("descriptionshort = ?, content = ?, categoryid = ?,");
		query.append("createdate = ?, createdby = ?, modifiedDate = ?, modifiedBy = ? WHERE id = ?");
		update(query.toString(), updateNew.getTitle(), updateNew.getThumbnail(), updateNew.getDescriptionshort(),
				updateNew.getContent(), updateNew.getCategoryId(), updateNew.getCreatedDate(), updateNew.getCreatedBy(),
				updateNew.getModifiedDate(), updateNew.getModifiedBy(), updateNew.getId());
		;
	}

	@Override
	public void delete(Long id) {
		String query = "DELETE FROM news WHERE id = ?";
		update(query, id);
	}

	@Override
	public int totalCount() {
		String query = "SELECT COUNT(*) FROM web_jsp_servlet.news";
		int count = totalCount(query);
		return count;
	}

	@Override
	public List<NewModel> findAll(PagingAndSorting ps) {
		StringBuffer query = new StringBuffer("SELECT *  FROM web_jsp_servlet.news");
		if (Objects.nonNull(ps.getSortName()) && Objects.nonNull(ps.getSortBy())) {
			query.append(" ORDER BY " + ps.getSortName() + " " + ps.getSortBy());
		}

		if (Objects.nonNull(ps.getLimit()) && Objects.nonNull(ps.getPage())) {
			Integer offset = (ps.getPage() - 1) * ps.getLimit();
			query.append(" LIMIT " +ps.getLimit()+ " OFFSET "+offset);			
		}
		List<NewModel> list = findAll(query.toString(), new NewMapper());
		return list;
	}
}
