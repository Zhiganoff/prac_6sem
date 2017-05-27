package control;

import model.Product;

public class ProductBridge {
    private Long id;
    private String name;
    private Integer cost;
    private Integer num;
    private String size;
    private String properties;
    private Long producttypeId;
    private Long producerId;

    public ProductBridge() {}

    public ProductBridge(Product p) {
        this.id = p.getId();
        this.name = p.getName();
        this.cost = p.getCost();
        this.num = p.getNum();
        this.size = p.getSize();
        this.properties = p.getProperties();
        this.producerId = p.getProducerByProducerId().getId();
        this.producttypeId = p.getProductTypeByProducttypeId().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public Long getProducttypeId() {
        return producttypeId;
    }

    public void setProducttypeId(Long producttypeId) {
        this.producttypeId = producttypeId;
    }

    public Long getProducerId() {
        return producerId;
    }

    public void setProducerId(Long producerId) {
        this.producerId = producerId;
    }
}

