package DAO.QICQ;

public class Filetrans {
    String src;
    String dest;
    long filelen;
    byte[] content;
    String name;
    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public long getFilelen() {
        return filelen;
    }

    public void setFilelen(int filelen) {
        this.filelen = filelen;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
