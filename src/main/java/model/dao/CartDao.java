package model.dao;

import java.util.List;

import model.beans.Product;

public interface CartDao {
    public boolean addCart(int productId, int userId);

    public List<Product> getCartList(int userId);
}
