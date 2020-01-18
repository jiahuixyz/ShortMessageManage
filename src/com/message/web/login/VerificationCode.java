package com.message.web.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��֤��
 */
@WebServlet("/VirificationCode")
public class VerificationCode extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public VerificationCode() {
        super();
    }
    
    /**
     * �������巽��,��������Font
     */
    public Font getFont() {
    	
    	//�����漴��
    	Random random=new Random();
    	//�����������
        //���屣��������������
    	Font[] font=new Font[2];
    	//����ÿһ������Ԫ��
    	font[0]=new Font("����",Font.PLAIN,25);
    	font[1]=new Font("����",Font.PLAIN,25);
    	
    	
    	return font[random.nextInt(2)];
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//1.�������������ΪͼƬ����
		//ʹ��response���õ�
		response.setContentType("image/jpeg");
		
		//2.Ҫ��ջ��档
		//��response�����  http ͷ �����������: Cache-Control 
		response.setHeader("Cache-Control","no-cache");
		
		//2.5׼����Ⱥ͸߶�
		int  width=80;
		int  height=30; 

		//3.��������Ļ���ͼƬ��
		BufferedImage image=new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
		
		
		//4.����ͨ������ͼƬ���������
		Graphics g=image.getGraphics();  
		
		//5.����ͨ��g������������. 
		//5.1������֤��ľ��ο�
		g.fillRect(0, 0, width, height);
		
		
		//���е����ݣ�a-z0-9  
		//�������ݣ�����Ϊchar���� 
		char[] ch="abcdefghijklmnopqrstuvxwyz0123456789".toCharArray();
		
		//����ĳ��ȵõ�    styz
		int length=ch.length;
		
		//����һ�����յ��ַ�������������4���ַ�
		String ch2="";  
		
		//���������
		Random random=new Random();
		
		//���������,ѭ��4�Σ�ȡ4���ַ�
		for(int i=0;i<4;i++) {
			//char-->Character-->String
			String cc=new Character(ch[random.nextInt(length)]).toString();
			//ȡ����ÿ���ַ��ۼ�����������ch2.
			ch2+=cc;
			
			//����֤����ַ�������ɫ 
			//ͨ��g����������ɫ
			g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
			
		    //��������,ͨ��g������������
			g.setFont(getFont());
			
			//������ÿһ���ַ�
			//g�����ַ�
			g.drawString(cc,20*i+6,25);

		}
		
		//��������
		//ѭ��
		for(int i=0;i<20;i++) {
			//���ŵ������,�����������
			int x=random.nextInt(width);
			int y=random.nextInt(height);
			//ͨ������
			g.drawOval(x, y,2,2);
		}

		//�����������
		g.dispose();
		
		//��֤��Ҫ�������������浽һ���Ự��
		request.getSession().setAttribute("safecode", ch2);
		
		//����һ�������
	    //response����
		OutputStream os=response.getOutputStream();
	
		//ҳ����ʾ�����յ���֤�� ,ͨ��imageIo��
		ImageIO.write(image,"jpeg",os);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
