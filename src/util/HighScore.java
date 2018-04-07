package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class HighScore
{
    private FileWriter fw;
    private BufferedWriter bw;
    private PrintWriter pw;

    private FileReader fr;
    private BufferedReader br;

    private StringTokenizer st;

    //"/home/mango/Documents/Platformer/res/scores/test"
    public HighScore(String path) 
    {
        try
        {
            fw = new FileWriter(path,true);
            fr = new FileReader(path);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        bw = new BufferedWriter(fw);
        pw = new PrintWriter(bw);

        br = new BufferedReader(fr);
    }

    public String getScore() 
    {
        String t = null;
        try 
        {
            t = br.readLine();
            if(t != null)
            {
                st = new StringTokenizer(t);
                while(st.hasMoreElements())
                {
                    t = st.nextToken("/");

                }
            }

        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        return t;
    }

    public void updateScore(String currentScore,String hScore)
    {
        if(hScore == null)
        {
            pw.print(currentScore + "/");
            pw.close();
        }
        else if(Integer.parseInt(currentScore)>Integer.parseInt(hScore))
        {
            pw.print(currentScore + "/");
            pw.close();
        }
    }

}
