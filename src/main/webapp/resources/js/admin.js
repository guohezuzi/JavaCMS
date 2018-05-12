$(function () {
    'use strict';

    //表单验证
    const $inputs = $('[data-rule]');
    $inputs.each(function (index, node) {
        /*解析每一个input验证规则*/
        new Input(node);
    });

    /*切换修改数据*/
    $('.default-data').click(function () {
        $(this).hide();
        $(this).next().css('display', 'flex');
    });

    $('.cancel-change').click(function () {
        $(this).parent().hide();
        $(this).parent().prev().css('display', 'block');
    });
});