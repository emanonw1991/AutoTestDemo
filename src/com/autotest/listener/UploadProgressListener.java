package com.autotest.listener;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.ProgressListener;

import com.autotest.entity.FileUploadProgress;

/**
 * Created by zipple on 2017/10/13.
 * 监听文件上传情况
 * 实现org.apache.commons.fileupload.ProgressListener接口
 */
public class UploadProgressListener implements ProgressListener {
	
	private HttpSession session;//创建监听器实例的时候获取session

    //在自定义的MultiPartRequest 类中 创建此监听器的实例
    public UploadProgressListener(HttpServletRequest request) {
        session = request.getSession();
        FileUploadProgress fileUploadProgress = new FileUploadProgress();
        fileUploadProgress.setFlag(false);
        session.setAttribute("fileUploadProgress", fileUploadProgress);
    }
    @Override
    public void update(long readBytes, long totalBytes, int currentItem) {
        //实现文件上传的核心方法
        Object attribute = session.getAttribute("fileUploadProgress");
//        System.out.println("当前已读取:"+readBytes+" 总长度:"+totalBytes+" 正在保存:"+currentItem);
        FileUploadProgress fileUploadProgress;
        if(null == attribute){
            fileUploadProgress = new FileUploadProgress();
            fileUploadProgress.setFlag(false);
            System.out.println("uploadListener文件上传的开始时间："+fileUploadProgress.getStartTime());
            session.setAttribute("fileUploadProgress", fileUploadProgress);
        }else{
            fileUploadProgress = (FileUploadProgress)attribute;
        }
        fileUploadProgress.setCurrentLength(readBytes);
        fileUploadProgress.setTotalLength(totalBytes);
        if(readBytes==totalBytes){
            fileUploadProgress.setFlag(true);
        }else{
            fileUploadProgress.setFlag(false);
        }
        session.setAttribute("fileUploadProgress", fileUploadProgress);
    }

}
