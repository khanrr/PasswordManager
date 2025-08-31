package PasswordManager;

import java.io.IOException;
import java.util.List;

public class PMCtrl {
    private final PMMdl model;
    private final PMView view;

    public PMCtrl(){
        model = new PMMdl();
        view = new PMView(this);
        view.setVisible(true);
    }

    public void setUName(String name){
        model.setUName(name);
    }
    public String getUName(){
        return model.getUName();
    }

    public void setAName(String aName){
        model.setAName(aName);
    }
    public String getAName(){
        return model.getAName();
    }

    public void setUID(String UID){
        model.setUID(UID);
    }
    public String getUID(){
        return model.getUID();
    }

    public void setPW(String PW){
        model.setPW(PW);
    }
    public String getPW(){
        return model.getPW();
    }

    public void setList(){
        model.setList();
    }
    public List getList(){
        return model.getList();
    }

    public void setFileName(String name){
        model.setFileName(name);
    }
    public String getFileName(){
        return model.getFileName();
    }

    public void setView(){
        view.setVisible(true);
    }

    public void fileWrite() throws IOException{
        model.fileWrite();
    }

    public String readFile(String name, String acctname) throws IOException{
        return model.readFile(name, acctname);
    }
}
