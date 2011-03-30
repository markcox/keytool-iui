/*
 *
 * Copyright (c) 2001-2008 RagingCat Project.
 * LGPL License.
 * http://code.google.com/p/keytool-iui/
 *
 * This software is the confidential and proprietary information of RagingCat Project.
 * You shall not disclose such confidential information and shall use it only in
 * accordance with the terms of RagingCat Project's license agreement.
 *
 * THE SOFTWARE IS PROVIDED AND LICENSED "AS IS" WITHOUT WARRANTY OF ANY KIND,
 * EITHER EXPRESS OR IMPLIED, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. 
 *
 * LICENSE FOR THE SOFTWARE DOES NOT INCLUDE ANY CONSIDERATION FOR ASSUMPTION OF RISK
 * BY KEYTOOL IUI PROJECT, AND KEYTOOL IUI PROJECT DISCLAIMS ANY AND ALL LIABILITY FOR INCIDENTAL
 * OR CONSEQUENTIAL DAMAGES ARISING OUT OF THE USE OR OPERATION OF OR INABILITY
 * TO USE THE SOFTWARE, EVEN IF KEYTOOL IUI PROJECT HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES. 
 *
 */
 
 
package com.google.code.p.keytooliui.ktl.swing.panel;

/**
    "Ktl" means Keytool


    known subclasses:
  
    . P??
**/

import java.io.File;
import com.google.code.p.keytooliui.ktl.util.jarsigner.UtilKstJks;
import com.google.code.p.keytooliui.shared.lang.*;
import com.google.code.p.keytooliui.shared.swing.panel.*;
import com.google.code.p.keytooliui.shared.swing.button.*;

import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.*;

import java.awt.*;

abstract public class PTabUICmdKtlKstOpenCCaAbs extends PTabUICmdKtlKstOpenAbs 
{
    
    // ------
    // PUBLIC
    
    public void insertUpdate(DocumentEvent evtDocument)
    {
        String strMethod = "insertUpdate(evtDocument)";
        
        Document doc = evtDocument.getDocument();
        
        if (doc == null)
            MySystem.s_printOutExit(this, strMethod, "nil doc");
            
        Object objPropVal = doc.getProperty(com.google.code.p.keytooliui.shared.swing.textfield.TFAbstract.f_s_strDocPropKey);
        
        if (objPropVal == null)
            MySystem.s_printOutExit(this, strMethod, "nil objPropVal");
            
        if (! (objPropVal instanceof String))
            MySystem.s_printOutExit(this, strMethod, "! (objPropVal instanceof String)");
            
        String strPropVal = (String) objPropVal;
        
        if (strPropVal == null)
            MySystem.s_printOutExit(this, strMethod, "nil strPropVal");
        
        // ----
        
        int intLength = doc.getLength();
        
        if (intLength == 0)
            MySystem.s_printOutExit(this, strMethod, "intLength == 0");
            
        String strText = null;
        
        try
        {
            strText = doc.getText(0, intLength);
        }
            
        catch(BadLocationException excBadLocation)
        {
            excBadLocation.printStackTrace();
            MySystem.s_printOutExit(this, strMethod, "excBadLocation caught");
        }
        
        // --------
      
        // input
        
        if (strPropVal.compareTo(this._strPropValFileIO) == 0)
        {
            this._strPathAbsFileIO_ = strText;
            _updateActionButtonDataChanged(true);
            return;
        }
        
        if (strPropVal.compareTo(PSelBtnTfdFileOpenKst.f_s_strDocPropVal) == 0)
        {
            super._strPathAbsKst_ = strText;
            _updateActionButtonDataChanged(true);
            return;
        }
        
        if (strPropVal.compareTo(PSelBtnTfdPasswdXlsKstAny.f_s_strDocPropVal) == 0)
        {
            super._strPasswdKst_ = strText;
            //_updateActionButtonDataChanged(true);
            return;
        }
        
        // ------------
        MySystem.s_printOutExit(this, strMethod, "uncaught strPropVal, strPropVal=" + strPropVal);
    }
    
    public void removeUpdate(DocumentEvent evtDocument)
    {
        String strMethod = "removeUpdate(evtDocument)";
  
        Document doc = evtDocument.getDocument();
        
        if (doc == null)
            MySystem.s_printOutExit(this, strMethod, "nil doc");
            
        Object objPropVal = doc.getProperty(com.google.code.p.keytooliui.shared.swing.textfield.TFAbstract.f_s_strDocPropKey);
        
        if (objPropVal == null)
            MySystem.s_printOutExit(this, strMethod, "nil objPropVal");
            
        if (! (objPropVal instanceof String))
            MySystem.s_printOutExit(this, strMethod, "! (objPropVal instanceof String)");
            
        String strPropVal = (String) objPropVal;
        
        if (strPropVal == null)
            MySystem.s_printOutExit(this, strMethod, "nil strPropVal");
        
        // --------
        
        
        if (strPropVal.compareTo(this._strPropValFileIO) == 0)
        {
            this._strPathAbsFileIO_ = null;
            _updateActionButtonDataChanged(false);
            return;
        }

        
        if (strPropVal.compareTo(PSelBtnTfdFileOpenKst.f_s_strDocPropVal) == 0)
        {
            super._strPathAbsKst_ = null;
            _updateActionButtonDataChanged(false);
            return;
        }
        
        if (strPropVal.compareTo(PSelBtnTfdPasswdXlsKstAny.f_s_strDocPropVal) == 0)
        {
            super._strPasswdKst_ = null;
            //_updateActionButtonDataChanged(false);
            return;
        }

        // -------
        
        MySystem.s_printOutExit(this, strMethod, "uncaught strPropVal, strPropVal=" + strPropVal);
    }
    
