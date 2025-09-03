package PasswordManager;

import java.io.IOException;

public class PMCtrl {
    private final PMMdl model;

    public PMCtrl(){
        model = new PMMdl();
        PMView view = new PMView(this);
        view.setVisible(true);
    }

    public void setUName(){
        model.setUName();
    }

    public void setAName(String aName){
        model.setAName(aName);
    }

    public void setUID(String UID){
        model.setUID(UID);
    }

    public void setPW(String PW){
        model.setPW(PW);
    }

    public void setList(){
        model.setList();
    }

    public void setFileName(String name){
        model.setFileName(name);
    }

    public void fileWrite() throws IOException{
        model.fileWrite();
    }

    public String readFile(String name, String acctName) throws IOException{
        return model.readFile(name, acctName);
    }
}
