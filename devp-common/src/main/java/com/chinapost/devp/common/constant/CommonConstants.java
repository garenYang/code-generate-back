package com.chinapost.devp.common.constant;



public interface CommonConstants {

	/**
	 * 菜单
	 */
	String MENU = "0";

	/**
	 * 编码
	 */
	String UTF8 = "UTF-8";

	/**
	 * JSON 资源
	 */
	String CONTENT_TYPE = "application/json; charset=utf-8";

	/**
	 * 前端工程名
	 */
	String FRONT_END_PROJECT = "cpms-ui";

	/**
	 * 后端工程名
	 */
	String BACK_END_PROJECT = "post";

	/**
	 * 成功标记
	 */
	Integer SUCCESS = 1;
	/**
	 * 失败标记
	 */
	Integer FAIL = 0;

	/**
	 * 成功标记
	 */
	String STR_SUCCESS = "1";
	/**
	 * 失败标记
	 */
	String STR_FAIL = "0";
	/**
	 * 验证码前缀
	 */
	String DEFAULT_CODE_KEY = "DEFAULT_CODE_KEY_";


	/**
	 *
	 */
	String SWAGGER_API_URI = "/v2/api-docs";

	String SPRING_PROFILE_TEST = "test";
	String SPRING_PROFILE_DEVELOPMENT = "dev";
	String SPRING_PROFILE_APP = "prod";
	String SPRING_PROFILE_PRODUCTION = "prod";


	// 对/错
	String SYSTEM_TRUE = "true";
	String SYSTEM_FALSE = "false";
	// 是/否
	Integer YES = 1;
	Integer NO = 0;
	// 是/否
	String STR_YES = "1";
	String STR_NO = "0";


	String TYPE_STRING = "String";
	String TYPE_INTEGER = "Integer";
	String TYPE_INT = "int";
	String TYPE_LONG = "Long";
	String TYPE_SHORT = "Short";
	String TYPE_FLOAT = "Float";
	String TYPE_DOUBLE = "Double";
	String TYPE_DATE = "Date";


	String CONDITION_EQ = "eq";
	String CONDITION_SQL_EQ = "=";
	String CONDITION_NE = "ne";
	String CONDITION_SQL_NE = "!=";
	String CONDITION_BETWEEN = "between";
	String CONDITION_IN = "in";
	String CONDITION_NOTIN = "not in";
	String CONDITION_EXIST = "exist";
	String CONDITION_NOTEXIST = "notexist";
	String CONDITION_GE = "ge";
	String CONDITION_SQL_GE = ">=";
	String CONDITION_GT = "gt";
	String CONDITION_SQL_GT = ">";
	String CONDITION_LE = "le";
	String CONDITION_SQL_LE = "<=";
	String CONDITION_LT = "lt";
	String CONDITION_SQL_LT = "<";
	String CONDITION_LIKE = "like";
	String CONDITION_ILIKE = "ilike";
	String CONDITION_QUERY = "query";
	String CONDITION_EQPROPERTY = "eqproperty";
	String CONDITION_NEPROPERTY = "neproperty";
	String CONDITION_GEPROPERTY = "geproperty";
	String CONDITION_GTPROPERTY = "gtproperty";
	String CONDITION_LEPROPERTY = "leproperty";
	String CONDITION_LTPROPERTY = "ltproperty";
	String CONDITION_OR = "or";
	String CONDITION_AND = "and";
	String SORT_DESC = "desc";
	String SORT_ASC = "asc";
	String SPACE = " ";

	String ID_REGEX = "^[_',.@A-Za-z0-9-]*$";

	String URL_IDS_REGEX = "/{ids:^[_',.@A-Za-z0-9-]*$}";
	String URL_ID_REGEX = "/{id:^[_',.@A-Za-z0-9-]*$}";
	String SYSTEM = "system";


	String BASIC_ = "Basic ";
	String UNKNOWN = "unknown";


	String MYSQL_QUOTE = "`";
	String ORACLE_QUOTE = "\"";
}
