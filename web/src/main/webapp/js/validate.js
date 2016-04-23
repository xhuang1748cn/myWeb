/**
 * 验证是否为金额
 * @param num
 * @returns
 */
function moneyCheck(num){
	return /^[0-9]+(\.[0-9]{0,2})?$/.test(num);
}

/**
 * 绑定moneyCheck keydown事件
 */
function moneyCheckKeyDown(_this) {
	var value = $(_this).val();
	if (moneyCheck(value)) {
		$(_this).attr("valitVale", value);
	}
}

/**
 * 绑定moneyCheck keyup事件
 */
function moneyCheckKeyUp(_this) {
	var value = $(_this).val();
	if (!moneyCheck(value) && value != "") {
		$(_this).val($(_this).attr("valitVale"));
	}
}

/**
 * 验证是否为正整数
 * @param num
 * @returns
 */
function positiveIntegerCheck(num){
	return /^[1-9][0-9]*$/.test(num);
}

/**
 * 绑定numberCheck keydown事件
 */
function positiveIntegerCheckKeyDown(_this) {
	var value = $(_this).val();
	if (positiveIntegerCheck(value)) {
		$(_this).attr("valitVale", value);
	}
}

/**
 * 绑定numberCheck keyup事件
 */
function positiveIntegerCheckKeyUp(_this) {
	var value = $(_this).val();
	if (!positiveIntegerCheck(value) && value != "") {
		$(_this).val($(_this).attr("valitVale"));
	}
}
