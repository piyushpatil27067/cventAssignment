package com.piyush.resources;

import com.piyush.api.Product;
import com.piyush.db.ProductDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("products")
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {

    ProductDao productDao;

    public ProductResource(ProductDao productDao) {
        this.productDao = productDao;
    }

    @GET
    public Response getProducts() {
        List<Product> allProducts = productDao.getAllProducts();
        return Response.ok(allProducts).build();
    }

    @POST
    public String createProduct(Product product) {
        productDao.insert(product);
        return "Product inserted";
    }

    @PUT
    @Path("/{id}")
    public String updateProduct(@PathParam("id")int id, Product product) {
        Product product1 = productDao.findById(id);
        String message = "Product updated";
        if (product1 != null)
            productDao.update(id, product);
        else
            message = "There is no product for given id.";
            //throw new WebApplicationException("There is no product for given id.", Response.Status.NOT_FOUND);
        return message;
    }

    @GET
    @Path("/{id}")
    public Response getProduct(@PathParam("id") int id) {
        Product product = productDao.findById(id);

        if (product == null)
            throw new WebApplicationException("Product does not exist", Response.Status.NOT_FOUND);

        return Response.ok(product).build();
    }

    @DELETE
    @Path("/{id}")
    public String deleteProduct(@PathParam("id") int id) {
        Product product = productDao.findById(id);
        String message = "Product deleted";
        if (product != null)
            productDao.deleteById(id);
        else
            message = "Product not found";

        return message;
    }
}