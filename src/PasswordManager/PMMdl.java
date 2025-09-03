package PasswordManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class PMMdl {
    //Initialize required variables
    private String UName, AName, UID, PW;
    private TreeMap<String, String> info;
    private List<String> aInfo;
    private File accounts;
    private BufferedWriter accountInfo;
    private BufferedReader br;
    private String listasString;
    private String account;
    private List<String> details;
    private Scanner scanner;
    private ArrayList<String> keys;
    private ArrayList<String> values;

    //Set the user's name
    public void setUName(String uName){
        UName = uName;
    }

    //Set the account name
    public void setAName(String aName){
        AName = aName;
    }

    //Set the user ID for the account
    public void setUID(String uID){
        UID = uID;
    }

    //Set the password for the account
    public void setPW(String pw){
        PW = pw;
    }

    //Puts the data into a list and maps it to the user
    public void setList(){
        aInfo = new ArrayList<>();
        aInfo.add(getAName());
        aInfo.add(getUID());
        aInfo.add(getPW());
    }



    public void setFileName(String UName){
        accounts = new File(UName + ".txt");
    }

    //Get the user's name
    public String getUName(){
        return UName;
    }

    //Get the account name
    public String getAName(){
        return AName;
    }

    //Get the user ID for the account
    public String getUID(){
        return UID;
    }

    //Get the password for the account
    public String getPW(){
        return PW;
    }

    //Get the map with the data
    public List getList(){
        return aInfo;
    }

    //Set file name
    public String getFileName(){
        return accounts.toString();
    }

    //If the file does not exist, create a file, then add the Map data to it in a String
    public void fileWrite() throws IOException{
        accountInfo = new BufferedWriter(new FileWriter(accounts, true));
        listasString = getList().toString().replaceAll("[\\p{Ps}\\p{Pe}]", "");
        if(accounts.createNewFile()){

            accountInfo.write(listasString);
            accountInfo.newLine();
            accountInfo.close();
        }
        else{//If the file exists, append the Map data to it in a String
            accountInfo.append(listasString);
            accountInfo.newLine();
            accountInfo.close();
        }
    }

    //Reads each line and puts the first entry of each line as a key and the remaining as values
    //then returns the values for the key with the account name
    public String readFile(String searchname, String acctname) throws FileNotFoundException, IOException{
        File myfile = new File(searchname + ".txt");
        info = new TreeMap<>();
        scanner = new Scanner(myfile);
        while(scanner.hasNextLine()){
            account = scanner.nextLine();
            String[] parts = account.split(",", 2);
            info.put(parts[0], parts[1]);
        }
        scanner.close();
        return info.get(acctname);
    }
}
