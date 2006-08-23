/** @file
 
 The file is used to create, update MsaHeader of MSA file
 
 Copyright (c) 2006, Intel Corporation
 All rights reserved. This program and the accompanying materials
 are licensed and made available under the terms and conditions of the BSD License
 which accompanies this distribution.  The full text of the license may be found at
 http://opensource.org/licenses/bsd-license.php
 
 THE PROGRAM IS DISTRIBUTED UNDER THE BSD LICENSE ON AN "AS IS" BASIS,
 WITHOUT WARRANTIES OR REPRESENTATIONS OF ANY KIND, EITHER EXPRESS OR IMPLIED.
 
 **/

package org.tianocore.frameworkwizard.module.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.tianocore.ModuleDefinitionsDocument;
import org.tianocore.ModuleSurfaceAreaDocument;
import org.tianocore.ModuleTypeDef;
import org.tianocore.MsaHeaderDocument;
import org.tianocore.LicenseDocument.License;
import org.tianocore.frameworkwizard.common.DataType;
import org.tianocore.frameworkwizard.common.DataValidation;
import org.tianocore.frameworkwizard.common.EnumerationData;
import org.tianocore.frameworkwizard.common.Log;
import org.tianocore.frameworkwizard.common.Tools;
import org.tianocore.frameworkwizard.common.Identifications.OpeningModuleType;
import org.tianocore.frameworkwizard.common.ui.IInternalFrame;
import org.tianocore.frameworkwizard.common.ui.StarLabel;

/**
 The class is used to create, update MsaHeader of MSA file
 It extends IInternalFrame
 


 **/
public class MsaHeader extends IInternalFrame {

    ///
    /// Define class Serial Version UID
    ///
    private static final long serialVersionUID = -8152099582923006900L;

    //
    //Define class members
    //
    private JPanel jContentPane = null;

    private JLabel jLabelBaseName = null;

    private JTextField jTextFieldBaseName = null;

    private JLabel jLabelGuid = null;

    private JTextField jTextFieldGuid = null;

    private JLabel jLabelVersion = null;

    private JTextField jTextFieldVersion = null;

    private JButton jButtonGenerateGuid = null;

    private JLabel jLabelLicense = null;

    private JTextArea jTextAreaLicense = null;

    private JLabel jLabelCopyright = null;

    private JLabel jLabelDescription = null;

    private JTextArea jTextAreaDescription = null;

    private JLabel jLabelSpecification = null;

    private JTextField jTextFieldSpecification = null;

    private JButton jButtonOk = null;

    private JButton jButtonCancel = null;

    private JScrollPane jScrollPaneLicense = null;

    private JScrollPane jScrollPaneDescription = null;

    private JLabel jLabelAbstract = null;

    private JTextField jTextFieldAbstract = null;

    private JLabel jLabelModuleType = null;

    private JComboBox jComboBoxModuleType = null;

    private JLabel jLabelArch = null;

    private JLabel jLabelBinaryModule = null;

    private JComboBox jComboBoxBinaryModule = null;

    private JLabel jLabelOutputFileBasename = null;

    private JTextField jTextFieldOutputFileBasename = null;

    private JScrollPane jScrollPaneCopyright = null;

    private JTextArea jTextAreaCopyright = null;

    private JLabel jLabelURL = null;

    private JTextField jTextFieldURL = null;

    private JScrollPane jScrollPane = null;

    private StarLabel jStarLabel1 = null;

    private StarLabel jStarLabel2 = null;

    private StarLabel jStarLabel4 = null;

    private StarLabel jStarLabel5 = null;

    private StarLabel jStarLabel6 = null;

    private StarLabel jStarLabel7 = null;

    private StarLabel jStarLabel8 = null;

    private StarLabel jStarLabel10 = null;

    private StarLabel jStarLabel12 = null;

    private StarLabel jStarLabel13 = null;

    private StarLabel jStarLabel14 = null;

    private StarLabel jStarLabel15 = null;

    private JCheckBox jCheckBoxIa32 = null;

    private JCheckBox jCheckBoxX64 = null;

    private JCheckBox jCheckBoxIpf = null;

    private JCheckBox jCheckBoxEbc = null;

    private JCheckBox jCheckBoxArm = null;

    private JCheckBox jCheckBoxPpc = null;

    //
    // Not used for UI
    //
    private MsaHeaderDocument.MsaHeader msaHeader = null;

    private ModuleDefinitionsDocument.ModuleDefinitions md = null;

    private ModuleSurfaceAreaDocument.ModuleSurfaceArea msa = null;

    private OpeningModuleType omt = null;

    private EnumerationData ed = new EnumerationData();

    /**
     * This method initializes jCheckBoxIa32    
     *  
     * @return javax.swing.JCheckBox    
     */
    private JCheckBox getJCheckBoxIa32() {
        if (jCheckBoxIa32 == null) {
            jCheckBoxIa32 = new JCheckBox();
            jCheckBoxIa32.setBounds(new java.awt.Rectangle(160, 505, 55, 20));
            jCheckBoxIa32.setText("IA32");
            jCheckBoxIa32.setToolTipText(DataType.SUP_ARCH_LIST_HELP_TEXT);
            jCheckBoxIa32.addFocusListener(this);
        }
        return jCheckBoxIa32;
    }

    /**
     * This method initializes jCheckBoxX64 
     *  
     * @return javax.swing.JCheckBox    
     */
    private JCheckBox getJCheckBoxX64() {
        if (jCheckBoxX64 == null) {
            jCheckBoxX64 = new JCheckBox();
            jCheckBoxX64.setBounds(new java.awt.Rectangle(215, 505, 53, 20));
            jCheckBoxX64.setText("X64");
            jCheckBoxX64.setToolTipText(DataType.SUP_ARCH_LIST_HELP_TEXT);
            jCheckBoxX64.addFocusListener(this);
        }
        return jCheckBoxX64;
    }

    /**
     * This method initializes jCheckBoxIpf 
     *  
     * @return javax.swing.JCheckBox    
     */
    private JCheckBox getJCheckBoxIpf() {
        if (jCheckBoxIpf == null) {
            jCheckBoxIpf = new JCheckBox();
            jCheckBoxIpf.setBounds(new java.awt.Rectangle(270, 505, 52, 20));
            jCheckBoxIpf.setText("IPF");
            jCheckBoxIpf.setToolTipText(DataType.SUP_ARCH_LIST_HELP_TEXT);
            jCheckBoxIpf.addFocusListener(this);
        }
        return jCheckBoxIpf;
    }

