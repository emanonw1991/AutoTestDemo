package com.autotest.listener;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.ProgressListener;

import com.autotest.entity.FileUploadProgress;

/**
 * Created by zipple on 2017/10/13.
 * �����ļ��ϴ����
 * ʵ��org.apache.commons.fileupload.ProgressListener�ӿ�
 */
public class UploadProgressListener implements ProgressListener {
	
	private HttpSession session;//����������ʵ����ʱ���ȡsession

    //���Զ����MultiPartRequest ���� �����˼�������ʵ��
    public UploadProgressListener(HttpServletRequest request) {
        session = request.getSession();
        FileUploadProgress fileUploadProgress = new FileUploadProgress();
        fileUploadProgress.setFlag(false);
        session.setAttribute("fileUploadProgress", fileUploadProgress);
    }
    @Override
    public void update(long readBytes, long totalBytes, int currentItem) {
        //ʵ���ļ��ϴ��ĺ��ķ���
        Object attribute = session.getAttribute("fileUploadProgress");
//        System.out.println("��ǰ�Ѷ�ȡ:"+readBytes+" �ܳ���:"+totalBytes+" ���ڱ���:"+currentItem);
        FileUploadProgress fileUploadProgress;
        if(null == attribute){
            fileUploadProgress = new FileUploadProgress();
            fileUploadProgress.setFlag(false);
            System.out.println("uploadListener�ļ��ϴ��Ŀ�ʼʱ�䣺"+fileUploadProgress.getStartTime());
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
