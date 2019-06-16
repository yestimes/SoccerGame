package cn.nchu.soccer.repository;

import cn.nchu.soccer.model.News;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository("NewsRepository")
public class NewsRepository {
	public List<News> findAll() {
		List<News> list = new ArrayList<News>();
		String url = "http://sports.sina.com.cn/global/";
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
            Elements listDiv = doc.getElementsByAttributeValue("class", "blk2");
            int n = 0;
            for(Element element : listDiv){
                Elements texts = element.getElementsByTag("a");
                for(Element text:texts){
                	if(n>=20) break;
                	News news = new News();
                    String ptext = text.text();
                    String ptext2 = text.outerHtml();
                    int endSigal = ptext2.indexOf('"', 10);
                    String address = ptext2.substring(9, endSigal);
                    int dateStart = address.indexOf('2', 19);
                    String date = address.substring(dateStart, dateStart+10);
                    news.setContent(ptext);
                    news.setUrl(address);
                    news.setDate(date);
                    list.add(news);
                    //System.out.println(ptext+"\n"+address);
                    n++;
                }
                System.out.println("成功抓取到" + n+"条新闻");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		return list; 
	}
	
	
}
