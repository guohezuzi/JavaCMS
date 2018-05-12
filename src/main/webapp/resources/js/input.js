$(function () {
    'use strict';

    window.Input = function (selector) {
        let $ele,
            rule = {
                required: true
            },
            me = this,
            $error_ele,
            validator;

        function findEle() {
            if (selector instanceof jQuery)
                $ele = selector;
            else
                $ele = $(selector);
        }

        function parseRule() {
            let rule_string = $ele.data('rule');
            if (!rule_string) return;

            const rule_arr = rule_string.split("|");
            for (let i = 0; i < rule_arr.length; i++) {
                const item_str = rule_arr[i];
                const item_arr = item_str.split(':');
                rule[item_arr[0]] = JSON.parse(item_arr[1]);
            }
        }

        this.loadValidator = function () {
            const val = this.get_val();
            validator = new Validator(val, rule);
        };

        this.get_val = function () {
            return $ele.val();
        };

        function listen() {
            $ele.blur(function () {
                //keyup或blur
                const valid = validator.is_valid(me.get_val());
                if (typeof valid === "boolean")
                    $error_ele.hide();
                else {
                    $error_ele.text(valid);
                    $error_ele.show();
                }
            })
        }

        function getErrorEle() {
            $error_ele= $(getErrorSelector());
            return $error_ele;
        }
        
        function getErrorSelector() {
            return '#'+$ele.attr('name')+'-input-error';
        }

        function init() {
            findEle();
            getErrorEle();
            parseRule();
            me.loadValidator();
            listen();
        }

        init();
    }

});