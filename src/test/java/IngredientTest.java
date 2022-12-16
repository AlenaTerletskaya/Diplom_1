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
import praktikum.Ingredient;
import praktikum.IngredientType;

// Тесты модели ингредиента (класс Ingredient)
public class IngredientTest {

    @Rule public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    Ingredient mockIngredient;

    // Проверяем, что метод getName() вызван 1 раз.
    @Test
    public void checkIngredientGetName_calledOnce() {
        mockIngredient.getName();
        Mockito.verify(mockIngredient).getName();
    }

    // Проверяем, что метод getPrice() вызван 1 раз.
    @Test
    public void checkIngredientGetPrice_calledOnce() {
        mockIngredient.getPrice();
        Mockito.verify(mockIngredient).getPrice();
    }

    // Проверяем, что метод getType() вызван 1 раз.
    @Test
    public void checkIngredientGetType_calledOnce() {
        mockIngredient.getType();
        Mockito.verify(mockIngredient).getType();
    }
}
