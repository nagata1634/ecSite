package model.dao;

import java.util.List;
import java.util.Optional;

import model.beans.Product;

public interface ProductDao {
    public List<Product> list(int start, int end);

    public Product search(int productId);

    public Optional<Integer> pieces();

}
