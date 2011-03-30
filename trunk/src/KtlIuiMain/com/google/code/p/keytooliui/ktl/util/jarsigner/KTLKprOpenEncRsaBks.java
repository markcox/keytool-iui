package com.google.code.p.keytooliui.ktl.util.jarsigner;

/**

    "Kpr" for "KeyPair" (entry)

     encrypting file with RSA public key of private key entry
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

final public class KTLKprOpenEncRsaBks extends KTLKprOpenEncRsaDMAbs
{
    // ------
    // PUBLIC

    public KTLKprOpenEncRsaBks(
        Frame frmOwner, 
        String strTitleAppli,
        
        // input
        String strPathAbsOpenKst, // existing keystore of type Bks 
        char[] chrsPasswdOpenKst,
        
        String strPathAbsFileOpenData,
        String strPathAbsFileSaveData,
        String strInstanceCipherAlgo
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
         
            KTLAbs.f_s_strProviderKstBks,
            strInstanceCipherAlgo
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
