$(function () {
   /* $('#temp').click(function(){window.location.href="/music/admin"});*/
    //登录验证
    const $adminLogin = $('#admin-login-form');
    $('#login-button').click(function (e) {
        e.preventDefault();
        let name=$('#admin-name').val();
        let password=$('#admin-password').val();
        $.post("/loginVerify",
            {
                name:name,
                password:password
            },
            function (data) {
                let isLogin=data.isLogin;
                if(isLogin){
                   $adminLogin.submit();
                }
                else {
                    $(".error-message").hide();
                    const errorType = data.error_type;
                    if(errorType==='admin_name'){
                        let $adminNameErr = $('#admin-name-err');
                        $adminNameErr.text(data.error_message);
                        $adminNameErr.show();
                    }
                    else if(errorType==='admin_password'){
                        let $adminPassErr = $('#admin-password-err');
                        $adminPassErr.text(data.error_message);
                        $adminPassErr.show();
                    }
                }
            }
        )

    });



    let page = 0;
    $('#test').click(
        function () {
            $.get('/music/loading?page=' + page++, function (data, status) {
                console.log(data[0][0].name);
                console.log(status);
            })
        }
    );

    //音乐卡片效果
    const $play = $('.play');
    $play.click(function () {
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
    const $music = $('.music-card');
    $music.mouseover(function () {
        //console.log($(this).children("div.play").first().css('display'));
        $(this).children("div.play").first().show();
        //console.log($(this).children("div.play").first().css('display'));
    });
    $music.mouseout(function () {
        //console.log('out');
        const bkg_url = $(this).children("div.play").first().css('background-image').split("/").pop();
        const icon = bkg_url.split(".")[0];
        if (icon === "play-icon") {
            $(this).children("div.play").first().hide();
        }
    });
});