    /**
     * This method initializes jCheckBoxEbc 
     *  
     * @return javax.swing.JCheckBox    
     */
    private JCheckBox getJCheckBoxEbc() {
        if (jCheckBoxEbc == null) {
            jCheckBoxEbc = new JCheckBox();
            jCheckBoxEbc.setBounds(new java.awt.Rectangle(325, 505, 53, 20));
            jCheckBoxEbc.setText("EBC");
            jCheckBoxEbc.setToolTipText(DataType.SUP_ARCH_LIST_HELP_TEXT);
            jCheckBoxEbc.addFocusListener(this);
        }
        return jCheckBoxEbc;
    }

    /**
     * This method initializes jCheckBoxArm 
     *  
     * @return javax.swing.JCheckBox    
     */
    private JCheckBox getJCheckBoxArm() {
        if (jCheckBoxArm == null) {
            jCheckBoxArm = new JCheckBox();
            jCheckBoxArm.setBounds(new java.awt.Rectangle(380, 505, 54, 20));
            jCheckBoxArm.setText("ARM");
            jCheckBoxArm.setToolTipText(DataType.SUP_ARCH_LIST_HELP_TEXT);
            jCheckBoxArm.addFocusListener(this);
        }
        return jCheckBoxArm;
    }

    /**
     * This method initializes jCheckBoxPpc 
     *  
     * @return javax.swing.JCheckBox    
     */
    private JCheckBox getJCheckBoxPpc() {
        if (jCheckBoxPpc == null) {
            jCheckBoxPpc = new JCheckBox();
            jCheckBoxPpc.setBounds(new java.awt.Rectangle(435, 505, 53, 20));
            jCheckBoxPpc.setText("PPC");
            jCheckBoxPpc.setToolTipText(DataType.SUP_ARCH_LIST_HELP_TEXT);
            jCheckBoxPpc.addFocusListener(this);
        }
        return jCheckBoxPpc;
    }

    /**
     This method initializes jTextFieldBaseName 
     
     @return javax.swing.JTextField jTextFieldBaseName
     
     **/
    private JTextField getJTextFieldBaseName() {
        if (jTextFieldBaseName == null) {
            jTextFieldBaseName = new JTextField();
            jTextFieldBaseName.setBounds(new java.awt.Rectangle(160, 10, 320, 20));
            jTextFieldBaseName.setPreferredSize(new java.awt.Dimension(320, 20));
            jTextFieldBaseName.addFocusListener(this);
            jTextFieldBaseName.setToolTipText("A brief Identifier, such as USB I/O Library, of the module");
        }
        return jTextFieldBaseName;
    }

    /**
     This method initializes jTextFieldGuid 
     
     @return javax.swing.JTextField jTextFieldGuid
     
     **/
    private JTextField getJTextFieldGuid() {
        if (jTextFieldGuid == null) {
            jTextFieldGuid = new JTextField();
            jTextFieldGuid.setPreferredSize(new java.awt.Dimension(250, 20));
            jTextFieldGuid.setLocation(new java.awt.Point(160, 60));
            jTextFieldGuid.setSize(new java.awt.Dimension(250, 20));
            jTextFieldGuid.addFocusListener(this);
            jTextFieldGuid.setToolTipText("Guaranteed Unique Identification Number, Registry Format (8-4-4-4-12)");
        }
        return jTextFieldGuid;
    }

    /**
     This method initializes jTextFieldVersion 
     
     @return javax.swing.JTextField jTextFieldVersion
     
     **/
    private JTextField getJTextFieldVersion() {
        if (jTextFieldVersion == null) {
            jTextFieldVersion = new JTextField();
            jTextFieldVersion.setPreferredSize(new java.awt.Dimension(320, 20));
            jTextFieldVersion.setLocation(new java.awt.Point(160, 85));
            jTextFieldVersion.setSize(new java.awt.Dimension(320, 20));
            jTextFieldVersion.addFocusListener(this);
            jTextFieldVersion.setToolTipText("A Version Number, 1.0, 1, 1.01, 1.0.1");
        }
        return jTextFieldVersion;
    }

    /**
     This method initializes jButtonGenerateGuid 
     
     @return javax.swing.JButton jButtonGenerateGuid
     
     **/
    private JButton getJButtonGenerateGuid() {
        if (jButtonGenerateGuid == null) {
            jButtonGenerateGuid = new JButton();
            jButtonGenerateGuid.setPreferredSize(new java.awt.Dimension(65, 20));
            jButtonGenerateGuid.setSize(new java.awt.Dimension(65, 20));
            jButtonGenerateGuid.setLocation(new java.awt.Point(415, 60));
            jButtonGenerateGuid.setText("GEN");
            jButtonGenerateGuid.addActionListener(this);
        }
        return jButtonGenerateGuid;
    }

    /**
     This method initializes jTextAreaLicense 
     
     @return javax.swing.JTextArea jTextAreaLicense
     
     **/
    private JTextArea getJTextAreaLicense() {
        if (jTextAreaLicense == null) {
            jTextAreaLicense = new JTextArea();
            jTextAreaLicense.setText("");
            jTextAreaLicense.setLineWrap(true);
            jTextAreaLicense.addFocusListener(this);
            jTextAreaLicense.setWrapStyleWord(true);
            jTextAreaLicense.setSelectionStart(0);
            jTextAreaLicense.setSelectionEnd(0);
            jTextAreaLicense.setToolTipText("The License for this Module.");
        }
        return jTextAreaLicense;
    }

    /**
     This method initializes jTextAreaDescription 
     
     @return javax.swing.JTextArea jTextAreaDescription
     
     **/
    private JTextArea getJTextAreaDescription() {
        if (jTextAreaDescription == null) {
            jTextAreaDescription = new JTextArea();
            jTextAreaDescription.setLineWrap(true);
            jTextAreaDescription.addFocusListener(this);
            jTextAreaDescription.setToolTipText("A verbose description of the module.");
            jTextAreaDescription.setWrapStyleWord(true);
            jTextAreaDescription.setSelectionStart(0);
            jTextAreaDescription.setSelectionEnd(0);
        }
        return jTextAreaDescription;
    }

    /**
     This method initializes jTextFieldSpecification 
     
     @return javax.swing.JTextField jTextFieldSpecification
     
     **/
    private JTextField getJTextFieldSpecification() {
        if (jTextFieldSpecification == null) {
            jTextFieldSpecification = new JTextField();
            jTextFieldSpecification.setPreferredSize(new java.awt.Dimension(320, 20));
            jTextFieldSpecification.setText("FRAMEWORK_BUILD_PACKAGING_SPECIFICATION   0x00000052");
            jTextFieldSpecification.setSize(new java.awt.Dimension(320, 20));
            jTextFieldSpecification.setLocation(new java.awt.Point(160, 530));
            jTextFieldSpecification.setEditable(false);
            jTextFieldSpecification.addFocusListener(this);
        }
        return jTextFieldSpecification;
    }

