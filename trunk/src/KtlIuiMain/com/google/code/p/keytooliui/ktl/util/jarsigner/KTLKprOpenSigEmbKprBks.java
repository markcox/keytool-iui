package com.google.code.p.keytooliui.ktl.util.jarsigner;

/**

    "Kpr" for "KeyPair" (entry)

     sign XML file with (right now) SHA1withRSA or SHA1withDSA private key entry
**/

import com.google.code.p.keytooliui.ktl.swing.dialog.*;

import com.google.code.p.keytooliui.shared.lang.*;
import com.google.code.p.keytooliui.shared.swing.optionpane.*;
import com.google.code.p.keytooliui.shared.util.jarsigner.*;


// ----
import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
// --
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
// ----

import java.awt.*;
import java.io.*;
import java.util.*;

final public class KTLKprOpenSigEmbKprBks extends KTLKprOpenSigEmbKprDMAbs
{
    // ------
    // PUBLIC

    public KTLKprOpenSigEmbKprBks(
        Frame frmOwner, 
        String strTitleAppli,
        
        // input
        String strPathAbsOpenKst, // existing keystore of type Bks 
        char[] chrsPasswdOpenKst,
        
        String strPathAbsFileOpenData,
        String strPathAbsFileSaveData
        )
    {
        super(
            frmOwner, 
            strTitleAppli,
        
            // input
            strPathAbsOpenKst, // existing keystore of type Bks 
            chrsPasswdOpenKst,
        
            strPathAbsFileOpenData,
            strPathAbsFileSaveData,
         
            KTLAbs.f_s_strProviderKstBks
            );
            
    }
    
    
    // ---------
    // protected
    
    protected KeyStore _getKeystoreOpen_(File fleOpen)
    {
        return UtilKstBks.s_getKeystoreOpen(
            super._frmOwner_, 
            super._strTitleAppli_,
            fleOpen,
            super._chrsPasswdKst_);
    }
}
