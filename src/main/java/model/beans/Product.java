package model.beans;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable {
    private int id;
    private String name;
    private String extension;
    private int pieces;
    private int price;
    private String imagePath;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getExtension() {
        return extension;
    }

    public int getPieces() {
        return pieces;
    }

    public int getPrice() {
        return price;
    }

    public String getImagePath() {
        return imagePath;
    }


    private Product(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.extension = builder.extension;
        this.pieces = builder.pieces;
        this.price = builder.price;
        this.imagePath = builder.imagePath;
    }

    public static class Builder {
    private int id;
    private String name;
    private String extension;
    private int pieces;
    private int price;
    private String imagePath;

        public Builder(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public Builder extension(String extension) {
            this.extension = extension;
            return this;
        }

        public Builder pieces(int pieces) {
            this.pieces = pieces;
            return this;
        }

        public Builder price(int price) {
            this.price = price;
            return this;
        }

        public Builder imagePath(String path) {
            this.imagePath = path;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }

    public String toString() {
        StringBuilder build = new StringBuilder();
        build.append("ID :");
        build.append(id);
        build.append("商品名 : ");
        build.append(name);
        build.append("説明　：");
        build.append(extension);
        build.append("個数");
        build.append(pieces);
        build.append("値段");
        build.append(price);
        build.append("画像");
        build.append(imagePath);
        return build.toString();
    }

    public boolean equal(Object o) {
        if (o == this) return true;
        if (o == null) return false;
        if (!(o instanceof Product)) return false;
        Product r = (Product)o;
        if (r.id == this.id && this.name.trim().equals(r.name.trim())) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(this.id,this.name);
    }
}
