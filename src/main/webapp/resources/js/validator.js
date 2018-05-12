$(function () {
    'use strict';

    window.Validator = function (val, rule) {
        let errorMessage;
        this.is_valid = function (new_val) {
            let key;
            if (new_val !== undefined)
                val = new_val;

            if (!rule.required && !val) {
                return true;
            }

            for (key in rule) {
                if (key === 'required')
                    continue;
                let r = this['validate_' + key]();
                if (typeof r === "string") return errorMessage;
            }
            return true;
        };

        /*this.validateRequired = function () {
            let real = $.trim(val);
            return !(!real && real !== 0);
        };*/

        this.validate_max = function () {
            val = parseFloat(val);
            errorMessage="请输入一个小于"+rule.max+"的值";
            return val <= rule.max?true:errorMessage;
        };

        this.validate_min = function () {
            val = parseFloat(val);
            errorMessage="请输入一个大于"+rule.min+"的值";
            return val >= rule.min?true:errorMessage;
        };

        this.validate_minLength=function () {
            errorMessage="请输入一个长度大于等于"+rule.minLength+"的值";
            return val.length >= rule.minLength?true:errorMessage;
        };

        this.validate_maxLength=function () {
            errorMessage="请输入一个长度小于等于"+rule.maxLength+"的值";
            return val.length <= rule.maxLength?true:errorMessage;
        }
    }
    /*var validator={};
    validator.validate_max=function () {

    }*/
});
