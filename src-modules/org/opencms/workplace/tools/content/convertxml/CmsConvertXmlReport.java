/*
 * File   : $Source: /alkacon/cvs/opencms/src-modules/org/opencms/workplace/tools/content/convertxml/CmsConvertXmlReport.java,v $
 * Date   : $Date: 2009/10/14 11:03:08 $
 * Version: $Revision: 1.2.2.3 $
 *
 * This library is part of OpenCms -
 * the Open Source Content Management System
 *
 * Copyright (c) 2002 - 2008 Alkacon Software GmbH (http://www.alkacon.com)
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * For further information about Alkacon Software GmbH, please see the
 * company website: http://www.alkacon.com
 *
 * For further information about OpenCms, please see the
 * project website: http://www.opencms.org
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package org.opencms.workplace.tools.content.convertxml;

import org.opencms.jsp.CmsJspActionElement;
import org.opencms.report.I_CmsReportThread;
import org.opencms.workplace.list.A_CmsListReport;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

/**
 * Provides a report for replacing html tags in xmlpages.
 * <p>
 * 
 * @author Mario Jaeger
 * 
 * @version $Revision: 1.2.2.3 $
 * 
 * @since 7.0.5
 */
public class CmsConvertXmlReport extends A_CmsListReport {

    /**
     * Public constructor with JSP action element.
     * <p>
     * 
     * @param jsp an initialized JSP action element
     */
    public CmsConvertXmlReport(CmsJspActionElement jsp) {

        super(jsp);
    }

    /**
     * Public constructor with JSP variables.
     * <p>
     * 
     * @param context the JSP page context.
     * 
     * @param req the JSP request.
     * 
     * @param res the JSP response.
     */
    public CmsConvertXmlReport(PageContext context, HttpServletRequest req, HttpServletResponse res) {

        this(new CmsJspActionElement(context, req, res));
    }

    /**
     * 
     * @see org.opencms.workplace.list.A_CmsListReport#initializeThread()
     */
    @Override
    public I_CmsReportThread initializeThread() {

        CmsConvertXmlSettings settings = (CmsConvertXmlSettings)((Map)getSettings().getDialogObject()).get(CmsConvertXmlDialog.class.getName());

        I_CmsReportThread changeThread = new CmsConvertXmlThread(getCms(), settings);

        return changeThread;
    }
}