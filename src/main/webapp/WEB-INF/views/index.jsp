<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: guohezuzi
  Date: 18-4-16
  Time: 上午11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <link href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link rel="stylesheet" href="/resources/css/music.css" type="text/css">
</head>
<body>
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
        <div class="login-select">
            <ul class="nav nav-tabs nav-justified" role="tablist">
                <li class="nav-item"><a class="nav-link" data-toggle="tab" href="#user-login-form">用户</a></li>
                <li class="nav-item"><a class="nav-link" data-toggle="tab" href="#admin-login-form">管理员</a></li>
            </ul>
        </div>
        <div class="tab-content text-muted">
            <form id="user-login-form" class="tab-pane active" method="post">
                <div class="form-group">
                    <label>用户名:</label>
                    <input type="text" class="form-control">
                </div>
                <div class="form-group">
                    <label>密码:</label>
                    <input type="password" class="form-control">
                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-secondary btn-block" value="登录">
                    <input id="temp" type="button" class="btn btn-secondary btn-block" value="注册">
                </div>
            </form>
            <form action="<c:url value="/admin_login"/>" id="admin-login-form" class="tab-pane" method="post">
                <div class="form-group">
                    <label>管理员账户:</label>
                    <input name="name" type="text" class="form-control">
                </div>
                <div class="form-group">
                    <label>密码:</label>
                    <input name="password" type="password" class="form-control">
                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-secondary btn-block" value="登录">
                </div>
            </form>
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
                <nav class="navbar navbar-expand justify-content-center">
                    <ul class="navbar-nav">
                        <li class="nav-item"><a href="<c:url value="/index"/>" class="nav-link">音乐</a></li>
                        <li class="nav-item"><a href="#" class="nav-link">开发中...</a></li>
                        <li class="nav-item"><a href="#" class="nav-link">开发中...</a></li>
                        <li class="nav-item"><a href="#" class="nav-link">开发中...</a></li>
                    </ul>
                </nav>
            </div>
        </div>
        <c:forEach items="${songList}" var="song">
            <div class="row">
                <div class="col-sm-6">
                    <div class="row">
                        <div class="col-4">
                            <div class="music-card">
                                <div class="music-link"
                                     style="background-image: url(${song[0].pic_url}) ">
                                </div>
                                <div class="play" data-content="${song[0].song_url}">
                                </div>
                            </div>
                        </div>
                        <div class="col-4">
                            <div class="music-card">
                                <div class="music-link"
                                     style="background-image: url(${song[1].pic_url}) ">
                                </div>
                                <div class="play" data-content="${song[1].song_url}">
                                </div>
                            </div>
                        </div>
                        <div class="col-4">
                            <div class="music-card">
                                <div class="music-link"
                                     style="background-image: url(${song[2].pic_url}) ">
                                </div>
                                <div class="play" data-content="${song[2].song_url}">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="row">
                        <div class="col-4">
                            <div class="music-card">
                                <div class="music-link"
                                     style="background-image: url(${song[3].pic_url}) ">
                                </div>
                                <div class="play" data-content="${song[3].song_url}">
                                </div>
                            </div>
                        </div>
                        <div class="col-4">
                            <div class="music-card">
                                <div class="music-link"
                                     style="background-image: url(${song[4].pic_url}) ">
                                </div>
                                <div class="play" data-content="${song[4].song_url}">
                                </div>
                            </div>
                        </div>
                        <div class="col-4">
                            <div class="music-card">
                                <div class="music-link"
                                     style="background-image: url(${song[5].pic_url}) ">
                                </div>
                                <div class="play" data-content="${song[5].song_url}">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
        <div class="row">
            <div class="col"></div>
        </div>
    </div>
</div>
<div>
    <audio class="player" controls="controls">
    </audio>
</div>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script type="text/javascript">
    console.log(${isLogin});
    var $play = $('.play');
    $play.click(function () {
        var bkg_url = $(this).css('background-image').split("/").pop();
        var icon = bkg_url.split(".")[0];
        if (icon === "play-icon") {
            $(".play").css({
                'background-image': 'url(/resources/img/play-icon.png)',
                'display': 'none'
            });
            $(this).css(
                'background-image', 'url(/resources/img/play-pause.png)'
            );
            var player = $('.player');
            player.attr('src', $(this).attr('data-content'));
            player.get(0).play();
        }
        else {
            $(this).css({
                'background-image': 'url(/resources/img/play-icon.png)'
            });
            $('.player').get(0).pause();
        }
    });
    var $music = $('.music-card');
    $music.mouseover(function () {
        //console.log($(this).children("div.play").first().css('display'));
        $(this).children("div.play").first().css('display', 'block');
        //console.log($(this).children("div.play").first().css('display'));
    });
    $music.mouseout(function () {
        //console.log('out');
        var bkg_url = $(this).children("div.play").first().css('background-image').split("/").pop();
        var icon = bkg_url.split(".")[0];
        if (icon === "play-icon") {
            $(this).children("div.play").first().css('display', 'none');
        }
    });

</script>

</body>
</html>