
import javax.imageio.ImageIO;
import javax.swing.JFrame;

import org.bytedeco.javacv.*;
import org.bytedeco.javacv.FrameGrabber.Exception;
import org.opencv.core.*;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 调用本地摄像头窗口视频
 * @author eguid
 * @version 2016年6月13日
 * @see //javavcCameraTest
 * @since  javacv1.2
 */

public class JavavcCameraTest{
    static {
        // Java 在使用 OpenCV 前必须加载 Core.NATIVE_LIBRARY_NAME 类,否则会报错
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }


    public static void main(String[] args) throws Exception, InterruptedException{

        OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);//0表示本机摄像头  当然这里也可以换成网络摄像头地址
        grabber.start();   //开始获取摄像头数据
        CanvasFrame canvas = new CanvasFrame("摄像头");//新建一个窗口
        canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//窗口关闭时程序运行结束
        canvas.setAlwaysOnTop(true);
        int i=0;

        while(true){
            if(!canvas.isDisplayable()){//窗口是否关闭
                System.out.println("已关闭");
                grabber.stop();//停止抓取
                System.exit(2);//退出
            }
            canvas.showImage(grabber.grab());//获取摄像头图像并放到窗口上显示， 这里的Frame frame=grabber.grab(); frame表示一帧视频图像
            //调用doExecuteFrame()方法，将截取的图片保存在本地
            doExecuteFrame(grabber.grabFrame(),"D:\\javaResource\\images\\"+i+".jpg");
            Thread.sleep(0);//50毫秒刷新一次图像
            i++;
        }


    }
    /**
     *
     * @param f 表示帧
     * @param targetFileName 存储路径
     */
    public static void doExecuteFrame(Frame f,String targetFileName) {
        if (null ==f ||null ==f.image) {
            return;
        }
        Java2DFrameConverter converter =new Java2DFrameConverter();
        BufferedImage bi =converter.getBufferedImage(f);
        File output =new File(targetFileName);
        try {
            ImageIO.write(bi,"jpg",output);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}