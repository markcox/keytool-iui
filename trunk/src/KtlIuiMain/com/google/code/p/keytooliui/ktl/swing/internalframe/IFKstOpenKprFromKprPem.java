package com.google.code.p.keytooliui.ktl.swing.internalframe;

import java.awt.Frame;
import com.google.code.p.keytooliui.ktl.swing.panel.*;


public class IFKstOpenKprFromKprPem extends IFAbs
{
    public IFKstOpenKprFromKprPem(Frame frmParent, String strTitleAppli)
    {
        super();
        
        super._pnl_ = new PTabUICmdKtlKstOpenKprFromKprPem(frmParent, strTitleAppli);
        setTitle(PTabUICmdKtlKstOpenKprFromKprPem.STR_TITLETASK);
    }

}

