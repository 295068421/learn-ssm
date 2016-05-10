package com.kaishengit.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DownloadAction extends BaseAction {

    private String name;
    private long size;

    @Override
    public String execute() throws Exception {
        File file = new File("D:/upload/old",name);
        if(file.exists()) {
            size = file.length();
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public InputStream getFileInputStream() throws IOException {
        return new FileInputStream(new File("D:/upload/old",name));
    }



    //get set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
