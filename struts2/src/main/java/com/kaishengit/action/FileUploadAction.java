package com.kaishengit.action;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.List;

public class FileUploadAction extends BaseAction {

    private String name;
    private List<File> doc;
    private List<String> docFileName;
    private List<String> docContentType;


    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public String save() throws Exception {
        System.out.println("Name:" + name);

        for(int i = 0;i < doc.size();i++) {
            File file = doc.get(i);
            System.out.println("File Size:" + file.length());
            System.out.println("real Name:" + docFileName.get(i));
            System.out.println("content Type:" + docContentType.get(i));

            InputStream inputStream = new FileInputStream(file);
            OutputStream outputStream = new FileOutputStream("D:/"+docFileName.get(i));

            IOUtils.copy(inputStream,outputStream);

            outputStream.flush();
            outputStream.close();
            inputStream.close();

        }

        return SUCCESS;
    }

    //get set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<File> getDoc() {
        return doc;
    }

    public void setDoc(List<File> doc) {
        this.doc = doc;
    }

    public List<String> getDocFileName() {
        return docFileName;
    }

    public void setDocFileName(List<String> docFileName) {
        this.docFileName = docFileName;
    }

    public List<String> getDocContentType() {
        return docContentType;
    }

    public void setDocContentType(List<String> docContentType) {
        this.docContentType = docContentType;
    }
}
