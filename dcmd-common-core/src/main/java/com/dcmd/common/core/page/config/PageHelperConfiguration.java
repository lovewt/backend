/**
 * Copy Right Information : 数云 <br>
 * Project : 数云指挥系统 <br>
 * Description : 分页参数类<br>
 * Author : 朱彪 <br>
 * Maintainer:  <br>
 * Version : 1.0.0 <br>
 * Since : 1.0 <br>
 * Date : 2018-03-20<br>
 * Update:  <br>
 */
package com.dcmd.common.core.page.config;

import java.util.Properties;

import com.github.pagehelper.PageHelper;

public class PageHelperConfiguration {

	public PageHelper pageHelper() {
		PageHelper pageHelper = new PageHelper();
		Properties p = new Properties();

		// #设置数据库 4.0.0 以后可以不设置 dialect=oracle
		// 设置为true时，会将RowBounds第一个参数offset当成pageNum页码使用
		p.setProperty("offsetAsPageNum", "true");
		// 设置为true时，使用RowBounds分页会进行count查询
		p.setProperty("rowBoundsWithCount", "true");
		p.setProperty("reasonable", "true");
		// 通过设置pageSize=0或者RowBounds.limit = 0就会查询出全部的结果。
		p.setProperty("pageSizeZero", "true");
		pageHelper.setProperties(p);
		return pageHelper;
	}
}