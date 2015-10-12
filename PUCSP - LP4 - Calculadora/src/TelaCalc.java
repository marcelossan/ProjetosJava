



import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;


import javax.swing.JPanel;
import javax.swing.JTextField;


public class TelaCalc {
	JFrame janela;
	JPanel contentPanel;
	JButton botaoResult;
	JButton botaoSoma;
	JButton botaoSub;
	JButton botaoDivisao;
	JButton botaoMult;
	JButton botaoPonto;
	JButton botaoDel;
	JButton botaoCE;
	JButton botao0; 
	JButton botao1;
	JButton botao2;
	JButton botao3;
	JButton botao4;
	JButton botao5;
	JButton botao6;
	JButton botao7;
	JButton botao8;
	JButton botao9;
	JTextField visor;
	String exp;
	Double d1 ;
	Double d2 ;
	Double result ;
	char operador = '\u0000';
	String logResult;
	CriaLogTxt log;
		// TODO Auto-generated catch block
	
	TelaCalc() throws IOException {
		exp = "";
		d1 = 0.0;
		d2 = 0.0;
		result = 0.0;
		log = new CriaLogTxt();
	}
	
	public void CriaFrame(){
		janela = new JFrame("Calculadora");
	    janela.setSize(260, 190);	
		janela.setResizable(false);
		janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		janela.addWindowListener(new 
				WindowAdapter(){
			public void windowClosing(WindowEvent event){
					try {
						funcaoSair();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
					// TODO Auto-generated catch block
			}
		});
		 
	}
	
	public void CriaPanel(){
		contentPanel = new JPanel();
		contentPanel.setBackground(Color.gray);
		
	}
	public void CriaButton(){
		botao0 = new JButton("0"); 
		botao1 = new JButton("1");
		botao2 = new JButton("2");
		botao3 = new JButton("3");
		botao4 = new JButton("4");
		botao5 = new JButton("5");
		botao6 = new JButton("6");
		botao7 = new JButton("7");
		botao8 = new JButton("8");
		botao9 = new JButton("9");
		botaoPonto = new JButton(".");
		botaoSoma = new JButton("+");
		botaoSub = new JButton("-");
		botaoDivisao = new JButton("/");
		botaoMult = new JButton("x");
		botaoResult = new JButton("=");
		botaoDel = new JButton("Del");
		botaoCE = new JButton("CE");
	}
	
	
	
		
	
	
	
	public void CriaTextField(){
		visor = new JTextField(20);
		visor.setEditable(false);
		visor.setBackground(Color.WHITE);
	}
	
	public void AddItem(){
		contentPanel.add(visor);
		contentPanel.add(botao7);
		contentPanel.add(botao8);
		contentPanel.add(botao9);
		contentPanel.add(botaoDel);
		contentPanel.add(botaoCE);
		contentPanel.add(botao4);
		contentPanel.add(botao5);
		contentPanel.add(botao6);
		contentPanel.add(botaoMult);
		contentPanel.add(botaoDivisao);
		contentPanel.add(botao1);
		contentPanel.add(botao2);
		contentPanel.add(botao3);
		contentPanel.add(botaoSoma);
		contentPanel.add(botaoSub);
		contentPanel.add(botao0);
		contentPanel.add(botaoPonto);
		contentPanel.add(botaoResult);		
		janela.add(contentPanel);
	}
	
	
	
	public void addEvento(){
	     botao0.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	clickBtnNumero(botao0);        	         		
	            }
	        });

	     botao1.addActionListener(new java.awt.event.ActionListener() {
		            public void actionPerformed(java.awt.event.ActionEvent evt) {
		            	clickBtnNumero(botao1);		            	   	
		            }
		        });
	     
	     
	     botao2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	clickBtnNumero(botao2);		
	            }
	        });

	     botao3.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	clickBtnNumero(botao3);		
	            }
	        });

	     botao4.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	clickBtnNumero(botao4);		
	            }
	        });

	     botao5.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	clickBtnNumero(botao5);		
	            }
	        });

	     botao6.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	clickBtnNumero(botao6);		
	            }
	        });

	     botao7.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	clickBtnNumero(botao7);		
	            }
	        });
	     
	     botao8.addActionListener(new java.awt.event.ActionListener() {
	         public void actionPerformed(java.awt.event.ActionEvent evt) {
	        	 clickBtnNumero(botao8);	
	         }
	     });

	    botao9.addActionListener(new java.awt.event.ActionListener() {
	         public void actionPerformed(java.awt.event.ActionEvent evt) {
	        	 clickBtnNumero(botao9); 
	         }
	     });
	     
	     botaoPonto.addActionListener(new java.awt.event.ActionListener() {
	         public void actionPerformed(java.awt.event.ActionEvent evt) {
	        	inserePonto();	
	         }
	     });

	     
	     botaoDel.addActionListener(new java.awt.event.ActionListener() {
	         public void actionPerformed(java.awt.event.ActionEvent evt) {
	        	deleta();
	         }
	     });
	     
	     botaoCE.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	limpaDados();	
	            }
	        });
	     
	     botaoResult.addActionListener(new java.awt.event.ActionListener() {
	         public void actionPerformed(java.awt.event.ActionEvent evt) {
	        	obtemResultado();
	         }
	     });

	     botaoSoma.addActionListener(new java.awt.event.ActionListener() {
	         public void actionPerformed(java.awt.event.ActionEvent evt) {
	        	 clickBtnOperacao(botaoSoma);    	
	         }
   	 
	     });
	     
	     botaoSub.addActionListener(new java.awt.event.ActionListener() {
	         public void actionPerformed(java.awt.event.ActionEvent evt) {
	        	 clickBtnOperacao(botaoSub);	        	
	        
	         }
        	 
	     });
	     
	     
	     
	    botaoMult.addActionListener(new java.awt.event.ActionListener() {
	         public void actionPerformed(java.awt.event.ActionEvent evt) {
	        	 clickBtnOperacao(botaoMult);	         	
	         }
	     });
	   
	   
	    botaoDivisao.addActionListener(new java.awt.event.ActionListener() {
	         public void actionPerformed(java.awt.event.ActionEvent evt) {
	        	 clickBtnOperacao(botaoDivisao);		        	  	
	         }
	     });
	}
	
	
	public void clickBtnNumero(JButton b){	
		if(operador == '\u0000'){
    		d1 = 0.0;
    	}
    	exp = exp + b.getText();
    	visor.setText(exp);
	}
	
	
	public void clickBtnOperacao(JButton op){
		if(exp != ""){
			if(d1 == 0.0){
				d1 = Double.parseDouble(exp);
			} else {
				d2 = Double.parseDouble(exp);
			}
		}
 	
		exp = "";
 		
		if((operador == '/') || (operador == '+')|| (operador == '-')|| (operador == 'x')){	
			if((d1 != 0.0) & (d2 != 0.0) & (operador != '\u0000')){	
				CalcBasic calculo = new CalcBasic(d1, operador, d2);
				result = calculo.calcular();
				logResult = String.valueOf(d1)+" "+String.valueOf(operador)+" "+String.valueOf(d2)+" = "+String.valueOf(result);
	        	log.gravaLog(String.valueOf(logResult));   
				exp = String.valueOf(result);
				visor.setText(exp);	
			}
			operador = op.getText().charAt(0);
			exp = "";
			d1 = result;
			d2 = 0.0;
		}else {
			operador = op.getText().charAt(0);	
		}
	}
 	
	public void obtemResultado(){	 
    	if((exp != "") && (operador != '\u0000')){
    		d2 = Double.parseDouble(exp);
    		CalcBasic calculo = new CalcBasic(d1, operador, d2);
    		result = calculo.calcular();				
    		logResult = String.valueOf(d1)+" "+String.valueOf(operador)+" "+String.valueOf(d2)+" = "+String.valueOf(result);
        	log.gravaLog(String.valueOf(logResult));        				
        	exp = "";
        	d1 = result;
        	operador = '\u0000';
        	d2= 0.0;
        	visor.setText(String.valueOf(result)); 
    	 }
    	
	}
	
	public void limpaDados(){
		exp = "";
    	visor.setText(exp);
    	operador = '\u0000';
    	d1 = 0.0;
    	d2 = 0.0;
    	result = 0.0;
	}

	public void deleta(){
		 exp = visor.getText();
    	 if(exp.length()>1)	{
    		exp = exp.substring(0, exp.length()-1);
    		visor.setText(exp);	 
    	 }else{
    		 exp = "";
    		 visor.setText(exp);
    	 }
	}
	
	public void inserePonto(){
		 if(exp != ""){
    		 if(exp.contains(".")){	 
    		 }else{
    			 	exp = exp + botaoPonto.getText();
    		 }
    	 }
    	 
	}
	
	public void mostraTela(){
		janela.setLocationRelativeTo(null);  
		janela.setVisible(true);
	}
	
	
	public void funcaoSair() throws IOException {
		log.fechaLog();
		janela.dispose();
		System.exit(0);		
	}
	
	
}
