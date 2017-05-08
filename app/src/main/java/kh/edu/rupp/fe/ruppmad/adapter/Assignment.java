package kh.edu.rupp.fe.ruppmad.adapter;

/**
 * Created by MK COMPUTER on 5/6/2017.
 */

public class Assignment {

    private String title;
    private String thumbnailUrl;
    private String date;

    public Assignment(String title, String thumbnailUrl, String date){
        this.title = title;
        this.thumbnailUrl = thumbnailUrl;
        this.date = date;
    }


    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title; }
    public String getThumbnailUrl() {return  thumbnailUrl; }
    public void setThumbnailUrl(String thumbnailUrl) {this.thumbnailUrl = thumbnailUrl; }
    public String getDate() {return date;}
//    public void setSize(int size) {this.size = size; }
    public String getFormatSize() {return  "Deadline " + date;}
}
