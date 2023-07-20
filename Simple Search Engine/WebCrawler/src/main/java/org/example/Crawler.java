package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;

public class Crawler {
    HashSet<String> urlSet;
    int Max_Depth = 2;

    Crawler(){
        urlSet = new HashSet<String>();
    }

    public void getPagesAndLinks(String url,int depth){
        if(urlSet.contains(url)){
            return;
        }
        if (depth >= Max_Depth){
            return;
        }
        urlSet.add(url);
        depth++;
        //here the jsup will convert the html object from url to java object
       try  {
            Document document = Jsoup.connect(url).timeout(5000).get();

            //Indexer work
           Indexer indexer = new Indexer(document,url);
            System.out.println(document.title());

            //getting all href link from webpage
            Elements AvailableLinksOnPage = document.select("a[href]");
            for (Element CurrLinks : AvailableLinksOnPage) {
                //here we use attr function to convert href links which is in <a> tag from element obj to string
                getPagesAndLinks(CurrLinks.attr("abs:href"), depth);
            }
        }
       catch (IOException ioException){
           ioException.printStackTrace();
       }

    }
    public static void main(String[] args) {
        Crawler crawler = new Crawler();
        crawler.getPagesAndLinks("https://javatpoint.com",0);
    }
}