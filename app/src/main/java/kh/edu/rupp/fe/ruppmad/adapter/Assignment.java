package kh.edu.rupp.fe.ruppmad.adapter;

/**
 * Created by MK COMPUTER on 5/6/2017.
 */

public class Assignment {

    private String title;
    private String thumbnailUrl;
    private int size;

    public Assignment(String title, String thumbnailUrl, int size){
        this.title = title;
        this.thumbnailUrl = thumbnailUrl;
        this.size = size;
    }

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title; }
    public String getThumbnailUrl() {return  thumbnailUrl; }
    public void setThumbnailUrl(String thumbnailUrl) {this.thumbnailUrl = thumbnailUrl; }
    public int getSize() {return size;}
    public void setSize(int size) {this.size = size; }
    public String getFormatSize() {return  size + "M";}
}