    /**
     This method initializes jButtonOk 
     
     @return javax.swing.JButton jButtonOk
     
     **/
    private JButton getJButtonOk() {
        if (jButtonOk == null) {
            jButtonOk = new JButton();
            jButtonOk.setText("OK");
            jButtonOk.setPreferredSize(new java.awt.Dimension(90, 20));
            jButtonOk.setBounds(new java.awt.Rectangle(390, 455, 90, 20));
            jButtonOk.addActionListener(this);
            jButtonOk.setVisible(false);
        }
        return jButtonOk;
    }

    /**
     This method initializes jButtonCancel 
     
     @return javax.swing.JButton jButtonCancel
     
     **/
    private JButton getJButtonCancel() {
        if (jButtonCancel == null) {
            jButtonCancel = new JButton();
            jButtonCancel.setText("Cancel");
            jButtonCancel.setBounds(new java.awt.Rectangle(390, 445, 90, 20));
            jButtonCancel.addActionListener(this);
            jButtonCancel.setPreferredSize(new java.awt.Dimension(90, 20));
            jButtonCancel.setVisible(false);
        }
        return jButtonCancel;
    }

    /**
     This method initializes jScrollPaneLicense 
     
     @return javax.swing.JScrollPane jScrollPaneLicense
     
     **/
    private JScrollPane getJScrollPaneLicense() {
        if (jScrollPaneLicense == null) {
            jScrollPaneLicense = new JScrollPane();
            jScrollPaneLicense.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            jScrollPaneLicense.setSize(new java.awt.Dimension(320, 120));
            jScrollPaneLicense.setLocation(new java.awt.Point(160, 305));
            jScrollPaneLicense.setViewportView(getJTextAreaLicense());
            jScrollPaneLicense.setPreferredSize(new java.awt.Dimension(320, 120));
        }
        return jScrollPaneLicense;
    }

    /**
     This method initializes jScrollPaneDescription 
     
     @return javax.swing.JScrollPane jScrollPaneDescription
     
     **/
    private JScrollPane getJScrollPaneDescription() {
        if (jScrollPaneDescription == null) {
            jScrollPaneDescription = new JScrollPane();
            jScrollPaneDescription.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            jScrollPaneDescription.setSize(new java.awt.Dimension(320, 120));
            jScrollPaneDescription.setLocation(new java.awt.Point(160, 135));
            jScrollPaneDescription.setViewportView(getJTextAreaDescription());
            jScrollPaneDescription.setPreferredSize(new java.awt.Dimension(320, 120));
        }
        return jScrollPaneDescription;
    }

    /**
     This method initializes jTextFieldAbstract 
     
     @return javax.swing.JTextField jTextFieldAbstract
     
     **/
    private JTextField getJTextFieldAbstract() {
        if (jTextFieldAbstract == null) {
            jTextFieldAbstract = new JTextField();
            jTextFieldAbstract.setPreferredSize(new java.awt.Dimension(320, 20));
            jTextFieldAbstract.setLocation(new java.awt.Point(160, 110));
            jTextFieldAbstract.setSize(new java.awt.Dimension(320, 20));
            jTextFieldAbstract.addFocusListener(this);
            jTextFieldAbstract.setToolTipText("A one sentence description of this module.");
        }
        return jTextFieldAbstract;
    }

    /**
     This method initializes jComboBoxModuleType 
     
     @return javax.swing.JComboBox jComboBoxModuleType
     
     **/
    private JComboBox getJComboBoxModuleType() {
        if (jComboBoxModuleType == null) {
            jComboBoxModuleType = new JComboBox();
            jComboBoxModuleType.setBounds(new java.awt.Rectangle(160, 35, 320, 20));
            jComboBoxModuleType.setPreferredSize(new java.awt.Dimension(320, 20));
            jComboBoxModuleType.addFocusListener(this);
        }
        return jComboBoxModuleType;
    }

    /**
     This method initializes jTextFieldURL	
     
     @return javax.swing.JTextField	
     
     **/
    private JTextField getJTextFieldURL() {
        if (jTextFieldURL == null) {
            jTextFieldURL = new JTextField();
            jTextFieldURL.setPreferredSize(new java.awt.Dimension(320, 20));
            jTextFieldURL.setLocation(new java.awt.Point(160, 430));
            jTextFieldURL.setSize(new java.awt.Dimension(320, 20));
            jTextFieldURL.addFocusListener(this);
            jTextFieldURL.setToolTipText("A URL for the latest version of the license.");
        }
        return jTextFieldURL;
    }

    /**
     This method initializes jScrollPane	
     
     @return javax.swing.JScrollPane	
     
     **/
    private JScrollPane getJScrollPane() {
        if (jScrollPane == null) {
            jScrollPane = new JScrollPane();
            jScrollPane.setViewportView(getJContentPane());
        }
        return jScrollPane;
    }

    /**
     This method initializes jScrollPaneCopyright	
     
     @return javax.swing.JScrollPane	
     
     **/
    private JScrollPane getJScrollPaneCopyright() {
        if (jScrollPaneCopyright == null) {
            jScrollPaneCopyright = new JScrollPane();
            jScrollPaneCopyright.setBounds(new java.awt.Rectangle(160, 260, 320, 40));
            jScrollPaneCopyright.setPreferredSize(new java.awt.Dimension(320, 40));
            jScrollPaneCopyright.setViewportView(getJTextAreaCopyright());
            jScrollPaneCopyright.setSize(new java.awt.Dimension(320, 40));
        }
        return jScrollPaneCopyright;
    }

    /**
     This method initializes jTextAreaCopyright	
     
     @return javax.swing.JTextArea	
     
     **/
    private JTextArea getJTextAreaCopyright() {
        if (jTextAreaCopyright == null) {
            jTextAreaCopyright = new JTextArea();
            jTextAreaCopyright.setLineWrap(true);
            jTextAreaCopyright.addFocusListener(this);
            jTextAreaCopyright.setWrapStyleWord(true);
            jTextAreaCopyright.setSelectionStart(0);
            jTextAreaCopyright.setSelectionEnd(0);
            jTextAreaCopyright.setBounds(new java.awt.Rectangle(0, 0, 320, 40));
            jTextAreaCopyright.setToolTipText("One or more copyright lines.");
        }
        return jTextAreaCopyright;
    }

