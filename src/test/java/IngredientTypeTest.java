import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import praktikum.IngredientType;

// Тесты типов ингредиента (перечисление IngredientType)
@RunWith(JUnitParamsRunner.class)
public class IngredientTypeTest {

    // Проверяем, что количество типов ингредиентов = 2
    @Test
    public void checkIngredientTypeLenght() {
        int actual = IngredientType.values().length;
        int expected = 2;
        Assert.assertEquals("The amount of ingredients should be equal to: " + expected, expected, actual);
    }

    // Проверяем, что все типы ингредиентов из параметров присутствуют в перечислении IngredientType.
    // В противном случае ловим исключение IllegalArgumentException.
    @Test
    @Parameters({"SAUCE", "FILLING"})
    public void checkIngredientType_hasAllTypes (String type) throws Exception {
        IllegalArgumentException exception = null;
        try {
            IngredientType ingredientType = IngredientType.valueOf(type);
        } catch (IllegalArgumentException ex) {
            exception = ex;
        }
        Assert.assertNull("There is no enum constant \"" + type + "\" in the IngredientType.", exception);
    }
}
