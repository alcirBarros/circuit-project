/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2012 Ricardo Mariaca
 * http://dynamicreports.sourceforge.net
 *
 * This file is part of DynamicReports.
 *
 * DynamicReports is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * DynamicReports is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */

package net.sf.dynamicreports.test.jasper.report;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.test.jasper.AbstractJasperValueTest;

/**
 * @author Ricardo Mariaca (dynamicreports@gmail.com)
 */
public class PrintWhenExpressionTest extends AbstractJasperValueTest {

	@Override
	protected void configureReport(JasperReportBuilder rb) {
		rb.title(
			cmp.text("title1").setPrintWhenExpression(exp.value(true)),
			cmp.text("title2").setPrintWhenExpression(exp.value(false)));
	}

	@Override
	public void test() {
		super.test();

		numberOfPagesTest(1);

		elementCountTest("title.textField1", 1);
		elementValueTest("title.textField1", "title1");
		elementCountTest("title.textField2", 0);
	}
}
