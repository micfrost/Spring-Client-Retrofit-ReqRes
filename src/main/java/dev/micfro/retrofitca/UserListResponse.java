package dev.micfro.retrofitca;

import java.util.List;

public class UserListResponse {
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<User> data;
    private Support support;

    public int getPage() { return page; }
    public int getPerPage() { return per_page; }
    public int getTotal() { return total; }
    public int getTotalPages() { return total_pages; }
    public List<User> getData() { return data; }
    public void setData(List<User> data) { this.data = data; }
    public Support getSupport() { return support; }
    public void setSupport(Support support) { this.support = support; }
}