    /**
     * This method initializes jComboBoxBinaryModule    
     *  
     * @return javax.swing.JComboBox    
     */
    private JComboBox getJComboBoxBinaryModule() {
        if (jComboBoxBinaryModule == null) {
            jComboBoxBinaryModule = new JComboBox();
            jComboBoxBinaryModule.setBounds(new java.awt.Rectangle(160, 480, 320, 20));
            jComboBoxBinaryModule.setPreferredSize(new java.awt.Dimension(320, 20));
            jComboBoxBinaryModule.addFocusListener(this);
            jComboBoxBinaryModule.setToolTipText("<html>Modules are either source modules <br>"
                                                 + "which can be compiled or binary <br>"
                                                 + "modules which are linked.  <br>"
                                                 + "A module cannot contain both. <br>"
                                                 + "The GUID numbers should be identical <br>"
                                                 + "for a binary and source MSA, <br>"
                                                 + "however the BINARY MSA should have <br>"
                                                 + "a higher version number.</html>");
        }
        return jComboBoxBinaryModule;
    }

    /**
     * This method initializes jTextFieldOutputFileBasename 
     *  
     * @return javax.swing.JTextField   
     */
    private JTextField getJTextFieldOutputFileBasename() {
        if (jTextFieldOutputFileBasename == null) {
            jTextFieldOutputFileBasename = new JTextField();
            jTextFieldOutputFileBasename.setBounds(new java.awt.Rectangle(160, 455, 320, 20));
            jTextFieldOutputFileBasename.setPreferredSize(new java.awt.Dimension(320, 20));
            jTextFieldOutputFileBasename.addFocusListener(this);
            jTextFieldOutputFileBasename.setToolTipText("Enter a single word for generated output file names.");
        }
        return jTextFieldOutputFileBasename;
    }

    /**
     This is the default constructor
     
     **/
    public MsaHeader() {
        super();
        init();
        this.setVisible(true);
    }

    /**
     This is the override edit constructor
     
     @param inMsaHeader The input data of MsaHeaderDocument.MsaHeader
     
     **/
    public MsaHeader(OpeningModuleType inMsa) {
        super();
        this.omt = inMsa;
        this.msa = omt.getXmlMsa();

        //      
        // Set module definitions default value
        //
        if (msa.getModuleDefinitions() == null) {
            ModuleDefinitionsDocument.ModuleDefinitions md = ModuleDefinitionsDocument.ModuleDefinitions.Factory
                                                                                                                .newInstance();
            md.setOutputFileBasename(msa.getMsaHeader().getModuleName());
            md.setBinaryModule(false);
            md.setSupportedArchitectures(ed.getVSupportedArchitectures());
            msa.setModuleDefinitions(md);
        }
        init(msa.getMsaHeader());
        init(msa.getModuleDefinitions());
        this.setVisible(true);
        this.setViewMode(false);
    }

    /**
     Disable all components when the mode is view
     
     @param isView true - The view mode; false - The non-view mode
     
     **/
    public void setViewMode(boolean isView) {
        if (isView) {
            this.jTextFieldBaseName.setEnabled(!isView);
            this.jTextFieldGuid.setEnabled(!isView);
            this.jTextFieldVersion.setEnabled(!isView);
            this.jTextAreaLicense.setEnabled(!isView);
            this.jTextAreaCopyright.setEnabled(!isView);
            this.jTextAreaDescription.setEnabled(!isView);
            this.jTextFieldSpecification.setEnabled(!isView);
            this.jTextFieldAbstract.setEnabled(!isView);
            this.jComboBoxModuleType.setEnabled(!isView);
            this.jButtonCancel.setEnabled(!isView);
            this.jButtonGenerateGuid.setEnabled(!isView);
            this.jButtonOk.setEnabled(!isView);
        }
    }

    /**
     This method initializes this
     
     **/
    private void init() {
        this.setSize(500, 515);
        this.setPreferredSize(new java.awt.Dimension(490, 615));
        this.setContentPane(getJScrollPane());
        this.setTitle("Module Surface Area Header");
        initFrame();
    }

    /**
     This method initializes this
     Fill values to all fields if these values are not empty
     
     @param inMsaHeader  The input data of MsaHeaderDocument.MsaHeader
     
     **/
    private void init(MsaHeaderDocument.MsaHeader inMsaHeader) {
        init();
        if (inMsaHeader != null) {
            setMsaHeader(inMsaHeader);
            if (this.msaHeader.getModuleName() != null) {
                this.jTextFieldBaseName.setText(this.msaHeader.getModuleName());
            }
            if (this.msaHeader.getModuleType() != null) {
                this.jComboBoxModuleType.setSelectedItem(this.msaHeader.getModuleType().toString());
            }
            if (this.msaHeader.getGuidValue() != null) {
                this.jTextFieldGuid.setText(this.msaHeader.getGuidValue());
            }
            if (this.msaHeader.getVersion() != null) {
                this.jTextFieldVersion.setText(this.msaHeader.getVersion());
            }
            if (this.msaHeader.getAbstract() != null) {
                this.jTextFieldAbstract.setText(this.msaHeader.getAbstract());
            }
            if (this.msaHeader.getDescription() != null) {
                this.jTextAreaDescription.setText(this.msaHeader.getDescription());
                jTextAreaDescription.setSelectionStart(0);
                jTextAreaDescription.setSelectionEnd(0);
            }
            if (this.msaHeader.getCopyright() != null) {
                this.jTextAreaCopyright.setText(this.msaHeader.getCopyright());
            }
            if (this.msaHeader.getLicense() != null) {
                this.jTextAreaLicense.setText(this.msaHeader.getLicense().getStringValue());
                jTextAreaLicense.setSelectionStart(0);
                jTextAreaLicense.setSelectionEnd(0);
            }
            if (this.msaHeader.getLicense() != null && this.msaHeader.getLicense().getURL() != null) {
                this.jTextFieldURL.setText(this.msaHeader.getLicense().getURL());
            }
            if (this.msaHeader.getSpecification() != null) {
                this.jTextFieldSpecification.setText(this.msaHeader.getSpecification());
            }
        }
    }

    /**
     This method initializes this
     Fill values to all fields if these values are not empty
     
     @param inMsaHeader  The input data of MsaHeaderDocument.MsaHeader
     
     **/
    private void init(ModuleDefinitionsDocument.ModuleDefinitions inMd) {
        if (inMd != null) {
            this.md = inMd;
            if (md.getSupportedArchitectures() != null) {
                this.setSelectedItems(Tools.convertListToVector(md.getSupportedArchitectures()));
            }
            if (md.getBinaryModule()) {
                this.jComboBoxBinaryModule.setSelectedIndex(1);
            } else {
                this.jComboBoxBinaryModule.setSelectedIndex(0);
            }
            if (md.getOutputFileBasename() != null) {
                this.jTextFieldOutputFileBasename.setText(md.getOutputFileBasename());
            }
        }
    }

