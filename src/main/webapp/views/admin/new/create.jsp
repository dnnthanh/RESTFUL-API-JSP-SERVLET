<%-- Created by IntelliJ IDEA. User: Ngọc Thanh Date: 7/12/2023 Time: 1:04 PM To
change this template use File | Settings | File Templates. --%>
<%@ page
        language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Thêm bài viết</title>
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
            <div class="row">
                <div class="col-xs-12">
                    <form id="form-submit-article" method="POST">
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"
                            >Thể loại</label
                            >
                            <div class="col-sm-9">
                                <select
                                        class="form-control"
                                        id="categoryId"
                                        name="categoryId"
                                >
                                    <option value="">1</option>
                                    <option value="">2</option>
                                    <option value="">3</option>
                                    <option value="">4</option>
                                </select>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"
                            >Tiêu đề</label
                            >
                            <div class="col-sm-9">
                                <input
                                        type="text"
                                        class="form-control"
                                        id="title"
                                        name="title"
                                        value=""
                                />
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"
                            >Hình đại diện</label
                            >
                            <div class="col-sm-9">
                                <input
                                        type="text"
                                        class="form-control"
                                        id="thumbnail"
                                        name="thumbnail"
                                        value=""
                                />
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"
                            >Mô tả ngắn</label
                            >
                            <div class="col-sm-9">
                                <input
                                        type="text"
                                        class="form-control"
                                        id="descriptionshort"
                                        name="descriptionshort"
                                        value=""
                                />
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"
                            >Nội dung</label
                            >
                            <div class="col-sm-9">
                    <textarea
                            rows=""
                            cols=""
                            id="content"
                            name="content"
                            style="width: 820px; height: 175px"
                    ></textarea>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <button class="btn btn-success btn-add-article">
                                Thêm bài viết
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    let cke = "";
    $(document).ready(function () {
        cke = CKEDITOR.replace("content");
    });

    API.get("/api-categories").then(function (reponse) {
        let len = reponse.data.length;
        let html = `<div class="list-group list-category">`;

        for (let i = 0; i < len; ++i) {
            html += getCategory(reponse.data[i]);
        }
        html += `</div>`;
        $("#categoryId").html(html);
    });

    function getCategory(item) {
        return `<option value="\${item.id}">\${item.name}</option>`;
    }

    $(".btn-add-article").click((event) => {
        event.preventDefault();
        let data = {};
        let dataFromForm = $("#form-submit-article").serializeArray();
        $.each(dataFromForm, function (index, value) {
            let propertyName = value.name;
            let propertyValue = value.value;
            if (propertyName === "content") {
                propertyValue = CKEDITOR.instances.content.getData();
            }
            data[propertyName] = propertyValue;
        });
        addArticles(data);
    });

    function addArticles(item) {
        $.ajax({
            url: "${pageContext.request.contextPath}/api/admin/articles",
            type: "POST",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(item),
            dataType: "JSON",
            success: function (response, status) {
                alert("Thêm bài viết thành công");
                console.log(response + " - " + status);
            },
            error: function (response) {
                alert("Thêm bài viết thất bại");
                console.log(response);
            }
        });
    }
</script>
</body>
</html>
