package com.project.comm.base;

public class RequestModel<TModel> {
    /**
     * 页码
     */
    private int page;
    /**
     * 分页尺寸
     */
    private int size;
    /**
     * 请求模型
     */
    private TModel model;

    public RequestModel() {
    }

    public RequestModel(int page, int size, TModel model) {
        this.page = page;
        this.size = size;
        this.model = model;
    }

    public RequestModel(TModel model) {
        this.model = model;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public TModel getModel() {
        return model;
    }

    public void setModel(TModel model) {
        this.model = model;
    }
}
