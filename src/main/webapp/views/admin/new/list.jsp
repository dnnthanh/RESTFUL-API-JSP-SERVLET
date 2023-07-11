<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Danh sách bài viết</title>
  </head>

  <body>
    <div class="main-content">
      <div class="main-content-inner">
        <div class="breadcrumbs ace-save-state" id="breadcrumbs">
          <ul class="breadcrumb">
            <li>
              <i class="ace-icon fa fa-home home-icon"></i>
              <a href="${pageContext.request.contextPath}/admin/dashboards"
                >Trang chủ</a
              >
            </li>
          </ul>
        </div>
        <div class="page-content">
          <!-- <div class="row lead">
					<div class="col-xs-12">
						<select style="width: 10%" class="form-control sort-by" id="sel1">
							<option value="DESC">Title - DESC</option>
							<option value="ASC">Title - ASC</option>
						</select>
					</div>
				</div> -->
          <div class="row">
            <div class="col-xs-12">
              <div class="table-responsive">
                <button style="margin-bottom: 8px;" class="btn btn-success" title="Thêm bài viết" href="${pageContext.request.contextPath}"/admin/articles/create>
                  <i class="fa fa-plus-circle" aria-hidden="true"></i>
                  Thêm bài viết
				</button>
                <table class="table table-bordered">
                  <thead>
                    <tr>
                      <th>Title</th>
                      <th>Short description</th>
                      <th scope="2">Thao tác</th>
                    </tr>
                  </thead>
                  <tbody class="list-news-pagination"></tbody>
                </table>
                <ul id="pagination-demo" class="pagination-sm"></ul>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <script type="text/javascript">
      let page_current = 1;
      let total_page;

      loadNews();
      function loadNews() {
        API.get(`\/api/admin/articles?limit=4&page=\${page_current}`).then(
          function (response) {
            let html = "";
            let len = response.data.data.length;
            total_page = response.data.total_page;
            for (let i = 0; i < len; ++i) {
              html += loadRowNew(response.data.data[i]);
            }
            $(".list-news-pagination").html(html);

            $("#pagination-demo").twbsPagination({
              first: "First",
              prev: "Previous",
              next: "Next",
              last: "Last",
              totalPages: total_page,
              startPage: page_current,
              onPageClick: function (event, page) {
                page_current = page;
                loadNews();
              },
            });
          }
        );
      }

      function loadRowNew(item) {
        return `\<tr>
							<td>\${item.title}</td>
							<td>\${item.descriptionshort}</td>
							<td>
								<button title="Xóa bài viết" type="button" class="btn btn-danger">
									<i style="margin-right: 4px" class="fa fa-trash" aria-hidden="true"></i>Delete
								</button>
								<a title="Cập nhật bài viết" href="${pageContext.request.contextPath}/admin/articles/\${item.id}" class="btn btn-warning">
									<i style="margin-right: 4px" class="fa fa-pencil" aria-hidden="true"></i>Updated
								</a>
							</td>
						</tr>`;
      }
    </script>
  </body>
</html>
