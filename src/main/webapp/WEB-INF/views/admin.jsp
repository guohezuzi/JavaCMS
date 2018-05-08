<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: guohezuzi
  Date: 18-4-21
  Time: 下午3:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="utf-8">
    <title>管理员界面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="apple-touch-icon" href="">
    <link rel="shortcut icon" href="" type="image/x-icon">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css" rel="stylesheet" media="screen">

    <!-- Link to your CSS file -->
    <%--服务器端通过nginx代理可以使用绝对路径--%>
    <link rel="stylesheet" href="/resources/css/admin.css" type="text/css">
</head>

<body>

<!-- Start coding here -->
<div id="left-bar" class="bg-dark">
    <div class="container-fluid">
        <div class="row">
            <div class="col">
                <a href="<c:url value="/index"/>">
                    <div id="logo" class="col text-center">
                        Logo
                    </div>
                </a>
            </div>
        </div>
        <div class="manage-select">
            <ul class="nav nav-pills flex-column">
                <li class="nav-item"><a class="nav-link active" href="#">音乐管理</a></li>
                <li class="nav-item"><a class="nav-link" href="#">开发中...</a></li>
                <li class="nav-item"><a class="nav-link" href="#">开发中...</a></li>
                <li class="nav-item"><a class="nav-link" href="#">开发中...</a></li>
            </ul>
        </div>
    </div>
    <%--
        <div class="bottom">balabalabala...</div>
    --%>
</div>
<div id="container-content">
    <div class="container">
        <div class="row">
            <div class="col">
                <h1 class="justify-content-center">管理员界面</h1>
            </div>
        </div>

        <!--<div class="sql-select">
            <ul class="nav nav-tabs nav-justified">
                <li class="nav-item"><a href="#browse" data-toggle="tab" class="nav-link">所有歌曲</a></li>
                <li class="nav-item"><a href="#" data-toggle="tab" class="nav-link">增加歌曲</a></li>
                <li class="nav-item"><a href="#" data-toggle="tab" class="nav-link">修改歌曲</a></li>
                <li class="nav-item"><a href="#" data-toggle="tab" class="nav-link">查</a></li>
            </ul>
        </div>-->
        <div class="row">
            <div class="col">
                <ul class="nav justify-content-between">
                    <li class="nav-item">
                        <div class="btn-group">
                            <a href="<c:url value="/music/admin"/>" class="btn btn-primary">显示所有歌曲</a>
                            <a href="#add" class="btn btn-info" data-toggle="collapse">增加歌曲</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <form action="<c:url value="/music/m_search_song"/>" class="form-group form-inline">
                            <input type="search" name="search" class="form-control" placeholder="搜点什么吧...">
                            <select class="form-control" name="select" id="search-select" title="类型">
                                <option value="name">歌名</option>
                                <option value="singer">歌手</option>
                            </select>
                            <input type="submit" class="form-control" value="搜索">
                        </form>
                    </li>
                </ul>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <form action="<c:url value="/music/m_add_song"/>" class="form collapse" method="post" id="add"
                      enctype="multipart/form-data">
                    <div class="form-group">
                        <label>歌名:</label>
                        <input class="form-control bg-secondary" name="name" type="text" size="5">

                        <label>歌手:</label>
                        <input class="form-control bg-secondary" name="singer" type="text" size="5">

                        <label>作曲: </label>
                        <input class="form-control bg-secondary" name="author" type="text" size="5">

                        <label>专辑:</label>
                        <input class="form-control bg-secondary" name="album" type="text" size="5">

                        <label>发行日期:</label>
                        <input class="form-control bg-secondary" name="issue_date" type="date">

                        <label>上传封面:</label>
                        <input class="form-control bg-secondary" name="song_pic" type="file" accept="image/jpeg"
                               size="2">
                        上传歌曲:<input class="form-control bg-secondary" name="song_file" type="file" accept="audio/mpeg"
                                    size="2">
                        <input type="submit" class="form-control btn-secondary" value="增加">
                    </div>
                </form>
            </div>
        </div>
        <div class="table-responsive-xl">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">歌名</th>
                    <th scope="col">歌手</th>
                    <th scope="col">作曲</th>
                    <th scope="col">专辑</th>
                    <th scope="col">发行日期</th>
                    <th scope="col">#</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${songList}" var="song">
                    <tr>
                        <form action="<c:url value="/music/m_upd_song"/>" method="get">
                            <th scope="row">
                                <p>${song.id}</p>
                                <input type="text" name="id" value="${song.id}" readonly style="display: none;"
                                       placeholder="id">
                            </th>
                            <td>
                                <p class="default-data">${song.name}</p>
                                <div class="change-input">
                                    <input name="name" class="form-control" type="text" size="2"
                                           placeholder="${song.name}">
                                    <input class="cancel-change btn-sm btn-secondary" type="button" value="&times;">
                                </div>
                            </td>
                            <td>
                                <p class="default-data">${song.singer}</p>
                                <div class="change-input">
                                    <input name="singer" class="form-control" type="text" size="2"
                                           placeholder="${song.singer}">
                                    <input class="cancel-change btn-sm btn-secondary" type="button" value="&times;">
                                </div>
                            </td>
                            <td>
                                <p class="default-data">${song.author}</p>
                                <div class="change-input">
                                    <input name="author" class="form-control" type="text" size="2"
                                           placeholder="${song.author}">
                                    <input class="cancel-change btn-sm btn-secondary" type="button" value="&times;">
                                </div>
                            </td>
                            <td>
                                <p class="default-data">${song.album}</p>
                                <div class="change-input">
                                    <input name="album" class="form-control" type="text" size="2"
                                           placeholder="${song.album}">
                                    <input class="cancel-change btn-sm btn-secondary" type="button" value="&times;">
                                </div>
                            </td>
                            <td>
                                <p class="default-data">${song.issue_date}</p>

                                <div class="change-input">
                                    <input name="issue_date" class="form-control-sm" type="date" size="2"
                                           placeholder="${song.issue_date}">
                                    <input class="cancel-change btn-sm btn-secondary" type="button" value="&times;">
                                </div>
                            </td>
                            <td>
                                <input name="update" class="btn btn-info btn-sm" type="submit" value="更改">
                                <input name="delete" class="btn btn-danger btn-sm" type="submit" value="删除">
                            </td>
                        </form>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</div>
<!-- <div id="footer">
    <audio class="player" controls="controls" autoplay="autoplay">
</audio>
</div>-->

<!-- Coding End -->

<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.bootcss.com/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script>
    $(document).ready(function () {
        /*切换修改数据*/
        $('.default-data').click(function () {
            $(this).css('display', 'none');
            $(this).next().css("display", "flex");
        });

        $('.cancel-change').click(function () {
            $(this).parent().css('display', 'none');
            $(this).parent().prev().css('display', 'block');
        });
    })

</script>

</body>

</html>

