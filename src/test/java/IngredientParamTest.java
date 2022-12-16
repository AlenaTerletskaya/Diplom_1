import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

// Параметризованный тест модели ингредиента (класс Ingredient)
@RunWith(Parameterized.class)
public class IngredientParamTest {

    private final IngredientType type;
    private final String name;
    private final float price;

    // Конструктор с параметрами
    public IngredientParamTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    // Метод для получения данных
    @Parameterized.Parameters(name = "Тестовые данные - тип:  {0}, имя: {1}, цена: {2}")
    public static Object[][] getTestData() {
        return new Object[][] {
                {IngredientType.SAUCE, "hot sauce", 200.3f},
                {IngredientType.FILLING, "cutlet", 0.01f},
                {IngredientType.SAUCE, "soursoursoursoursoursour creamcreamcreamcreamcreamcream", 100000f},
                {IngredientType.FILLING, "", 0f}
        };
    }

    // Проверяем, что можно создать экземпляр ингредиента, передав параметры: тип, имя и цену.
    // Экземпляр ингредиента не равен null.
    // Тип, имя и цена созданного экземпляра ингредиента соответствуют переданным параметрам.
    @Test
    public void checkIngrCreate_expectIngrNotNull_hasTypeNamePrice () {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertNotNull("The ingredient should not be null", ingredient);
        Assert.assertEquals("The type should be equal to: " + type, type, ingredient.getType());
        Assert.assertEquals("The name should be equal to: " + name, name, ingredient.getName());
        Assert.assertEquals("The price should be equal to: " + price, price, ingredient.getPrice(), 0.001);
    }
}