    public void destroy()
    {
        super.destroy();
        
        if (this._pnlSelectFileIO_ != null)
        {
            this._pnlSelectFileIO_.destroy();
            this._pnlSelectFileIO_ = null;
        }
    }
    
    public boolean init()
    {
        String strMethod = "init()";
        
        if (! super.init())
        {
            MySystem.s_printOutError(this, strMethod, "failed");
            return false;
        }
        
        
        if (this._pnlSelectFileIO_ == null)
        {
            MySystem.s_printOutError(this, strMethod, "nil this._pnlSelectFileIO_");
            return false;
        }
        
        if (! this._pnlSelectFileIO_.init())
        {
            MySystem.s_printOutError(this, strMethod, "failed");
            return false;
        }
        
        
        
        // alignment
        
        java.util.Vector<PSelAbs> vecPanel = new java.util.Vector<PSelAbs>();
        
        
        Component[] cmps = null;
        
        try
        {
            cmps = super._pnlInput_.getComponents();
            
            for (int i=0; i<cmps.length; i++)
            {
                PSelAbs pnlCur = (PSelAbs) cmps[i];
                vecPanel.add(pnlCur);
            }
            
             cmps = super._pnlOutput_.getComponents();
            
            for (int i=0; i<cmps.length; i++)
            {
                PSelAbs pnlCur = (PSelAbs) cmps[i];
                vecPanel.add(pnlCur);
            }
        
        }
        
        catch(ClassCastException excClassCast)
        {
            excClassCast.printStackTrace();
            MySystem.s_printOutError(this, strMethod, "excClassCast caught, DEV ERROR");
            return false;
        }
        
        if (! PSelAbs.s_alignLabels(vecPanel))
        {
            MySystem.s_printOutError(this, strMethod, "failed");
            return false;
        }
        
        // assign CACERTS path to keystore's related textfield, then disable buttonOpen
        
        File fleKstTcrSys = UtilKstJks.s_getFileKstCertsTrustCASys();
        
        if (fleKstTcrSys == null)
        {
            // error
            return false;
            
        }
        
        super._pnlSelectFileKst_.getTextField().setText(fleKstTcrSys.getAbsolutePath());
        super._pnlSelectFileKst_.setEnabledSelect(false);
        super._pnlSelectFileKst_.setSelectedValue(true);
        
        
        // ---
        return true;
    }
    
    // ---------
    // PROTECTED   
    

    
    // either cert (import) or csr (request), created in subclasses
    protected PSelAbs _pnlSelectFileIO_ = null;
    
    // either cert (import) or csr (request), created in subclasses
    protected String _strPathAbsFileIO_ = null;
     
    protected PTabUICmdKtlKstOpenCCaAbs(
        String strHelpID,
        Frame frmOwner,
        String strTitleAppli,
        String strPropValFileIO // eg: select_file_csr
        )
    {
        super(
            "Root CA certs store password:", // MEMO: default: "changeit
            strHelpID, 
            frmOwner, 
            strTitleAppli,
            "Root CA certs store file:",
            true, // blnAllowTypeJks
            false, // blnAllowTypeJceks
            false, // blnAllowTypePkcs12 ==> ?allowed for CSR or cert reply?
            false, // blnAllowTypeBks ==> allowed for CSR or cert reply
            false // blnAllowTypeUber ==> allowed for CSR or cert reply
            );
            
        this._strPropValFileIO = strPropValFileIO;
    }
    
    // -------
    // PRIVATE
    
    private String _strPropValFileIO = null; // assigned by subclasses
    
    private void _updateActionButtonDataChanged(boolean blnFieldInserted)
    {        
        if (blnFieldInserted)
        {
            if (super._btnAction_.isEnabled())
                return;
            
            
            
            if (this._strPathAbsFileIO_ == null)
                return;
                
            if (super._strPathAbsKst_ == null)
                return;
                
            // --
            super._btnAction_.setEnabled(true);
            return;
        }
        
        else
        {
            if (! super._btnAction_.isEnabled())
                return;
            
            
            if (this._strPathAbsFileIO_ == null)
            {
                super._btnAction_.setEnabled(false);
                return;
            }
            
            if (super._strPathAbsKst_ == null)
            {
                super._btnAction_.setEnabled(false);
                return;
            }
 
            // --
            return;
        }
    }
}
