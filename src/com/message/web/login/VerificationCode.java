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
 * 验证码
 */
@WebServlet("/VirificationCode")
public class VerificationCode extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public VerificationCode() {
        super();
    }
    
    /**
     * 设置字体方法,返回字体Font
     */
    public Font getFont() {
    	
    	//产生随即类
    	Random random=new Random();
    	//产生字体对象
        //定义保存多种字体的数组
    	Font[] font=new Font[2];
    	//声明每一个数组元素
    	font[0]=new Font("宋体",Font.PLAIN,25);
    	font[1]=new Font("黑体",Font.PLAIN,25);
    	
    	
    	return font[random.nextInt(2)];
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//1.设置输出的类型为图片类型
		//使用response来得到
		response.setContentType("image/jpeg");
		
		//2.要清空缓存。
		//靠response来清空  http 头 缓存的属性名: Cache-Control 
		response.setHeader("Cache-Control","no-cache");
		
		//2.5准备宽度和高度
		int  width=80;
		int  height=30; 

		//3.产生画板的缓存图片类
		BufferedImage image=new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
		
		
		//4.马上通过缓存图片类产生画板
		Graphics g=image.getGraphics();  
		
		//5.可以通过g对象来画内容. 
		//5.1画出验证码的矩形框
		g.fillRect(0, 0, width, height);
		
		
		//框中的数据，a-z0-9  
		//定义数据，类型为char数组 
		char[] ch="abcdefghijklmnopqrstuvxwyz0123456789".toCharArray();
		
		//数组的长度得到    styz
		int length=ch.length;
		
		//定义一个最终的字符串变量，接收4个字符
		String ch2="";  
		
		//定义随机类
		Random random=new Random();
		
		//对数组遍历,循环4次，取4个字符
		for(int i=0;i<4;i++) {
			//char-->Character-->String
			String cc=new Character(ch[random.nextInt(length)]).toString();
			//取出的每个字符累加起来，放入ch2.
			ch2+=cc;
			
			//给验证码的字符设置颜色 
			//通过g对象设置颜色
			g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
			
		    //设置字体,通过g画板设置字体
			g.setFont(getFont());
			
			//画出这每一个字符
			//g画出字符
			g.drawString(cc,20*i+6,25);

		}
		
		//画干扰线
		//循环
		for(int i=0;i<20;i++) {
			//干扰点的坐标,产生随机坐标
			int x=random.nextInt(width);
			int y=random.nextInt(height);
			//通过画板
			g.drawOval(x, y,2,2);
		}

		//最后做清理工作
		g.dispose();
		
		//验证码要保存起来，保存到一个会话中
		request.getSession().setAttribute("safecode", ch2);
		
		//产生一个输出流
	    //response产生
		OutputStream os=response.getOutputStream();
	
		//页面显示出最终的验证码 ,通过imageIo类
		ImageIO.write(image,"jpeg",os);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
