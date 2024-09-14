package model.beans;

import java.io.Serializable;

public class Page implements Serializable {
    private int totalProducts;
    private int pageItem;
    private int page;

    public Page (int page, int totalProducts) {
        this.page = page;
        this.totalProducts = totalProducts;
    }
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
    public int getPageItem() {
        return pageItem;
    }
    public void setPageItem(int pageItem) {
        this.pageItem = pageItem;
    }

    public int pageCount() {

        boolean fraction = (totalProducts % pageItem == 0) ? true : false;

        int pageCount = (fraction) ? totalProducts / pageItem : totalProducts / pageItem + 1;

        return pageCount;
    }
}
