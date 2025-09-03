package PasswordManager;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class PMMdl {
    private String AName;
    private String UID;
    private String PW;
    private List<String> aInfo;
    private File accounts;

    //Set the user's name
    public void setUName(){
        //Initialize required variables
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

    //If the file does not exist, create a file, then add the Map data to it in a String
    public void fileWrite() throws IOException{
        BufferedWriter accountInfo = new BufferedWriter(new FileWriter(accounts, true));
        String listasString = getList().toString().replaceAll("[\\p{Ps}\\p{Pe}]", "");
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
    public String readFile(String searchName, String acctName) throws IOException{
        File myfile = new File(searchName + ".txt");
        TreeMap<String, String> info = new TreeMap<>();
        Scanner scanner = new Scanner(myfile);
        while(scanner.hasNextLine()){
            String account = scanner.nextLine();
            String[] parts = account.split(",", 2);
            info.put(parts[0], parts[1]);
        }
        scanner.close();
        return info.get(acctName);
    }
}
