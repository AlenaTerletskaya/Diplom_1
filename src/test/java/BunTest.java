import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import praktikum.Bun;

// Тесты модели булочки для бургера (класс Bun)
@RunWith(JUnitParamsRunner.class)
public class BunTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    Bun mockBun;

    // Проверяем, что метод getName() вызван 1 раз.
    @Test
    public void checkBunGetName_calledOnce() {
        mockBun.getName();
        Mockito.verify(mockBun).getName();
    }

    // Проверяем, что метод getPrice() вызван 1 раз.
    @Test
    public void checkBunGetPrice_calledOnce() {
        mockBun.getPrice();
        Mockito.verify(mockBun).getPrice();
    }

    // Проверяем, что можно создать экземпляр булочки, передав параметры: имя и цену.
    // Экземпляр булочки не равен null.
    // Имя и цена созданного экземпляра булочки соответствуют переданным параметрам.
    @Test
    @Parameters ({
            "black bun, 100",
            "w, 0.01",
            "redredredredredredredred bunbunbunbunbunbunbun, 100000",
            ", 0.00"
    })
    public void checkBunCreate_expectBunNotNull_hasNameAndPrice (String name, float price) {
        Bun bun = new Bun(name, price);
        Assert.assertNotNull("Bun should not be null", bun);
        Assert.assertEquals("Name should be equal to: " + name, name, bun.getName());
        Assert.assertEquals("Price should be equal to: " + price, price, bun.getPrice(), 0.001);
    }

}
