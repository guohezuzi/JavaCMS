$(function () {
    /* $('#temp').click(function(){window.location.href="/music/admin"});*/
    //登录验证
    const $adminLogin = $('#admin-login-form');
    $('#login-button').click(function (e) {
        e.preventDefault();
        let name = $('#admin-name').val();
        let password = $('#admin-password').val();
        $.post("/loginVerify",
            {
                name: name,
                password: password
            },
            function (data) {
                let isLogin = data.isLogin;
                if (isLogin) {
                    $adminLogin.submit();
                }
                else {
                    $(".error-message").hide();
                    const errorType = data.error_type;
                    if (errorType === 'admin_name') {
                        let $adminNameErr = $('#admin-name-err');
                        $adminNameErr.text(data.error_message);
                        $adminNameErr.show();
                    }
                    else if (errorType === 'admin_password') {
                        let $adminPassErr = $('#admin-password-err');
                        $adminPassErr.text(data.error_message);
                        $adminPassErr.show();
                    }
                }
            }
        )

    });

    //音乐卡片效果

    $(document).on('click','.play',function () {
        const bkg_url = $(this).css('background-image').split("/").pop();
        const icon = bkg_url.split(".")[0];
        if (icon === "play-icon") {
            $(".play").css({
                'background-image': 'url(/resources/img/play-icon.png)',
                'display': 'none'
            });
            $(this).css(
                'background-image', 'url(/resources/img/play-pause.png)'
            );
            const player = $('.player');
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

    $(document).on('mouseover', ".music-card", function () {
        //console.log($(this).children("div.play").first().css('display'));
        $(this).children("div.play").first().show();
        //console.log($(this).children("div.play").first().css('display'));
    });

    $(document).on('mouseout', ".music-card", function () {
        //console.log('out');
        const bkg_url = $(this).children("div.play").first().css('background-image').split("/").pop();
        const icon = bkg_url.split(".")[0];
        if (icon === "play-icon") {
            $(this).children("div.play").first().hide();
        }
    });

    //异步加载更多数据
    let page = 0;
    $('#loading').click(
        function () {
            $.get('/api/music/music.json?page=' + page++, function (data) {
                console.log(data);
                $.each(data, function (n, value) {
                    $('#loading-wrap').before(
                        '<div class="row">' +
                        '                <div class="col-sm-6">' +
                        '                    <div class="row">' +
                        '                        <div class="col-4">' +
                        '                            <div class="music-card">' +
                        '                                <div class="music-link"' +
                        '                                     style="background-image: url(' + value[0].pic_url + ') ">' +
                        '                                </div>' +
                        '                                <div class="play" data-content="' + value[0].song_url + '">' +
                        '                                </div>' +
                        '                            </div>' +
                        '                        </div>' +
                        '                        <div class="col-4">' +
                        '                            <div class="music-card">' +
                        '                                <div class="music-link"' +
                        '                                     style="background-image: url(' + value[1].pic_url + ') ">' +
                        '                                </div>' +
                        '                                <div class="play" data-content="' + value[1].song_url + '">' +
                        '                                </div>' +
                        '                            </div>' +
                        '                        </div>' +
                        '                        <div class="col-4">' +
                        '                            <div class="music-card">' +
                        '                                <div class="music-link"' +
                        '                                     style="background-image: url(' + value[2].pic_url + ') ">' +
                        '                                </div>' +
                        '                                <div class="play" data-content="' + value[2].song_url + '">' +
                        '                                </div>' +
                        '                            </div>' +
                        '                        </div>' +
                        '                    </div>' +
                        '                </div>' +
                        '                <div class="col-sm-6">' +
                        '                    <div class="row">' +
                        '                        <div class="col-4">' +
                        '                            <div class="music-card">' +
                        '                                <div class="music-link"' +
                        '                                     style="background-image: url(' + value[3].pic_url + ') ">' +
                        '                                </div>' +
                        '                                <div class="play" data-content="' + value[3].song_url + '">' +
                        '                                </div>' +
                        '                            </div>' +
                        '                        </div>' +
                        '                        <div class="col-4">' +
                        '                            <div class="music-card">' +
                        '                                <div class="music-link"' +
                        '                                     style="background-image: url(' + value[4].pic_url + ') ">' +
                        '                                </div>' +
                        '                                <div class="play" data-content="' + value[4].song_url + '">' +
                        '                                </div>' +
                        '                            </div>' +
                        '                        </div>' +
                        '                        <div class="col-4">' +
                        '                            <div class="music-card">' +
                        '                                <div class="music-link"' +
                        '                                     style="background-image: url(' + value[5].pic_url + ') ">' +
                        '                                </div>' +
                        '                                <div class="play" data-content="' + value[5].song_url + '">' +
                        '                                </div>' +
                        '                            </div>' +
                        '                        </div>' +
                        '                    </div>' +
                        '                </div>' +
                        '            </div>'
                    )
                })
            })
        }
    );

});