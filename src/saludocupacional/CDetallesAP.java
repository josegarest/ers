package saludocupacional;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class CDetallesAP extends JInternalFrame {
    //DECLARACION DE VARIABLES
    CAntecedentesFamiliar ObjACF;
    public String cadnombrepestana="";
    CAntecedentesPersonales ObjACP;
    CExamenFisico frameEXFi;
    Object objetoRS;
    int swframe;
    //DECLARACION DE COMPONENTES VISUALES
    JPanel JPDetallesAP = new JPanel();
    JLabel JLBNombPac = new JLabel();
    JLabel JLBNumHcDAP = new JLabel();
    JLabel JLBNumHCAP = new JLabel();
    JTabbedPane JTBDetallesAP = new JTabbedPane();
    JPanel JPDetAP = new JPanel();
    JScrollPane JSPDetAP = new JScrollPane();
    JEditorPane JEDPdetAP = new JEditorPane();
    public CDetallesAP(CAntecedentesPersonales objap) {
        try {
            jbInit();
            cadnombrepestana="ANTECEDENTES PERSONALES";
            JLBNombPac.setText(objap.JLBNombpacAP.getText());
            JLBNumHCAP.setText(objap.JLBnhcAP.getText());
            ObjACP=objap;
            swframe=1;
            //System.out.println("MARIO");
         } catch (Exception ex) {
             //System.out.println("MARIO"+ex.getMessage());
          }
    }
    public CDetallesAP(CAntecedentesFamiliar objaf) {
        try {
            cadnombrepestana="ANTECEDENTES FAMILIARES";
            jbInit();
            JLBNombPac.setText(objaf.JLBNombpacAF.getText());
            JLBNumHCAP.setText(objaf.JLBNumhcAF.getText());
            ObjACF=objaf;
            swframe=0;
            //JEDPdetAP.requestFocus();
         } catch (Exception ex) {
            ex.printStackTrace();
           }
    }

    public CDetallesAP(CExamenFisico objExFis){
        try {
            jbInit();
            swframe=3;
            cadnombrepestana=objExFis.nombreefisico;
            JLBNombPac.setText(objExFis.JLBNombPacEF.getText());
            JLBNumHCAP.setText(objExFis.JLBnumhcEF.getText());
            frameEXFi=objExFis;
         } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
      public CDetallesAP(CRevisionSistemas frameRS) {
        try {
            jbInit();
            cadnombrepestana="REVISION POR SISTEMAS";
            JLBNombPac.setText(frameRS.JLBNumhcRS.getText());
            JLBNumHCAP.setText(frameRS.JLBNhc2RS.getText());
            objetoRS=frameRS;
            swframe=2;
         } catch (Exception ex) {
            ex.printStackTrace();
        }

    }



    private void jbInit() throws Exception {
        this.setClosable(true);
        this.setVisible(true);
        //this.setIconifiable(true);
        //this.setMaximizable(true);
        //this.setResizable(true);
        //COMPONENTES VISUALES
        this.addInternalFrameListener(new InternalFrameAdapter() {
            public void internalFrameClosing(InternalFrameEvent e) {
                this_internalFrameClosing(e);
            }
        });

        this.getContentPane().setLayout(null);
        JPDetallesAP.setBackground(new Color(122, 150, 223));
        JPDetallesAP.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JPDetallesAP.setBorder(BorderFactory.createRaisedBevelBorder());
        JPDetallesAP.setBounds(new Rectangle(4, 4, 531, 558));
        JPDetallesAP.setLayout(null);
        JLBNombPac.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JLBNombPac.setForeground(Color.red);
        JLBNombPac.setToolTipText("");
        JLBNombPac.setText("YANETH");
        JLBNombPac.setBounds(new Rectangle(7, 9, 283, 30));
        JLBNumHcDAP.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JLBNumHcDAP.setForeground(Color.red);
        JLBNumHcDAP.setToolTipText("");
        JLBNumHcDAP.setText("HISTORIA CLINICA N#");
        JLBNumHcDAP.setBounds(new Rectangle(260, 11, 146, 30));
        JLBNumHCAP.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JLBNumHCAP.setForeground(Color.red);
        JLBNumHCAP.setBounds(new Rectangle(412, 14, 114, 25));
        JTBDetallesAP.setBackground(new Color(122, 150, 223));
        JTBDetallesAP.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JTBDetallesAP.setForeground(Color.red);
        JTBDetallesAP.setBounds(new Rectangle(5, 43, 521, 510));
        JPDetAP.setBackground(new Color(122, 150, 223));
        JPDetAP.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JPDetAP.setBorder(BorderFactory.createRaisedBevelBorder());
        JPDetAP.setLayout(null);
        JSPDetAP.getViewport().setBackground(new Color(122, 150, 223));
        JSPDetAP.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JSPDetAP.setBounds(new Rectangle(3, 5, 509, 470));
        JEDPdetAP.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JEDPdetAP.setBorder(BorderFactory.createLoweredBevelBorder());
        JEDPdetAP.setToolTipText("");
        JEDPdetAP.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                JEDPdetAP_keyReleased(e);
            }
        });
        this.getContentPane().add(JPDetallesAP);
        JPDetallesAP.add(JLBNumHcDAP);
        JPDetallesAP.add(JLBNumHCAP);
        JPDetallesAP.add(JLBNombPac);
        JPDetallesAP.add(JTBDetallesAP);
        JTBDetallesAP.add(JPDetAP, cadnombrepestana);
        JPDetAP.add(JSPDetAP);
        JSPDetAP.getViewport().add(JEDPdetAP);
    }
    public void this_internalFrameClosing(InternalFrameEvent e) {
       editorproceso();
    }//cierra el metodo this_internalFrameClosing(InternalFrameEvent e)

    /**
     * procesoantfam
     */
    public void procesoantfam() {
           if(ObjACF.JCHEpilepsia.isSelected()==true && ObjACF.swepilepsia==1){
             ObjACF.JTFEpilepsia.setText(JEDPdetAP.getText());
             ObjACF.swepilepsia=0;
           }//cierra if de epilepsia
           else{
              if(ObjACF.JCHCardiopatias.isSelected()==true && ObjACF.swcardiopat==1){
               ObjACF.JTFCardiopatias.setText(JEDPdetAP.getText());
               ObjACF.swcardiopat=0;
              }//cierra if de Cardiopatia
              else{
                  if(ObjACF.JCHCancer.isSelected()==true && ObjACF.swcancer==1){
                     ObjACF.JTFCancer.setText(JEDPdetAP.getText());
                     ObjACF.swcancer=0;
                  }//cierra if de Cancer
                  else{
                      if(ObjACF.JCHOtros.isSelected()==true && ObjACF.swotros==1){
                         ObjACF.JTFOtros.setText(JEDPdetAP.getText());
                         ObjACF.swotros=0;
                      }//cierra if de Otros
                      else{
                          if(ObjACF.JCHDiabet.isSelected()==true && ObjACF.swdiab==1){
                             ObjACF.JTFDiab.setText(JEDPdetAP.getText());
                             ObjACF.swdiab=0;
                          }//cierra if de diabetes
                          else{
                              if(ObjACF.JCHHta.isSelected()==true && ObjACF.swhta==1){
                                 ObjACF.JTFHta.setText(JEDPdetAP.getText());
                                 ObjACF.swhta=0;
                              }//cierra if de HTA

                          }//cierra el else de HTA
                      }//cierra el else de diabetes
                  }// cierra el else de cancer
              }//cierra el else de Cardiopatias
          }//ciera else de epilepsia
       this.dispose();
       ObjACF.setVisible(true);
    }//ciera procesoantfam()

    /**
     * procesoantfam
     */
    public void procesoantper() {
        if(ObjACP.JCHDiabet.isSelected()==true && ObjACP.swdiabet==1){
             ObjACP.JTFDiabet.setText(JEDPdetAP.getText());
             ObjACP.swdiabet=0;
         }
         else
           if(ObjACP.JCHHipArt.isSelected()==true && ObjACP.swhipart==1){
               ObjACP.JTFHiperArt.setText(JEDPdetAP.getText());
               ObjACP.swhipart=0;
           }
           else
            if(ObjACP.JCHCoronario.isSelected()==true && ObjACP.swcoronaria==1){
             ObjACP.JFTCoronario.setText(JEDPdetAP.getText());
             ObjACP.swcoronaria=0;
           }
           else
            if(ObjACP.JCHDislipedia.isSelected()==true && ObjACP.swdislipedia==1){
             ObjACP.JTFDislipidemia.setText(JEDPdetAP.getText());
             ObjACP.swdislipedia=0;
           }
           else
              if(ObjACP.JCHAsmaBronq.isSelected()==true && ObjACP.swasmabronq==1){
               ObjACP.JTFAsmaBronquial.setText(JEDPdetAP.getText());
               ObjACP.swasmabronq=0;
             }
             else
              if(ObjACP.JCHPsicopatia.isSelected()==true && ObjACP.swpsicopatia==1){
                ObjACP.JTFPsicopatia.setText(JEDPdetAP.getText());
                ObjACP.swpsicopatia=0;
              }
              else
                if(ObjACP.JCHAlergiaAp.isSelected()==true && ObjACP.swalergia==1){
                  ObjACP.JTFAlergiaAP.setText(JEDPdetAP.getText());
                  ObjACP.swalergia=0;
                }
                else
                  if(ObjACP.JCHTuberculosisAP.isSelected()==true && ObjACP.swtuberculosis==1){
                    ObjACP.JTFTuberculosisAP.setText(JEDPdetAP.getText());
                    ObjACP.swtuberculosis=0;
                  }
                  else
                   if(ObjACP.JCHAtipiaAP.isSelected()==true && ObjACP.swatipia==1){
                     ObjACP.JTFAtipiaAP.setText(JEDPdetAP.getText());
                     ObjACP.swatipia=0;
                   }
                   else
                     if(ObjACP.JCHGotaAP.isSelected()==true && ObjACP.swgota==1){
                       ObjACP.JTFGotaAP.setText(JEDPdetAP.getText());
                       ObjACP.swgota=0;
                     }
                     else
                       if(ObjACP.JCHAffBroncoAP.isSelected()==true && ObjACP.swatccbroncpulm==1){
                         ObjACP.JTFAfccbroncpulm.setText(JEDPdetAP.getText());
                         ObjACP.swatccbroncpulm=0;
                       }
                       else
                         if(ObjACP.JCHEndocrinopatiasAP.isSelected()==true && ObjACP.swendocrinopatias==1){
                            ObjACP.JTFEndocrinopatiasAP.setText(JEDPdetAP.getText());
                            ObjACP.swendocrinopatias=0;
                         }
                         else
                           if(ObjACP.JCHNefrologiasAP.isSelected()==true && ObjACP.swnefrologias==1){
                            ObjACP.JTNefrologiasAP.setText(JEDPdetAP.getText());
                            ObjACP.swnefrologias=0;
                           }
                           else
                             if(ObjACP.JCHPatiasAP.isSelected()==true && ObjACP.swpatias==1){
                                ObjACP.JTFPatiasAP.setText(JEDPdetAP.getText());
                                ObjACP.swpatias=0;
                             }
                             else
                               if(ObjACP.JCHHemopatiasAP.isSelected()==true && ObjACP.swhemopatias==1){
                                 ObjACP.JTFHemopatias.setText(JEDPdetAP.getText());
                                 ObjACP.swhemopatias=0;
                               }
                               else
                                 if(ObjACP.JCHEtsAP.isSelected()==true && ObjACP.swets==1){
                                   ObjACP.JTFETSap.setText(JEDPdetAP.getText());
                                   ObjACP.swets=0;
                                 }
                                 else
                                    if(ObjACP.JCHUlceraGastr.isSelected()==true && ObjACP.swgastroduod==1){
                                       ObjACP.JTFUlcGastrDuodAP.setText(JEDPdetAP.getText());
                                       ObjACP.swgastroduod=0;
                                    }
                                    else
                                      if(ObjACP.JCHColecistopatiaAP.isSelected()==true && ObjACP.swcolecistopatia==1){
                                         ObjACP.JTFColecistopatia.setText(JEDPdetAP.getText());
                                         ObjACP.swcolecistopatia=0;
                                      }
                                      else
                                        if(ObjACP.JCHHepatitis.isSelected()==true && ObjACP.swhepatitis==1){
                                          ObjACP.JTFHepatitis.setText(JEDPdetAP.getText());
                                          ObjACP.swhepatitis=0;
                                        }
                                        else
                                          if(ObjACP.JCHEnfNeurologicaEP.isSelected()==true && ObjACP.swenfneurologicas==1){
                                             ObjACP.JTFEnfNeurologAP.setText(JEDPdetAP.getText());
                                             ObjACP.swenfneurologicas=0;
                                          }
                                          else
                                            if(ObjACP.JCHFiebresProAP.isSelected()==true && ObjACP.swfiebresprolongadas==1){
                                               ObjACP.JFTFiebresProlongAP.setText(JEDPdetAP.getText());
                                               ObjACP.swfiebresprolongadas=0;
                                            }
                                            else
                                               if(ObjACP.JCHColagenopatias.isSelected()==true && ObjACP.swcolageno==1){
                                                 ObjACP.JFTColagenopatias.setText(JEDPdetAP.getText());
                                                 ObjACP.swcolageno=0;
                                               }
                                               else
                                                   if(ObjACP.JCHTraumatismo.isSelected()==true && ObjACP.swtraumat==1){
                                                      ObjACP.JTFTraumatismo.setText(JEDPdetAP.getText());
                                                      ObjACP.swtraumat=0;
                                                   }
                                                   else
                                                       if(ObjACP.JCHOtros.isSelected()==true && ObjACP.swotros==1){
                                                          ObjACP.JTFOtros.setText(JEDPdetAP.getText());
                                                          ObjACP.swotros=0;
                                                       }


         this.dispose();
         ObjACP.setVisible(true);

    }

    /**
     * procesoef
     */
    public void procesoef() {
             // frameEXFi.swcara=0;
              if(frameEXFi.JRBnoAbdomenEF.isSelected()==true && frameEXFi.swabdomen==1){
                   frameEXFi.JTFAbdomenEF.setText(JEDPdetAP.getText());
                   frameEXFi.swabdomen=0;
              }
              else
                 if(frameEXFi.JRnoCab.isSelected()==true && frameEXFi.swcabeza==1){
                   frameEXFi.JTFCabeza.setText(JEDPdetAP.getText());
                   frameEXFi.swcabeza=0;//System.out.println("YERLIS cadera");
                 }
                 else
                   if(frameEXFi.JRnoCara.isSelected()==true && frameEXFi.swcara==1){
                      frameEXFi.JTFcaraEF.setText(JEDPdetAP.getText());
                      frameEXFi.swcara=0;
                   }
                   else
                      if(frameEXFi.JRnoOjosEF.isSelected()==true && frameEXFi.swojos==1){
                        frameEXFi.JTFojosEF.setText(JEDPdetAP.getText());
                        frameEXFi.swojos=0;
                      }
                      else
                         if(frameEXFi.JRnoOidos.isSelected()==true && frameEXFi.swoidos==1){
                           frameEXFi.JTFoidosEF.setText(JEDPdetAP.getText());
                           frameEXFi.swoidos=0;
                         }
                         else
                           if(frameEXFi.JRBnoNariz.isSelected()==true && frameEXFi.swnariz==1){
                             frameEXFi.JTFnarizEF.setText(JEDPdetAP.getText());
                             frameEXFi.swnariz=0;
                           }
                           else
                              if(frameEXFi.JRBnoBocaEF.isSelected()==true && frameEXFi.swboca==1){
                                 frameEXFi.JTFbocaEF.setText(JEDPdetAP.getText());
                                 frameEXFi.swboca=0;
                              }
                              else
                                 if(frameEXFi.JRBnoDentEF.isSelected()==true && frameEXFi.swdentadura==1){
                                   frameEXFi.JTFDentEF.setText(JEDPdetAP.getText());
                                   frameEXFi.swdentadura=0;
                                 }
                                 else
                                   if(frameEXFi.JRBnoCuelloEF.isSelected()==true && frameEXFi.swcuello==1){
                                    frameEXFi.JTFcuelloEF.setText(JEDPdetAP.getText());
                                    frameEXFi.swcuello=0;
                                   }
                                   else
                                    if(frameEXFi.JRBnoToraxEF.isSelected()==true && frameEXFi.swtorax==1){
                                      frameEXFi.JTFtoraxEF.setText(JEDPdetAP.getText());
                                      frameEXFi.swtorax=0;
                                    }
                                    else
                                      if(frameEXFi.JRBnoCardiacoEF.isSelected()==true && frameEXFi.swcardiaco==1){
                                        frameEXFi.JTFCardiacoEF.setText(JEDPdetAP.getText());
                                        frameEXFi.swcardiaco=0;
                                      }
                                      else
                                        if(frameEXFi.JRBnoPulmonEF.isSelected()==true && frameEXFi.swpulmon==1){
                                          frameEXFi.JTFPulmonEF.setText(JEDPdetAP.getText());
                                          frameEXFi.swpulmon=0;
                                        }
                                        else
                                          if(frameEXFi.JRBnomamasEF.isSelected()==true && frameEXFi.swmamas==1){
                                            frameEXFi.JTFMamasEF.setText(JEDPdetAP.getText());
                                            frameEXFi.swmamas=0;
                                          }
                                          else
                                             if(frameEXFi.JRBnoGenitalesEF.isSelected()==true && frameEXFi.swgenitales==1){
                                                frameEXFi.JTFGenitalesEF.setText(JEDPdetAP.getText());
                                                frameEXFi.swgenitales=0;
                                             }
                                             else
                                               if(frameEXFi.JRBnoMsupEF.isSelected()==true && frameEXFi.swmsup==1){
                                                  frameEXFi.JTFMsup.setText(JEDPdetAP.getText());
                                                  frameEXFi.swmsup=0;
                                               }
                                               else
                                                  if(frameEXFi.JRnoMinfEF.isSelected()==true && frameEXFi.swminf==1){
                                                     frameEXFi.JTFMinfEF.setText(JEDPdetAP.getText());
                                                     frameEXFi.swminf=0;
                                                  }
                                                  else
                                                     if(frameEXFi.JRBnoPiesEF.isSelected()==true && frameEXFi.swpies==1){
                                                        frameEXFi.JTFPiesEF.setText(JEDPdetAP.getText());
                                                        frameEXFi.swpies=0;
                                                     }
                                                     else
                                                        if(frameEXFi.JRBnoColEF.isSelected()==true && frameEXFi.swcol==1){
                                                           frameEXFi.JTFColEF.setText(JEDPdetAP.getText());
                                                           frameEXFi.swcol=0;
                                                        }
                                                        else
                                                           if(frameEXFi.JRBnoNeurl.isSelected()==true && frameEXFi.swneurologico==1){
                                                              frameEXFi.JTFNeurlogEF.setText(JEDPdetAP.getText());
                                                              frameEXFi.swneurologico=0;
                                                           }
                                                           else
                                                              if(frameEXFi.JRBnoPielEF.isSelected()==true && frameEXFi.swpiel==1){
                                                                frameEXFi.JTFPielEF.setText(JEDPdetAP.getText());
                                                                frameEXFi.swpiel=0;
                                                              }
              this.dispose();
              frameEXFi.setVisible(true);
    }

    /**
     * procesors
     */
    public void procesors() {
        CRevisionSistemas frameRSystem;
            frameRSystem=(CRevisionSistemas)objetoRS;
            if(frameRSystem.JRDolorPrecordial.isSelected()==true && frameRSystem.swdolorprecordial==1){
              frameRSystem.JFTDolorPrecordial.setText(JEDPdetAP.getText());
              frameRSystem.swdolorprecordial=0;
            }//cierra el if del dolorprecordial
            else{
                 if(frameRSystem.JRLipotimia.isSelected()==true && frameRSystem.swdlipotimia==1){
                    frameRSystem.JFTLipotimia.setText(JEDPdetAP.getText());
                    frameRSystem.swdlipotimia=0;
                 }//cierra el if del lipotimia
                 else{
                      if(frameRSystem.JRPalpitaciones.isSelected()==true && frameRSystem.swpalpitaciones==1){
                         frameRSystem.JFTPalpit.setText(JEDPdetAP.getText());
                         frameRSystem.swpalpitaciones=0;
                      }//cierra el if del palpitaciones
                      else{
                           if(frameRSystem.JRSincope.isSelected()==true && frameRSystem.swsincope==1){
                               frameRSystem.JFTSincope.setText(JEDPdetAP.getText());
                               frameRSystem.swsincope=0;
                           }//cierra el if de sincope
                           else{
                                if(frameRSystem.JRDisnea.isSelected()==true && frameRSystem.swdisnea==1){
                                   frameRSystem.jFormattedTextField2.setText(JEDPdetAP.getText());
                                   frameRSystem.swdisnea=0;
                                }//cierra el if de disnea
                                else{
                                     if(frameRSystem.JRDescamacion.isSelected()==true && frameRSystem.swdescamacion==1){
                                        frameRSystem.JFTdescam.setText(JEDPdetAP.getText());
                                        frameRSystem.swdescamacion=0;
                                     }//cierra el if de descamacion
                                     else{
                                          if(frameRSystem.JRDolorAbdominal.isSelected()==true && frameRSystem.swdolorabdominal==1){
                                             frameRSystem.JFTDolorAbd.setText(JEDPdetAP.getText());
                                             frameRSystem.swdolorabdominal=0;
                                          }//cierra el if de dolor abdominal
                                          else{
                                               if(frameRSystem.JREpigastraigia.isSelected()==true && frameRSystem.swepigastraigia==1){
                                                  frameRSystem.JFTEpigastr.setText(JEDPdetAP.getText());
                                                  frameRSystem.swepigastraigia=0;
                                               }//cierra el if de epigastraigia
                                               else{
                                                   if(frameRSystem.JREstrenimiento.isSelected()==true && frameRSystem.swestrenimiento==1){
                                                      frameRSystem.JFTEstrenimiento.setText(JEDPdetAP.getText());
                                                      frameRSystem.swestrenimiento=0;
                                                   }//cierra el if de estrenimiento
                                                   else{
                                                        if(frameRSystem.JRDiarrea.isSelected()==true && frameRSystem.swdiarrea==1){
                                                          frameRSystem.JFTDiarrea.setText(JEDPdetAP.getText());
                                                          frameRSystem.swdiarrea=0;
                                                       }//cierra el if de diarrea
                                                       else{
                                                           if(frameRSystem.JRSangrado.isSelected()==true && frameRSystem.swsangrado==1){
                                                              frameRSystem.JFTSangrado.setText(JEDPdetAP.getText());
                                                              frameRSystem.swsangrado=0;
                                                           }//cierra el if de sangrado
                                                           else{
                                                                if(frameRSystem.JREritema.isSelected()==true && frameRSystem.sweritema==1){
                                                                   frameRSystem.JFTEritema.setText(JEDPdetAP.getText());
                                                                   frameRSystem.sweritema=0;
                                                                }//cierra el if de eritema
                                                                else{
                                                                    if(frameRSystem.JRHiperhidrosis.isSelected()==true && frameRSystem.swhiperhidrosis==1){
                                                                       frameRSystem.JFTHiperhidrosis.setText(JEDPdetAP.getText());
                                                                       frameRSystem.swhiperhidrosis=0;
                                                                    }//cierra el if de hiperhidrosis
                                                                    else{
                                                                        if(frameRSystem.JRBrote.isSelected()==true && frameRSystem.swbrote==1){
                                                                           frameRSystem.JFTBrote.setText(JEDPdetAP.getText());
                                                                           frameRSystem.swbrote=0;
                                                                        }//cierra el if de brote
                                                                        else{
                                                                            if(frameRSystem.JRSequedad.isSelected()==true && frameRSystem.swsequedad==1){
                                                                               frameRSystem.JFTSequedad.setText(JEDPdetAP.getText());
                                                                               frameRSystem.swsequedad=0;
                                                                            }//cierra el if de sequedad
                                                                            else{
                                                                                if(frameRSystem.JRPrurito.isSelected()==true && frameRSystem.swprurito==1){
                                                                                   frameRSystem.JFTprurito.setText(JEDPdetAP.getText());
                                                                                   frameRSystem.swprurito=0;
                                                                                }//cierra el if de prurito
                                                                                else{
                                                                                    if(frameRSystem.JRDispepsia.isSelected()==true && frameRSystem.swdispepsia==1){
                                                                                       frameRSystem.JFTDispepsia.setText(JEDPdetAP.getText());
                                                                                       frameRSystem.swdispepsia=0;
                                                                                    }//cierra el if de dispepsia
                                                                                    else{
                                                                                        if(frameRSystem.JRDisminucionCalibre.isSelected()==true && frameRSystem.swdisminucioncalibre==1){
                                                                                           frameRSystem.JFTDisminucionCalibre.setText(JEDPdetAP.getText());
                                                                                           frameRSystem.swdisminucioncalibre=0;
                                                                                        }//cierra el if de disminucioncalibre
                                                                                        else{
                                                                                            if(frameRSystem.JRDisuria.isSelected()==true && frameRSystem.swdisuria==1){
                                                                                               frameRSystem.JFTDisuria.setText(JEDPdetAP.getText());
                                                                                               frameRSystem.swdisuria=0;
                                                                                            }//cierra el if de disuria
                                                                                            else{
                                                                                                if(frameRSystem.JRHematuria.isSelected()==true && frameRSystem.swhematuria==1){
                                                                                                   frameRSystem.JFTHematuria.setText(JEDPdetAP.getText());
                                                                                                   frameRSystem.swhematuria=0;
                                                                                                }//cierra el if de hematuria
                                                                                                else{
                                                                                                   if(frameRSystem.JRTrantCicloMestr.isSelected()==true && frameRSystem.swtransciclomestrual==1){
                                                                                                      frameRSystem.JFTtranstCicloMestr.setText(JEDPdetAP.getText());
                                                                                                      frameRSystem.swtransciclomestrual=0;
                                                                                                   }//cierra el if de transtornos ciclo mestrual
                                                                                                   else{
                                                                                                       if(frameRSystem.JRNicturia.isSelected()==true && frameRSystem.swnicturia==1){
                                                                                                         frameRSystem.JFTNicturia.setText(JEDPdetAP.getText());
                                                                                                         frameRSystem.swnicturia=0;
                                                                                                       }//cierra el if de nicturia
                                                                                                       else{
                                                                                                           if(frameRSystem.JRPolaquiuria.isSelected()==true && frameRSystem.swpolaquiuria==1){
                                                                                                             frameRSystem.JFTPalquiuria.setText(JEDPdetAP.getText());
                                                                                                             frameRSystem.swpolaquiuria=0;
                                                                                                           }//cierra el if de polaquiuria
                                                                                                           else{
                                                                                                               if(frameRSystem.JRTenesmoVesical.isSelected()==true && frameRSystem.swtenesmovesical==1){
                                                                                                                   frameRSystem.JFTTenesmovesical.setText(JEDPdetAP.getText());
                                                                                                                   frameRSystem.swtenesmovesical=0;
                                                                                                               }//cierra el if de tenesmo vesical
                                                                                                               else{
                                                                                                                   if(frameRSystem.JRCefalea.isSelected()==true && frameRSystem.swcefalea==1){
                                                                                                                      frameRSystem.JFTCefalea.setText(JEDPdetAP.getText());
                                                                                                                      frameRSystem.swcefalea=0;
                                                                                                                   }//cierra el if de cefalea
                                                                                                                   else{
                                                                                                                        if(frameRSystem.JRAlteracionMemoria.isSelected()==true && frameRSystem.swalteracionmemoria==1){
                                                                                                                           frameRSystem.JFTAlteracionMemoria.setText(JEDPdetAP.getText());
                                                                                                                           frameRSystem.swalteracionmemoria=0;
                                                                                                                        }//cierra el if de alteracionmemoria
                                                                                                                        else{
                                                                                                                             if(frameRSystem.JRAlteracionSensib.isSelected()==true && frameRSystem.swealteraciosensibilidad==1){
                                                                                                                                frameRSystem.JFTAlteracionSencib.setText(JEDPdetAP.getText());
                                                                                                                                frameRSystem.swealteraciosensibilidad=0;
                                                                                                                             }//cierra el if de alteracionsencibilidad
                                                                                                                             else{
                                                                                                                                  if(frameRSystem.JRAlteracionMotora.isSelected()==true && frameRSystem.swalteracionmotora==1){
                                                                                                                                     frameRSystem.JFTAlteracMotora.setText(JEDPdetAP.getText());
                                                                                                                                     frameRSystem.swalteracionmotora=0;
                                                                                                                                  }//cierra el if de alteracionmotora
                                                                                                                                  else{
                                                                                                                                       if(frameRSystem.JRVertigo.isSelected()==true && frameRSystem.swvertigo==1){
                                                                                                                                          frameRSystem.JFTVertigo.setText(JEDPdetAP.getText());
                                                                                                                                          frameRSystem.swvertigo=0;
                                                                                                                                       }//cierra el if de vertigo
                                                                                                                                       else{
                                                                                                                                          if(frameRSystem.JRArdorprurito.isSelected()==true && frameRSystem.swardorprurito==1){
                                                                                                                                             frameRSystem.JFTArdorPrurito.setText(JEDPdetAP.getText());
                                                                                                                                             frameRSystem.swardorprurito=0;
                                                                                                                                          }//cierra el if de ardorprurito
                                                                                                                                          else{
                                                                                                                                               if(frameRSystem.JRCansancio.isSelected()==true && frameRSystem.swcansancio==1){
                                                                                                                                                  frameRSystem.JFTCansancio.setText(JEDPdetAP.getText());
                                                                                                                                                  frameRSystem.swcansancio=0;
                                                                                                                                               }//cierra el if de cansancio
                                                                                                                                               else{
                                                                                                                                                   if(frameRSystem.JRVisionBorrosa.isSelected()==true && frameRSystem.swvisionborrosa==1){
                                                                                                                                                      frameRSystem.JFTVisionBorrosa.setText(JEDPdetAP.getText());
                                                                                                                                                      frameRSystem.swvisionborrosa=0;
                                                                                                                                                   }//cierra el if de visionborrosa
                                                                                                                                                   else{
                                                                                                                                                       if(frameRSystem.JRLagrimeo.isSelected()==true && frameRSystem.swlagrimeo==1){
                                                                                                                                                          frameRSystem.JFTLagrimeo.setText(JEDPdetAP.getText());
                                                                                                                                                          frameRSystem.swlagrimeo=0;
                                                                                                                                                       }//cierra el if de lagrimeo
                                                                                                                                                       else{
                                                                                                                                                           if(frameRSystem.JROjoRojo.isSelected()==true && frameRSystem.swojorojo==1){
                                                                                                                                                             frameRSystem.JFTOjoRojo.setText(JEDPdetAP.getText());
                                                                                                                                                             frameRSystem.swojorojo=0;
                                                                                                                                                           }//cierra el if de ojo rojo
                                                                                                                                                           else{
                                                                                                                                                               if(frameRSystem.JRTos.isSelected()==true && frameRSystem.swtos==1){
                                                                                                                                                                  frameRSystem.JFTTos.setText(JEDPdetAP.getText());
                                                                                                                                                                  frameRSystem.swtos=0;
                                                                                                                                                               }//cierra el if de tos
                                                                                                                                                               else{
                                                                                                                                                                  if(frameRSystem.JRDolorToraxico.isSelected()==true && frameRSystem.swdolortoraxico==1){
                                                                                                                                                                     frameRSystem.JFTDolorToraxico.setText(JEDPdetAP.getText());
                                                                                                                                                                     frameRSystem.swdolortoraxico=0;
                                                                                                                                                                  }//cierra el if de dolortoraxico
                                                                                                                                                                  else{
                                                                                                                                                                      if(frameRSystem.JRExpectoracion.isSelected()==true && frameRSystem.swexpectoracion==1){
                                                                                                                                                                        frameRSystem.JFTExpectoracion.setText(JEDPdetAP.getText());
                                                                                                                                                                        frameRSystem.swexpectoracion=0;
                                                                                                                                                                      }//cierra el if de expectoracion
                                                                                                                                                                      else{
                                                                                                                                                                         if(frameRSystem.JRDisfonia.isSelected()==true && frameRSystem.swdisfonia==1){
                                                                                                                                                                            frameRSystem.JFTDisfonia.setText(JEDPdetAP.getText());
                                                                                                                                                                            frameRSystem.swdisfonia=0;
                                                                                                                                                                         }//cierra el if de disfonia
                                                                                                                                                                         else{
                                                                                                                                                                              if(frameRSystem.JREpistaxis.isSelected()==true && frameRSystem.swepistaxis==1){
                                                                                                                                                                                 frameRSystem.JFTEpistaxis.setText(JEDPdetAP.getText());
                                                                                                                                                                                 frameRSystem.swepistaxis=0;
                                                                                                                                                                              }//cierra el if de epistaxis
                                                                                                                                                                              else{
                                                                                                                                                                                  if(frameRSystem.JRHipoacusia.isSelected()==true && frameRSystem.swhipoacusia==1){
                                                                                                                                                                                     frameRSystem.JFTHipoacusia.setText(JEDPdetAP.getText());
                                                                                                                                                                                     frameRSystem.swhipoacusia=0;
                                                                                                                                                                                  }//cierra el if de hipoacusia
                                                                                                                                                                                  else{
                                                                                                                                                                                      if(frameRSystem.JRObstruccionNasal.isSelected()==true && frameRSystem.swobstruccionnasal==1){
                                                                                                                                                                                         frameRSystem.JFTObstruccionNasal.setText(JEDPdetAP.getText());
                                                                                                                                                                                         frameRSystem.swobstruccionnasal=0;
                                                                                                                                                                                      }//cierra el if de obstruccion nasal
                                                                                                                                                                                      else{
                                                                                                                                                                                          if(frameRSystem.JRRinorrea.isSelected()==true && frameRSystem.swrinorrea==1){
                                                                                                                                                                                             frameRSystem.JFTRinorrea.setText(JEDPdetAP.getText());
                                                                                                                                                                                             frameRSystem.swrinorrea=0;
                                                                                                                                                                                          }//cierra el if de rinorrea
                                                                                                                                                                                          else{
                                                                                                                                                                                             if(frameRSystem.JRTinitus.isSelected()==true && frameRSystem.swtinitus==1){
                                                                                                                                                                                               frameRSystem.JFTTinitus.setText(JEDPdetAP.getText());
                                                                                                                                                                                               frameRSystem.swtinitus=0;
                                                                                                                                                                                             }//cierra el if de tinitus
                                                                                                                                                                                             else{
                                                                                                                                                                                                 if(frameRSystem.JRArtralgias.isSelected()==true && frameRSystem.swartralgias==1){
                                                                                                                                                                                                    frameRSystem.JFTArtralgias.setText(JEDPdetAP.getText());
                                                                                                                                                                                                    frameRSystem.swartralgias=0;
                                                                                                                                                                                                 }//cierra el if de artralgias
                                                                                                                                                                                                 else{
                                                                                                                                                                                                       if(frameRSystem.JRTendinitis.isSelected()==true && frameRSystem.swtendinitis==1){
                                                                                                                                                                                                          frameRSystem.JFTTendinitis.setText(JEDPdetAP.getText());
                                                                                                                                                                                                          frameRSystem.swtendinitis=0;
                                                                                                                                                                                                       }//cierra el if de tendinitis
                                                                                                                                                                                                       else{
                                                                                                                                                                                                            if(frameRSystem.JRLimitacionFuncional.isSelected()==true && frameRSystem.swlimitacionfuncional==1){
                                                                                                                                                                                                               frameRSystem.JFTLimitacionFunc.setText(JEDPdetAP.getText());
                                                                                                                                                                                                               frameRSystem.swlimitacionfuncional=0;
                                                                                                                                                                                                            }//cierra el if de limitacionfuncional
                                                                                                                                                                                                            else{
                                                                                                                                                                                                                if(frameRSystem.JRParentestesias.isSelected()==true && frameRSystem.swparestesias==1){
                                                                                                                                                                                                                   frameRSystem.JFTParestesias.setText(JEDPdetAP.getText());
                                                                                                                                                                                                                   frameRSystem.swparestesias=0;
                                                                                                                                                                                                                }//cierra el if de parestesias
                                                                                                                                                                                                                else{
                                                                                                                                                                                                                    if(frameRSystem.JRCervicalgia.isSelected()==true && frameRSystem.swcervicalgias==1){
                                                                                                                                                                                                                       frameRSystem.JFTCervicalgia.setText(JEDPdetAP.getText());
                                                                                                                                                                                                                       frameRSystem.swcervicalgias=0;
                                                                                                                                                                                                                    }//cierra el if de cervicalgias
                                                                                                                                                                                                                    else{
                                                                                                                                                                                                                        if(frameRSystem.JRDorsalgia.isSelected()==true && frameRSystem.swdorsalgia==1){
                                                                                                                                                                                                                           frameRSystem.JFTDorsalgia.setText(JEDPdetAP.getText());
                                                                                                                                                                                                                           frameRSystem.swdorsalgia=0;
                                                                                                                                                                                                                        }//cierra el if de dorsalgias
                                                                                                                                                                                                                        else{
                                                                                                                                                                                                                            if(frameRSystem.JRLumbalgia.isSelected()==true && frameRSystem.swlumbalgia==1){
                                                                                                                                                                                                                               frameRSystem.JFTLumbalgia.setText(JEDPdetAP.getText());
                                                                                                                                                                                                                               frameRSystem.swlumbalgia=0;
                                                                                                                                                                                                                            }//cierra el if de lumbalgias
                                                                                                                                                                                                                            else{
                                                                                                                                                                                                                                if(frameRSystem.JRIncapacitante.isSelected()==true && frameRSystem.swincapacitante==1){
                                                                                                                                                                                                                                   frameRSystem.JRIncapacitante.setText(JEDPdetAP.getText());
                                                                                                                                                                                                                                   frameRSystem.swincapacitante=0;
                                                                                                                                                                                                                                }//cierra el if de incapacitante
                                                                                                                                                                                                                                else{
                                                                                                                                                                                                                                     if(frameRSystem.JRCoronaria.isSelected()==true && frameRSystem.swcoronaria==1){
                                                                                                                                                                                                                                        frameRSystem.JFTCoronaria.setText(JEDPdetAP.getText());
                                                                                                                                                                                                                                        frameRSystem.swcoronaria=0;
                                                                                                                                                                                                                                     }//cierra el if de coronaria
                                                                                                                                                                                                                                     else{
                                                                                                                                                                                                                                         if(frameRSystem.JRArritmia.isSelected()==true && frameRSystem.swarritmia==1){
                                                                                                                                                                                                                                            frameRSystem.JFTArritmia.setText(JEDPdetAP.getText());
                                                                                                                                                                                                                                            frameRSystem.swarritmia=0;
                                                                                                                                                                                                                                         }//cierra el if de arritmia
                                                                                                                                                                                                                                         else{
                                                                                                                                                                                                                                             if(frameRSystem.JRHa.isSelected()==true && frameRSystem.swHA==1){
                                                                                                                                                                                                                                                frameRSystem.JFTha.setText(JEDPdetAP.getText());
                                                                                                                                                                                                                                                frameRSystem.swHA=0;
                                                                                                                                                                                                                                             }//cierra el if de arritmia

                                                                                                                                                                                                                                         }//cierra el else de HA
                                                                                                                                                                                                                                     }//cierra el else de arritmia

                                                                                                                                                                                                                                } //cierra el else de coronora
                                                                                                                                                                                                                            } //cierra el else incapacitante
                                                                                                                                                                                                                        } //cierra el else de lumbalgias
                                                                                                                                                                                                                    }//cierra el else de dorsalgias
                                                                                                                                                                                                                }//cierra el else de cervicalgias
                                                                                                                                                                                                            } //cierra el else de parestesias
                                                                                                                                                                                                       }//cierra el else limitacion funcional
                                                                                                                                                                                                 }  // cierra el else de tendinitis
                                                                                                                                                                                             } //cierra el else de artralgias
                                                                                                                                                                                          }//cierra el else de tinitus
                                                                                                                                                                                      } //cierra el else de rinorrea
                                                                                                                                                                                  } //cierra el else obstruccion nasal
                                                                                                                                                                             } //cierra el else de hipoacusia
                                                                                                                                                                         }//cierra el else de epistaxis
                                                                                                                                                                     }//  cierra el else de disfonia
                                                                                                                                                                  }  //cierra el else de xpectoracion
                                                                                                                                                               } //cierra el else de dolor toraxico
                                                                                                                                                           }//cierra el else de tos
                                                                                                                                                       }//cierra el else de ojo rojo
                                                                                                                                                   } //cierra el else de lagrimeo
                                                                                                                                               }//cierra el else de visionborrosa
                                                                                                                                          } //cierra el else de cansancio
                                                                                                                                       }//cierra el else de ardorprurito
                                                                                                                                  }//cierra el el else de vertigo
                                                                                                                             } //cierra el else de alteracion motora
                                                                                                                        } //cierra el else alteracionsencibilidad
                                                                                                                   }//cierra el else de alteracionmemoria
                                                                                                               }// cierra el else de cefalea
                                                                                                           } //cierra el else de tenesmovesical
                                                                                                       }//cierra el else de polaquiuria
                                                                                                   } //cierra el else de nicturia
                                                                                                }//cierra el else de transtornos ciclo mestrual
                                                                                            }//cierra el else de hematuria
                                                                                        }//cierra el else de disuria
                                                                                    }//cierra el else de disminucioncalibre
                                                                                } //cierra el else de dispepsia
                                                                            }//cierra el else de prurito
                                                                        }//cierra el else de sequedad
                                                                    }//  cierra el else de brote.
                                                                }
                                                           }//cierra el else de hiperhidrosis
                                                       }//cierra el else de sangrado
                                                   }//cierra el else de diarrea
                                              }//cierra el else de estrenimiento

                                          }//cierra el el else de epigastraiguia

                                     } //cierra el else de dolor abdominal
                                }//cierra el else de disnea
                           }//cierra el else de sincope
                  }//cierra el else de palpitaciones
                 }//cierra el else de lipotimia
            }//cierra el else del dolor precordial
            this.dispose();
            frameRSystem.setVisible(true);


    }//cierra el metodo procesors

    public void JEDPdetAP_keyReleased(KeyEvent e) {
       int c = e.getKeyCode();
       if (c == KeyEvent.VK_ESCAPE) {
           //System.out.println("damareis");
           editorproceso();
       }
    }

    /**
     * editorproceso
     */
    public void editorproceso() {
        if(swframe==0){
           procesoantfam();
       }//cierra el if del swframe=0
       else{
          if(swframe==1){
              procesoantper();
          }//cierra el swframe==1
          else{
               if(swframe==2){
                  procesors();
               }//cierra el if swframe==2
               else
                   procesoef();
          }//cierra el else cuando el swframe no es 0 ni 1
       }//cierra el else del swframe=0

    }
    /**
     * CDetallesAP
     */


}