    /**
     This method initializes jContentPane
     
     @return javax.swing.JPanel jContentPane
     
     **/
    private JPanel getJContentPane() {
        if (jContentPane == null) {

            jLabelURL = new JLabel();
            jLabelURL.setText("License URL");
            jLabelURL.setLocation(new java.awt.Point(15, 430));
            jLabelURL.setSize(new java.awt.Dimension(140, 20));
            jLabelBaseName = new JLabel();
            jLabelBaseName.setText("Module Name");
            jLabelBaseName.setBounds(new java.awt.Rectangle(15, 10, 140, 20));
            jLabelModuleType = new JLabel();
            jLabelModuleType.setBounds(new java.awt.Rectangle(15, 35, 140, 20));
            jLabelModuleType.setText("Module Type");
            jLabelGuid = new JLabel();
            jLabelGuid.setText("Guid Value");
            jLabelGuid.setLocation(new java.awt.Point(15, 60));
            jLabelGuid.setSize(new java.awt.Dimension(140, 20));
            jLabelVersion = new JLabel();
            jLabelVersion.setText("Version");
            jLabelVersion.setLocation(new java.awt.Point(15, 85));
            jLabelVersion.setSize(new java.awt.Dimension(140, 20));
            jLabelAbstract = new JLabel();
            jLabelAbstract.setText("Abstract");
            jLabelAbstract.setLocation(new java.awt.Point(15, 110));
            jLabelAbstract.setSize(new java.awt.Dimension(140, 20));
            jLabelDescription = new JLabel();
            jLabelDescription.setText("Description");
            jLabelDescription.setLocation(new java.awt.Point(15, 135));
            jLabelDescription.setSize(new java.awt.Dimension(140, 20));
            jLabelCopyright = new JLabel();
            jLabelCopyright.setText("Copyright");
            jLabelCopyright.setLocation(new java.awt.Point(15, 260));
            jLabelCopyright.setSize(new java.awt.Dimension(140, 20));
            jLabelLicense = new JLabel();
            jLabelLicense.setText("License");
            jLabelLicense.setLocation(new java.awt.Point(15, 305));
            jLabelLicense.setSize(new java.awt.Dimension(140, 20));
            jLabelOutputFileBasename = new JLabel();
            jLabelOutputFileBasename.setBounds(new java.awt.Rectangle(15, 455, 140, 20));
            jLabelOutputFileBasename.setText("Output File Basename");
            jLabelBinaryModule = new JLabel();
            jLabelBinaryModule.setBounds(new java.awt.Rectangle(15, 480, 140, 20));
            jLabelBinaryModule.setText("Binary Module");
            jLabelArch = new JLabel();
            jLabelArch.setBounds(new java.awt.Rectangle(15, 505, 140, 20));
            jLabelArch.setText("Supported Architectures");
            jLabelSpecification = new JLabel();
            jLabelSpecification.setText("Specification");
            jLabelSpecification.setLocation(new java.awt.Point(14, 530));
            jLabelSpecification.setSize(new java.awt.Dimension(140, 20));

            jContentPane = new JPanel();
            jContentPane.setLayout(null);
            jContentPane.setPreferredSize(new java.awt.Dimension(490, 565));
            jContentPane.addFocusListener(this);

            jContentPane.add(jLabelBaseName, null);
            jContentPane.add(getJTextFieldBaseName(), null);
            jContentPane.add(jLabelGuid, null);
            jContentPane.add(getJTextFieldGuid(), null);
            jContentPane.add(jLabelVersion, null);
            jContentPane.add(getJTextFieldVersion(), null);
            jContentPane.add(getJButtonGenerateGuid(), null);
            jContentPane.add(jLabelLicense, null);
            jContentPane.add(jLabelCopyright, null);
            jContentPane.add(jLabelDescription, null);
            jContentPane.add(jLabelSpecification, null);
            jContentPane.add(getJTextFieldSpecification(), null);
            jContentPane.add(getJButtonOk(), null);
            jContentPane.add(getJButtonCancel(), null);
            jContentPane.add(getJScrollPaneLicense(), null);
            jContentPane.add(getJScrollPaneDescription(), null);
            jContentPane.add(jLabelAbstract, null);
            jContentPane.add(getJTextFieldAbstract(), null);
            jContentPane.add(jLabelModuleType, null);
            jContentPane.add(getJComboBoxModuleType(), null);
            jContentPane.add(jLabelURL, null);
            jContentPane.add(getJTextFieldURL(), null);
            jContentPane.add(jLabelOutputFileBasename, null);
            jContentPane.add(getJTextFieldOutputFileBasename(), null);
            jContentPane.add(jLabelBinaryModule, null);
            jContentPane.add(getJComboBoxBinaryModule(), null);
            jContentPane.add(jLabelArch, null);

            jStarLabel1 = new StarLabel();
            jStarLabel1.setLocation(new java.awt.Point(0, 10));
            jStarLabel2 = new StarLabel();
            jStarLabel2.setLocation(new java.awt.Point(0, 35));
            jStarLabel4 = new StarLabel();
            jStarLabel4.setLocation(new java.awt.Point(0, 60));
            jStarLabel5 = new StarLabel();
            jStarLabel5.setLocation(new java.awt.Point(0, 85));
            jStarLabel6 = new StarLabel();
            jStarLabel6.setLocation(new java.awt.Point(0, 135));
            jStarLabel7 = new StarLabel();
            jStarLabel7.setLocation(new java.awt.Point(0, 260));
            jStarLabel8 = new StarLabel();
            jStarLabel8.setLocation(new java.awt.Point(0, 305));
            jStarLabel10 = new StarLabel();
            jStarLabel10.setLocation(new java.awt.Point(0, 110));
            jStarLabel12 = new StarLabel();
            jStarLabel12.setLocation(new java.awt.Point(0, 455));
            jStarLabel13 = new StarLabel();
            jStarLabel13.setLocation(new java.awt.Point(0, 480));
            jStarLabel14 = new StarLabel();
            jStarLabel14.setLocation(new java.awt.Point(0, 505));
            jStarLabel15 = new StarLabel();
            jStarLabel15.setLocation(new java.awt.Point(0, 530));

            jContentPane.add(jStarLabel1, null);
            jContentPane.add(jStarLabel2, null);
            jContentPane.add(jStarLabel4, null);
            jContentPane.add(jStarLabel5, null);
            jContentPane.add(jStarLabel6, null);
            jContentPane.add(jStarLabel7, null);
            jContentPane.add(jStarLabel8, null);
            jContentPane.add(jStarLabel10, null);
            jContentPane.add(jStarLabel12, null);
            jContentPane.add(jStarLabel13, null);
            jContentPane.add(jStarLabel14, null);
            jContentPane.add(jStarLabel15, null);
            jContentPane.add(getJScrollPaneCopyright(), null);

            jContentPane.add(getJCheckBoxIa32(), null);
            jContentPane.add(getJCheckBoxX64(), null);
            jContentPane.add(getJCheckBoxIpf(), null);
            jContentPane.add(getJCheckBoxEbc(), null);
            jContentPane.add(getJCheckBoxArm(), null);
            jContentPane.add(getJCheckBoxPpc(), null);
        }
        return jContentPane;
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     *
     * Override actionPerformed to listen all actions
     *
     */
    public void actionPerformed(ActionEvent arg0) {
        if (arg0.getSource() == jButtonOk) {
            if (this.check()) {
                this.save();
            } else {
                return;
            }
            this.setEdited(true);
            this.dispose();
        }
        if (arg0.getSource() == jButtonCancel) {
            this.setEdited(false);
        }
        if (arg0.getSource() == jButtonGenerateGuid) {
            jTextFieldGuid.setText(Tools.generateUuidString());
        }
    }

    /**
     Data validation for all fields
     
     @retval true - All datas are valid
     @retval false - At least one data is invalid
     
     **/
    public boolean check() {
        //
        // Check if all required fields are not empty
        // and check if all data fields values are valid
        //

        //
        // Check Base Name
        //
        if (isEmpty(this.jTextFieldBaseName.getText())) {
            Log.wrn("Update Msa Header", "Name must be entered!");
            //this.jTextFieldBaseName.requestFocus();
            return false;
        }
        if (!DataValidation.isBaseName(this.jTextFieldBaseName.getText())) {
            Log.wrn("Update Msa Header", "Incorrect data type for Name, it must start with an alpha character!");
            //this.jTextFieldBaseName.requestFocus();
            return false;
        }

        //
        // Check Guid
        //
        if (isEmpty(this.jTextFieldGuid.getText())) {
            Log.wrn("Update Msa Header", "The Guid Value must be entered!");
            //this.jTextFieldGuid.requestFocus();
            return false;
        }
        if (!DataValidation.isGuid((this.jTextFieldGuid).getText())) {
            Log.wrn("Update Msa Header", "Incorrect data type for Guid, it must be registry format, 8-4-4-4-12");
            //this.jTextFieldGuid.requestFocus();
            return false;
        }

        //
        // Check Version
        //
        if (isEmpty(this.jTextFieldVersion.getText())) {
            Log.wrn("Update Msa Header", "Version must be entered!");
            //this.jTextFieldVersion.requestFocus();
            return false;
        }
        if (!DataValidation.isVersion(this.jTextFieldVersion.getText())) {
            Log.wrn("Update Msa Header", "Incorrect data type for Version, it must start with a digit.");
            //this.jTextFieldVersion.requestFocus();
            return false;
        }

        //
        // Check Abstact
        //
        if (isEmpty(this.jTextFieldAbstract.getText())) {
            Log.wrn("Update Msa Header", "Abstract must be entered!");
            //this.jTextFieldAbstract.requestFocus();
            return false;
        }
        if (!DataValidation.isAbstract(this.jTextFieldAbstract.getText())) {
            Log.wrn("Update Msa Header", "Incorrect data type for Abstract, is should be a sentence describing the module.");
            //this.jTextFieldAbstract.requestFocus();
            return false;
        }

        //
        // Check Description
        //
        if (isEmpty(this.jTextAreaDescription.getText())) {
            Log.wrn("Update Msa Header", "Description must be entered!");
            //this.jTextAreaDescription.requestFocus();
            return false;
        }

        //
        // Check Copyright
        //
        if (isEmpty(this.jTextAreaCopyright.getText())) {
            Log.wrn("Update Msa Header", "Copyright must be entered!");
            //this.jTextFieldCopyright.requestFocus();
            return false;
        }

        //
        // Check License
        //
        if (isEmpty(this.jTextAreaLicense.getText())) {
            Log.wrn("Update Msa Header", "License must be entered!");
            //this.jTextAreaLicense.requestFocus();
            return false;
        }

        //
        // Check Specification
        //
        if (isEmpty(this.jTextFieldSpecification.getText())) {
            Log.wrn("Update Msa Header", "Specification must exist.");
            //this.jTextFieldSpecification.requestFocus();
            return false;
        }
        if (!DataValidation.isSpecification(this.jTextFieldSpecification.getText())) {
            Log.wrn("Update Msa Header", "Incorrect data type for Specification");
            //this.jTextFieldSpecification.requestFocus();
            return false;
        }

        return true;
    }

    /**
     Save all components of Msa Header
     if exists msaHeader, set the value directly
     if not exists msaHeader, new an instance first
     
     **/
    public void save() {
        try {
            msaHeader.setSpecification(this.jTextFieldSpecification.getText());
            msa.setMsaHeader(msaHeader);
            msa.setModuleDefinitions(md);
            this.omt.setSaved(false);
        } catch (Exception e) {
            Log.wrn("Save Module", e.getMessage());
            Log.err("Save Module", e.getMessage());
        }
    }

    /**
     This method initializes Module type and Compontent type
     
     **/
    private void initFrame() {
        EnumerationData ed = new EnumerationData();
        Tools.generateComboBoxByVector(jComboBoxModuleType, ed.getVModuleType());
        Tools.generateComboBoxByVector(jComboBoxBinaryModule, ed.getVBoolean());
        this.setSelectedItems(ed.getVSupportedArchitectures());
    }

    /**
     Get MsaHeaderDocument.MsaHeader
     
     @return MsaHeaderDocument.MsaHeader
     
     **/
    public MsaHeaderDocument.MsaHeader getMsaHeader() {
        return msaHeader;
    }

    /**
     Set MsaHeaderDocument.MsaHeader
     
     @param msaHeader The input data of MsaHeaderDocument.MsaHeader
     
     **/
    public void setMsaHeader(MsaHeaderDocument.MsaHeader msaHeader) {
        this.msaHeader = msaHeader;
    }

    /* (non-Javadoc)
     * @see java.awt.event.ComponentListener#componentResized(java.awt.event.ComponentEvent)
     * 
     * Override componentResized to resize all components when frame's size is changed
     */
    public void componentResized(ComponentEvent arg0) {
        int intCurrentWidth = this.getJContentPane().getWidth();
        int intPreferredWidth = this.getJContentPane().getPreferredSize().width;

        Tools.resizeComponentWidth(this.jTextFieldBaseName, intCurrentWidth, intPreferredWidth);
        Tools.resizeComponentWidth(this.jTextFieldGuid, intCurrentWidth, intPreferredWidth);
        Tools.resizeComponentWidth(this.jTextFieldVersion, intCurrentWidth, intPreferredWidth);
        Tools.resizeComponentWidth(this.jScrollPaneLicense, intCurrentWidth, intPreferredWidth);
        Tools.resizeComponentWidth(this.jTextFieldURL, intCurrentWidth, intPreferredWidth);
        Tools.resizeComponentWidth(this.jScrollPaneCopyright, intCurrentWidth, intPreferredWidth);
        Tools.resizeComponentWidth(this.jScrollPaneDescription, intCurrentWidth, intPreferredWidth);
        Tools.resizeComponentWidth(this.jTextFieldSpecification, intCurrentWidth, intPreferredWidth);
        Tools.resizeComponentWidth(this.jTextFieldAbstract, intCurrentWidth, intPreferredWidth);
        Tools.resizeComponentWidth(this.jComboBoxModuleType, intCurrentWidth, intPreferredWidth);
        Tools.resizeComponentWidth(this.jComboBoxBinaryModule, intCurrentWidth, intPreferredWidth);
        Tools.resizeComponentWidth(this.jTextFieldOutputFileBasename, intCurrentWidth, intPreferredWidth);

        Tools.relocateComponentX(this.jButtonGenerateGuid, intCurrentWidth, intPreferredWidth,
                           DataType.SPACE_TO_RIGHT_FOR_GENERATE_BUTTON);
    }

    public void focusLost(FocusEvent arg0) {
        if (this.msaHeader == null) {
            msaHeader = MsaHeaderDocument.MsaHeader.Factory.newInstance();
        }

        //
        // Check BaseName
        //
        if (arg0.getSource() == this.jTextFieldBaseName) {
            if (isEmpty(this.jTextFieldBaseName.getText())) {
                Log.wrn("Update Msa Header", "The Name must be entered!");
                //this.jTextFieldBaseName.requestFocus();
                return;
            }
            if (!DataValidation.isBaseName(this.jTextFieldBaseName.getText())) {
                Log.wrn("Update Msa Header", "Incorrect data type for Name, it must begin with an alpha character.");
                //this.jTextFieldBaseName.requestFocus();
                return;
            }
            if (!this.jTextFieldBaseName.getText().equals(msaHeader.getModuleName())) {
                this.msaHeader.setModuleName(this.jTextFieldBaseName.getText());
            } else {
                return;
            }
        }

        //
        // Check Module Type
        //
        if (arg0.getSource() == this.jComboBoxModuleType) {
            if (!jComboBoxModuleType.getSelectedItem().toString().equals(msaHeader.getModuleType().toString())) {
                msaHeader.setModuleType(ModuleTypeDef.Enum.forString(jComboBoxModuleType.getSelectedItem().toString()));
            } else {
                return;
            }
        }

        //
        // Check Guid
        //
        if (arg0.getSource() == this.jTextFieldGuid) {
            if (isEmpty(this.jTextFieldGuid.getText())) {
                Log.wrn("Update Msa Header", "Guid must be entered!");
                //this.jTextFieldGuid.requestFocus();
                return;
            }
            if (!DataValidation.isGuid((this.jTextFieldGuid).getText())) {
                Log.wrn("Update Msa Header", "Incorrect data type for Guid, it must be registry format. (8-4-4-4-12)");
                //this.jTextFieldGuid.requestFocus();
                return;
            }
            if (!this.jTextFieldGuid.getText().equals(msaHeader.getGuidValue())) {
                this.msaHeader.setGuidValue(this.jTextFieldGuid.getText());
            } else {
                return;
            }
        }

        //
        // Check Version
        //
        if (arg0.getSource() == this.jTextFieldVersion) {
            if (isEmpty(this.jTextFieldVersion.getText())) {
                Log.wrn("Update Msa Header", "Version must be entered!");
                //this.jTextFieldVersion.requestFocus();
                return;
            }
            if (!DataValidation.isVersion(this.jTextFieldVersion.getText())) {
                Log.wrn("Update Msa Header", "Incorrect data type for Version, it must start with a digit.");
                //this.jTextFieldVersion.requestFocus();
                return;
            }
            if (!this.jTextFieldVersion.getText().equals(msaHeader.getVersion())) {
                this.msaHeader.setVersion(this.jTextFieldVersion.getText());
            } else {
                return;
            }
        }

        //
        // Check Abstact
        //
        if (arg0.getSource() == this.jTextFieldAbstract) {
            if (isEmpty(this.jTextFieldAbstract.getText())) {
                Log.wrn("Update Msa Header", "Abstract must be entered!");
                //this.jTextFieldAbstract.requestFocus();
                return;
            }
            if (!DataValidation.isAbstract(this.jTextFieldAbstract.getText())) {
                Log.wrn("Update Msa Header", "Incorrect data type for Abstract, it must be sentence.");
                //this.jTextFieldAbstract.requestFocus();
                return;
            }
            if (!this.jTextFieldAbstract.getText().equals(msaHeader.getAbstract())) {
                this.msaHeader.setAbstract(this.jTextFieldAbstract.getText());
            } else {
                return;
            }
        }

        //
        // Check Description
        //
        if (arg0.getSource() == this.jTextAreaDescription) {
            if (isEmpty(this.jTextAreaDescription.getText())) {
                Log.wrn("Update Msa Header", "Description must be entered!");
                //this.jTextAreaDescription.requestFocus();
                return;
            }
            if (!this.jTextAreaDescription.getText().equals(msaHeader.getDescription())) {
                this.msaHeader.setDescription(this.jTextAreaDescription.getText());
            } else {
                return;
            }
        }

        //
        // Check Copyright
        //
        if (arg0.getSource() == this.jTextAreaCopyright) {
            if (isEmpty(this.jTextAreaCopyright.getText())) {
                Log.wrn("Update Msa Header", "Copyright must be entered!");
                //this.jTextFieldCopyright.requestFocus();
                return;
            }
            if (!this.jTextAreaCopyright.getText().equals(msaHeader.getCopyright())) {
                this.msaHeader.setCopyright(this.jTextAreaCopyright.getText());
            } else {
                return;
            }
        }

        //
        // Check License
        //
        if (arg0.getSource() == this.jTextAreaLicense) {
            if (isEmpty(this.jTextAreaLicense.getText())) {
                Log.wrn("Update Msa Header", "License must be entered!");
                //this.jTextAreaLicense.requestFocus();
                return;
            }
            if (this.msaHeader.getLicense() != null) {
                if (!this.jTextAreaLicense.getText().equals(msaHeader.getLicense().getStringValue())) {
                    this.msaHeader.getLicense().setStringValue(this.jTextAreaLicense.getText());
                } else {
                    return;
                }
            } else {
                License mLicense = License.Factory.newInstance();
                mLicense.setStringValue(this.jTextAreaLicense.getText());
                this.msaHeader.setLicense(mLicense);
            }
        }

        //
        // Check License URL
        //
        if (arg0.getSource() == this.jTextFieldURL) {
            if (!isEmpty(this.jTextFieldURL.getText())) {
                if (this.msaHeader.getLicense() == null) {
                    License mLicense = License.Factory.newInstance();
                    mLicense.setURL(this.jTextFieldURL.getText());
                    this.msaHeader.setLicense(mLicense);
                } else {
                    if (!this.jTextFieldURL.getText().equals(msaHeader.getLicense().getURL())) {
                        this.msaHeader.getLicense().setURL(this.jTextFieldURL.getText());
                    } else {
                        return;
                    }
                }
            }
        }

        //
        // Check Output File Basename
        //
        if (arg0.getSource() == this.jTextFieldOutputFileBasename) {
            if (isEmpty(this.jTextFieldOutputFileBasename.getText())) {
                Log.wrn("Update Msa Header", "Output File Basename must be entered!");
                //                jTextFieldOutputFileBasename.removeFocusListener(this);
                //                jTextFieldOutputFileBasename.requestFocus();
                //                jTextFieldOutputFileBasename.addFocusListener(this);
                return;
            }
            if (!this.jTextFieldOutputFileBasename.getText().equals(md.getOutputFileBasename())) {
                this.md.setOutputFileBasename(this.jTextFieldOutputFileBasename.getText());
            } else {
                return;
            }
        }

        //
        // Check Binary Module Type
        //
        if (arg0.getSource() == this.jComboBoxBinaryModule) {
            if (jComboBoxBinaryModule.getSelectedItem().toString().equals(DataType.TRUE)) {
                if (md.getBinaryModule()) {
                    return;
                } else {
                    md.setBinaryModule(true);
                }
            } else if (jComboBoxBinaryModule.getSelectedItem().toString().equals(DataType.FALSE)) {
                if (md.getBinaryModule()) {
                    md.setBinaryModule(false);
                } else {
                    return;
                }
            }
        }

        //
        // Check Supported Arch
        //
        if (arg0.getSource() == this.jCheckBoxArm || arg0.getSource() == this.jCheckBoxEbc
            || arg0.getSource() == this.jCheckBoxIa32 || arg0.getSource() == this.jCheckBoxIpf
            || arg0.getSource() == this.jCheckBoxPpc || arg0.getSource() == this.jCheckBoxX64) {
            if (!this.getSelectedItemsString().equals(md.getSupportedArchitectures().toString())) {
                md.setSupportedArchitectures(this.getSelectedItemsVector());
            } else {
                return;
            }
        }

        this.save();
    }

    private Vector<String> getSelectedItemsVector() {
        Vector<String> v = new Vector<String>();
        if (this.jCheckBoxIa32.isSelected()) {
            v.addElement(jCheckBoxIa32.getText());
        }
        if (this.jCheckBoxX64.isSelected()) {
            v.addElement(jCheckBoxX64.getText());
        }
        if (this.jCheckBoxIpf.isSelected()) {
            v.addElement(jCheckBoxIpf.getText());
        }
        if (this.jCheckBoxEbc.isSelected()) {
            v.addElement(jCheckBoxEbc.getText());
        }
        if (this.jCheckBoxArm.isSelected()) {
            v.addElement(jCheckBoxArm.getText());
        }
        if (this.jCheckBoxPpc.isSelected()) {
            v.addElement(jCheckBoxPpc.getText());
        }
        return v;
    }

    private String getSelectedItemsString() {
        String s = "";
        if (this.jCheckBoxIa32.isSelected()) {
            s = s + jCheckBoxIa32.getText() + " ";
        }
        if (this.jCheckBoxX64.isSelected()) {
            s = s + jCheckBoxX64.getText() + " ";
        }
        if (this.jCheckBoxIpf.isSelected()) {
            s = s + jCheckBoxIpf.getText() + " ";
        }
        if (this.jCheckBoxEbc.isSelected()) {
            s = s + jCheckBoxEbc.getText() + " ";
        }
        if (this.jCheckBoxArm.isSelected()) {
            s = s + jCheckBoxArm.getText() + " ";
        }
        if (this.jCheckBoxPpc.isSelected()) {
            s = s + jCheckBoxPpc.getText() + " ";
        }
        return s.trim();
    }

    private void setAllItemsSelected(boolean isSelected) {
        this.jCheckBoxIa32.setSelected(isSelected);
        this.jCheckBoxX64.setSelected(isSelected);
        this.jCheckBoxIpf.setSelected(isSelected);
        this.jCheckBoxEbc.setSelected(isSelected);
        this.jCheckBoxArm.setSelected(isSelected);
        this.jCheckBoxPpc.setSelected(isSelected);
    }

    private void setSelectedItems(Vector<String> v) {
        setAllItemsSelected(false);
        if (v != null) {
            for (int index = 0; index < v.size(); index++) {
                if (v.get(index).equals(this.jCheckBoxIa32.getText())) {
                    this.jCheckBoxIa32.setSelected(true);
                    continue;
                }
                if (v.get(index).equals(this.jCheckBoxIpf.getText())) {
                    this.jCheckBoxIpf.setSelected(true);
                    continue;
                }
                if (v.get(index).equals(this.jCheckBoxX64.getText())) {
                    this.jCheckBoxX64.setSelected(true);
                    continue;
                }
                if (v.get(index).equals(this.jCheckBoxEbc.getText())) {
                    this.jCheckBoxEbc.setSelected(true);
                    continue;
                }
                if (v.get(index).equals(this.jCheckBoxArm.getText())) {
                    this.jCheckBoxArm.setSelected(true);
                    continue;
                }
                if (v.get(index).equals(this.jCheckBoxPpc.getText())) {
                    this.jCheckBoxPpc.setSelected(true);
                    continue;
                }
            }
        }
    }
}
