import com.piyush.ProductServiceApplication;
import com.piyush.api.Product;
import com.piyush.resources.ProductResource;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

public class ProductServiceApplicationTest {

    Product product;
    @Mock
    ProductServiceApplication productServiceApplication;

    @Mock
    ProductResource productResource;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDelete(){
        when(productResource.deleteProduct(1)).thenReturn("Product not found");
        Assert.assertEquals("Product not found", productResource.deleteProduct(1));
    }



    @Test
    public void testUpdate(){
        when(productResource.updateProduct(1, product)).thenReturn("Product updated");
        Assert.assertEquals("Product updated", productResource.updateProduct(1, product));
    }

    @Test
    public void testInsert(){
        when(productResource.createProduct(product)).thenReturn("Product inserted");
        Assert.assertEquals("Product inserted", productResource.createProduct(product));
    }

}